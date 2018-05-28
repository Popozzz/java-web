package dao;



import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.etspace.abc.vo.OrderDetails;
import org.etspace.abc.vo.OrderProduct;
import org.etspace.abc.vo.OrderProductId;
import org.etspace.abc.vo.OrderView;
import org.etspace.abc.vo.OrderViewId;
import org.etspace.abc.vo.Product;
import org.etspace.abc.vo.SumView;
import org.etspace.abc.vo.SumViewId;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import db.DBManager;
import random.OrderID;

public class OrderDao implements IOrderDao{
	
	Session mySession;
	DBManager db = new DBManager();
	boolean flag;
	
	//查找自己的全部订单
	public List<OrderView> getAllPersonOrder(String id)
	{
		mySession = db.getSession();
		Query query = mySession.createQuery("from OrderView where customer_id=?");
		query.setString(0, id);
		List<OrderView> list = db.query(query);
		
		db.closeSession();
		return list;
		
	}
	
	//查找分类订单
	public List<OrderView> getTypePersonOrder(String id,Short type)
	{
		mySession = db.getSession();
		Query query = mySession.createQuery("from OrderView where customer_id=? and order_state=?");
		query.setString(0, id);
		query.setShort(1, type);
		List<OrderView> list = db.query(query);
		
		db.closeSession();
		return list;
	}
	
	//添加订单
	public boolean addOrder(List<OrderViewId> o)
	{

		//String t = new OrderID().getOrderID();

		OrderDetails od = new OrderDetails();
		od.setOrderId(o.get(0).getOrderId());//后台生成ID
		
		od.setCustomerId(o.get(0).getCustomerId());//客户ID
		
		String address = new AddressDao().getOneAddress(o.get(0).getCustomerId(), o.get(0).getAddressId()).getCustomerAddress();
		od.setOrderAddress(address);

		od.setOrderTotalAmount(Double.valueOf(0));
		od.setOrderState(o.get(0).getOrderState());
		
		Date u = new Date();
		Timestamp date = new Timestamp(u.getTime());
		od.setOrderDate(date);//后台生成时间
		
		od.setAddressId(o.get(0).getAddressId());
		Double amount = (double) 0;
		//保存订单详情
		flag = new OrderDetailDao().addOrderDetail(od);

		if(flag == true)
		{
			

			for(int i=0;i<o.size();i++)
			{
				Product p = new Product();
				OrderProduct op = new OrderProduct();
				OrderProductId k = new OrderProductId();
				p = new ProductDao().getProduct(o.get(i).getProductId());
				k.setOrderDetails(od);
				k.setProductId(o.get(i).getProductId());
				op.setId(k);
				op.setProductImg(p.getProductImg());
				op.setProductName(p.getProductName());
				op.setProductNumber(o.get(i).getProductNumber());
				op.setProductPrice(p.getProductPrice());
				amount = amount + p.getProductPrice()*o.get(i).getProductNumber();
				if(o.get(i).getOrderState()==1)
				{
					flag = new ProductDao().buyProduct(p, o.get(i).getProductNumber());
				}
				if(flag==false)
				{
					new ProductDao().deleteProduct(o.get(0).getOrderId());
					new OrderDetailDao().deleteOrderDetails(o.get(0).getOrderId());
					return false;
				}
				flag = new OrderProductDao().addOrderProduct(op);
			}
		}
		mySession = db.getSession();
		Query query = mySession.createQuery("update OrderDetails set order_totalAmount=? where order_id=?");
		query.setDouble(0, amount);
		query.setString(1, o.get(0).getOrderId());
		flag = db.update(query, mySession);
		
		
		db.closeSession();
		if(flag==false)
		{
			System.out.println("添加订单到数据库失败！");
			return false;
		}
		System.out.println("添加订单成功！");
		return true;
		
		
	}
	
	//生成预订单
	public OrderDetails produceList(List<OrderViewId> l)
	{
		OrderDetails order = new OrderDetails();
		Double amount = (double) 0;
		Set<OrderProduct> q = new HashSet(); 
		
		String t = new OrderID().getOrderID();
		order.setOrderId(t);//后台生成ID
		if(l.size()>0)
		{
			order.setCustomerId(l.get(0).getCustomerId());
			
			
			for(int i=0;i<l.size();i++)
			{
				Product p = new Product();
				OrderProductId k = new OrderProductId();
				p = new ProductDao().getProduct(l.get(i).getProductId());
				OrderProduct op = new OrderProduct();
				
				k.setOrderDetails(order);
				k.setProductId(l.get(i).getProductId());
				op.setId(k);
				op.setProductImg(p.getProductImg());
				op.setProductName(p.getProductName());
				op.setProductPrice(p.getProductPrice());
				op.setProductNumber(l.get(i).getProductNumber());
				amount = amount + p.getProductPrice()*l.get(i).getProductNumber();
				q.add(op);
				
			}
			order.setOrderTotalAmount(amount);
			order.setOrderProducts(q);
			
			return order;
		}
		return null;
		
	}
	
	
	//查找全部订单
	
	public List<OrderView> getAllOrder()
	{
		mySession = db.getSession();
		Query query = mySession.createQuery("from OrderView");
		
		List<OrderView> list = db.query(query);
		db.closeSession();
		return list;
	}
	
	//查找一类型的全部订单
	public List<OrderView> getAllTypeOrder(short type)
	{
		mySession = db.getSession();
		Query query = mySession.createQuery("from OrderView where order_state=?");
		query.setShort(0, type);
		
		List<OrderView> list = db.query(query);
		
		db.closeSession();
		return list;
	}
	
	public boolean deleteOrder(String oid)
	{
		flag = new OrderProductDao().deleteOrderProduct(oid);
		if(flag==false)
		{
			return false;
		}
		flag = new OrderDetailDao().deleteOrderDetails(oid);
		return flag;
	}
	
	//结算，按产品结算月销量
	public List<SumViewId> getSettleAccounts(String start,String end)
	{
		mySession = db.getSession();
		start = start+" 00:00:00";//开始日期
		end = end+" 23:59:59";//截止日期
		Query query = mySession.createSQLQuery("select product_id,product_name,product_price,sum(product_number)as product_number,sum(product_totalAmount)as order_totalAmount,order_date"
				+ " from sum_view where order_date between ? and ?  group by product_id");
		query.setTimestamp(0, Timestamp.valueOf(start));//
		query.setTimestamp(1,Timestamp.valueOf(end));
		List sum =db.query(query);
		List<SumViewId> list = new ArrayList<SumViewId>();
		if(sum.size()<=0)
		{
			System.out.println("该日期范围没有产品销售！");
		}
		else
		{
			for(int i=0;i<sum.size();i++)
			{

				SumViewId s = new SumViewId();

				Object[] obj = (Object[])sum.get(i);
				
				/*System.out.println(obj[0].toString());
				System.out.println(obj[1].toString());
				System.out.println(obj[2].toString());
				System.out.println(obj[3].toString());
				System.out.println(obj[4].toString());
				System.out.println(obj[5]);*/
				s.setProductId(obj[0].toString());
				s.setProductName(obj[1].toString());
				s.setProductPrice(Double.valueOf(obj[2].toString()));
				s.setProductNumber(Integer.valueOf(obj[3].toString()));
				s.setProductTotalAmount(Double.valueOf(obj[4].toString()));
				list.add(s);
					
			}
		}
		
		return list;
	
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*测试添加订单
		OrderDao od = new OrderDao();
		List<OrderViewId> list = new ArrayList<OrderViewId>();
		Short x = 1;
		for(int i=0;i<3;i++)
		{
			OrderViewId l = new OrderViewId();
			l.setCustomerId("h1jk2b2ozd8A");
			l.setOrderState(Short.valueOf("6"));
			l.setOrderTotalAmount(Double.valueOf("199"));
			l.setAddressId(x);
			//l.setProductId("2qUM6Ek5yDEO");
			l.setProductNumber(i);
			list.add(l);
		}
		
		list.get(0).setProductId("2qUM6Ek5yDEO");
		list.get(1).setProductId("0MxKY22e2cUr");
		list.get(2).setProductId("G9diIL3FF7JW");
		
		for(int i=0;i<3;i++)
		{
			System.out.println(list.get(i).getProductId());
			System.out.println(list.get(i).getProductNumber());
		}
		System.out.println(list.size());
		od.addOrder(list);*/
		
		
		/*测试查找客户个人的全部订单
	 	OrderDao od = new OrderDao();
		String id = "h1jk2b2ozd8A";
		List<OrderView> list = od.getAllPersonOrder(id);
		System.out.println(list.size());
		System.out.println(list.get(0).getId().getProductId());
		System.out.println(list.get(1).getId().getProductId());
		System.out.println(list.get(2).getId().getProductId());
		System.out.println(list.get(3).getId().getProductId());
		System.out.println(list.get(4).getId().getProductId());
		System.out.println(list.get(5).getId().getProductId());
		OrderView d = new OrderView();*/
		
		/*测试查找客户个人分类订单
		OrderDao od = new OrderDao();
		String id = "h1jk2b2ozd8A";
		Short state = 6;
		List<OrderView> list = od.getTypePersonOrder(id, state);
		System.out.println(list.size());
		System.out.println(list.get(0).getId().getProductId());
		System.out.println(list.get(1).getId().getProductId());
		System.out.println(list.get(2).getId().getProductId());
		System.out.println(list.get(3).getId().getProductId());
		System.out.println(list.get(4).getId().getProductId());
		System.out.println(list.get(5).getId().getProductId());*/
		
		/*测试查找全部订单
		OrderDao od = new OrderDao();
		List<OrderView> list = od.getAllOrder();
		System.out.println(list.size());
		System.out.println(list.get(0).getId().getProductId());
		System.out.println(list.get(1).getId().getProductId());
		System.out.println(list.get(2).getId().getProductId());
		System.out.println(list.get(3).getId().getProductId());
		System.out.println(list.get(4).getId().getProductId());*/
		
		/*
		OrderDao od = new OrderDao();
		List<OrderView> list = od.getAllTypeOrder(Short.valueOf("6"));
		System.out.println(list.size());
		System.out.println(list.get(0).getId().getProductId());
		System.out.println(list.get(1).getId().getProductId());
		System.out.println(list.get(2).getId().getProductId());
		System.out.println(list.get(3).getId().getProductId());
		System.out.println(list.get(4).getId().getProductId());*/
		
		
		OrderDao od = new OrderDao();
		String start = "2017-11-01";
		String end = "2017-11-01";
		od.getSettleAccounts(start, end);	
		
	}

}

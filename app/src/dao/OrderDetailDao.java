package dao;




import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.etspace.abc.vo.Customer;
import org.etspace.abc.vo.OrderDetails;
import org.etspace.abc.vo.OrderProduct;
import org.etspace.abc.vo.Product;
import org.hibernate.Query;
import org.hibernate.Session;

import db.DBManager;
import net.sf.json.JSONArray;

public class OrderDetailDao implements IOrderDetailDao
{
	
	Session mySession;
	DBManager db = new DBManager();
	boolean flag;

	//��Ӷ���
	public boolean addOrderDetail(OrderDetails od)
	{
		
		mySession = db.getSession();
		flag = db.save(od,mySession);
		db.closeSession();
		if(flag==false)
		{
			System.out.println("��Ӷ������鵽���ݿ�ʧ�ܣ�");
			return false;
		}
		System.out.println("��Ӷ�������ɹ���");
		return true;
		
	}
	
	//���¶���״̬
	public boolean updateOrderDetailsState(String id,Short x)
	{
		mySession = db.getSession();
		Query query = mySession.createQuery("update OrderDetails set order_state=? where order_id=?");
		query.setShort(0, x);
		query.setString(1, id);
		flag = db.update(query, mySession);
		
		db.closeSession();
		
		if(flag==false)
		{
			System.out.println("���¶���״̬�����ݿ�ʧ�ܣ�");
			return false;
		}
		if(x==1)
		{
			query = mySession.createQuery("from OrderDetails where order_id=?");
			query.setString(0, id);
			List<OrderDetails> list = db.query(query);
			Product p = new Product();
			if(list.size()>0)
			{
				Iterator j = list.get(0).getOrderProducts().iterator();
				JSONArray array = new JSONArray();
				for(Iterator iter = j; iter.hasNext();)
				{

					OrderProduct str = (OrderProduct)iter.next();
					p = new ProductDao().getProduct(str.getId().getProductId());
					new ProductDao().buyProduct(p,str.getProductNumber());			
				}
			}
		}
		System.out.println("���¶���״̬�����ݿ�ɹ���");
		return true;
	}
	
	//�޸Ŀͻ�����
	public boolean changeOrderDetails(String id,Short x)
	{
		mySession = db.getSession();
		Query query = mySession.createQuery("update OrderDetails set address_id=? where order_id=?");
		query.setShort(0, x);
		query.setString(1, id);
		flag = db.update(query, mySession);
		db.closeSession();
		if(flag==false)
		{
			System.out.println("�޸Ķ��������ݿ�ʧ�ܣ�");
			return false;
		}
		System.out.println("�޸Ķ��������ݿ�ɹ���");
		return true;
				
	}
	
	//���ҿͻ������ж������飨�ͻ��ˣ�
	public List<OrderDetails> getPersonOrderDetails(String cid)
	{
		mySession = db.getSession();
		Query query = mySession.createQuery("from OrderDetails where customer_id=? order by order_date DESC");
		query.setString(0, cid);
		List<OrderDetails> list = db.query(query);
		//db.closeSession();
		return list;
	}
	
	//�鿴�ͻ����ඩ��
	public List<OrderDetails> getPersonTypeOrderDetails(String cid,Short x)
	{
		mySession = db.getSession();
		Query query = mySession.createQuery("from OrderDetails where customer_id=? and order_state=? order by order_date DESC");
		query.setString(0, cid);
		query.setShort(1, x);
		List<OrderDetails> list = db.query(query);
		
		//db.closeSession();
		return list;
	}
	
	//�鿴���ж���(�����)
	public List<OrderDetails> getAllOrderDetails()
	{
		mySession = db.getSession();
		Query query = mySession.createQuery("from OrderDetails order by order_date DESC");
		List<OrderDetails> list = db.query(query);
		
		//db.closeSession();
		return list;
	}
	
	//�鿴��״̬�����ж���
	public List<OrderDetails> getAllTypeOrderDetails(Short x)
	{
		mySession = db.getSession();
		Query query = mySession.createQuery("from OrderDetails where order_state=? order by order_date DESC");
		query.setShort(0, x);
		List<OrderDetails> list = db.query(query);
		
		//db.closeSession();
		return list;
	}
	
	//���ҿͻ�����������ˣ������ֻ���
	public List<OrderDetails> getCustomerOrderDetails(String phone)
	{
		Customer c = new UserDao().getUser(phone);
		if(c==null)
		{
			System.out.println("���û�������!");
			return null;
		}
		String id = c.getCustomerId();
		mySession = db.getSession();
		
		Query query = mySession.createQuery("from OrderDetails where customer_id=? order by order_date DESC");//һ��Ҫ�����������ֻ���
		query.setString(0, id);
		List<OrderDetails> list = db.query(query);

		db.closeSession();
		return list;
	}
	
	public boolean deleteOrderDetails(String oid)
	{
		mySession = db.getSession();
		Query query = mySession.createQuery("delete OrderDetails where order_id=?");
		query.setString(0, oid);
		flag = db.update(query, mySession);
		return flag;
	}
	
	public static void main(String[] args) {
	
		/*���Բ鿴���ж���
		OrderDetailDao od = new OrderDetailDao();
		List<OrderDetails> list = od.getAllOrderDetails();
		System.out.println(list.size());
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getOrderId());
		}*/
		
		//�������ֻ��鿴��Ӧ�ͻ��Ķ���
		/*OrderDetailDao od = new OrderDetailDao();
		od.getCustomerOrderDetails("1342835871");
		
		System.out.println(list.size());
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getCustomerId());
			//System.out.println(list.get(i).getOrderProducts().size());
		}*/
		
		//�����ÿͻ�ID�鿴�û�����
		/*
		OrderDetailDao od = new OrderDetailDao();
		List<OrderDetails> list = od.getPersonOrderDetails("h1jk2b2ozd8A");
		System.out.println(list.size());
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getOrderProducts().size());
		}
		Iterator j = list.get(1).getOrderProducts().iterator();
		 for (Iterator iter = j; iter.hasNext();) 
		 {
			  OrderProduct str = (OrderProduct)iter.next();
			  System.out.println(str.getProductNumber());
			 }*/
		//Set<OrderProduct> p = list.get(1).getOrderProducts();
		//System.out.println(p.toString());
		/*�����޸Ķ���
		OrderDetailDao od = new OrderDetailDao();
		Short l = 7;
		String id = "uU87nfZ8DyComlwX";
		od.changeOrderDetails(id, l);*/
		

		

				
		
	}
	


}

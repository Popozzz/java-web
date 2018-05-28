package dao;

import java.util.List;

import org.etspace.abc.vo.Cart;
import org.etspace.abc.vo.Customer;
import org.etspace.abc.vo.OrderViewId;
import org.etspace.abc.vo.Product;
import org.etspace.abc.vo.Shoppingcart;
import org.etspace.abc.vo.ShoppingcartId;
import org.hibernate.Query;
import org.hibernate.Session;

import db.DBManager;

public class ShoppingCartDao implements IShoppingCartDao{
	
	Session mySession;
	DBManager db = new DBManager();
	boolean flag;
	
	//��ӵ����ﳵ
	public Shoppingcart addProductToCart(String cid,String pid,int number)
	{
		mySession = db.getSession();
		//���ݿ����
		Query query = mySession.createQuery("from Shoppingcart where product_id=?");
		query.setString(0, pid);
		List<Shoppingcart> l = db.query(query);
		if(l.size()>0)//�ò�Ʒ�Ѿ����ڹ��ﳵ
		{
			if((l.get(0).getProductNumber()+number)==0)//
			{
				query = mySession.createQuery("delete Shoppingcart where customer_id=? and product_id=?");
				query.setString(0, cid);
				query.setString(1, pid);
				db.update(query, mySession);
				l.get(0).setProductNumber(l.get(0).getProductNumber()+number);
				return l.get(0); 
			}
			query = mySession.createQuery("update Shoppingcart set product_number=product_number+? where customer_id=? and product_id=?");
			query.setInteger(0, number);
			query.setString(1, cid);
			query.setString(2, pid);
			db.update(query, mySession);
			l.get(0).setProductNumber(l.get(0).getProductNumber()+number);
			return l.get(0);
			
		}
		
		query = mySession.createQuery("from Product where product_id=?");
		query.setString(0, pid);
		List<Product> list = db.query(query);
		Customer c = new Customer();
		ShoppingcartId i = new ShoppingcartId();
		Shoppingcart s = new Shoppingcart();
		flag = false;
		if(list.size()>0)
		{

			c.setCustomerId(cid);
			i.setProduct(list.get(0));
			i.setCustomer(c);	
			s.setId(i);
			s.setProductImg(list.get(0).getProductImg());
			s.setProductName(list.get(0).getProductName());
			s.setProductNumber(number);
			s.setProductPrice(list.get(0).getProductPrice());
			flag = db.save(s,mySession);
		}

		db.closeSession();
		if(flag == false)
		{
			System.out.println("��ӹ��ﳵ�����ݿ�ʧ�ܣ�");
			return null;
		}
		System.out.println("��ӹ��ﳵ�����ݿ�ɹ���");
		return s;
		
	}
	
	public boolean updateShoppingCart(List<Cart> cart)
	{
		mySession = db.getSession();
		Query query = mySession.createQuery("update Shoppingcart set product_number=? where customer_id=? and product_id=?");
		if(cart.size()<=0)
		{
			return false;
		}
		for(int i=0;i<cart.size();i++)
		{

			query.setInteger(0, cart.get(i).getProductNumber());
			query.setString(1, cart.get(i).getCustomerId());
			query.setString(2, cart.get(i).getProoductId());
			flag = db.update(query, mySession);
		}
		return flag;
	}
	
	//ɾ�����ﳵ��Ʒ
	public boolean deleteProductToCart(String cid,String pid)
	{
		
		mySession = db.getSession();
		Query query = mySession.createQuery("delete Shoppingcart where customer_id=? and product_id=?");
		query.setString(0, cid);
		query.setString(1, pid);
		flag = db.update(query,mySession);
		db.closeSession();
		if(flag == false)
		{
			System.out.println("�����ݿ�ɾ�����ﳵ��Ʒʧ�ܣ�");
			return false;
		}
		System.out.println("�����ݿ�ɾ�����ﳵ��Ʒ�ɹ�");
		return true;
		
		
	}
	
	//���㹺�ﳵ,���ɶ���
	public boolean buyProductToCart(List<OrderViewId> o)
	{
		
		new OrderDao().addOrder(o);
		
		return true;
		
		
		
	}
	
	//��ø��˹��ﳵ
	public List<Shoppingcart> getProductToCart(String id)
	{
		
		mySession = db.getSession();
		//���ݿ����
		Query query = mySession.createQuery("from Shoppingcart where customer_id=?");
		query.setString(0, id);
		List<Shoppingcart> list = db.query(query);
				
		db.closeSession();
		return list;
		
	}
	
	
	public static void main(String[] args) {
		
		/*
		ShoppingCartDao sc = new ShoppingCartDao();
		Shoppingcart s = new Shoppingcart();
		ShoppingcartId id = new ShoppingcartId();
		Customer p = new Customer();
		p.setCustomerId("h1jk2b2ozd8A");
		Product q = new Product();
		q.setProductId("0MxKY22e2cUr");
		id.setCustomer(p);
		id.setProduct(q);
		s.setId(id);
		s.setProductImg("meme");
		s.setProductName("ok");
		s.setProductNumber(17);
		sc.addProductToCart(s);*/
		ShoppingCartDao sc = new ShoppingCartDao();
		String id = "h1jk2b2ozd8A";
		List<Shoppingcart> list = sc.getProductToCart(id);
		System.out.println(list.size());
		
		
	}


}

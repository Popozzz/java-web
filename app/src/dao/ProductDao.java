package dao;

import java.util.ArrayList;
import java.util.List;

import org.etspace.abc.vo.Product;
import org.hibernate.Query;
import org.hibernate.Session;

import db.DBManager;


public class ProductDao implements IProductDao{
	
	Session mySession;
	DBManager db = new DBManager();
	boolean flag;
	
	//��Ӳ�Ʒ
	public boolean addProduct(Product p)
	{
		mySession = db.getSession();
		flag = db.save(p,mySession);//���浽���ݿ�
		db.closeSession();
		if(flag == false)
		{
			System.out.println("��Ӳ�Ʒ�����ݿ�ʧ�ܣ�");
			return false;
		}
		System.out.println("��Ӳ�Ʒ�ɹ���");
		return true;		
	}
	
	//�޸Ĳ�Ʒ
	public boolean changeProduct(String description,double price,int storage,String parameter,String id)
	{
		mySession = db.getSession();
		System.out.println("�޸���....");
		
		Query query = mySession.createQuery("update Product set product_description=?,product_price=?,product_storage=?,product_parameter=? where product_id=?");
		query.setString(0, description);
		query.setDouble(1, price);
		query.setInteger(2, storage);
		query.setString(3, parameter);
		query.setString(4, id);
		flag = db.update(query, mySession);
		if(flag==true)
		{
			System.out.println("�޸Ĳ�Ʒ�ɹ���");
		}
		else
		{
			System.out.println("�޸Ĳ�Ʒʧ�ܣ�");
		}
		
		return flag;
	}
	
	//ɾ����Ʒ
	public boolean deleteProduct(String id)
	{
		mySession = db.getSession();
		System.out.println("id="+id);
		Query query = mySession.createQuery("delete Shoppingcart where product_id=?");
		query.setString(0, id);
		flag = db.update(query,mySession);
		
		query = mySession.createQuery("delete Product where product_id=?");
		query.setString(0, id);
		flag = db.update(query,mySession);
		db.closeSession();
		if(flag == false)
		{
			System.out.println("�����ݿ�ɾ����Ʒʧ�ܣ�");
			return false;
		}
		System.out.println("ɾ����Ʒ�ɹ���");
		return true;
		
	}
	
	//�ؼ���������Ʒ
	public List<Product> findKeyProduct(String keyWord)
	{
		mySession = db.getSession();
		//���ݿ���Ҳ�Ʒ
		Query query = mySession.createQuery("from Product where product_name like ? order by product_name");//ģ����ѯ
		keyWord = "%" + keyWord +"%";
		query.setString(0, keyWord);
		List<Product> list = db.query(query);
		System.out.println(list.size());
		System.out.println("��ȡ�ؼ��ֲ�Ʒ�ɹ�");
		db.closeSession();
		return list;
		
	}
	
	//����������Ʒ
	public List<Product> findTypeProduct(Short type) 
	{
		mySession = db.getSession();
		//���ݿ���Ҳ�Ʒ
		Query query = mySession.createQuery("from Product where product_type=?");
		query.setShort(0, type);
		List<Product> list = db.query(query);
		
		db.closeSession();
		return list;
	}
	
	//�����Ʒ����Ʒ���������仯
	public boolean buyProduct(Product p,int number) 
	{
		
		mySession = db.getSession();
		Query query = mySession.createQuery("update Product set product_storage=?,product_sell=? where product_id=?");
		query.setInteger(0,p.getProductStorage()-number );
		query.setInteger(1, p.getProductSell()+number);
		query.setString(2, p.getProductId());
		flag = db.update(query, mySession);
		db.closeSession();
		if(flag == false)
		{
			System.out.println("��Ʒ�����������ʧ�ܣ�");
			return false;
		}
		System.out.println("��Ʒ����������³ɹ���");
		return true;

	}
	
	//�鿴���в�Ʒ
	public List<Product> getAllProduct()
	{
		mySession = db.getSession();

		//���ݿ���Ҳ�Ʒ
		Query query = mySession.createQuery("from Product order by product_type,product_name");
		List<Product> list = db.query(query);
		System.out.println("��ȡ���в�Ʒ�ɹ���");
		db.closeSession();
		return list;
	}
	
	//�鿴������Ʒ
	public Product getProduct(String id)
	{
		mySession = db.getSession();
		//���ݿ���Ҳ�Ʒ
		Query query = mySession.createQuery("from Product where product_id=?");
		query.setString(0, id);
		List<Product> list = db.query(query);
		System.out.println(list.size());
		db.closeSession();
		Product p = list.get(0);
		System.out.println(p.getProductId());
		return p;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		ProductDao p = new ProductDao();
		List<Product> list = p.getAllProduct();
		System.out.println(list.get(0).getProductDescription());*/
		
		/*ģ����ѯ
		ProductDao p = new ProductDao();
		String key = "i";
		List<Product> list = p.findKeyProduct(key);
		System.out.println(list.get(0).getProductName());*/
		
		/*�������Ͳ�Ʒ
		ProductDao p = new ProductDao();
		int i = 1;
		List<Product> list = p.findTypeProduct(i);
		System.out.println(list.get(0).getProductName());*/
		/*�õ�������Ʒ
		ProductDao p = new ProductDao();
		String id = "0MxKY22e2cUr";
		Product q = p.getProduct(id);
		System.out.println(q.getProductId());*/
		ProductDao p = new ProductDao();
		List<Product> list = p.getAllProduct();
		System.out.println(list.size());
		System.out.println(list.get(0).getProductDescription());
		
		
	}

}

package dao;

import java.util.List;

import org.etspace.abc.vo.Customer;
import org.hibernate.Query;
import org.hibernate.Session;

import db.DBManager;
import random.UserID;



public class UserDao implements IUserDao{
	
	Session mySession;
	DBManager db = new DBManager();
	boolean flag;
	
	//����û��Ƿ���ڣ��ֻ��ţ�
	public boolean existUser(String phone)
	{
		mySession = db.getSession();
		//������ֻ����Ƿ����
		Query query = mySession.createQuery("from Customer where customer_phone=?");
		query.setString(0, phone);
		List list = db.query(query);
		
		db.closeSession();
		//�ֻ��Ŵ����򷵻���
		if(list.size() > 0)
		{
			System.out.println("���û��Ѵ��ڣ�");
			return true;
		}
		else 
			return false;
		
	}
	
	//����û�==ע��
	public boolean addUser(Customer c) 
	{	
		mySession = db.getSession();
		UserID id = new UserID();
		c.setCustomerId(id.getUserID());
		c.setCustomerSum(Short.valueOf("0"));
		//�ֻ��Ŵ��������ʧ��
		if(existUser(c.getCustomerPhone()))
		{
			System.out.println("����û�ʧ�ܣ����û��Ѵ��ڣ�");
			db.closeSession();
			return false;
		}
		mySession = db.getSession();
		flag = db.save(c,mySession);
		db.closeSession();
		if(flag==false)
		{
			System.out.println("����û������ݿ�ʧ�ܣ�");
			return false;
		}
		System.out.println("����û��ɹ���");
		return true;
	}
	
		
	//��֤�û�
	public boolean findUser(String phone,String password) 	
	{
		Query query = db.getSession().createQuery("from Customer where customer_phone=? and customer_password=?");
		query.setString(0, phone);
		query.setString(1, password);
		List list = db.query(query);
		db.closeSession();
		if(list.size()==0)//����ʧ��
		{
			System.out.println("�û������ڣ���¼ʧ�ܣ�");
			
			return false;
		}
		System.out.println("�û����ڣ���¼�ɹ���");
		return true;
	}
	
	//�޸��û��ֻ�
	public boolean changeUserPhone(Customer c,String phone)
	{
		if(existUser(phone))//���ֻ����Ƿ����
		{
			return false;
		}
		else
		{
			mySession = db.getSession();
			Query query = mySession.createQuery("update Customer set customer_phone=? where customer_phone=?");
			query.setString(0, phone);
			query.setString(1, c.getCustomerPhone());
			flag = db.update(query, mySession);
			db.closeSession();
			if(flag == false)
			{
				System.out.println("�޸��ֻ��ŵ����ݿ�ʧ�ܣ�");
				return false;
			}
			System.out.println("�޸��ֻ��ųɹ���");
			return true;
		}
		
	}
	
	//�޸��û�����
	public boolean changeUserPass(String phone,String password)
	{
		
		mySession = db.getSession();
		Query query = mySession.createQuery("update Customer set customer_password=? where customer_phone=?");
		query.setString(0, password);
		query.setString(1, phone);
		flag = db.update(query, mySession);
		db.closeSession();
		if(flag == false)
		{
			System.out.println("�޸����뵽���ݿ�ʧ�ܣ�");
			return false;
		}
		System.out.println("�޸�����ɹ���");
		return true;
		
	}
	
	//�õ��û�
	public Customer getUser(String phone)
	{
		Customer c;
		mySession = db.getSession();
		
		Query query = mySession.createQuery("from Customer where customer_phone=?");
		query.setString(0, phone);
		List list = db.query(query);
		db.closeSession();
		if(list.size()<=0)
		{
			return null;
		}
		c = (Customer)list.get(0);
		return c;
	}
	
	
	//ɾ���û�
	public boolean deleteUser(String phone) 
	{
		mySession = db.getSession();
		Query query = mySession.createQuery("delete Customer where customer_phone=?");
		query.setString(0, phone);
		flag = db.update(query,mySession);
		db.closeSession();
		if(flag == false)
		{
			System.out.println("�����ݿ�ɾ���û�ʧ�ܣ�");
			return false;
		}
		System.out.println("ɾ���û��ɹ���");
		return true;
		
	}
	
	public List<Customer> getAllUser()
	{
		mySession = db.getSession();
		Query query = mySession.createQuery("from Customer");

		List<Customer> list= db.query(query);
		db.closeSession();
		return list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserDao user = new UserDao();
		Customer c = new Customer();
		c.setCustomerPhone("15322327009");
		c.setCustomerPassword("dwedf4984");
		user.addUser(c);
		c = user.getUser("15322327009");
		user.changeUserPhone(c, "13428358712");
		System.out.println(user.getUser("15322327009").getCustomerPhone());
		
	}
	


}

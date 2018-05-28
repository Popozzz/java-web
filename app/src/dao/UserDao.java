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
	
	//检查用户是否存在（手机号）
	public boolean existUser(String phone)
	{
		mySession = db.getSession();
		//检验该手机号是否存在
		Query query = mySession.createQuery("from Customer where customer_phone=?");
		query.setString(0, phone);
		List list = db.query(query);
		
		db.closeSession();
		//手机号存在则返回真
		if(list.size() > 0)
		{
			System.out.println("该用户已存在！");
			return true;
		}
		else 
			return false;
		
	}
	
	//添加用户==注册
	public boolean addUser(Customer c) 
	{	
		mySession = db.getSession();
		UserID id = new UserID();
		c.setCustomerId(id.getUserID());
		c.setCustomerSum(Short.valueOf("0"));
		//手机号存在则添加失败
		if(existUser(c.getCustomerPhone()))
		{
			System.out.println("添加用户失败！该用户已存在！");
			db.closeSession();
			return false;
		}
		mySession = db.getSession();
		flag = db.save(c,mySession);
		db.closeSession();
		if(flag==false)
		{
			System.out.println("添加用户到数据库失败！");
			return false;
		}
		System.out.println("添加用户成功！");
		return true;
	}
	
		
	//验证用户
	public boolean findUser(String phone,String password) 	
	{
		Query query = db.getSession().createQuery("from Customer where customer_phone=? and customer_password=?");
		query.setString(0, phone);
		query.setString(1, password);
		List list = db.query(query);
		db.closeSession();
		if(list.size()==0)//查找失败
		{
			System.out.println("用户不存在，登录失败！");
			
			return false;
		}
		System.out.println("用户存在，登录成功！");
		return true;
	}
	
	//修改用户手机
	public boolean changeUserPhone(Customer c,String phone)
	{
		if(existUser(phone))//该手机号是否存在
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
				System.out.println("修改手机号到数据库失败！");
				return false;
			}
			System.out.println("修改手机号成功！");
			return true;
		}
		
	}
	
	//修改用户密码
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
			System.out.println("修改密码到数据库失败！");
			return false;
		}
		System.out.println("修改密码成功！");
		return true;
		
	}
	
	//得到用户
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
	
	
	//删除用户
	public boolean deleteUser(String phone) 
	{
		mySession = db.getSession();
		Query query = mySession.createQuery("delete Customer where customer_phone=?");
		query.setString(0, phone);
		flag = db.update(query,mySession);
		db.closeSession();
		if(flag == false)
		{
			System.out.println("从数据库删除用户失败！");
			return false;
		}
		System.out.println("删除用户成功！");
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

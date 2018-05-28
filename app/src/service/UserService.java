package service;

import java.util.List;

import org.etspace.abc.vo.Customer;

import dao.IUserDao;

public class UserService implements IUserService{
	
	private IUserDao userDao;
	
	public void setUserDao(IUserDao userDao)
	{
		this.userDao = userDao;
	}
	//检查用户是否存在（手机号）
	public boolean exist(String phone) 
	{
		return userDao.existUser(phone);
	}
		
	//添加用户==注册
	public boolean add(Customer c) 
	{
		return userDao.addUser(c);
	}
		
	//验证用户
	public boolean find(String phone,String password) 
	{
		return userDao.findUser(phone, password);
	}

		
	//修改用户手机
	public boolean changePhone(Customer c,String phone) 
	{
		return userDao.changeUserPhone(c, phone);
	}

		
	//修改用户密码
	public boolean changePass(String phone,String password) 
	{
		return userDao.changeUserPass(phone, password);
	}

		
	//得到用户
	public Customer get(String phone) 
	{
		return userDao.getUser(phone);
	}

		
	//删除用户
	public boolean delete(String phone) 
	{
		return userDao.deleteUser(phone);
	}
	
	//得到所有用户
	public List<Customer> getAll()
	{
		return userDao.getAllUser();
	}


}

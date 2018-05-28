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
	//����û��Ƿ���ڣ��ֻ��ţ�
	public boolean exist(String phone) 
	{
		return userDao.existUser(phone);
	}
		
	//����û�==ע��
	public boolean add(Customer c) 
	{
		return userDao.addUser(c);
	}
		
	//��֤�û�
	public boolean find(String phone,String password) 
	{
		return userDao.findUser(phone, password);
	}

		
	//�޸��û��ֻ�
	public boolean changePhone(Customer c,String phone) 
	{
		return userDao.changeUserPhone(c, phone);
	}

		
	//�޸��û�����
	public boolean changePass(String phone,String password) 
	{
		return userDao.changeUserPass(phone, password);
	}

		
	//�õ��û�
	public Customer get(String phone) 
	{
		return userDao.getUser(phone);
	}

		
	//ɾ���û�
	public boolean delete(String phone) 
	{
		return userDao.deleteUser(phone);
	}
	
	//�õ������û�
	public List<Customer> getAll()
	{
		return userDao.getAllUser();
	}


}

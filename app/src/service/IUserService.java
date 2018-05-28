package service;

import java.util.List;

import org.etspace.abc.vo.Customer;

public interface IUserService {
	
	//检查用户是否存在（手机号）
	public boolean exist(String phone);
	
	//添加用户==注册
	public boolean add(Customer c);
	
	//验证用户
	public boolean find(String name,String password);
	
	//修改用户手机
	public boolean changePhone(Customer c,String phone);
	
	//修改用户密码
	public boolean changePass(String phone,String password);
	
	//得到用户
	public Customer get(String phone);
	
	//删除用户
	public boolean delete(String phone);
	
	//得到所有用户
	public List<Customer> getAll();
	

}

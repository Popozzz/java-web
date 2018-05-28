package dao;

import java.util.List;

import org.etspace.abc.vo.Customer;

public interface IUserDao {
	
	//检查用户是否存在（手机号）
	public boolean existUser(String phone);
	
	//添加用户==注册
	public boolean addUser(Customer c);
	
	//验证用户
	public boolean findUser(String phone,String password);
	
	//修改用户手机
	public boolean changeUserPhone(Customer c,String phone);
	
	//修改用户密码
	public boolean changeUserPass(String phone,String password);
	
	//得到用户
	public Customer getUser(String phone);
	
	//删除用户
	public boolean deleteUser(String phone);
	
	//得到所有用户
	public List<Customer> getAllUser();
	

}

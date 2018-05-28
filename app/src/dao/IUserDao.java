package dao;

import java.util.List;

import org.etspace.abc.vo.Customer;

public interface IUserDao {
	
	//����û��Ƿ���ڣ��ֻ��ţ�
	public boolean existUser(String phone);
	
	//����û�==ע��
	public boolean addUser(Customer c);
	
	//��֤�û�
	public boolean findUser(String phone,String password);
	
	//�޸��û��ֻ�
	public boolean changeUserPhone(Customer c,String phone);
	
	//�޸��û�����
	public boolean changeUserPass(String phone,String password);
	
	//�õ��û�
	public Customer getUser(String phone);
	
	//ɾ���û�
	public boolean deleteUser(String phone);
	
	//�õ������û�
	public List<Customer> getAllUser();
	

}

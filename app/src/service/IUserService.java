package service;

import java.util.List;

import org.etspace.abc.vo.Customer;

public interface IUserService {
	
	//����û��Ƿ���ڣ��ֻ��ţ�
	public boolean exist(String phone);
	
	//����û�==ע��
	public boolean add(Customer c);
	
	//��֤�û�
	public boolean find(String name,String password);
	
	//�޸��û��ֻ�
	public boolean changePhone(Customer c,String phone);
	
	//�޸��û�����
	public boolean changePass(String phone,String password);
	
	//�õ��û�
	public Customer get(String phone);
	
	//ɾ���û�
	public boolean delete(String phone);
	
	//�õ������û�
	public List<Customer> getAll();
	

}

package service;

import java.util.List;

import org.etspace.abc.vo.Address;

public interface IAddressService {
	
	//��ӵ�ַ
	public boolean add(Address d);
	
	//�޸ĵ�ַ
	public boolean change(Address d);
	
	//ɾ����ַ
	public boolean delete(String id,Short address);
	
	//���ȫ����ַ
	public List<Address> getAll(String id);

	//��õ�һ��ַ
	public Address getOne(String id,Short order);
}

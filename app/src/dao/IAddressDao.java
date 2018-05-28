package dao;

import java.util.List;

import org.etspace.abc.vo.Address;

public interface IAddressDao {
	
	//ǰ����Ҫ���ջ��ˣ��ջ��������ջ���ַ�Ϳͻ�ID
	
	//��ӵ�ַ
	public boolean addAddress(Address d);//����Ҫ��ַID
	
	//�޸ĵ�ַ
	public boolean changeAddress(Address d);
	
	//ɾ����ַ
	public boolean deleteAddress(String id,Short address);//ֻ��Ҫ��ַID�Ϳͻ�ID
	
	//���ȫ����ַ
	public List<Address> getAllAddress(String id);//ֻ��Ҫ�ͻ�ID
	
	//��õ�һ��ַ
	public Address getOneAddress(String id,Short order);

}

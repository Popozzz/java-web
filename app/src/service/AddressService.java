package service;

import java.util.List;

import org.etspace.abc.vo.Address;

import dao.IAddressDao;


public class AddressService implements IAddressService{
	
	private IAddressDao addressDao;
	
	public void setAddressDao(IAddressDao addressDao)
	{
		this.addressDao = addressDao;
	}
	
	//��ӵ�ַ
	public boolean add(Address d)
	{
		return addressDao.addAddress(d);
	}
	
	//�޸ĵ�ַ
	public boolean change(Address d)
	{
		return addressDao.changeAddress(d);
	}
	
	//ɾ����ַ
	public boolean delete(String id,Short address)
	{
		return addressDao.deleteAddress(id, address);
	}
	
	//���ȫ����ַ
	public List<Address> getAll(String id)
	{
		return addressDao.getAllAddress(id);
	}
	
	//��õ�һ��ַ
	public Address getOne(String id,Short order)
	{
		return addressDao.getOneAddress(id, order);
	}

}

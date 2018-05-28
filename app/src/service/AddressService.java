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
	
	//添加地址
	public boolean add(Address d)
	{
		return addressDao.addAddress(d);
	}
	
	//修改地址
	public boolean change(Address d)
	{
		return addressDao.changeAddress(d);
	}
	
	//删除地址
	public boolean delete(String id,Short address)
	{
		return addressDao.deleteAddress(id, address);
	}
	
	//获得全部地址
	public List<Address> getAll(String id)
	{
		return addressDao.getAllAddress(id);
	}
	
	//获得单一地址
	public Address getOne(String id,Short order)
	{
		return addressDao.getOneAddress(id, order);
	}

}

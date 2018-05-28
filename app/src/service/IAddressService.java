package service;

import java.util.List;

import org.etspace.abc.vo.Address;

public interface IAddressService {
	
	//添加地址
	public boolean add(Address d);
	
	//修改地址
	public boolean change(Address d);
	
	//删除地址
	public boolean delete(String id,Short address);
	
	//获得全部地址
	public List<Address> getAll(String id);

	//获得单一地址
	public Address getOne(String id,Short order);
}

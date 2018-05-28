package dao;

import java.util.List;

import org.etspace.abc.vo.Address;

public interface IAddressDao {
	
	//前端需要传收货人，收货姓名，收货地址和客户ID
	
	//添加地址
	public boolean addAddress(Address d);//不需要地址ID
	
	//修改地址
	public boolean changeAddress(Address d);
	
	//删除地址
	public boolean deleteAddress(String id,Short address);//只需要地址ID和客户ID
	
	//获得全部地址
	public List<Address> getAllAddress(String id);//只需要客户ID
	
	//获得单一地址
	public Address getOneAddress(String id,Short order);

}

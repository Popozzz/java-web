package dao;

import java.util.List;

import org.etspace.abc.vo.OrderDetails;

public interface IOrderDetailDao {
	
	//添加订单
	public boolean addOrderDetail(OrderDetails od);
	
	
	//更新订单状态
	public boolean updateOrderDetailsState(String id,Short x);//订单ID
	
	//修改订单
	public boolean changeOrderDetails(String id,Short x);
	
	//查找客户的所有订单详情（客户端）
	public List<OrderDetails> getPersonOrderDetails(String cid);
	
	//查看客户分类订单
	public List<OrderDetails> getPersonTypeOrderDetails(String cid,Short x);
	
	//查看所有订单
	public List<OrderDetails> getAllOrderDetails();
	
	//查看所有状态的订单
	public List<OrderDetails> getAllTypeOrderDetails(Short x);
	
	//查找客户订单（管理端），用手机号
	public List<OrderDetails> getCustomerOrderDetails(String phone);
	
	//删除订单
	public boolean deleteOrderDetails(String oid);
}

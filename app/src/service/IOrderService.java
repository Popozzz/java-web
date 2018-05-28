package service;

import java.util.List;

import org.etspace.abc.vo.OrderDetails;
import org.etspace.abc.vo.OrderViewId;

public interface IOrderService {
	
	//添加订单
	public boolean add(List<OrderViewId> o);
	
	//生成预订单
	public OrderDetails produceList(List<OrderViewId> l);
	
	//修改订单
	public boolean change(String id,Short x);
	
	//更新订单状态
	public boolean updateState(String id,Short x);//订单ID
	
	//删除订单
	public boolean delete(String oid);
	
	//查找客户的所有订单详情（客户端）
	public List<OrderDetails> getPersonOrder(String cid);
	
	//查看客户分类订单
	public List<OrderDetails> getPersonTypeOrder(String cid,Short x);
	
	//查看所有订单
	public List<OrderDetails> getAllOrder();
	
	//查看所有状态的订单
	public List<OrderDetails> getAllTypeOrder(Short x);
	
	//查找客户订单（管理端），用手机号
	public List<OrderDetails> getCustomerOrder(String phone);

}

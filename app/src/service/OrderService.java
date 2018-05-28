package service;

import java.util.List;

import org.etspace.abc.vo.OrderDetails;
import org.etspace.abc.vo.OrderViewId;

import dao.IOrderDao;
import dao.IOrderDetailDao;
import dao.OrderDao;
import dao.OrderDetailDao;

public class OrderService implements IOrderService{
	
	private IOrderDetailDao orderDetailDao;
	private IOrderDao orderDao;
	
	public void setOrderDetailDao(IOrderDetailDao orderDetailDao)
	{
		this.orderDetailDao = orderDetailDao;
	}
	
	public void setOrderDao(IOrderDao orderDao)
	{
		this.orderDao = orderDao;
	}
	
	//添加订单
	public boolean add(List<OrderViewId> o)
	{
		return orderDao.addOrder(o);
	}
	
	//生成预订单
	public OrderDetails produceList(List<OrderViewId> l)
	{
		return orderDao.produceList(l);
	}
	
	//修改订单,地址
	public boolean change(String id,Short x)
	{
		return orderDetailDao.changeOrderDetails(id, x);
	}
	
	//更新订单状态
	public boolean updateState(String id,Short x)//订单ID
	{
		return orderDetailDao.updateOrderDetailsState(id, x);
	}
	
	public boolean delete(String oid)
	{
		return orderDao.deleteOrder(oid);
	}
	
	//查找客户的所有订单详情（客户端）
	public List<OrderDetails> getPersonOrder(String cid)
	{
		return orderDetailDao.getPersonOrderDetails(cid);
	}
	
	//查看客户分类订单
	public List<OrderDetails> getPersonTypeOrder(String cid,Short x)
	{
		return orderDetailDao.getPersonTypeOrderDetails(cid, x);
	}
	
	//查看所有订单
	public List<OrderDetails> getAllOrder()
	{
		return orderDetailDao.getAllOrderDetails();
	}
	
	//查看所有状态的订单
	public List<OrderDetails> getAllTypeOrder(Short x)
	{
		return orderDetailDao.getAllTypeOrderDetails(x);
	}
	
	//查找客户订单（管理端），用手机号
	public List<OrderDetails> getCustomerOrder(String phone)
	{
		 return orderDetailDao.getCustomerOrderDetails(phone);
	}
}

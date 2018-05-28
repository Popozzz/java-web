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
	
	//��Ӷ���
	public boolean add(List<OrderViewId> o)
	{
		return orderDao.addOrder(o);
	}
	
	//����Ԥ����
	public OrderDetails produceList(List<OrderViewId> l)
	{
		return orderDao.produceList(l);
	}
	
	//�޸Ķ���,��ַ
	public boolean change(String id,Short x)
	{
		return orderDetailDao.changeOrderDetails(id, x);
	}
	
	//���¶���״̬
	public boolean updateState(String id,Short x)//����ID
	{
		return orderDetailDao.updateOrderDetailsState(id, x);
	}
	
	public boolean delete(String oid)
	{
		return orderDao.deleteOrder(oid);
	}
	
	//���ҿͻ������ж������飨�ͻ��ˣ�
	public List<OrderDetails> getPersonOrder(String cid)
	{
		return orderDetailDao.getPersonOrderDetails(cid);
	}
	
	//�鿴�ͻ����ඩ��
	public List<OrderDetails> getPersonTypeOrder(String cid,Short x)
	{
		return orderDetailDao.getPersonTypeOrderDetails(cid, x);
	}
	
	//�鿴���ж���
	public List<OrderDetails> getAllOrder()
	{
		return orderDetailDao.getAllOrderDetails();
	}
	
	//�鿴����״̬�Ķ���
	public List<OrderDetails> getAllTypeOrder(Short x)
	{
		return orderDetailDao.getAllTypeOrderDetails(x);
	}
	
	//���ҿͻ�����������ˣ������ֻ���
	public List<OrderDetails> getCustomerOrder(String phone)
	{
		 return orderDetailDao.getCustomerOrderDetails(phone);
	}
}

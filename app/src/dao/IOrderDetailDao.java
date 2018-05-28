package dao;

import java.util.List;

import org.etspace.abc.vo.OrderDetails;

public interface IOrderDetailDao {
	
	//��Ӷ���
	public boolean addOrderDetail(OrderDetails od);
	
	
	//���¶���״̬
	public boolean updateOrderDetailsState(String id,Short x);//����ID
	
	//�޸Ķ���
	public boolean changeOrderDetails(String id,Short x);
	
	//���ҿͻ������ж������飨�ͻ��ˣ�
	public List<OrderDetails> getPersonOrderDetails(String cid);
	
	//�鿴�ͻ����ඩ��
	public List<OrderDetails> getPersonTypeOrderDetails(String cid,Short x);
	
	//�鿴���ж���
	public List<OrderDetails> getAllOrderDetails();
	
	//�鿴����״̬�Ķ���
	public List<OrderDetails> getAllTypeOrderDetails(Short x);
	
	//���ҿͻ�����������ˣ������ֻ���
	public List<OrderDetails> getCustomerOrderDetails(String phone);
	
	//ɾ������
	public boolean deleteOrderDetails(String oid);
}

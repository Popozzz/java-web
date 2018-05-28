package service;

import java.util.List;

import org.etspace.abc.vo.OrderDetails;
import org.etspace.abc.vo.OrderViewId;

public interface IOrderService {
	
	//��Ӷ���
	public boolean add(List<OrderViewId> o);
	
	//����Ԥ����
	public OrderDetails produceList(List<OrderViewId> l);
	
	//�޸Ķ���
	public boolean change(String id,Short x);
	
	//���¶���״̬
	public boolean updateState(String id,Short x);//����ID
	
	//ɾ������
	public boolean delete(String oid);
	
	//���ҿͻ������ж������飨�ͻ��ˣ�
	public List<OrderDetails> getPersonOrder(String cid);
	
	//�鿴�ͻ����ඩ��
	public List<OrderDetails> getPersonTypeOrder(String cid,Short x);
	
	//�鿴���ж���
	public List<OrderDetails> getAllOrder();
	
	//�鿴����״̬�Ķ���
	public List<OrderDetails> getAllTypeOrder(Short x);
	
	//���ҿͻ�����������ˣ������ֻ���
	public List<OrderDetails> getCustomerOrder(String phone);

}

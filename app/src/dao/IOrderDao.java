package dao;

import java.util.List;

import org.etspace.abc.vo.OrderDetails;
import org.etspace.abc.vo.OrderView;
import org.etspace.abc.vo.OrderViewId;
import org.etspace.abc.vo.SumViewId;


public interface IOrderDao 
{
	//ǰ����Ҫ���������ݣ���ƷID�б���ַID������״̬���ͻ�ID
	
	//�����Լ���ȫ������
	public List<OrderView> getAllPersonOrder(String id);
	
	//�ͻ����ҷ��ඩ��
	public List<OrderView> getTypePersonOrder(String id,Short type);
	
	//��Ӷ���
	public boolean addOrder(List<OrderViewId> o);
	
	//����Ԥ����
	public OrderDetails produceList(List<OrderViewId> l);
	
	//ɾ������
	public boolean deleteOrder(String oid);
	
	//����ȫ������
	public List<OrderView> getAllOrder();
	
	//����һ���͵�ȫ������
	public List<OrderView> getAllTypeOrder(short type);
	
	//����
	public List<SumViewId> getSettleAccounts(String start,String end);

}

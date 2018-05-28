package dao;

import java.util.List;

import org.etspace.abc.vo.OrderProduct;
import org.etspace.abc.vo.Product;

public interface IOrderProductDao {
	
	//��Ʒ���������ж���ID����Ʒid����Ʒ���ƣ���Ʒ������,��Ʒ�ļ۸񡣺Ͳ�ƷͼƬ
	//ǰ����Ҫ����ƷID�Ͳ�Ʒ����
	
	//��Ӷ���
	public boolean addOrderProduct(OrderProduct op);
	
	//ɾ������
	public boolean deleteOrderProduct(String oid);
	
	//�鿴���������в�Ʒ
	public List<OrderProduct> getAllOrderProduct(String oid);
	

}

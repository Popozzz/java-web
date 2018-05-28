package service;

import java.util.List;

import org.etspace.abc.vo.Cart;
import org.etspace.abc.vo.OrderViewId;
import org.etspace.abc.vo.Shoppingcart;

public interface IShoppingCartService {
	
	//��ӵ����ﳵ
	public Shoppingcart add(String cid,String pid,int number);
	
	//���¹��ﳵ
	public boolean update(List<Cart> cart);
	
	//ɾ�����ﳵ��Ʒ
	public boolean delete(String cid,String pid);
	
	//���㹺�ﳵ,���ɶ���
	public boolean buy(List<OrderViewId> o);
	
	//��ù��ﳵ
	public List<Shoppingcart> getCart(String id);

}

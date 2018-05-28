package dao;

import java.util.List;

import org.etspace.abc.vo.Cart;
import org.etspace.abc.vo.OrderViewId;
import org.etspace.abc.vo.Shoppingcart;

public interface IShoppingCartDao {
	
	//ǰ����Ҫ����ƷID���ͻ�ID����ƷͼƬ�Ͳ�Ʒ����
	
	//��ӵ����ﳵ
	public Shoppingcart addProductToCart(String cid,String pid,int number);
	
	//���¹��ﳵ
	public boolean updateShoppingCart(List<Cart> cart);
	
	//ɾ�����ﳵ��Ʒ
	public boolean deleteProductToCart(String cid,String pid);
	
	//���㹺�ﳵ,���ɶ���
	public boolean buyProductToCart(List<OrderViewId> o);
	
	//��ù��ﳵ
	public List<Shoppingcart> getProductToCart(String id);

}

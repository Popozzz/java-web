package service;

import java.util.List;

import org.etspace.abc.vo.Cart;
import org.etspace.abc.vo.OrderViewId;
import org.etspace.abc.vo.Shoppingcart;

public interface IShoppingCartService {
	
	//添加到购物车
	public Shoppingcart add(String cid,String pid,int number);
	
	//更新购物车
	public boolean update(List<Cart> cart);
	
	//删除购物车产品
	public boolean delete(String cid,String pid);
	
	//结算购物车,生成订单
	public boolean buy(List<OrderViewId> o);
	
	//获得购物车
	public List<Shoppingcart> getCart(String id);

}

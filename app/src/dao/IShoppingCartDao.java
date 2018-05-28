package dao;

import java.util.List;

import org.etspace.abc.vo.Cart;
import org.etspace.abc.vo.OrderViewId;
import org.etspace.abc.vo.Shoppingcart;

public interface IShoppingCartDao {
	
	//前端需要传产品ID，客户ID，产品图片和产品数量
	
	//添加到购物车
	public Shoppingcart addProductToCart(String cid,String pid,int number);
	
	//更新购物车
	public boolean updateShoppingCart(List<Cart> cart);
	
	//删除购物车产品
	public boolean deleteProductToCart(String cid,String pid);
	
	//结算购物车,生成订单
	public boolean buyProductToCart(List<OrderViewId> o);
	
	//获得购物车
	public List<Shoppingcart> getProductToCart(String id);

}

package service;

import java.util.List;

import org.etspace.abc.vo.Cart;
import org.etspace.abc.vo.OrderViewId;
import org.etspace.abc.vo.Shoppingcart;

import dao.IShoppingCartDao;

public class ShoppingCartService implements IShoppingCartService{
	
	private IShoppingCartDao shoppingCartDao;
	
	public void setShoppingCartDao(IShoppingCartDao shoppingCartDao)
	{
		this.shoppingCartDao = shoppingCartDao;
	}
	
	//添加到购物车
	public Shoppingcart add(String cid,String pid,int number)
	{
		return shoppingCartDao.addProductToCart(cid,pid,number);
	}
	
	public boolean update(List<Cart> cart)
	{
		return shoppingCartDao.updateShoppingCart(cart);
	}
	
	//删除购物车产品
	public boolean delete(String cid,String pid)
	{
		return shoppingCartDao.deleteProductToCart(cid, pid);
	}
	
	//结算购物车,生成订单
	public boolean buy(List<OrderViewId> o)
	{
		return shoppingCartDao.buyProductToCart(o);
	}
	
	//获得购物车
	public List<Shoppingcart> getCart(String id)
	{
		return shoppingCartDao.getProductToCart(id);
	}

}

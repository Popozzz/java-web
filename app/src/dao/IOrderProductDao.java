package dao;

import java.util.List;

import org.etspace.abc.vo.OrderProduct;
import org.etspace.abc.vo.Product;

public interface IOrderProductDao {
	
	//产品订单里面有订单ID，产品id，产品名称，产品的数量,产品的价格。和产品图片
	//前端需要传产品ID和产品数量
	
	//添加订单
	public boolean addOrderProduct(OrderProduct op);
	
	//删除订单
	public boolean deleteOrderProduct(String oid);
	
	//查看订单的所有产品
	public List<OrderProduct> getAllOrderProduct(String oid);
	

}

package dao;

import java.util.List;

import org.etspace.abc.vo.OrderDetails;
import org.etspace.abc.vo.OrderView;
import org.etspace.abc.vo.OrderViewId;
import org.etspace.abc.vo.SumViewId;


public interface IOrderDao 
{
	//前端需要发来的数据：产品ID列表，地址ID，订单状态，客户ID
	
	//查找自己的全部订单
	public List<OrderView> getAllPersonOrder(String id);
	
	//客户查找分类订单
	public List<OrderView> getTypePersonOrder(String id,Short type);
	
	//添加订单
	public boolean addOrder(List<OrderViewId> o);
	
	//生成预订单
	public OrderDetails produceList(List<OrderViewId> l);
	
	//删除订单
	public boolean deleteOrder(String oid);
	
	//查找全部订单
	public List<OrderView> getAllOrder();
	
	//查找一类型的全部订单
	public List<OrderView> getAllTypeOrder(short type);
	
	//结算
	public List<SumViewId> getSettleAccounts(String start,String end);

}

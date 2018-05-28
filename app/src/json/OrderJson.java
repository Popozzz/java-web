package json;

import java.util.Iterator;

import org.etspace.abc.vo.OrderDetails;
import org.etspace.abc.vo.OrderProduct;

import db.DBManager;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class OrderJson {
	
	JSONObject jsonObj = new JSONObject();
	DBManager db = new DBManager();
	public OrderJson(OrderDetails order)
	{
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("orderId",order.getOrderId());
		jsonObj.put("customerId", order.getCustomerId());
		jsonObj.put("orderTotalAmount", order.getOrderTotalAmount());
		jsonObj.put("orderDate", order.getOrderDate().toString());
		jsonObj.put("orderState", order.getOrderState());
		jsonObj.put("addressId",order.getAddressId());
		jsonObj.put("orderAddress",order.getOrderAddress());
		Iterator j = order.getOrderProducts().iterator();
		JSONArray array = new JSONArray();
		for(Iterator iter = j; iter.hasNext();)
		{
			OrderProduct str = (OrderProduct)iter.next();
			JSONObject json = new JSONObject();
			json.put("productId",str.getId().getProductId());
			json.put("productNumber",str.getProductNumber());
			json.put("productPrice", str.getProductPrice());
			json.put("productName", str.getProductName());
			json.put("productImg", str.getProductImg());
			array.add(json);
		}
		jsonObj.put("orderProduct", array.toString());
		db.closeSession();
	}
	
	public JSONObject getOrderJson()
	{
		return jsonObj;
	}

}

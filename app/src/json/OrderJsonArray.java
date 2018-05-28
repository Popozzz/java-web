package json;

import java.util.Iterator;
import java.util.List;

import org.etspace.abc.vo.OrderDetails;
import org.etspace.abc.vo.OrderProduct;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dao.OrderDetailDao;
import db.DBManager;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class OrderJsonArray {
	
	JSONArray orderJsonArray = new JSONArray();
	DBManager db = new DBManager();
	public OrderJsonArray(List<OrderDetails> order)
	{
		for(int i=0;i<order.size();i++)
		{
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("orderId",order.get(i).getOrderId());
			jsonObj.put("customerId", order.get(i).getCustomerId());
			jsonObj.put("orderTotalAmount", order.get(i).getOrderTotalAmount());
			jsonObj.put("orderDate", order.get(i).getOrderDate().toString());
			jsonObj.put("orderState", order.get(i).getOrderState());
			jsonObj.put("addressId",order.get(i).getAddressId());
			jsonObj.put("orderAddress",order.get(i).getOrderAddress());
			Iterator j = order.get(i).getOrderProducts().iterator();
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
			
			orderJsonArray.add(jsonObj);
		}
		db.closeSession();
		
	}
	
	public JSONArray getOrderJSONArray()
	{
		return orderJsonArray;
	}
	
	public static void main(String[] args) {
		
		OrderDetailDao od = new OrderDetailDao();
		List<OrderDetails> order = od.getAllOrderDetails();
		OrderJsonArray oj = new OrderJsonArray(order);
		JSONArray or = oj.getOrderJSONArray();
		System.out.println(or.toString());
		
		Gson gson = new Gson();
        // 将 json 转化 成 List泛型
        List<OrderDetails> stus = gson.fromJson(or.toString(), new TypeToken<List<OrderDetails>>() {}.getType());
        System.out.println(stus.size());
        Iterator j = order.get(2).getOrderProducts().iterator();
        for(Iterator iter = j; iter.hasNext();)
		{
			OrderProduct str = (OrderProduct)iter.next();
			System.out.println(str.getId().getProductId());
			System.out.println(str.getProductName());
			System.out.println(str.getProductNumber());
		}
        
        
		
	}

}

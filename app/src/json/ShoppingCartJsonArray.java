package json;

import java.util.List;

import org.etspace.abc.vo.Shoppingcart;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ShoppingCartJsonArray 
{
	JSONArray shoppingJsonArray = new JSONArray();
	
	public ShoppingCartJsonArray(List<Shoppingcart> list)
	{
		for(int i=0;i<list.size();i++)
		{
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("customerId",list.get(i).getId().getCustomer().getCustomerId());
			jsonObj.put("productId",list.get(i).getId().getProduct().getProductId());
			jsonObj.put("productNumber",list.get(i).getProductNumber());
			jsonObj.put("productImg",list.get(i).getProductImg());
			jsonObj.put("productName",list.get(i).getProductName());
			jsonObj.put("productPrice",list.get(i).getProductPrice());
			shoppingJsonArray.add(jsonObj);
			
		}
	}
	
	public JSONArray getShoppingCartJSONArray()
	{
		return shoppingJsonArray;
	}

}

package json;

import org.etspace.abc.vo.Shoppingcart;

import net.sf.json.JSONObject;

public class ShoppingCartJson {
	
	JSONObject jsonObj =  new JSONObject();
	
	public  ShoppingCartJson(Shoppingcart s)
	{
		jsonObj = new JSONObject();
		jsonObj.put("customerId",s.getId().getCustomer().getCustomerId());
		jsonObj.put("productId",s.getId().getProduct().getProductId());
		jsonObj.put("productNumber",s.getProductNumber());
		jsonObj.put("productImg",s.getProductImg());
		jsonObj.put("productName",s.getProductName());		
		jsonObj.put("productPrice",s.getProductPrice());
	}
	
	public JSONObject getShoppingCartJson()
	{
		return jsonObj;
	}

}

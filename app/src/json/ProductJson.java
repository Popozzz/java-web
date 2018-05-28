package json;

import java.text.SimpleDateFormat;

import org.etspace.abc.vo.Product;

import net.sf.json.JSONObject;

public class ProductJson {
	
	JSONObject jsonObj =  new JSONObject();
	
	public ProductJson(Product p)
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		jsonObj = new JSONObject();
		jsonObj.put("productId",p.getProductId());
		jsonObj.put("productName",p.getProductName());
		jsonObj.put("productImg",p.getProductImg());
		jsonObj.put("productDate",format.format(p.getProductDate()));
		jsonObj.put("productSell",p.getProductSell());
		jsonObj.put("productPrice",p.getProductPrice());
		jsonObj.put("productDescription",p.getProductDescription());
		jsonObj.put("productStorage",p.getProductStorage());
		jsonObj.put("productParameter",p.getProductParameter());
		jsonObj.put("productType",p.getProductType());
	}
	
	public JSONObject getProductJson()
	{
		return jsonObj;
	}

}

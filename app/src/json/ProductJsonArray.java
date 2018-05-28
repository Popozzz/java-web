package json;

import java.text.SimpleDateFormat;
import java.util.List;

import org.etspace.abc.vo.Product;

import dao.ProductDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ProductJsonArray 
{
	JSONArray productJsonArray = new JSONArray();
	
	public ProductJsonArray(List<Product> p)
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		for(int i=0;i<p.size();i++)
		{
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("productId",p.get(i).getProductId());
			jsonObj.put("productName",p.get(i).getProductName());
			jsonObj.put("productImg",p.get(i).getProductImg());
			jsonObj.put("productDate",format.format(p.get(i).getProductDate()));
			jsonObj.put("productSell",p.get(i).getProductSell());
			jsonObj.put("productPrice",p.get(i).getProductPrice());
			jsonObj.put("productDescription",p.get(i).getProductDescription());
			jsonObj.put("productStorage",p.get(i).getProductStorage());
			jsonObj.put("productParameter",p.get(i).getProductParameter());
			jsonObj.put("productType",p.get(i).getProductType());
			productJsonArray.add(jsonObj);
		}
		
	}

	public JSONArray getProductJSONArray()
	{
		return productJsonArray;
	}
	
	public static void main(String[] args) {
		ProductDao pd = new ProductDao();
		List<Product> p = pd.getAllProduct();
		ProductJsonArray pj = new ProductJsonArray(p);
		JSONArray array = pj.getProductJSONArray();
		System.out.println(array.toString());
		
	}
}

package json;

import java.util.List;

import org.etspace.abc.vo.Address;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class AddressJsonArray 
{
	JSONArray addressJsonArray = new JSONArray();
	
	public AddressJsonArray(List<Address> list)
	{
		for(int i=0;i<list.size();i++)
		{
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("customerId",list.get(i).getId().getCustomer().getCustomerId());
			jsonObj.put("addressId",list.get(i).getId().getAddressId());
			jsonObj.put("customerName",list.get(i).getCustomerName());
			jsonObj.put("customerAddress",list.get(i).getCustomerAddress());
			jsonObj.put("customerPhone",list.get(i).getCustomerPhone());
			addressJsonArray.add(jsonObj);
			
		}
	}
	
	public JSONArray getAddressJsonArray()
	{
		return addressJsonArray;
	}
}

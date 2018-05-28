package json;



import org.etspace.abc.vo.Address;

import net.sf.json.JSONObject;

public class AddressJson {
	
	JSONObject jsonObj =  new JSONObject();
	
	public  AddressJson(Address a)
	{
		jsonObj = new JSONObject();
		jsonObj.put("customerId",a.getId().getCustomer().getCustomerId());
		jsonObj.put("addressId",a.getId().getAddressId());
		jsonObj.put("customerName",a.getCustomerName());
		jsonObj.put("customerAddress",a.getCustomerAddress());
		jsonObj.put("customerPhone",a.getCustomerPhone());
		
	}
	
	public JSONObject getAddressJson()
	{
		return jsonObj;
	}

}

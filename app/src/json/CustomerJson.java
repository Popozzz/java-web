package json;

import org.etspace.abc.vo.Customer;

import net.sf.json.JSONObject;

public class CustomerJson
{
	JSONObject jsonObj =  new JSONObject();
	
	public  CustomerJson(Customer c)
	{
		jsonObj = new JSONObject();
		jsonObj.put("customerId", c.getCustomerId());
		jsonObj.put("customerPassword", c.getCustomerPassword());
		jsonObj.put("customerPhone", c.getCustomerPhone());
		jsonObj.put("customerEmail", c.getCustomerEmail());
		jsonObj.put("customerSum", c.getCustomerSum());
		
	}
	
	public JSONObject getCustomerJson()
	{
		return jsonObj;
	}

}

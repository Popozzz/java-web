package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.etspace.abc.vo.Address;
import org.etspace.abc.vo.AddressId;
import org.etspace.abc.vo.Customer;

import json.AddressJson;
import net.sf.json.JSONObject;
import service.AddressService;

public class ChangeAddressServlet extends BaseServlet{
	
	
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException
	{
		
			String cid = request.getParameter("cid");
			Short aid = Short.valueOf(request.getParameter("aid"));
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			
			AddressService addressService = (AddressService)getCtx().getBean("addressService");
			
			Address a = new Address();
			AddressId i = new AddressId();
			Customer c = new Customer();
			c.setCustomerId(cid);
		
			i.setCustomer(c);
			i.setAddressId(aid);
			a.setId(i);
			a.setCustomerPhone(phone);
			a.setCustomerName(name);
			a.setCustomerAddress(address);
					
			response.setContentType("text/html;charset=GBK");
			
			try{
				
				boolean flag = addressService.change(a);
				if(flag == false)
				{
					response.getWriter().println("");
				}
				else
				{
					JSONObject jsonObj = new AddressJson(a).getAddressJson();
					response.getWriter().println(jsonObj.toString());
				}
			}catch(Exception e)
			{
				e.printStackTrace();
				response.getWriter().println("");
			}
			
		
	}


}

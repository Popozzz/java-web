package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.etspace.abc.vo.Address;

import json.AddressJsonArray;
import net.sf.json.JSONArray;
import service.AddressService;

public class GetAllAddressServlet extends BaseServlet{
	
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException
	{
		
			String id = request.getParameter("cid");
			
			AddressService address = (AddressService)getCtx().getBean("addressService");
			
			response.setContentType("text/html;charset=GBK");
			
			try{
				
				List<Address> list = address.getAll(id);
				
				if(list.size()<=0)
				{
					response.getWriter().println("");
				}
				else
				{
					JSONArray jsonArray = new AddressJsonArray(list).getAddressJsonArray();
					response.getWriter().println(jsonArray.toString());
				}
			}catch(Exception e)
			{
				e.printStackTrace();
				response.getWriter().println("");
			}
			
		
	}

}

package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.etspace.abc.vo.Address;

import json.AddressJson;
import net.sf.json.JSONObject;
import service.AddressService;

public class GetOneAddressServlet extends BaseServlet{
	
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException
	{
		
			String cid = request.getParameter("cid");
			Short aid = Short.valueOf(request.getParameter("aid"));
			
			AddressService address = (AddressService)getCtx().getBean("addressService");
			
			response.setContentType("text/html;charset=GBK");
			
			try{
				
				Address one = address.getOne(cid, aid);
				
				if(one == null)
				{
					response.getWriter().println("");
				}
				else
				{
					JSONObject jsonObject = new AddressJson(one).getAddressJson();
					response.getWriter().println(jsonObject.toString());
				}
			}catch(Exception e)
			{
				e.printStackTrace();
				response.getWriter().println("");
			}
			
		
	}

}

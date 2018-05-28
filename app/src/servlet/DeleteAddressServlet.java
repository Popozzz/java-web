package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AddressService;

public class DeleteAddressServlet extends BaseServlet{


	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException
	{
			String cid = request.getParameter("cid");
			Short aid = Short.valueOf(request.getParameter("aid"));
			
			AddressService address = (AddressService)getCtx().getBean("addressService");			
			response.setContentType("text/html;charset=GBK");
			
			try{
				
				boolean flag = address.delete(cid, aid);
				if(flag == false)
				{
					response.getWriter().println("");
				}
				else
				{
					response.getWriter().println("Success");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				response.getWriter().println("");
			}
	}

}

package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.OrderService;

public class UpdateOrderStateServlet extends BaseServlet{
	
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException
	{
		
		String oid = request.getParameter("oid");//¶©µ¥ID
		Short x = Short.valueOf(request.getParameter("state"));
		
		OrderService order = (OrderService)getCtx().getBean("orderService");
		response.setContentType("text/html;charset=GBK");
		
		try{
			
			boolean flag = order.updateState(oid, x);
			if(flag == false)
			{
				response.getWriter().println("");
			}
			else
			{
				response.getWriter().println("Success");
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
			response.getWriter().println("");
		}
	}

}

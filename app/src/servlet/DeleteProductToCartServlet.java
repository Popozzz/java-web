package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ShoppingCartService;

public class DeleteProductToCartServlet extends BaseServlet{
	
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException
	{
		
			String cid = request.getParameter("cid");
			String pid = request.getParameter("pid");
			
			ShoppingCartService cart = (ShoppingCartService)getCtx().getBean("shoppingCartService");
			
			response.setContentType("text/html;charset=GBK");
			
			try{
				
				boolean flag = cart.delete(cid, pid);
				if(flag==false)
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

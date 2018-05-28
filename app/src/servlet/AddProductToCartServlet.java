package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.etspace.abc.vo.Shoppingcart;

import json.ShoppingCartJson;
import net.sf.json.JSONObject;
import service.ShoppingCartService;

public class AddProductToCartServlet extends BaseServlet{
	
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException
	{
			String cid = request.getParameter("cid");
			String pid = request.getParameter("pid");
			int number = Integer.valueOf(request.getParameter("number"));
			
			ShoppingCartService cart = (ShoppingCartService)getCtx().getBean("shoppingCartService");
			
			response.setContentType("text/html;charset=GBK");
			
			try{
				
				Shoppingcart shoppingCart = cart.add(cid, pid, number);
				
				if(shoppingCart == null)
				{
					response.getWriter().println("");
				}
				else
				{
					JSONObject jsonObj = new ShoppingCartJson(shoppingCart).getShoppingCartJson() ;
					response.getWriter().println(jsonObj.toString());
				}
				
				
			}catch(Exception e)
			{
				e.printStackTrace();
				response.getWriter().println("");
			}
			
			
	}

}

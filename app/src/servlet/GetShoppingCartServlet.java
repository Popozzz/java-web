package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.etspace.abc.vo.Shoppingcart;

import json.ShoppingCartJsonArray;
import net.sf.json.JSONArray;
import service.ShoppingCartService;

public class GetShoppingCartServlet extends BaseServlet{
	
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException
	{
			String id = request.getParameter("cid");
			
			ShoppingCartService cart = (ShoppingCartService)getCtx().getBean("shoppingCartService");
			
			response.setContentType("text/html;charset=GBK");
			
			try{
				
				List<Shoppingcart> list = cart.getCart(id);

				if(list.size()<=0)
				{
					response.getWriter().println("");
				}
				else
				{
					JSONArray jsonArray = new ShoppingCartJsonArray(list).getShoppingCartJSONArray();
					response.getWriter().println(jsonArray.toString());
				}
				
				
			}catch(Exception e)
			{
				e.printStackTrace();
				response.getWriter().println("");
			}
		
	}

}

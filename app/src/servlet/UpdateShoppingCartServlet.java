package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.etspace.abc.vo.Cart;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import service.ShoppingCartService;

public class UpdateShoppingCartServlet extends BaseServlet{
	
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException
	{
		
		String shoppingCart = request.getParameter("shoppingCart");
		ShoppingCartService cart = (ShoppingCartService)getCtx().getBean("ShoppingCartService");
		response.setContentType("text/html;charset=GBK");
		
		try{
			Gson gson = new Gson();
			List<Cart> list = gson.fromJson(shoppingCart.toString(), new TypeToken<List<Cart>>() {}.getType());
			boolean flag = cart.update(list);
			if(flag == false)
			{
				response.getWriter().println("");
			}
			else
			{
				response.getWriter().println("Success");
			}
        
        
		}catch( Exception e)
		{
			e.printStackTrace();
			response.getWriter().println("");
		}
		
	}

}

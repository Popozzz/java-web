package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.etspace.abc.vo.OrderViewId;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import service.OrderService;

public class AddOrderServlet extends BaseServlet{
	

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException
	{
		
		String orderString = request.getParameter("order");
		
		
		OrderService order = (OrderService)getCtx().getBean("orderService");
		response.setContentType("text/html;charset=GBK");
		
		try{
			Gson gson = new Gson();
			List<OrderViewId> or = gson.fromJson(orderString.toString(), new TypeToken<List<OrderViewId>>() {}.getType());
			boolean flag = order.add(or);
			if(flag == false)
			{
				response.getWriter().println("");
			}
			else
			{
				response.getWriter().println("Sucess");
			}
        
        
		}catch( Exception e)
		{
			e.printStackTrace();
			response.getWriter().println("");
		}
        
        
        
	}

}

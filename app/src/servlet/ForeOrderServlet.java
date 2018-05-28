package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.etspace.abc.vo.OrderDetails;
import org.etspace.abc.vo.OrderViewId;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import json.OrderJson;
import net.sf.json.JSONObject;
import service.OrderService;

public class ForeOrderServlet extends BaseServlet{//Ô¤¶©µ¥
	

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
			 OrderDetails od = order.produceList(or);
			if(od == null)
			{
				response.getWriter().println("");
			}
			else
			{
				JSONObject obj = new OrderJson(od).getOrderJson();
				response.getWriter().println(obj.toString());
			}
        
        
		}catch( Exception e)
		{
			e.printStackTrace();
			response.getWriter().println("");
		}
        
		
	}
}

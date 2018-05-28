package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.etspace.abc.vo.OrderDetails;

import json.OrderJsonArray;
import net.sf.json.JSONArray;
import service.OrderService;

public class GetTypeOrderServlet extends BaseServlet{
	
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException
	{
		
		String cid = request.getParameter("cid");
		Short state = Short.valueOf(request.getParameter("state"));
		
		OrderService order = (OrderService)getCtx().getBean("orderService");
		response.setContentType("text/html;charset=GBK");
		
		try{
			
			List<OrderDetails> list = order.getPersonTypeOrder(cid, state);
			if(list.size()<=0)
			{
				response.getWriter().println("");
			}
			else
			{
				JSONArray jsonArray = new OrderJsonArray(list).getOrderJSONArray();
				response.getWriter().println(jsonArray.toString());
			}
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
			response.getWriter().println("");
		}
		
	}

}

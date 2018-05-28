package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.etspace.abc.vo.OrderViewId;

import service.OrderService;

public class AddOrderDirectlyServlet extends BaseServlet{	//需要产品ID，客户ID，订单状态，产品数量
	

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException
	{
		
		String cid = request.getParameter("cid");
		String pid = request.getParameter("pid");
		String oid = request.getParameter("oid");
		Short state = Short.valueOf(request.getParameter("state"));
		Short addressId = Short.valueOf(request.getParameter("addressId"));
		int number = Integer.valueOf(request.getParameter("number"));
		
		List<OrderViewId> lo = new ArrayList<OrderViewId>();
		OrderViewId l = new OrderViewId();
		l.setCustomerId(cid);
		l.setProductId(pid);
		l.setOrderId("oid");
		l.setAddressId(addressId);
		l.setProductNumber(number);
		l.setOrderState(state);
		lo.add(l);
		
		OrderService order = (OrderService)getCtx().getBean("orderService");
		response.setContentType("text/html;charset=GBK");
		
		try{
			
			boolean flag = order.add(lo);
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

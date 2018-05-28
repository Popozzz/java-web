package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.etspace.abc.vo.Product;

import json.ProductJson;
import net.sf.json.JSONObject;
import service.ProductService;

public class GetOneProductServlet extends BaseServlet{
	
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException
	{
		
		
		String id = request.getParameter("productId");
		
		ProductService product = (ProductService)getCtx().getBean("productService");
		
		response.setContentType("text/html;charset=GBK");
		
		try
		{
			
			Product p = product.getOne(id);
			if(p == null)
			{
				
				response.getWriter().println("");
			}
			else
			{
				JSONObject json= new ProductJson(p).getProductJson();				
				response.getWriter().println(json.toString());
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			response.getWriter().println("");
		}
		
		
	}

}

package servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.etspace.abc.vo.Product;

import json.ProductJsonArray;
import net.sf.json.JSONArray;
import service.ProductService;

public class GetAllProductServlet extends BaseServlet{
	
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException
	{
		
		ProductService product = (ProductService)getCtx().getBean("productService");
		response.setContentType("text/html;charset=GBK");
		
		try{
			
			List<Product> list = product.getAll();
			
			if(list.size()<=0)//数据库数据为空
			{
				response.getWriter().println("");
			}
			else
			{
				JSONArray jsonArray = new ProductJsonArray(list).getProductJSONArray();			
				response.getWriter().println(jsonArray.toString());
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
			response.getWriter().println("");
		}
		
		
	}

}

package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.etspace.abc.vo.Customer;

import json.CustomerJson;
import net.sf.json.JSONObject;
import service.UserService;

public class RegisterServlet extends BaseServlet{
	

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException
	{
		String phone = request.getParameter("phone");
		String pass = request.getParameter("pass");
		Customer c = new Customer();
		System.out.println("Phone:"+phone.toString());
		System.out.println("pass:"+pass.toString());
		UserService user = (UserService) getCtx().getBean("userService");

		c.setCustomerPhone(phone);
		c.setCustomerPassword(pass);
		response.setContentType("text/html;charset=GBK");
				
		try{
			
			boolean flag = user.add(c);//添加用户			
			if(flag == false)
			{
				response.getWriter().println("");
			}
			else
			{
				JSONObject jsonObj = new CustomerJson(c).getCustomerJson();//返回注册的用户信息
				System.out.println(jsonObj.toString());
				//输出响应
				response.getWriter().println(jsonObj.toString());			
			}	
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			response.getWriter().println("");
		}
		
		
		
	}

}

package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class BaseServlet  extends HttpServlet
{

	private static final long serialVersionUID = 1L;
	private ApplicationContext ctx;
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		//��ȡwebӦ���е�ApplicationContextʵ��
		ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		
	}
	
	//����webӦ���е�Spring����
	public ApplicationContext getCtx()
	{
		return this.ctx;
	}
}

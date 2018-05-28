package servlet;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.etspace.abc.vo.Product;
import random.ProductID;
import service.ProductService;




public class UploadServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Product p = new Product();
		 // 1. 创建DiskFileItemFactory对象，设置缓冲区大小和临时文件目录 
	    DiskFileItemFactory factory = new DiskFileItemFactory(); 
	    // System.out.println(System.getProperty("java.io.tmpdir"));//默认临时文件夹 
	    // 2. 创建ServletFileUpload对象，并设置上传文件的大小限制。 
	    ServletFileUpload sfu = new ServletFileUpload(factory); 
	    sfu.setSizeMax(10 * 1024 * 1024);// 以byte为单位 不能超过10M 1024byte = 
	             // 1kb 1024kb=1M 1024M = 1G 
	    sfu.setHeaderEncoding("utf-8");
	    
		ProductID k = new ProductID();
		String id = k.getProductID();
		boolean flag;
		String tips= "添加失败";
		String img= "fail.png";
		String text1;
		String text2;
		String text3;
		String text;
		text1 = "<html xmlns=\"http://www.w3.org/1999/xhtml \">"+"<head>"
				+"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />"
				+"<title>tips</title>"
				+"</head>"
				+"<body style=\"padding-top:180px; padding-left:50px; padding-right:50px; background:#FFF\">"
				+	"<div align=\"center\" height=\"350px\"><img src=\"/app/icon/tip.png\" alt=\"apple\" height=\"100px\" width=\"100px\"/></div>"
				+	"<p align=\"center\">Apple提示你：";
		text2="<img src=\"/app/icon/";
		text3=	"\" alt=\"\" height=\"30px\" width=\"30px\"/></p>"
				+	"<br/>"
				+ "<div style=\"float:left;padding-left:80px;padding-top:60px;\"><a style=\"color:#333\" href=\"javascript:history.go(-1);\"><b><<返回<b></a></div>"
				+ "<div style=\"float:right;padding-right:80px;padding-top:60px;\"><a style=\"color:#333\" href=\"javascript:window.parent.zDiag.close();\"><b>关闭</b></a></div>"
				+ "</body>";
		

		
		String value[] = new String[6];

		
		Date date = new Date();
		
		ProductService product = (ProductService) getCtx().getBean("productService");
		
	    try {
	    	
	    	List<FileItem>  f = sfu.parseRequest(request);
	    	int l = f.size()-1;
	    	System.out.println(f.size());//返回 文件名或文件路径
	    	System.out.println(f.get(l).getName());//返回 文件名或文件路径
	    	System.out.println(f.get(l).getFieldName());//返回表单中的name属性
	    	System.out.println(f.get(l).getContentType());//返回文件的 类型
	    	System.out.println(f.get(l).getSize());//返回文件的大小

	    	String url = "";
	    	
	    	
	    	int j=0;
			  	
	    	for(FileItem item : f)
	    	{
                //如果fileitem中封装的是普通输入项的数据
                if(item.isFormField()){
                    //String name = item.getFieldName();
                    //解决普通输入项的数据的中文乱码问题
                    value[j] = item.getString("UTF-8");
                    //value = new String(value.getBytes("iso8859-1"),"UTF-8");
                    
                }else{
                	//如果fileitem中封装的是上传文件
                    //得到上传的文件名称，
        	    	System.out.println("文件名：" + item.getName());
        	        String suffix = item.getName().substring(f.get(l).getName().lastIndexOf('.')); //获取扩展名
        	        System.out.println("扩展名：" + suffix);
        	        String fileName = id + suffix;
        	        System.out.println(fileName.toString());//返回文件的大小
        	    	FileItem  i = item;
        	    	File file = new File("E:\\upload\\image\\"+fileName);
        	    	p.setProductImg(fileName);
        	    	url = "http://localhost:8080/upload/image/"+fileName;
        	    	i.write(file);//写入文件
        	    	i.delete();//删除临时文件

                    }
                j++;
                }
			p.setProductId(id);
	    	p.setProductName(value[0]);
	    	p.setProductDescription(value[1]);
	    	p.setProductPrice(Double.parseDouble(value[2]));
	    	p.setProductStorage(Integer.parseInt(value[3]));
	    	p.setProductParameter(value[4]);
	    	p.setProductType(Short.parseShort(value[5]));
	    	p.setProductDate(date);
	    	p.setProductSell(0);
	    	flag = product.add(p);
	    	
	    	if(flag==true)
	    	{
	    		img = "success.png";
	    		tips = "添加成功";
	    	}
	    	else
	    	{
	    		img = "fail.png";
	    		tips = "添加失败";
	    	}
	    	System.out.println(img);
	    	System.out.println(tips);

	    	//输出响应
			response.setContentType("text/html;charset=GBK");
			response.setCharacterEncoding("utf-8");
			text = text1+tips+text2+img+text3+"<script type=\"text/javascript\">window.parent.removeAll();window.parent.landing();</script></html>";
			System.out.println(text);
			response.getWriter().println(text);
	    	

	    	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setContentType("text/html;charset=GBK");
			response.setCharacterEncoding("utf-8");
			text = text1+tips+text2+img+text3+"</html>";
			response.getWriter().println(text);
		} 
	    

		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

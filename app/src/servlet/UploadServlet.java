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
		 // 1. ����DiskFileItemFactory�������û�������С����ʱ�ļ�Ŀ¼ 
	    DiskFileItemFactory factory = new DiskFileItemFactory(); 
	    // System.out.println(System.getProperty("java.io.tmpdir"));//Ĭ����ʱ�ļ��� 
	    // 2. ����ServletFileUpload���󣬲������ϴ��ļ��Ĵ�С���ơ� 
	    ServletFileUpload sfu = new ServletFileUpload(factory); 
	    sfu.setSizeMax(10 * 1024 * 1024);// ��byteΪ��λ ���ܳ���10M 1024byte = 
	             // 1kb 1024kb=1M 1024M = 1G 
	    sfu.setHeaderEncoding("utf-8");
	    
		ProductID k = new ProductID();
		String id = k.getProductID();
		boolean flag;
		String tips= "���ʧ��";
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
				+	"<p align=\"center\">Apple��ʾ�㣺";
		text2="<img src=\"/app/icon/";
		text3=	"\" alt=\"\" height=\"30px\" width=\"30px\"/></p>"
				+	"<br/>"
				+ "<div style=\"float:left;padding-left:80px;padding-top:60px;\"><a style=\"color:#333\" href=\"javascript:history.go(-1);\"><b><<����<b></a></div>"
				+ "<div style=\"float:right;padding-right:80px;padding-top:60px;\"><a style=\"color:#333\" href=\"javascript:window.parent.zDiag.close();\"><b>�ر�</b></a></div>"
				+ "</body>";
		

		
		String value[] = new String[6];

		
		Date date = new Date();
		
		ProductService product = (ProductService) getCtx().getBean("productService");
		
	    try {
	    	
	    	List<FileItem>  f = sfu.parseRequest(request);
	    	int l = f.size()-1;
	    	System.out.println(f.size());//���� �ļ������ļ�·��
	    	System.out.println(f.get(l).getName());//���� �ļ������ļ�·��
	    	System.out.println(f.get(l).getFieldName());//���ر��е�name����
	    	System.out.println(f.get(l).getContentType());//�����ļ��� ����
	    	System.out.println(f.get(l).getSize());//�����ļ��Ĵ�С

	    	String url = "";
	    	
	    	
	    	int j=0;
			  	
	    	for(FileItem item : f)
	    	{
                //���fileitem�з�װ������ͨ�����������
                if(item.isFormField()){
                    //String name = item.getFieldName();
                    //�����ͨ����������ݵ�������������
                    value[j] = item.getString("UTF-8");
                    //value = new String(value.getBytes("iso8859-1"),"UTF-8");
                    
                }else{
                	//���fileitem�з�װ�����ϴ��ļ�
                    //�õ��ϴ����ļ����ƣ�
        	    	System.out.println("�ļ�����" + item.getName());
        	        String suffix = item.getName().substring(f.get(l).getName().lastIndexOf('.')); //��ȡ��չ��
        	        System.out.println("��չ����" + suffix);
        	        String fileName = id + suffix;
        	        System.out.println(fileName.toString());//�����ļ��Ĵ�С
        	    	FileItem  i = item;
        	    	File file = new File("E:\\upload\\image\\"+fileName);
        	    	p.setProductImg(fileName);
        	    	url = "http://localhost:8080/upload/image/"+fileName;
        	    	i.write(file);//д���ļ�
        	    	i.delete();//ɾ����ʱ�ļ�

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
	    		tips = "��ӳɹ�";
	    	}
	    	else
	    	{
	    		img = "fail.png";
	    		tips = "���ʧ��";
	    	}
	    	System.out.println(img);
	    	System.out.println(tips);

	    	//�����Ӧ
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

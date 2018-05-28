package random;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.hibernate.Query;

import db.DBManager;

public class ProductID {
	
	DBManager db = new DBManager();
	
	//检验所生成的产品ID是否已经存在
	public boolean existProductID(String id)
	{
	
		Query query = db.getSession().createQuery("from OrderProduct where product_id=?");
		query.setString(0, id);
		List list = query.list();
		db.closeSession();
		if(list.size()>0)//判断用户ID是否存在
		{
			System.out.print("该产品ID已存在！");
			return true;//存在返回true
		}
		else 
			return false;
	}
	
	public String getProductID()
	{
		String id=RandomStringUtils.randomAlphanumeric(12);
		while(existProductID(id))//直到该产品ID不存在
		{
			id=RandomStringUtils.randomAlphanumeric(12);
		}
		return id;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductID id = new ProductID();
		String ID = id.getProductID();
		System.out.print(ID.toString());
	}

}

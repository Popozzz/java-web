package random;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.hibernate.Query;

import db.DBManager;

public class OrderID {
	
	DBManager db = new DBManager();
	
	//检验所生成的用户ID是否已经存在
	public boolean existOrderID(String id)
	{
	
		Query query = db.getSession().createQuery("from OrderDetails where order_id=?");
		query.setString(0, id);
		List list = query.list();
		db.closeSession();
		if(list.size()>0)//判断用户ID是否存在
		{
			System.out.print("该订单ID已存在！");
			return true;//存在返回true
		}
		else 
			return false;
	}
	
	public String getOrderID()
	{
		String id=RandomStringUtils.randomAlphanumeric(16);
		while(existOrderID(id))//直到该产品ID不存在
		{
			id=RandomStringUtils.randomAlphanumeric(16);
		}
		return id;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrderID id = new OrderID();
		String ID = id.getOrderID();
		System.out.print(ID.toString());
	}

}

package random;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.etspace.abc.factory.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;

import db.DBManager;

//ID生成器
public class UserID {
	
	
	DBManager db = new DBManager();
	
	//检验所生成的用户ID是否已经存在
	public boolean existUserID(String id)
	{
	
		Query query = db.getSession().createQuery("from Customer where customer_id=?");
		query.setString(0, id);
		List list = query.list();
		db.closeSession();
		if(list.size()>0)//判断用户ID是否存在
		{
			System.out.print("该用户ID已存在！");
			return true;//存在返回true
		}
		else 
			return false;
	}
	
	public String getUserID()
	{
		String id=RandomStringUtils.randomAlphanumeric(12);
		while(existUserID(id))//直到该用户ID不存在
		{
			id=RandomStringUtils.randomAlphanumeric(12);
		}
		return id;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserID id = new UserID();
		String ID = id.getUserID();
		System.out.print(ID.toString());
	}

}

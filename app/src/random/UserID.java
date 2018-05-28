package random;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.etspace.abc.factory.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;

import db.DBManager;

//ID������
public class UserID {
	
	
	DBManager db = new DBManager();
	
	//���������ɵ��û�ID�Ƿ��Ѿ�����
	public boolean existUserID(String id)
	{
	
		Query query = db.getSession().createQuery("from Customer where customer_id=?");
		query.setString(0, id);
		List list = query.list();
		db.closeSession();
		if(list.size()>0)//�ж��û�ID�Ƿ����
		{
			System.out.print("���û�ID�Ѵ��ڣ�");
			return true;//���ڷ���true
		}
		else 
			return false;
	}
	
	public String getUserID()
	{
		String id=RandomStringUtils.randomAlphanumeric(12);
		while(existUserID(id))//ֱ�����û�ID������
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

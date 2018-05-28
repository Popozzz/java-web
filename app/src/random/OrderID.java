package random;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.hibernate.Query;

import db.DBManager;

public class OrderID {
	
	DBManager db = new DBManager();
	
	//���������ɵ��û�ID�Ƿ��Ѿ�����
	public boolean existOrderID(String id)
	{
	
		Query query = db.getSession().createQuery("from OrderDetails where order_id=?");
		query.setString(0, id);
		List list = query.list();
		db.closeSession();
		if(list.size()>0)//�ж��û�ID�Ƿ����
		{
			System.out.print("�ö���ID�Ѵ��ڣ�");
			return true;//���ڷ���true
		}
		else 
			return false;
	}
	
	public String getOrderID()
	{
		String id=RandomStringUtils.randomAlphanumeric(16);
		while(existOrderID(id))//ֱ���ò�ƷID������
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

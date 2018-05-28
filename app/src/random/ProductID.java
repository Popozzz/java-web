package random;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.hibernate.Query;

import db.DBManager;

public class ProductID {
	
	DBManager db = new DBManager();
	
	//���������ɵĲ�ƷID�Ƿ��Ѿ�����
	public boolean existProductID(String id)
	{
	
		Query query = db.getSession().createQuery("from OrderProduct where product_id=?");
		query.setString(0, id);
		List list = query.list();
		db.closeSession();
		if(list.size()>0)//�ж��û�ID�Ƿ����
		{
			System.out.print("�ò�ƷID�Ѵ��ڣ�");
			return true;//���ڷ���true
		}
		else 
			return false;
	}
	
	public String getProductID()
	{
		String id=RandomStringUtils.randomAlphanumeric(12);
		while(existProductID(id))//ֱ���ò�ƷID������
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

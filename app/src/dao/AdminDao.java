package dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;

import db.DBManager;

public class AdminDao implements IAdminDao{
	
	Session mySession;
	DBManager db = new DBManager();
	
	public boolean existAdmin(String name,String pass)
	{
		Query query = db.getSession().createQuery("from Admin where admin_id=? and admin_password=?");
		query.setString(0, name);
		query.setString(1, pass);
		List list = db.query(query);
		db.closeSession();
		if(list.size()==0)//����ʧ��
		{
			System.out.println("�ù���Ա�����ڣ���¼ʧ�ܣ�");
			
			return false;
		}
		System.out.println("�ù���Ա���ڣ���¼�ɹ���");
		return true;
		
		
	}
	
	public void admin()
	{
		Query query = db.getSession().createQuery("select adminId,adminPassword from Admin where admin_id='Popo'");
		List list = db.query(query);
		System.out.println(list.size());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AdminDao a = new AdminDao();
		a.existAdmin("Popo", "15251104140");
		//AdminDao a = new AdminDao();
		//a.admin();
		
	}

}

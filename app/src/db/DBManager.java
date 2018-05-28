package db;

import java.sql.*;
import java.util.List;

import org.etspace.abc.factory.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
/*
 * �������ݿ�
 */
public class DBManager {
	
	//��session
	public Session getSession()
	{
		Session mySession = HibernateSessionFactory.getSession();
		//System.out.println("oo"+mySession.toString());
		return mySession;
	}
	
	//������ݣ����浽���ݿ�
	public boolean save(Object c,Session mySession)
	{
		Transaction myTransaction = mySession.beginTransaction();
		System.out.println(c.getClass());
		try{		
		mySession.save(c);//����
		mySession.flush();  
		myTransaction.commit();//�����ύ
		}
		catch(Exception e)
		{
			if(myTransaction!=null)
			{
				myTransaction.rollback();
			}
			System.out.print(e.toString());
			return false;//���浽���ݿ�ʧ�ܣ�����ع�
		}
		return true;
		
		
	}
	
	//��ѯ���ݿ�
	public List query(Query query)
	{
		List list = query.list();
		return list;
	}
	
	//�޸ĺ�ɾ�����ݣ����浽���ݿ�
	public boolean update(Query query,Session mySession)
	{
		Transaction myTransaction = mySession.beginTransaction();
		try
		{
			query.executeUpdate();
			myTransaction.commit();//�����ύ
		}
		catch(Exception e)
		{
			if(myTransaction!=null)
			{
				myTransaction.rollback();
			}
			System.out.print(e.toString());
			return false;//���浽���ݿ�ʧ�ܣ�����ع�
		}
		return true;

	}
	
	//�ر�session
	public void closeSession()
	{
		HibernateSessionFactory.closeSession();
	}
	
}
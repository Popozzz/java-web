package db;

import java.sql.*;
import java.util.List;

import org.etspace.abc.factory.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
/*
 * 连接数据库
 */
public class DBManager {
	
	//打开session
	public Session getSession()
	{
		Session mySession = HibernateSessionFactory.getSession();
		//System.out.println("oo"+mySession.toString());
		return mySession;
	}
	
	//添加数据，保存到数据库
	public boolean save(Object c,Session mySession)
	{
		Transaction myTransaction = mySession.beginTransaction();
		System.out.println(c.getClass());
		try{		
		mySession.save(c);//保存
		mySession.flush();  
		myTransaction.commit();//事物提交
		}
		catch(Exception e)
		{
			if(myTransaction!=null)
			{
				myTransaction.rollback();
			}
			System.out.print(e.toString());
			return false;//保存到数据库失败，事物回滚
		}
		return true;
		
		
	}
	
	//查询数据库
	public List query(Query query)
	{
		List list = query.list();
		return list;
	}
	
	//修改和删除数据，保存到数据库
	public boolean update(Query query,Session mySession)
	{
		Transaction myTransaction = mySession.beginTransaction();
		try
		{
			query.executeUpdate();
			myTransaction.commit();//事物提交
		}
		catch(Exception e)
		{
			if(myTransaction!=null)
			{
				myTransaction.rollback();
			}
			System.out.print(e.toString());
			return false;//保存到数据库失败，事物回滚
		}
		return true;

	}
	
	//关闭session
	public void closeSession()
	{
		HibernateSessionFactory.closeSession();
	}
	
}
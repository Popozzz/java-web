package dao;

import java.util.List;

import org.etspace.abc.vo.OrderProduct;

import org.hibernate.Query;
import org.hibernate.Session;

import db.DBManager;

public class OrderProductDao implements IOrderProductDao{
	
	Session mySession;
	DBManager db = new DBManager();
	boolean flag;
	
	//��Ӷ���
	public boolean addOrderProduct(OrderProduct op)
	{
		mySession = db.getSession();
		flag = db.save(op,mySession);
		db.closeSession();
		if(flag==false)
		{
			System.out.println("��Ӳ�Ʒ���������ݿ�ʧ�ܣ�");
			return false;
		}
		System.out.println("��Ӳ�Ʒ�����ɹ���");
		return true;
	}
	
	
	//�鿴���������в�Ʒ
	public List<OrderProduct> getAllOrderProduct(String oid)
	{
		mySession = db.getSession();
		Query query = mySession.createQuery("from OrderProduct where order_id=?");
		query.setString(0, oid);
		List<OrderProduct> list = db.query(query);
		
		db.closeSession();
		return list;
	}
	
	public boolean deleteOrderProduct(String oid)
	{
		mySession = db.getSession();
		Query query = mySession.createQuery("delete OrderProduct where order_id=?");
		query.setString(0, oid);
		flag = db.update(query, mySession);
		return flag;
	}

}

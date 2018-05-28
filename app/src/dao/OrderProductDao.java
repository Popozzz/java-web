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
	
	//添加订单
	public boolean addOrderProduct(OrderProduct op)
	{
		mySession = db.getSession();
		flag = db.save(op,mySession);
		db.closeSession();
		if(flag==false)
		{
			System.out.println("添加产品订单到数据库失败！");
			return false;
		}
		System.out.println("添加产品订单成功！");
		return true;
	}
	
	
	//查看订单的所有产品
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

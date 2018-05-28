package dao;

import java.util.ArrayList;
import java.util.List;

import org.etspace.abc.vo.Product;
import org.hibernate.Query;
import org.hibernate.Session;

import db.DBManager;


public class ProductDao implements IProductDao{
	
	Session mySession;
	DBManager db = new DBManager();
	boolean flag;
	
	//添加产品
	public boolean addProduct(Product p)
	{
		mySession = db.getSession();
		flag = db.save(p,mySession);//保存到数据库
		db.closeSession();
		if(flag == false)
		{
			System.out.println("添加产品到数据库失败！");
			return false;
		}
		System.out.println("添加产品成功！");
		return true;		
	}
	
	//修改产品
	public boolean changeProduct(String description,double price,int storage,String parameter,String id)
	{
		mySession = db.getSession();
		System.out.println("修改中....");
		
		Query query = mySession.createQuery("update Product set product_description=?,product_price=?,product_storage=?,product_parameter=? where product_id=?");
		query.setString(0, description);
		query.setDouble(1, price);
		query.setInteger(2, storage);
		query.setString(3, parameter);
		query.setString(4, id);
		flag = db.update(query, mySession);
		if(flag==true)
		{
			System.out.println("修改产品成功！");
		}
		else
		{
			System.out.println("修改产品失败！");
		}
		
		return flag;
	}
	
	//删除产品
	public boolean deleteProduct(String id)
	{
		mySession = db.getSession();
		System.out.println("id="+id);
		Query query = mySession.createQuery("delete Shoppingcart where product_id=?");
		query.setString(0, id);
		flag = db.update(query,mySession);
		
		query = mySession.createQuery("delete Product where product_id=?");
		query.setString(0, id);
		flag = db.update(query,mySession);
		db.closeSession();
		if(flag == false)
		{
			System.out.println("从数据库删除产品失败！");
			return false;
		}
		System.out.println("删除产品成功！");
		return true;
		
	}
	
	//关键字搜索产品
	public List<Product> findKeyProduct(String keyWord)
	{
		mySession = db.getSession();
		//数据库查找产品
		Query query = mySession.createQuery("from Product where product_name like ? order by product_name");//模糊查询
		keyWord = "%" + keyWord +"%";
		query.setString(0, keyWord);
		List<Product> list = db.query(query);
		System.out.println(list.size());
		System.out.println("获取关键字产品成功");
		db.closeSession();
		return list;
		
	}
	
	//分类搜索产品
	public List<Product> findTypeProduct(Short type) 
	{
		mySession = db.getSession();
		//数据库查找产品
		Query query = mySession.createQuery("from Product where product_type=?");
		query.setShort(0, type);
		List<Product> list = db.query(query);
		
		db.closeSession();
		return list;
	}
	
	//购买产品，产品库存和销量变化
	public boolean buyProduct(Product p,int number) 
	{
		
		mySession = db.getSession();
		Query query = mySession.createQuery("update Product set product_storage=?,product_sell=? where product_id=?");
		query.setInteger(0,p.getProductStorage()-number );
		query.setInteger(1, p.getProductSell()+number);
		query.setString(2, p.getProductId());
		flag = db.update(query, mySession);
		db.closeSession();
		if(flag == false)
		{
			System.out.println("产品库存销量更新失败！");
			return false;
		}
		System.out.println("产品库存销量更新成功！");
		return true;

	}
	
	//查看所有产品
	public List<Product> getAllProduct()
	{
		mySession = db.getSession();

		//数据库查找产品
		Query query = mySession.createQuery("from Product order by product_type,product_name");
		List<Product> list = db.query(query);
		System.out.println("获取所有产品成功！");
		db.closeSession();
		return list;
	}
	
	//查看单个产品
	public Product getProduct(String id)
	{
		mySession = db.getSession();
		//数据库查找产品
		Query query = mySession.createQuery("from Product where product_id=?");
		query.setString(0, id);
		List<Product> list = db.query(query);
		System.out.println(list.size());
		db.closeSession();
		Product p = list.get(0);
		System.out.println(p.getProductId());
		return p;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		ProductDao p = new ProductDao();
		List<Product> list = p.getAllProduct();
		System.out.println(list.get(0).getProductDescription());*/
		
		/*模糊查询
		ProductDao p = new ProductDao();
		String key = "i";
		List<Product> list = p.findKeyProduct(key);
		System.out.println(list.get(0).getProductName());*/
		
		/*查找类型产品
		ProductDao p = new ProductDao();
		int i = 1;
		List<Product> list = p.findTypeProduct(i);
		System.out.println(list.get(0).getProductName());*/
		/*得到单个产品
		ProductDao p = new ProductDao();
		String id = "0MxKY22e2cUr";
		Product q = p.getProduct(id);
		System.out.println(q.getProductId());*/
		ProductDao p = new ProductDao();
		List<Product> list = p.getAllProduct();
		System.out.println(list.size());
		System.out.println(list.get(0).getProductDescription());
		
		
	}

}

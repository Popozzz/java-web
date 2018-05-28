package service;

import java.util.List;

import org.etspace.abc.vo.Product;

import dao.IProductDao;

public class ProductService implements IProductService{
	
	private IProductDao productDao;
	
	public void setProductDao(IProductDao productDao)
	{
		this.productDao = productDao;
	}
	
	//添加产品
	public boolean add(Product p)
	{
		return productDao.addProduct(p);
	}
	
	//修改产品
	public boolean change(String description,double price,int storage,String parameter,String id)
	{
		return productDao.changeProduct(description,price,storage,parameter,id);
	}
	
	//删除产品
	public boolean delete(String id)
	{
		return productDao.deleteProduct(id);
	}
	
	
	//关键字搜索产品
	public List<Product> findKey(String keyWord)
	{
		return productDao.findKeyProduct(keyWord);
	}
	
	//分类搜索产品
	public List<Product> findType(Short type)
	{
		return productDao.findTypeProduct(type);
	}
	
	//购买产品
	public boolean buy(Product p,int number)
	{
		return productDao.buyProduct(p, number);
	}
	
	//查看所有产品
	public List<Product> getAll()
	{
		return productDao.getAllProduct();
	}
	
	//查看单个产品
	public Product getOne(String id)
	{
		return productDao.getProduct(id);
	}

}

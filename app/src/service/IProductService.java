package service;

import java.util.List;

import org.etspace.abc.vo.Product;

public interface IProductService {
	
	//添加产品
	public boolean add(Product p);
	
	//修改产品
	public boolean change(String description,double price,int storage,String parameter,String id);
	
	//删除产品
	public boolean delete(String id);
	
	
	//关键字搜索产品
	public List<Product> findKey(String keyWord);
	//分类搜索产品
	public List<Product> findType(Short type);
	
	//购买产品
	public boolean buy(Product p,int number);
	//查看所有产品
	public List<Product> getAll();
	
	//查看单个产品
	public Product getOne(String id);

}

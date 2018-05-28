package dao;

import java.util.List;

import org.etspace.abc.vo.Product;

public interface IProductDao {
	
	//添加产品
	public boolean addProduct(Product p);
	
	//修改产品
	public boolean changeProduct(String description,double price,int storage,String parameter,String id);
	
	//删除产品
	public boolean deleteProduct(String id);
	
	
	//关键字搜索产品
	public List<Product> findKeyProduct(String keyWord);
	//分类搜索产品
	public List<Product> findTypeProduct(Short type);
	
	//购买产品
	public boolean buyProduct(Product p,int number);
	//查看所有产品
	public List<Product> getAllProduct();
	
	//查看单个产品
	public Product getProduct(String id);
	

}

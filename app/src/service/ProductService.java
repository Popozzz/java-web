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
	
	//��Ӳ�Ʒ
	public boolean add(Product p)
	{
		return productDao.addProduct(p);
	}
	
	//�޸Ĳ�Ʒ
	public boolean change(String description,double price,int storage,String parameter,String id)
	{
		return productDao.changeProduct(description,price,storage,parameter,id);
	}
	
	//ɾ����Ʒ
	public boolean delete(String id)
	{
		return productDao.deleteProduct(id);
	}
	
	
	//�ؼ���������Ʒ
	public List<Product> findKey(String keyWord)
	{
		return productDao.findKeyProduct(keyWord);
	}
	
	//����������Ʒ
	public List<Product> findType(Short type)
	{
		return productDao.findTypeProduct(type);
	}
	
	//�����Ʒ
	public boolean buy(Product p,int number)
	{
		return productDao.buyProduct(p, number);
	}
	
	//�鿴���в�Ʒ
	public List<Product> getAll()
	{
		return productDao.getAllProduct();
	}
	
	//�鿴������Ʒ
	public Product getOne(String id)
	{
		return productDao.getProduct(id);
	}

}

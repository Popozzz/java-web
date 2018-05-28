package dao;

import java.util.List;

import org.etspace.abc.vo.Product;

public interface IProductDao {
	
	//��Ӳ�Ʒ
	public boolean addProduct(Product p);
	
	//�޸Ĳ�Ʒ
	public boolean changeProduct(String description,double price,int storage,String parameter,String id);
	
	//ɾ����Ʒ
	public boolean deleteProduct(String id);
	
	
	//�ؼ���������Ʒ
	public List<Product> findKeyProduct(String keyWord);
	//����������Ʒ
	public List<Product> findTypeProduct(Short type);
	
	//�����Ʒ
	public boolean buyProduct(Product p,int number);
	//�鿴���в�Ʒ
	public List<Product> getAllProduct();
	
	//�鿴������Ʒ
	public Product getProduct(String id);
	

}

package service;

import java.util.List;

import org.etspace.abc.vo.Product;

public interface IProductService {
	
	//��Ӳ�Ʒ
	public boolean add(Product p);
	
	//�޸Ĳ�Ʒ
	public boolean change(String description,double price,int storage,String parameter,String id);
	
	//ɾ����Ʒ
	public boolean delete(String id);
	
	
	//�ؼ���������Ʒ
	public List<Product> findKey(String keyWord);
	//����������Ʒ
	public List<Product> findType(Short type);
	
	//�����Ʒ
	public boolean buy(Product p,int number);
	//�鿴���в�Ʒ
	public List<Product> getAll();
	
	//�鿴������Ʒ
	public Product getOne(String id);

}

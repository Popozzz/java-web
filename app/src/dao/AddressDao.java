package dao;

import java.util.List;

import org.etspace.abc.vo.Address;
import org.etspace.abc.vo.AddressId;
import org.etspace.abc.vo.Customer;
import org.hibernate.Query;
import org.hibernate.Session;

import db.DBManager;

public class AddressDao implements IAddressDao{
	
	Session mySession;
	DBManager db = new DBManager();
	boolean flag;
	
	//��ӵ�ַ
	public boolean addAddress(Address d)
	{
		
		AddressId b = d.getId();
		mySession = db.getSession();
		
		Query query = mySession.createQuery("from Address where customer_id=?");
		query.setString(0, d.getId().getCustomer().getCustomerId());
		List<Address> list = db.query(query);
		short order = (short) (list.size()+1);
		
		b.setAddressId(order);
		d.setId(b);
		flag = db.save(d,mySession);
		
		query = mySession.createQuery("update Customer set customer_sum=? where customer_id=?");
		query.setShort(0,order);
		query.setString(1,d.getId().getCustomer().getCustomerId());
		db.update(query, mySession);
		
		db.closeSession();
		if(flag == false)
		{
			System.out.println("��ӵ�ַ�����ݿ�ʧ�ܣ�");
			return false;
		}
		System.out.println("��ӵ�ַ�����ݿ�ɹ���");
		return true;
		
	}
	
	//�޸ĵ�ַ
	public boolean changeAddress(Address d)
	{
		
		mySession = db.getSession();
		Query query = mySession.createQuery("update Address set customer_name=?,customer_phone=?,customer_address=? where customer_id=? and address_id=?");
		query.setString(0, d.getCustomerName());
		query.setString(1, d.getCustomerPhone());
		query.setString(2, d.getCustomerAddress());
		query.setString(3, d.getId().getCustomer().getCustomerId());
		query.setShort(4, d.getId().getAddressId());
		flag = db.update(query, mySession);
		db.closeSession();
		if(flag==false)
		{
			System.out.println("�޸ĵ�ַ�����ݿ�ʧ�ܣ�");
			return false;
		}
		System.out.println("�޸ĵ�ַ�����ݿ�ɹ���");
		return true;
		
		
		
	}
	
	//ɾ����ַ
	public boolean deleteAddress(String id,Short address)
	{
		mySession = db.getSession();
		Query query = mySession.createQuery("delete Address where customer_id=? and address_id=?");
		query.setString(0, id);
		query.setShort(1, address);
		flag = db.update(query,mySession);
		
		if(flag == false)
		{
			System.out.println("�����ݿ�ɾ����ַʧ�ܣ�");
			return false;
		}
		query = mySession.createQuery("update Address set address_id=address_id-1 where customer_id=? and address_id>?");
		query.setString(0,id);
		query.setShort(1, address);
		flag = db.update(query,mySession);
		
		query = mySession.createQuery("update Customer set customer_sum=customer_sum-1 where customer_id=?");
		query.setString(0,id);
		db.update(query, mySession);
		
		db.closeSession();
		
		System.out.println("ɾ����ַ�ɹ���");
		return true;
		
	}
	
	//���ȫ����ַ
	public List<Address> getAllAddress(String id)
	{
		mySession = db.getSession();
		
		Query query = mySession.createQuery("from Address where customer_id=?");
		query.setString(0, id);
		List<Address> list = db.query(query);
		db.closeSession();

		return list;
	}
	
	//��õ�һ��ַ
	public Address getOneAddress(String id,Short order)
	{
		mySession = db.getSession();
		
		Query query = mySession.createQuery("from Address where customer_id=? and address_id=?");
		query.setString(0, id);
		query.setShort(1, order);
		List<Address> list = db.query(query);
		db.closeSession();
		System.out.println(list.get(0).getCustomerAddress());
		if(list.size()>0)
		{
			return list.get(0);
		}
		else 
			return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*������ӵ�ַ
		AddressDao dao = new AddressDao();
		Address d = new Address();
		Customer c = new Customer();
		AddressId a = new AddressId();
		c.setCustomerId("h1jk2b2ozd8A");
		a.setCustomer(c);

		d.setId(a);
		d.setCustomerName("zwh");
		d.setCustomerPhone("910069169");
		d.setCustomerAddress("������ѧ");
		dao.addAddress(d);*/
		
		//�����޸ĵ�ַ
		AddressDao dao = new AddressDao();
		Address d = new Address();
		Customer c = new Customer();
		AddressId a = new AddressId();
		c.setCustomerId("h1jk2b2ozd8A");
		a.setCustomer(c);
		short i = 2;
		a.setAddressId(i);
		d.setId(a);
		d.setCustomerName("zwh");
		d.setCustomerPhone("910069169");
		d.setCustomerAddress("�����ѧ");
		dao.changeAddress(d);
		
		/*����ɾ����ַ
		AddressDao dao = new AddressDao();
		String id = "h1jk2b2ozd8A";
		short order = 2;
		dao.deleteAddress(id, order);*/
		
		/*���Ի��ȫ����ַ
		AddressDao dao = new AddressDao();
		String id = "h1jk2b2ozd8A";
				
		List<Address> list = dao.getAllAddress(id);
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getCustomerName());
		}*/
		/*���Եõ�һ����ַ
		AddressDao dao = new AddressDao();
		String id = "h1jk2b2ozd8A";
				
		Address a = dao.getOneAddress(id,Short.valueOf("1"));
		System.out.println(a.getCustomerAddress());*/
		
		
		
		
		
		
	}

}

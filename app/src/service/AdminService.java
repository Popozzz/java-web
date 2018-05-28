package service;

import dao.IAdminDao;


public class AdminService implements IAdminService{
	
	private IAdminDao adminDao;
	
	
	public void setAdminDao(IAdminDao adminDao)
	{
		this.adminDao = adminDao;
	}
	
	public boolean exist(String name,String pass)
	{
		
		return adminDao.existAdmin(name, pass);
	}

}

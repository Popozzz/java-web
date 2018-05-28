package dao;

public interface IAdminDao {
	
	//验证管理员（用于登录）
	public boolean existAdmin(String name,String pass);

}

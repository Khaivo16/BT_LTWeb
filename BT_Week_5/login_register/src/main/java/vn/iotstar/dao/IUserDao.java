package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.UserModel;

public interface IUserDao {
	
	List<UserModel> findAll();
	
	UserModel findById(int id);
	
	void insert(UserModel user);
	
	UserModel UpdateByUser(String user, String fullname, String phone);
	
	void UpdatePswbyUser(String user,String psw);
	
	boolean CheckEmailExist(String Email);
	
	boolean CheckEmailDuplicate(String Email,String user);
	
	boolean CheckUserExist(String User);
	
	UserModel findbyUser(String User); 
	
}

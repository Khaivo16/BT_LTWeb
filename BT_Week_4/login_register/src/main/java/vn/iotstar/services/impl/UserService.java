package vn.iotstar.services.impl;

import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;

public class UserService implements IUserService {
	UserDaoImpl userDao = new UserDaoImpl();
	@Override
	public UserModel login(String username, String password) {
		
		UserModel user = this.findbyUser(username);
		 
		if (user != null && password.equals(user.getPassword())) {
			 return user;
		 }
		 return null;
	}

	public UserModel findbyUser(String username) {
		// TODO Auto-generated method stub
		return userDao.findbyUser(username);
	}



	
}

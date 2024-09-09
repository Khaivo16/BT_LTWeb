package vn.iotstar.services.impl;

import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;

public class UserService implements IUserService {

	@Override
	public String login(String username, String password) {
		// TODO Auto-generated method stub
		UserDaoImpl userDao = new UserDaoImpl();
		UserModel user = userDao.findbyUser(username);
		if (user == null) {
			return "khong co thong tin tai khoan";
		}
		else if (password.equals(user.getPassword())) {
			
			return "Hello" + " " + username ;
		}
		return "sai mat khau";
	}

	@Override
	public UserModel get(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

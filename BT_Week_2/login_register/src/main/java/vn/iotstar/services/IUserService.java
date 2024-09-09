package vn.iotstar.services;

import vn.iotstar.models.UserModel;

public interface IUserService {
	String login(String username, String password);
	UserModel get(String username);
}

package service.impl;

import java.util.Map;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import service.UserService;

public class UserServiceImpl implements UserService {

	private UserDAO udao = new UserDAOImpl();

	@Override
	public int insertUser(Map<String, String> user) {
		return udao.insertUser(user);
	}

	@Override
	public boolean loginUser(Map<String, String> login) {

		if (udao.selectUserByID(login).get("uiId").equals(login.get("uiId"))) {
			if(udao.selectUserByID(login).get("uiPwd").equals(login.get("uiPwd"))) {
				return true;
			}
		}
		return false;
	}

}

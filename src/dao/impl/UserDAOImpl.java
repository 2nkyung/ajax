package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import dao.UserDAO;
import db.DBCon;

public class UserDAOImpl implements UserDAO {

	private String insertUser = "insert into user_info"
	+ " (ui_num, ui_name, ui_id, ui_pwd, ui_email)"
	+ " values(seq_ui_num.nextval,?,?,?,?)";

	
	private String selectUserByID = "select ui_id, ui_pwd from user_info where ui_id=?";
	
	
	@Override
	public int insertUser(Map<String, String> user) {
	try {
		PreparedStatement ps = DBCon.getCon().prepareStatement(insertUser);
		ps.setString(1, user.get("uiName"));
		ps.setString(2, user.get("uiId"));
		ps.setString(3, user.get("uiPwd"));
		ps.setString(4, user.get("uiEmail"));
		return ps.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return 0;
	}

	@Override
	public Map<String,String> selectUserByID(Map<String, String> login) {
		try {
			PreparedStatement ps = DBCon.getCon().prepareStatement(selectUserByID);
			ps.setString(1, login.get("uiId"));
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Map<String,String> user = new HashMap<>();
				user.put("uiId", rs.getString("ui_id"));
				user.put("uiPwd", rs.getString("ui_pwd"));
				return user;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}

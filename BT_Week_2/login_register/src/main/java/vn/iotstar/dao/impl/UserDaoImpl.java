package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.DBConnectMySQL;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.models.UserModel;

public class UserDaoImpl extends DBConnectMySQL implements IUserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	public PreparedStatement findMissingIdStmt = null;

	@Override
	public List<UserModel> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from ltwebt5";
		List<UserModel> list = new ArrayList<>();

		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new UserModel(rs.getInt("id"), rs.getString("user"), rs.getString("email"),
						rs.getString("fullname"), rs.getString("image"), rs.getString("password")));

			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserModel findById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from ltwebt5 WHERE id = ?";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				return new UserModel(rs.getInt("id"), rs.getString("user"), rs.getString("email"),
						rs.getString("fullname"), rs.getString("image"), rs.getString("password"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void insert(UserModel user) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO ltwebt5(id,fullname,image,user,password,email) VALUES (?,?,?,?,?,?)";

//		try {
//			conn = super.getDatabaseConnection();
//			ps = conn.prepareStatement(sql);
//			
//			ps.setInt(1,user.getId());
//			ps.setString(2,user.getFullname());
//			ps.setString(3,user.getImages());
//			ps.setString(4,user.getUsername());
//			ps.setString(5,user.getPassword());
//			ps.setString(6,user.getEmail());
//			
//			
//			ps.executeUpdate();
//			
//		}
//		catch (Exception e){
//			e.printStackTrace();
//		}
		try {
			conn = super.getDatabaseConnection();
			// Tìm và chèn dữ liệu vào ID trống
			String findMissingIdSQL = "SELECT t1.id + 1 AS missing_id " + "FROM ( " + "    SELECT id FROM ltwebt5 "
					+ "    UNION ALL " + "    SELECT 0 AS id " + ") AS t1 "
					+ "LEFT JOIN ltwebt5 t2 ON t1.id + 1 = t2.id " + "WHERE t2.id IS NULL " + "ORDER BY missing_id "
					+ "LIMIT 1;";

			findMissingIdStmt = conn.prepareStatement(findMissingIdSQL);

			ps = conn.prepareStatement(sql);
			rs = findMissingIdStmt.executeQuery();

			while (rs.next()) {
				int missingId = rs.getInt("missing_id");

				// Chèn thông tin vào ID trống
				ps.setInt(1, missingId);
				ps.setString(2, user.getFullname());
				ps.setString(3, user.getImages());
				ps.setString(4, user.getUsername());
				ps.setString(5, user.getPassword());
				ps.setString(6, user.getEmail());

				ps.executeUpdate();

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public boolean CheckEmailExist(String Email) {
		// TODO Auto-generated method stub
		boolean duplicate = false;
		String query = "select * from ltwebt5 WHERE email = ?";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, Email);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	@Override
	public boolean CheckUserExist(String User) {
		// TODO Auto-generated method stub4
		boolean duplicate = false;
		String query = "select * from ltwebt5 WHERE user = ?";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, User);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	@Override
	public UserModel findbyUser(String User) {
		// TODO Auto-generated method stub
		String sql = "select * from ltwebt5 WHERE user = ?";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, User);
			rs = ps.executeQuery();

			while (rs.next()) {
				return new UserModel(rs.getInt("id"), rs.getString("user"), rs.getString("email"),
						rs.getString("fullname"), rs.getString("image"), rs.getString("password"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

//	public static void main(String[] args) {
//
//		UserDaoImpl userDao = new UserDaoImpl();
//		String email = "1156@gmail";
//		if (userDao.CheckEmailExist(email) == true ) {
//			System.out.println("Da ton tai");
//			return;
//		}
////		userDao.insert(new UserModel("abc", "1156@gmail", "Huy","null", "123456"));
////		
////		List<UserModel> list = userDao.findAll();
////
////		for (UserModel user : list) {
////			System.out.println(user);
////		}
////		UserModel model = userDao.findById(2);
////		System.out.println(model);
//		
//	}

}

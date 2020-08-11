package kr.or.connect.jdbcexams.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import kr.or.connect.jdbcexams.dto.Role;

public class RoleDao {
	private static String dburl = "jdbc:mysql://localhost:3307/connectdb";
	private static String dbUser = "connectuser";
	private static String dbpasswd = "connect123!@#";

	public Role getRole(Integer roleId) {
		Role role = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			String sql = "SELECT description,role_id FROM role WHERE role_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, roleId);
			rs = ps.executeQuery();

			if (rs.next()) {
				String description = rs.getString(1);
				int id = rs.getInt("role_id");
				role = new Role(id, description);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return role;
	}
	
	public int addRole(Role role) {
		int insertCount = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "INSERT INTO role (role_id, description) VALUES ( ?, ? )";

		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, role.getRoleId());
			ps.setString(2, role.getDescription());

			insertCount = ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return insertCount;
	}
	
	//for jdbcExam3
	public List<Role> getRoles() {
		List<Role> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "SELECT description, role_id FROM role order by role_id desc";
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					String description = rs.getString(1);
					int id = rs.getInt("role_id");
					Role role = new Role(id, description);
					list.add(role);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
	
	// for jdbcExam4 - delete Role with given role id
	public int deleteRole(Integer roleId) {
		 int deleteCount = 0;
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
		 } catch(ClassNotFoundException e) {
			 e.printStackTrace();
		 }
		 String sql = "DELETE FROM role WHERE role_id = ?";
		 try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
					PreparedStatement ps = conn.prepareStatement(sql)) {
			 ps.setInt(1, roleId);
			 deleteCount = ps.executeUpdate();
		 }catch (Exception ex) {
			 ex.printStackTrace();
		 }
		 return deleteCount;
	}
	
	// for jdbcExam5 - update role 
	public int updateRole(Role role) {
		 int updateCount = 0;
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
		 } catch(ClassNotFoundException e) {
			 e.printStackTrace();
		 }
		 String sql = "UPDATE role set description = ? WHERE role_id = ?";
		 try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
					PreparedStatement ps = conn.prepareStatement(sql)) {
			 ps.setString(1, role.getDescription());
			 ps.setInt(2, role.getRoleId());
			 
			 updateCount = ps.executeUpdate();
		 }catch (Exception ex) {
			 ex.printStackTrace();
		 }
		 return updateCount;
	}
}
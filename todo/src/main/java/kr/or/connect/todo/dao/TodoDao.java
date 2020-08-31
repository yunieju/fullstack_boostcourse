package kr.or.connect.todo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.or.connect.todo.dto.Todo;


public class TodoDao {
	private static String dburl = "jdbc:mysql://localhost:3307/todolist";
	private static String dbUser = "connectuser";
	private static String dbpasswd = "connect123!@#";
	
	public int addTodo(Todo todo) {
		int insertCount = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "INSERT INTO todo(title, name, sequence) values(?, ?, ?)";
				
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, todo.getTitle());
			ps.setString(2, todo.getName());
			ps.setInt(3, todo.getSequence());
			
			insertCount = ps.executeUpdate();
			
		} catch(Exception ex) {
			ex.printStackTrace();
			
		}
		return insertCount;
	}
	
	public List<Todo> getTodos() {
		List<Todo> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "SELECT * FROM todo ORDER BY id";
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					long id = rs.getLong("id");
					String name = rs.getString("name");
					String regDate = rs.getString("regdate");
					int sequence = rs.getInt("sequence");
					String title = rs.getString("title");
					String type = rs.getString("type");
					
					Todo todo = new Todo(id, name, regDate, sequence, title, type);
					list.add(todo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
		

	}
	
	public int updateTodo(Todo todo) {
		int updateCount = 0;
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
		 } catch(ClassNotFoundException e) {
			 e.printStackTrace();
		 }
		 String sql = "UPDATE todo set type = ? where id = ?";
		 
		 try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
					PreparedStatement ps = conn.prepareStatement(sql)) {
			 ps.setString(1, todo.getType());
			 ps.setLong(2, todo.getId());
			 
			 updateCount = ps.executeUpdate();
		 }catch (Exception ex) {
			 ex.printStackTrace();
		 }
		 return updateCount;
	}
	
	
}

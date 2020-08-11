package kr.or.connect.jdbcexams;

import java.sql.SQLException;
import java.util.List;

import kr.or.connect.jdbcexams.dto.Role;
import kr.or.connect.jdbcexams.dao.RoleDao;



public class jdbcExam3 {
	public static void main(String[] args) {
		RoleDao dao = new RoleDao();
		List<Role> list = dao.getRoles();
		
		for(Role role: list) {
			System.out.println(role);
		}
	}

}

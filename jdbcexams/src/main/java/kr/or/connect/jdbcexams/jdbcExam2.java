package kr.or.connect.jdbcexams;

import kr.or.connect.jdbcexams.dao.RoleDao;
import kr.or.connect.jdbcexams.dto.Role;

public class jdbcExam2 {
	public static void main(String[] args) {
		int roleId = 501;
		String description = "CTO";
		
		Role role = new Role(roleId, description);
		
		RoleDao dao = new RoleDao();
		int insertCount = dao.addRole(role);

		System.out.println(insertCount);
	}
}

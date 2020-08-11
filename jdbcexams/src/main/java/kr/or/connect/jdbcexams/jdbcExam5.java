package kr.or.connect.jdbcexams;

import kr.or.connect.jdbcexams.dao.RoleDao;
import kr.or.connect.jdbcexams.dto.Role;

public class jdbcExam5 {
	public static void main(String[] args) {
		int roldId = 100;
		String description = "CEO";
		Role role = new Role(roldId, description);
		
		RoleDao dao = new RoleDao();
		int updateCount = dao.updateRole(role);
		
		System.out.println("Updated " + updateCount + " roles successfully.");
	}

}

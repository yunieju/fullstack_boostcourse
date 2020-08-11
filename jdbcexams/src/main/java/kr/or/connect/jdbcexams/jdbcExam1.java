package kr.or.connect.jdbcexams;

import kr.or.connect.jdbcexams.dao.RoleDao;
import kr.or.connect.jdbcexams.dto.Role;

public class jdbcExam1 {

	public static void main(String[] args) {
		RoleDao dao = new RoleDao();
		Role role = dao.getRole(100);
		System.out.println(role);
	}

}
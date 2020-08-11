package kr.or.connect.jdbcexams;
import kr.or.connect.jdbcexams.dao.RoleDao;
import kr.or.connect.jdbcexams.dto.Role;

public class jdbcExam4 {
	public static void main(String[] args) {
		int roldId = 501;
		RoleDao dao = new RoleDao();
		int deleteCount = dao.deleteRole(roldId);
		
		System.out.println("Deleted " + deleteCount + " roles successfully.");
	}
}

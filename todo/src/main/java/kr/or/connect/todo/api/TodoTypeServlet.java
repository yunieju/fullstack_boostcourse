package kr.or.connect.todo.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.connect.todo.dao.TodoDao;
import kr.or.connect.todo.dto.Todo;

/**
 * Servlet implementation class TodoTypeServlet
 */
@WebServlet("/type")
public class TodoTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private enum Type {
		TODO, DOING, DONE;

		private static Type[] typeList = values();

		public Type nextElement() {
			return typeList[(this.ordinal() + 1) % typeList.length];
		}
	}
	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		ObjectMapper objectMapper = new ObjectMapper();
		HashMap<String, String> map = objectMapper.readValue(request.getReader(),
				new TypeReference<HashMap<String, String>>() {});
		
		TodoDao dao = new TodoDao();
		Todo todo = new Todo();
		todo.setId(Long.parseLong(map.get("id")));
		todo.setType(Type.valueOf(map.get("type")).nextElement().toString());
		
		int updateCount= dao.updateTodo(todo);
		if (updateCount > 0) {
			out.print("Successfully update " + updateCount + " items");
			
		} else {
			out.print("Update failed");
		}
	}

}

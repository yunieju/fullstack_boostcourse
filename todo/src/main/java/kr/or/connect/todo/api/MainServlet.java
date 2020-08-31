package kr.or.connect.todo.api;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.connect.todo.dao.TodoDao;
import kr.or.connect.todo.dto.Todo;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public enum Type {
		TODO, DOING, DONE;
	}
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TodoDao dao = new TodoDao();

		Map<String, List<Todo>> list = dao.getTodos().stream().collect(Collectors.groupingBy(Todo::getType));
		for (Type type : Type.values()) {
			request.setAttribute(type.toString(), list.get(type.toString()));
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("main.jsp");
		requestDispatcher.forward(request, response);
	}
	
}

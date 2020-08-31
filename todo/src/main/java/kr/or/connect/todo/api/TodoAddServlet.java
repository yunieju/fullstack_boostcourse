package kr.or.connect.todo.api;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.or.connect.todo.dto.Todo;
import kr.or.connect.todo.dao.TodoDao;


/**
 * Servlet implementation class TodoAddServlet
 */
@WebServlet("/addnew")
public class TodoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		Todo todo = new Todo();
		todo.setTitle(request.getParameter("new_title"));
		todo.setName(request.getParameter("new_name"));
		todo.setSequence(Integer.parseInt(request.getParameter("new_sequence")));
		
		TodoDao dao = new TodoDao();
		dao.addTodo(todo);
		response.sendRedirect("main");
		
		
	}

}

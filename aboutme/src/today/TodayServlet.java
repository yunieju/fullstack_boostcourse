package today;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TodayServlet
 */
@WebServlet("/today")
public class TodayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utp-8");
		PrintWriter out = response.getWriter();
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        
        
        out.println("<html>");
		out.println("<head><title>form</title></head>");
		out.println("<body>");
		out.println("<a href='http://localhost:8080/index.html'> Home</a><br><br><br><br><br><br>");
		
		out.print("<h1>Current time is " + dateTime +"</h1>");
		out.println("</body>");
		out.println("</html>");
	}
}

	
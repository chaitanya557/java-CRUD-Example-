import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
/**
 * Servlet implementation class View
 */
@WebServlet("/View")
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("getView");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<a href='index.html'>ADD EMPLOYEES</a>");
		out.println("<h1>EMPLOYEE LIST</h1>");
		
		List<Emp> list = EmpDao.getAllEmployees();
		out.println("<table border='1' width='100%'>");
		out.println("<tr><th>id</th><td>name</th><th>password</th><th>email</th><th>country</th></tr>");
		for(Emp e:list) {
			out.println("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getPassword()+"</td><td>"+e.getEmail()+"</td><td>"+e.getCountry()+
					"</td><td><a href='Edit?id="+e.getId()+"'>edit</a></td><td><a href='Delete?id="+e.getId()+"'>delete</a></td></tr>");
		}
		out.println("</table>");
		
		out.close();
	}

}

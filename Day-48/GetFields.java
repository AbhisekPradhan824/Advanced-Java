package hff;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class GetFields
 */
@WebServlet("/get")
public class GetFields extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetFields() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s1 =  request.getParameter("book1");
		String s2 =  request.getParameter("book2");
		String s3 =  request.getParameter("book3");
		
		PrintWriter pw = response.getWriter();
		pw.println("<html><body bgcolor=wheat text=blue><center>");
		pw.println("<h1> Your books Lists</h1><ol>");
		
		if(!s1.equals("null")) {
			pw.println("<li>"+s1+"</li>");
		}
		if(!s2.equals("null")) {
			pw.println("<li>"+s2+"</li>");
		}
		if(!s3.equals("null")) {
			pw.println("<li>"+s3+"</li>");
		}
		pw.println("</ol></center></body></html>");
	}

}


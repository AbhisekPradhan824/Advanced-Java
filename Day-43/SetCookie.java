package cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class SetCookie
 */
@WebServlet("/set")
public class SetCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s1= request.getParameter("book1");
		String s2 = request.getParameter("book2");
		String s3 = request.getParameter("book3");
		
		if(s1!=null) {
			Cookie c1 = new Cookie("book1", s1);
			response.addCookie(c1);
		}
		if(s2!=null) {
			Cookie c2 = new Cookie("book2", s2);
			response.addCookie(c2);
		}
		if(s3!=null) {
			Cookie c3 = new Cookie("book3", s3);
			response.addCookie(c3);
		}
		
		PrintWriter pw = response.getWriter();
		pw.println("<html><body bgcolor=cyan text=blue><center>");
		pw.println("<h1>Your books are added to Cart successfully...</h1>");
		pw.println("<a href=get>Next</a>");
		pw.println("</center></body></html>");
	}

}

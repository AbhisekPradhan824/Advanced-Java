package basics;

import jakarta.servlet.*;
import java.io.*;

public class SecondServer extends GenericServlet {
  
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		pw.println("<html><body bgcolor=red text=yellow>");
		pw.println("<h1>Welcome to Servlet</h1>");
		pw.println("</body></html>");
	}

}

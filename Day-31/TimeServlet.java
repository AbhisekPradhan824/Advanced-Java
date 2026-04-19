/**
* Servlet Program to display System time...
*/
package basics;

import jakarta.servlet.*;
import java.io.*;
import java.time.LocalTime;

public class TimeServlet extends GenericServlet {
   
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LocalTime lt = LocalTime.now();
		PrintWriter pw = response.getWriter();
		pw.println("<html><head><meta http-equiv=refresh content =1></head>");
		pw.println("<body bgcolor=green text = yellow><h1>");
		pw.println(lt);
		pw.println("</h1></body></html>");
	}

}

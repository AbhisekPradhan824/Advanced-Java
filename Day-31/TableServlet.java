/**
* Servlet program to display Multiplication Table..
*/

package basics;
import jakarta.servlet.*;
import java.io.*;

/**
 * Servlet implementation class TableServlet
 */
public class TableServlet extends GenericServlet {
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		pw.println("<html><body bgcolor=pink text=blue><table border=1>");
		for(int i=1; i<=100; i++) {
			pw.println("</tr><td>5</td><td>*</td>");
			pw.println("<td>" +i+ "</td><td>=</td>");
			pw.println("<td>"+5*i+"</td></tr>");
		}
		pw.println("</table></body></html>");
	}

}

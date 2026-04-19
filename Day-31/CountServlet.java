/**
* Servlet program to count the number of views.
*/

package basics;

import jakarta.servlet.*;

import java.io.*;

/**
 * Servlet implementation class CountServlet
 */
public class CountServlet extends GenericServlet {
	private int count =0;
       
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter fw = response.getWriter();
		count++;
		fw.println("<html><body bgcolor = red text =green><h1>");
		fw.println("This page has been accessed "+count+" times..");
		fw.println("</h1></body></html>");
		
	}

}

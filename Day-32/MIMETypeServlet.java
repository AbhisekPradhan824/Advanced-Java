/**
* Servlet Program to demonstrate MIMEType
*/

package basics;

import jakarta.*;
import java.io.*;

/**
 * Servlet implementation class MIMETypeServlet
 */
public class MIMETypeServlet extends GenericServlet {
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.setContentType("application/msword");
		PrintWriter pw = response.getWriter();
		pw.println("Welcome....");
	}

}

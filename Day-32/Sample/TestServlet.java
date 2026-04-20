/**
* Servlet Program to demonstrate annotations
*/

package sample;

import jakarta.*;
import java.io.*;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/test")
public class TestServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.println("Welcome..");
	}

}

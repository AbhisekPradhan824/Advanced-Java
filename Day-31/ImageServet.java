/**
* Servlet program to display image
*/

package basics;

import jakarta.servlet.*;

import java.io.*;

/**
 * Servlet implementation class ImageServlet
 */
public class ImageServlet extends GenericServlet {

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletOutputStream sos=response.getOutputStream();
		FileInputStream fis = new FileInputStream("D:/flower.jpg");
		int n = fis.available();
		byte[] b = new byte[n];
		fis.read(b);
		sos.write(b);
	}

}

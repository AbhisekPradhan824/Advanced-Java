package filters;
import java.io.*;
import jakarta.servlet.http.*;
public  class WelcomeServlet extends HttpServlet{
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    String s1= request.getParameter("uname");
    String s2 = request.getParameter("pword");
    PrintWriter pw = response.getWriter();
    pw.println("<html><body bgcolor=green text=yellow><h1>");
    pw.println("Welcome"+s1);
    pw.println("</h1></body></html>");
  }
}

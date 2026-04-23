package login;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class RegServlet
 */
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    @Override
    public void init(ServletConfig config) {
        try {
        	String d = config.getInitParameter("driver");
            String u = config.getInitParameter("url");
            String un = config.getInitParameter("user");
            String p = config.getInitParameter("pass");
        	
            Class.forName(d);
            con = DriverManager.getConnection(u,un,p);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (con == null) {
	        response.getWriter().println("Database connection is not established. Check server logs.");
	        return;
	    }
		try {
			// TODO Auto-generated method stub
			String s1 = request.getParameter("fname");
			String s2 = request.getParameter("lname");
			String s3 = request.getParameter("uname");
			String s4 = request.getParameter("pword");
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO uinfo values (?,?,?,?)");
			ps.setString(1, s1);
			ps.setString(2, s2);
			ps.setString(3, s3);
			ps.setString(4, s4);
			ps.executeUpdate();
			
			PrintWriter pw = response.getWriter();
			pw.println("<html><body bgcolor=green text=yellow><center><h1>");
			pw.println("Hey User "+s3+ " You have successfully registered..</h1><a href=login.html>Login</a></center></body></html>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

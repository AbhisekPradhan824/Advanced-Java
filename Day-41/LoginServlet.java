package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			ServletContext cs = config.getServletContext(); 
        	String d = cs.getInitParameter("driver");
            String u = cs.getInitParameter("url");
            String un = cs.getInitParameter("username");
            String p = cs.getInitParameter("password");
        	
            Class.forName(d);
            conn = DriverManager.getConnection(u,un,p);
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
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// TODO Auto-generated method stub
			String s1 = request.getParameter("uname");
			String s2 = request.getParameter("pword");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM uinfo WHERE uname = ? AND pword=?");
			ps.setString(1, s1);
			ps.setString(2, s2);
			ResultSet rs = ps.executeQuery();
			PrintWriter pw = response.getWriter();
			if(rs.next()) {
				response.sendRedirect("welcome");
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("login.html");
				response.setContentType("text/html");
				pw.println("<h3 style='color:red; text-align:center;'>Invalid UserName/Password</h3>");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

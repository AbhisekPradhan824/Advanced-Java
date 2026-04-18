import java.io.*;
import jakarta.servlet.*;

public class FirstServlet{
public void service(ServletRequest req, ServletResponse res){
	try{
		PrintWriter pw = res.getWriter();
		pw.println("Welcome to servlet..");
	}catch(Exception e){
		e.printStackTrace();
	}
}

}

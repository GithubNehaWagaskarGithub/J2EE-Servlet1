package Demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/link1")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String pass=req.getParameter("password");
		
		if(name.equals("Neha") && pass.equals("Neha@123"))
		{
			//HttpSession hs=req.getSession();//if not provided any argument then it will check for existing Session if is is 
			//not available new Session is created.
			HttpSession hs=req.getSession(true);//true means session will create a new Session without checking existing session .
			RequestDispatcher rd=req.getRequestDispatcher("link2");//HttpSession is used for to store login Credentials
			rd.forward(req, resp);//by using forward() we have to forward login credentials from 1 servlet to another servlet 
									//which are stored inside a HttpSession.
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("index.html");
			rd.include(req, resp);
		}
	}

}
//54A67D71F06D8BAF8538AA4ED10298CB
//CE8AC759435D49AD1545B91B2D4BE689
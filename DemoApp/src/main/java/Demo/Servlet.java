package Demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet({"/link1"})
public class Servlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String pass=req.getParameter("pass");
		
		String[] username= {"ABC","BCD","CDE","DEF","EFG"};
        String[] passward= {"123","234","345","456","567"};
        PrintWriter pw=resp.getWriter();
        boolean found=false;
        for(int i=0;i<=username.length-1;i++)
        {
            if(name.equals(username[i]))
            {
                found=true;
            }
        }
        if(found)
        {
            for(int j=0;j<=passward.length-1;j++)
            {
                if(pass.equals(passward[j]))
                {
                    pw.print("Valid Username and Passward");
                }
            }
        }
        else
        {
            pw.print("Invalid Username and Passward");
        }
	}
}


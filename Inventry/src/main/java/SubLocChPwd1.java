import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class  SubLocChPwd1 extends HttpServlet
{ 
	 
	public void  service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
	int i=0;String a="",sc;
	res.setContentType("text/html");
	PrintWriter pw=res.getWriter();
	
	try
	{    
           String c=(req.getParameter("name")).trim();
   	   String d=req.getParameter("pass").trim();
 	   String f=req.getParameter("cpass").trim();
	   if (c==null||d==null||f==null)
	      {
    		     pw.println("<h3> field should not be null><br>");
		     res.setHeader("Refresh","2;URL=./SubLocPwd");	
	      }
	    else 
	      {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:dmms","dmms","dmms");
			Statement st=con.createStatement();
			i=st.executeUpdate("update sublocationincharge set password='"+f+"'  where  name='"+c+"' " );
  	      
		   if (i>=1)
  		             {
  		             	pw.println ("your password is changed");
			res.setHeader("Refresh","2;URL=./blank.html");
		              }
		   			else
		   				{
		   				pw.println("Password has not changed<br>Try toAdd Again!!");
		   				res.setHeader("Refresh","2;URL=./SubLocChPwd");
		   				}
	      }
	}    catch(Exception e){e.printStackTrace();}		 
			   	
        }
}
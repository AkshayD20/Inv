import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
public class DeleteSupplierController2 extends HttpServlet
{
  public void service(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
   {
     resp.setContentType("text/html");
     //String id1=req.getParameter("op1");
     int id=Integer.parseInt(req.getParameter("s1"));
	System.out.println("id"+id);
     PrintWriter out=resp.getWriter();
   
      try
          {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           Connection con=DriverManager.getConnection("jdbc:odbc:dmms","dmms","dmms");
	       Statement stmt=con.createStatement();
	int i=stmt.executeUpdate("delete from supplier where SUPPLIERID="+id);
	System.out.println("Deleted id has selected");
	if(i==1)
	{
  		out.println("deletion has taken successfully");
		resp.setHeader("Refresh","2;URL=./choosesup.html");
	}
	else
 	{
  		out.println("deletion has not taken place");
		resp.setHeader("Refresh","2;URL=./choosesup.html");
	}
	out.close();
	stmt.close();
	con.close();
 	}
       catch(Exception e) {
 		                e.printStackTrace();
 	                     }
     }
   
  
   }

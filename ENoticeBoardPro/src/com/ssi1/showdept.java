package com.ssi1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;


@WebServlet("/showdept")
public class showdept extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;
       
    
    public showdept() {
        super();
        // TODO Auto-generated constructor stub
    }

	 public void init()
		{

				try
				{
				Class.forName("com.mysql.jdbc.Driver");
				conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/notice","root","root");
				
				
		}
				catch (Exception e) {
					e.printStackTrace();
				}
		} 
	    public void destroy()
	    {
	    	try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String qr="select userid,dept from staff where userid in(select uid from notices)";
			PreparedStatement ps=(PreparedStatement) conn.prepareStatement(qr);
			ResultSet rs=ps.executeQuery();
			PrintWriter out=response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<h3>Click on the dept to view notices</h3>");
			out.println("<hr>");
			while(rs.next())
			{
				out.println("<a href=NoticeBoard?id="+rs.getString("userid")+">");
				out.println(rs.getString("dept"));
				out.println("</a>");
				out.println("<br>");
				out.println("</body>");
			    out.println("<html>");
			
			
		}
		}
		catch(Exception e)
		{
			
		}
	}

}

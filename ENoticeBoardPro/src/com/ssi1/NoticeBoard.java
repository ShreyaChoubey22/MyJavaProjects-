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


@WebServlet("/NoticeBoard")
public class NoticeBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;

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
				
				e.printStackTrace();
			}
	    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String id=request.getParameter("id");
			String qr="select * from notices where uid=?";
			PreparedStatement ps=(PreparedStatement) conn.prepareStatement(qr);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			PrintWriter out=response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<hr>");
			out.println("<table border=2>");
			while(rs.next())
			{
			
			
			String s1=rs.getString(1);
			String s2=rs.getString(2);
			String s3=rs.getString(3);
			String s4=rs.getString(4);
			String s5=rs.getString(5);
			out.println("<tr>");
			out.println("<th>ID</th>");
			out.println("<td>"+s1+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>Title</th>");
			out.println("<td>"+s2+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>Message</th>");
			out.println("<td>"+s3+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>Uid</th>");
			out.println("<td>"+s4+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>PostDate</th>");
			out.println("<td>"+s5+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("</tr>");
			}
			out.println("<hr>");
		     out.println("</table>");
		     out.println("<a href=student-home.jsp>Home</a>");
		     out.println("</br>");
		     out.println("<a href=showdept>Back</a>");
		     
			out.println("</body>");
			out.println("</html>");
			
			
			
		    }
		catch(Exception e)
		{
			
		}
	}

}

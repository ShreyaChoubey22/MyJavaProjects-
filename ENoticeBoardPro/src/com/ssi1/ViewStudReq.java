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


@WebServlet("/ViewStudReq")
public class ViewStudReq extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static Connection conn;
    PreparedStatement ps;
    public ViewStudReq() {
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
		String qr="select * from student where status='pending'";
		PrintWriter out=response.getWriter();
		String s1=null;
		String s2=null;
		String s3=null;
		String s4=null;
		try {
			ps=(PreparedStatement) conn.prepareStatement(qr);
			ResultSet rs=ps.executeQuery();
			out.println("<html><body><h3>Pending-Accounts</h3>");
			out.println("<table border=2>");
			out.println("<tr>");
			out.println("<th>ID</th>");
			out.println("<th>Name</th>");
			out.println("<th>Branch</th>");
			out.println("<th>Semester</th>");
			out.println("</tr>");
			while(rs.next())
			{
				 s1=rs.getString("userid");
				 s2=rs.getString("uname");
				 s3=rs.getString("branch");
				 s4=rs.getString("sem");
		     
			out.println("<tr>");
			out.println("<td>"+s1+"</td>");
			out.println("<td>"+s2+"</td>");
			out.println("<td>"+s3+"</td>");
			out.println("<td>"+s4+"</td>");
			out.println("<td><a href=EnableStudentAccount?id="+s1+">Enable</a></td>");
			out.println("</tr>");
			
			}
			out.println("</table>");
			out.println("<a href='admin-home.jsp>Home</a>'");
			out.println("</body>");
			out.println("</html>");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
}
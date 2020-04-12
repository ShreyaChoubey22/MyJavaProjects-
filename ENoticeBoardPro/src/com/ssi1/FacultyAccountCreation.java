package com.ssi1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






@WebServlet("/FacultyAccountCreation")
public class FacultyAccountCreation extends HttpServlet {
	Connection conn;
	PreparedStatement ps;
	
	
	
	private static final long serialVersionUID = 1L;
       
   
    public FacultyAccountCreation() {
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
     
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uid=request.getParameter("userid");
		String password=request.getParameter("pwd");
		String name=request.getParameter("name");
		String department=request.getParameter("dept");
		PrintWriter out=response.getWriter();

		
		  try
		  {
			  String qr="insert into staff values(?,?,?,'activated',?)";
			  PreparedStatement ps=(PreparedStatement) conn.prepareStatement(qr);
			ps.setString(1,uid);
			ps.setString(2,password);
			
			ps.setString(3,department);
			ps.setString(4, name);
			
			ps.executeUpdate();
		
			conn.close();
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>Account Created</h1><br>");
			out.println("<a href='admin-home.jsp'>Home</a><br>");
			out.println("<a href='HOD-reg.jsp'>Create-Another-Account</a>");
			out.println("</body>");
			out.println("/<html>");
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}
}
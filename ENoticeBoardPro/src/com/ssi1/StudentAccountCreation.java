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






@WebServlet("/StudentAccountCreation")
public class StudentAccountCreation extends HttpServlet {
	Connection conn;
	PreparedStatement ps;
	String qr="insert into student values(?,?,?,?,?,'pending')";
	
	
	private static final long serialVersionUID = 1L;
       
   
    public StudentAccountCreation() {
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
		
		String userid=request.getParameter("userid");
		String password=request.getParameter("pwd");
		String name=request.getParameter("name");
		String branch=request.getParameter("branch");
		String sem=request.getParameter("sem");
		PrintWriter out=response.getWriter();
		
		
		
		  try
		  {
			 ps=(PreparedStatement) conn.prepareStatement(qr);
			ps.setString(1,userid);
			ps.setString(2,password);
			ps.setString(3, name);
			ps.setString(4,branch);
			ps.setString(5, sem);
			
			ps.executeUpdate();
		
			
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>Account Created</h1>");
			out.println("<h3>After verification your account will be activated</h3>");
			out.println("<a href='index.jsp'>Home</a>");
			
			out.println("</body>");
			out.println("/<html>");
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}
}
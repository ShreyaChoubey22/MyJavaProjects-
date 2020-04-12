package com.ssi1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class VerifyUser
 */
@WebServlet("/VerifyUser")
public class VerifyUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;
	PreparedStatement ps;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyUser() {
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
	    
		String userid=request.getParameter("uid");
		String password=request.getParameter("pwd");
		String usertype=request.getParameter("utype");
		String save=request.getParameter("savepwd");
		String msg=null;
		
        if(usertype.equals("admin"))
        {
        	if(userid.equals("admin")&&password.equals("indore"))
        	{
        		//use cookies to save uid pwd
        		if(save!=null)
        		{
        			Cookie c1=new Cookie("admin-id",userid);
        			Cookie c2=new Cookie("admin-pwd",password);
        			Cookie c3=new Cookie("admin-utype",usertype);
        			c1.setMaxAge(60*60*24*7);
        			c2.setMaxAge(60*60*24*7);
        		    c3.setMaxAge(60*60*24*7);
        			response.addCookie(c3);
        			response.addCookie(c1);
        			response.addCookie(c2);
        		}
        		response.sendRedirect("admin-home.jsp");
           	}
        	else
        	{
        		msg="Invalid details";
        	}
        }
        else if(usertype.equals("HOD"))
        {
        	String qr="select * from staff where userid=? and pwd=?";
        	try {
				ps=conn.prepareStatement(qr);
				ps.setString(1,userid);
				ps.setString(2,password);
				ResultSet rs=ps.executeQuery();
				boolean b=rs.next();
				String status=rs.getString("status");
				String dept=rs.getString("dept");
				
				
				if(b)
				{
					if(status.equals("activated"))
					{
						//store uid and pwd in session
						if(save!=null)
		        		{
		        			Cookie c1=new Cookie("hod-id",userid);
		        			Cookie c2=new Cookie("hod-pwd",password);
		        			Cookie c3=new Cookie("hod-utype",usertype);
		        			c1.setMaxAge(60*60*24*7);
		        			c2.setMaxAge(60*60*24*7);
		        			
		        			c3.setMaxAge(60*60*24*7);
		        			response.addCookie(c3);
		        			response.addCookie(c1);
		        			response.addCookie(c2);
		        		}
						HttpSession session=request.getSession();
						session.setAttribute("id",userid);
						
						session.setAttribute("dept",dept);
						response.sendRedirect("faculty-home.jsp");
						
					}
				}
				else
				{
					msg="No Faculty with these records";
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}     	
        }
        else if(usertype.equals("student"))
        {
        	String qr="select * from student where userid=? and password=?";
        	try {
				ps=conn.prepareStatement(qr);
				ps.setString(1,userid);
				ps.setString(2,password);
				ResultSet rs=ps.executeQuery();
				boolean b=rs.next();
				String status=rs.getString("status");
				String branch=rs.getString("branch");
				HttpSession session2=request.getSession();
				session2.setAttribute("stud-id",userid);
				
				session2.setAttribute("branch",branch);
				
				
				if(b)
				{
					if(status.equals("activated"))
					{
						if(save!=null)
		        		{
		        			Cookie c1=new Cookie("stud-id",userid);
		        			Cookie c2=new Cookie("stud-pwd",password);
		        			Cookie c3=new Cookie("student-utype",usertype);
		        			c1.setMaxAge(60*60*24*7);
		        			c2.setMaxAge(60*60*24*7);
		        			
		        			c3.setMaxAge(60*60*24*7);
		        			response.addCookie(c3);
		        			response.addCookie(c1);
		        			response.addCookie(c2);
		        		}
						response.sendRedirect("student-home.jsp");
					}
					else
					{
						msg="Account is not activated yet please wait till activation!!";
					}
					
				}
				else
				{
					msg="No Student with such records";
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}     	
        }
        
        PrintWriter out=response.getWriter();
        out.println(msg);
		
	}

}

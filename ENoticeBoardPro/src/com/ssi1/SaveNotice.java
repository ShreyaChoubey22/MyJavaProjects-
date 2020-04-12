package com.ssi1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;






@WebServlet("/SaveNotice")
public class SaveNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;
   
    public SaveNotice() {
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
		String title=request.getParameter("title");
		String message=request.getParameter("msg");
		String qr="insert into notices values(?,?,?,?,?)";
		java.util.Date dt=new java.util.Date();
		long ts=dt.getTime();
		java.sql.Date postDate=new java.sql.Date(ts);
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		
		try {
			PreparedStatement ps=(PreparedStatement) conn.prepareStatement(qr);
			ps.setString(1,id);
			ps.setString(2,title);
			ps.setString(3,message);
			ps.setString(4,id);
			ps.setDate(5,postDate);
			ps.executeUpdate();
			out.println("<html><body>");
			out.println("<h3>Notice has been posted Successfully<h3>");
			out.println("<h1><a href=faculty-home.jsp>Home</a></h4>");
			out.println("<h1><a href=noticepost.jsp>Post-Another</a></h4>");		
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		     
		
	}

}

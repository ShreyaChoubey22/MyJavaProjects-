package com.ssi1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;


@WebServlet("/EnableStudentAccount")
public class EnableStudentAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection conn;
	PreparedStatement ps;
       
    
    public EnableStudentAccount() {
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
		String id=request.getParameter("id");
		String qr="update student set status='activated' where userid=?";
		try {
			ps=(PreparedStatement) conn.prepareStatement(qr);
			ps.setString(1,id);
			ps.executeUpdate();
			response.sendRedirect("ViewStudReq");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

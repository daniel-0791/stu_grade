package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.JDBCUtil;

/**
 * Servlet implementation class teacher_login
 */
@WebServlet("/teacher_login")
public class teacher_login extends HttpServlet {
	JDBCUtil jdbcUtil = new JDBCUtil();
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public teacher_login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		
		int str1=Integer.parseInt(request.getParameter("user"));
		
		String str2=request.getParameter("password1");
		Connection conn =jdbcUtil. buildConnect();
	
		ResultSet rs;
		String str="select name,photo from teacher,teacher_login where user=? and password=? and teacher_user=user" ;
		try {
			PreparedStatement sql=(PreparedStatement) conn.prepareStatement(str);
			
			sql.setInt(1, str1);
			sql.setString(2, str2);
			 
			rs=sql.executeQuery();
			
			  if(rs.next()){ 
				  
		            System.out.println("登录成功");
		            String name=rs.getString(1);
		            String photo=rs.getString(2);
		            HttpSession session=request.getSession(true);
		            session.setAttribute("name1", name);
		            session.setAttribute("photo1", photo);
		            RequestDispatcher dis=request.getRequestDispatcher("teacherManager.jsp");
		            dis.forward(request, response);
		        }
		        else{ 
		            System.out.println("登录失败");
		            response.sendRedirect("1LOGIN.jsp");	        }
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		}	
		
	}

}

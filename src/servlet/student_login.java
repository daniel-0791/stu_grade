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
@WebServlet("/student_login")
public class student_login extends HttpServlet {
	JDBCUtil jdbcUtil = new JDBCUtil();
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public student_login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		
		int str1=Integer.parseInt(request.getParameter("user_stu"));
	
		String str2=request.getParameter("password");
		Connection conn =jdbcUtil. buildConnect();
		
		ResultSet rs;
		String str="select student.id,name,photo from student,student_login where user=? and student_login.password=? and student_login.user=student.login_name";
		try {
			PreparedStatement sql=(PreparedStatement) conn.prepareStatement(str);
			
			sql.setInt(1, str1);
			sql.setString(2, str2);
			 
			rs=sql.executeQuery();
			
			  if(rs.next()){ 
		            System.out.println("登录成功");
		            String id=rs.getString(1);
		            String name=rs.getString(2);
		            String photo=rs.getString(3);
		            HttpSession session=request.getSession(true);
		            session.setAttribute("id", id);
		            session.setAttribute("name", name);
		            session.setAttribute("photo", photo);
		            RequestDispatcher dis=request.getRequestDispatcher("stuSystem.jsp");
		            dis.forward(request, response);
		        }
		        else{  
		            System.out.println("输入的密码或账号不正确，请重新输入");
		            RequestDispatcher sc=request.getRequestDispatcher("1LOGIN.jsp");
		            sc.forward(request, response);
		                   
		            }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

}

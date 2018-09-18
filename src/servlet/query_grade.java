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
import javax.websocket.Session;

import org.apache.catalina.util.SessionConfig;

import util.JDBCUtil;

/**
 * Servlet implementation class query_grade
 */
@WebServlet("/query_grade")
public class query_grade extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JDBCUtil jdbcUtil = new JDBCUtil(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public query_grade() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		
		HttpSession session=request.getSession();
		String str2= (String) session.getAttribute("name");
		Connection conn =jdbcUtil.buildConnect();
		
		ResultSet rs;
		String str="select name,database_grade.grade from student,database_grade where name=? and database_grade.stu_id=login_name";
		try {
			
			PreparedStatement sql=(PreparedStatement) conn.prepareStatement(str);
	
			sql.setString(1, str2);
			 
			rs=sql.executeQuery();
			
			  if(rs.next()){ 
		            System.out.println("查到了");
		            String name=rs.getString(1);
		            String grade=rs.getString(2);
		         
		            request.setAttribute("name", name);
		            request.setAttribute("grade", grade);
		            request.getRequestDispatcher("search_grade.jsp").forward(request, response);//����ת������˼
		        }
		        else{  
		            System.out.println("输入的密码或账号不正确，请重新输入");
		                
		            }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	
		
		
	}

}

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
 * Servlet implementation class gradesort
 */
@WebServlet(name = "gradeSort", urlPatterns = { "/gradeSort" })
public class gradesort extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JDBCUtil jdbcUtil = new JDBCUtil();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gradesort() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	
	

		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		


		Connection conn =jdbcUtil. buildConnect();
		
		ResultSet rs;
		String str="SELECT AVG(grade), MAX(grade), MIN(grade) FROM database_grade";
		
		try {
			PreparedStatement sql=(PreparedStatement) conn.prepareStatement(str);
			
		
			 
			rs=sql.executeQuery();
			
			  if(rs.next()){ 
		            System.out.println("查到成绩了");
		            int avg=rs.getInt(1);
		            int max=rs.getInt(2);
		            int min=rs.getInt(3);
		            
	
		            HttpSession session=request.getSession(true);
		            session.setAttribute("avg", avg);
		            session.setAttribute("max", max);
		            session.setAttribute("min", min);
		            RequestDispatcher dis=request.getRequestDispatcher("gradeSort.jsp");
		            dis.forward(request, response);
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

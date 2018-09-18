package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CourseDAO;
import model.Course;
import util.JDBCUtil;

/**
 * Servlet implementation class course_add
 */
@WebServlet("/course_add")
public class course_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JDBCUtil jdbcUtil = new JDBCUtil();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public course_add() {
    	
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		request.setCharacterEncoding("utf-8");
		
	
		
		Connection conn =jdbcUtil. buildConnect();
		
		ResultSet rs;
		ResultSet rs1;
		
		try {
			CourseDAO courseDAO=new CourseDAO();
		
		
			int stu_id=Integer.parseInt(request.getParameter("stu_id"));	
			System.out.println("学生id是"+stu_id);
			int course_id=Integer.parseInt(request.getParameter("id"));				
			String ccode=request.getParameter("ccode");
			String cname=request.getParameter("cname");
			int score=Integer.parseInt(request.getParameter("score"));
			//course.setId(id);
			
			HttpSession session=request.getSession(true);
			session.setAttribute("stu_id", stu_id);
			String str="select * from plan_study_course where course_id=? and student_id=?";
			PreparedStatement sql=(PreparedStatement) conn.prepareStatement(str);

			sql.setInt(1,course_id);
			sql.setInt(2, stu_id);
			rs=sql.executeQuery();
			
			  if(rs.next()){ 
				
				
					String str1="已存在";					
					request.setAttribute("name", str1);				
					request.getRequestDispatcher("courselist").forward(request, response);
		        }
		        else{  
		        	
		        	String str3="select sum(course.score) as fenshu from plan_study_course,course  where  course_id=course.id and student_id=?";
					System.out.println("选择后显示了没");
		        	PreparedStatement sql1=(PreparedStatement) conn.prepareStatement(str3);
					sql1.setInt(1, stu_id);
					rs1=sql1.executeQuery();
//					System.out.println("选择后显示了没2");
					//System.out.println(rs1.);
					int sum=0;
					if(rs1.next())
					{
						sum=rs1.getInt(1);
						System.out.println("选择后显示了没3");
						System.out.println(sum);
					}
				
				
		    	
		    		if(sum>25)
	    			{
	    				String str1="已超过本学期学分30分";
	    				request.setAttribute("name", str1);				
						request.getRequestDispatcher("courselist").forward(request, response);
	    			}
	    			else {
	    				  String str1="插入成功";				
							request.setAttribute("name", str1);
							courseDAO.save(stu_id,course_id);
							
							request.getRequestDispatcher("courselist").forward(request, response);
	    			}
		        	
		        	
						
		        
		        }


				}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}

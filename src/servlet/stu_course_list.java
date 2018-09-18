package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CourseDAO;
import model.Course;
import org.apache.jasper.tagplugins.jstl.core.Choose;
import util.JdbcException;

/**
 * Servlet implementation class stu_course_list
 */
@WebServlet("/stu_course_list")
public class stu_course_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public stu_course_list() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest
								   request, HttpServletResponse response
	) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CourseDAO courseDAO=new CourseDAO();
		System.out.println("正选选课");
		HttpSession session=request.getSession(true);
		System.out.println("这里吗111");
		
		
		int stu_id = 0;
		
		try {
			System.out.println("这里吗");
			 stu_id=(int) session.getAttribute("stu_id");
			 System.out.println("asdasdasdsadsadasdsadsaasasdasdas");
				ArrayList<Course> courses=courseDAO.findAll_stu(stu_id);
					System.out.println("这里在运行");
					/*boolean choose= (boolean) session.getAttribute("choose");
					choose=false;
					session.setAttribute("choose",choose);*/
				
				
				request.setAttribute("courselist_stu", courses);//(������", ����ֵ)����ֵ
				request.getRequestDispatcher("courseList.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("这里错了");
			request.getRequestDispatcher("wrong.jsp").forward(request, response);
			
		}
		
		
		
	}

}

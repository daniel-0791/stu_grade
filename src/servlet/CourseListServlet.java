package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDAO;
import dao.studentDao;
import model.Course;
import model.student_info;

/**
 * Servlet implementation class CourseListServlet
 */
@WebServlet("/courselist")
public class CourseListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		CourseDAO courseDAO=new CourseDAO();
		ArrayList<Course> courses=courseDAO.findAll();
	
		
		
		request.setAttribute("courselist1", courses);
		request.getRequestDispatcher("take_course.jsp").forward(request, response);//����ת������˼
		
	}

}

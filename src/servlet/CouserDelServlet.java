package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CourseDAO;
import model.Course;

/**
 * Servlet implementation class CouserDelServlet
 */
@WebServlet("/delcourse")
public class CouserDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CouserDelServlet() {
        super();


        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CourseDAO courseDAO=new CourseDAO();
		Course course=new Course();
		int id=Integer.parseInt(request.getParameter("id"));
		course.setId(id);
		HttpSession session=request.getSession(true);
		int stu_id=(int) session.getAttribute("stu_id");
		
		
		
		courseDAO.delete(course,stu_id);
		
		request.getRequestDispatcher("stu_course_list").forward(request, response);
	
	}

}

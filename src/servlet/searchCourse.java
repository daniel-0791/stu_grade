package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDAO;
import model.Course;

/**
 * Servlet implementation class searchCourse
 */
@WebServlet("/searchCourse")
public class searchCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchCourse() {
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
		System.out.println("asdsadsad");
		String name=request.getParameter("key_word");
		System.out.println(name+",");
		ArrayList<Course> courses=courseDAO.findByCName(name);
		
		if(courses.isEmpty())
		{

		}
		else
		{
			System.out.println("有");
		}
		System.out.println("在这儿");
		request.setAttribute("courselist2", courses);
		
		request.getRequestDispatcher("searchCourse.jsp").forward(request, response);
	}

	

}

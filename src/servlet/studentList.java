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
 * Servlet implementation class studentList
 */
@WebServlet("/studentList")
public class studentList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		studentDao studentDAO=new studentDao();
		ArrayList<student_info> student=studentDAO.findAll();
		request.setAttribute("studentlist", student);
		request.getRequestDispatcher("gradeManager.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * @author 
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		studentDao studentDAO=new studentDao();
		ArrayList<student_info> student=studentDAO.findAll();
		request.setAttribute("studentlist", student);//
		
		request.getRequestDispatcher("studentList.jsp").forward(request, response);
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		studentDao studentDAO=new studentDao();
		ArrayList<student_info> student=studentDAO.findAll();
		request.setAttribute("studentlist", student);//
		
		request.getRequestDispatcher("studentList.jsp").forward(request, response);
	}


}

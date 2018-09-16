package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.studentDao;
import model.student_info;

/**
 * Servlet implementation class student_grade_list
 */
@WebServlet("/student_grade_list")
public class student_grade_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public student_grade_list() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		studentDao studentDAO=new studentDao();
		ArrayList<student_info> student=studentDAO.findAll();
		request.setAttribute("studentlist", student);
		request.getRequestDispatcher("gradeManager.jsp").forward(request, response);
	}

}

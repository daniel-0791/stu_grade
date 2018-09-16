package servlet;

import java.io.IOException;
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
 * Servlet implementation class stu_grade
 */
@WebServlet("/stu_grade")
public class stu_grade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public stu_grade() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		studentDao student=new studentDao();
		//student_info stu_info=new student_info();
	/*	int id=Integer.parseInt(request.getParameter("id"));
		int grade=Integer.parseInt(request.getParameter("grade"));*/
		
		String[] grade=request.getParameterValues("grade_stu"); //用getParameterValues的方法，将核取到的值取到langtype[]阵列内    
		String[] stu_id=request.getParameterValues("stu_id");
		  for (int i=0;i<stu_id.length;i++)    
		  {  System.out.println("我在这里");   
			  System.out.println(stu_id[i]);   
		
		  }
		int temp[]=new int[grade.length];
		int id[]=new int[stu_id.length];
		System.out.println("这句执行 没2");
		
	for(int i=0;i<stu_id.length;i++){
			
			id[i] = Integer.parseInt(stu_id[i]);
	    }
		for(int i=0;i<grade.length;i++){
			
			temp[i] = Integer.parseInt(grade[i]);
	    }
		System.out.println("这句执行 没3");
		if (temp!=null)    
			//前端的使用者,如果没打勾的话    
			//request.getParameterValues("grade")会接收到null值    
			{    
			  int size=grade.length;    
			//取得这个阵列大小    
			  for (int i=0;i<size;i++)    
			  { student_info stu_info=new student_info();
				  System.out.println(temp[i]);   
			  stu_info.setGrade(temp[i]);
			  stu_info.setId(id[i]);
			  student.update(stu_info);
			  }    
			//利用一个for迴圈将阵列资料取出    
			
			} 
		/*
		stu_info.setGrade(grade);
		stu_info.setId(id);*/
	
		//student.update(stu_info);
		String str="上传成功";
		request.setAttribute("str", str);
		request.getRequestDispatcher("gradeManager.jsp").forward(request, response);
	}

}

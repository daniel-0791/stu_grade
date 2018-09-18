package servlet;

import dao.CourseDAO;
import model.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author peter
 * @create 2018-09-10 上午 10:40
 */
@WebServlet("/new_stusys")
public class new_stusys extends HttpServlet {


    protected void service(HttpServletRequest
                                   request, HttpServletResponse response
    ) throws ServletException, IOException {
        // TODO Auto-generated method stub
        HttpSession session=request.getSession(true);
        System.out.println("newstusys");
        boolean choose= (boolean) session.getAttribute("choose");
        choose=false;
        session.setAttribute("choose",choose);
        request.getRequestDispatcher("stuSystem.jsp").forward(request, response);
        }



    }



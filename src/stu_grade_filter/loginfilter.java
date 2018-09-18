package stu_grade_filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class MemberFilter
 *
 * //检查用户当前是否登录过滤器
 *
 */
@WebFilter(
        filterName="/loginfilter",
        urlPatterns={"/stuSystem.jsp","/teacherManager.jsp","/peiyangfangan.jsp","/take_course.jsp"},
//        initParams={
//                @WebInitParam(name="Login",value="/font/user_login.jsp")},
        dispatcherTypes={
                DispatcherType.FORWARD,
                DispatcherType.INCLUDE,
                DispatcherType.REQUEST,
                DispatcherType.ERROR,
                DispatcherType.ASYNC
        })
public class loginfilter implements Filter {

    private String Login;

    /**
     * Default constructor.
     */
    public loginfilter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // TODO Auto-generated method stub
        HttpServletRequest req=(HttpServletRequest) request;
        if(req.getSession().getAttribute("stu_loginer")!=null){
            chain.doFilter(req, response);
        }
        else if(req.getSession().getAttribute("tea_loginer")!=null){
            chain.doFilter(req, response);

        }
        else{

            HttpServletResponse resp=(HttpServletResponse) response;
            System.out.println("过滤器错误");
            resp.sendRedirect("index.jsp");
        }
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
        this.Login=fConfig.getInitParameter("Login");
    }

}

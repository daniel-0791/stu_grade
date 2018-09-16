package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import model.Course;
import util.IHander;
import util.JDBCUtil;
import util.JdbcException;

public class CourseDAO{

	JDBCUtil jdbcUtil = new JDBCUtil();
	
	

	public void save(int stu_id,int course_id) throws JdbcException {  
			System.out.println(course_id);
			System.out.println(stu_id);
		String sql = "insert into plan_study_course(course_id,semester_id,student_id) values(?,?,?)";
		jdbcUtil.executeUpdate(sql,course_id,1,stu_id);
	
	

             }

	public void update(Course course) throws JdbcException { 
		String sql = "update course set ccode=?,cname=?,ename=?,score=?,category=?,tlhour=? where id=?";
		jdbcUtil.executeUpdate(sql, course.getCcode(), course.getCname(), course.getEname(), course.getScore(),
				course.getCategory(), course.getTlhour(), course.getId());
	}

	public void delete(Course course,int stu_id) throws JdbcException {  
		String sql = "delete from plan_study_course where course_id=? and student_id=?";
		jdbcUtil.executeUpdate(sql, course.getId(),stu_id);
	}

	public ArrayList<Course> findByCName(String CName)  throws JdbcException{  
		
		System.out.println("findbyCName");
		String sql="select * from course where cname like ?";
		return jdbcUtil.executeQuery(new CourseHandler(), sql,"%"+CName+"%");

	}



	public ArrayList<Course> findAll() throws JdbcException {//��������
		String sql = "select * from course";
		return jdbcUtil.executeQuery(new CourseHandler(), sql);
	}

	class CourseHandler implements IHander<Course> {

		@Override
		public ArrayList<Course> wrap(ResultSet rs) throws JdbcException {
			ArrayList<Course> courses = new ArrayList<Course>();
			try {
				while (rs.next()) {
					//System.out.println("course111111");
					Course course = new Course();
					course.setId(rs.getInt("id"));
					course.setCcode(rs.getString("ccode"));
					course.setCname(rs.getString("cname"));
					course.setEname(rs.getString("ename"));
					course.setScore(rs.getInt("score"));
					course.setCategory(rs.getString("category"));
				
				
					course.setTlhour(rs.getInt("tlhour"));
					courses.add(course);
				}
			} catch (SQLException e) {
				throw new JdbcException(JdbcException.ExceptionCategory.ResultSetFail);
			}
			return courses;
		}

	}
		public ArrayList<Course> findAll_stu(int stu_id) throws JdbcException {
		String sql = "select course.id,ccode,cname,ename,score,category,tlhour FROM plan_study_course,course where course_id=course.id and student_id=?";
		return jdbcUtil.executeQuery(new CourseHandler_stu(), sql,stu_id);
	}

	class CourseHandler_stu implements IHander<Course> {

		@Override
		public ArrayList<Course> wrap(ResultSet rs) throws JdbcException {
			ArrayList<Course> courses_stu = new ArrayList<Course>();
			System.out.println("这里显示了吗2");
			try {
				System.out.println("这里显示了吗");
				while (rs.next()) {
					
					Course course = new Course();
					course.setId(rs.getInt("id"));
					System.out.println(rs.getInt("id"));
					course.setCcode(rs.getString("ccode"));
					course.setCname(rs.getString("cname"));
					course.setEname(rs.getString("ename"));
					course.setScore(rs.getInt("score"));
					course.setCategory(rs.getString("category"));
								
					course.setTlhour(rs.getInt("tlhour"));
					courses_stu.add(course);
				}
			} catch (SQLException e) {
				throw new JdbcException(JdbcException.ExceptionCategory.ResultSetFail);
			}
			return courses_stu;
		}

	}
}

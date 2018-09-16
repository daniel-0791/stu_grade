package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


import model.student_info;
import util.IHander;
import util.JDBCUtil;
import util.JdbcException;

public class studentDao {
	JDBCUtil jdbcUtil = new JDBCUtil();
	

	public void update(student_info student) throws JdbcException { //����
		String sql = "update database_grade set grade=? where id=?";
		jdbcUtil.executeUpdate(sql, student.getGrade(),student.getId());
	}
	public ArrayList<student_info> findAll() throws JdbcException {
		String sql = "select * from student";
		return jdbcUtil.executeQuery(new studentHandler(), sql);
	}
	public ArrayList<student_info> findGrade(String name) throws JdbcException {//��������
		String sql = "select * from student where name=?";
		
		return jdbcUtil.executeQuery(new studentHandler(), sql,name);
	}

	class studentHandler implements IHander<student_info> {

		@Override
		public ArrayList<student_info> wrap(ResultSet rs) throws JdbcException {
			ArrayList<student_info> students = new ArrayList<student_info>();
			try {
				while (rs.next()) {
					student_info student = new student_info();
					student.setId(rs.getInt("id"));
					student.setScode(rs.getString("scode"));
					student.setName(rs.getString("name"));
					student.setClass_id(rs.getInt("class_id"));
					student.setGender(rs.getString("gender"));
					student.setGrade(rs.getInt("grade"));
					student.setPhoto(rs.getString("photo"));
					students.add(student);
				}
			} catch (SQLException e) {
				throw new JdbcException(JdbcException.ExceptionCategory.ResultSetFail);
			}
			return students;
		}

	}
}

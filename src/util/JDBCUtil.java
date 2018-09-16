package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JDBCUtil {
	private final static String URL = "jdbc:mysql://localhost:3306/course_db?"+"user=root&password=123456&characterEncoding=gb2312";

	public Connection buildConnect() throws JdbcException{
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");// 
			conn = DriverManager.getConnection(URL);//
		} catch (ClassNotFoundException e) {
			throw new JdbcException(JdbcException.ExceptionCategory.ClassNotFound);
		} catch (SQLException e) {
			throw new JdbcException(JdbcException.ExceptionCategory.ConnectFail);
		}

		return conn;
	}

	
	/**
	 * 
	 * @param sql
	 *            SQL COMMAND INSERT,DELETE and UPDATE
	 * @param params
	 *           
	 * @throws JdbcException 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void executeUpdate(String sql, Object... params) throws JdbcException{
		try (Connection conn = buildConnect(); PreparedStatement pt = conn.prepareStatement(sql);) {
			for (int i = 0; i < params.length; i++) {
				System.out.println(params[i]);
				pt.setObject(i + 1, params[i]);
			}
			pt.executeUpdate();
		} catch (SQLException e) {
			throw new JdbcException(JdbcException.ExceptionCategory.SQLFail);
		}
	}

	/**
	 * 
	 * @param handler
	 *          
	 * @param sql
	 *           
	 * @param params
	 *            
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws JdbcException 
	 */
	public <E> ArrayList<E> executeQuery(IHander<E> handler, String sql, Object... params)//�������ͺͲ�����֮�����ʡ�Ժţ����Ĳ������ǿɱ�ģ����ԺͲ�ȷ����ʵ��ƥ��
			throws JdbcException {
		try (
				Connection conn = buildConnect(); 
				PreparedStatement pt = conn.prepareStatement(sql);) {
			System.out.println("executeQuery");
			for (int i = 0; i < params.length; i++) {
				pt.setObject(i + 1, params[i]);//和setInt（）一样，建立对象
				System.out.println("params="+params[i]);
			}
			
			ResultSet rs = pt.executeQuery();
			System.out.println("那这里呢s");
			//if (rs!=null && rs.next()) System.out.println("courseHEllo"+rs.getInt(1));
			return handler.wrap(rs);//将查询到的结果返回给courseHandler重写的方法，把结果保存到动态数组里
		} catch (SQLException e) {
			
			throw new JdbcException(JdbcException.ExceptionCategory.SQLFail);
		}
	}

}

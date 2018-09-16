package util;

public class JdbcException extends RuntimeException {
	private static final long serialVersionUID = -7071349265573207234L;
	
	public JdbcException(ExceptionCategory exceptionCategory) {
		super(exceptionCategory.getMessage());
	}
	
	public enum ExceptionCategory{
		ClassNotFound("驱动错误"),ConnectFail("未连接"),SQLFail("SQL查询失败"),ResultSetFail("ResultSet错误");
		private String message;
		public String getMessage() {
			return message;
		}
		ExceptionCategory(String message){this.message=message;}
	}
}

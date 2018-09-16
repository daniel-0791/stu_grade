package util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IHander<E> {
	public ArrayList<E> wrap(ResultSet rs) throws JdbcException;
}

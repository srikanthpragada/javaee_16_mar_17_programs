
import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.rowset.Predicate;

import oracle.jdbc.rowset.OracleFilteredRowSet;

public class FilteredRowSetDemo {

	public static void main(String[] args) throws Exception {
		OracleFilteredRowSet rs = new OracleFilteredRowSet();
		rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		rs.setUsername("hr");
		rs.setPassword("hr");
		rs.setCommand("select * from jobs");
		rs.execute();
		System.out.println("****** ALL *************");
		while (rs.next()) {
			System.out.println(rs.getString("job_title") + ":" + rs.getString("min_salary"));
		}

		System.out.println("****** Salary *************");
		rs.setFilter(new SalaryPredicate());
		rs.beforeFirst();
		while (rs.next()) {
			System.out.println(rs.getString("job_title") + ":" + rs.getString("min_salary"));
		}

		System.out.println("****** Title *************");
		rs.setFilter(new TitlePredicate());
		rs.beforeFirst();
		while (rs.next()) {
			System.out.println(rs.getString("job_title") + ":" + rs.getString("min_salary"));
		}
		rs.close();

	}
}

class SalaryPredicate implements Predicate {
	@Override
	public boolean evaluate(RowSet rs) {
		try {
			int minsal = rs.getInt(3);
			return rs.wasNull() || minsal > 10000;
		} catch (Exception ex) {
			return false;
		}

	}

	@Override
	public boolean evaluate(Object value, int columnNumber) throws SQLException {
		return true;
	}

	@Override
	public boolean evaluate(Object value, String columnName) throws SQLException {
		return true;
	}
}

class TitlePredicate implements Predicate {
	@Override
	public boolean evaluate(RowSet rs) {
		try {
			return rs.getString("job_title").length() > 20;
		} catch (Exception ex) {
			return false;
		}

	}

	@Override
	public boolean evaluate(Object value, int columnNumber) throws SQLException {
		return true;
	}

	@Override
	public boolean evaluate(Object value, String columnName) throws SQLException {
		return true;
	}
}

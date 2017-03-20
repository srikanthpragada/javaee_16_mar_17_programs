import oracle.jdbc.rowset.OracleCachedRowSet;

public class EmployeesByJob {

	public static void main(String[] args)  throws Exception {

		OracleCachedRowSet rs = new OracleCachedRowSet();
		rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		rs.setUsername("hr");
		rs.setPassword("hr");
		rs.setCommand("select * from employees where job_id = ?");
		rs.setString(1, "IT_PROG");
		rs.execute();
		
		
		while ( rs.next())
		{
			System.out.println( rs.getString("first_name"));
		}
		
		rs.close();

	}

}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ChangeJobTItle {

	public static void main(String[] args) throws Exception {
		
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr")) {
		    Scanner s = new Scanner(System.in);
		    System.out.print("Enter job id : ");
		    String id = s.nextLine();
		    
		    System.out.print("Enter job title  : ");
		    String title = s.nextLine();
		    
			PreparedStatement ps = con.prepareStatement
					        ("update jobs set job_title = ? where job_id = ?");
			ps.setString(1, title);
			ps.setString(2, id);
			
			int count = ps.executeUpdate();
			
			if ( count == 1)
				System.out.println("Updated Successfully!");
			else
				System.out.println("Job Id Not Found!");
			
			ps.close();
		}

	}

	 

}

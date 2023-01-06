import java.sql.*;
import java.util.*;

public class Userpasvalid {
static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		passwordvalidation();
		

	}

	private static void passwordvalidation() {
		try {
			Connection con=JDBCDEMO1.getDBconnection();
			Statement stmt=JDBCDEMO1.createstatementobject(con);
			System.out.println("enter username");
			String username=sc.next();
			System.out.println("enter pasword");
			String password=sc.next();
			String sqlquery="select count(*) from userpasvalid where username='"+username+"' AND password='"+ password+"'";
			//System.out.println(sqlquery);
			ResultSet rs=stmt.executeQuery(sqlquery);
			rs.next();
			int res=rs.getInt(1);
			if(res>0) {
				System.out.println("USER FOUND");
			
				
				}
			else {
				System.out.println("USER NOT FOUND");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

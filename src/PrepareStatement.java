import java.sql.*;
import java.util.Scanner;

public class PrepareStatement {
	static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Connection con=JDBCDEMO1.getDBconnection();
			PreparedStatement ps=con.prepareStatement("select*from userpasvalid where id=?");
			//PreparedStatement ps=con.prepareStatement("select*from t1 left join t2 on t1.id=t2.pid");
			System.out.println("enter id whre you want");
			int id=sc.nextInt();
			//ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
				//System.out.println("usernamepasword details id:"+rs.getInt(1));
				//System.out.println("usernamepasword details username:"+rs.getString(2));
				//System.out.println("usernamepasword details password:"+rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		public static void insertrow() throws SQLException {
			Connection con=null;
			try {
				con=JDBCDEMO1.getDBconnection();
				PreparedStatement ps1=con.prepareStatement("insert into userpasvalid values(?,?,?)");
				System.out.println("enter id");
				int id=sc.nextInt();
				System.out.println("enter username");
				String username=sc.next();
				System.out.println("enterpassword");
				String password=sc.next();
				//scanner input
				ps1.setInt(1, id);
				ps1.setString(2, username);
				ps1.setString(3, password);
				//static input
				//ps1.setInt(1,7);
				//ps1.setString(2, "ganesh@gmail.com");
				//ps1.setString(3, "ganesh123");
			int res=ps1.executeUpdate();
			System.out.println(res);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				con.close();
				
			}
			

	}

}

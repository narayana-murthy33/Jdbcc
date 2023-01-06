import java.sql.*;

public class JDBCDEMO1{


 

	public static void main(String[] args) throws SQLException  {
		// TODO Auto-generated method stub
		 Connection connection=null;
		 Statement statement=null;
		 ResultSet rs=null;
		
		connection=getDBconnection();
		statement=createstatementobject(connection);
		String sql="insert into userpasvalid values(5,'gundabattulateja','teja123')";
		int count=statement.executeUpdate(sql);
		System.out.println(count+"rows inserted");
		

	




	
		jdbcdemo(connection, statement, rs);
	
	}



	private static void jdbcdemo(Connection connection, Statement statement, ResultSet rs) throws SQLException {
		try {
			 connection = getDBconnection();
			//System.out.println("conncection eastablished");
			  statement = createstatementobject(connection);
			String sqlQuery="select*from collegeattendies";
			 rs=statement.executeQuery("select*from collegeattendies");
			while(rs.next()) {
				System.out.println(rs.getString(1)
						+"\t"+rs.getString(2)+"\t"+rs.getString(3));
				if(rs.getString(1).equals("19225A0150")) {
					System.out.println("successs");
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			connection.close();
			statement.close();
			rs.close();
		}
	}

	

	public static Statement createstatementobject(Connection connection) throws SQLException {
		Statement statement;
		statement=connection.createStatement();
		return statement;
	}

	public static Connection getDBconnection() throws SQLException {
		Connection connection;
		connection=DriverManager.getConnection(COSTANTS.dburl,COSTANTS.dbusername,COSTANTS.dbpassword);
		return connection;
	}

	}

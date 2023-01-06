import java.sql.*;
import java.util.*;

public class Insertmysql {
	static int id;
	static String name;
	static int sal;
	static String absentieso;
	static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		Statement stmt=null;
		try {
			con=JDBCDEMO1.getDBconnection();
			System.out.println("commcemce");
			stmt=JDBCDEMO1.createstatementobject(con);
			System.out.println("alright");
			//insertrow(stmt);
			updatequery(stmt);
			
		}catch(Exception e) {
			e.printStackTrace();
			
			
		}
	
		

	}
	public static void runtime() {
		System.out.println("please enter your id");
		id=sc.nextInt();
		System.out.println("please enter your name");
		name=sc.next();
		System.out.println("please enter sal");
		sal=sc.nextInt();
		//System.out.println("please enter absentieso");
		//absentieso=sc.next();
		
	}
	public static void insertrow(Statement stmt)throws SQLException {
		runtime();
		String insertquary="insert into emp values("  + id + "," + "'" + name + "'," + sal + ")";
		System.out.println(insertquary);
		int noofrows=stmt.executeUpdate(insertquary);
		System.out.println("....");
		System.out.println(noofrows);
		
	}
	public static void updatequery(Statement stmt)throws SQLException{
		runtime();

	//String sql = "update emp set name=" + "'" + name + "'where id=" + id;//
	String sql = "update emp set sal=" + "'" + sal + "'where id=" + id;
	int noOfRows = stmt.executeUpdate(sql);
	System.out.println("sucessfully updated");
	System.out.println(noOfRows);
		 
	
		
	}
	
}

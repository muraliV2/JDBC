package connection;
import java.util.Scanner;
import java.sql.*;
public class assignment 
{
	public static void insert()
	{
	Scanner scn = new Scanner(System.in);
	System.out.println("enter ID");
	int id = scn.nextInt();
	scn.nextLine();
	System.out.println("enter Name");
	String name = scn.nextLine();
	System.out.println("enter Capital");
	String capital = scn.nextLine();
	System.out.println("enter Population");
	String population = scn.nextLine();
	System.out.println("enter Currency");
	String currency = scn.nextLine();
	try
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
	String dburl =("jdbc:mysql://localhost:3306/add_m13?user=root&password=@");
	Connection con = DriverManager.getConnection(dburl);
	if(con != null)
	{
	System.out.println("connection successfull");	
	}
	else
	{
		System.out.println("check your connection");
		}
	String Query = " INSERT INTO COUNTRY(ID,NAME,CAPITAL,POPULATION,CURRENCY) VALUES(?,?,?,?,?)";
	PreparedStatement pstmt = con.prepareStatement(Query);
	pstmt.setInt(1, id);
	pstmt.setString(2, name);
	pstmt.setString(3, capital);
	pstmt.setString(4, population);
	pstmt.setString(5, currency);
	int op = pstmt.executeUpdate();
	if(op>0)
	{
	System.out.println("query working successfully");	
	}
	else
	{
		System.out.println("check your query");}

	}


	catch(ClassNotFoundException | SQLException e)
	{
		e.printStackTrace();
	}
	scn.close();
	}
	
	public static void update()
	{
		
	}

	
	public static void main(String [] args)
{



}
}

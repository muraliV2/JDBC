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
	String dburl =("jdbc:mysql://localhost:3306/add_m13?user=root&password=Murali@6492");
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
	
	
	public static void update() {
	    Scanner scn = new Scanner(System.in);

	    System.out.println("Enter ID to update:");
	    int id = scn.nextInt();
	    scn.nextLine();

	    System.out.println("Enter Name:");
	    String name = scn.nextLine();

	    System.out.println("Enter Capital:");
	    String capital = scn.nextLine();

	    System.out.println("Enter Population:");
	    String population = scn.nextLine();

	    System.out.println("Enter Currency:");
	    String currency = scn.nextLine();

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        String dburl = "jdbc:mysql://localhost:3306/add_m13?user=root&password=Murali@6492";
	        Connection con = DriverManager.getConnection(dburl);

	        System.out.println("Connection successful");

	        String query = "UPDATE country SET NAME=?, CAPITAL=?, POPULATION=?, CURRENCY=? WHERE ID=?";

	        PreparedStatement psmt = con.prepareStatement(query);

	        psmt.setString(1, name);
	        psmt.setString(2, capital);
	        psmt.setString(3, population);
	        psmt.setString(4, currency);
	        psmt.setInt(5, id);

	        int op = psmt.executeUpdate();

	        if (op > 0) {
	            System.out.println("Record updated successfully");
	        } else {
	            System.out.println("No record found with given ID");
	        }

	        psmt.close();
	        con.close();

	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void read()
	{
		Scanner scn = new Scanner(System.in);
		System.out.println("enter id");
		int id = scn.nextInt();
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dburl = ("jdbc:mysql://localhost:3306/add_m13?user=root&password=Murali@6492");
			Connection con = DriverManager.getConnection(dburl);
			if(con !=null)
			{
				System.out.println("connection successfull");
			}
			else
			{
				System.out.println("connection unsuccessfull");
			}
			
			String query = "SELECT * FROM STORE WHERE ID = ?";
			PreparedStatement psst = con.prepareStatement(query);
			psst.setInt(1, id);
			System.out.println("id\tname\tcapital\tpopulation\tcurrency");
			ResultSet rs = psst.executeQuery();
			if(rs.next())
			{
				String name = rs.getString("NAME");
				String capital = rs.getString("CAPITAL");
				String population = rs.getString("POPULATION");
				String currency = rs.getString("CURRENCY");
				System.out.println( id + "\t" + name + "\t" + capital + "\t" + population + "\t" + currency       );
				
			}
			else
			{
				System.out.println("check your query");
			}
			scn.close();
			con.close();
			rs.close();
			
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void delete()
	{
		Scanner scn = new Scanner(System.in);
		System.out.println("enter id (which you want to delete");
		int id = scn.nextInt();
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/add_m13?user=root&password=Murali@6492";
			Connection con = DriverManager.getConnection(dburl);
			if(con !=null)
			{
				System.out.println("connection successfull");
			}
			else
			{
				System.out.println("no connection happened");
			}
			
			String Query = "DELETE FROM COUNTRY WHERE ID=?";
			PreparedStatement psp = con.prepareStatement(Query);
			psp.setInt(1, id);
			int op = psp.executeUpdate();
			if(op>0)
			{
				System.out.println("sequenece deleted");
			}
			else
			{
				System.out.println("you have error in your code");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
public static void main(String [] args)
{
	Scanner scn = new Scanner(System.in);
	System.out.println("1.Create\n2.read\n3.update\n4.delete");
	System.out.println("enter your choice");
	int choice = scn.nextInt();
	switch(choice)
	{
	case 1 : System.out.println("you selected insert");
	         insert();
	         break;
	case 2 : System.out.println("you selected read");
             read();
             break;
	case 3 : System.out.println("you selected update");
             update();
              break;
	case 4 : System.out.println("you selected delete");
             delete();
             break;
	}



}
}

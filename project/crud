package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.Scanner;

public class CrudOperations {
	
	public static void value()
	{
		Scanner scn = new Scanner(System.in);
		System.out.println("enter id");
		int id = scn.nextInt();
		scn.nextLine();
		System.out.println("enter name");
		String name = scn.nextLine();
		System.out.println("enter quantity");
		int quantity = scn.nextInt();
		System.out.println("enter price");
		int price = scn.nextInt();
		scn.nextLine();
		System.out.println("enter Date of Expiry");
		String doe = scn.nextLine();
	
	}
	public static void insert()
	{
		Scanner scn = new Scanner(System.in);
		System.out.println("enter id");
		int id = scn.nextInt();
		scn.nextLine();
		System.out.println("enter name");
		String name = scn.nextLine();
		System.out.println("enter quantity");
		int quantity = scn.nextInt();
		System.out.println("enter price");
		int price = scn.nextInt();
		scn.nextLine();
		System.out.println("enter Date of Expiry");
		String doe = scn.nextLine();
	
	
		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/dmart?user=root&password=Murali@6492";
			Connection con = DriverManager.getConnection(dburl);
			if(con != null)
			{
				System.out.println("connection successfull");
			}
			else
			{
				System.out.println("connection unsuccessfull");
			}
			
			String query = "INSERT INTO STORE (ID,NAME,QUANTITY,PRICE,DOE) VALUES(?,?,?,?,?)";
			PreparedStatement psp =  con.prepareStatement(query);
			psp.setInt(1, id);
			psp.setString(2, name);
			psp.setInt(3, quantity);
			psp.setInt(4, price);
			psp.setString(5, doe);
			int op = psp.executeUpdate();
			if(op>0)
			{
				System.out.println("query successfull");
			}
			else
			{
				System.out.println("query unsuceessfull");
			}
		 	scn.close();
		 	con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void delete()
	{
		Scanner scn = new Scanner(System.in);
		System.out.println("enter id (to delete)");
		int id = scn.nextInt();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/dmart?user=root&password=Murali@6492";
			Connection con = DriverManager.getConnection(dburl);
			if(con!=null)
			{
				System.out.println("connection successfull");
			}
			else
			{
				System.out.println("connection unsuccessfull");
			}
			
			String url = "DELETE  FROM STORE WHERE ID =?";
			PreparedStatement psmt = con.prepareStatement(url);
			psmt.setInt(1, id);
			int op = psmt.executeUpdate();
			if(op>0)
			{
				System.out.println("query is good and working");
			}
			else
			{
				System.out.println("check the query and try again");
			}
			con.close();
		}
		catch(Exception e)
		{
			
		}
		scn.close();
		
		
	}
	public static void update()
	{
		Scanner scn = new Scanner(System.in);System.out.println("enter id");
		int id = scn.nextInt();
		scn.nextLine();
		System.out.println("enter name");
		String name = scn.nextLine();
		System.out.println("enter quantity");
		int quantity = scn.nextInt();
		System.out.println("enter price");
		int price = scn.nextInt();
		scn.nextLine();
		System.out.println("enter Date of Expiry");
		String doe = scn.nextLine();
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String dburl = "jdbc:mysql://localhost:3306/dmart?user=root&password=Murali@6492";
		 Connection con = DriverManager.getConnection(dburl);
		 if(con != null)
		 {
			 System.out.println("connection successfull");
		 }
		 else
		 {
			 System.out.println("connection not succesfull");
		 }
		 String query = "Update  STORE SET NAME=?,QUANTITY=?,PRICE=?,DOE=? WHERE ID=?";
		 PreparedStatement psst = con.prepareStatement(query);
		 psst.setString(1, name);
		 psst.setInt(2, quantity);
		 psst.setInt(3, price);
		 psst.setString(4, doe);
		 psst.setInt(5, id);
		 int op = psst.executeUpdate();
		 if(op>0)
		 {
			 System.out.println("query corrected");
		 }
		 else
		 {
			 System.out.println("check your query");
		 }
		 scn.close();
		 con.close();
		 
	}
	catch(Exception e)
	{
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
			String dburl = "jdbc:mysql://localhost:3306/dmart?user=root&password=Murali@6492";
			Connection con = DriverManager.getConnection(dburl);
			if(con != null)
			{
				System.out.println("connection successfull");
			}
			else
			{
				System.out.println("connection unsucessfull (try again ");
			}
			String Query = "SELECT * FROM STORE WHERE ID=?";
			PreparedStatement psmt = con.prepareStatement(Query);
			psmt.setInt(1, id);
			ResultSet rs = psmt.executeQuery();
			System.out.println("id \t name \t quantity \t price \t doe");
			while(rs.next())
			{
				String name = rs.getString("NAME");
				int quantity = rs.getInt("quantity");
				int price = rs.getInt("PRICE");
				String doe = rs.getString("DOE");
				System.out.print(id + "\t" + name + "\t\t" + quantity + "\t" + price + "\t" + doe);
			}
			con.close();
			scn.close();
			rs.close();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public static void main(String [] args)
	{
		Scanner scn =  new Scanner(System.in);
		System.out.println("enter choice");
		System.out.println("1.create\n2.read\n3.Update\n4.Delete");
		int choice = scn.nextInt();
		
		switch(choice)
		{
		case 1 : System.out.println("you chosed insert");
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

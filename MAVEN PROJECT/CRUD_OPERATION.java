package com.jsp.demo.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class jdbcoperation 
{
	
public static Connection  conne() throws ClassNotFoundException,SQLException
{
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		String dburl = "jdbc:mysql://localhost:3306/dmart?user=root&password=Murali@6492";
		return DriverManager.getConnection(dburl);
		
	
}
public static  void insert()
{
Scanner scn = new Scanner(System.in);
System.out.println("enter id");
int id = scn.nextInt();
scn.nextLine();
System.out.println("enter name");
String name = scn.next();
System.out.println("enter quantity");
int quantity = scn.nextInt();
System.out.println("enter price");
int price = scn.nextInt();
scn.nextLine();
System.out.println("enter doe");
String doe = scn.next();

	try
	{
	Connection con =	conne();
	
	String query ="INSERT INTO STORE (ID,NAME,QUANTITY,PRICE,DOE) VALUE(?,?,?,?,?)";
	PreparedStatement pst = con.prepareStatement(query);
	pst.setInt(1, id);
	pst.setString(2,name);
	pst.setInt(3, quantity);
	pst.setInt(4, price);
	pst.setString(5, doe);
	
	int op = pst.executeUpdate();
	if(op>0)
	{
		System.out.println("execution done");
	}
	else
	{
		System.out.println("check the query");
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	scn.close();
}

public static void read() throws ClassNotFoundException,SQLException
{
	Scanner scn = new Scanner(System.in);
	System.out.println("Enter id");
	int id = scn.nextInt();
	Connection con =conne();
	String query = "SELECT * FROM STORE WHERE ID = ?";
	PreparedStatement psmt = con.prepareStatement(query);
	psmt.setInt(1, id);
	ResultSet rs = psmt.executeQuery();
	
	
if(rs.next())
{
	String name = rs.getString("NAME");
	String quantity = rs.getString("QUANTITY");
	String price = rs.getString("PRICE");
	String doe = rs.getString("DOE");
	System.out.println( id + "\t" + name + "\t" + quantity + "\t" + price + "\t" + doe       );
}
scn.close();
}
  
public static void delete() throws ClassNotFoundException,SQLException
{
	Scanner scn = new Scanner(System.in);
	System.out.println("enter id");
	int id = scn.nextInt();
	Connection con = conne();
	String dburl = "DELETE FROM STORE WHERE ID=? ";
	PreparedStatement psmt = con.prepareStatement(dburl);
	psmt.setInt(1, id);
	int op = psmt.executeUpdate();
	if(op>0)
	{
		System.out.println("query done");
	}
	else
	{
		System.out.println("check the query");
	}
	
}
}

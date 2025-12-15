package connection;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updatenameflower 
{
public static void main(String [] args)
{
	Scanner scn = new Scanner(System.in);
	System.out.println("enter id to update");
	int id = scn.nextInt();
	
	System.out.println("enter name to update");
	String name = scn.next();
	
	try
	{
		
Class.forName("com.mysql.cj.jdbc.Driver");
String dburl = "jdbc:mysql://localhost:3306/pictures?user=root&password=Murali@6492";
Connection con = DriverManager.getConnection(dburl);
if(con != null)
{
System.out.println("connection successfull");	
}
else
{
	System.out.println("connection unsuccessfull");
	}

String query = "UPDATE  FLOWERS SET NAME = ? WHERE ID=?";
PreparedStatement psmt = con.prepareStatement(query);

psmt.setString(1, name);
psmt.setInt(2, id);
int op = psmt.executeUpdate();
if(op>0)
{
System.out.println("operation done");	
}
else
{
	System.out.println("check the query");}


	}
	catch(ClassNotFoundException | SQLException e)
	{
		e.printStackTrace();
	}
}
}

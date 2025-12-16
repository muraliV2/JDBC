package connection;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updateimage_audio 
{
public static void main(String [] args)
{
	Scanner scn = new Scanner(System.in);
	System.out.println("enter id to update");
	int id = scn.nextInt();
	
	
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

String query = "UPDATE  FLOWERS SET IMAGE = ? WHERE ID=4";
PreparedStatement psmt = con.prepareStatement(query);
FileInputStream fis1 = new FileInputStream("C:\\Users\\mural\\OneDrive\\Desktop\\New folder\\sample-15s.wav");
psmt.setBinaryStream(1, fis1);
int op = psmt.executeUpdate();
if(op>0)
{
System.out.println("operation done");	
}
else
{
	System.out.println("check the query");}


	}

	catch(ClassNotFoundException | SQLException | FileNotFoundException e)
	{
		e.printStackTrace();
	}

}

}

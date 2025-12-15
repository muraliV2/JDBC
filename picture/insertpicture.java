
package connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertimage 
{
public static void main(String [] args)
{
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
System.out.println("check the connection");	
}
String query = "INSERT INTO FLOWERS(ID,NAME,IMAGE) VALUES(?,?,?)";
PreparedStatement psm = con.prepareStatement(query);
FileInputStream fis = new FileInputStream("C:\\Users\\mural\\OneDrive\\Desktop\\New folder\\download (1).jpg");
FileInputStream fis1 = new FileInputStream("C:\\Users\\mural\\OneDrive\\Desktop\\New folder\\download (2).jpg");
FileInputStream fis2 = new FileInputStream("C:\\Users\\mural\\OneDrive\\Desktop\\New folder\\images.jpg");
FileInputStream fi3 = new FileInputStream("C:\\Users\\mural\\OneDrive\\Desktop\\New folder\\M1F1-Alaw-AFsp.wav");
psm.setInt(1, 1);
psm.setString(2, "red");
psm.setBinaryStream(3, fis);
psm.setInt(1, 2);
psm.setString(2,"rose");
psm.setBinaryStream(3, fis1);
psm.setInt(1, 3);
psm.setString(2, "ROSE");
psm.setBinaryStream(3, fis2);

psm.setInt(1, 4);
psm.setString(2, "Audio");
psm.setBinaryStream(3, fi3);
int output =psm.executeUpdate();
if(output>0)
{
System.out.println("successfull");	
}
else
{
	System.out.println("check the query");}
con.close();
psm.close();

	}

	catch(ClassNotFoundException | SQLException | FileNotFoundException e)
	{
		e.printStackTrace();
		}
}
}

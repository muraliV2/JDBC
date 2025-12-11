package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class sortdata 
{
public static void main(String [] args)
{


	try{

Class.forName("com.mysql.cj.jdbc.Driver");
String dburl = ("jdbc:mysql://localhost:3306/dmart?user=root&password=Murali@6492");
Connection con = DriverManager.getConnection(dburl);
if(con != null)
{
System.out.println("connection successfull");	
}
else
{
System.out.println("connection unsuccessfull");	
}

String query = "SELECT NAME FROM STORE ORDER BY PRICE";
PreparedStatement psp  = con.prepareStatement(query);
ResultSet rs = psp.executeQuery(query);
while(rs.next())
{
	
String name = rs.getString(1);

System.out.println(name);
}

}
	catch(ClassNotFoundException | SQLException e)
	{
		e.printStackTrace();
	}
}
}

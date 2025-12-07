package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class rodata 
{
public static void main(String [] args)
{
	Scanner scn = new Scanner(System.in);
	System.out.println("enter id");
	int id = scn.nextInt();
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("loading completed!");
		String dburl = ("jdbc:mysql://localhost:3306/dmart?user=root&password=Murali@6492");
		Connection con = DriverManager.getConnection(dburl);
		if(con!=null)
		{
			System.out.println("connection created");
		}
		else
		{
			System.out.println("connection not successfull");
		}
		
		String query = "SELECT * FROM STORE WHERE ID = ?";
		PreparedStatement psmt = con.prepareStatement(query);
		psmt.setInt(1, id);
		ResultSet rs = psmt.executeQuery();
		System.out.println("---------------------------------------------------------");
		System.out.println("id\tname\tquantity\tprice\tdoe");
		System.out.println("---------------------------------------------------------");
		if(rs.next())
		{
			int id1 = rs.getInt(1);
			String name = rs.getString(2);
			int quantity = rs.getInt(3);
			int price = rs.getInt(4);
			String doe = rs.getString(5);
			System.out.println(id1 +"\t" + name + "\t" + quantity + "\t" + price + "\t" + doe);
		}
		else
		{
			System.out.println("try again");
		}
		con.close();
		psmt.close();
		rs.close();
		scn.close();
		
	}
	catch(SQLException | ClassNotFoundException e)
	{
		e.printStackTrace();
	}

}
}

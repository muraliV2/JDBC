//Batch processing in JDBC
//Batch : Group,Processing : execution : verification
//def : Batch programming is an technique in jdbc , helps to excute multiple queries at a point of time
// NOTE  : 
   //1 : BAtch processsing only allows "OTHER THAN SELECT TYPE OF QUERIES " (STATIC,DYNAMIC)
    //2: BAtch Processing helps in CRUD Operation except,Select Queries
//Method helps to achieve Batch Processing
//1.addBatch()
//2.ExecuteBatch()

//EXAMPLE :
	//Write JDBC Program to perform insert,update & fetch data from table by using Batch processing?



package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class batch 
{
public static void main(String [] args)
{
try
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	String dburl = ("jdbc:mysql://localhost:3306/add_m13?user=root&password=Murali@6492");
	Connection con = DriverManager.getConnection(dburl);
	if(con != null)
	{
		System.out.println("connection successfull");
	}
	else
	{
		System.out.println("connection unsucesfyull");
	}
	String query = "INSERT INTO COUNTRY VALUES(10,'NEPAL','kATMANDO','10','NPR')";
	String query1 ="INSERT INTO COUNTRY VALUES(11,'USA','WS','50+','Dollar')";
	String query2 = "UPDATE COUNTRY SET NAME ='delhi' WHERE ID =1 ";
	String query3 = "DELETE FROM COUNTRY WHERE ID = 3";
	String query4 = "SELECT * FROM COUNTRY";
	Statement stmt = con.createStatement();
	stmt.addBatch(query);
	stmt.addBatch(query1);
	stmt.addBatch(query2);
	stmt.addBatch(query3);

	
	int [] count = stmt.executeBatch();
	for(int i : count)
	{
		System.out.println(i + " ");
	}
	
	ResultSet rs = stmt.executeQuery(query4);
	while(rs.next())
	{
		int id = rs.getInt(1);
		String name = rs.getString(2);
		String capital = rs.getString(3);
		String population = rs.getString(4);
		String currency =  rs.getString(5);
		System.out.println(id+" "+name+" "+capital+" "+population+" "+ currency );
	}
}
catch(ClassNotFoundException | SQLException e)
{
e.printStackTrace();	
}
}
}

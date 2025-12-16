package connection;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.mysql.cj.xdevapi.Result;

public class selectimage 
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
	System.out.println("check the connection");}
String query =  "SELECT IMAGE FROM FLOWERS WHERE ID=4";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(query);
if(rs.next())
{
	//get image as inputstream format
InputStream as = rs.getBinaryStream("image");
//convert dbstream into AudioInputStream format

AudioInputStream asd = AudioSystem.getAudioInputStream(new BufferedInputStream(as));
//GET AUDIO CLIP

Clip cip = AudioSystem.getClip();
cip.open(asd);
cip.start();
System.out.println(" Music is playing");
while(cip.isRunning())
{
System.out.println(" music playing");	
Thread.sleep(500);
}
System.out.println("/n Music playback finsihed ");
Thread.sleep(cip.getMicrosecondLength()/1000);
cip.close();
}
else
{
System.out.println("try again!!");	
}
con.close();
stmt.close();
rs.close();
}


catch(ClassNotFoundException | SQLException | IOException | UnsupportedAudioFileException | LineUnavailableException | InterruptedException e)
{
e.printStackTrace();	
}
}
}

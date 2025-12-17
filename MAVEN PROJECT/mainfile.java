package com.jsp.demo.jdbc;

public class main {
public static void main(String [] args)
{
	try
	{
jdbcoperation.insert();
jdbcoperation.update();
jdbcoperation.read();
jdbcoperation.delete();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}

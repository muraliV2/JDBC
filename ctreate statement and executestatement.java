
package com.JDBC;

/*write a jdbc program to delete a records into table?
key points to solve above requirements
i. query: Other than select type(DELETE)
ii. type of query: static type
iii. create statement: Statement interface
iv. factory method to create statement: createStatement() method
v. helper method to execute query: executeUpdate(String query) method
* */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  //loading driver
            System.out.println("Loading driver completed"); 
            String dburl = "jdbc:mysql://localhost:3306/add_m12";
            String username ="username";
            String password = "1610";
            Connection con = DriverManager.getConnection(dburl,username,password); // create connection
            if(con != null){
                System.out.println("connection established");
            }else{
                System.out.println("try again");
            }
            String query = "Insert into country values(2,'America','Washington DC','120 cr', 'USD' )"; //issue the query
            Statement stmt = con.createStatement(); //create statement
            int inserted = stmt.executeUpdate(query); //execute the statement
            if(inserted>0){
                System.out.println("Inserted successfully");
            }else{
                System.out.println("check the query");
            }
            con.close();
            stmt.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

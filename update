package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbrul = "jdbc:mysql://localhost:3306/add_m12";
            String username = "root";
            String password = "1610";
            Connection con =  DriverManager.getConnection(dbrul,username,password);
            String query = "UPDATE country SET country_population='110 cr' WHERE country_code=2";
            Statement stmt = con.createStatement();
            int affected = stmt.executeUpdate(query);
            if(affected >0){
                System.out.println("Updated successfully");
            }else {
                System.out.println("check the query");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

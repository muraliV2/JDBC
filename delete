package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbrul = "jdbc:mysql://localhost:3306/add_m12";
            String username = "user";
            String password = "1310";
            Connection con =  DriverManager.getConnection(dbrul,username,password);
            String query = "DELETE FROM country WHERE country_code=2";
            Statement stmt = con.createStatement();
            int affected = stmt.executeUpdate(query);
            if(affected >0){
                System.out.println("Deleted successfully successfully");
            }else {
                System.out.println("check the query");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    }


package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Loading_Drivers {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Loading Driver completed!");
            String dburl = "jdbc:mysql://localhost:3306/add_m12";
            String userName = "username";
            String password = "1610";
            Connection con = DriverManager.getConnection(dburl,userName,password);
            if (con != null) {
                System.out.println("Establish successfull");
            }else{
                System.out.println("not establish");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Loading_Drivers {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Loading Driver completed!");
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

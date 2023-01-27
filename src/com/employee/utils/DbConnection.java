/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employee.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class DbConnection {
    private static Connection conn;
    static{
        try{
                 Class.forName("oracle.jdbc.OracleDriver");
             conn=DriverManager.getConnection("jdbc:oracle:thin:@//Sanjay:1521/xe","empproj","mystudents");
        }catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Fail to load driver! "+e.getMessage());
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Database error! "+e.getMessage());
        }
    }
    public static Connection getConnection(){
         return conn;
    }
    public static void closeConnection(){
        try{
            conn.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Database error! "+e.getMessage());
        }
    }
   
    
}

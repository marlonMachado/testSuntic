/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class Conexion {
     Connection con;
    public Conexion(){
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");//   com.mysql.jdbc.Driver
            //Connection con
                    con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/suntic","root","");
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("show databases;");
            System.out.println("Connected");  
//            
//            Class.forName("com.mysql.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://localhost:80/testkonecta","root","");
        } catch (Exception e) {
            System.out.println("falla" );
        }
}
    public Connection getConexion(){
        return con;
    
    }
//        public static void main(String[] args) {
//       Conexion con = new Conexion();
//       con.getConexion();
//    }
}

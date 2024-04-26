/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author orell
 */
public class Conexion {
 
   static String bd = "";
    static String login = "";
    static String password = "";
    String ip = "";
    static String url = "";
    Connection connection = null;

    public Conexion(){
        try{
            
            ip = "127.0.0.1:3306";
            this.bd = "pruebaingsoftware";
            this.login = "root";
            this.password = "root";
            url="jdbc:mysql://"+ip+"/"+bd+"?useUnicode=tru"
            + "e&useJDBCCompliantTimezoneutcShift=true&useLegacyDatetimeCode=false&serverTimezone=America/Argentina/Buenos_Aires";
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,login,password);
            System.out.println("conectado");
        }catch(SQLException ex){
            System.out.println("error conexion"+ex);        
        }catch(Exception ex){
            System.out.println("error conexion"+ex);
        }
    }
    public Connection getConnection(){
        return connection;
    }
    public void desconectar(){
        connection = null;
    }
    
}

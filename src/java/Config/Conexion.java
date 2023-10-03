/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

/**
 *
 * @author yacruz
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    Connection con;

    public Conexion() {
        try {
            Class.forName("org.postgresql.Driver"); 
            con = DriverManager.getConnection("jdbc:postgresql://172.17.0.2:5432/mydb", "postgres", "postgres");
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }

    public Connection getConnection() {
        return con;
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author yacruz
 */
public class Conexiones {
    
    Connection conexion = null;
    String db = "usuarios";
    String host = "172.17.0.1";
    String port = "5432";
    String user = "postgres"; // Cambia "tu_usuario" por tu nombre de usuario de PostgreSQL
    String pass = "postgres"; // Cambia "tu_contraseña" por tu contraseña de PostgreSQL

    String driverDb = "org.postgresql.Driver";
    String url = "jdbc:postgresql://localhost:5432/tu_base_de_datos";

    public Connection conectar() {
        try {
            Class.forName(driverDb);
            conexion = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return conexion;
    }

    public Connection getConexion(){
        return conexion;
    }
    
}


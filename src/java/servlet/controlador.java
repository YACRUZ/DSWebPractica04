/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Conexiones;

/**
 *
 * @author yacruz
 */
public class controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Conexiones con = new Conexiones();
        con.conectar();
        String sql = "INSERT INTO usuarios (nombre_usuario, contrasena) VALUES (?, ?);";
        
        try(PreparedStatement ps = con.getConexion().prepareStatement(sql))
        {
            ps.setString(1, request.getParameter("nombre_usuario"));
            ps.setString(2, request.getParameter("contrasena"));
            ps.execute();

            request.getRequestDispatcher("nuevo.jsp").forward(request, response);
        }
        catch(Exception e)
        {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

}

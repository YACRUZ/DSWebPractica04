/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Empleado;
import ModeloDAO.EmpleadoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yacruz
 */
public class Controlador extends HttpServlet {
    String listar="vistas/listar.jsp";
    String add="vistas/add.jsp";
    String edit="vistas/edit.jsp";
    Empleado p=new Empleado();
    EmpleadoDAO dao=new EmpleadoDAO();
    int id;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso="";
        String action=request.getParameter("accion");
        if(action.equalsIgnoreCase("listar")){
            acceso=listar;            
        }else if(action.equalsIgnoreCase("add")){
            acceso=add;
        }
        else if(action.equalsIgnoreCase("Agregar")){
            int clave = Integer.parseInt(request.getParameter("txtclave"));
            String nombre=request.getParameter("txtnombre");
            String direccion=request.getParameter("txtdireccion");
            int telefono = Integer.parseInt(request.getParameter("txttelefono"));
            p.setClave(clave);
            p.setNombre(nombre);
            p.setDireccion(direccion);
            p.setTelefono(telefono);
            dao.add(p);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idper",request.getParameter("clave"));
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            int clave=Integer.parseInt(request.getParameter("txtclave"));
            String nombre=request.getParameter("txtnombre");
            String direccion=request.getParameter("txtdireccion");
            int telefono = Integer.parseInt(request.getParameter("txttelefono"));
            p.setClave(clave);
            p.setNombre(nombre);
            p.setDireccion(direccion);
            p.setTelefono(telefono);
            dao.edit(p);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            int clave=Integer.parseInt(request.getParameter("clave"));
            p.setClave(clave);
            dao.eliminar(clave);
            acceso=listar;
        }
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

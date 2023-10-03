<%-- 
    Document   : listar
    Created on : 2 oct 2023, 16:45:03
    Author     : yacruz
--%>


<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Empleado"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.EmpleadoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <h1>Empleados</h1>
            <a class="btn btn-success" href="Controlador?accion=add">Agregar Nuevo</a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">CLAVE</th>
                        <th class="text-center">NOMBRE</th>
                        <th class="text-center">DIRECCION</th>
                        <th class="text-center">TELEFONO</th>
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    EmpleadoDAO dao = new EmpleadoDAO();
                    List<Empleado>list=dao.listar();
                    Iterator<Empleado>iter=list.iterator();
                    Empleado per=null;
                    while(iter.hasNext()){
                        per=iter.next();
                    
                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= per.getClave()%></td>
                        <td class="text-center"><%= per.getDireccion()%></td>
                        <td class="text-center"><%= per.getTelefono()%></td>
                        <td><%= per.getNombre()%></td>
                        <td class="text-center">
                            <a class="btn btn-warning" href="Controlador?accion=editar&id=<%= per.getClave()%>">Editar</a>
                            <a class="btn btn-danger" href="Controlador?accion=eliminar&id=<%= per.getClave()%>">Remove</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>
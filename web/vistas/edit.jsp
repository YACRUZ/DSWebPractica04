<%-- 
    Document   : edit
    Created on : 28 sep 2023, 23:16:17
    Author     : yacruz
--%>

<%@page import="Modelo.Empleado"%>
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
            <div class="col-lg-6">
              <%
              EmpleadoDAO dao = new EmpleadoDAO();
              int id=Integer.parseInt((String)request.getAttribute("idper"));
              Empleado p=(Empleado)dao.list(id);
          %>
            <h1>Modificar Empleado</h1>
            <form action="Controlador">
                Clave:<br>
                <input class="form-control" type="text" name="txtclave" value="<%= p.getClave()%>"><br>
                Nombre: <br>
                <input class="form-control" type="text" name="txtnombre" value="<%= p.getNombre()%>"><br>
                Direccion: <br>
                <input class="form-control" type="text" name="txtdireccion" value="<%= p.getDireccion()%>"><br>
                Telefono: <br>
                <input class="form-control" type="text" name="txttelefono" value="<%= p.getTelefono()%>"><br>
                
                <input type="hidden" name="txtclave" value="<%= p.getClave()%>">
                <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                <a href="Controlador?accion=listar">Regresar</a>
            </form>
          </div>
          
        </div>
    </body>
</html>

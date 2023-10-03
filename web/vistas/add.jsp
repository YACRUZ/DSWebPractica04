<%-- 
    Document   : add
    Created on : 28 sep 2023, 23:11:43
    Author     : yacruz
--%>

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
                <h1>Agregar Empleado</h1>
                <form action="Controlador">
                    Clave:<br>
                    <input class="form-control" type="text" name="txtclave"><br>
                    Nombre: <br>
                    <input class="form-control" type="text" name="txtnombre"><br>
                    Direccion: <br>
                    <input class="form-control" type="text" name="txtdireccion"><br>
                    Telefono: <br>
                    <input class="form-control" type="text" name="txttelefono"><br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    <a href="Controlador?accion=listar">Regresar</a>
                </form>
            </div>

        </div>
    </body>
</html>

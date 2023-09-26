<%-- 
    Document   : procesar_login
    Created on : 25 sep 2023, 23:33:03
    Author     : yacruz
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="org.apache.commons.codec.digest.DigestUtils" %>

<%
// Inicio de sesión
    String username = request.getParameter("username");
    String password = request.getParameter("password");

// Conexión a la base de datos PostgreSQL
    String dbUrl = "jdbc:postgresql://172.17.0.2:5432/mydb";
    String dbUser = "postgres";
    String dbPassword = "postgres";

    try {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

        // Consulta SQL
        String query = "SELECT id, nombre_usuario, contrasena FROM usuarios WHERE nombre_usuario = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, username);
        
        out.println(username);
        out.println(password);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        if (resultSet.next() && DigestUtils.sha256Hex(password).equals(resultSet.getString("contrasena"))) {
            // Inicio de sesión exitoso
            session.setAttribute("id", resultSet.getInt("id"));
            response.sendRedirect("index.jsp");
        } else {
            // Inicio de sesión fallido
            out.println("Nombre de usuario o contraseña incorrectos.");
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>

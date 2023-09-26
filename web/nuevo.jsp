<%-- 
    Document   : nuevo
    Created on : 25 sep 2023, 19:01:01
    Author     : yacruz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd"&gt;

    <html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
</head>
<body>
   <body>
    <h2>Iniciar Sesión</h2>
    <form action="procesar_login.jsp" method="POST">
        <label for="username">Nombre de Usuario:</label>
        <input type="text" name="username" required><br><br>
        <label for="password">Contraseña:</label>
        <input type="password" name="password" required><br><br>
        <input type="submit" value="Iniciar Sesión">
    </form>
</body>
</body>
</html>

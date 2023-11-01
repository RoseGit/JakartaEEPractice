<%-- 
    Document   : joinemail
    Created on : 30 oct. 2023, 14:28:01
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/main.css" type="text/css">
    </head>
    <body>
        <h1>Join our emial list</h1>
        <p>To join our email list, enter your name and email below.</p>
        <!-- Mensaje de error de validacion de datos en Servlet  -->
        <p><i>${message}</i></p>
        <form action="emailListjsp" method="post">
            <input type="hidden" name = "action" value="add">
            <label>Email:</label>
            <input type="email" name="email" value="${user.email}"><br>
            <label>First Name:</label>
            <input type="text" name="firstName" value="${user.firstName}"><br>
            <label>Last Name:</label>
            <input type="text" name="lastName" value="${user.lastName}"><br>
            <label>&nbsp;</label>
            <input type="submit" value="Join Now" class="margin_left">
        </form>
    </body>
</html>

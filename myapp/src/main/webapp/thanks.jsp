<%-- 
    Document   : thanks
    Created on : 30 oct. 2023, 13:57:25
    Author     : Rose
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
        <h1>Thanks for joining our email list</h1>
        
        <p>Here is the information that you entered!</p>
        
        <label>Email:</label>
        <span>${user.email}</span><br>
        
        <label>First Name:</label>
        <span>${user.firstName}</span><br>
        
        <label>LastName:</label>
        <span>${user.lastName}</span><br>
        
        <p>To enter another email address, click on the back button in your browser or the retun button show below.</p>
        <!<!-- Regresa al mismo servlet del que fue llamado y le agrega la action join  -->
        <form action = "" method="get">
            <input type = "hidden" name="action" value="join">
            <input type="submit" value="Return">
        </form>
        
    </body>
</html>

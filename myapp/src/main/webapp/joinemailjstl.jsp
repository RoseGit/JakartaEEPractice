<%-- 
    Document   : joinemailjstl
    Created on : 6 nov. 2023, 13:48:51
    Author     : Rose
--%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<c:import url="header.html" />

<h1>Join our emial list</h1>
<p>To join our email list, enter your name and email below.</p>
<!-- Mensaje de error de validacion de datos en Servlet  -->
<c:if test="${message!=null}">
    <p><i>${message}</i></p>
</c:if>
    
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
    
    <c:import url="footer.jsp" />
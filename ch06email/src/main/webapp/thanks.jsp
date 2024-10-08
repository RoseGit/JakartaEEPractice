<%-- 
    Document   : thanks
    Created on : 14 ago 2024, 17:46:56
    Author     : ROSE DESKTOP
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<c:import url="/includes/header.html" />

<h1>Thanks for joining our email list</h1>

<p>Here is the information that you entered:</p>
<label>Email:</label>
<span>${user.emailAddress}</span><br>
<label>First Name:</label>
<span>${user.firstName}</span><br>
<label>Last Name:</label>
<span>${user.lastName}</span><br>

<p>To enter another email address, click on the Back 
    button in your browser or the Return button shown 
    below.</p>

<form action="" method="post">
    <input type="hidden" name="action" value="join">
    <input type="submit" value="Return">
</form>

<c:import url="/includes/footer.jsp" />
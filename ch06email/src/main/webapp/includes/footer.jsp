<%-- 
    Document   : footer
    Created on : 14 ago 2024, 17:49:31
    Author     : ROSE DESKTOP
--%>

<%@ page import="java.util.GregorianCalendar, java.util.Calendar" %>
<%
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentYear = currentDate.get(Calendar.YEAR);
%>
<p>&copy; Copyright <%= currentYear%> Mike Murach &amp; Associates</p>
</body>
</html>
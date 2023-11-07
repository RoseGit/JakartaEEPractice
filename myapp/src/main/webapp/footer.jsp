<%-- 
    Document   : footer
    Created on : 6 nov. 2023, 13:44:04
    Author     : Rose
--%>

<%@page import="java.util.GregorianCalendar, java.util.Calendar"  contentType="text/html" pageEncoding="UTF-8"%>
<%
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentYear = currentDate.get(Calendar.YEAR);
%>

<p>&copy; Copyright <%=currentYear%> Rose &amp; Associates</p>
</body>
</html>
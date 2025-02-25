<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>

    <h1>CD list</h1>
    <table>
        <tr>
            <th>Description</th>
            <th class="right">Price</th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach var="product" items="${products}">
        <tr>
            <td><c:out value='${product.description}' /></td>
            <td class="right">${product.priceCurrencyFormat}</td>
            <td><form action="cart" method="post">
                    <input type="hidden" name="productCode" 
                           value="${product.code}">
                    <input type="submit" 
                           value="Add To Cart">
                </form></td>        
        </tr>
        </c:forEach>
    </table>

    <p>For customer service, please send an email to ${custServEmail}.</p>

    <p>&copy; Copyright ${currentYear} Mike Murach &amp; Associates, Inc.
        All rights reserved.</p>
</body>
</html>
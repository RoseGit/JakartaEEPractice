<%-- 
    Document   : cart
    Created on : 16 ago 2024, 13:13:53
    Author     : ROSE DESKTOP
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Murach's Java Servlets and JSP</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
    <body>

        <h1>Your cart</h1>

        <table>
            <tr>
                <th>Quantity</th>
                <th>Description</th>
                <th>Price</th>
                <th>Amount</th>
                <th></th>
            </tr>

            <%@ taglib uri="jakarta.tags.core" prefix="c"%>
            <c:forEach var="item" items="${cart.items}">
                <tr>
                    <td>
                        <form action="" method="post">
                            <input type="hidden" name="productCode" value="${item.product.code}">
                            <input type=text name="quantity" value="${item.quantity}" id="quantity">
                            <input type="submit" value="Update">
                        </form>
                    </td>
                    <td>${item.product.description}</td>
                    <td>${item.product.priceCurrencyFormat}</td>
                    <td>${item.totalCurrencyFormat}</td>
                    <td>
                        <form action="" method="post">
                            <input type="hidden" name="productCode" 
                                   value="${item.product.code}">
                            <input type="hidden" name="quantity" 
                                   value="0">
                            <input type="submit" value="Remove Item">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <p><b>To change the quantity</b>, enter the new quantity 
            and click on the Update button.</p>

        <form action="" method="post">
            <input type="hidden" name="action" value="shop">
            <input type="submit" value="Continue Shopping">
        </form>

        <form action="" method="post">
            <input type="hidden" name="action" value="checkout">
            <input type="submit" value="Checkout">
        </form>

    </body>
</html>
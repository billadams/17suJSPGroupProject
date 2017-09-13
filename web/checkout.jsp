<%-- 
    Document   : checkout
    Created on : Sep 10, 2017, 12:54:16 PM
    Author     : Bill Adams
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/header.jsp" />

    <h1>Checkout</h1>
    
    <table class="table table-bordered table-striped">
        <thead>
            <tr>
                <th>Quantity</th>
                <th>Product Name</th>
                <th>Price</th>
                <th>Amount</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${oCart.items}">
                <tr>
                    <td>
                        <input type=text name="quantity" 
                            value="<c:out value='${item.quantity}'/>" id="quantity">
                    </td>
                    <td><c:out value='${item.product.productName}'/></td>
                    <td>${item.product.priceCurrencyFormat}</td>
                    <td>${item.totalCurrencyFormat}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

<c:import url="/includes/footer.jsp" />

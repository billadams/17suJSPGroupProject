<%-- 
    Document   : thanks
    Created on : Sep 18, 2017, 10:08:58 AM
    Author     : Bill Adams
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/header.jsp" />

    <h1>Thank You For Your Order</h1>
    
    <p>Order ID: ${oOrder.orderID}</p>
    <p>Order Date: ${oOrder.orderDateFormatted}</p>
    <c:forEach var="item" items="${oCart.items}">
        <p>Product Name: <c:out value="${items.productName}" /></p>
        <p>Quantity: <c:out value="${items.quantity}" /></p>
    </c:forEach>
    <p>Total: <c:out value="${oCart.cartTotalFormatted}" /></p>

    
<c:import url="/includes/footer.jsp" />
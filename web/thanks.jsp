<%-- 
    Document   : thanks
    Created on : Sep 18, 2017, 10:08:58 AM
    Author     : Bill Adams
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/header.jsp" />

<div class="col-md-8">

    <h1>Thank You For Your Order</h1>
    
    <p>Order ID: ${oOrder.orderID}</p>
    <p>Order Date: ${oOrder.orderDateFormatted}</p>
    <p>Items Ordered</p>
    <c:forEach var="item" items="${oCart.items}">
        <ul>
            <li>Product Name: <c:out value="${item.product.productName}" /></li>
            <li>Quantity: <c:out value="${item.quantity}" /></li>
        </ul>
    </c:forEach>
    <p>Order Total: <c:out value="${oCart.cartTotalFormatted}" /></p>

</div> <!-- end col-md-8 -->

    
<c:import url="/includes/footer.jsp" />
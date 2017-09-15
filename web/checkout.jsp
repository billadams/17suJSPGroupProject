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
                <th class="text-center">Quantity</th>
                <th class="text-center">Product Name</th>
                <th class="text-center">Price</th>
                <th class="text-center">Amount</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${oCart.items}">
                <tr>
                    <td class="text-center"><c:out value="${item.quantity}" /></td>
                    <td class="text-center"><c:out value="${item.product.productName}" /></td>
                    <td class="text-right">${item.product.priceCurrencyFormat}</td>
                    <td class="text-right">${item.totalCurrencyFormat}</td>
                </tr>
            </c:forEach>
                <tr>
                    <td colspan="3" class="text-right">Cart Total</td>
                    <td class="text-right text">${oCart.cartTotalFormatted}</td>
                </tr>
        </tbody>
    </table>

<c:import url="/includes/footer.jsp" />

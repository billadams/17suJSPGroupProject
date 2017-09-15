<%-- 
    Document   : cart
    Created on : Sep 10, 2017, 12:53:41 PM
    Author     : Bill Adams
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/header.jsp" />

    <h1>Your Cart</h1>
    
    <table class="table table-bordered table-striped">
        <thead>
            <tr>
                <th>Quantity</th>
                <th>Product Name</th>
                <th>Price</th>
                <th>Amount</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${oCart.items}">
                <tr>
                    <td>
                        <form action="" method="post">
                            <input type="hidden" name="action" 
                                   value="cart">
                            <input type="hidden" name="productID" 
                                   value="<c:out value='${item.product.productID}'/>">
                            <input type=text name="quantity" 
                                   value="<c:out value='${item.quantity}'/>" id="quantity">
                            <input type="hidden" name="action" 
                                   value="update">
                            <input type="submit" value="Update">
                        </form>
                    </td>
                    <td><c:out value='${item.product.productName}'/></td>
                    <td>${item.product.priceCurrencyFormat}</td>
                    <td>${item.totalCurrencyFormat}</td>
                    <td>
                        <form action="" method="post">
                            <input type="hidden" name="action" 
                                   value="cart">
                            <input type="hidden" name="productID" 
                                   value="<c:out value='${item.product.productID}'/>">
                            <input type="hidden" name="quantity" 
                                   value="0">
                            <input type="hidden" name="action" 
                                   value="cart">
                            <input type="submit" value="Remove Item">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <form action="CartController" method="post">
        <input type="hidden" name="action" value="shop">
        <button class="btn btn-primary">Continue Shopping</button>
    </form>

    <form action="CartController" method="post">
        <input type="hidden" name="action" value="checkout">
        <button class="btn btn-primary">Checkout</button>
    </form>

<c:import url="/includes/footer.jsp" />

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
                    <td class="col-md-2">
                        <form action="CartController" method="post">
                            <input type="hidden" name="action" value="update">
                            <input type="hidden" name="productID" 
                                   value="<c:out value='${item.product.productID}'/>">
                            <input type=text name="quantity" class="col-md-3" 
                                   value="<c:out value='${item.quantity}'/>" id="quantity">
                            <input type="submit" value="Update">
                        </form>
                    </td>
                    <td class="col-md-4"><c:out value='${item.product.productName}'/></td>
                    <td class="col-md-2 text-right">${item.product.priceCurrencyFormat}</td>
                    <td class="col-md-2 text-right">${item.totalCurrencyFormat}</td>
                    <td class="col-md-2 text-center">
                        <form action="CartController" method="post">
                            <input type="hidden" name="action" value="cart">
                            <input type="hidden" name="productID" 
                                   value="<c:out value='${item.product.productID}'/>">
                            <input type="hidden" name="quantity" 
                                   value="0">
                            <input type="submit" value="Remove Item">
                        </form>
                    </td>
                </tr>
            </c:forEach>
            <tr class="total-row">
                <td colspan="3" class="text-right">Cart Total</td>
                <td class="text-right text">${oCart.cartTotalFormatted}</td>
            </tr>
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

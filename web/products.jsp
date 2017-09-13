<%-- 
    Document   : products
    Created on : Sep 6, 2017, 10:20:45 AM
    Author     : nc520675
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/header.jsp" />

<h1>${msg}</h1>

<c:forEach var="product" items="${oProducts}">
    <!--<div class="row">-->
        <div class="col-md-3 text-center product">
            <img src="<c:out value='${product.imagePath}'/>" alt="Image Text">
            <p><c:out value="${product.productName}"/></p>
            <p><c:out value="${product.priceCurrencyFormat}"/></p>
                        
            <form action="CartController" method="post">
                <input type="hidden" name="action" value="cart">
                <input type="hidden" name="productID" value="<c:out value='${product.productID}' />">
                <div class="form-group row">
                    <label for="quantity" class="col-md-offset-3 col-md-3 col-form-label">Quantity:</label>
                    <div class="col-md-3">
                        <input type="number" name="quantity" class="form-control" id="quantity">
                    </div>
                </div>
                <button class="btn btn-default">Add To Cart</button>
            </form>
        </div> <!-- end col-md-3 -->
    <!--</div>  end row -->
</c:forEach>

<c:import url="/includes/footer.jsp" />

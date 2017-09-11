<%-- 
    Document   : products
    Created on : Sep 6, 2017, 10:20:45 AM
    Author     : nc520675
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/header.html" />

<h1>${msg}</h1>
<div class="row">
    <div class="col">
        <p>Product ID</p>
    </div>
    <div class="col">
        <p>Product Name</p>
    </div>
    <div class="col">
        <p>Image</p>
    </div>
    <div class="col">
        <p>Description</p>
    </div>
    <div class="col">
        <p>Price</p>
    </div>
    <div class="col">
        <p>Order</p>
    </div>
</div>


<c:forEach var="item" items="${oProducts}">
    <div class="row">
        <div class="col">
            <p><c:out value="${item.productID}" /></p>
        </div>
        <div class="col">
            <p><c:out value="${item.productName}"/> </p>
        </div>
        <div class="col">
            <img src="<c:out value="${item.imagePath}"/>" alt="<c:out value="${item.productName}"/>">
        </div>
        <div class="col">
            <p><c:out value="${item.productDesc}"/></p>
        </div>
        <div class="col">
            <p>$<c:out value="${item.price}"/></p>    
        </div>
        <div class="col">
            <form action="CartController" method="Post">
                <label>Quantity</label>
                <input type="number" name="quantity">
                <input type="hidden" name="action" value="add">
                <input type="hidden" name="productID" value="<c:out value="${item.productID}"/>">
                <input type="submit" value="Submit">    
            </form>
        </div>
    </div>
</c:forEach>

<c:import url="/includes/footer.html" />

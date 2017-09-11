<%-- 
    Document   : products
    Created on : Sep 6, 2017, 10:20:45 AM
    Author     : nc520675
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/header.html" />

<h1>${msg}</h1>

<c:forEach var="product" items="${oProducts}">
    <div class="row">
        <div class="col">
            <p><c:out value="${product.productName}"/></p>
            <img src="<c:out value='${product.imagePath}'/>" alt="Image Text">
            <p><c:out value="${product.price}"/></p>
                        
            <form action="CartServlet" method="post">
                <input type="hidden" name="action" value="add">
                <input type="hidden" name="employeeID" value="<c:out value='${product.productID}' />">
                <div class="form-group row">
                    <label for="quantity" class="col-md-3 col-form-label">First name:</label>
                    <div class="col-md-9">
                        <input type="number" name="quantity" class="form-control" id="quantity">
                    </div>
                </div>
                <button type="button">Add To Cart</button>
            </form>
        </div>
        
        
        <div class="col">
            <p><c:out value="${product.productID}" /></p>
        </div>
        <div class="col">
            <p><c:out value="${product.productName}"/> </p>
        </div>
        <div class="col">
            <img src="<c:out value="${product.imagePath}"/>" alt="<c:out value="${product.productName}"/>">
        </div>
        <div class="col">
            <p><c:out value="${product.productDesc}"/></p>
        </div>
        <div class="col">
            <p>$<c:out value="${product.price}"/></p>    
        </div>
        <div class="col">
            <form action="CartServlet" method="Post">
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

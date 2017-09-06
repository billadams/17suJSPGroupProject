<%-- 
    Document   : detailview
    Created on : Sep 6, 2017, 10:20:45 AM
    Author     : nc520675
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="/includes/header.html" />
<div class="row">
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


<c:forEach var="item" items="${oProduct}">
    <div class="row">
        <div class="col">
            <p>${item.productID}</p>
        </div>
        <div class="col">
            <p>${item.productName} </p>
        </div>
        <div class="col">
            <img src="${item.imagePath}" alt="${item.productName}">
        </div>
        <div class="col">
            <h3>${item.productDesc}</h3>
        </div>
        <div class="col">
            <h3>${item.price}</h3>    
        </div>
        <div class="col">
            <form>
                <label>Quantity</label>
                <input type="number" name="quantity">
                <input type="hidden" name="action" value="cart">
                <input type="submit" value="Submit" action="">    
            </form>
        </div>
    </div>
</c:forEach>

<c:import url="/includes/footer.html" />

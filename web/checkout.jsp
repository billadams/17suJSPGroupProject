<%-- 
    Document   : checkout
    Created on : Sep 10, 2017, 12:54:16 PM
    Author     : Bill Adams
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/header.jsp" />

    <h1>Checkout</h1>
    
    <table class="table table-bordered table-striped cart">
        <thead>
            <tr>
                <th class="text-center">Quantity</th>
                <th>Product Name</th>
                <th class="text-center">Price</th>
                <th class="text-center">Amount</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${oCart.items}">
                <tr>
                    <td class="text-center"><c:out value="${item.quantity}" /></td>
                    <td><c:out value="${item.product.productName}" /></td>
                    <td class="text-right">${item.product.priceCurrencyFormat}</td>
                    <td class="text-right">${item.totalCurrencyFormat}</td>
                </tr>
            </c:forEach>
                <tr class="total-row">
                    <td colspan="3" class="text-right">Cart Total</td>
                    <td class="text-right text">${oCart.cartTotalFormatted}</td>
                </tr>
        </tbody>
    </table>
                
    <div class="col-md-6">
        <form action="CartController" method="post">
            <input type="hidden" name="action" value="completeOrder">
            <legend>Please enter your information</legend>
            
            <c:if test="${errorMessages != null}">
                <div class="alert alert-danger" role="alert">
                    <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                    <c:forEach var="error_message" items="${errorMessages}">
                        <ul>
                            <li>${error_message}</li>
                        </ul>
                    </c:forEach>
                </div>
            </c:if>  

            <div class="form-group row">
                <label for="first-name" class="col-md-3 col-form-label">First name:</label>
                <div class="col-md-9">
                    <input type="text" name="firstName" class="form-control" id="first-name" value="<c:out value='${oCustomer.firstName}' />">
                </div>
            </div> <!-- end form-group -->

            <div class="form-group row">
                <label for="last-name" class="col-md-3 col-form-label">Last name:</label>
                <div class="col-md-9">
                    <input type="text" name="lastName" class="form-control" id="last-name" value="<c:out value='${oCustomer.lastName}' />">
                </div>
            </div> <!-- end form-group -->

            <div class="form-group row">
                <label for="street" class="col-md-3 col-form-label">Street:</label>
                <div class="col-md-9">
                    <input type="text" name="street" class="form-control" id="street" value="<c:out value='${oCustomer.street}' />">
                </div>
            </div> <!-- end form-group -->
            
            <div class="form-group row">
                <label for="city" class="col-md-3 col-form-label">City:</label>
                <div class="col-md-9">
                    <input type="text" name="city" class="form-control" id="city" value="<c:out value='${oCustomer.city}' />">
                </div>
            </div> <!-- end form-group -->
            
            <div class="form-group row">
                <label for="state" class="col-md-3 col-form-label">State:</label>
                <div class="col-md-9">
                    <select name="state" class="form-control" id="state">
                        <%--<c:choose>--%>
                            <%--<c:when test="${oCustomer.state != null}">--%>
                                <%--<c:out value="${oCustomer.state}" />--%>
                            <%--</c:when>--%>
                            <%--<c:otherwise>--%>
                                <option value="">Select Your State</option>
                                <option value="NE">Nebraska</option>
                            <%--</c:otherwise>--%>
                        <%--</c:choose>--%>
                    </select>
                </div>
            </div> <!-- end form-group -->
            
            <div class="form-group row">
                <label for="zipcode" class="col-md-3 col-form-label">City:</label>
                <div class="col-md-9">
                    <input type="text" name="zipcode" class="form-control" id="zipcode" value="<c:out value='${oCustomer.zip}' />">
                </div>
            </div> <!-- end form-group -->
            
            <div class="form-group row">
                <label for="phone" class="col-md-3 col-form-label">Phone:</label>
                <div class="col-md-9">
                    <input type="text" name="phone" class="form-control" id="phone" value="<c:out value='${oCustomer.phone}' />">
                </div>
            </div> <!-- end form-group -->
            
            <div class="form-group row">
                <label for="email" class="col-md-3 col-form-label">Email:</label>
                <div class="col-md-9">
                    <input type="text" name="email" class="form-control" id="email" value="<c:out value='${oCustomer.email}' />">
                </div>
            </div> <!-- end form-group -->

            <div class="form-group row">
                <div>
                    <input class="btn btn-primary" type="submit" value="Complete Order">
                </div>
            </div> <!-- end form-group -->

        </form>
    </div> <!-- end col-md-6 -->            

<c:import url="/includes/footer.jsp" />

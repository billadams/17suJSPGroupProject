<%-- 
    Document   : index
    Created on : Jul 26, 2017, 11:18:14 AM
    Author     : Bill Adams
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/header.jsp" />

<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
        <div class="item active">
            <img src="images/he-slideshow1.jpg" alt="Husker Electronics">
        </div>

        <div class="item">
            <img src="images/he-slideshow2.jpg" alt="Merchandise">
        </div>

        <div class="item">
            <img src="images/he-slideshow3.jpg" alt="Audio Equipment">
        </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

<div class="row">
    
    <div class="col-md-8">
        <h1>Husker Electronics</h1>
        <main>Husker Electronics is your superstore for everything electronic.</main>

        <h2>Featured Products</h2>
        <div class="row">
            <div class="col-md-4 featured-product text-center">
                <h5>iPhone 7 Plus</h5>
                <img src="images/iphone-7s-200x200.png" alt="iPhone7 Plus">
                <div class="form-group">
                    <a href="HomeController?action=filter&category=Phones">
                        <button class="btn btn-default">All SmartPhones</button>
                    </a>
                </div>
            </div> <!-- end col-md-4 -->
            <div class="col-md-4 featured-product text-center">
                <h5>Samsung HDTV</h5>
                <img src="images/60-inch-samsung-flatscreen.jpg" alt="Smart HDTV">
                <div class="form-group">
                    <a href="HomeController?action=filter&category=Desktops">
                        <button class="btn btn-default">All Desktops</button>
                    </a>
                </div>
            </div> <!-- end col-md-4 -->
            <div class="col-md-4 featured-product text-center">
                <h5>Dell Optiplex 3040</h5>
                <img src="images/dell-optiplex-3040.jpg" alt="Optiplex 3040">
                <div class="form-group">
                    <a href="HomeController?action=filter&category=Televisions">
                        <button class="btn btn-default">All TVs</button>
                    </a>
                </div>
            </div> <!-- end col-md-4 -->
        </div> <!-- end row -->
    </div> <!-- end col-md-8 -->
    
    <div class="col-md-4">
        <h3>Satisfaction Guarantee</h3>
        <p>At Husker Electronics, we are committed to your satisfaction.</p>
    </div> <!-- end col-md-4 -->
    
</div> <!-- end row -->

<c:import url="/includes/footer.jsp" />
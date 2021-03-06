<%-- 
    Document   : header
    Created on : Sep 13, 2017, 8:49:47 AM
    Author     : Bill Adams
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/bootstrap.css" type="text/css"/>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
        <title>Employee List</title>
    </head>
    <body>
                
        <div class="container">
            
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="index.jsp"><img src="images/he-logo.png" alt="HE Logo"></a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="index.jsp">Home <span class="sr-only">(current)</span></a></li>
                            <!--<li><a href="#">Link</a></li>-->
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Products <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="HomeController?action=filter&category=all">All Products</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="HomeController?action=filter&category=Phones">SmartPhones</a></li>
                                    <li><a href="HomeController?action=filter&category=Desktops">Desktops</a></li>
                                    <li><a href="HomeController?action=filter&category=Laptops">Laptops</a></li>
                                    <li><a href="HomeController?action=filter&category=Televisions">TVs</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="HomeController?action=filter&category=Accessories">Accessories</a></li>
                                </ul>
                            </li>
                            <li><a href="about.jsp">About</a></li>
                            <li><a href="contact.jsp">Contact</a></li>
                        </ul>
<!--                        <form class="navbar-form navbar-left">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Search">
                            </div>
                            <button type="submit" class="btn btn-default">Submit</button>
                        </form>-->
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a href="cart.jsp">
                                    <span class="glyphicon glyphicon-shopping-cart"></span> Shopping Cart (<c:out value="${cartTotalItems}" />)
                                </a>
                            </li>
<!--                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Action</a></li>
                                    <li><a href="#">Another action</a></li>
                                    <li><a href="#">Something else here</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="#">Separated link</a></li>
                                </ul>
                            </li>-->
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </nav>

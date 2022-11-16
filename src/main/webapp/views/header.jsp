<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
  <a class="navbar-brand" href="#">Simple Ecommerce</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="home">Home <span class="sr-only">(current)</span></a>
      </li>
      
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Categories
        </a>
        
        <!-- Load all category to home page and product pages -->
        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
          <c:forEach items="${listCategories}" var="o">
          	<li><a class="dropdown-item" href="product?cID=${o.categoryID}"> ${o.icons} ${o.categoryName} </a></li>
          </c:forEach>
        </ul>
      </li>
      
      <li class="nav-item">
        <a class="nav-link" href="product?cID=All">Product</a>
      </li>
      <li class="nav-item">
      <li class="nav-item">
        <a class="nav-link" href="#">Cart</a>
      </li>
      <li class="nav-item">
        <a class="nav-link " href="#">Contact</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>

<section class="jumbotron text-center">
	<div class="container">
		<h1 class="jumbotron-heading">E-COMMERCE BOOTSTRAP THEME</h1>
		<p class="lead text-muted mb-0">Simple theme for e-commerce buid
			with Bootstrap 4.0.0. Pages available : home, category, product, cart
			contact</p>
	</div>
</section>

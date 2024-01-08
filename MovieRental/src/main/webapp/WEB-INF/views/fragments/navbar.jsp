<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="top-nav">
    <div class="nav-container">
        <a href="${pageContext.request.contextPath}/movieList" class="logo">MovieRental</a>
        <div class="nav-items">
            <div class="search-and-add">
                <form action="${pageContext.request.contextPath}/search" method="get">
                    <input type="text" name="query" placeholder="Search movies...">
                    <button type="submit">Search</button>
                </form>
                <a href="${pageContext.request.contextPath}/addMovie" class="nav-item">Add New Movie</a>
            </div>
            <div class="auth-buttons">
                <c:if test="${empty sessionScope.user}">
                    <!-- User not logged in, display login and register -->
                    <a href="${pageContext.request.contextPath}/login" class="nav-item">Login</a>
                    <a href="${pageContext.request.contextPath}/register" class="nav-item">Register</a>
                </c:if>
                <c:if test="${not empty sessionScope.user}">
                    <!-- User logged in, display username and logout -->
                    <div class="welcome-text">Welcome, ${sessionScope.user.username}</div>
                    <a href="${pageContext.request.contextPath}/cart" class="nav-item">Shopping Cart</a>
                    <a href="${pageContext.request.contextPath}/orderList" class="nav-item">Order List</a>
                    <a href="${pageContext.request.contextPath}/logout" class="nav-item">Logout</a>
                </c:if>
            </div>
        </div>
    </div>
</div>

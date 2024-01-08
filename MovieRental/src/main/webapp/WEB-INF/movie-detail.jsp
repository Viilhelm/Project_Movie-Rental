<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="comp413.movierental.beans.Movie" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/styles.css">
    <title>Movie Detail</title>
    <style>
        body {
            text-align: center; /* Keep center alignment for body to center the content container */
            font-family: Arial, sans-serif;
        }

        .content-container {
            display: inline-block; /* Inline-block will make the container width shrink to fit its content */
            text-align: left; /* Align text to the left inside the content container */
            margin-top: 20px; /* Adjust as necessary for spacing from the navbar */
        }

        .movie-detail-container {
            padding: 20px;
            border: 1px solid #ddd;
            background-color: #f9f9f9;
            margin-bottom: 20px; /* Spacing after the container */
        }

        .back-link {
            display: block; /* Display block for the link to take its own line */
            margin-bottom: 10px; /* Spacing after the link */
            color: #06c;
            font-size: 16px;
            text-decoration: none;
        }

        .actions {
            display: flex;
            justify-content: space-between; 
            align-items: center;
            margin-top: 20px;
        }

        .actions .edit-delete {
            display: flex;
            justify-content: flex-start;
        }

        .actions a, .actions form {
            margin: 10px;
        }

        a {
            color: #06c;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

    </style>
</head>
<body>
    <% if (session.getAttribute("errorMessage") != null) { %>
        <script>
            alert('<%= session.getAttribute("errorMessage") %>');
            <% session.removeAttribute("errorMessage"); %>
        </script>
    <% } %>
    <jsp:include page="/WEB-INF/views/fragments/navbar.jsp" />
    <div class="content-container"> <!-- This container will be centered by the body's text-align -->
        <a href="${pageContext.request.contextPath}/movieList" class="back-link">Back to Movie List</a>
        <c:if test="${not empty movie}">
            <div class="movie-detail-container">
                <h2>Movie Details: ${movie.title}</h2>
                <p>Title: ${movie.title}</p>
                <p>Year: ${movie.movieyear}</p>
                <p>Genre: ${movie.genre}</p>
                <p>Leading Actor: ${movie.leadingactor}</p>
                <p>Studio: ${movie.studio}</p>
                <p>Director: ${movie.director}</p>
                <p>Length: ${movie.length} minutes</p>
                <p>Rental Price: $${movie.rentalprice}</p>
                <p>Cost Production: $${movie.costproduction} million</p>
                <p>Estimated Box Office Revenue: $${movie.estimatedboxofficerevenue} million</p>
                <div class="actions">
                    <div class="edit-delete">
                        <a href="${pageContext.request.contextPath}/editMovie?id=${movie.id}">Edit</a>
                        <a href="${pageContext.request.contextPath}/deleteMovie?id=${movie.id}" onclick="return confirm('Are you sure?')">Delete</a>
                    </div>
                    <div class="cart-action">
                        <a href="${pageContext.request.contextPath}/addToCart?id=${movie.id}" class="add-cart-link">Add to Cart</a>
                    </div>
                </div>
            </div>
        </c:if>
        <c:if test="${empty movie}">
            <p>Movie not found.</p>
        </c:if>
    </div>
</body>
</html>

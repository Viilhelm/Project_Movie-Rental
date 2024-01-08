<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/styles.css">
    <title>Movie List</title>
    <style>
        .movie-section {
            max-width: 800px; /* Or whatever width you prefer */
            margin: 0 auto; /* This will center your section */
            padding: 20px; /* Adds padding inside the section */
        }

        .movie-list-title {
            text-align: left; /* Aligns the title to the left of the section */
            margin: 0; /* Removes default margin from the h2 element */
            padding-bottom: 10px; /* Adds a little space below the title */
            border-bottom: 1px solid #ddd; /* Adds a separator line */
        }
        .movie-item {
            border: 1px solid #ddd;
            padding: 10px;
            margin-bottom: 10px;
            background-color: #f9f9f9; /* Light gray background */
            list-style-type: none; /* Remove default list item styling */
        }
        .movie-item:hover {
            background-color: #f0f0f0;
        }
        
        .movie-actions button {
            margin-right: 5px;
        }
        
        .actions a {
            margin-right: 10px;
            text-decoration: none;
            color: #06c;
        }
        .actions a:hover {
            text-decoration: underline;
        }
        
        .actions {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .action-link:hover {
            background-color: #0056b3;
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
    <div class="movie-section">
        <h2 class="movie-list-title">Movie List</h2>
        <ul>
            <c:forEach var="movie" items="${movies}">
                <li class="movie-item" onclick="window.location.href='${pageContext.request.contextPath}/movieDetail?id=${movie.id}'">
                    <h3>${movie.title} (${movie.movieyear})</h3>
                    <p>Genre: ${movie.genre}</p>
                    <p>Director: ${movie.director}</p>
                    <p>Leading Actor: ${movie.leadingactor}</p>
                    <p>Length: ${movie.length} minutes</p>
                    <p>Rental Price: $${movie.rentalprice}</p>
                    <div class="actions">
                        <div class="action-buttons">
                            <a href="${pageContext.request.contextPath}/editMovie?id=${movie.id}" >Edit</a>
                            <%-- 
                            <form method="post" action="${pageContext.request.contextPath}/deleteMovie">
                                <input type="hidden" name="id" value="${movie.id}">
                                <input type="submit" value="Delete" onclick="return confirm('Are you sure you want to delete this movie?');">
                            </form>
                            --%>
                            <a href="${pageContext.request.contextPath}/deleteMovie?id=${movie.id}" onclick="return confirm('Are you sure?')">Delete</a>
                        </div>
                        <div class="cart-button">
                            <a href="${pageContext.request.contextPath}/addToCart?id=${movie.id}" class="cart-action">Add to Cart</a>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>

</body>
</html>

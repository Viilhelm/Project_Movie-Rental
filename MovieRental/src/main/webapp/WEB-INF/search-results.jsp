<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/styles.css">
    <title>Search Results</title>
    <style>
        body {
            text-align: center; /* Center text for all elements */
            margin: 0; /* Ensure there are no default margins */
            padding: 0; /* Ensure there are no default paddings */
            font-family: Arial, sans-serif; /* Optional: Set a default font for the page */
        }

        .container {
            max-width: 800px; /* Or whatever maximum width you prefer */
            margin: 20px auto; /* This will center the container and add space on the top */
            text-align: left; /* Align text to the left within the centered container */
        }

        .movie-list {
            list-style-type: none; /* Remove bullets from list */
            padding: 0; /* Remove default padding */
            margin: 0; /* Remove default margin to align with the top of the container */
        }

        .movie-item {
            cursor: pointer;
            transition: background-color 0.3s;
            border: 1px solid #ddd;
            padding: 10px;
            margin-bottom: 10px; /* Space between list items */
            /* Ensure text alignment is consistent */
            text-align: left;
        }

        .movie-item:hover {
            background-color: #f0f0f0;
        }

    </style>
</head>
<body>
    <jsp:include page="/WEB-INF/views/fragments/navbar.jsp" />
    <div class="container">
        <h1>Search Results</h1>
        <c:choose>
            <c:when test="${not empty searchResults}">
                <ul class="movie-list">
                    <c:forEach items="${searchResults}" var="movie">
                        <li class="movie-item" onclick="window.location.href='${pageContext.request.contextPath}/movieDetail?id=${movie.id}'">
                            ${movie.title} (${movie.movieyear})
                        </li>
                    </c:forEach>
                </ul>
            </c:when>
            <c:otherwise>
                <p>No movies found matching your search.</p>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>

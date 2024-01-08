<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="comp413.movierental.beans.Movie" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/styles.css">
    <title>Edit Movie</title>
    <style>
        .movie-form-container {
            border: 1px solid #ddd;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            background-color: white;
            width: 80%; 
            max-width: 600px; 
            margin: 50px auto; 
            display: block;
        }

        .movie-form-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        .form-group {
            display: flex;
            flex-direction: column;
            margin-bottom: 15px;
        }

        .form-group label {
            text-align: left; 
            margin-bottom: 5px;
        }

        .form-group input[type="text"],
        .form-group input[type="number"] {
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 4px;
            width: 100%; 
        }

        .form-group input[type="submit"] {
            background-color: #5cb85c;
            color: white;
            cursor: pointer;
            padding: 10px;
            border: none;
            border-radius: 4px;
            margin-top: 10px;
        }

        .submit-group {
            display: flex;
            justify-content: center; 
        }
        
       
        .submit-group input[type="submit"] {
            background-color: #5cb85c; 
            color: white; 
            cursor: pointer; 
            padding: 10px 15px; 
            border: none; 
            border-radius: 4px; 
            font-size: 1em; 
            margin-top: 10px; 
            width: auto; 
            display: inline-block;
        }

        .submit-group input[type="submit"]:hover {
            background-color: #4cae4c; 
        }

       
    </style>
</head>
<body>
    <jsp:include page="/WEB-INF/views/fragments/navbar.jsp" />
        <div class="movie-form-container">
        <h2>Edit Movie</h2>
        <c:choose>
            <c:when test="${not empty movie}">
                <form action="${pageContext.request.contextPath}/editMovie" method="post">
                    <!-- 隐藏字段用于传递电影ID -->
                    <input type="hidden" name="id" value="${movie.id}">

                    <div class="form-group">
                        <label for="title">Title:</label>
                        <input type="text" id="title" name="title" value="${movie.title}" required>
                    </div>
                    <div class="form-group">
                        <label for="movieYear">Year:</label>
                        <input type="number" id="movieYear" name="movieYear" value="${movie.movieyear}" required>
                    </div>
                    <div class="form-group">
                        <label for="genre">Genre:</label>
                        <input type="text" id="genre" name="genre" value="${movie.genre}">
                    </div>
                    <div class="form-group">
                        <label for="leadingActor">Leading Actor:</label>
                        <input type="text" id="leadingActor" name="leadingActor" value="${movie.leadingactor}">
                    </div>
                    <div class="form-group">
                        <label for="studio">Studio:</label>
                        <input type="text" id="studio" name="studio" value="${movie.studio}">
                    </div>
                    <div class="form-group">
                        <label for="director">Director:</label>
                        <input type="text" id="director" name="director" value="${movie.director}">
                    </div>
                    <div class="form-group">
                        <label for="length">Length (minutes):</label>
                        <input type="number" id="length" name="length" value="${movie.length}" min="1" step="any">
                    </div>
                    <div class="form-group">
                        <label for="rentalPrice">Rental Price:</label>
                        <input type="number" id="rentalPrice" name="rentalPrice" value="${movie.rentalprice}" step="0.01" min="0">
                    </div>
                    <div class="form-group">
                        <label for="costProduction">Cost Production (million):</label>
                        <input type="number" id="costProduction" name="costProduction" value="${movie.costproduction}" step="0.01" min="0">
                    </div>
                    <div class="form-group">
                        <label for="estimatedBoxOfficeRevenue">Estimated Box Office Revenue (million):</label>
                        <input type="number" id="estimatedBoxOfficeRevenue" name="estimatedBoxOfficeRevenue" value="${movie.estimatedboxofficerevenue}" step="0.01" min="0">
                    </div>
                    <div class="submit-group">
                        <input type="submit" value="Update Movie">
                    </div>
                </form>
            </c:when>
            <c:otherwise>
                <p>Movie not found.</p>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>

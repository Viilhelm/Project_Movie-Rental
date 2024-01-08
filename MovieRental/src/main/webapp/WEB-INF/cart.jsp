<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="comp413.movierental.beans.ShoppingCart" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/styles.css">
    <title>Shopping Cart</title>
    <style>
        body {
            font-family: Arial, sans-serif; /* Set a default font for your page */
            margin: 0;
            padding: 0;
            background: #f4f4f4; /* Add a light grey background */
        }

        .shopping-cart-container {
            width: 60%; /* Set width to 60% for the container */
            margin: 30px auto; /* This will center your table and give some space from the top */
            background: #fff; /* Background color for the cart area */
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Add some shadow for a subtle depth effect */
        }

        table {
            width: 100%; /* Make table take full width of its container */
            border-collapse: collapse; /* Collapse borders */
        }

        th, td {
            text-align: left; /* Align text to the left in table headers and cells */
            padding: 10px; /* Add padding for visual space inside cells */
            border-bottom: 1px solid #ddd; /* Add a light bottom border to each cell */
        }

        th {
            background: #333; /* Dark background for the header */
            color: #fff; /* White text color for the header */
        }

        tr:hover {
            background-color: #f5f5f5; /* Add a hover effect for each row */
        }

        a {
            color: #06c; /* Set a blue color for links */
            text-decoration: none; /* Remove underline from links */
        }

        a:hover {
            text-decoration: underline; /* Add underline on hover for links */
        }

        .empty-cart {
            text-align: center; /* Center the empty cart message */
        }
        
        .confirm-btn-container {
            text-align: right; /* Aligns the button to the right */
            margin-top: 10px; /* Adds space between the table and the button */
        }

        .confirm-order-btn {
            padding: 10px 20px; /* Adds padding inside the button */
            background-color: #4CAF50; /* Sets the background color */
            color: white; /* Sets the text color */
            border: none; /* Removes the border */
            text-decoration: none; /* Removes the underline from the text */
            font-size: 16px; /* Sets the font size */
            cursor: pointer; /* Changes the cursor to a pointer on hover */
            border-radius: 5px; /* Rounds the corners of the button */
        }

        .confirm-order-btn:hover {
            background-color: #45a049; /* Darkens the button on hover */
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
    <div class="shopping-cart-container">
        <h2>Your Shopping Cart</h2>
        <c:if test="${not empty cartEntries}">
            <table>
                <tr>
                    <th>Movie Title</th>
                    <th>Quantity</th>
                    <th>Rental Price</th>
                    <th>Actions</th>
                </tr>
                <c:set var="totalPrice" value="0" />
                <c:forEach items="${cartEntries}" var="entry">
                    <tr>
                        <td>${entry.movie.title}</td>
                        <td>${entry.quantity}</td>
                        <td>${entry.movie.rentalprice}</td>
                        <c:set var="totalPrice" value="${totalPrice + (entry.movie.rentalprice * entry.quantity)}" />
                        <td><a href="${pageContext.request.contextPath}/removeFromCart?id=${entry.cartId}">Remove</a></td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="2"><strong>Total:</strong></td>
                    <td><strong>${totalPrice}</strong></td> <!-- 显示总价格 -->
                    <td></td>
                </tr>
            </table>
            <div class="confirm-btn-container">
                <form action="${pageContext.request.contextPath}/confirmOrder" method="post">
                    <input type="submit" value="Confirm Order" class="confirm-order-btn" />
                </form>
            </div>
        </c:if>
        <c:if test="${empty cartEntries}">
            <p class="empty-cart">Your cart is empty.</p>
        </c:if>
    </div>
</body>
</html>

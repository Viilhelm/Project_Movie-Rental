<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="comp413.movierental.beans.Order" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/styles.css">
    <title>Order List</title>
    <style>
        body {
            font-family: Arial, sans-serif; /* Set a default font for your page */
            margin: 0;
            padding: 0;
            background: #f4f4f4; /* Add a light grey background */
        }

        .order-list-container {
            width: 80%; /* Set width to 80% for the container */
            margin: 30px auto; /* This will center your table and give some space from the top */
            background: #fff; /* Background color for the cart area */
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Add some shadow for a subtle depth effect */
        }

        table {
            width: 100%; /* Make table take full width of its container */
            border-collapse: collapse; /* Collapse borders */
            margin-top: 20px; /* Add some space above the table */
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
    </style>
</head>
<body>
    <jsp:include page="/WEB-INF/views/fragments/navbar.jsp" />
    <div class="order-list-container">
        <h1>Order List</h1>
        <c:if test="${not empty orders}">
            <table>
                <tr>
                    <th>Order ID</th>
                    <th>Date</th>
                    <th>Status</th>
                    <th>Total</th>
                    <th>Details</th>
                </tr>
                <c:forEach items="${orders}" var="order">
                    <tr>
                        <td>${order.orderId}</td>
                        <td>${order.orderDate}</td> 
                        <td>${order.status}</td> 
                        <td>$${order.total}</td> 
                        <td><a href="${pageContext.request.contextPath}/orderDetails?orderId=${order.orderId}">View Details</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <c:if test="${empty orders}">
            <p>No orders found.</p>
        </c:if>
    </div>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="comp413.movierental.beans.Order" %>
<%@ page import="comp413.movierental.beans.OrderDetail" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/styles.css">
    <title>Order Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background: #f4f4f4;
        }

        .order-details-container {
            width: 60%;
            margin: 30px auto;
            background: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            text-align: left;
            padding: 10px;
            border-bottom: 1px solid #ddd;
        }

        th {
            background: #333;
            color: #fff;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        a {
            color: #06c;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        .empty-order {
            text-align: center;
        }
        
        .back-link {
            display: block; /* Display block for the link to take its own line */
            margin-bottom: 10px; /* Spacing after the link */
            color: #06c;
            font-size: 16px;
            text-decoration: none;
            margin-top: 20px; /* Adjust as necessary for spacing from the navbar */
        }

        .back-link:hover {
            text-decoration: underline; /* Add underline on hover for links */
        }
    </style>
</head>
<body>
    <jsp:include page="/WEB-INF/views/fragments/navbar.jsp" />
    <div class="order-details-container">
        <h2>Order Details</h2>
        <a href="${pageContext.request.contextPath}/orderList" class="back-link">Back to Order List</a>
        <c:if test="${not empty orderDetails}">
            <table>
                <tr>
                    <th>Product Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Total</th>
                </tr>
                <c:set var="totalPrice" value="0" />
                <c:forEach items="${orderDetails}" var="detail">
                    <tr>
                        <td>${detail.movie.title}</td>
                        <td>${detail.quantity}</td>
                        <td>$${detail.price}</td>
                        <c:set var="totalPrice" value="${totalPrice + (detail.price * detail.quantity)}" />
                        <td>$${detail.price * detail.quantity}</td>
                    </tr>
                </c:forEach>

                <tr>
                    <td colspan="3"><strong>Total:</strong></td>
                    <td><strong>$${totalPrice}</strong></td>
                </tr>
            </table>
        </c:if>
        <c:if test="${empty orderDetails}">
            <p class="empty-order">This order has no details.</p>
        </c:if>
    </div>
</body>
</html>

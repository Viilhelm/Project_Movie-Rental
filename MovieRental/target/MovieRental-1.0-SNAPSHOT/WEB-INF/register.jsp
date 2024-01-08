<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/styles.css">
    <title>Register</title>
    <style>
        .register-box {
            border: 1px solid #ddd;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            background-color: white;
            width: 340px; /* Adjust width as needed */
            margin: 60px auto 20px; /* Increase top margin to create space */
            display: block;
            text-align: center; /* Center the text */
        }

        .register-box h2 {
            text-align: center;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block; /* 使标签独占一行 */
            text-align: left; /* 左对齐文本 */
            margin-bottom: 5px; /* 添加一些间隔 */
        }

        .form-group input {
            width: calc(100% - 20px); /* 减去padding的宽度 */
            padding: 10px; /* 输入框的内边距 */
            margin-bottom: 15px; /* 添加一些间隔 */
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        .form-group button {
            width: 100%;
            padding: 10px;
            background-color: #5cb85c;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .form-group button:hover {
            background-color: #4cae4c;
        }

        .error-message {
            color: red;
            text-align: center;
        }

        .login-link {
            text-align: center;
        }
    </style>
</head>
<body>
    <jsp:include page="/WEB-INF/views/fragments/navbar.jsp" />
    <div class="register-box">
        <h2>Register</h2>
        <form action="${pageContext.request.contextPath}/register" method="post">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="form-group">
                <label for="confirmPassword">Confirm Password:</label>
                <input type="password" id="confirmPassword" name="confirmPassword" required>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="form-group">
                <button type="submit">Register</button>
            </div>
        </form>
        <div class="login-link">
            <p>Already have an account? <a href="${pageContext.request.contextPath}/login">Login here</a>.</p>
        </div>
    </div>
</body>
</html>

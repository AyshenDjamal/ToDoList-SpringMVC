<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>
        body {
            background: #dfe6fb;
            font-family: Arial;
        }
        .container {
            width: 350px;
            margin: 80px auto;
            padding: 30px;
            background: white;
            border-radius: 10px;
            box-shadow: 0 0 10px #ccc;
        }
        h2 {
            text-align: center;
            color: #0059b3;
        }
        input {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #aaa;
            border-radius: 5px;
        }
        button {
            width: 100%;
            background: #0073e6;
            color: white;
            border: none;
            padding: 10px;
            border-radius: 5px;
            cursor: pointer;
        }
        button:hover {
            background: #005bb5;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Login Page</h2>

    <!-- Error mesajı -->
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>

    <form action="login" method="post">
        <input type="email" name="email" placeholder="Email" required>
        <input type="password" name="password" placeholder="Password" required>
        <button type="submit">Login</button>
    </form>
    <div style="text-align: center; margin-top: 15px;">
        <a href="/">Don't have an account? Register</a>
    </div>

</div>
</body>
</html>

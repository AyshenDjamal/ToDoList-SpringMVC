<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
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
            box-shadow: 0 0 10px #b3d1ff;
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
        a {
            display: block;
            text-align: center;
            margin-top: 10px;
            color: #0073e6;
        }
        .error {
            color: red;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Create Account</h2>

    <!-- Error mesajı -->
    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>

    <form action="register" method="post">
        <input type="text" name="fullName" placeholder="Full Name" required>
        <input type="email" name="email" placeholder="Email" required>
        <input type="password" name="password" placeholder="Password" required>
        <button type="submit">Register</button>
        <a href="login">Already registered? Login here</a>
    </form>
</div>
</body>
</html>

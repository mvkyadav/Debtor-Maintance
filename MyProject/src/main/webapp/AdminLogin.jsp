<%--
  Created by IntelliJ IDEA.
  User: Vamshi
  Date: 27-12-2021
  Time: 09:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<header>
    <h1 class="header">Admin Login</h1>
    <br />
</header>
<form action = /AdminLoginServlet method="post">
    <div class="body">
        <div class="main">
            <label>Username</label>
            <input type="text" name="username" required/><br /><br />

            <label>Password</label>
            <input type="password" name="password" required/><br /><br />


            <% String error;%>
            <%
                error = (String) request.getAttribute("exception");
                if(error!=null) {
            %>
            <p style="color: red">User Not Found! Please register to Login</p>

            <% } %>
            <%
                error = (String) request.getAttribute("IncorrectPassword");
                if(error!=null) {
            %>
            <p style="color: red">Wrong Credentials!</p>

            <% } %>
            <input class="login" type="submit" value="Login" name="login" />
            <input class="btn" type="button" value="Register" name="register" />
            <br /><br />
            <script>
                document.querySelector(".btn").addEventListener("click", function() {
                    location.href = "AdminRegister.jsp";
                })
            </script>
        </div>
    </div>
</form>
</body>
</html>

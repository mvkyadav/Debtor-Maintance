<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<header>
    <h1 class="header">Login</h1>
    <br />
</header>
<form action = /UserLoginServlet method="post">
<div class="body">
    <div class="main">
        <div class="admin_btn">
            <input type="button" value="Admin Login" name="admin"  />
        </div>
        <br />
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
            if(error != null) {
        %>
        <p style="color: red">Wrong Credentials!</p>

        <% } %>

        <input class="login" type="submit" value="Login" name="login" />

        <input class="btn" type="button" value="Register" name="register" />
        <br /><br />
        <script>
            document.querySelector(".btn").addEventListener("click", function() {
                location.href = "/UserRegister.jsp";
            })
            document.querySelector(".admin_btn").addEventListener("click", ()=>{
                location.href = "AdminLogin.jsp";
            })
        </script>
    </div>
</div>
</form>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Vamshi
  Date: 27-12-2021
  Time: 07:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/AdminRegistrationServlet" method="post">
    <fieldset>
        <legend>Admin Registration</legend>
        <label>Username</label>
        <input type="text" name="username" required/><br /><br />

        <label>Password</label>
        <input type="password" name="password" required/><br /><br />

        <label>ConfirmPassword</label>
        <input type="password" name="ConfirmPassword" required/><br /><br />
        <% String error;%>
        <%
             error = (String) request.getAttribute("error");
            if(error!=null) {
        %>
        <p style="color: red">Password Mismatch</p>

        <% } %>

        <%
             error = (String) request.getAttribute("alreadyRegistered");
            if(error!=null) {
        %>
        <p style="color: red">User Already Registered</p>

        <% } %>


        <input type="submit" value="Register" name="register">
    </fieldset>

</form>

</body>
</html>

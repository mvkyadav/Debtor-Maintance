<%--
  Created by IntelliJ IDEA.
  User: Vamshi
  Date: 26-12-2021
  Time: 11:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head> </head>
<body>
<form action="/ReviewAndConfirmindex.html">
    <fieldset >
        <legend>Personal Details</legend>
        Debtor Name:
        <input type="text" name="debtorName" required /><br /><br />
        Debtor Id: <input type="number" name="debtorId" required /><br /><br />
        Address Line1:
        <input type="text" name="address1" required /><br /><br />
        Address Line2: <input type="text" name="address2" /><br /><br />
        Fax Number: <input type="text" name="faxNumber" /><br /><br />
        Mobile Number: <input type="number" name="Mobile" /><br /><br />
        Email id: <input type="email" name="email" /><br /><br />
    </fieldset>

    <fieldset>
        <legend>Bank Account Details</legend>
        Bank Name: <input type="text" name="bankName" required /><br /><br />
        Branch Name:<input type="text" name="branchName" required /><br /><br />
        Swift Address:
        <input type="text" name="swiftAddress" required /><br /><br />
        Account Number:
        <input type="number" name="AccountNumber" required /><br /><br />

<%--        Hidden field        --%>
        <input type="hidden" name="action" value="form">

    </fieldset>
    <input type="submit" name="submit" />
    <input type="button" name="clear" value="Clear" />
    <input type="button" name="cancel" value="Cancel" />
</form>
</body>
</html>

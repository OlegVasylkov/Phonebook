<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Contact List</title>
</head>
<body>
<section>
    <h2><a href="index.html">Home</a></h2>
    <h3>Contacts list</h3>
    <hr>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Name</th>
            <th>Mobile Phone</th>
            <th>Home Phone</th>
            <th>Address</th>
            <th>E-mail</th>
        </tr>
        </thead>
        <c:forEach items="${contactList}" var="contact">
            <jsp:useBean id="contact" scope="page" type="model.Contact"/>
            <tr>
                <td>${contact.firstName} ${contact.middleName} ${contact.lastName}</td>
                <td>${contact.mobilePhone}</td>
                <td>${contact.homePhone}</td>
                <td>${meal.address}</td>
                <td>${meal.email}</td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://Phonebook.com/functions" %>
<html>
<head>
    <title>Contact List</title>
</head>
<body>
<section>
    <h2><a href="index.html">Home</a></h2>
    <h3>Contacts list</h3>
    <hr>
    <a href="contacts?action=create">Add Contact</a>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Name</th>
            <th>Mobile Phone</th>
            <th>Home Phone</th>
            <th>Address</th>
            <th>E-mail</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${contactList}" var="contact">
            <jsp:useBean id="contact" scope="page" type="ua.vasylkov.phonebook.model.Contact"/>
            <tr>
                <td>${contact.firstName} ${contact.middleName} ${contact.lastName}</td>
                <td>${fn:matcher(contact.mobilePhone)}</td>
                <td>${contact.homePhone}</td>
                <td>${contact.address}</td>
                <td>${contact.email}</td>
                <td><a href="contacts?action=update&id=${contact.id}">Update</a></td>
                <td><a href="contacts?action=delete&id=${contact.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>

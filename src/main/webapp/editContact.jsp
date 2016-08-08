<%--
  Created by IntelliJ IDEA.
  User: filipenko_n
  Date: 06.08.2016
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contact</title>
</head>
<body>
<section>
    <h2><a href="">Home</a></h2>
    <h3>Edit meal</h3>
    <hr>
    <jsp:useBean id="contact" type="model.Contact" scope="request"/>
    <form method="post" action="contacts">
        <input type="hidden" name="id" value="${contact.id}">
        <dl>Last name:<input minlength=4 type="text" value="${contact.lastName}" name="lastName" required></dl>
        <dl>Fist name:<input minlength=4 type="text" value="${contact.firstName}" name="firstName" required></dl>
        <dl>Middle name:<input minlength=4 type="text" value="${contact.middleName}" name="middleName" required></dl>
        <dl>Mobile Phone:<input pattern="\+380.{9,9}" type="text" value="${contact.mobilePhone}" name="mobilePhone" required></dl>
        <dl>Home Phone:<input type="text" value="${contact.homePhone}" name="homePhone"></dl>
        <dl>Address:<input type="text" value="${contact.address}" name="address"></dl>
        <dl>Email:<input type="email" value="${contact.email}" name="email"></dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()">Cancel</button>
    </form>
</section>
</body>
</html>

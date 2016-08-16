<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contact</title>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<section>
    <h2><a href="intex.html">Home</a></h2>
    <h3>${param.action == 'create' ? 'Create contact' : 'Edit contact'}</h3>
    <hr>
    <jsp:useBean id="contact" type="ua.vasylkov.phonebook.model.Contact" scope="request"/>
    <form method="post" action="contacts">
        <input type="hidden" name="id" value="${contact.id}">
        <dl>Last name:<input minlength=4 type="text" value="${contact.lastName}" name="lastName" required></dl>
        <dl>Fist name:<input minlength=4 type="text" value="${contact.firstName}" name="firstName" required></dl>
        <dl>Middle name:<input minlength=4 type="text" value="${contact.middleName}" name="middleName" required></dl>
        <dl>Mobile Phone:<input pattern="\+380.{9,9}" type="text" value="${contact.mobilePhone}" name="mobilePhone" required></dl>
        <dl>Home Phone:<input pattern="\+380.{9,9}" type="text" value="${contact.homePhone}" name="homePhone"></dl>
        <dl>Address:<input pattern="\+380.{9,9}" type="text" value="${contact.address}" name="address"></dl>
        <dl>Email:<input type="email" value="${contact.email}" name="email"></dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()">Cancel</button>
    </form>
</section>
</body>
</html>
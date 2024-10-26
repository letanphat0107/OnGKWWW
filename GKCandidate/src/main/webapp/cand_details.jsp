<%@ page import="vn.edu.iuh.fit.entities.Candidate" %><%--
  Created by IntelliJ IDEA.
  User: DMX
  Date: 10/26/2024
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% Candidate can = (Candidate) session.getAttribute("can"); %>

<div>
    <h1>Candidate Details</h1>
    <table>
        <tr>
            <td>Id</td>
            <td><%= can.getId() %></td>
        </tr>
        <tr>
            <td>Fullname</td>
            <td><%= can.getFullname() %></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><%= can.getEmail() %></td>
        </tr>
        <tr>
            <td>Phone</td>
            <td><%= can.getPhone() %></td>
        </tr>
    </table>
</div>
</body>

</html>

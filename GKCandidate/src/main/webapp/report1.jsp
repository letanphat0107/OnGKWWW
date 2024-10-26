<%@ page import="vn.edu.iuh.fit.entities.Candidate" %>
<%@ page import="java.util.List" %><%--
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
<% List<Candidate> lst = (List<Candidate>) session.getAttribute("lstCan");

%>
<form action="controller" method="post">
    <input type="hidden"  name="action" value="timKiem">
    <div>
        <input type="text" name="companyName" placeholder="Nhap ten cong ty">
        <button type="submit">Tim kiem</button>
    </div>
</form>
<% if (lst != null) { %>
<table>

    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Phone</th>
    </tr>
    </thead>
    <tbody>
    <% for (Candidate can : lst) { %>
    <tr>
        <td><%= can.getId() %></td>
        <td><%= can.getFullname() %></td>
        <td><%= can.getEmail() %></td>
        <td><%= can.getPhone() %></td>
        <th>
            <a href="controller?action=moreInfo&idCan=<%=can.getId()%>">More Info</a>
        </th>
    </tr>
    <% } %>
    </tbody>
</table>
<% } %>
</body>
</html>

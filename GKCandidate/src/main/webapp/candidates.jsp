<%@ page import="java.util.List" %>
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
    <title>Candidate</title>
</head>
<body>
<% List<Candidate> lst = (List<Candidate>) session.getAttribute("lstCan");
    if (lst == null) {
         response.sendRedirect("controller?action=lstCandidate");
    }
%>
<% if (lst != null) { %>
  <table border="1">

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

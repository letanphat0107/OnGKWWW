<%@ page import="vn.edu.iuh.fit.dtos.XeDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.entities.Hangxe" %>
<%@ page import="java.time.LocalDate" %><%--
  Created by IntelliJ IDEA.
  User: DMX
  Date: 10/26/2024
  Time: 11:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Form ADD</title>
</head>
<body>
<%
    String action = request.getParameter("action");
    XeDTO xeDTO=(XeDTO) session.getAttribute("xeDTO");
    List<Hangxe> hangXeList = (List<Hangxe>) session.getAttribute("hangXeList");

    long maXe = xeDTO.getId() == 0 ? 0 : xeDTO.getId();
    String tenXe = xeDTO.getTenxe() == null ? "" : xeDTO.getTenxe();
    double giaXe = xeDTO.getGiaxe() == 0 ? 0.0 : xeDTO.getGiaxe();
    int namSX = xeDTO.getNamsanxuat() == 0 ? LocalDate.now().getYear() : xeDTO.getNamsanxuat();
    String hangXe = xeDTO.getTenhangxe() == null ? "" : xeDTO.getTenhangxe();


%>
<div class="container">
    <h1 class="text-center">Form Xe</h1>
    <form action="controller" method="post">
        <input type="hidden" name="action" value="<%=action%>">
        <div class="mb-2">
            <label for="maXe" class="form-label">Ma Xe</label>
            <input type="text" class="form-control" id="maXe" name="maXe" value="<%=maXe%>" required>
        </div>
        <div class="mb-2">
            <label for="tenXe" class="form-label">Ten Xe</label>
            <input type="text" class="form-control" id="tenXe" name="tenXe" value="<%=tenXe%>" required>
        </div>
        <div class="mb-2">
            <label for="giaXe" class="form-label">Gia Xe</label>
            <input type="text" class="form-control" id="giaXe" name="giaXe" value="<%=giaXe%>" required>
        </div>
        <div class="mb-2">
            <label for="namSX" class="form-label">Nam Sx</label>
            <input type="text" class="form-control" id="namSX" name="namSX" value="<%=namSX%>" required>
        </div>
        <div class="mb-2">
            <label for="hangXe" class="form-label">Hang xe</label>
            <select class="form-select" id="hangXe" name="hangXe">
                <%
                    for (Hangxe hxe: hangXeList) {
                        String selected = hxe.getTenhang().equals(hangXe) ? "selected" : "";
                %>
                <option value="<%=hxe.getTenhang()%>" <%=selected%>><%=hxe.getTenhang()%></option>
                <%
                    }
                %>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
        <a href="controller?action=dsXe" class="btn btn-danger">Cancel</a>
    </form>
</div>
</body>
</html>

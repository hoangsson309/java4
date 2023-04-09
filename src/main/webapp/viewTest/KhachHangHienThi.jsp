<%--
  Created by IntelliJ IDEA.
  User: HOANG SON
  Date: 3/27/2023
  Time: 1:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">
</head>
<body>
<br>
<br>
<div class="container">
    <form action="/khach-hang/add" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Mã</label>
            <input class="form-control" type="text" name="ma" required><br>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Ten</label>
            <input class="form-control" type="text" name="ten" required><br>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Ten dem</label>
            <input class="form-control" type="text" name="tenDem" required><br>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Ho</label>
            <input class="form-control" type="text" name="ho" required><br>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Ngay sinh</label>
            <input class="form-control" type="text" name="ngaySinh" required><br>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Sdt</label>
            <input class="form-control" type="text" name="sdt" required><br>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Dia chi</label>
            <input class="form-control" type="text" name="diaChi" required><br>
        </div>
        <br>
        <div class="fw-bold">
            <button type="submit" class="btn btn-success">Add</button>
        </div>
    </form>
</div>
<div class="container">
    <table class="table-hover table table-bordered text-center">
        <thead class="text-bg-dark bg-dark">
        <th>Ma</th>
        <th>Ho ten</th>
        <th>Ngay sinh</th>
        <th>SDT</th>
        <th>Dia chi</th>
        <th></th>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="d">
            <tr>
                <td>${d.ma}</td>
                <td>${d.ho} ${d.tenDem} ${d.ten}</td>
                <td>${d.ngaySinh}</td>
                <td>${d.sdt}</td>
                <td>${d.diaChi}</td>
                <td>
                    <a href="/khach-hang/detail?id=${d.id}" class="btn btn-primary">Xem</a>
                    <a href="/khach-hang/delete?id=${d.id}" class="btn btn-danger">Xoa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="/webjars/bootstrap/5.2.3/js/bootstrap.bundle.js"></script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: HOANG SON
  Date: 4/7/2023
  Time: 1:42 AM
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
<br><br>
<div class="container">
    <table class="table-hover table table-bordered text-center">
        <thead class="text-bg-dark bg-dark">
        <th>Tên</th>
        <th>NSX</th>
        <th>Màu</th>
        <th>Loại</th>
        <th>Năm</th>
        <th>Còn</th>
        <th>Nhập</th>
        <th>Bán</th>
        <td></td>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="d">
            <tr>
                <td hidden>${d.id}</td>
                <td>${d.sanPham.ten}</td>
                <td>${d.nsx.ten}</td>
                <td>${d.mauSac.ten}</td>
                <td>${d.dongSP.ten}</td>
                <td>${d.namBH}</td>
                <td>${d.soLuongTon}</td>
                <td>${d.giaNhap}</td>
                <td>${d.giaBan}</td>
                <td>
                    <a href="/gio-hang/add?id=${d.id}"class="btn btn-success" role="button">Thêm vào giỏ</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="/webjars/bootstrap/5.2.3/js/bootstrap.bundle.js"></script>
</body>
</html>

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
    <form action="/chi-tiet-sp/add" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">San pham</label>
            <select name="sanPham" class="form-select form-select-sm" aria-label=".form-select-sm example">
                <c:forEach items="${listSP}" var="ch">
                    <option value="${ch.id}">${ch.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Nha san xuat</label>
            <select name="nsx" class="form-select form-select-sm" aria-label=".form-select-sm example">
                <c:forEach items="${listNSX}" var="ch">
                    <option value="${ch.id}">${ch.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Mau sac</label>
            <select name="mauSac" class="form-select form-select-sm" aria-label=".form-select-sm example">
                <c:forEach items="${listMS}" var="ch">
                    <option value="${ch.id}">${ch.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Dong san pham</label>
            <select name="dongSP" class="form-select form-select-sm" aria-label=".form-select-sm example">
                <c:forEach items="${listDongSP}" var="ch">
                    <option value="${ch.id}">${ch.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Nam BH</label>
            <input class="form-control" type="number" name="namBH" required><br>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">So luong ton</label>
            <input class="form-control" type="number" name="soLuongTon" required><br>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Gia nhap</label>
            <input class="form-control" type="number" name="giaNhap" required><br>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Gia ban</label>
            <input class="form-control" type="number" name="giaBan" required><br>
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
        <th>San pham</th>
        <th>Nha san xuat</th>
        <th>Mau sac</th>
        <th>Dong sp</th>
        <th>Nam</th>
        <th>So luong ton</th>
        <th>Gia nhap</th>
        <th>Gia ban</th>
        <td></td>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="d">
            <tr>
                <td>${d.sanPham.ten}</td>
                <td>${d.nsx.ten}</td>
                <td>${d.mauSac.ten}</td>
                <td>${d.dongSP.ten}</td>
                <td>${d.namBH}</td>
                <td>${d.soLuongTon}</td>
                <td>${d.giaNhap}</td>
                <td>${d.giaBan}</td>
                <td>
                    <a href="/chi-tiet-sp/detail?id=${d.id}" class="btn btn-primary">Xem</a>
                    <a href="/chi-tiet-sp/delete?id=${d.id}" class="btn btn-danger">Xoa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="/webjars/bootstrap/5.2.3/js/bootstrap.bundle.js"></script>
</body>
</html>

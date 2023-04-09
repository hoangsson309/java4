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
<br>
<br>
<div class="container">
    <table class="table-hover table table-bordered text-center">
        <thead class="text-bg-dark bg-dark">
        <th>Tên</th>
        <th>Màu</th>
        <th>Loại</th>
        <th>Giá</th>
        <th>Số lượng mua</th>
        <th>Thành tiền</th>
        <td></td>
        </thead>
        <tbody>
        <c:set var="total" value="${0}" scope="page"></c:set>
        <c:forEach items="${giohang}" var="d">
            <tr>
                <td hidden>${d.id}</td>
                <td>${d.sanPham.ten}</td>
                <td>${d.mauSac.ten}</td>
                <td>${d.dongSP.ten}</td>
                <td>${d.giaBan}</td>
                <td>${d.soLuong}</td>
                <td>${d.soLuong * d.giaBan}</td>
                <td>
                    <a href="/gio-hang/delete?id=${d.id}" class="btn btn-danger">Xoa</a>
                </td>
                <c:set var="total" value="${total = total + d.soLuong * d.giaBan}" scope="page"></c:set>
            </tr>

        </c:forEach>
        </tbody>
        <tfoot>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td>Tổng tiền: <b class="text-danger">${total}</b> vnđ</td>
        </tr>
        </tfoot>
    </table>
    <a href="/dssp/hien-thi">Tiep tuc mua</a>
</div>
<br>
<br>
<div class="container">
    <h3 class="card-header">Thông tin khách hàng</h3>
    <form action="/gio-hang/thanh-toan" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Tên</label>
            <input class="form-control" type="text" name="kh_ten" required><br>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">SĐT</label>
            <input class="form-control" type="text" name="kh_sdt" required><br>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Địa chỉ</label>
            <input class="form-control" type="text" name="kh_diaChi" required><br>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Địa chỉ nhận hàng</label>
            <input class="form-control" type="text" name="hd_diaChi" required><br>
        </div>
        <br>
        <button type="submit" class="btn btn-success pe-3 ps-3">Thanh toán</button>
    </form>
</div>
<script src="/webjars/bootstrap/5.2.3/js/bootstrap.bundle.js"></script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: HOANG SON
  Date: 3/27/2023
  Time: 1:37 PM
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
    <div class="container">
        <form action="/nhan-vien/update" method="post">
            <div hidden class="form-group row">
                <label class="col-sm-2 col-form-label">ID</label>
                <input class="form-control" type="text" name="id" value="${cv.id}"required><br>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Mã</label>
                <input class="form-control" type="text" name="ma" value="${cv.ma}"required><br>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Ten</label>
                <input class="form-control" type="text" name="ten" value="${cv.ten}"required><br>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Ten dem</label>
                <input class="form-control" type="text" name="tenDem" value="${cv.tenDem}" required><br>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Ho</label>
                <input class="form-control" type="text" name="ho" value="${cv.ho}" required><br>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Gioi tinh</label>
                <span hidden id="gioiTinhHiden">${cv.gioiTinh}</span>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gioiTinh" value="Nam" id="flexRadioDefault1"
                    checked
                    >
                    <label class="form-check-label" for="flexRadioDefault1">
                        Nam
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gioiTinh" value="Nu" id="flexRadioDefault2">
                    <label class="form-check-label" for="flexRadioDefault2">
                        Nu
                    </label>
                </div>
            </div>
            <%--        <div class="form-group row">--%>
            <%--            <label class="col-sm-2 col-form-label">Ngay sinh</label>--%>
            <%--            <input class="form-control" type="text" name="ngaySinh" required><br>--%>
            <%--        </div>--%>

            <%--        <div class="form-group row">--%>
            <%--            <label class="col-sm-2 col-form-label">Dia chi</label>--%>
            <%--            <input class="form-control" type="text" name="diaChi" required><br>--%>
            <%--        </div>--%>

            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Sdt</label>
                <input class="form-control" type="text" name="sdt" value="${cv.sdt}" required><br>
            </div>

            <%--        <div class="form-group row">--%>
            <%--            <label class="col-sm-2 col-form-label">Mat khau</label>--%>
            <%--            <input class="form-control" type="password" name="matKhau" required><br>--%>
            <%--        </div>--%>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Chuc vu</label>
                <select name="chucVu" class="form-select form-select-sm" aria-label=".form-select-sm example">
                    <c:forEach items="${listCV}" var="ch">
                        <option value="${ch.id}" ${ch.id == cv.chucVu.id ? 'selected = "selected"': ''}> ${ch.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Cua hang</label>
                <select name="cuaHang" class="form-select form-select-sm" aria-label=".form-select-sm example">
                    <c:forEach items="${listCH}" var="ch">
                        <option value="${ch.id}" ${ch.id == cv.cuaHang.id ? 'selected = "selected"': ''}> ${ch.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Trang thai</label>
                <span hidden id="trangThaiHiden">${cv.trangThai}</span>
                <select name="trangThai" class="form-select form-select-sm" aria-label=".form-select-sm example">
                    <option id="nam" value="0">Dang lam</option>
                    <option id="nu" value="1">Nghi lam</option>
                </select>
            </div>
            <br>
            <div class="fw-bold">
                <button type="submit" class="btn btn-danger">Save</button>
            </div>
        </form>
    </div>
    <script>
        var trangThais = document.getElementById("trangThaiHiden").innerText;
        Number(trangThais) == 0 ? document.getElementById("nam").selected = true
            : document.getElementById("nu").selected = true;
        var gioiTinhs = document.getElementById("gioiTinhHiden").innerText;
        gioiTinhs == "Nam" ? document.getElementById("flexRadioDefault1").checked = true
            : document.getElementById("flexRadioDefault2").checked = true;
    </script>
<script src="/webjars/bootstrap/5.2.3/js/bootstrap.bundle.js"></script>
</body>
</html>

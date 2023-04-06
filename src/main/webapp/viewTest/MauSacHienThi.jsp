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
        <form action="/mau-sac/add" method="post">
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Mã</label>
                <div class="col-sm-10">
                    <input class="form-control" type="text" name="ma" required><br>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Ten</label>
                <div class="col-sm-10">
                    <input class="form-control" type="text" name="ten" required><br>
                </div>
            </div>
            <div class="fw-bold">
                <button type="submit" class="btn btn-success pe-3 ps-3">Add</button>
            </div>
        </form>
    </div>
    <div class="container">
        <table class="table-hover table table-bordered text-center">
            <thead class="text-bg-dark bg-dark">
                <th>ID</th>
                <th>Ma</th>
                <th>Ten</th>
                <th></th>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="d">
                    <tr>
                        <td>${d.id}</td>
                        <td>${d.ma}</td>
                        <td>${d.ten}</td>
                        <td>
                            <a href="/mau-sac/detail?id=${d.id}" class="btn btn-primary">Xem</a>
                            <a href="/mau-sac/delete?id=${d.id}" class="btn btn-danger">Xoa</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <script src="/webjars/bootstrap/5.2.3/js/bootstrap.bundle.js"></script>
</body>
</html>

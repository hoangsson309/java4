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
        <form action="/mau-sac/update" method="post">
            <div hidden class="form-group row">
                <label class="col-sm-2 col-form-label">ID</label>
                <div class="col-sm-10">
                    <input class="form-control" type="text" name="id" value="${cv.id}"><br>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Ma</label>
                <div class="col-sm-10">
                    <input class="form-control" type="text" name="ma" value="${cv.ma}"><br>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Ten</label>
                <div class="col-sm-10">
                    <input class="form-control" type="text" name="ten" value="${cv.ten}"><br>
                </div>
            </div>
            <button type="submit" class="btn btn-warning">Sua</button>
        </form>
    </div>
<script src="/webjars/bootstrap/5.2.3/js/bootstrap.bundle.js"></script>
</body>
</html>

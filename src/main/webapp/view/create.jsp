<%--
  Created by IntelliJ IDEA.
  User: HOANG SON
  Date: 3/13/2023
  Time: 12:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">
</head>
<body>
    <br>
    <div class="container">
        <form action="/students/add" method="post">
            <div class="mb-3">
                <label class="form-label fw-bold">ID</label>
                <input type="number" class="form-control" name="id">
            </div>
            <div class="mb-3">
                <label class="form-label fw-bold">Full name</label>
                <input type="number" class="form-control" name="fullName">
            </div>
            <div class="mb-3">
                <label class="form-label fw-bold">Email</label>
                <input type="number" class="form-control" name="email">
            </div>
            <div class="mb-3">
                <label class="form-label fw-bold">Phone Number</label>
                <input type="number" class="form-control" name="phoneNumber">
            </div>
            <div class="mb-3">
                <label class="form-label fw-bold">Status</label>
                <input type="number" class="form-control" name="status">
            </div>
            <button type="submit" class="btn btn-primary">Add now</button>
        </form>
    </div>
    <br>
    <script src="/webjars/bootstrap/5.2.3/js/bootstrap.bundle.js"></script>
</body>
</html>

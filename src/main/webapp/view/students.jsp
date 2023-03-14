<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">
</head>
<body>
<h1 class="text-center">List student</h1>
<br>
<button onclick="location.href = '/view/create.jsp'" class="btn btn-success">Create new student</button>
<table class="table-bordered table table-hover text-center">
    <thead class="bg-dark text-white">
    <tr>
        <th>ID</th>
        <th>Ho va ten</th>
        <th>Email</th>
        <th>SDT</th>
        <th>Trang Thai</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="stu">
        <tr>
            <td>${stu.id}</td>
            <td>${stu.fullName}</td>
            <td>${stu.email}</td>
            <td>${stu.phoneNumber}</td>
            <c:set var="status" scope="session" value="${stu.status}"/>
            <c:if test="${status == 0}">
                <td class="fw-bold text-success"><c:out value="Passes"></c:out></td>
            </c:if>
            <c:if test="${status != 0}">
                <td class="fw-bold text-danger"><c:out value="Not pass"></c:out></td>
            </c:if>
            <td>
                <button class="btn fw-bold btn-primary">Xem</button>
                <button class="btn fw-bold btn-danger">Xoa</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="/webjars/bootstrap/5.2.3/js/bootstrap.bundle.js"></script>
</body>
</html>

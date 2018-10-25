<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!doctype html>
<html>
<head>
    <!-- Reference Bootstrap files -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <title>User List</title>

</head>
<body>
<div class="container">
    <h2>User List</h2>
    <table class="table table-striped">

        <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Password</th>
            <th>Enabled</th>
           <%-- <th>Update</th>
            <th>Delete</th>--%>
        </tr>

        <tbody>
        <c:forEach items="${usersList }" var="users">
            <tr>
                <td>${users.usersID }</td>
                <td>${users.username }</td>
                <td>${users.password }</td>
                <td>${users.enabled }</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <security:authorize access="hasRole('ADMIN')">
    <spring:url value="/users/addUsers/" var="addURL" />

    <div>
        <a href="${pageContext.request.contextPath}/register/showRegistrationForm" class="btn btn-primary">Register New User</a>
        <a href="${pageContext.request.contextPath}/register/showDeleteForm" class="btn btn-primary">Delete User</a>
    </div>

    <br>
    </security:authorize>
    <div >
        <p>
            <a href="${pageContext.request.contextPath}/" class="btn btn-primary">Go to Home Page</a>
        </p>
    </div>

</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html>
<head>
    <!-- Reference Bootstrap files -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <title>User List</title>

    <style>
        .navbar {
            margin-left: 50px;
            margin-right: 50px;
        }
    </style>

</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Instructors and Courses</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="${pageContext.request.contextPath}/">Home</a></li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Lists <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="${pageContext.request.contextPath}/instructor/list">Instructor List</a></li>
                    <li><a href="${pageContext.request.contextPath}/course/list">Course List</a></li>
                    <li class="active"><a href="#">User List</a></li>
                </ul>
            </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><form:form action="${pageContext.request.contextPath}/logout"
                           method="POST">
                <input type="submit" value="Logout" class="btn btn-danger navbar-btn" role="button"
                       aria-pressed="true"/>
            </form:form></li>
            <li class="navbar-text">User:
                <span style="color:blue"><security:authentication property="principal.username"/></span>
                , Role:
                <security:authentication property="principal.authorities"/></li>
        </ul>
    </div>
</nav>

<div class="container">
    <h2>User List</h2>

    <table class="table table-striped">

        <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Password</th>
           <%-- <th>Enabled</th>--%>
           <%-- <th>Update</th>
            <th>Delete</th>--%>
        </tr>

        <tbody>
        <c:forEach items="${usersList }" var="users">
            <tr>
                <td>${users.usersID }</td>
                <td>${users.username }</td>
                <td>${users.password }</td>
            <%--    <td>${users.enabled }</td>--%>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <security:authorize access="hasRole('ADMIN')">
    <spring:url value="/users/addUsers/" var="addURL" />

    <div>
        <a href="${pageContext.request.contextPath}/register/showRegistrationForm" class="btn btn-primary">Register New User</a>
        <a href="${pageContext.request.contextPath}/register/showDeleteForm" class="btn btn-danger">Delete User</a>
    </div>

    <br>
    </security:authorize>

    <%--<div >
        <p>
            <a href="${pageContext.request.contextPath}/" class="btn btn-primary">Go to Home Page</a>
        </p>
    </div>--%>

</div>
</body>
</html>
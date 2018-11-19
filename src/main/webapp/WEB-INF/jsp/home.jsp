<!doctype html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html lang="en">
<head>
    <title>Home Page</title>
    <!-- Reference Bootstrap files -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <style>

        .navbar {
            margin-left: 40px;
            margin-right: 40px;
        }

        h3 {
            text-align: center;
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
            <li class="active"><a href="#">Home</a></li>
          <%--  <li><a href="${pageContext.request.contextPath}/instructor/list">Instructor List</a></li>
            <li><a href="${pageContext.request.contextPath}/course/list">Course List</a></li>
            <li><a href="${pageContext.request.contextPath}/users/list">User List</a></li>--%>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Lists <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="${pageContext.request.contextPath}/instructor/list">Instructor List</a></li>
                    <li><a href="${pageContext.request.contextPath}/course/list">Course List</a></li>
                    <li><a href="${pageContext.request.contextPath}/users/list">User List</a></li>
                    <%--<li role="separator" class="divider"></li>
                    <li><a href="#">Separated link</a></li>--%>
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

    <div class="starter-template">
        <h3>Welcome to Home Page</h3>
    </div>

    <br>
    <div class="row text-center">

        <img src="/images/courses.png" height="435" width="540">

    </div>
</div>
</body>
</html>

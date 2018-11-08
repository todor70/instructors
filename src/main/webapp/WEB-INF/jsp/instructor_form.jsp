<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!doctype html>
<html>
<head>
    <!-- Reference Bootstrap files -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <title>Instructor Form</title>

    <style>
        .error {
            color: red
        }
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
                    <li><a href="${pageContext.request.contextPath}/users/list">User List</a></li>
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
    <spring:url value="/instructor/saveInstructor" var="saveURL"/>
    <h2>Add/Update Instructor</h2>
    <form:form modelAttribute="instructorForm" method="post"
               action="${saveURL }" cssClass="form">
        <form:hidden path="instructorID"/>
        <div class="form-group" style="width: 250px">
            <label>First name</label>
            <form:input path="firstName" cssClass="form-control" id="firstName"/>
            <form:errors path="firstName" cssClass="error"/>
        </div>
        <div class="form-group" style="width: 250px">
            <label>Last name</label>
            <form:input path="lastName" cssClass="form-control" id="lastName"/>
            <form:errors path="lastName" cssClass="error"/>
        </div>
        <div class="form-group" style="width: 250px">
            <label>Day of Birth</label>
            <form:input path="dayOfBirth" cssClass="form-control"
                        placeholder="yyyy-MM-dd" id="dayOfBirth"/>
        </div>
        <div class="form-group" style="width: 250px">
            <label>Address</label>
            <form:input path="address" cssClass="form-control" id="address"/>
            <form:errors path="address" cssClass="error"/>
        </div>
        <div class="form-group" style="width: 250px">
            <label>Phone</label>
            <form:input path="phone" cssClass="form-control" id="phone"/>
            <form:errors path="phone" cssClass="error"/>
        </div>
        <div class="form-group" style="width: 250px">
            <label>Email</label>
            <form:input path="email" cssClass="form-control" id="email"/>
            <form:errors path="email" cssClass="error"/>
        </div>

        <button type="submit" class="btn btn-primary">Save</button>
    </form:form>
</div>
</body>
</html>
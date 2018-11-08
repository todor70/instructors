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
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <title>Course Add Form</title>

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
    <spring:url value="/course/saveCourse" var="saveURL"/>
    <h2>Add Course</h2>
    <form:form modelAttribute="courseAddForm" method="post"
               action="${saveURL }" cssClass="form">
        <form:hidden path="courseID"/>
        <div class="form-group" style="width: 250px">
            <label>Title</label>
            <form:input path="title" cssClass="form-control" id="title"/>
            <form:errors path="title" cssClass="error" />
        </div>
        <div class="form-group" style="width: 250px">
            <label>Start</label>
            <form:input path="start" cssClass="form-control" placeholder="yyyy-MM-dd" id="start"/>
        </div>
        <div class="form-group"style="width: 250px" >
            <label>End</label>
            <form:input path="end" cssClass="form-control" placeholder="yyyy-MM-dd" id="end"/>
        </div>


        <div class="form-group"style="width: 250px" >
            <label for="instructor">Instructor first name</label>

            <fieldset>
                <select name="instructor.instructorID" id="instructor.firstName"
                        class="form-control">

                    <c:forEach items="${instructorList}" var="instructor">
                        <option value="${instructor.instructorID}">${instructor.firstName}</option>
                    </c:forEach>
                </select>
            </fieldset>
        </div>

        <br>
        <button type="submit" class="btn btn-primary">Save</button>
    </form:form>
</div>
</body>
</html>
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

</head>
<body>
<div class="container">

    <div class="starter-template">
        <h1>Instructors and Courses</h1>
        <h2>Welcome to Home Page</h2>
        <h3>User:
            <security:authentication property="principal.username"/>
            , Role:
            <security:authentication property="principal.authorities"/></h3>
    </div>

    <br>
    <div>
        <a href="${pageContext.request.contextPath}/instructor/list" class="btn btn-primary">Instructor List</a>
        <a href="${pageContext.request.contextPath}/course/list" class="btn btn-primary">Course List</a>
        <a href="${pageContext.request.contextPath}/users/list" class="btn btn-primary">User List</a>
    </div>

    <hr>

    <!-- Add a logout button -->
    <form:form action="${pageContext.request.contextPath}/logout"
               method="POST">

        <input type="submit" value="Logout" class="btn btn-primary" role="button" aria-pressed="true"/>

    </form:form>

</div>
</body>
</html>

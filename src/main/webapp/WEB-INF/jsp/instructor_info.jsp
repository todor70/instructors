<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE HTML>
<html>

<head>
    <title>Instructor Info</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

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

    <form enctype="multipart/form-data">
        <div class="col-md-4">
            <h1>Instructor Courses</h1>
            <div class="panel panel-default">

                <div class="panel-body" style="padding-left: 15px;">
                    <h4><span style="color:blue;font-weight:bold">Instructor</span></h4>
                    <h4>First name: ${instructor.firstName}</h4>
                    <h4>Last name: ${instructor.lastName}</h4>
                    <h4>Day of Birth: ${instructor.dayOfBirth}</h4>
                    <h4>Address: ${instructor.address}</h4>
                    <h4>Phone: ${instructor.phone}</h4>
                    <h4>Email: ${instructor.email}</h4><br>
                    <h4><span style="color:blue;font-weight:bold">Courses</span></h4>

                    <c:forEach items="${courseList }" var="course">
                        <h4>${course.title }</h4>
                    </c:forEach>

                   <%-- <h4>Email:</h4> <a href="|mailto:${instructor.email}|" class="btn btn-primary"> ${instructor.email}</a>--%>
                </div>
            </div>
        </div>
    </form>
</div>

</body>
</html>
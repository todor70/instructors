<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>

<head>
    <title>Instructor Info</title>

    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
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

<br>
<div>
    <p>
        <a href="${pageContext.request.contextPath}/instructor/list"
           class="btn btn-primary" style="margin-left: 130px;">Back to List</a>
    </p>
</div>
</body>
</html>
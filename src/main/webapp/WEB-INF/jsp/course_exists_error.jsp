<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
    <!-- Reference Bootstrap files -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Course Exists Error</title>

    <style>

        html, body{
            margin-left:15px;
            font-family:Verdana, Arial, Helvetica, sans-serif;
        }

    </style>
</head>

<body>



<h2>Course <span style="color:blue;font-weight:bold">${course.title }</span> already exists!!!</h2>


<hr>

<a href="${pageContext.request.contextPath}/course/list" class="btn btn-primary">Back to Course List</a>

</body>

</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!doctype html>
<html>
<head>

    <!-- Reference Bootstrap files -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <title>Instructor List</title>

</head>
<body>


<div class="container">
    <h2>Instructor List</h2>


    <table class="table table-striped">

        <tr>
            <th>ID</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Day of Birth</th>
            <th>Address</th>
            <th>Phone</th>
            <th>Email</th>
            <security:authorize access="hasRole('ADMIN')">

                <th>Update</th>
                <th>Delete</th>

            </security:authorize>
        </tr>

        <tbody>
        <c:forEach items="${instructorList }" var="instructor">
            <tr>
                <td>${instructor.instructorID }</td>
                <td>${instructor.firstName }</td>
                <td>${instructor.lastName }</td>
                <td>${instructor.dayOfBirth }</td>
                <td>${instructor.address }</td>
                <td>${instructor.phone }</td>
                <td>${instructor.email }</td>

                <security:authorize access="hasRole('ADMIN')">

                    <td><spring:url
                            value="/instructor/updateInstructor/${instructor.instructorID }"
                            var="updateURL"/> <a class="btn btn-primary"
                                                 href="${updateURL }">Update</a></td>
                    <td><spring:url
                            value="/instructor/deleteInstructor/${instructor.instructorID }"
                            var="deleteURL"/> <a class="btn btn-primary"
                                                 href="${deleteURL }"
                                                 onclick="if (!(confirm('Are you sure you want to delete this instructor?'))) return false">Delete</a></td>

                </security:authorize>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>

    <security:authorize access="hasRole('ADMIN')">
        <spring:url value="/instructor/addInstructor/" var="addURL"/>
        <div>
            <p>
                <a href="${addURL }" class="btn btn-primary">Add New Instructor</a>
            </p>
        </div>
    </security:authorize>

    <div>
        <p>
            <a href="${pageContext.request.contextPath}/" class="btn btn-primary">Go
                to Home Page</a>
        </p>

    </div>

</div>
</body>
</html>
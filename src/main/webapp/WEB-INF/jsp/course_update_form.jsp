<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html>
<head>
    <!-- Reference Bootstrap files -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <title>Course Update Form</title>

</head>
<body>
<div class="container">
    <br>
    <spring:url value="/course/updateCourse" var="saveURL"/>
    <h2>Update Course</h2>
    <form:form modelAttribute="courseUpdateForm" method="post"
               action="${saveURL }" cssClass="form">
        <form:hidden path="courseID"/>
        <div class="form-group" style="width: 250px">
            <label>Title</label>
            <form:input path="title" cssClass="form-control" id="title" readonly="true"/>
        </div>
        <div class="form-group" style="width: 250px">
            <label>Start</label>
            <form:input path="start" cssClass="form-control" placeholder="yyyy-MM-dd" id="start"/>
        </div>
        <div class="form-group" style="width: 250px">
            <label>End</label>
            <form:input path="end" cssClass="form-control" placeholder="yyyy-MM-dd" id="end"/>
        </div>


        <div class="form-group" style="width: 250px">
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
        <button type="submit" class="btn btn-primary">Update</button>
    </form:form>


    <br>
    <div>
        <p>
            <a href="${pageContext.request.contextPath}/course/list" class="btn btn-primary">Back
                to List</a>
        </p>
    </div>
</div>
</body>
</html>
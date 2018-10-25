<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html>
<head>

   <%-- <style>
        input {
            width: 250px;
            border: 1px solid #667;
            border-radius: 5px;
            padding: 4px;
            font-size: 16px;
        }
    </style>--%>
    <!-- Reference Bootstrap files -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <title>Course Add Form</title>

</head>
<body>
<div class="container">
    <br>
    <spring:url value="/course/saveCourse" var="saveURL"/>
    <h2>Add Course</h2>
    <form:form modelAttribute="courseAddForm" method="post"
               action="${saveURL }" cssClass="form">
        <form:hidden path="courseID"/>
        <div class="form-group" style="width: 250px">
            <label>Title</label>
            <form:input path="title" cssClass="form-control" id="title"/>
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
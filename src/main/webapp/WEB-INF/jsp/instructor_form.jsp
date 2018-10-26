<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!doctype html>
<html>
<head>

<style>
.error {color:red}
</style>

<!-- Reference Bootstrap files -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Instructor Form</title>

</head>
<body>
	<div class="container">
		<br>
		<spring:url value="/instructor/saveInstructor" var="saveURL" />
		<h2>Add/Update Instructor</h2>
		<form:form modelAttribute="instructorForm" method="post"
			action="${saveURL }" cssClass="form">
			<form:hidden path="instructorID" />
			<div class="form-group" style="width: 250px">
				<label>First name</label>
				<form:input path="firstName" cssClass="form-control" id="firstName" />
				<form:errors path="firstName" cssClass="error" />
			</div>
			<div class="form-group" style="width: 250px">
				<label>Last name</label>
				<form:input path="lastName" cssClass="form-control" id="lastName" />
				<form:errors path="lastName" cssClass="error" />
			</div>
			<div class="form-group" style="width: 250px">
				<label>Day of Birth</label>
				<form:input path="dayOfBirth" cssClass="form-control"
					placeholder="yyyy-MM-dd" id="dayOfBirth" />
			</div>
			<div class="form-group" style="width: 250px">
				<label>Address</label>
				<form:input path="address" cssClass="form-control" id="address" />
				<form:errors path="address" cssClass="error" />
			</div>
			<div class="form-group" style="width: 250px">
				<label>Phone</label>
				<form:input path="phone" cssClass="form-control" id="phone" />
				<form:errors path="phone" cssClass="error" />
			</div>
			<div class="form-group" style="width: 250px">
				<label>Email</label>
				<form:input path="email" cssClass="form-control" id="email" />
				<form:errors path="email" cssClass="error" />
			</div>

			<button type="submit" class="btn btn-primary">Save</button>
		</form:form>

		<br>
		<div>
			<p>
				<a href="${pageContext.request.contextPath}/instructor/list"
					class="btn btn-primary">Back to List</a>
			</p>
		</div>
	</div>
</body>
</html>
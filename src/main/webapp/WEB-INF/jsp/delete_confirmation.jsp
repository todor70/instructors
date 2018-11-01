<html>

<head>
    <!-- Reference Bootstrap files -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Delete Confirmation</title>

    <style>

        html, body {
            margin-left: 15px;
            font-family: Verdana, Arial, Helvetica, sans-serif;
        }

    </style>
</head>

<body>

<h2>User <span style="color:blue;font-weight:bold">${users.username }</span> deleted successfully!</h2>

<hr>

<a href="${pageContext.request.contextPath}/users/list" class="btn btn-primary">Back
    to User List</a>

</body>

</html>
<%--
  Created by IntelliJ IDEA.
  User: sambit.pradhan
  Date: 6/19/2022
  Time: 11:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%--    Bootstrap for Design--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <%--    For Validation--%>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/css/bootstrapValidator.min.css"/>
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"> </script>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Lato:ital@0;1&display=swap" rel="stylesheet">
    <title>Create User</title>
</head>
<body style="font-family: 'Segoe UI Semibold'">
<h3 class="text-center">Create New User</h3>
<form:form action="/createUser" method="post" modelAttribute="userModel">
    <div class="container" style="margin-top: 2rem">
        <div class="row ">

            <div class="col-lg-3 col-md-6">
                <label for="userId" class="form-label">User Id</label>
                <form:input path="userId" type="text" name="userId" id="userId" class="form-control" minlength="5" />
            </div>

            <div class="col-lg-3 col-md-6">
                <label for="password" class="form-label">Password</label>
                <form:input path="password" type="password" name="password" id="password" class="form-control" minlength="8" />
            </div>

            <div class="col-lg-3 col-md-6">
                <label for="confirmPassword" class="form-label">Confirm Password</label>
                <input type="password" name="confirmPassword" id="confirmPassword" class="form-control" minlength="8" required>
            </div>

            <div class="col-lg-3 col-md-6">
                <label for="frame" class="form-label">View Image</label></br>
                <img src="images/default.jpg" id="frame" class="img-fluid">
            </div>

        </div>
    </div>
</form:form>
</body>
</html>

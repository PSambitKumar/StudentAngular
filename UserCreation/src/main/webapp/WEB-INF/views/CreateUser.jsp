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

    <style>
        .no-gutters {
            margin-right: 0;
            margin-left: 0;

        > .col,
        > [class*="col-"] {
            padding-right: 0;
            padding-left: 0;
        }
        }

        .container {
            padding: 0.5rem;
        }
        .cell {
            min-height: 100px;
            margin: 1rem;
        }
        .cell__big {
            height: auto;
            display: flex;
            height: calc(100% - 2rem);
        }
    </style>
</head>
<body style="font-family: 'Segoe UI Semibold'">
<h3 class="text-center">Create New User</h3>
<form:form action="/createUser" method="post" modelAttribute="userModel" enctype="multipart/form-data">

    <div class="container">
        <div class="row no-gutters">
            <div class="col-4">
                <div class="cell">
                    <label for="userId" class="form-label">User Id</label>
                    <form:input path="userId" type="text" name="userId" id="userId" class="form-control" minlength="5" />
                </div>
            </div>
            <div class="col-4">
                <div class="cell">
                    <label for="password" class="form-label">Password</label>
                    <form:input path="password" type="password" name="password" id="password" class="form-control" minlength="8" />
                </div>
            </div>
            <div class="col-4">
                <div class="cell">
                    <label for="confirmPassword" class="form-label">Confirm Password</label>
                    <input type="password" name="confirmPassword" id="confirmPassword" class="form-control" minlength="8" required>
                </div>
            </div>
        </div>
        <div class="row no-gutters">
            <div class="col-8">
                <div class="row no-gutters">
                    <div class="col-6">
                        <div class="cell">
                            <label for="password" class="form-label">Full Name</label>
                            <form:input path="fullName" type="text" name="fullName" id="fullName" class="form-control" />
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="cell">
                            <label for="Image" class="form-label">Upload Your Image</label>
                            <input class="form-control" type="file" id="Image" onchange="preview()" name="imageData">
                            <small style="color: orangered">(.jpg/.jpeg/.gif only & Max size 500 KB)</small>
                        </div>
                    </div>
                </div>
                <div class="row no-gutters">
                    <div class="col-6">
                        <div class="cell">
                            <label for="password" class="form-label">Email</label>
                            <form:input path="email" type="email" name="email" id="email" class="form-control"  />
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="cell">
                            <label for="password" class="form-label">Mobile</label>
                            <form:input path="mobile" type="number" name="mobile" id="mobile" class="form-control" />
                        </div>
                    </div>
                </div>
                <div class="row no-gutters">
                    <div class="col-6">
                        <div class="cell">
                            <label for="password" class="form-label">Date of Birth</label>
                            <form:input path="dob" type="date" name="dob" id="dob" class="form-control"  />
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="cell">
                            <label for="password" class="form-label">Gender</label>
                            <form:input path="gender" type="text" name="gender" id="gender" class="form-control" />
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <div class="cell cell__big">
                    <div class="col-md-12">
                        <img src="images/default.jpg" id="frame" class="img-fluid" style="height: 10rem; margin-bottom: 10px;"></br>
                        <label class="form-label">Address</label>
                        <form:textarea path="address" id="address" class="form-control" rows="5"/>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="col-md-12" style="margin-left: 40rem;">
        <button type="submit" class="btn btn-success" onclick="submitFoem()">Submit</button>
        <button type="button" class="btn btn-warning" onclick="resetForm()">Reset</button>
    </div>
</form:form>

<script>
    function preview() {
        frame.src = URL.createObjectURL(event.target.files[0]);
    }
    function submitFoem(){

    }
    function resetForm(){

    }
</script>
</body>
</html>

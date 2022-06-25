<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/css/bootstrapValidator.min.css"/>
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"> </script>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">
    <script src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js"> </script>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" >
<%--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <title>Ultimate Gaming Zone Membership Registration</title>
</head>
<body style="font-family: 'Segoe UI'; margin: 100px">
<form:form action="/saveGamingZoneRegistration" modelAttribute="gamingZoneRegistration" method="post">

    <div style="margin-top: 30px" class="form-group col-md-12">

        <fieldset class="form-group border p-3">
            <legend style="color: orangered" class="w-auto px-2">Ultimate Gaming Zone Membership Registration</legend>
            <div style="margin-top: 4rem" class="form-group row required">

                <div class="col-md-4">
                    <label class="form-label control-label" for="inputName">Name<span style="color: red">*</span></label>
                    <form:input path="name" type="text" class="form-control" id="inputName" value="${gamingZoneRegistration.name}" placeholder="Enter Your Name"/>
                </div>

                <div class="col-md-4">
                    <label class="form-label" for="email">Email Address<span style="color: red">*</span></label>
                    <form:input path="email" type="email" class="form-control" value="${gamingZoneRegistration.email}" placeholder="Enter Email Address"/>
                </div>

                <div class="col-md-4">
                    <label class="form-label" for="mobile" >Mobile Number<span style="color: red">*</span></label>
                    <form:input path="mobile" type="number" class="form-control" value="${gamingZoneRegistration.mobile}" placeholder="Enter Mobile Number"/>
                </div>

            </div>

            <div style="margin-top: 4rem" class="form-group row required">

                <div class="col-md-3">
                    <label class="form-label control-label" for="dob">Date Of Birth<span style="color: red">*</span></label>
                    <form:input path="dob" type="date" class="form-control" value="${gamingZoneRegistration.dob}"/>
                </div>

                <div class="col-md-3">
                    <label class="form-label" for="subType">Subscription Type<span style="color: red">*</span></label>
                    <form:select path="subType" cssClass="form-control" id="subType" onchange="calculateTotalCost()" value="${gamingZoneRegistration.subType}">
                        <form:option value="Standard">Standard-1100</form:option>
                        <form:option value="Gold">Gold-1500</form:option>
                        <form:option value="Diamond">Diamond-2000</form:option>
                    </form:select>
                </div>

                <div class="col-md-3">
                    <label class="form-label" for="subDuration" >Duration<span style="color: red">*</span></label>
                    <form:input path="subDuration" type="number" class="form-control" id="duration" onkeyup="calculateTotalCost(this.value)" placeholder="Enter Duaration" value="${gamingZoneRegistration.subDuration}"/>
                </div>

                <div class="col-md-3">
                    <label class="form-label" for="totalCost" >Total Cost<span style="color: red">*</span></label>
                    <form:input path="totalCost" type="number" class="form-control" value="${gamingZoneRegistration.totalCost}" id="totalCost" disabled="true"/>
                </div>

                <form:input type="hidden" path="regId" value="${gamingZoneRegistration.regId}"/>
            </div>

        <div>

        <div style="margin: auto; margin-top: 20px" class="form-group row col-md-8">

            <div class="form-group row col-md-3" style="margin-left: 42rem;">
                <button id="save" type="submit"  class="btn btn-success">Save</button>
            </div>

            <div style="margin-left: 10px" class="form-group row col-md-3">
                <button type="reset" class="btn btn-danger">Reset</button>
            </div>

        </div>

        </fieldset>
    </div>
</form:form>

<table id="employeeTable table" class="table table-striped table-bordered" style="margin-top: 1rem;">
    <thead>
    <tr>
        <th>Name</th>
        <th>Age</th>
        <th>Phone No</th>
        <th>Subscription Type</th>
        <th>Valid From</th>
        <th>Expired on</th>
        <th>Upgrade Plan</th>
    </tr>
    </thead>
    <tbody id="tableBody">
    <c:forEach items="${gamingZoneRegistrationList}" var="e">
        <tr>
            <td>${e.name}</td>
            <td>${e.age}</td>
            <td>${e.mobile}</td>
            <td>${e.subType}</td>
            <td>${e.validFrom}</td>
            <td>${e.expiredOn}</td>
            <td>
                <a href = "/upgradeGamingZoneRegistration/${e.regId}" class="btn btn-warning">Upgrade</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>

<script>
    function calculateTotalCost(x){
        x = $('#duration').val();
        let subType = $('#subType').val();
        let totalCost = 0;
        console.log(subType);
        if (subType == "Standard"){
            totalCost = 1100 * x;
        }else if (subType == "Gold"){
            totalCost = 1500 * x;
        }else if (subType == "Diamond"){
            totalCost = 2000 * x;
        }
        console.log(totalCost);
        $('#totalCost').val(totalCost);
    }
</script>

</html>

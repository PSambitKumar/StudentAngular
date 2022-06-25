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
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
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
    <title>Book Appointment</title>

</head>
<body>

<fieldset class="form-group border p-3">
  <legend style="color: orangered" class="w-auto px-2">Appointment Booking For Dr. Sharma</legend>
  <form:form action="/appointment" method="post" modelAttribute="appointmentBooking">

    <div class="container">
      <div class="row no-gutters">
        <div class="col-4">
          <div class="cell">
            <label for="name" class="form-label">Patient's Name</label>
            <form:input path="name" type="text" id="name" class="form-control" minlength="4" onkeyup="checkName(this.value)" />
          </div>
        </div>
        <div class="col-4">
          <div class="cell">
            <label for="age" class="form-label">Age</label>
            <form:input path="age" type="number" id="age" class="form-control" onblur="return checkAge()" />
          </div>
        </div>
        <div class="col-4">
          <div class="cell">
            <label class="form-label">Gender</label>
            <form:radiobutton class="form-check-input" path="gender" value = "Male"/>Male&emsp;&emsp;
            <form:radiobutton class="form-check-input" path="gender" value = "Female"/>Female
          </div>
        </div>
      </div>
      <div class="row no-gutters">
        <div class="col-8">
          <div class="row no-gutters">
            <div class="col-6">
              <div class="cell">
                <label for="apptDate" class="form-label">Appointment Date</label>
                <input path="apptDate" type="date" name="apptDate" id="apptDate" class="form-control" onblur="checkDate()" />
              </div>
            </div>
            <div class="col-6">
              <div class="cell">
                <label for="descr" class="form-label">Brief Desc. About Disease</label>
                <form:textarea path="descr" id="descr" class="form-control" rows="5"/>
              </div>
            </div>
          </div>
          <div class="row no-gutters">
            <div class="col-6">
              <div class="cell">
                <label for="address" class="form-label">Patient's Address</label>
                <form:textarea path="address" id="address" class="form-control" rows="5"/>
              </div>
            </div>
            <div class="col-6">
              <div class="cell">
                <label for="email" class="form-label">Email</label>
                <input path="email" type="email" name="email" id="email" class="form-control"  />
              </div>
            </div>
          </div>
          <div class="row no-gutters">
            <div class="col-6">
              <div class="cell">
                <label for="mobile" class="form-label">Mobile</label>
                <input path="mobile" type="number" name="mobile" id="mobile" class="form-control" />
              </div>
            </div>
          </div>
        </div>
        <div class="col-4">
          <div class="cell cell__big">
              <table id="employeeTable table" class="table table-striped table-bordered">
                <thead>
                <tr>
                  <th>Appointment</th>
                  <th>Booking Status</th>
                </tr>
                </thead>
                <tbody id="tableBody">
                <c:forEach items="${tableDataList}" var="e">
                  <tr style="height: 1rem;">
                    <td>${e.apptDate}</td>
                    <td>${e.totalAppt}</td>
                  </tr>
                </c:forEach>
                </tbody>
              </table>
          </div>
        </div>
      </div>
    </div>

    <div class="col-md-12" style="margin-left: 40rem;">
      <button type="submit" class="btn btn-success" onclick="submitForm()">Submit</button>
      <button type="button" class="btn btn-warning" onclick="resetForm()">Reset</button>
    </div>
  </form:form>
</fieldset>

</body>

<script>
function checkName(name){
  if (name.length() < 4){
    alert("Name Must be Greater Than 4 Letters!");
    return false;
  }
}

</script>

<script>
  function checkAge(){
    let age = $('#age').val();
    if (age > 100 ){
      alert("Invalid Age");
    }else if(age < 8){
      alert("Invalid Age!");
    }
  }

  function checkDate() {
    var dateString = document.getElementById('id_dateOfBirth').value;
    var myDate = new Date(dateString);
    var today = new Date();
    if ( myDate > today ) {
      alert("Date Must Be Greater Than today.")
      return false;
    }
    return true;
  }
</script>
</html>

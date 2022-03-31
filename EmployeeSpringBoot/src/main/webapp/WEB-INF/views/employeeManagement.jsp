<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/css/bootstrapValidator.min.css"/>
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"> </script>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">
    <script src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js"> </script>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" >
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <title>Employee Master</title>
</head>
<body style="font-family: 'Segoe UI'; margin: 100px">
<h4 style="text-align: center">Employee Registration</h4>
<form id="saveEmployee" method="post" action="/saveEmployee">

    <div style="margin-left: 30px; margin-top: 30px" class="form-group col-md-12">

        <fieldset class="form-group border p-3">
            <legend style="color: orangered" class="w-auto px-2">Personal Details</legend>
            <div style="margin-top: 4rem" class="form-group row required">


                <div class="col-md-4">
                    <label class="form-label control-label" for="inputName">Employee Name<span style="color: red">*</span></label>
                    <input type="text" class="form-control" id="inputName" name="empName" <%--onblur="validateName()"--%>  placeholder="Enter Your Name"/>
                </div>


                <div class="col-md-4">
                    <label class="form-label" for="inputMobile" >Mobile Number<span style="color: red">*</span></label>
                    <input type="number" class="form-control" id="inputMobile" name="empPhn"  placeholder="Enter Mobile Number"/>
                </div>


                <div class="col-md-4">
                    <label class="form-label" for="inputEmail">Email Address<span style="color: red">*</span></label>
                    <input type="email" class="form-control" id="inputEmail" name="empEmail"  placeholder="Enter Email Address"/>
                </div>

            </div>

            <div style="margin-top: 20px" class="form-group row required">


                <div class="col-md-4">
                    <label class="form-label control-label"  for="inputDob">Date of Birth<span style="color: red">*</span></label>
                    <input type="date" class="form-control" id="inputDob" name="empDob"  placeholder="Select Date"/>
                </div>


                <div class="col-md-4">
                    <label class="form-label" for="inputNationality">Select Nationality<span style="color: red">*</span></label>
                    <select name="empNationality" id="inputNationality" class="form-control lab" onchange="findStateByCountryId(this.value)" required="required">
                        <option value="0">Select</option>
                        <c:forEach items="${countryList}" var="countryList">
                            <option value="${countryList.cid}">${countryList.cname}</option>
                        </c:forEach>
                    </select>
                    <div id="inputNationalityalert"></div>
                </div>


                <div class="col-md-4" id="rel1">
                    <label class="form-label" >Select Religion<span style="color: red">*</span></label>
                    <select name="empReligion" id="inputReligion" class="form-control lab" required="required">
                        <option value="0">Select</option>
                        <c:forEach items="${religionList}" var="religionList">
                            <option value="${religionList.rid}">${religionList.rname}</option>
                        </c:forEach>
                        <option value="Other">Other</option>
                    </select>
                </div>

                <div class="col-md-4" id="rel2">
                    <label class="form-label" >Enter Religion<span style="color: red">*</span></label>
                    <input type="text" class="form-control" id="inputRel1" name="empReligion.rname"  placeholder="Enter Religion"/>
                </div>

            </div>


            <div style="margin-top: 20px" class="form-group row required">


                <div class="col-md-4">
                    <label class="form-label control-label" >Select Qualification<span style="color: red">*</span></label>
                    <select name="empQualification" id="inputQualification" class="form-control lab"  required="required">
                        <option value="0">Select</option>
                        <c:forEach items="${qualificationList}" var="qualificationList">
                            <option value="${qualificationList.qualId}">${qualificationList.qualName}</option>
                        </c:forEach>
                    </select>
                </div>


                <div style="margin-top: 30px" class="col-md-4">
                    <label class="form-label" >Select Gender<span style="color: red">*</span></label>
                    <input class="form-check-input" type="radio" name="empGender" value="male">Male &emsp;
                    <input class="form-check-input" type="radio" name="inputGender" value="female">Female
                </div>


            </div>
        </fieldset>

        <fieldset class="form-group border p-3">
            <legend style="color: orangered" class="w-auto px-2">Permanent Address</legend>
            <div style="margin-top: 4rem" class="form-group row required">


                <div class="col-md-4">
                    <label class="form-label control-label" >Street<span style="color: red">*</span></label>
                    <input type="text" class="form-control" id="inputStreet" name="empPermanentAddress.street"  placeholder="Enter Street"/>
                </div>


                <div class="col-md-4">
                    <label class="form-label" >City<span style="color: red">*</span></label>
                    <input type="text" class="form-control" id="inputCity" name="empPermanentAddress.city"  placeholder="Enter City"/>
                </div>


                <div class="col-md-4">
                    <label class="form-label" >Select Country<span style="color: red">*</span></label>
                    <select name="empPermanentAddress.country" id="inputCountry" class="form-control lab" <%--onchange="findStatetByCountryId(this.value)"--%> required="required">
                        <option value="0">Select</option>
                        <c:forEach items="${countryList}" var="countryList">
                            <option value="${countryList.cid}">${countryList.cname}</option>
                        </c:forEach>
                    </select>
                </div>

            </div>

            <div style="margin-top: 20px" class="form-group row required">


                <div class="col-md-4">
                    <label class="form-label control-label" >Select State<span style="color: red">*</span></label>
                    <select name="empPermanentAddress.state" id="inputState" class="form-control lab" required="required">
                        <option value="0">Select</option>
                        <c:forEach items="${stateList}" var="stateList">
                            <option value="${stateList.sid}">${stateList.sname}</option>
                        </c:forEach>
                    </select>
                </div>


                <div class="col-md-4">
                    <label class="form-label" >Pincode<span style="color: red">*</span></label>
                    <input type="number" class="form-control" id="inputPin" name="empPermanentAddress.pincode"  placeholder="Enter Pin Code"/>
                </div>

            </div>

        </fieldset>
        <div><input type="hidden" name="inputId"/></div>

        <div style="margin: auto; margin-top: 20px" class="form-group row col-md-8">

            <div class="form-group row col-md-3">
                <button id="submit" <%--onclick="saveEmployee()"--%> type="submit"  class="btn btn-success">Submit</button>
            </div>

            <div style="margin-left: 10px" class="form-group row col-md-3">
                <button type="reset" class="btn btn-danger">Reset</button>
            </div>

        </div>

        <div id="display"></div>

    </div>
</form>

<div style="margin-left: 35rem">
    <button onclick="window.location='employeeManagement'; return false;" class="btn btn-primary">Employee Management</button>
    <button onclick="window.location='/viewemployeeManagement'; return false;" class="btn btn-success">View Employee</button>
</div>


<script>
    $(document).ready(function (){

        // $('#inputName').attr('disabled', 'disabled');
        $('#rel2').hide();
        $('#rel1').show();


        //Validating And Duplicate Checking
        $('#inputName').blur(function (){
            var name = $(this).val();
            console.log(name);

            //Cheking Empty Value
            if (name == null || name == ""){
                $('#inputName').focus().val("").css('border','1px solid red');
                return false;
            }else {
                $('#inputName').css('border','1px solid green');
                //For the return truw statement the control returns back so that the next ajax method is not called
                // return true;
            }

            //Cheking Duplicate Value
            $.ajax({
                type : "Get",
                url : "/CheckDuplicateEmployee",
                data : {
                    "name" : name
                },
                success : function (response){
                    console.log(response);
                    if (response == "Success"){
                        $('#inputName').focus().val("").css('border','1px solid red');
                        return false;
                    }else {
                        $('#inputName').css('border','1px solid green');
                        return true;
                    }
                },
                error : function (error){
                    console.log(error);
                }
            });

        });


        //Validation Nationality Dropdown
        $("#inputNationality").on('blur', function (){
            var name = $(this).val();
            console.log(name);
            if (name==0){
                // alert("Nationality Must Select!")
                $('#inputNationalityalert').text("Country Must Select!!").css('color', 'red');
                $('#inputNationality').focus().css('border','1px solid red');
                return false;
            }else {
                $('#inputNationalityalert').html("Looks Good").css('color', 'green');
                $('#inputNationality').css('border','1px solid green');
                return true;
            }
            //End


        })

        //For Selecting Other from Religion dropdown
        $('#inputReligion').on('change', function (){
            var name = $(this).val();
            if (name == "Other"){
                $('#rel1').hide();
                $('#rel1').empty();
                $('#rel2').show();
            }
            else {
                $('#rel2').hide();
                $('#rel2').empty();
            }
        });

    });
</script>
</body>
</html>

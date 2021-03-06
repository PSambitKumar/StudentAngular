<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
<%--    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.min.js"></script>--%>
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/css/bootstrapValidator.min.css"/>
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"> </script>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">
    <script src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js"> </script>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" >
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js"></script>
    <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.min.css'></link>
    <title>Make A Drive</title>
</head>
<body style="font-family: 'Segoe UI'; margin: 100px">
<h4>Make A Drive</h4>

<c:choose>
    <c:when test="${flashMessage == 'Success'}">
        <script>swal("Successful", "Drive Added Successfully.", "success")</script>
    </c:when>

    <c:when test="${flashMessage == 'Failed'}">
        <script>swal("Failed", "Failed To Add Drive!", "error")</script>
    </c:when>
<%--    <c:otherwise>--%>
<%--        <script>swal("Oops!", "Something Went Wrong!", "error")</script>--%>
<%--    </c:otherwise>--%>
</c:choose>


<form id="saveDrive" method="post" action="/saveDrive" modelAttribute="studentMaster">

    <div style="margin-left: 30px; margin-top: 30px" class="form-group col-md-12">

        <fieldset class="form-group border p-3">
            <legend style="color: orangered" class="w-auto px-2">Drive Details</legend>
            <div style="margin-top: 4rem" class="form-group row required">


                <div class="col-md-4">
                    <label class="form-label control-label" for="companyName">Company Name<span style="color: red">*</span></label>
                    <input type="text" class="form-control" id="companyName" name="companyName"  placeholder="Enter Company Name"/>
                </div>


                <div class="col-md-4">
                    <label class="form-label" for="dateOfDrive" >Date of Drive<span style="color: red">*</span></label>
                    <input type="date" class="form-control" id="dateOfDrive" name="driveDate"  />
                </div>


                <div class="col-md-3">
                    <label class="form-label" for="package">Package<span style="color: red">*</span></label>
                    <input type="number" class="form-control" id="package" name="drivePackage"  placeholder="Enter Package"/><span>/annum</span>
                </div>

            </div>

            <div style="margin-top: 20px" class="form-group row required">


                <div class="col-md-4">
                    <label class="form-label control-label"  for="hrEmail">Hr's Email<span style="color: red">*</span></label>
                    <input type="email" class="form-control" id="hrEmail" name="hrEmail"  placeholder="ex:name@email.com"/>
                </div>


                <div class="col-md-4">
                    <label class="form-label" for="hrMobileNo">Hr's Mobile Number<span style="color: red">*</span></label>
                    <input type="number" class="form-control" id="hrMobileNo" name="hrMobile"  placeholder="Enter Phone No. Of Hr"/>
                </div>


                <div class="col-md-4" id="rel1">
                    <label class="form-label" >Company Website<span style="color: red">*</span></label>
                    <input type="url" class="form-control" id="companyWebsite" name="companyURL"  placeholder="Company Website URL"/>
                </div>

            </div>
        </fieldset>

        <fieldset class="form-group border p-3">
            <legend style="color: orangered" class="w-auto px-2">Filter Student</legend>
            <div style="margin-top: 4rem" class="form-group row required">


                <div class="col-md-4">
                    <label class="form-label" for="companyName">Branch<span style="color: red">*</span></label></br>
                    <input class="form-check-input"  type="checkbox" name="cse" id="cse" value="CSE"/><label>CSE</label>&emsp;
                    <input class="form-check-input" type="checkbox" name="civil" id="civil" value="CIVIL"/><label>CIVIL</label>
                </div>


                <div class="col-md-2">
                    <label class="form-label" for="tenPer" >10th %age<span style="color: red">*</span></label>
                    <input type="number" class="form-control" id="tenPer" name="tenPer"  />
                </div>

                <div class="col-md-2">
                    <label class="form-label" for="plustwoPer" >+2 %age<span style="color: red">*</span></label>
                    <input type="number" class="form-control" id="plustwoPer" name="plustwoPer"  />
                </div>


                <div class="col-md-3">
                    <label class="form-label" for="cgpa">CGPA<span style="color: red">*</span></label>
                    <input type="cgpa" class="form-control" id="cgpa" name="package"  placeholder="Enter CGPA"/>
                </div>

            </div>

        </fieldset>


        <div style= "float: right;margin: auto; margin-top: 20px" class="form-group row col-md-6">
            <div style="" class="form-group row col-md-4">
                <button type="button" class="btn btn-info" onclick="filterStudents()">Filter Students</button>
            </div>

            <div style="margin-left: 2rem; " class="form-group row col-md-2">
                <button id="submit"  type="submit"  class="btn btn-success">Save</button>
            </div>
        </div>

    </div>


    <div style="margin-left: 30px; margin-top: 30px" class="form-group col-md-12">

        <fieldset class="form-group border p-3">
            <legend style="color: orangered" class="w-auto px-2">Student Details</legend>

            <table id="studentTable table" class="table table-striped table-bordered" style="margin-top: 1rem;">
                <thead>
                <tr>
                    <th>Sl. No</th>
                    <th>Regd No</th>
                    <th>Name</th>
                    <th>Branch</th>
                    <th>Email</th>
                    <th>Mobile</th>
                </tr>
                </thead>
                <tbody id="tableBody"></tbody>
            </table>
        </fieldset>
    </div>

    <div id="form2"></div>

</form>
<script>
    $(Document).ready(function (){
        $('#form2').hide();
    })
    var count = 0;

    function filterStudents(){
        var cse = $('#cse:checked').val();
        var civil = $('#civil:checked').val();
        var tenPer = $('#tenPer').val();
        var plustwoper = $('#plustwoPer').val();
        var cgpa = $('#cgpa').val();
        console.log(cse + civil + tenPer + plustwoper + cgpa);
        // cse =="on" && civil == undefined && tenPer == ""  && plustwoper == "" && cgpa == ""
        if (cse =="CSE" && civil == undefined && tenPer == ""  && plustwoper == "" && cgpa == ""){
            console.log("Inside This Method1--------------->>")
            $.ajax({
                type : "POST",
                url : "/getCSEStudents",
                data : {
                    "cse" : cse,
                },
                success : function (data){
                    console.log(data);
                    var html = "";
                    var html1 = "";
                    if (data != null && data != ""){
                        $.each(data, function (index, value){
                            count = count + 1 ;
                            html = html + '<tr>' +
                                '<td>'+count+'</td>' +
                                '<td>'+value.regdNo+'</td>' +
                                '<td>'+value.name+'</td>' +
                                '<td>'+value.branch+'</td>' +
                                '<td>'+value.emialId+'</td>' +
                                '<td>'+value.mobileNo+'</td>' +
                                '</tr>';

                            html1 = html1 + '<tr>' +
                                '<td><input style="border: none" type="text" name="regdNo" value='+value.regdNo+'/></td>'
                                '</tr>'


                            // html1 = html1 + '<tr>' +
                            //     '<td>'+count+'</td>' +
                            //     '<td><input style="border: none" type="text" name="regdNo" value='+value.regdNo+'/></td>' +
                            //     '<td><input style="border: none" type="text" name="name" value='+value.name+' /></td>' +
                            //     '<td><input style="border: none" type="text" name="branch" value='+value.branch+' /></td>' +
                            //     '<td><input style="border: none" type="text" name="emialId" value='+value.emialId+' /></td>' +
                            //     '<td><input style="border: none" type="text" name="mobileNo" value='+value.mobileNo+' /></td>' +
                            //     '</tr>'

                        })
                    }
                    else {
                        html = 'No Data Found, Table Empty!';
                    }
                    $('#tableBody').empty().append(html);
                    $('#form2').empty().append(html1).hide();

                },
                error : function (error){
                    console.log(error);
                }
            })
        }
    }
</script>


</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <link href="script/script.js" rel="script"/>
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
    <title>View Employee</title>
</head>
<body style="margin: 100px; font-family: 'Segoe UI'">
<div style="margin: 6rem">
    <h4 style="text-align: center">All Employee Details</h4>

    <div class="row" >
        <div class="col-xs-6">
            <div class="dataTables_length form-inline" id="">
                <label>Display
                    <select name="dynamicTable_length" aria-controls="dynamicTable" class="form-control input-sm" id="pageSize">
                        <option value="10" selected>10</option>
                        <option value="25">25</option>
                        <option value="50">50</option>
                        <option value="100">100</option>
                    </select>
                    records</label>
            </div>
        </div>
    </div>

    <table id="employeeTable table" class="table table-striped table-bordered" style="margin-top: 1rem;">
        <thead>
        <tr>
            <th>Sl No</th>
            <th>Employee Code</th>
            <th>Employee Name</th>
            <th>Applied Date</th>
            <th>Mobile Number</th>
            <th>Email Address</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody id="tableBody"></tbody>
    </table>

    <div class="row" id="tableFoot"></div>

</div>
<div style="margin-left: 35rem">
    <button onclick="window.location='employeeManagement'; return false;" class="btn btn-primary">Home</button>
    <button onclick="window.location='/employeeManagement'; return false;" class="btn btn-success">Employee Registration</button>
</div>





<script>
    $(document).ready(function (){
        loadDataOfTable(10,1);
    });

    $('#pageSize').on('change', function (){
        var pagesize = $(this).val();
        console.log(pagesize);
        loadDataOfTable(pagesize, 1);
    });



    function loadDataOfTable(pageSize, pageNumber){
        var count = 0;
        var pSize = pageSize;
        var pNumber = pageNumber;
        console.log("Page Size " + pSize + " Page Number " + pNumber)

        $.ajax({
            type : "POST",
            url : "/getDataOfTable",
            data : {
               "pageSize" : pageSize,
                "pageNumber" : pageNumber
            } ,
            success : function (response){
                var htmlBody = "";
                var htmlFoot = "";
                var data = response;
                console.log(data);

                if (data != null || data != ""){
                    $.each(data, function (index, value){
                        count = count+1;
                        htmlBody = htmlBody+'<tr><td>'+count+'</td><td>'+value.empCode+'</td><td>'+value.empName+'</td><td>'+value.datePrint+'</td></td><td>'+value.empPhn+'</td></td><td>'+value.empEmail+'</td><td><a class="btn btn-xs bigger btn-primary" href="#" title="Edit" onclick="editQualificationMaster('+value.qualId+');"><span class="glyphicon glyphicon-edit"></span></a></td>';
                    });
                }
                else {
                    html = 'Table Empty, No Data Found!!';
                }
                htmlFoot = '<div class="col-xs-9"> <div role="status" aria-live="polite">Showing '+pNumber+' to '+pSize+' of '+pSize+' entries</div> </div> <div class="col-xs-3"> <div> <ul class="pagination"> <li class="paginate_button previous disabled" aria-controls="dynamicTable" tabindex="0" id="dynamicTable_previous"><a onclick="loadTableBodyData('+pSize+',0)">Previous</a></li> <li class="paginate_button active" aria-controls="dynamicTable" tabindex="0" id="btn1"><a onclick="loadDataOfTable('+pSize+',1)" style="cursor: pointer;">1</a></li> <li class="paginate_button fade in" aria-controls="dynamicTable" tabindex="0" id="btn2"><a onclick="loadDataOfTable('+pSize+',2)" style="cursor: pointer;">2</a></li> <li class="paginate_button fade in" aria-controls="dynamicTable" tabindex="0" id="btn3"><a onclick="loadDataOfTable('+pSize+',3)" style="cursor: pointer;">3</a></li> <li class="paginate_button next fade in" aria-controls="dynamicTable" tabindex="0" id="dynamicTable_next"><a href="#">Next</a></li> </ul> </div>';

                $('#tableBody').empty().append(htmlBody);
                $('#tableFoot').empty().append(htmlFoot);
            } ,
            error : function (error){
                console.log(error);
            }
        });
    }





    function openModal(id){
        var empId = id;
        console.log(empId);

        $('#modalBtn').hidden;

        $.ajax({
            type: "GET",
            url: "/getPersonalData",
            data: {
                "empId" : empId
            },
            success: function (response){
                console.log(response);
                $('#body').append(response);
                // location.reload();
            },
            error: function (response){}
        });
    }

    function refreshPage(){
        location.reload();
    }
</script>


<div class="container">
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Employee Details</h4>
                </div>
                <div class="modal-body">
                    <div id="body"></div>
                </div>
                <div class="modal-footer">
                    <button onclick="refreshPage()" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>

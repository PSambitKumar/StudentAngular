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

        <tbody id="tableBody">
        <c:forEach items="${employeeList}" var="employeeList" varStatus="counter">
            <tr>
                <td>${counter.count}</td>
                <td><a href="#myModal"data-toggle="modal" data-target="#myModal"  id="modalCheck" onclick="openModal(${employeeList.empId})">${employeeList.empCode}</a></td>
                <td>${employeeList.empName}</td>
                <td>${employeeList.empApplyDate}</td>
                <td>${employeeList.empPhn}</td>
                <td>${employeeList.empEmail}</td>
                <td>
                    <a href = "/editEmployee/${employeeList.empId}"><span class="glyphicon glyphicon-edit"></span></a>
                    |
                    <a href = "/deleteEmployee/${employeeList.empId}"><span class="glyphicon glyphicon-trash"></span></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>

        <tfoot>
        <tr>
            <td colspan="2">Col Span 2</td>
            <td colspan="5">Col Span 5</td>
        </tr>
        </tfoot>

    </table>

    <div class="row">
        <div class="col-xs-9">
            <div <%--class="dataTables_info" id="dynamicTable_info"--%> role="status" aria-live="polite">Showing 0 to 0 of 0 entries</div>
        </div>
        <div class="col-xs-3">
            <div <%--class="dataTables_paginate paging_simple_numbers" id="dynamicTable_paginate"--%>>
                <ul class="pagination">
                    <li class="paginate_button previous disabled" aria-controls="dynamicTable" tabindex="0" id="dynamicTable_previous"><a onclick="loadTableBodyData(10,0)">Previous</a></li>
                    <li class="paginate_button active" aria-controls="dynamicTable" tabindex="0" id="btn1"><a onclick="loadDataOfTable(10,1)" style="cursor: pointer;">1</a></li>
                    <li class="paginate_button" aria-controls="dynamicTable" tabindex="0" id="btn2"><a onclick="loadDataOfTable(10,2)" style="cursor: pointer;">2</a></li>
                    <li class="paginate_button" aria-controls="dynamicTable" tabindex="0" id="btn3"><a onclick="loadDataOfTable(10,3)" style="cursor: pointer;">3</a></li>
                    <li class="paginate_button next" aria-controls="dynamicTable" tabindex="0" id="dynamicTable_next"><a href="#">Next</a></li>
                </ul>
            </div>
        </div>
    </div>

</div>
<div style="margin-left: 35rem">
    <button onclick="window.location='employeeManagement'; return false;" class="btn btn-primary">Home</button>
    <button onclick="window.location='/employeeManagement'; return false;" class="btn btn-success">Employee Registration</button>
</div>
<script>
    $(document).ready(function (){
        // $('.table').DataTable();
        loadDataOfTable(10,1);
    });

    $('#pageSize').on('change', function (){
        var pagesize = $(this).val();
        console.log(pagesize);
        loadDataOfTable(pagesize, 1);
    });

    function loadDataOfTable(pageSize, pageNumber){
        var pSize = pageSize;
        var pNumber = pageNumber;
        console.log("Page Size " + pSize + " Page Number " + pNumber)
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

<%--<button id="modalBtn" type="button" data-toggle="modal" data-target="#myModal">Open Modal</button>--%>

<div class="container">
    <%--    <!-- Modal -->--%>
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">
            <!-- Modal content-->
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

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
    <title>Product Master</title>
</head>
<body>
<form id="saveProductMaster" method="post" action="/saveProductMaster" modelAttribute="productMaster">

    <div style="margin-left: 30px; margin-top: 30px; margin-right: 30px" class="form-group col-md-11">

        <fieldset class="form-group border p-3">
            <legend style="color: orangered" class="w-auto px-2">Add Product</legend>
            <div style="margin-top: 4rem" class="form-group row required">


                <div class="col-md-4">
                    <label class="form-label control-label" for="pName">Product Name<span style="color: red">*</span></label>
                    <input type="text" class="form-control" id="pName" value="${productMaster.pName}" name="pName" <%--onblur="validateName()"--%>  placeholder="Enter Product Name"/>
                </div>


                <div class="col-md-4">
                    <label class="form-label" for="pPrice" >Product Price<span style="color: red">*</span></label>
                    <input type="number" class="form-control" value="${productMaster.pPrice}" id="pPrice" name="pPrice"  placeholder="Enter Product Price"/>
                </div>


                <div class="col-md-4">
                    <label class="form-label" for="pDesc">Product Description<span style="color: red">*</span></label>
                    <input type="text" class="form-control" id="pDesc" value="${productMaster.pDesc}" name="pDesc"  placeholder="Enter Product Description"/>
                </div>

            </div>

            <div><input type="hidden" name="pId" value="${productMaster.pId}" id="pId"/></div>

            <div style="margin: auto; margin-top: 20px" class="form-group row col-md-8">

                <div class="form-group row col-md-3">
                    <button id="submit" type="submit"  class="btn btn-success">Submit</button>
                </div>

                <div style="margin-left: 10px" class="form-group row col-md-3">
                    <button type="reset" class="btn btn-danger">Reset</button>
                </div>
            </div>
        </fieldset>

        <div id="display"></div>

    </div>
</form>




<div style="margin-left: 30px; margin-top: 30px; margin-right: 30px" class="form-group col-md-11">

    <fieldset class="form-group border p-3">
        <legend style="color: orangered" class="w-auto px-2">Product List</legend>
        <table border = "1" align="center" class="table table-striped table-bordered" cellspacing="0" id="dynamicTable">
            <thead>
            <tr>
                <th>Sl No</th>
                <th>Product Name</th>
                <th>Product Price</th>
                <th>Product Desc.</th>
                <th>Action</th>
            </tr>

            </thead>

            <tbody>
            <c:forEach items="${productMasterList}" var="productMasterList" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${productMasterList.pName}</td>
                    <td>${productMasterList.pPrice}</td>
                    <td>${productMasterList.pDesc}</td>
                    <td>
                        <a href = "/edit/${productMasterList.pId}">Edit</a>
                        |
                        <a href = "/delete/${productMasterList.pId}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
    </fieldset>

</div>

<script>
    jQuery(function($) {
        $('#dynamicTable').DataTable({
            pageLength: 10,
            paging: true,
            searching: true,
            order: [[0, "asc"]],
            columnDefs: [{ orderable: true, targets: [3] }]
        });
    })
</script>

</body>
</html>

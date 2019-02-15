<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="submitFormUrl" value="/api-admin-news"></c:url>
<html>
<head>
    <title><fmt:message key="label.news.page.title" bundle="${lang}"/></title>
    <style>
        #newsImage {
            display: none;
        }

        .imagePreviewWrapper {
            width: 150px;
            height: 150px;
            background: url("<c:url value='/template/admin/image/icon_preview.png'/>") center;
            background-size: cover;
            border: 2px dashed #909090;
            cursor: pointer;
        }

        #imagePreview {
            width: 100%;
            height: 100%;
            object-fit: cover;
        }
    </style>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try {
                    ace.settings.check('breadcrumbs', 'fixed')
                } catch (e) {
                }
            </script>
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Home</a>
                </li>
                <li>
                    <a href="#">
                        <fmt:message key="label.news" bundle="${lang}"/>
                    </a>
                </li>
                <li class="active">
                    <fmt:message key="label.news.info.${model.id eq null ? 'insert' : 'update'}" bundle="${lang}"/>
                </li>
            </ul>
            <!-- /.breadcrumb -->
            <div class="nav-search" id="nav-search">
                <form class="form-search">
                     <span class="input-icon">
                     <input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input"
                            autocomplete="off">
                     <i class="ace-icon fa fa-search nav-search-icon"></i>
                     </span>
                </form>
            </div>
            <!-- /.nav-search -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${not empty message}">
                        <div class="alert alert-${alert}">
                                ${message}
                        </div>
                    </c:if>
                    <form id="submitForm" class="form-horizontal" role="form"
                          enctype="multipart/form-data" method="post">
                        <c:if test="${not empty model.id}">
                            <input type="hidden" name="id" value="${model.id}">
                        </c:if>
                        <div class="form-group" style="display: flex; justify-content: center;">
                            <input type="file" id="newsImage" name="thumbnail">
                            <div class="imagePreviewWrapper">
                                <c:if test="${not empty model.thumbnail}">
                                    <c:url value="/repository/${model.thumbnail}" var="imageUrl"></c:url>
                                </c:if>
                                <img src="${imageUrl}" alt="" id="imagePreview">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label no-padding-right">Thể loại</label>
                            <div class="col-sm-5">
                                <select class="form-control" id="categoryId" name="categoryId">
                                    <c:forEach var="category" items="${model.categoryModelList}">
                                        <option value="${category.id}" ${category.id eq model.categoryId ? 'selected' : ''}>${category.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label no-padding-right">Tiêu đề</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" id="title" name="title" value="${model.title}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label no-padding-right">Mô tả ngắn</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" id="description" name="description"
                                       value="${model.description}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label no-padding-right">Nội dung</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" id="content" name="content"
                                       value="${model.content}"/>
                            </div>
                        </div>
                        <div class="clearfix form-actions">
                            <div style="display: flex; justify-content: center;">
                                <button class="btn btn-sm btn-info" type="button" id="submitButton">
                                    <i class="ace-icon fa fa-check bigger-110"></i>
                                    Submit
                                </button>

                                &nbsp; &nbsp; &nbsp;
                                <button class="btn btn-sm" type="reset">
                                    <i class="ace-icon fa fa-undo bigger-110"></i>
                                    Reset
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /.page-content -->
    </div>
</div>
<content tag="local_script">
    <%--<script type="application/javascript" src="<c:url value='/library/ckeditor/ckeditor.js'/>"></script>--%>
    <%--<script type="application/javascript" src="<c:url value='/library/ckfinder/ckfinder.js'/>"></script>--%>
    <script type="application/javascript"
            src="<c:url value='/template/admin/assets/js/jquery.validate.min.js'/>"></script>

    <script type="application/javascript">
        $(document).ready(function () {
            addEnventForButton();
            getImagePreview();
        })

        function getImagePreview() {
            $(".imagePreviewWrapper").click(function () {
                $("#newsImage").trigger('click');
            })

            $("#newsImage").change(function () {
                readURL(this);
            })
        }

        function readURL(input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
                    $('#imagePreview').attr('src', reader.result);
                }

                reader.readAsDataURL(input.files[0]);
            }
        }

        function addEnventForButton() {
            $("#submitButton").click(function () {
                var data = {};
                var formData = $("#submitForm").serializeArray();
                $.each(formData, function (index, object) {
                    data[object.name] = object.value;
                })

                <c:choose>
                <c:when test="${empty model.id}">
                addNew(data);
                </c:when>
                <c:otherwise>
                update(data);
                </c:otherwise>
                </c:choose>
            });
        }

        function addNew(data) {
            $.ajax({
                url: '${submitFormUrl}',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(data),
                dataType: 'json',
                success: function (result) {
                    console.log(result);
                },
                error: function (error) {
                    console.log(error);
                },
            });
        }

        function update(data) {
            $.ajax({
                url: '${submitFormUrl}',
                type: 'PUT',
                contentType: 'application/json',
                data: JSON.stringify(data),
                dataType: 'json',
                success: function (result) {
                    console.log(result);
                },
                error: function (error) {
                    console.log(error);
                },
            });
        }

        <%--function validateFormInput() {--%>
        <%--$('#editingForm').validate({--%>
        <%--ignore: [],--%>
        <%--rules: [],--%>
        <%--messages: []--%>
        <%--});--%>

        <%--$("#guidelineTitle").rules("add", {--%>
        <%--required: true,--%>
        <%--minlength: 5,--%>
        <%--maxlength: 255,--%>
        <%--messages: {--%>
        <%--required: '<fmt:message key="label.input.empty" bundle="${lang}"/>',--%>
        <%--minlength: jQuery.validator.format('<fmt:message key="label.input.minlenght" bundle="${lang}"/>'),--%>
        <%--maxlength: jQuery.validator.format('<fmt:message key="label.input.maxlenght" bundle="${lang}"/>')--%>
        <%--}--%>
        <%--});--%>

        <%--<c:if test="${empty item.pojo.listenGuideLineId}">--%>
        <%--$("#newsImage").rules("add", {--%>
        <%--required: true,--%>
        <%--messages: {--%>
        <%--required: '<fmt:message key="label.input.empty" bundle="${lang}"/>',--%>
        <%--}--%>
        <%--});--%>
        <%--</c:if>--%>


        <%--$("#guidelineContent").rules("add", {--%>
        <%--required: function () {--%>
        <%--CKEDITOR.instances.guidelineContent.updateElement();--%>
        <%--},--%>
        <%--messages: {--%>
        <%--required: '<fmt:message key="label.input.empty" bundle="${lang}"/>',--%>
        <%--}--%>
        <%--});--%>
        <%--}--%>
    </script>
</content>
</body>
</html>

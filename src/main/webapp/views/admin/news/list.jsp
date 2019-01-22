<%--
  Created by IntelliJ IDEA.
  User: vothanhtai
  Date: 1/17/19
  Time: 21:45
--%>
<%@include file="/common/taglib.jsp" %>
<c:url var="formSubmitUrl" value="/admin-news"></c:url>
<html>
<head>
    <title>Danh sách bài viết</title>
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
                        Quản lý bài viết
                    </a>
                </li>
                <li class="active">
                    Danh sách bài viết
                </li>
            </ul>
            <!-- /.breadcrumb -->
            <div class="nav-search" id="nav-search">
                <form class="form-search" action="${listenGuidelineSearchUrl}" method="get">
                    <input type="hidden" name="urlType" value="url_list">
                    <span class="input-icon">
                     <input type="text" name="pojo.title" value="${param['pojo.title']}" placeholder="Search ..."
                            class="nav-search-input" id="nav-search-input"
                            autocomplete="off">
                     <i class="ace-icon fa fa-search nav-search-icon"></i>
                     </span>
                    <input type="submit" class="hidden">
                </form>
            </div>
            <!-- /.nav-search -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <!-- PAGE CONTENT BEGINS -->
                    <c:if test="${not empty messageResponse}">
                        <div class="alert alert-dismissible fade in alert-${alert}">
                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                            <strong>${messageResponse}</strong>
                        </div>
                    </c:if>
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="pull-right">
                                <div class="btn-group btn-overlap">
                                    <div class="ColVis btn-group" title="" data-original-title="Show/hide columns">
                                        <a href="${listenGuidelineImportUrl}"
                                           class="ColVis_Button ColVis_MasterButton btn btn-success btn-sm btn-bold"
                                           style="display: flex; align-items: center">
                                            <span><i class="icon-only  ace-icon ace-icon fa fa-file-excel-o bigger-140"
                                                     style="padding-right: 5px"></i></span>Import
                                        </a>
                                        <a href="${listenGuidelineEditUrl}"
                                           class="ColVis_Button ColVis_MasterButton btn btn-primary btn-sm btn-bold"
                                           style="display: flex; align-items: center">
                                            <span><i class="icon-only  ace-icon ace-icon fa fa-plus bigger-140"
                                                     style="padding-right: 5px"></i></span>Thêm
                                        </a>
                                        <button class="ColVis_Button ColVis_MasterButton btn btn-danger btn-sm btn-bold"
                                                id="btnDeleteAll" style="display: flex; align-items: center" disabled
                                                onclick="btnClickEvent(this)">
                                            <span><i class="ace-icon fa fa-trash-o bigger-140"
                                                     style="padding-right: 5px"></i></span>Xoá
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <br>
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th class="text-primary">Title</th>
                            <th class="text-primary">Description</th>
                            <th class="text-primary">Created date</th>
                            <th class="text-primary">Created by</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${model.listResult}" var="news">
                            <tr>
                                <td>${news.title}</td>
                                <td>${news.description}</td>
                                <td>${news.createdDate}</td>
                                <td>${news.createdBy}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div class="row">
                        <div class="col-xs-12 text-center">
                            <ul class="pagination" id="pagination"></ul>
                        </div>
                    </div>
                    <form action="${formSubmitUrl}" id="pagingForm">
                        <input type="hidden" id="page" name="page">
                        <input type="hidden" id="maxPageItems" name="maxPageItems" value="${model.maxPageItems}">
                    </form>
                    <!-- PAGE CONTENT ENDS -->
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /.page-content -->
    </div>
</div>
<content tag="local_script">
    <script type="text/javascript">
        $(function () {
            window.pagObj = $('#pagination').twbsPagination({
                totalPages: ${model.totalPages},
                visiblePages: 5,
                startPage: ${model.page},
                onPageClick: function (event, page) {
                }
            }).on('page', function (event, page) {
                $('#page').val(page);
                $('#pagingForm').submit();
            });
        });
    </script>
</content>
</body>
</html>

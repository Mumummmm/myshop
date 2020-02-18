<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<html>
<head>
    <title>我的商城 | 内容管理</title>
    <jsp:include page="../includes/header.jsp"/>
    <link rel="stylesheet" href="/static/assets/plugins/jquery-ztree/css/zTreeStyle/zTreeStyle.min.css" />
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">
    <!-- Navbar -->
    <jsp:include page="../includes/nav.jsp"/>
    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <jsp:include page="../includes/sidebar.jsp"/>
    <!-- /.Main Sidebar Container -->

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <div class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1 class="m-0 text-dark">内容管理</h1>
                    </div><!-- /.col -->
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">我的商城</a></li>
                            <li class="breadcrumb-item active">内容管理</li>
                        </ol>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <c:if test="${baseResult != null}">
                    <div class="alert alert-warning alert-dismissible">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        <h5><i class="icon fas fa-ban"></i> 注意!</h5>
                            ${baseResult.message}
                    </div>
                </c:if>
                <!-- Horizontal Form -->
                <div class="card card-info">
                    <div class="card-header">
                        <h3 class="card-title">${tbContent.id == null ? "新增" : "修改"}内容</h3>
                    </div>
                    <!-- /.card-header -->
                    <!-- form start -->
                    <form:form id="inputForm" cssClass="form-horizontal" action="/my_shop_web_admin_war_exploded/user/save" method="post" modelAttribute="tbContent">
                        <form:hidden path="id" />
                        <div class="card-body">
                            <div class="form-group row">
                                <label for="categoryId" class="col-sm-2 col-form-label">类别</label>
                                <div class="col-sm-10">
                                    <form:input path="categoryId" cssClass="form-control required" placeholder="请选择类别"/>
                                </div>
                            </div>
                        </div>
                        <!-- /.card-body -->
                        <div class="card-footer">
                            <button type="button" class="btn btn-info" onclick="history.back(-1)">返回</button>
                            <button type="submit" class="btn btn-success float-right">保存修改</button>
                        </div>
                        <!-- /.card-footer -->
                    </form:form>
                </div>
                <!-- /.card -->
            </div>
        </section>
        <!-- /.Main content -->
    </div>

    <!-- copyright -->
    <jsp:include page="../includes/copyright.jsp"/>
    <!-- /.copyright -->
</div>

<jsp:include page="../includes/footer.jsp"/>
<script src="/static/assets/plugins/jquery-ztree/js/jquery.ztree.core-3.5.min.js"></script>

<!-- 自定义模态框 -->
<sys:modal title="请选择" message="<ul id='myTree' class='ztree'></ul>" />

<script>
    $(function () {
        App.initZTree("/content/category/tree/data", ["id"], function (nodes) {
            var node = nodes[0];
            $("#parentId").val(node.id);
            $("#parentName").val(node.name);
            $("#modal-default").modal("hide");
        });
    });
</script>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<html>
<head>
    <title>我的商城 | 内容管理</title>
    <jsp:include page="../includes/header.jsp"/>
    <link rel="stylesheet" href="/my_shop_web_admin_war_exploded/static/assets/plugins/treeTable/themes/vsStyle/treeTable.min.css">
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
                    <div class="alert alert-success alert-dismissible">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        <h5><i class="icon fas fa-check"></i> 注意!</h5>
                            ${baseResult.message}
                    </div>
                </c:if>

                <!-- card -->
                <div class="card card-info">
                    <!-- card-header -->
                    <div class="card-header">
                        <h3 class="card-title">内容类目列表</h3>
                    </div>
                    <!-- /.card-header -->
                    <!-- card-body -->
                    <div class="card-body">
                        <div class="row">
                            <div class="col-xs-12">
                                <a class="btn btn-secondary btn-sm" href="#">
                                    <i class="fas fa-plus-circle">
                                    </i>
                                    新增
                                </a>
                                <a class="btn btn-secondary btn-sm" href="#">
                                    <i class="fas fa-trash">
                                    </i>
                                    删除
                                </a>
                                <a class="btn btn-secondary btn-sm" href="#">
                                    <i class="fas fa-upload">
                                    </i>
                                    导入
                                </a>
                                <a class="btn btn-secondary btn-sm" href="#">
                                    <i class="fas fa-download">
                                    </i>
                                    导出
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="card-body">
                        <div class="row table-responsive p-0">
                            <table id="treeTable" class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>名称</th>
                                        <th>排序</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${tbContentCategories}" var="tbContentCategory">
                                    <tr id="${tbContentCategory.id}" pId="${tbContentCategory.parentId}">
                                        <td>${tbContentCategory.id}</td>
                                        <td>${tbContentCategory.name}</td>
                                        <td>${tbContentCategory.sortOrder}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <!-- /.card-body -->
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
<script src="/my_shop_web_admin_war_exploded/static/assets/plugins/treeTable/jquery.treeTable.min.js"></script>
<sys:modal></sys:modal>

<script>
    $(function () {
        var option = {
            column: 1,
            expandLevel : 2,
        };
        $('#treeTable').treeTable(option);
    })
</script>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<html>
<head>
    <title>我的商城 | 内容管理</title>
    <jsp:include page="../includes/header.jsp"/>
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
                <div class="card card-info card-search" style="display: none;">
                    <!-- card-header -->
                    <div class="card-header">
                        <h3 class="card-title">高级搜索</h3>
                    </div>
                    <!-- /.card-header -->
                    <!-- card-body -->
                    <div class="card-body row form-horizontal">
                        <div class="form-group col-md-3 row">
                            <label for="title" class="col-sm-2 col-form-label">标题</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="title" name="title" placeholder="标题">
                            </div>
                        </div>
                        <div class="form-group col-md-3 row">
                            <label for="subTitle" class="col-sm-2 col-form-label">子标题</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="subTitle" name="subTitle" placeholder="子标题">
                            </div>
                        </div>
                        <div class="form-group col-md-3 row">
                            <label for="titleDesc" class="col-sm-2 col-form-label">标题简介</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="titleDesc" name="titleDesc" placeholder="标题简介">
                            </div>
                        </div>
                    </div>
                    <!-- /.card-body -->
                    <!-- card-footer -->
                    <div class="card-footer">
                        <button type="button" class="btn btn-info float-right" onclick="search();"><i class="fas fa-search"></i></button>
                    </div>
                    <!-- /.card-footer -->
                </div>
                <!-- /.card -->

                <!-- card -->
                <div class="card card-info">
                    <!-- card-header -->
                    <div class="card-header">
                        <h3 class="card-title">内容列表</h3>
                    </div>
                    <!-- /.card-header -->
                    <!-- card-body -->
                    <div class="card-body">
                        <div class="row">
                            <div class="col-xs-12">
                                <a class="btn btn-secondary btn-sm" href="/my_shop_web_admin_war_exploded/content/form">
                                    <i class="fas fa-plus-circle">
                                    </i>
                                    新增
                                </a>
                                <a class="btn btn-secondary btn-sm" href="#" onclick="App.deleteMulti('/my_shop_web_admin_war_exploded/user/delete');">
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
                                <button class="btn btn-secondary btn-sm" onclick="$('.card-search').css('display') == 'none' ? $('.card-search').show('fast') : $('.card-search').hide('fast')">
                                    <i class="fas fa-search">
                                    </i>
                                    搜索
                                </button>
                            </div>
                        </div>
                    </div>
                    <div class="card-body">
                        <div class="row table-responsive p-0">
                            <table id="dataTable" class="table table-hover">
                                <thead>
                                <tr>
                                    <th>
                                        <input type="checkbox" class="minimal icheck_master" />
                                    </th>
                                    <th>ID</th>
                                    <th>标题</th>
                                    <th>子标题</th>
                                    <th>标题简介</th>
                                    <th>url</th>
                                    <th>图片1</th>
                                    <th>图片2</th>
                                    <th>更新时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
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
<sys:modal></sys:modal>

<script>
    var dataTable;

    $(function () {
        var url = "/my_shop_web_admin_war_exploded/content/page";
        var columns = [
            {"data": function ( row, type, val, meta ) {
                    return '<input id="'+ row.id + '" type="checkbox" class="minimal" />'
                }
            },
            { "data": "id" },
            { "data": "title" },
            { "data": "subTitle" },
            { "data": "titleDesc" },
            {
                "data": function (row, type, val, meta) {
                    if (row.url == null) {
                        return '';
                    }

                    return '<a href="' + row.url + '" target="_blank">查看</a>';
                }
            },
            {
                "data": function (row, type, val, meta) {
                    if (row.pic == null) {
                        return '';
                    }

                    return '<a href="' + row.pic + '" target="_blank">查看</a>';
                }
            },
            {
                "data": function (row, type, val, meta) {
                    if (row.pic2 == null) {
                        return '';
                    }

                    return '<a href="' + row.pic2 + '" target="_blank">查看</a>';
                }
            },
            {
                "data": function (row, type, val, meta) {
                    return DateTime.format(row.updated, "yyyy-MM-dd HH:mm:ss");
                }
            },
            { "data": function ( row, type, val, meta ) {
                    var detailUrl = "/my_shop_web_admin_war_exploded/user/detail?id=" + row.id;
                    return '<button class="btn btn-primary btn-sm" onclick="App.showDetail(\''+detailUrl+'\')"> <i class="fas fa-eye"> </i>查看 </button>'
                        +'<a class="btn btn-info btn-sm" href="/my_shop_web_admin_war_exploded/content/form?id='+row.id+'"> <i class="fas fa-pencil-alt"> </i>编辑 </a>'
                        +'<a class="btn btn-danger btn-sm" href="#"> <i class="fas fa-trash"> </i>删除 </a>';
                }
            },
        ];
        dataTable = App.initDataTable(url, columns);
    });

    function search() {
        var title = $('#title').val();
        var subTitle = $('#subTitle').val();
        var titleDesc = $('#titleDesc').val();

        dataTable.settings()[0].ajax.data = {
            "title": title,
            "subTitle": subTitle,
            "titleDesc": titleDesc
        };
        dataTable.ajax.reload();
    };

</script>
</body>
</html>

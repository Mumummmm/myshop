<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>我的商城 | 用户管理</title>
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
                        <h1 class="m-0 text-dark">用户管理</h1>
                    </div><!-- /.col -->
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">我的商城</a></li>
                            <li class="breadcrumb-item active">用户管理</li>
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
                        <h3 class="card-title">${tbUser.id == null ? "新增" : "修改"}用户</h3>
                    </div>
                    <!-- /.card-header -->
                    <!-- form start -->
                    <form:form id="inputForm" cssClass="form-horizontal" action="/my_shop_web_admin_war_exploded/user/save" method="post" modelAttribute="tbUser">
                        <form:hidden path="id" />
                        <div class="card-body">
                            <div class="form-group row">
                                <label for="email" class="col-sm-2 col-form-label">邮箱</label>
                                <div class="col-sm-10">
                                    <form:input path="email" cssClass="form-control required email" placeholder="请输入邮箱"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="password" class="col-sm-2 col-form-label">密码</label>
                                <div class="col-sm-10">
                                    <form:input path="password" cssClass="form-control required" placeholder="请输入用户密码"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="username" class="col-sm-2 col-form-label">姓名</label>
                                <div class="col-sm-10">
                                    <form:input path="username" cssClass="form-control required" placeholder="请输入姓名"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="phone" class="col-sm-2 col-form-label">电话</label>
                                <div class="col-sm-10">
                                    <form:input path="phone" cssClass="form-control required" placeholder="请输入电话"/>
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
</body>
</html>

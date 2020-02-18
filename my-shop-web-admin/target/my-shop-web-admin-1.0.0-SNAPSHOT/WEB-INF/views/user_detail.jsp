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
<div class="card">
    <div class="card-header">
        <h3 class="card-title">用户详情</h3>
    </div>
    <!-- /.card-header -->
    <div class="card-body p-0">
        <table class="table table-condensed">
            <tbody>
            <tr>
                <td>姓名</td>
                <td>${tbUser.username}</td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td>${tbUser.email}</td>
            </tr>
            <tr>
                <td>电话</td>
                <td>${tbUser.phone}</td>
            </tr>
            <tr>
                <td>创建时间</td>
                <td><fmt:formatDate value="${tbUser.created}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            </tr>
            <tr>
                <td>更新时间</td>
                <td><fmt:formatDate value="${tbUser.updated}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            </tr>
            </tbody>
        </table>
    </div>
    <!-- /.card-body -->
</div>
<jsp:include page="../includes/footer.jsp"/>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade" id="modal-detail">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">用户详情</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body">
                <p id="modal-detail-body"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<!-- jQuery -->
<script src="/my_shop_web_admin_war_exploded/static/assets/plugins/jquery/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="/my_shop_web_admin_war_exploded/static/assets/plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- jQuery validate 1.19.1 -->
<script src="/my_shop_web_admin_war_exploded/static/assets/plugins/jquery-validation/jquery.validate.min.js"></script>
<script src="/my_shop_web_admin_war_exploded/static/assets/plugins/jquery-validation/additional-methods.min.js"></script>
<script src="/my_shop_web_admin_war_exploded/static/assets/plugins/jquery-validation/localization/messages_zh.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
    $.widget.bridge('uibutton', $.ui.button)
</script>
<!-- Bootstrap 4 -->
<script src="/my_shop_web_admin_war_exploded/static/assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- ChartJS -->
<script src="/my_shop_web_admin_war_exploded/static/assets/plugins/chart.js/Chart.min.js"></script>
<!-- Sparkline -->
<script src="/my_shop_web_admin_war_exploded/static/assets/plugins/sparklines/sparkline.js"></script>
<!-- JQVMap -->
<script src="/my_shop_web_admin_war_exploded/static/assets/plugins/jqvmap/jquery.vmap.min.js"></script>
<script src="/my_shop_web_admin_war_exploded/static/assets/plugins/jqvmap/maps/jquery.vmap.usa.js"></script>
<!-- jQuery Knob Chart -->
<script src="/my_shop_web_admin_war_exploded/static/assets/plugins/jquery-knob/jquery.knob.min.js"></script>
<!-- daterangepicker -->
<script src="/my_shop_web_admin_war_exploded/static/assets/plugins/moment/moment.min.js"></script>
<script src="/my_shop_web_admin_war_exploded/static/assets/plugins/daterangepicker/daterangepicker.js"></script>
<!-- Tempusdominus Bootstrap 4 -->
<script src="/my_shop_web_admin_war_exploded/static/assets/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
<!-- Summernote -->
<script src="/my_shop_web_admin_war_exploded/static/assets/plugins/summernote/summernote-bs4.min.js"></script>
<!-- overlayScrollbars -->
<script src="/my_shop_web_admin_war_exploded/static/assets/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<!-- AdminLTE App -->
<script src="/my_shop_web_admin_war_exploded/static/assets/js/adminlte.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="/my_shop_web_admin_war_exploded/static/assets/js/pages/dashboard.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="/my_shop_web_admin_war_exploded/static/assets/js/demo.js"></script>
<!-- iCheck -->
<script src="/my_shop_web_admin_war_exploded/static/assets/plugins/iCheck/icheck.min.js"></script>
<!-- DataTables -->
<script type="text/javascript" charset="utf8" src="http://cdn.datatables.net/1.10.15/js/jquery.dataTables.js"></script>
<!-- app -->
<script src="/my_shop_web_admin_war_exploded/static/assets/app/validate.js"></script>
<script src="/my_shop_web_admin_war_exploded/static/assets/app/app.js"></script>
<script src="/my_shop_web_admin_war_exploded/static/assets/app/datetime.js"></script>
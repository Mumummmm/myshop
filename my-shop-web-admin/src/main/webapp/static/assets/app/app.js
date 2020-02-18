var App = function () {
    var _masterCheckbox;
    var _checkbox;

    var _idArray = new Array();

    var handlerInitCheckbox = function () {
        // 激活
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass   : 'iradio_minimal-blue'
        });
        _masterCheckbox = $('input[type="checkbox"].minimal.icheck_master');
        _checkbox = $('input[type="checkbox"].minimal');
    };

    var handlerCheckAll = function () {
        _masterCheckbox.on("ifClicked", function (e) {
            if (e.target.checked) {
                _checkbox.iCheck("uncheck");
            }
            else {
                _checkbox.iCheck("check");
            }
        });
    };

    var handlerDeleteMulti = function (url) {
        _checkbox.each(function () {
            var _id = $(this).attr("id");
            if (_id != null && _id != 'define' && $(this).is(":checked")) {
                _idArray.push(_id);
            }
        });

        if (_idArray.length === 0) {
            $('#modal-message').html("您还没有选择任何数据项，请至少选择一项");
        }
        else {
            $('#modal-message').html("您确定删除数据项吗？");
        }
        $('#modal-default').modal("show");

        $('#btnModalOk').bind("click", function () {
            del();
        })

        function del() {
            $('#modal-default').modal("hide");

            if (_idArray.length === 0) {

            }
            else {
                $.ajax({
                    "url": url,
                    "type": "POST",
                    "data": {"ids" : _idArray.toString()},
                    "dataType": "JSON",
                    "success": function (data) {
                        $("#btnModalOk").unbind("click");

                        if (data.status === 200) {
                            $('#btnModalOk').bind("click", function () {
                                window.location.reload();
                            });
                        }
                        else {
                            $('#btnModalOk').bind("click", function () {
                                $('#modal-default').modal("hide");
                            });
                        }
                        $('#modal-message').html(data.message);
                        $('#modal-default').modal("show");
                    }

                })
            }
        };
    };

    var handlerInitDataTable = function(url, columns) {
        var dataTable = $('#dataTable').DataTable(
            {
                "deferRender": true,
                "lengthChange": false,
                "ordering": false,
                "searching": false,
                "serverSide": true,
                "processing": true,
                "info": true,
                "paging": true,
                "ajax": {
                    url: url,
                    method: "GET"
                },
                "columns": columns,
                "drawCallback": function( settings ) {
                    handlerInitCheckbox();
                    handlerCheckAll();
                },
                language: {
                    "sProcessing": "处理中...",
                    "sLengthMenu": "显示 _MENU_ 项结果",
                    "sZeroRecords": "没有匹配结果",
                    "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                    "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                    "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                    "sInfoPostFix": "",
                    "sSearch": "搜索:",
                    "sUrl": "",
                    "sEmptyTable": "表中数据为空",
                    "sLoadingRecords": "载入中...",
                    "sInfoThousands": ",",
                    "oPaginate": {
                        "sFirst": "首页",
                        "sPrevious": "上页",
                        "sNext": "下页",
                        "sLast": "末页"
                    },
                    "oAria": {
                        "sSortAscending": ": 以升序排列此列",
                        "sSortDescending": ": 以降序排列此列"
                    }
                }
            }
        );
        return dataTable;
    };

    var handlerShowDetail = function (url) {
        $.ajax({
            "url": url,
            "type": "GET",
            "dataType": "html",
            "success": function (data) {
                $('#modal-detail-body').html(data);
                $('#modal-detail').modal("show");
            }
        })
    };

    var handlerInitZTree = function (url, autoParam, callback) {
        var setting = {
            view: {
                selectedMulti: false
            },
            async: {
                enable: true,
                url: url,
                autoParam: autoParam
            }
        };

        $.fn.zTree.init($("#myTree"), setting);

        $("#btnModalOk").bind("click", function () {
            var zTree = $.fn.zTree.getZTreeObj("myTree");
            var nodes = zTree.getSelectedNodes();

            // 未选择
            if (nodes.length == 0) {
                alert("请选择一个节点");
            }
            // 已选择
            else {
                callback(nodes);
            }
        });
    };

    return {
        initCheckbox: function () {
            handlerInitCheckbox();
            handlerCheckAll();
        },

        deleteMulti: function (url) {
            handlerDeleteMulti(url);
        },

        initDataTable: function (url, columns) {
            return handlerInitDataTable(url, columns);
        },

        showDetail: function (url) {
            handlerShowDetail(url);
        },

        initZTree: function(url, autoParam, callback) {
            handlerInitZTree(url, autoParam, callback);
        },
    }
}();

$(document).ready(function () {
    App.initCheckbox();
});
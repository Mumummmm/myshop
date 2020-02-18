var Validate = function() {
    var handlerInitValidate = function() {
        $.validator.addMethod("mobile", function () {
            var length = value.length;
            var mobile = /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/;
            return this.optional(element) || (length == 11 && mobile.test(value));
        }, "手机号码格式错误");

        $("#inputForm").validate({
            errorPlacement: function (element) {
                element.attr("class", "form-control required email is-invalid");
            }
        });
    };

    return {
        init: function () {
            handlerInitValidate();
        }
    }
}();

$(document).ready(function () {
    Validate.init();
})
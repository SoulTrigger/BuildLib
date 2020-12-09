<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="footer" >
	<div class="pull-right">
		By：<a href="http://www.zi-han.net" target="_blank">zihan's blog</a>
	</div>
	<div>
		<strong>Copyright</strong> H+ &copy; 2014
	</div>
</div>
<script src="assets/js/plugins/validate/jquery.validate.min.js"></script>
<script src="assets/js/plugins/validate/additional-methods.min.js"></script>
<script src="assets/js/plugins/validate/messages_zh.min.js"></script>
<script src="assets/js/plugins/sweetalert/sweetalert.min.js"></script>
<script src="assets/js/plugins/iCheck/icheck.min.js"></script>
<script>
$.validator.setDefaults({
    highlight: function (element) {
        $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
    },
    success: function (element) {
        element.closest('.form-group').removeClass('has-error').addClass('has-success');
    },
    errorElement: "span",
    errorPlacement: function (error, element) {
        if (element.is(":radio") || element.is(":checkbox")) {
            error.appendTo(element.parent().parent().parent());
        } else {
            error.appendTo(element.parent());
        }
    },
    errorClass: "help-block m-b-none",
    validClass: "help-block m-b-none"
});
</script>
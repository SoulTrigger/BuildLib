<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="common/meta.jsp" %>
</head>
<body class="gray-bg">

    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name">H+</h1>

            </div>
            <h3>欢迎使用 H+</h3>

            <form class="m-t" role="form" action="index.html">
                <div class="form-group">
                    <input type="email" class="form-control" placeholder="用户名" required="">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="密码" required="">
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>
 				<div class="form-group">
					<div class="checkbox">
					    <label>
					      <input type="checkbox"> 记住密码
					    </label>
				   </div>
				   <div class="checkbox">
					    <label>
					      <input type="checkbox"> 自动登陆
					    </label>
				   </div>
			   </div>
            </form>
        </div>
    </div>

    <!-- 全局js -->
    <script src="assets/js/jquery.min.js?v=2.1.4"></script>
    <script src="assets/js/bootstrap.min.js?v=3.3.6"></script>

</body>
</html>
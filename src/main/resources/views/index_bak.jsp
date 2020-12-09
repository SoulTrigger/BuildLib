<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js">
<head>
<%@include file="common/meta.jsp" %>
</head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 升级浏览器  以获得更好的体验！</p>
<![endif]-->
<%@include file="common/header.jsp" %>
<div class="am-cf admin-main">
  <!-- sidebar start -->
  <%@include file="common/sidebar.jsp" %>
  <!-- sidebar end -->
  <!-- content start -->
  <div class="admin-content"></div>
  <!-- content end -->
</div>
	<p><%=request.getAttribute("handleTime") %>s </p>
	
	
<%@include file="common/footer.jsp" %>
<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="assets/js/jquery.min.js"></script>
<!--<![endif]-->
<script src="assets/js/doT.js"></script>
<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/app.js"></script>
<script>
	var url = "${name}"
	$(".admin-content").load(url,function(){
		$(".am-form-select1").selected();
	});
	
	//sidebar
	var sidebarhtml='';
	$.ajax({
		url:'sidebar',
		success:function(data){
			$(".admin-sidebar-list").empty();
			loadSidebar(data,'')
			$(".admin-sidebar-list").append(sidebarhtml);
		}
	})
	function loadSidebar(datas,collapseName){
		for(var i=0;i<datas.length;i++){
			sidebarhtml+='<li>';
			var collapseval = '';
			if(datas[i].child.length>0){
				collapseName = datas[i].id;
				collapseval = 'data-am-collapse="{target: \'#collapse-'+collapseName+'\'}"';
			}
			sidebarhtml+='<a class="am-cf" '+collapseval+'><span class="am-icon-file"></span> '+datas[i].name+'</a>';
			sidebarhtml+=(datas[i].collections.length>0||datas[i].child.length>0?'<ul class="am-list admin-sidebar-sub am-collapse am-in" id="collapse-'+collapseName+'">':'');
			if(datas[i].collections.length>0){
				for(var j=0;j<datas[i].collections.length;j++){
					sidebarhtml+='<li><a href="#"><span class="am-icon-puzzle-piece"></span> '+datas[i].collections[j].name+'</a></li>';
				}
			}
			if(datas[i].child.length>0){
				loadSidebar(datas[i].child,collapseName);
			}
			sidebarhtml+=(datas[i].collections.length>0||datas[i].child.length>0?'</ul>':'');
			sidebarhtml+='</li>';
		}
	}
</script>

</body>
</html>
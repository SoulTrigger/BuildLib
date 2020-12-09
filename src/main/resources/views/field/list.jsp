<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="row">
	<div class="col-sm-12">
		<div class="ibox float-e-margins">
			<div class="ibox-title">
				<h5>其他</h5>
			</div>
			<div class="ibox-content">
				<div class="row row-lg">
					<div class="col-sm-12">
						<div class="bootstrap-table">
							<div class="fixed-table-toolbar">
								<div class="bars pull-left">
									<div class="btn-group hidden-xs" id="exampleToolbar"
										role="group">
										<button type="button" class="btn btn-outline btn-default" onclick="javascript:location.href='page/field/toEdit'">
											<i class="glyphicon glyphicon-plus" aria-hidden="true"></i>
										</button>
										<button type="button" class="btn btn-outline btn-default" onclick="edit()">
											<i class="glyphicon glyphicon-edit" aria-hidden="true"></i>
										</button>
										<button type="button" class="btn btn-outline btn-default">
											<i class="glyphicon glyphicon-trash" aria-hidden="true"></i>
										</button>
									</div>
								</div>
							</div>
							<table id="table"></table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script src="assets/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="assets/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script src="assets/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script>
	///数据加载
	$('#table').bootstrapTable({	
	  url: 'field/list',
	  pagination:true,
	  search:true,
	  sidePagination : 'server',
	  pageSize : 8,
	  queryParamsType: '',
	  clickToSelect:true,
	  columns: [{
		  checkbox:true
	  }, {
	    field: 'label',
	    title: '中文名称'
	  }, {
	    field: 'columnName',
	    title: '英文名称'
	  }, {
	    field: 'shortColumnName',
	    title: '英文名称缩写'
	  }, {
	    field: 'columnSchema',
	    title: '字段分类'
	  }],
	  responseHandler:function(res){
		  return {rows:res.results,total:res.totalCount}
	  }
	});
	//编辑数据
	function edit(){
		var row = $("#table").bootstrapTable('getSelections');
		location.href='page/field/toEdit?id='+row[0].id
	}
	
</script>
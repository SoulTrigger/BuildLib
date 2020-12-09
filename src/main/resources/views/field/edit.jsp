<%@page import="com.wl.model.dto.MetadataElement"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>所有表单元素 <small>包括自定义样式的复选和单选按钮</small></h5>
                    </div>
                    <div class="ibox-content">
                        <form method="get" id="form" class="form-horizontal">
                        	<div class="form-group">
                                <label class="col-sm-2 control-label">字段呈现类型</label>
                                <div class="col-sm-10">
                                    <select class="form-control" name="columnElement">
									<c:forEach items="<%=MetadataElement.values() %>" var="e" >
                                        <option value="${e}" selected="${data.columnElement!=null&&data.columnElement==e?'selected':''} ">${e.alias }</option>
                                    </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">字段分类</label>
                                <div class="col-sm-10">
                                    <div class="input-group">
                                        <input type="text" class="form-control" name="columnSchema" id="columnSchema" required>
                                        <div class="input-group-btn">
                                            <button data-toggle="dropdown" class="btn btn-white dropdown-toggle" type="button" aria-expanded="false">选择 <span class="caret"></span>
                                            </button>
                                            <ul class="dropdown-menu pull-right"></ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">字段中文名</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="label" required value="${data.label }">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">字段英文名</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="columnName" required value="${data.columnName }">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">字段英文名简写</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="shortColumnName" required value=${data.shortColumnName }>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">字段默认值</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="defaultValue" value="${data.defaultValue }">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">是否启用</label>
                                <div class="col-sm-10">
                                	 <label class="radio-inline i-checks">
                                        <input type="radio" checked="${data.isShow?'checked':'' }" value="true" name="isShow">是</label>
                                    <label class="radio-inline i-checks">
                                        <input type="radio" checked="${data.isShow?'':'checked' }"value="false" name="isShow">否</label>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-2">
                                    <button class="btn btn-primary" type="submit">保存内容</button>
                                    <button class="btn btn-white" type="button" onclick="javascript:location.href='page/field/toList'">返回</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
<script src="assets/js/plugins/suggest/bootstrap-suggest.min.js"></script>
<script>
$(function(){
	var testdataBsSuggest = $("#columnSchema").bsSuggest({
	    indexId: 0, //data.value 的第几个数据，作为input输入框的内容
	    indexKey: 1, //data.value 的第几个数据，作为input输入框的内容
	    data: {
	        'value': [
	            {
	                'id': '0',
	                'word': 'lzw',
	                'description': 'http://lzw.me'	
	            },
	            {
	                'id': '1',
	                'word': 'lzwme',
	                'description': 'http://w.lzw.me'
	            },
	            {
	                'id': '2',
	                'word': 'meizu',
	                'description': 'http://www.meizu.com'
	            },
	            {
	                'id': '3',
	                'word': 'flyme',
	                'description': 'http://flyme.meizu.com'
	            }
			],
	        'defaults': 'http://lzw.me'
	    }
	});	
	$("#form").validate({
		rules:{
			columnName:{
				mustWord:true
			},
			shortColumnName:{
				mustUpperCaseWord:true
			},
			label:{
				mustChinese:true
			}
		},
		submitHandler: function(form) 
	   {
			$('#form').ajaxSubmit({
				url:'field/save',
				success:function(data){
					if(data.success){
						location.href='page/field/toList';
					}else{
						swal({
		                    title: "操作失败",
		                    text: '错误详情：'+data.msg
		                });
					}
				}
			});     
	   }  
	});
})
</script>
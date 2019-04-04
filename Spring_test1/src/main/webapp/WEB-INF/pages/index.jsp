<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link rel="stylesheet" href="bootstrap-4.3.1/css/bootstrap.min.css">
<script src="jQurey/jquery-3.3.1.min.js"></script>
<script src="bootstrap-4.3.1/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="jquery-easyui-1.6.10/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="jquery-easyui-1.6.10/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="jquery-easyui-1.6.10/demo/demo.css">
<script type="text/javascript" src="jquery-easyui-1.6.10/jquery.min.js"></script>
<script type="text/javascript"
	src="jquery-easyui-1.6.10/jquery.easyui.min.js"></script>
<body>
	<h2 align="center" style="color:#F00;font-size:32px;font-family:'微软雅黑'">相册</h2>
	<div style="margin: 20px 0;"></div>
	<div class="easyui-layout" style="width: 100%; height: 768px;">
		<div id="p" data-options="region:'west'" title="导航"
			style="width: 25%; padding: 10px">
			<div style="margin: 20px 0;"></div>
			<div class="easyui-panel" style="padding: 5px">
				<ul id="tt" class="easyui-tree"
					data-options="
				url: 'jquery-easyui-1.6.10/demo/tree/tree_data1.json',
				method: 'get',
				animate: true,
				onContextMenu: function(e,node){
					e.preventDefault();
					$(this).tree('select',node.target);
					$('#mm').menu('show',{
						left: e.pageX,
						top: e.pageY
					});
				}
			"></ul>
			</div>
		</div>
		<div id="conter" data-options="region:'center'" title="内容">
			<div id="context"></div>
			<div id="ccontext"></div>
			<div id="cccontext"></div>
		</div>
	</div>
	<script type="text/javascript">
		$('#tt').tree({
			onClick : function(node) {
				var cont="";
				var data = node.text;
				var id = node.id;
				var url = "http://localhost:8091/doConterTest01.do";
				var params = {
					"data" : data,
					"id":id
				};
				console.log(params);
				$.post(url, params, function(result) {
					cont=result.message;
					console.log(cont);
					$("#context").html(cont);			
				}, "json");
			}
		});
	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>zTree</title>

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

<!-- <script src="jQurey/jquery-3.3.1.min.js"></script> -->
<script type="text/javascript" src="zTree_v3/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="zTree_v3/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="zTree_v3/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript" src="zTree_v3/js/jquery.ztree.exedit.js"></script>
<link rel="stylesheet" href="zTree_v3/css/zTreeStyle/zTreeStyle.css"
	type="text/css">
</head>
<body>
	<div class="easyui-layout" style="width: 100%; height: 768px;">
		<div id="p" data-options="region:'west'" title="导航"
			style="width: 25%; padding: 10px">
			<div class="zTreeDemoBackground left">
				<ul id="treeDemo" class="ztree"
					style="width: 230px; overflow: auto;"></ul>

			</div>
		</div>
		<div id="conter" data-options="region:'center'" title="内容">
			<div id="context" style="border: 3px solid #E0E0E0;text-align:center;"></div>
		</div>
	</div>
</body>
<script type="text/javascript">
	var setting = {
		check : {
			enable : false
		},
		view : {
			selectedMulti : false,
		// addHoverDom: addHoverDom,
		// removeHoverDom: removeHoverDom,
		},
		data : {
			key : {
				name : "name"
			},
			simpleData : {//简单数据模式
				enable : true,
				idKey : "id",
				pIdKey : "pId"
			}
		},
		callback : { //回调函数
			/**
			 * event:鼠标事件
			 * treeId：树的容器id
			 * treeNode：当前点击的节点
			 */
			onNodeCreated : zTreeOnNodeCreated,
			onClick : zTreeOnClick
		}
	};
	$(document).ready(function() {
		var url = "http://localhost:8091/doZnodes.do";
		$.get(url, function(result) {
			var zNodes = result.data;
			console.log(zNodes);
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		}, "json");
	});

	//节点点击事件
	function zTreeOnClick(event, treeId, treeNode) {
		var cont = 'id:' + treeNode.id + ', name:' + treeNode.name + ',pId:'
				+ treeNode.pId;

		$("#context").html(cont);
	}

	// 给生成的节点添加class属性
	function zTreeOnNodeCreated(event, treeId, treeNode) {
		var str = treeNode.tId + "_span";
		$("#" + str).addClass(treeNode.type);
	}
</script>

</html>
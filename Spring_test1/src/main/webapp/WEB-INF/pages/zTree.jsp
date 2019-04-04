<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>zTree</title>
<!-- <script src="jQurey/jquery-3.3.1.min.js"></script> -->
<script type="text/javascript" src="zTree_v3/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="zTree_v3/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="zTree_v3/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript" src="zTree_v3/js/jquery.ztree.exedit.js"></script>
<link rel="stylesheet" href="zTree_v3/css/zTreeStyle/zTreeStyle.css"
	type="text/css">
</head>
<body>
	<div class="zTreeDemoBackground left">
		<ul id="treeDemo" class="ztree" style="width: 230px; overflow: auto;"></ul>

	</div>
</body>
<script type="text/javascript">
	var setting = {
		isSimpleData : true,
		treeNodeKey : "mid",
		treeNodeParentKey : "pid",
		showLine : true,
		root : {
			isRoot : true,
			nodes : []
		},
		callback : { //回调函数
			/**
			 * event:鼠标事件
			 * treeId：树的容器id
			 * treeNode：当前点击的节点
			 */
			onClick: zTreeOnClick
		}
	};
	$(document).ready(function() {
		var url = "http://localhost:8091/doZnodes.do";
		$.get(url, function(result) {
			var zNodes = result.message;
			zNodes = JSON.parse(zNodes);
			console.log(zNodes);
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		}, "json");
	});

	function zTreeOnClick(event, treeId, treeNode){
		console.log(treeNode.tId + ", " + treeNode.name);
	}
</script>

</html>
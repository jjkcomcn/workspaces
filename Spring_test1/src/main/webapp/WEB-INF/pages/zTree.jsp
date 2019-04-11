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



<style type="text/css">
#d1 {
	margin: auto;
	width: 700px;
	border: 0px solid #F00;
}

a {
	text-decoration: none
}

.hide {
	display: none;
}

.modal {
	position: fixed;
	left: 50%;
	top: 50%;
	width: 500px;
	height: 249px;
	margin-left: -400px;
	margin-top: -300px;
	z-index: 10;
	background-color: #F5FFFA;
	border: 3px solid #E0E0E0;
}

.shade {
	position: fixed;
	left: 0;
	right: 0;
	top: 0;
	bottom: 0;
	opacity: 0.6;
	background-color: black;
	z-index: 9;
}

p {
	text-align: center;
}
</style>
</head>
<body>
	<div id="treeTop" style="text-align: right; font-size: 24px;">
		<a href="http://localhost:8091/findTreeList.do">后台管理</a>
	</div>
	<div class="easyui-layout" style="width: 100%; height: 768px;">
		<div id="p" data-options="region:'west'" title="导航"
			style="width: 18%; padding: 10px">
			<div class="zTreeDemoBackground left">
				<ul id="treeDemo" class="ztree"
					style="width: 230px; overflow: auto;"></ul>

			</div>
		</div>
		<div id="conter" data-options="region:'center'" title="内容">
			<div id="context"
				style="border: 3px solid #E0E0E0; text-align: center;"></div>
		</div>
	</div>
	<div class="modal hide">
		<form id="uploadForm" class="form" method="post"
			action="http://localhost:8091/doUploadFile.do"
			enctype="multipart/form-data">
			</p>
			</p>
			<p>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;id：<input id="id" name="id"
					type="text" readonly="true">
			</p>
			<p>
				&nbsp;&nbsp;&nbsp;&nbsp;pId：<input id="pId" name="pId" type="text"
					readonly="true">
			</p>
			<p>
				name：<input id="name" name="name" type="text" readonly="true">
			</p>
			<p>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
					type="file" name="file" value="file">
			</p>
			<div style="width: 25%; margin: 0 auto;">
				<input type="button" value="取消"> <input type="submit"
					value="确定" style="float: right">
			</div>
		</form>
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
	//获取节点数据
	$(document).ready(function() {
		var url = "http://localhost:8091/doZnodes.do";
		$.get(url, function(result) {
			var zNodes = result.data;
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		}, "json");
	});

	//节点点击事件
	function zTreeOnClick(event, treeId, treeNode) {
		var id = treeNode.id;
		var name = treeNode.name;
		var pId = treeNode.pId;
		var cont = "";
		//cont = cont + 'id:' + treeNode.id + ', name:' + treeNode.name + ',pId:'+ treeNode.pId;
		var ch = treeNode.children;
		var data = {};
		if (ch != undefined) {
			data["pId"] = treeNode.id;
		} else {
			cont = "<div style='text-align: left; font-size: 18px; margin:10px auto;width:90%;'><a href='#' onclick = 'addPic("
					+ id
					+ ","
					+ pId
					+ ","
					+ '"'
					+ name
					+ '"'
					+ " )'>添加图片</a></div>";
			data["id"] = treeNode.id;
		}
		console.log(data);
		var url = "http://localhost:8091/doGetStr.do";
		$.post(url, data, function(result) {
			var htl = result.message;
			cont = cont + htl;
			$("#context").html(cont);
		}, "json");
	}

	// 给生成的节点添加class属性
	function zTreeOnNodeCreated(event, treeId, treeNode) {
		var str = treeNode.tId + "_span";
		$("#" + str).addClass(treeNode.type);
	}

	//取消按钮
	$('input[value="取消"]').click(function() {
		// 执行隐藏
		$(".hide").hide().removeClass("show");
	});

	//添加图片
	function addPic(id, pId, name) {
		//更改显示状态
		//$('.hide').toggle();
		// 执行隐藏
		//$(".abc").hide().removeClass("show");
		// 显示
		$(".hide").show().addClass("show");
		//根据target寻找modal中的对应框，并写入内容
		$('#id').val(id);
		$('#name').val(name);
		$('#pId').val(pId);
	}
</script>

</html>
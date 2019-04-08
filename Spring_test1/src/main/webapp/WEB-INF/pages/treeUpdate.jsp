<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 引入Jsp标准标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新树</title>
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
	border: 1px solid #F00;
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
	width: 700px;
	height: 600px;
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
	<div id="d1">
		<table width="100%" algin="center" border="1">
			<tr align="center">
				<td colspan="5"><h2>树信息</h2></td>
			</tr>
			<tr align="center">
				<td>ID</td>
				<td>name</td>
				<td>open</td>
				<td>pId</td>
				<td>操作</td>
			</tr>
			<!-- 遍历返回结果 -->
			<c:forEach items="${ findTreeTest }" var="u">
				<tr align="center">
					<td target="id">${u.id}</td>
					<td target="name">${u.name}</td>
					<td target="open">${u.open }</td>
					<td target="pId">${u.pId }</td>
					<td target="update" onclick="update(this)">更新</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="modal hide">
		<p>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;id：<input name="id" type="text"
				readonly="true">
		</p>
		<p>
			name：<input name="name" type="text">
		</p>
		<p>
			open：<input name="open" type="text">
		</p>
		<p>
			&nbsp;&nbsp;pId：<input name="pId" type="text">
		</p>
		<p>
			<input type="button" value="取消"> <input type="button"
				value="提交">
		</p>
	</div>
</body>
<script type="text/javascript">
	function update(datas) {
		var td = $(datas).parent().children("td");
		var td1 = td.eq(0).text();
		var td2 = td.eq(1).text();
		var td3 = td.eq(2).text();
		var td4 = td.eq(3).text();
		console.log("id:" + td1 + ",anme:" + td2 + ",open:" + td3 + ",pId:"
				+ td4);
		$('.hide').removeClass('hide');
		td.each(function() {
			//获取target值
			var tar_val = $(this).attr('target');
			var con = $(this).text();
			$('.modal input[name="' + tar_val + '"]').val(con);
		});
	}
	//取消按钮
	$('input[value="取消"]').click(function() {
		$('input[type="text"]').val('');
		$('.modal,.shade').addClass('hide');
	});
	//提交按钮
	$('input[value="提交"]').click(function() {
		var p = $(this).parent().parent().children("p").children("input");
		var params = {
			"id" : p[0].value,
			"name" : "你好",
			"open" : p[2].value,
			"pId" : p[3].value
		};
		console.log(params);
		var url = "http://localhost:8091/updatezTree.do";

		$.ajax({
			type : 'post',
			url : url,
			contentType : 'application/json;charset=utf-8',
			dataType : 'json',
			//数据格式是json串
			data : params,
			success : function(data) {//测试能不能返回数据
				console.log(data);
			}
		});
	});
</script>
</html>
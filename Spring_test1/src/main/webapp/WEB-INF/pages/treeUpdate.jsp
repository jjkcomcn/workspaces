<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<div id="treeTop" style="text-align: right; font-size: 28px;">
		<a href="http://localhost:8091/dozTree.do">返回</a>
	</div>
	<h1 style="text-align: center">树修改</h1>
	<div id="d1">
		<table id="table" width="100%" algin="center" border="1"
			style="text-align: center; margin-top: 30px;">
			<tr>
				<th>id</th>
				<th>name</th>
				<th>open</th>
				<th>pId</th>
				<th>操作</th>
			</tr>
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
	$(document)
			.ready(
					function() {
						var url = "http://localhost:8091/doZnodes.do";
						$
								.get(
										url,
										function(result) {
											var data = result.data;
											var ht = "";
											for (i = 0; i < data.length; i++) {
												var value = data[i];
												ht = ht
														+ "<tr><td target='id'>"
														+ value.id + "</td>"
														+ "<td target='name'>"
														+ value.name + "</td>"
														+ "<td target='open'>"
														+ value.open + "</td>"
														+ "<td target='pId'>"
														+ value.pId + "</td>";
												ht = ht
														+ "<td><a href = '#' onclick = 'update(this)'>修改</a></<td></tr>";
											}
											$("#table").append(ht);
										}, "json");
					});

	function update(datas) {
		var td = $(datas).parent().parent().children("td");
		$('.hide').removeClass('hide');
		td.each(function() {
			//获取target值
			var tar_val = $(this).attr('target');
			console.log(tar_val);
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
			"name" : p[1].value,
			"open" : p[2].value,
			"pId" : p[3].value
		};
		console.log(params);
		var url = "http://localhost:8091/updatezTree.do";

		$.post(url, params, function(result) {
			cont = result.message;
			if (cont == 'update ok') {
				$('.modal,.shade').addClass('hide');
				window.location.reload();
			} else {
				alert(cont);
			}
		});
	});
</script>
</html>
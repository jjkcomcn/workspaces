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
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.6.10/demo/demo.css">
<script type="text/javascript" src="jquery-easyui-1.6.10/jquery.min.js"></script>
<script type="text/javascript"
	src="jquery-easyui-1.6.10/jquery.easyui.min.js"></script>
</head>
<body>
	<h2>Fluid Layout</h2>
	<div style="margin: 20px 0;"></div>
	<div class="easyui-layout" style="width: 100%; height: 350px;">
		<div id="p" data-options="region:'west'" title="左树"
			style="width: 25%; padding: 10px">
			<p>width: 25%</p>
		</div>
		<div data-options="region:'center'" title="右表"></div>
	</div>
</body>
</html>
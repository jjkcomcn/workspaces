<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>model</title>
<!-- <script src="jQurey/jquery-3.3.1.min.js"></script> -->
<script type="text/javascript" src="zTree_v3/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="zTree_v3/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="zTree_v3/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript" src="zTree_v3/js/jquery.ztree.exedit.js"></script>
<link rel="stylesheet" href="zTree_v3/css/zTreeStyle/zTreeStyle.css"
	type="text/css">

<style>
.hide {
	display: none;
}

.modal {
	position: fixed;
	left: 50%;
	top: 50%;
	width: 500px;
	height: 400px;
	margin-left: -200px;
	margin-top: -250px;
	z-index: 10;
	background-color: white;
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
	<input type="button" value="添加">
	<div class="container">
        <table border="1">
            <tr>
                <td target="hostname">1.1.1.1</td>
                <td target="port">80</td>
                <td target="ip">192.168.1.101</td>
                <td><input type="button" value="编辑"> | <input type="button" value="删除"></td>
            </tr>
            <tr>
                <td target="hostname">1.1.1.2</td>
                <td target="port">81</td>
                <td target="ip">192.168.1.102</td>
                <td><input type="button" value="编辑"> | <input type="button" value="删除"></td>
            </tr>
            <tr>
                <td target="hostname">1.1.1.3</td>
                <td target="port">82</td>
                <td target="ip">192.168.1.103</td>
                <td><input type="button" value="编辑"> | <input type="button" value="删除"></td>
            </tr>
            <tr>
                <td target="hostname">1.1.1.4</td>
                <td target="port">83</td>
                <td target="ip">192.168.1.104</td>
                <td><input type="button" value="编辑"> | <input type="button" value="删除"></td>
            </tr>
        </table>
    </div>
    <div class="modal hide">
        <p>主机：<input name="hostname" type="text"></p>
        <p>端口：<input name="port" type="text"></p>
        <p>地址：<input name="ip" type="text"></p>
        <p><input type="button" value="取消"></p>
    </div>
    <div class="shade hide"></div>
	<script>
        //添加按钮
        $('input[value="添加"]').click(function(){
            $('.hide').removeClass('hide');
        });
        //取消按钮
        $('input[value="取消"]').click(function(){
            $('input[type="text"]').val('');
            $('.modal,.shade').addClass('hide');
        });
        //编辑按钮
        $('input[value="编辑"]').click(function(){
            $('.hide').removeClass('hide');
            //获取点击前面标签
            var tds = $(this).parent().prevAll();
            tds.each(function(){
                //获取target值
                var tar_val = $(this).attr('target');
                //获取当前td的内容
                var con = $(this).text();
                //根据target寻找modal中的对应框，并写入内容
                $('.modal input[name="'+tar_val+'"]').val(con);
            });
        });
        //删除按钮
        $('input[value="删除"]').click(function(){
            $(this).parent().parent().remove();
        });
    </script>
</body>
</html>
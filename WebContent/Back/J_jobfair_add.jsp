<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<script type="text/javascript" src="lib/PIE_IE678.js"></script>
<![endif]-->
<link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="lib/icheck/icheck.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>添加招聘会</title>
</head>
<body>
<div class="pd-20">
	<form action="/Team/Back/jobfair_add.do" method="post" class="form form-horizontal" id="form-admin-add">
	<div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>标题：</label>
			<div class="formControls col-5">
				<input type="text" class="input-text" value="" placeholder="" id="admin-name" name="title" datatype="*2-16" nullmsg="标题不能为空">
			</div>
			<div class="col-4"> </div>
		</div>
			<div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>地址：</label>
			<div class="formControls col-5">
				<input type="text" placeholder="" autocomplete="off" value="" class="input-text" name="address" datatype="*6-20" nullmsg="地址不能为空">
			</div>
			<div class="col-4"> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>公司数目：</label>
			<div class="formControls col-5">
				<input type="text" placeholder="" autocomplete="off" value="" class="input-text" name="firmnumber" datatype="n1-3" nullmsg="公司数目不能为空">
			</div>
			<div class="col-4"> </div>
		</div>
		
		
		
    <div class="row cl">
		<label class="form-label col-3"><span class="c-red">*</span>日期：</label>
		<div class="formControls col-5">
		<input type="date" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" id="datemin" name="addtime" class="input-text Wdate" style="width:120px;">
	</div>
	</div>
		
	
		<div class="row cl">
			<div class="col-9 col-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</div>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript" src="lib/Validform/5.3.2/Validform.min.js"></script> 
<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script> 
<script type="text/javascript" src="js/H-ui.js"></script> 
<script type="text/javascript" src="js/H-ui.admin.js"></script> 
<script type="text/javascript">
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#form-admin-add").Validform({
		tiptype:2
		
	});
});
</script>
</body>
</html>
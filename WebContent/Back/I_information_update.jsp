<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<% 
String path=request.getContextPath();
%>
<base href="<%=path%>/Back/">
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
<title>修改管理员</title>
</head>
<body>
<div class="pd-20">
	<form action="/Team/Back/information_update.do" method="post" class="form form-horizontal" id="form-article-add" enctype="multipart/form-data">
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">ID</span>：</label>
			<div class="formControls col-2">
				<input type="text" class="input-text" readonly="readonly" value="${infor_update.ID}" placeholder="" id="" name="ID">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-2">标题</label>
			<div class="formControls col-2">
				<input type="text" class="input-text" value="${infor_update.getTitle()}" placeholder="" id="" name="title">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-2">来源：</label>
			<div class="formControls col-2">
				<input type="text" class="input-text" value="${infor_update.getSourse()}" placeholder="" id="" name="sourse">
			</div>
		</div>
	<div class="row cl">
			<label class="form-label col-2">作者：</label>
			<div class="formControls col-2">
				<input type="text" class="input-text" value="${infor_update.getAuthor()}" placeholder="" id="" name="author">
				
			</div>
		</div>
		
		<input type="hidden" id="type_hidden" value="${infor_update.getType()}">
			<div class="row cl">
	<label class="form-label col-2"><span class="c-red">*</span>分类栏目：</label>
		<div class="formControls col-2"> 
		<span class="select-box">
				<select name="type" class="select" id="type">
					<option value="求职技巧">求职技巧</option>
					<option value="面试宝典">面试宝典</option>
					<option value="简历指南">简历指南</option>
					<option value="就业指南">就业指南</option>
					<option value="企业指南">企业指南</option>
					<option value="学生指南">学生指南</option>
					<option value="创业政策">创业政策</option>					
					<option value="创业动态">创业动态</option>
				</select>
				</span> 
				</div>
				</div>
		<div class="row cl">
			<label class="form-label col-2">内容：</label>
			<div class="formControls col-7">
				<textarea name="content" cols="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" datatype="*10-5000" dragonfly="true" nullmsg="内容不能为空！" onKeyUp="textarealength(this,200)">${infor_update.getContent()}</textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/5000</p>
			</div>
		</div>
	
		<div class="row cl">
			<label class="form-label col-2">原图：</label>
			<div class="formControls col-2">
				<img width="200px" height="200px" src="${infor_update.getPicture()}">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-2">缩略图：</label>
			<div class="formControls col-10">
				<div class="uploader-thum-container">
					<div id="fileList" class="uploader-list" ></div>
					<input type="file" class="input-text" value="" placeholder="" id="" name="myfile" datatype="*" nullmsg="图片不能为空">
				</div>
			</div>
		</div>
	
		<div class="row cl">
			<div class="col-10 col-offset-2">
				<button onClick="" class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i>提交</button>
				<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
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

/*type下拉框选中*/
 var temp=$("#type_hidden").val()
$("select option").each(function(){
	if($(this).val()==temp){
		$(this).attr("selected","selected");
	}
}
);

</script>
</body>
</html>
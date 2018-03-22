<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
     //项目的发布路径，例如：/abcd
     String path=request.getContextPath();
     /*
            全路径，形式如下： http://127.0.0.1:8001/abcd/
     request.getScheme()       ——>http 获取协议
     request.getServerName()   ——>127.0.0.1 获取服务器名
     request.getServerPort()   ——>8001 获取端口号
     path                      ——> /abcd 获取访问的路径
     */
     String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=path%>/Back/">
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="lib/icheck/icheck.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />

<title>发布宣讲会</title>
</head>
<body> 	
<div class="pd-20">
	<form action="/Team/firm_preach_add.do" method="post" class="form form-horizontal" id="form-admin-add">
		<div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>标题：</label>
			<div class="formControls col-5">
				<input type="text"  style="width:250px;" class="input-text" placeholder="请输入标题" id="title" name="title" datatype="*2-16" nullmsg="标题不能为空！" >
			</div>
			<div class="col-4"> </div>
		</div>
		
		<div class="row cl">
           <label class="form-label col-3"><span class="c-red">*</span>场地：</label>
           <div class="formControls col-5">
               <input type="text" style="width:250px;" class="input-text" placeholder="请输入场地" name="address" id=""address"" datatype="*" nullmsg="场地不能为空！">
           </div>
          <div class="col-4"> </div>
        </div>
        
        		
		<div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>日期：</label>
			<div class="formControls col-5">
				<input type="text" style="width:250px;" id="date" name="date" placeholder="请输入宣讲会日期"  class="input-text" datatype="*" nullmsg="日期不能为空">
			</div>
			<div class="col-4"> </div>
		</div>
        
        <div class="row cl">
           <label class="form-label col-3"><span class="c-red">*</span>内容：</label>
           <div class="formControls col-5">
              <textarea name="content" cols="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" datatype="*10-200" dragonfly="true" nullmsg="内容不能为空！" onKeyUp="textarealength(this,200)"></textarea>
            </div>
           <div class="col-4"> </div>
        </div>

            
		<div class="row cl">${msg}</div>
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
		tiptype:'2'	
	});
	
});
</script>
</body>
</html>
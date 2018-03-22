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
<link href="lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />


<link href="tip/css/manhua_hoverTips.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="tip/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="tip/js/manhua_hoverTips.js"></script>
<title>安全设置</title>
</head>
<body>
<div class="pd-20">
	<form action="/Team/firm_changePWD.do" method="post" class="form form-horizontal" id="form-goods-add"  >
	   	
	   	<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>当前密码： </label>
			<div class="formControls col-3">
				<input type="password" class="input-text" autocomplete="off" placeholder="必须先验证旧密码" name="old-password" datatype="*6-20" id="new-password" nullmsg="密码不能为空" ajaxurl="../firm_checkPWD.do">
			</div>
		</div>	
		
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>新密码：</label>
			<div class="formControls col-3">
				<input type="password" class="input-text" autocomplete="off" placeholder="不修改请留空" name="PassWord" datatype="*6-20" id="new-password" nullmsg="密码不能为空">
			</div>
		</div>	
		
		<div class="row cl">		
			<label class="form-label col-2"><span class="c-red">*</span>确认密码：</label>
			<div class="formControls col-3">
				<input type="password" autocomplete="off" class="input-text Validform_error" datatype="*"   placeholder="不修改请留空" name="new-password2" id="new-password2" recheck="PassWord"  nullmsg="请再输入一次新密码！" errormsg="您两次输入的密码不一致！"  >
			</div>
		</div>
              
				    
		<div class="row cl">${msg}
		<input type="hidden" id="adress_hidden" name="adress_hidden" value="${firm.adress}"> <%--隐藏域获取地址基本信息 --%>
		</div>
	    
		<div class="row cl">
			<div class="col-10 col-offset-2">
					<input  class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;保存&nbsp;&nbsp;">&nbsp;&nbsp;&nbsp;		    				    			    
			        <button  class="btn btn-default radius" type="reset">&nbsp;&nbsp;重置&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</div>
 
 
<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script> 
<script type="text/javascript" src="/Team/Back/lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="lib/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript" src="lib/Validform/5.3.2/Validform.min.js"></script> 
<script type="text/javascript" src="lib/webuploader/0.1.5/webuploader.min.js"></script> 
<script type="text/javascript" src="js/H-ui.js"></script> 
<script type="text/javascript" src="js/H-ui.admin.js"></script> 
<script type="text/javascript">
/*--------------------------*/
$(function(){
	
	/*提示*/
    $("#tt").manhua_hoverTips();//使用默认参数，所以不用调用最简洁
	$("#tl").manhua_hoverTips({position : "l"});//改变了显示的位置参数
	$("#tr").manhua_hoverTips({position : "r"});//改变了显示的位置参数
	$("#tb").manhua_hoverTips({position : "b"});//改变了显示的位置参数
	/*提交表单*/
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#form-goods-add").Validform({
		tiptype:'3'	
	});

});
</script>
</body>
</html>
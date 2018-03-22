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


<title>添加职位</title>
</head>
<body> 	
<div class="pd-20">
	<form action="/Team/firm_recruit_job_des.do" method="post" class="form form-horizontal" id="form-admin-add">
	    <div class="row cl">
           <label class="form-label col-3"><span class="c-red">*</span>职位：</label>
           <div class="formControls col-5">
               <input type="text" style="width:250px;" class="input-text" placeholder="请输入职位信息" name="Job"  datatype="*" nullmsg="职位不能为空！" value="${recruit.job}" readonly="readonly">
           </div>
          <div class="col-4"> </div>
        </div>		       
        <div class="row cl">
           <label class="form-label col-3"><span class="c-red">*</span>职位描述：</label>
           <div class="formControls col-5">
              <textarea name="Job_Des" cols="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" datatype="*10-200" dragonfly="true" nullmsg="企业简介不能为空！" onKeyUp="textarealength(this,200)" readonly="readonly">${recruit.job_Des}</textarea>
			  <p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p>    </div>
           <div class="col-4"> </div>
        </div>                  
		<div class="row cl">${msg}</div>	
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
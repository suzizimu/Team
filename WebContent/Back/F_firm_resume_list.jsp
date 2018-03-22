<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />

<link href="lib/lightbox2/2.8.1/css/lightbox.css" rel="stylesheet" type="text/css" >
<title>收到的简历</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 简历管理 <span class="c-gray en">&gt;</span>收到的简历 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">
	<div class="cl pd-5 bg-1 bk-gray mt-20">
	   <span class="l"> 
	     <a href="javascript:;" onclick="resume_colMore()" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe6df;</i>收藏</a>
         <a href="javascript:;" onclick="resume_delMore()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
       </span> 
    </div>
	<div class="portfolio-content">
		<ul class="cl portfolio-area">
		  <c:forEach items="${list}" var="resume">
			<li class="item">
				<div class="portfoliobox">
					<input class="checkbox" name="check" type="checkbox" value="${resume.ID}">
					<div class="picbox"><a href="${resume.resume}" data-lightbox="gallery" data-title="求职意向：${resume.intention}"><img src="${resume.resume}"></a></div>
					<div class="textbox">学历：${resume.educationBgd}</div>
				</div>
			</li>
		  </c:forEach>	
		</ul>
	</div>
</div>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script> 
<script type="text/javascript" src="lib/lightbox2/2.8.1/js/lightbox-plus-jquery.min.js"></script> 
<script type="text/javascript" src="js/H-ui.js"></script> 
<script type="text/javascript" src="js/H-ui.admin.js"></script> 
<script type="text/javascript">

	/*-----批量删除收到的简历---------*/
	function resume_delMore(){
		var check=document.getElementsByName("check");
		var len=check.length;
		var idAll="";
		for(var i=0;i<len;i++){
			if(check[i].checked){
				idAll+=check[i].value+",";
			}
		}
		window.location.href="../firm_resume_deleteMore.do?idAll="+idAll;
	}
	/*----------批量收藏简历-----------*/
	function resume_colMore(){
		var check=document.getElementsByName("check");
		var len=check.length;
		var idAll="";
		for(var i=0;i<len;i++){
			if(check[i].checked){
				idAll+=check[i].value+",";
			}
		}	
		window.location.href="../firm_resume_CandD.do?idAll="+idAll;
	}	
	/*------------------------*/
	//$.Huihover(".portfolio-area li");


</script>
</body>
</html>
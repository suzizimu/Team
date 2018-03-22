<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>s
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
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,member-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />

<link href="lib/lightbox2/2.8.1/css/lightbox.css" rel="stylesheet" type="text/css" >

<link rel="stylesheet" type="text/css" href="work/css.css" />
<link rel="stylesheet" type="text/css" href="work/alpha.css" />
<script type="text/javascript" src="work/jquery.js"></script>
<script type="text/javascript" src="work/drag.js"></script>
<script type="text/javascript" src="work/city_arr.js"></script>
<script type="text/javascript" src="work/nationality_arr.js"></script>
<script type="text/javascript" src="work/funtype_arr.js"></script>
<script type="text/javascript" src="work/industry_arr.js"></script>
<script type="text/javascript" src="work/major_arr.js"></script>
<script type="text/javascript">
// 是否在数组内
function in_array(needle, haystack) {
	if(typeof needle == 'string' || typeof needle == 'number') {
		for(var i in haystack) {
			if(haystack[i] == needle) {
					return true;
			}
		}
	}
	return false;
}
</script>
<title>简历收藏</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>简历管理 <span class="c-gray en">&gt;</span> 简历收藏<a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>

 <div class="pd-20">
 
   <form action="/Team/firm_resume_collect_select.do" method="post">
	 <div class="text-c"> 
	   <span class="select-box inline">
       <select id="EducationBgd" name="EducationBgd" class="select" style="width:100px">
					<option value="">学历</option>
					<option value="其他">其他</option>
					<option value="大学专科" >大学专科</option>
					<option value="大学本科" >大学本科</option>
					<option value="硕士研究生" >硕士研究生</option>
					<option value="博士研究生" >博士研究生</option>												
		</select>
		</span>&nbsp;
		
		日期范围：
		<input type="text" name="date1" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" id="datemin" class="input-text Wdate" style="width:120px">
		-
		<input type="text" name="date2" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d'})" id="datemax" class="input-text Wdate" style="width:120px">  
	   <br><br>
	   <script type="text/javascript" src="work/major_func.js"></script>
	   <input   id="btn_MajorID_2" type="button" value="选择求职意向" onclick="majorSelect_2()" />
	   <input   id="MajorID_2" type="hidden" name="MajorID_2" value="" />
	   <input   id="MajorID_22" type="hidden" name="MajorID_22" value="" />
	   
	   <button type="submit" class="btn btn-success" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜记录</button>
	 </div>
    </form>
    
	<!-- alpha div -->
<div id="maskLayer" style="display:none">
<iframe id="maskLayer_iframe" frameBorder=0 scrolling=no style="filter:alpha(opacity=50)"></iframe>
<div id="alphadiv" style="filter:alpha(opacity=50);-moz-opacity:0.5;opacity:0.5"></div>
	<div id="drag">
		<h3 id="drag_h"></h3>
		<div id="drag_con"></div><!-- drag_con end -->
	</div>
</div>
<!-- maskLayer end -->
</div>
<!-- alpha div end -->
<div id="sublist" style="display:none"></div>

	<div class="cl pd-5 bg-1 bk-gray mt-20"> 
	    <span class="l">
	       <a href="javascript:;" onclick="resume_collect_delMore()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> 	      
	    </span>	   
	</div>
	
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
				<th width="50"><input type="checkbox" name="" value=""></th>
				<th width="150">姓名</th>
				<th width="100">简历</th>
				<th width="100">专业</th>				
				<th width="250">学历</th>				
				<th width="150">求职意向</th>
				<th width="150">发布时间</th>				
				<th width="250">操作</th>
			</tr>		
		</thead>
		<tbody>
			<c:forEach items="${list}" var="resume">
		     <tr class="text-c">
		       <td><input type="checkbox" value="${resume.ID}" name="check"></td>
		       <td>${resume.realName}</td>
		       <td><a href="${resume.resume}"  data-lightbox="gallery" data-title="${resume.intention}"><img src="${resume.resume}" style="width:150px;" ></a></td>
		       <td>${resume.major}</td>
		       <td>${resume.educationBgd}</td>
		       <td>${resume.intention}</td>	
		       <td>${resume.resumeTime}</td>			   
			   <td class="td-manage">
			      <a itle="删除" href="javascript:;" onclick="resume_del(${resume.ID})" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a>			  
			   </td>
			</tr>
		  </c:forEach>		
		</tbody>
	</table>
  </div>

<script type="text/javascript" src="lib/lightbox2/2.8.1/js/lightbox-plus-jquery.min.js"></script> 
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="/Team/Back/lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="js/H-ui.js"></script> 
<script type="text/javascript" src="js/H-ui.admin.js"></script> 
<script type="text/javascript">
$(function(){
	$('.table-sort').dataTable({
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0]}// 制定列不参与排序
		]
	});
	$('.table-sort tbody').on( 'click', 'tr', function () {
		if ( $(this).hasClass('selected') ) {
			$(this).removeClass('selected');
		}
		else {
			table.$('tr.selected').removeClass('selected');
			$(this).addClass('selected');
		}
	});
});

/*--------------------------------------------------------------------------------

/*简历收藏-删除*/
function resume_del(id){
	layer.confirm('确认要删除吗？',function(){
		$.post("/Team/firm_resume_collect_delete.do",{resume_id:id},function(data){
			if(data.info=="删除成功"){
				layer.msg('已删除!',{icon:1,time:1000});
				window.location.href="/Team/firm_resume_collect_list.do";					
			}else{
				layer.msg('删除失败！');
			}			
		},"json")
		
	});
}
/*-----批量删除收到的简历---------*/
function resume_collect_delMore(){
	var check=document.getElementsByName("check");
	var len=check.length;
	var idAll="";
	for(var i=0;i<len;i++){
		if(check[i].checked){
			idAll+=check[i].value+",";
		}
	}
	window.location.href="../firm_resume_collect_deleteMore.do?idAll="+idAll;
}
</script> 
</body>
</html>
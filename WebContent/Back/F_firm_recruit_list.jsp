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
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,member-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />

<title>职位列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 职位管理 <span class="c-gray en">&gt;</span> 职位列表<a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>

 <div class="pd-20">
 
	
	<div class="cl pd-5 bg-1 bk-gray mt-20"> 
	    <span class="l">
	       <a href="javascript:;" onclick="recurit_delMore()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> 
	       <a href="javascript:;" onclick="recruit_add('添加职位','F_firm_recruit_add.jsp','1000','800')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加职位</a>
	    </span>	   
	</div>
	
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
				<th width="50"><input type="checkbox" name="" value=""></th>
				<th width="150">职位</th>
				<th width="100">部门</th>
				<th width="100">薪资</th>				
				<th width="250">福利</th>				
				<th width="150">工作性质</th>
				<th width="150">发布时间</th>
				<th width="100">状态</th>
				<th width="250">操作</th>
			</tr>		
		</thead>
		<tbody>
			<c:forEach items="${list}" var="recruit">
		     <tr class="text-c">
		       <td><input type="checkbox" value="${recruit.ID}" name="check"></td>
		       <td>${recruit.job}</td>
		       <td>${recruit.department}</td>
		       <td>${recruit.pay}</td>
		       <td>${recruit.welfare}</td>
		       <td>${recruit.jobNature}</td>	
		       <td>${recruit.date}</td>
			   <td class="td-status"><span class="label label-success radius">已发布</span></td>
			   <td class="td-manage">
			      <a style="text-decoration:none" class="ml-5" onClick="job_des(${recruit.ID})" href="javascript:;" title="职位详情"><i class="Hui-iconfont">&#xe63f;</i></a> 			      
				  <a title="修改信息" href="javascript:;" onclick="recruit_update(${recruit.ID})" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>				  
				  <a itle="删除" href="javascript:;" onclick="recruit_del(${recruit.ID})" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a>
			   </td>
			</tr>
		  </c:forEach>		
		</tbody>
	</table>
	</div>
</div>
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
/*管理员-添加*/
function recruit_add(title,url,w,h){
	layer_show(title,url,w,h);
}

/*职位-修改信息*/
function recruit_update(id){
	layer.open({
		type:2
		,area:['1000px','800px']
	    ,title:'修改职位信息'
	    ,maxmin:true
	    ,content:'../firm_recruit_update.do?id='+id    
	});
}
/*职位-详情浏览*/
function job_des(id){
	//var id=$("#change").attr("admin_id");
	layer.open({
		type:2
		,area:['600px','350px']
	    ,title:'职位详情'
	    ,maxmin:true
	    ,content:'../firm_recruit_job_des.do?id='+id    
	});
	
}
/*职位-删除*/
function recruit_del(id){
	layer.confirm('确认要删除吗？',function(){
		$.post("/Team/firm_recruit_delete.do",{recruit_id:id},function(data){
			if(data.info=="删除成功"){
				layer.msg('已删除!',{icon:1,time:1000});
				window.location.href="/Team/firm_recruit_list.do";					
			}else{
				layer.msg('删除失败！');
			}			
		},"json")
		
	});
}
/*管理员-批量删除*/
function recurit_delMore(){
   var check = document.getElementsByName("check");
   var len=check.length;
   var idAll="";
   for(var i=0;i<len;i++){
       if(check[i].checked){
          idAll+=check[i].value+",";
    }
  }
 window.location.href="../firm_recruit_deleteMore.do?idAll="+idAll;
}
</script> 
</body>
</html>
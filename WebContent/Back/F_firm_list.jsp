<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=path%>/Back/">
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,member-scalable=no"/>
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<script type="text/javascript" src="lib/PIE_IE678.js"></script>
<![endif]-->
<link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<link href="lib/lightbox2/2.8.1/css/lightbox.css" rel="stylesheet" type="text/css" >
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>公司管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 用户中心 <span class="c-gray en">&gt;</span> 用户管理 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">
<form action="/Team/Back/admin_select.do" method="post">
	<div class="text-c"> 日期范围：
		<input type="text" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" id="datemin" name="addtime1" class="input-text Wdate" style="width:120px;">
		-
		<input type="text" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d'})" id="datemax" name="addtime2" class="input-text Wdate" style="width:120px;">
		<input type="text" class="input-text" style="width:250px" placeholder="输入管理员名称" id="" name="adminname">
		<button type="submit" class="btn btn-success radius" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜用户</button>
	</div>
	</form>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l">
	<a href="javascript:;" onclick="checkedall()" id="uncheck" name="checkall" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 全选</a>
	<a href="javascript:;" onclick="admin_bacthdel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
	</span> <span class="r">共有数据：<strong>88</strong> 条</span> </div>
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
			<th width="25"><input type="checkbox" name="" value=""></th>
			    <th width="40">ID</th>
				<th width="90">企业ID</th>
				<th width="90">证件照片</th>
				<th width="130">加入时间</th>
				<th width="100">状态</th>
				<th width="100">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listfirmlist}" var="firm">
		
			<tr class="text-c">
				<td><input type="checkbox" id="${firm.ID}" value="1" name="admin_ids"></td>
				<td>${firm.ID}</td>
				<td>${firm.getFirmName()}</td>
				<td><a href="${firm.picture}"  data-lightbox="gallery" ><img width="150px" height="150px" src="${firm.picture}"></a></td>
			    <td>${firm.getCardStart()}</td> 
				<td class="td-status"><span class="label label-success radius">${firm.getStatus()}</span></td>
				<td class="td-manage"><a style="text-decoration:none" onClick="firm_stop(this,${firm.getID()})" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>  
				<a title="删除" href="javascript:;" onclick="admin_del(this,${firm.getID()})" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
			</tr>
	</c:forEach>
			
		</tbody>
	</table>
	</div>
</div>
<script type="text/javascript" src="lib/lightbox2/2.8.1/js/lightbox-plus-jquery.min.js"></script> 
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="lib/My97DatePicker/WdatePicker.js"></script> 
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
/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*用户-查看*/
function member_show(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*用户-停用*/
function member_stop(obj,id){
    var ID=id;

	var temp;
		temp="已停用";
	var	messege=id+" "+temp;
	layer.confirm('确认要停用吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="Hui-iconfont">&#xe6e1;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已停用</span>');
		$(obj).remove();
		$.post("/Team/Back/firm_stop_start.do",{messege:messege},function(data){
		})
		layer.msg('已停用!',{icon: 5,time:1000});
	});
}

/*用户-启用*/
function member_start(obj,id){
	var ID=id;
	
	//alert(document.getElementById('control').name);
	var temp;
		temp="已启用";
    var	messege=id+" "+temp;
	layer.confirm('确认要启用吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_stop(this,${admin.getID()})" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>');
		
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
		$(obj).remove();
		$.post("/Team/Back/firm_stop_start.do",{messege:messege},function(data){
				})
		layer.msg('已启用!',{icon: 6,time:1000});
	});
}
/*用户-编辑*/
function admin_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*密码-修改*/
function change_password(title,url,id,w,h){
	layer_show(title,url,w,h);	
}
/*用户-删除*/
function admin_del(obj,id){
	var ID=id;
	
	layer.confirm('确认要删除吗？',function(index){
		$.post("/Team/Back/firmlist_delete.do",{ID:ID},function(data){
			
		$(obj).parents("tr").remove();
		
		layer.msg('已删除!',{icon:1,time:1000});
         layer.close(index);
			})
		
	});;
}
/*用户-批量删除*/
function admin_bacthdel(){
	var ID="";
	var temp=0;
	 var admin_ids=document.getElementsByName("admin_ids");
	 for(var i=0;i<admin_ids.length;i++){
         var id = admin_ids[i];
        if(id.checked==true){
        	ID=ID+" "+id.id;
        } else{
        	temp=temp+1;
        }
     }
	 if(temp==admin_ids.length){
		 layer.confirm('确认要删除吗？',function(index){
			 layer.msg('请先选择!',{icon:1,time:1000});
	            layer.close(index);	
	});
	 }else{
		 window.location.href="/Team/Back/firmlist_batchdelete.do?ID="+ID;
	 } 
}

/*用户-停用*/
function firm_stop(obj,id){
	var ID=id;
	
	layer.confirm('确认要停用吗？',function(index){
		$.post("/Team/Back/firm_stop.do",{ID:ID},function(data){
			
		$(obj).parents("tr").remove();
		
		layer.msg('已停用!',{icon:1,time:1000});
         layer.close(index);
			})
		
	});;
}
/*用户-全选*/
 function checkedall(){
	if(document.getElementsByName("checkall").id=="uncheck"){
		  var admin_ids=document.getElementsByName("admin_ids");
          for(var i=0;i<admin_ids.length;i++){
              var id = admin_ids[i];
              id.checked=true;
          }
          document.getElementsByName("checkall").id="checked";
	}
	else{
			  var admin_ids=document.getElementsByName("admin_ids");
	          for(var i=0;i<admin_ids.length;i++){
	              var id = admin_ids[i];
	              id.checked=false;
	          }
	          document.getElementsByName("checkall").id="uncheck";  
        }
}

</script> 
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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
<title>公司验证</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 用户中心 <span class="c-gray en">&gt;</span> 用户管理 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
			<th width="25"><input type="checkbox" name="" value=""></th>
				<th width="40">ID</th>
				<th width="90">证件照片</th>
				<th width="90">公司名称</th>
				<th width="90">公司类型</th>
				<th width="90">地区</th>
				<th width="130">地址</th>
				<th width="100">联系方式</th>
				<th width="100">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listfirmlist}" var="firm">
		
			<tr class="text-c">
				<td><input type="checkbox" id="${firm.ID}" value="1" name="admin_ids"></td>
				<td>${firm.ID}</td>
				<td><a href="${firm.picture}"  data-lightbox="gallery" ><img width="150px" height="150px" src="${firm.picture}"></a></td>
			    <td>${firm.getFirmName()}</td>
			    <td>${firm.getType()}</td> 
				<td>${firm.getArea()}</td> 
				<td >${firm.getAdress()}</td>
				<td >${firm.getTel()}</td>
				<td class="td-manage">
				<a style="text-decoration:none" onClick="student_uncheck(this,${firm.getID()})" href="javascript:;" title="不通过"><i class="Hui-iconfont">&#xe631;</i></a> 
				<a style="text-decoration:none" onClick="student_checked(this,${firm.getID()})" href="javascript:;" title="通过"><i class="Hui-iconfont">&#xe6e1;</i></a> 
				<a title="删除" href="javascript:;" onclick="admin_del(this,${firm.getID()})" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
			</tr>
	</c:forEach>
			</tr>
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
			layer.confirm('确认要删除吗？',function(index){
				
				 $.post("/Team/Back/firmlist_batchdelete.do",{ID:ID},function(data){
					 layer.msg('已删除!',{icon:1,time:1000});
			            layer.close(index);
					})				
			});
	 } 
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
 /*企业验证通过*/
 function student_checked(obj,id){
	var ID=id;
	var temp='Yes';
	var	messege=id+" "+temp;
	layer.confirm('确认要通过吗？',function(index){
		$.post("/Team/Back/firm_checkstatus.do",{messege:messege},function(data){
			
		$(obj).parents("tr").remove();
		
		layer.msg('操作成功!',{icon:1,time:1000});
         layer.close(index);
			})
		
	});;
}
 /*企业验证不通过*/
  function student_uncheck(obj,id){
	var ID=id;
	var temp='No';
	var	messege=id+" "+temp;
	layer.confirm('确认要不通过吗？',function(index){
		$.post("/Team/Back/firm_checkstatus.do",{messege:messege},function(data){
			
		$(obj).parents("tr").remove();
		
		layer.msg('操作成功!',{icon:1,time:1000});
         layer.close(index);
			})
		
	});;
}
</script> 
</body>
</html>
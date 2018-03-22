<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
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

<title>招聘会列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>项目扶持<span class="c-gray en">&gt;</span>项目列表<a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>

 <div class="pd-20">
 

	
	
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
				<th width="50"><input type="checkbox" name="" value=""></th>
				<th width="150">项目名</th>
				<th width="250">项目描述</th>					
				<th width="100">负责人</th>
				<th width="100">学校</th>				
				<th width="250">专业</th>										
				<th width="150">操作</th>
			</tr>		
		</thead>
		<tbody>
			<c:forEach items="${list}" var="item">
		     <tr class="text-c">
		       <td><input type="checkbox" value="${item.ID}" name="check"></td>
		       <td>${item.itemName}</td>
		       <td>${item.descripe}</td>
		       <td>${item.stuName}</td>
		       <td>${item.school}</td>		    	
		       <td>${item.intention}</td>			  
			   <td class="td-manage">
			      <a style="text-decoration:none" class="ml-5" href="${item.businessPlan}" download="">下载文档</a> 
			      <c:if test="${!(item.firmName eq FirmName) }">
			      <a style="text-decoration:none" class="ml-5" onClick="jobfair_attend(${item.ID})" href="javascript:;" >扶持该项目</a> 
			      </c:if>
			      <c:if test="${item.firmName eq FirmName }">
			      <a style="text-decoration:none" class="ml-5" >已扶持</a> 
			      </c:if>			      				  
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
/*招聘会-企业参加*/
function jobfair_attend(id){
    layer.confirm('确认要扶持该项目吗？',function(){
    	$.post("/Team/firm_item_help.do",{item_id:id},function(data){
    		if(data.info=="扶持成功"){
    			layer.msg('已扶持！',{icon:1,time:2000}); 
    			window.location.href="/Team/firm_item_list.do";
    		}else{
    			layer.msg('扶持失败！');
    		}
    	},"json")
    });
}

/*管理员-批量删除*/
function admin_delMore(){
   var check = document.getElementsByName("check");
   var len=check.length;
   var idAll="";
   for(var i=0;i<len;i++){
       if(check[i].checked){
          idAll+=check[i].value+",";
    }
  }
 window.location.href="../admin_deleteMore.do?idAll="+idAll;
}
</script> 
</body>
</html>
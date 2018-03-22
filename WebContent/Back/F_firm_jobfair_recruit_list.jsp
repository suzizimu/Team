<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt"%>
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
 
   <form action="/Lesson_Design_second/admin_select.do" method="post">
	 <div class="text-c"> 日期范围：
		<input type="text" name="date1" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" id="datemin" class="input-text Wdate" style="width:120px">
		-
		<input type="text" name="date2" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d'})" id="datemax" class="input-text Wdate" style="width:120px">
		<input type="text" name="admin_name" class="input-text" style="width:250px" placeholder="输入管理员名称" id="" >
		<button type="submit" class="btn btn-success" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜职位</button>
	 </div>
   </form>
	
	<div class="cl pd-5 bg-1 bk-gray mt-20"> 
	    <span class="l">	        
	       <a href="javascript:;" onclick="jobfair_recruit_add()" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i>发布职位</a>
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
/*批量发布招聘会职位*/
function jobfair_recruit_add(){
   var check = document.getElementsByName("check");
   var len=check.length;
   var idAll="";
   for(var i=0;i<len;i++){
       if(check[i].checked){
          idAll+=check[i].value+",";
    }
  }
 window.location.href="../firm_jobfair_recruit_add.do?FairID=${FairID}&idAll="+idAll;
}
</script> 
</body>
</html>
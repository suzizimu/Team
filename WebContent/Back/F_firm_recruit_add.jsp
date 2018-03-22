<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          <%@ page import="java.text.SimpleDateFormat" %>
     <%@ page import="java.util.*" %>
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
<title>添加职位</title>
</head>
<body> 	
<div class="pd-20">
	<form action="/Team/firm_recruit_add.do" method="post" class="form form-horizontal" id="form-admin-add">
		
		<div class="row cl">
           <label class="form-label col-3"><span class="c-red">*</span>职位：</label>
           <div class="formControls col-5">
	<script type="text/javascript" src="work/major_func.js"></script>
	<input id="btn_MajorID_2" type="button" value="请选择专业" onclick="majorSelect_2()" />
	<input id="MajorID_2" type="hidden" name="MajorID_2" value="" />单选
	<input id="MajorID_22" type="hidden" name="MajorID_22" value="" />
           </div>
          <div class="col-4"> </div>
        </div>
        
        <div class="row cl">
           <label class="form-label col-3"><span class="c-red">*</span>部门：</label>
           <div class="formControls col-5">
              <input type="text" style="width:250px;" class="input-text" value="" placeholder="请输入部门信息"  name="Department"  datatype="*" nullmsg="部门不能为空！">
            </div>
           <div class="col-4"> </div>
        </div>
		
		<div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>薪资：</label>
			<div class="formControls col-5"> <span class="select-box">
				<select id="Pay" name="Pay" class="select" nullmsg="薪资不能为空！" datatype="*"  >
					<option value="">请选择</option>
					<option value="面议">面议</option>
					<option value="1400-1999元" >1500-2999元</option>
					<option value="3000-4999元" >3000-4999元</option>
					<option value="5000-6999元" >5000-6999元</option>
					<option value="7000-9999元" >7000-9999元</option>	
					<option value="一万元以上" >一万元以上</option>												
				</select>
				</span>
		    </div>
		</div>
		<div class="row cl">
			<label class="form-label col-3"><span class="c-red"></span>福利：</label>
			<div class="formControls col-2 skin-minimal">
			  <div class="check-box">
					<input type="checkbox" id="checkbox-pinglun" name="Welfare" value="公积金">公积金
					<label for="checkbox-pinglun">&nbsp;</label>								
		      </div>
			  <div class="check-box">
					<input type="checkbox" id="checkbox-pinglun" name="Welfare" value="工伤保险">工伤保险
					<label for="checkbox-pinglun">&nbsp;</label>				
		      </div>			 
		      <div class="check-box">
					<input type="checkbox" id="checkbox-pinglun" name="Welfare" value="医疗保险">医疗保险
					<label for="checkbox-pinglun">&nbsp;</label>				
		      </div>			
		      <div class="check-box">
					<input type="checkbox" id="checkbox-pinglun" name="Welfare" value="养老保险">养老保险
					<label for="checkbox-pinglun">&nbsp;</label>				
		      </div>
		      <div class="check-box">
					<input type="checkbox" id="checkbox-pinglun" name="Welfare" value="生育保险">生育保险
					<label for="checkbox-pinglun">&nbsp;</label>				
		      </div>
		      <div class="check-box">
					<input type="checkbox" id="checkbox-pinglun" name="Welfare" value="失业保险">失业保险
					<label for="checkbox-pinglun">&nbsp;</label>				
		      </div>
		      <div class="check-box">
					<input type="checkbox" id="checkbox-pinglun" name="Welfare" value="其他福利">其他福利
					<label for="checkbox-pinglun">&nbsp;</label>				
		      </div>
		    </div>
			<div class="col-4"> </div>
		</div>
		
        <div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>学历：</label>
			<div class="formControls col-5"> <span class="select-box">
				<select id="EducationBgd" name="EducationBgd" class="select" nullmsg="学历不能为空！" datatype="*"  >
					<option value="">请选择</option>
					<option value="其他">其他</option>
					<option value="大学专科" >大学专科</option>
					<option value="大学本科" >大学本科</option>
					<option value="硕士研究生" >硕士研究生</option>
					<option value="博士研究生" >博士研究生</option>													
				</select>
				</span>
		    </div>
		</div>
        
        <div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>工作性质：</label>
			<div class="formControls col-5"> <span class="select-box">
				<select id="JobNature" name="JobNature" class="select" nullmsg="工作性质不能为空！" datatype="*"  >
					<option value="">请选择</option>
					<option value="不限">不限</option>
					<option value="小时工" >小时工</option>
					<option value="临时" >临时</option>
					<option value="实习" >实习</option>
					<option value="兼职" >兼职</option>
					<option value="全职" >全职</option>										
				</select>
				</span>
		    </div>
		</div>
        
        <div class="row cl">
           <label class="form-label col-3"><span class="c-red">*</span>职位描述：</label>
           <div class="formControls col-5">
              <textarea name="Job_Des" cols="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" datatype="*10-200" dragonfly="true" nullmsg="企业简介不能为空！" onKeyUp="textarealength(this,200)">${firm.des}</textarea>
			  <p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p>    </div>
           <div class="col-4"> </div>
        </div>
        
        <div class="row cl">
       <%	
        Date date =new Date();
	 	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 	//sdf.format(date);
		%>
			<label class="form-label col-3"><span class="c-red">*</span>发布日期：</label>
			<div class="formControls col-5">
				<input type="text" class="input-text" value="<%=sdf.format(date)%>"  id="Date"  name="Date" readonly="readonly" >
			</div>
			<div class="col-4"> </div>
		</div> 
           
		<div class="row cl">
		${msg}
		<input type="hidden" id="hidden_job" name="Job">
		</div>
		<div class="row cl">
			<div class="col-9 col-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;发布职位&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</div>
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
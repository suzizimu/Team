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

<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/Popt.js"></script>
<script src="js/cityJson.js"></script>
<script src="js/citySet.js"></script>

<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=EZPCgQ6zGu6hZSmXlRrUMTpr"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/map.jquery.min.js"></script>
<style type="text/css">
/*头像预览显示的代码*/
#preview,
.img,
img {
width: 150px;
height: 150px;
}
#preview {
border: 1px solid #000;
}

/*三级联动(所在区域)*/
* { -ms-word-wrap: break-word; word-wrap: break-word; }
html { -webkit-text-size-adjust: none; text-size-adjust: none; }
html, body {height:100%;width:100%; }
html, body, h1, h2, h3, h4, h5, h6, div, ul, ol, li, dl, dt, dd, iframe, textarea, input, button, p, strong, b, i, a, span, del, pre, table, tr, th, td, form, fieldset, .pr, .pc { margin: 0; padding: 0; word-wrap: break-word; font-family: verdana,Microsoft YaHei,Tahoma,sans-serif; *font-family: Microsoft YaHei,verdana,Tahoma,sans-serif; }
body, ul, ol, li, dl, dd, p, h1, h2, h3, h4, h5, h6, form, fieldset, .pr, .pc, em, del { font-style: normal; font-size: 100%; }
ul, ol, dl { list-style: none; }
._citys { width: 450px; display: inline-block; border: 2px solid #eee; padding: 5px; position: relative; }
._citys span { color: #56b4f8; height: 15px; width: 15px; line-height: 15px; text-align: center; border-radius: 3px; position: absolute; right: 10px; top: 10px; border: 1px solid #56b4f8; cursor: pointer; }
._citys0 { width: 100%; height: 34px; display: inline-block; border-bottom: 2px solid #56b4f8; padding: 0; margin: 0; }
._citys0 li { display: inline-block; line-height: 34px; font-size: 15px; color: #888; width: 80px; text-align: center; cursor: pointer; }
.citySel { background-color: #56b4f8; color: #fff !important; }
._citys1 { width: 100%; display: inline-block; padding: 10px 0; }
._citys1 a { width: 83px; height: 35px; display: inline-block; background-color: #f5f5f5; color: #666; margin-left: 6px; margin-top: 3px; line-height: 35px; text-align: center; cursor: pointer; font-size: 13px; overflow: hidden; }
._citys1 a:hover { color: #fff; background-color: #56b4f8; }
.AreaS { background-color: #56b4f8 !important; color: #fff !important; }

		/* reset */
		html,body,h1,h2,h3,h4,h5,h6,div,dl,dt,dd,ul,ol,li,p,blockquote,pre,hr,figure,table,caption,th,td,form,fieldset,legend,input,button,textarea,menu{margin:0;padding:0;} 
		
		body{padding:100px;font-size: 14px;}
		h1{font-size: 26px;}
		p{font-size: 14px; margin-top: 10px;}
		pre{background:#eee;border:1px solid #ddd;border-left:4px solid #f60;padding:15px;margin-top: 15px;}
		h2{font-size: 20px;margin-top: 20px;}
		.case{margin-top: 15px;width:400px;}

		.bMap{position: relative;}
		.bMap .map-warp{position: absolute;left:0;width:100%;height:400px;top:34px;display: none;}
		.bMap input{width:100%;height:30px;line-height: 30px;border:1px solid #d7d7d7;}
		.tangram-suggestion-main{z-index: 9999}
</style>
<title>基本信息</title>
</head>
<body>
<div class="pd-20">
	<form action="/Team/firm_information_update.do" method="post" class="form form-horizontal" id="form-goods-add" enctype="multipart/form-data">
	   
	    <div class="row cl">
	        
			<label class="form-label col-2"><span class="c-red">*</span>企业头像：</label>
			<div class="formControls col-10">
			    <div id="preview"></div>
				
				<input name="Logo" type="file" onchange="preview(this)" datatype="*" nullmsg="企业头像不能为空！" value="${firm.logo}"/>
			</div>
		</div>
	
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>企业名称：</label>
			<div class="formControls col-3">
				<input type="text" class="input-text" value="${firm.firmName}" placeholder="" id="" name="FirmName" datatype="*" nullmsg="商品名称不能为空！"  readonly="readonly">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>企业性质：</label>
			<div class="formControls col-2"> <span class="select-box">
				<select id="Type" name="Type" class="select" nullmsg="企业性质不能为空！" datatype="*"  >
					<option value="">请选择</option>
					<option value="非正规就业组织">非正规就业组织</option>
					<option value="个体经济组" >个体经济组织</option>
					<option value="社团" >社团</option>
					<option value="机关" >机关</option>
					<option value="事业" >事业</option>
					<option value="企业" >企业</option>
					<option value="其它">其它</option>						
				</select>
				</span>
		    </div>
		</div>
		
	    <div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>人员规模：</label>
			<div class="formControls col-2"> <span class="select-box">
				<select id="type" name="PeopleNumber" class="select" nullmsg="人员规模不能为空！" datatype="*"  >
					<option value="">请选择</option>
					<option value="10人以下" category="book">10人以下</option>
					<option value="10--99人" category="app">10--99人</option>
					<option value="10--499人" category="clothes">10--499人</option>
					<option value="500--999人" category="digital">500--999人</option>
					<option value="1000--2999人" category="digital">1000--2999人</option>
					<option value="3000人以上" category="digital">3000人以上</option>
					<option value="其它">其它</option>						
				</select>
				</span>
		    </div>
		</div>
		
		
		<div class="row cl">	
			<label class="form-label col-2"><span class="c-red">*</span>区域：</label>
			<div class="formControls col-3" >
				<input type="text" datatype="*"  name="Area" class="input-text" value="${firm.area}" placeholder="" id="city"  nullmsg="区域不能为空！">
			</div>
		</div>
	 
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>联系地址：</label>
			<div class="formControls col-3" >
			   <div class="bMap" id='case1'></div>
			</div>
	    </div>
		
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>联系人：</label>
			<div class="formControls col-2">
				<input type="text"  class="input-text" value="${firm.linkMan}" placeholder="" id="" name="LinkMan" nullmsg="联系人不能为空！"  datatype="*">
			</div>
		</div>
        
        <div class="row cl">
			<label class="form-label col-2">手机号：</label>
			<div class="formControls col-2">
				<input type="text"  class="input-text" value="${firm.tel}" placeholder="" id="" name="Tel"   datatype="*" >
			</div>
		</div>
        
        <div class="row cl">
			<label class="form-label col-2">企业邮箱：</label>
			<div class="formControls col-2">
				<input type="text"  class="input-text" value="${firm.email}" placeholder="" id="" name="Email"   datatype="e" readonly="readonly">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>企业简介：</label>
			<div class="formControls col-10">
				<textarea name="Des" cols="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" datatype="*10-200" dragonfly="true" nullmsg="企业简介不能为空！" onKeyUp="textarealength(this,200)">${firm.des}</textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p>
			</div>
		</div>
				    
		<div class="row cl">${msg}
		<input type="hidden" id="adress_hidden" name="adress_hidden" value="${firm.adress}"> <%--隐藏域获取地址基本信息 --%>
		<input type="hidden" id="logo_hidden" name="logo_hidden" value="${firm.logo}"> <%--隐藏域获取地址基本信息 --%>
		<input type="hidden" id="type_hidden" name="type_hidden" value="${firm.type}"> <%--隐藏域获取地址基本信息 --%>
		<input type="hidden" id="peopleNumber_hidden" name="peopleNumber_hidden" value="${firm.peopleNumber}"> <%--隐藏域获取地址基本信息 --%>
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
/*头像上传*/
function preview(file) {
	var prevDiv = document.getElementById('preview');
	if (file.files && file.files[0]) {
	var reader = new FileReader();
	reader.onload = function(evt) {
	prevDiv.innerHTML = '<img src="' + evt.target.result + '" />';
	}
	reader.readAsDataURL(file.files[0]);
	} else {
	prevDiv.innerHTML = '<div class="img" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + file.value + '\'"></div>';
	}
	}	
/*三级联动*/	
$("#city").click(function (e) {
	SelCity(this,e);
    console.log("inout",$(this).val(),new Date())
});	

	
/*--------------------------*/
$(function(){
	/*百度地图*/
	$("#case1").bMap();//百度地图
	
	var adress=$("#adress_hidden").val()//百度地图文本框赋初值
	$("#Map_input_map").val(adress);//百度地图文本框赋初值
	
	
	/*头像*/
	var img = document.createElement("img");//图片可从数据库调出初始化看见。
	var logo=$("#logo_hidden").val();
	var imgObj= $("<img>").attr("src", logo);  
	imgObj.appendTo("#preview");
	
	/*下拉框默认选中*/
	var temp=$("#type_hidden").val()
	
	 $("select option").each(function(){  
         if($(this).val()==temp){  
             $(this).attr("selected","selected");  
         }  
     }); 

	var temp2=$("#peopleNumber_hidden").val()
		 $("select option").each(function(){  
         if($(this).val()==temp2){  
             $(this).attr("selected","selected");  
         }  
     }); 
	/*提示*/

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
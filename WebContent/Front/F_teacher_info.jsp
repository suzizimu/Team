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
<!DOCTYPE html>
<html lang="en">
    <head>
    	<base href="<%=path%>/Front/">
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>创业导师</title>

        <!-- Bootstrap -->
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- custom css (blue green by default) -->
        <link href="css/style.css" rel="stylesheet" type="text/css" media="screen">
        <link href="font-awesome-4.3.0/css/font-awesome.min.css" rel="stylesheet">
        <!-- flex slider css -->
        <link href="css/flexslider.css" rel="stylesheet" type="text/css" media="screen">
        <!-- animated css  -->
        <link href="css/animate.css" rel="stylesheet" type="text/css" media="screen">
        <!--google fonts-->              
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
        <!--owl carousel css-->
        <link href="css/owl.carousel.css" rel="stylesheet" type="text/css" media="screen">
        <link href="css/owl.theme.css" rel="stylesheet" type="text/css" media="screen">
        <!--mega menu -->
        <link href="css/yamm.css" rel="stylesheet" type="text/css">
        <!--cube css-->
        <link href="cubeportfolio/css/cubeportfolio.min.css" rel="stylesheet" type="text/css">
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        
	        
	    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
	    <!--owl carousel css-->
	    <link href="css/owl.carousel.css" rel="stylesheet" type="text/css" media="screen">
	    <link href="css/owl.theme.css" rel="stylesheet" type="text/css" media="screen">
	    <!--mega menu -->
	    <link href="css/yamm.css" rel="stylesheet" type="text/css">
	    <!--popups css-->
	    <link href="css/magnific-popup.css" rel="stylesheet" type="text/css">
	    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	    <!--[if lt IE 9]>
	    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	    <![endif]-->

    </head>
    <body>
	
        <div id="header-top" class="hidden-xs">
            <div class="container">
                <div class="top-bar">
                    <div class="pull-left sample-1right">
                        <a><i class="fa fa-phone"></i> 有任何问题,请联系管理员   电话: <span class="colored-text">+17854119966</span> </a> 
                         <a><i class="fa fa-envelope"></i>邮箱: <span class="colored-text">chaoyue@163.com</span> </a>
                    </div>
                    <div class="pull-right">
                        <ul class="list-inline top-social">
                            <li>分享:</li>
                            <li><a href="javascript:;"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="javascript:;"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="javascript:;"><i class="fa fa-google-plus"></i></a></li>
                            <li><a href="javascript:;"><i class="fa fa-linkedin"></i></a></li>
                            <li><a href="javascript:;"><i class="fa fa-pinterest"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div><!--top bar end hidden in small devices-->
<!--navigation -->
<!-- Static navbar -->
<div class="navbar navbar-default navbar-static-top yamm sticky" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="../home.so">大学生就业创业服务网</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown active ">
                    <a href="../home.so" class="dropdown-toggle" >首页</i></a>
                </li>
                <!--menu 首页 li end here-->
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle " data-toggle="dropdown">就业日历<i class="fa fa-angle-down"></i></a>
                    <ul class="dropdown-menu multi-level" role="menu">
                        <li>
                            <a tabindex="-1" href="../firm_F_preach_list.so">宣讲会</a>
                        </li>
                        <li>
                            <a tabindex="-1" href="../firm_F_jobfair_list.so">招聘会</a>
                        </li>
                    </ul>
                </li>
                <!--menu 就业日历 li end here-->
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle " data-toggle="dropdown">就业指导<i class="fa fa-angle-down"></i></a>
                    <ul class="dropdown-menu multi-level" role="menu">
                        <li>
                            <a tabindex="-1" href="information_frontinforlist.so?type=面试宝典">面试宝典</a>
                        </li>
                        <li>
                            <a tabindex="-1" href="information_frontinforlist.so?type=求职技巧">求职技巧</a>
                        </li>
                        <li>
                            <a tabindex="-1" href="information_frontinforlist.so?type=简历指南">简历指南</a>
                        </li>
                        <li>
                            <a tabindex="-1" href="information_frontinforlist.so?type=就业指南">就业指南</a>
                        </li>
                    </ul>
                </li>
                <!--menu 就业指导 li end here-->
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle " data-toggle="dropdown">创业指导<i class="fa fa-angle-down"></i></a>
                    <ul class="dropdown-menu multi-level" role="menu">
                        <li>
                            <a tabindex="-1" href="information_frontinforlist.so?type=创业政策">创业政策</a>
                        </li>
                        <li>
                            <a tabindex="-1" href="../teacher_info.so">创业导师</a>
                        </li>
                        <li>
                            <a tabindex="-1" href="../StudentLoginTransform.sdo">项目申报</a>
                        </li>
                        <li>
                            <a tabindex="-1" href="information_frontinforlist.so?type=创业动态">创业动态</a>
                        </li>
                    </ul>
                </li>
                <!--menu 创业指导 li end here-->
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle " data-toggle="dropdown">服务指南<i class="fa fa-angle-down"></i></a>
                    <ul class="dropdown-menu multi-level" role="menu">
                        <li>
                            <a tabindex="-1" href="information_frontinforlist.so?type=企业指南">企业指南</a>
                        </li>
                        <li>
                            <a tabindex="-1" href="information_frontinforlist.so?type=学生指南">学生指南</a>
                        </li>
                        <li>
                            <a tabindex="-1" href="information_frontinforlist.so?type=资源下载">资源下载</a>
                        </li>
                    </ul>
                </li>
                <!--menu 服务指南 li end here-->
                <li class="dropdown">
                    <a href="../firm_F_information.so" class="dropdown-toggle " >名企招聘</a>
                </li>
                <!--menu 名企介绍 li end here-->
                <li class="dropdown">
                    <a href="../FrontQueryRecruit.so" class="dropdown-toggle ">最新职位</a>
                </li>
                <!--menu 最新职位 li end here-->
                
                <c:if test="${student!=null }">
                <li class="dropdown">
                    <a href="../StudentLoginTransform.sdo" class="dropdown-toggle ">学生中心</a>
                </li>
                </c:if>
                 <c:if test="${TeacherName!=null }">
                <li class="dropdown">
                    <a href="../Back/T_teacher_index.jsp" class="dropdown-toggle ">教师中心</a>
                </li>
                </c:if>
                <c:if test="${FirmName!=null }">
                <li class="dropdown">
                    <a href="../Back/F_firm_index.jsp" class="dropdown-toggle ">企业中心</a>
                </li>
                </c:if>
                <c:if test="${student==null&&FirmName==null&&TeacherName==null }">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle " data-toggle="dropdown"><i class="fa fa-lock"></i>登录入口<i class="fa fa-angle-down"></i></a>
                    <ul class="dropdown-menu multi-level" role="menu" style="text-align: center">
                        <li>
                            <a tabindex="-1" href="../Back/student-login.jsp"><i class="fa fa-user"></i>    学生登录</a>
                        </li>
                        <li>
                            <a tabindex="-1" href="../Back/T_teacher_login.jsp"><i class="fa fa-user"></i>    教师登录</a>
                        </li>
                        <li>
                            <a tabindex="-1" href="../Back/F_firm_login.jsp"><i class="fa fa-user"></i>    企业登录</a>
                        </li>
                    </ul>
                </li>
                </c:if>
                
                <!--menu 登录入口 li end here-->
            </ul>
        </div><!--/.nav-collapse -->
    </div><!--container-->
</div><!--navbar-default-->




<!--revolution slider-->
        <div class="breadcrumb-wrap">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <h4>创业导师</h4>
                    </div>
                    <div class="col-sm-6 hidden-xs text-right">
                        <ol class="breadcrumb">
                            <li><a>创业指导</a></li>
                            <li>创业导师</li>
                        </ol>
                    </div>
                </div>
            </div>
        </div><!--breadcrumbs-->
        <div class="divide80"></div>
        <div class="container">
            <div class="portfolio-cube">
			<!--
                <div id="filters-container" class="cbp-l-filters-button">
                    <div data-filter="*" class="cbp-filter-item-active cbp-filter-item">
                       	 所有教师 <div class="cbp-filter-counter"></div>
                    </div>
                    <div data-filter=".清华大学" class="cbp-filter-item">
                       	 清华大学 <div class="cbp-filter-counter"></div>
                    </div>
                    <div data-filter="同济大学" class="cbp-filter-item">
                       	 同济大学 <div class="cbp-filter-counter"></div>
                    </div>                  
                </div>
			  -->
                <div id="grid-container" class="cbp">
                <c:forEach items="${list}" var="teacher">
                	
                    <div class="cbp-item">
                    
                        <div class="cbp-caption">
                            <div class="cbp-caption-defaultWrap">
                                <img src="${teacher.picture}" alt="${teacher.teacherName}" style="width:500px;height:333px">
                            </div>
                            <div class="cbp-caption-activeWrap">
                                <div class="cbp-l-caption-alignCenter">
                                    <div class="cbp-l-caption-body">
                                        <a href="../teacher_singleinfo.so?ID=${teacher.ID}&TeacherName=${teacher.teacherName}" class=" cbp-l-caption-buttonLeft">详细信息</a>
                                        <a href="${teacher.picture}" class="cbp-lightbox cbp-l-caption-buttonRight" data-title="姓名：${teacher.teacherName}<br>个人邮箱：${teacher.email}">放大查看</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="cbp-l-grid-projects-title">${teacher.teacherName}
                        </div>
                        <div class="cbp-l-grid-projects-desc">${teacher.school} / 个人邮箱：${teacher.email}</div>
                    </div> 
              </c:forEach>
                </div>

                <div id="loadMore-container" class="cbp-l-loadMore-button">
                    <a href="#" class="cbp-l-loadMore-link">
                        <span class="cbp-l-loadMore-defaultText">加载更多</span>
                        <span class="cbp-l-loadMore-loadingText">加载中...</span>
                        <span class="cbp-l-loadMore-noMoreLoading">已加载全部</span>
                    </a>
                </div>
			
            </div>


        </div>
        <div class="divide60"></div>
       <footer id="footer">
    <div class="container">

        <div class="row">
            <div class="col-md-4 col-sm-6 margin30">
                <div class="footer-col">
                    <h3>关于我们</h3>
                    <p>
                        我们注重品质，绝对不卖乱七八糟的宝贝，不找乱七八糟的伙伴，想要做卧底侦探的请绕道，虽然我们很简单很善良，但是有必要时我们也很黄很暴力！
                    </p>
                    <ul class="list-inline social-1">
                        <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                        <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                        <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                        <li><a href="#"><i class="fa fa-pinterest"></i></a></li>
                        <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                    </ul>
                </div>
            </div><!--footer col-->


            <div class="col-md-4 col-sm-6 margin30">
                <div class="footer-col">
                    <h3>留言</h3>
                    <p>
                        我们致力于为人民服务
                    </p>
                    <form role="form" class="subscribe-form">
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="想对ss说些什么...">
                            <span class="input-group-btn">
                                        <button class="btn  btn-theme-dark btn-lg" type="submit">发送</button>
                                    </span>
                        </div>
                    </form>
                </div>
            </div><!--footer col-->
            <div class="col-md-4 col-sm-6 margin30">
                <div class="footer-col">
                    <h3>联系我们</h3>
                    <ul class="list-unstyled contact">
                        <li><p><strong><i class="fa fa-map-marker"></i> 公司地址:</strong> 山东省济南市齐鲁工业大学</p></li>
                        <li><p><strong><i class="fa fa-envelope"></i> 电子邮箱:</strong> <a href="#">Soul@designmylife.com</a></p></li>
                        <li> <p><strong><i class="fa fa-phone"></i> 电话:</strong> +02 1212 121 2121</p></li>
                        <li> <p><strong><i class="fa fa-print"></i> 传真：</strong> 1821 2121 2121</p></li>
                        <li> <p><strong><i class="fa fa-skype"></i> 网络电话：</strong> soul.212</p></li>

                    </ul>
                </div>
            </div><!--footer col-->
        </div>
        <div class="row">
            <div class="col-md-12 text-center">
                <div class="footer-btm">
                    <span>&copy;2017. by soul</span>
                </div>
            </div>
        </div>
    </div>
</footer><!--底部 end here-->
        <!--scripts and plugins -->
        <!--must need plugin jquery-->
        <script src="js/jquery.min.js"></script>        
        <!--bootstrap js plugin-->
        <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>       
        <!--easing plugin for smooth scroll-->
        <script src="js/jquery.easing.1.3.min.js" type="text/javascript"></script>
        <!--sticky header-->
        <script type="text/javascript" src="js/jquery.sticky.js"></script>
        <!--flex slider plugin-->
        <script src="js/jquery.flexslider-min.js" type="text/javascript"></script>
        <!--parallax background plugin-->
        <script src="js/jquery.stellar.min.js" type="text/javascript"></script>                
        <!--digit countdown plugin-->
        <script src="http://cdnjs.cloudflare.com/ajax/libs/waypoints/2.0.3/waypoints.min.js"></script>
        <!--digit countdown plugin-->
        <script src="js/jquery.counterup.min.js" type="text/javascript"></script>
        <!--on scroll animation-->
        <script src="js/wow.min.js" type="text/javascript"></script> 
        <!--owl carousel slider-->
        <script src="js/owl.carousel.min.js" type="text/javascript"></script>
        <!--popup js-->
        <script src="js/jquery.magnific-popup.min.js" type="text/javascript"></script>
        <!--you tube player-->
        <script src="js/jquery.mb.YTPlayer.min.js" type="text/javascript"></script>               
        <!--customizable plugin edit according to your needs-->
        <script src="js/custom.js" type="text/javascript"></script>
        <!--cube portfolio plugin-->
        <script src="cubeportfolio/js/jquery.cubeportfolio.min.js" type="text/javascript"></script>
         <script src="js/cube-portfolio.js" type="text/javascript"></script>
    </body>
</html>

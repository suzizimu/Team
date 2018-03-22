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
    <base href="<%=path%>/Front/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>大学生就业创业网</title>

    <!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- custom css-->
    <link href="css/style.css" rel="stylesheet" type="text/css" media="screen">

    <!-- font awesome for icons -->
    <link href="font-awesome-4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- flex slider css -->
    <link href="css/flexslider.css" rel="stylesheet" type="text/css" media="screen">
    <!-- animated css  -->
    <link href="css/animate.css" rel="stylesheet" type="text/css" media="screen">
    <!--Revolution slider css-->
    <link href="rs-plugin/css/settings.css" rel="stylesheet" type="text/css" media="screen">
    <link href="css/rev-style.css" rel="stylesheet" type="text/css" media="screen">
    <!--google fonts-->


    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <!--owl carousel css-->
    <link href="css/owl.carousel.css" rel="stylesheet" type="text/css" media="screen">
    <link href="css/owl.theme.css" rel="stylesheet" type="text/css" media="screen">
    <!--mega menu -->
    <link href="css/yamm.css" rel="stylesheet" type="text/css">
    <!--popups css-->
    <link href="css/magnific-popup.css" rel="stylesheet" type="text/css">

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
<article>
    <div>
        <div class="tp-banner-vertical" >
            <ul>    <!-- SLIDE  -->
                <li data-transition="slidevertical" data-slotamount="1" data-masterspeed="1000" data-thumb="img/construction/constro-bg-1.jpg"  data-saveperformance="off"  data-title="Slide">
                    <!-- MAIN IMAGE -->
                    <img src="img/construction/constro-bg-1.jpg"  alt="fullslide1"  data-bgposition="center top" data-bgfit="cover" data-bgrepeat="no-repeat">
                    <!-- LAYERS -->

                    <!-- LAYER NR. 1 -->
                    <div class="tp-caption vertical-title lfb ltt tp-resizeme"
                         data-x="left" data-hoffset="100"
                         data-y="center" data-voffset="-70"
                         data-speed="600"
                         data-start="800"
                         data-easing="Power4.easeOut"
                         data-splitin="none"
                         data-splitout="none"
                         data-elementdelay="0.01"
                         data-endelementdelay="0.1"
                         data-endspeed="500"
                         data-endeasing="Power4.easeIn"
                    >就业/创业
                    </div>

                    <!-- LAYER NR. 2 -->
                    <div class="tp-caption vertical-caption lfb ltt tp-resizeme"
                         data-x="left" data-hoffset="100"
                         data-y="center" data-voffset="20"
                         data-speed="600"
                         data-start="900"
                         data-easing="Power4.easeOut"
                         data-splitin="none"
                         data-splitout="none"
                         data-elementdelay="0.01"
                         data-endelementdelay="0.1"
                         data-endspeed="500"
                         data-endeasing="Power4.easeIn"
                    >为您提供更优质的服务.<br>拥有更明智的选择.
                    </div>
                    <!-- LAYER NR. 3 -->
                    <div class="tp-caption rev-buttons lfb ltt tp-resizeme"
                         data-x="left" data-hoffset="100"
                         data-y="center" data-voffset="110"
                         data-speed="600"
                         data-start="900"
                         data-easing="Power4.easeOut"
                         data-splitin="none"
                         data-splitout="none"
                         data-elementdelay="0.01"
                         data-endelementdelay="0.1"
                         data-endspeed="500"
                         data-endeasing="Power4.easeIn"
                    ><a href="information_frontinforlist.so?type=创业政策" class="btn btn-lg border-white">了解更多</a>
                    </div>
                </li>
                <!-- SLIDE  -->
                <li data-transition="slidevertical" data-slotamount="1" data-masterspeed="1000" data-thumb="img/construction/constro-bg-2.jpg"  data-saveperformance="off"  data-title="Slide">
                    <!-- MAIN IMAGE -->
                    <img src="img/construction/constro-bg-2.jpg"  alt="fullslide1"  data-bgposition="center top" data-bgfit="cover" data-bgrepeat="no-repeat">
                    <!-- LAYERS -->

                    <!-- LAYER NR. 1 -->
                    <div class="tp-caption vertical-title lfb ltt tp-resizeme"
                         data-x="left" data-hoffset="100"
                         data-y="center" data-voffset="-70"
                         data-speed="600"
                         data-start="800"
                         data-easing="Power4.easeOut"
                         data-splitin="none"
                         data-splitout="none"
                         data-elementdelay="0.01"
                         data-endelementdelay="0.1"
                         data-endspeed="500"
                         data-endeasing="Power4.easeIn"
                    >招聘会/指导建议
                    </div>

                    <!-- LAYER NR. 2 -->
                    <div class="tp-caption vertical-caption lfb ltt tp-resizeme"
                         data-x="left" data-hoffset="100"
                         data-y="center" data-voffset="20"
                         data-speed="600"
                         data-start="900"
                         data-easing="Power4.easeOut"
                         data-splitin="none"
                         data-splitout="none"
                         data-elementdelay="0.01"
                         data-endelementdelay="0.1"
                         data-endspeed="500"
                         data-endeasing="Power4.easeIn"
                    >寻找人生新起点.<br>为企业注入新活力.
                    </div>
                    <!-- LAYER NR. 3 -->
                    <div class="tp-caption rev-buttons lfb ltt tp-resizeme"
                         data-x="left" data-hoffset="100"
                         data-y="center" data-voffset="110"
                         data-speed="600"
                         data-start="900"
                         data-easing="Power4.easeOut"
                         data-splitin="none"
                         data-splitout="none"
                         data-elementdelay="0.01"
                         data-endelementdelay="0.1"
                         data-endspeed="500"
                         data-endeasing="Power4.easeIn"
                    ><a href="information_frontinforlist.so?type=求职技巧" class="btn btn-lg border-white">了解更多</a>
                    </div>
                </li>



            </ul>
            <div class="tp-bannertimer"></div>
        </div>
    </div>
</article>		<!--revolution vertical slider end-->

<div class="divide70"></div>
<div class="schedule">
    <div class="container">
        <div class="center-heading">
            <h2>招聘会</h2>
            <span class="center-line"></span>
    
        </div>
        <div class="row">
          <c:forEach items="${list1}" var="jobfair">
            <div class="col-sm-6 ">    
                <div class="event-box animated fadeInLeft">
                    <span class="time"><i class="fa fa-clock-o"></i>${jobfair.date}</span>
                    <h3 class="title"><a href="../firm_F_jobfair_detail.so?ID=${jobfair.ID}">${jobfair.title}</a></h3>
                    <p>
                      ${jobfair.content}
                    </p>
                    <span class="author">${jobfair.address}</span>
                </div><!--event box-->               
            </div>
           </c:forEach>                 
        </div>
    </div>
</div><!--招聘会 end-->
<div class="divide70"></div>
<div class="featured-work">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="center-heading">
                    <h2>名企招聘</h2>
                    <span class="center-line"></span>
                </div>
            </div>
        </div>
    </div>
    <!--owl carousel start-->
    <div id="featured-work">
    
      <c:forEach items="${list2}" var="firm">
        <div class="item">
            <div class="work-wrap">
                <img src="${firm.logo}" class="img-responsive" alt="" style="width:500px;height:333px;">
                <div class="img-overlay">
                    <div class="inner-overlay">
                        <h2>${firm.firmName}</h2>
                        <p>发布职位数：${firm.recruitSum}</p>
                        <a class="link" href="../firm_F_informaiton_detail.so?ID=${firm.ID}&FirmName=${firm.firmName}"><i class="fa fa-search"></i></a>
                        <a class="zoom show-image" href="${firm.logo}"><i class="fa fa-image"></i></a>
                    </div>
                </div><!--img-overlay-->
            </div><!--work-image-wrap end-->
        </div><!--owl item end-->
      </c:forEach>
              
    </div>
</div><!--名企招聘 end-->
<div class="divide70"></div>
<div class="assan-features">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="center-heading">
                    <h2>最新<strong>职位</strong></h2>
                    <span class="center-line"></span>
                </div>
            </div>
        </div>
        <div class="row">

          <c:forEach items="${list4}" var="recruit">
            <div class="col-md-4 col-sm-6 margin20">
                <div class="services-box wow animated fadeIn" data-wow-duration="400ms" data-wow-delay="400ms">
                    <div class="services-box-icon">
                        <i class="fa fa-flag"></i>
                    </div><!--services icon-->
                    <div class="services-box-info">
                        <h4><a href="../FrontRecruitDetailSet.so?ID=${recruit.ID }">${recruit.job}</a></h4>
                        <p>
                                                             待遇：${recruit.pay}+${recruit.welfare}
                        </p>
                    </div>
                </div><!--services box-->
            </div><!--services col-->
         </c:forEach>  
            
        </div><!--services row-->
    </div>
</div><!--最新职位 end-->
<div class="divide70"></div>
<div class="constro-cta parallax" >
    <div class="container">
        <div class="row">
            <div class="col-sm-8 col-sm-offset-2">
                <p>人生要策划，要洗涤心灵，洒扫心灵。</p>
                <h1>求职、简历、面试、就业</h1>
                
                <p><a href="information_frontinforlist.so?type=就业指南" class="btn btn-theme-bg btn-lg">就业指导 <i class="fa fa-chevron-right"></i></a></p>
            </div>
        </div>
    </div>
</div><!--constro cta-->

<div class="testimonials-v-2 construction wow animated fadeInUp" data-wow-duration="700ms" data-wow-delay="100ms">
    <div class="container">
        <div class="row">
            <div class="col-sm-8 col-sm-offset-2">
                <div class="center-heading">
                    <h2>名师交流</h2>
                    <span class="center-line"></span>

                </div>
            </div>
        </div><!--center heading end-->

        <div class="row">
            <div class="col-sm-8 col-sm-offset-2">
                <div class="testi-slide">
                    <ul class="slides">
                    
                      <c:forEach items="${list3}" var="teacher">
                        <li>
                            <img src="${teacher.picture}" alt="">
                            <h4><Strong><a href="../teacher_singleinfo.so?ID=${teacher.ID}">${teacher.teacherName}</a></Strong></h4>
                            <p>
                                <i class="ion-quote"></i>
                             ${teacher.des}
                            </p>
                            <h4 class="test-author">
                                ${teacher.school} - <em>${teacher.academy}</em>
                            </h4>
                        </li><!--testi item-->
                      </c:forEach> 
                                              
                    </ul>
                </div><!--flex slider testimonials end here-->
            </div>
        </div><!--testi slider row end-->
    </div>
</div><!--名师交流 end-->

<div class="divide70"></div>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="center-heading">
                <h2>政策·动态</h2>
                <span class="center-line"></span>
            </div>
        </div>
        
        <div class="margin40">
              <c:forEach items="${list5}" var="information">
                <div class="col-md-6">                    
                        <div class="news-desc">                           
                            <h4><a href="/Team/Front/information_detail.so?ID=${information.ID}" class="colored-text">${information.title}</a></h4>
                            <span>${information.date}</span>                          
                            <span><a href="/Team/Front/information_detail.so?ID=${information.ID}">阅读更多</a></span>
                        </div><!--news desc-->               
                </div>
             </c:forEach>
        </div><!--col 7 end use for latest news owl carousel slide-->
    </div>
</div><!--政策·动态 end-->
<div class="divide70"></div>

<div class="divide40"></div>

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
<script src="js/jquery-migrate.min.js"></script>
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

<script src="js/jquery.isotope.min.js" type="text/javascript"></script>
<!--image loads plugin -->
<script src="js/jquery.imagesloaded.min.js" type="text/javascript"></script>
<!--owl carousel slider-->
<script src="js/owl.carousel.min.js" type="text/javascript"></script>
<!--popup js-->
<script src="js/jquery.magnific-popup.min.js" type="text/javascript"></script>
<!--you tube player-->
<script src="js/jquery.mb.YTPlayer.min.js" type="text/javascript"></script>
<!--customizable plugin edit according to your needs-->
<script src="js/custom.js" type="text/javascript"></script>

<!--revolution slider plugins-->
<script src="rs-plugin/js/jquery.themepunch.tools.min.js" type="text/javascript"></script>
<script src="rs-plugin/js/jquery.themepunch.revolution.min.js" type="text/javascript"></script>
<script src="js/revolution-custom.js" type="text/javascript"></script>
<script src="js/isotope-custom.js" type="text/javascript"></script>
</body>
</html>
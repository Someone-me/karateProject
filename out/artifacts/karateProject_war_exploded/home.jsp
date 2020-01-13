<%--
  Created by IntelliJ IDEA.
  User: 12816
  Date: 2019/12/16
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>安徽省空手道协会</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- <link rel="stylesheet" href="css/register.css">-->
    <link href="css/bootstrap.theme.css" rel="stylesheet">
    <!--		导入jquery-->
    <script src="js/jquery-3.3.1.js"></script>
    <script src="js/bootstrap.js" rel="stylesheet"></script>
    <%-- <script src="js/jquery.bootstrap.newsbox.min.js" rel="stylesheet"></script>--%>

    <style>
        .applyButton {
            cursor: pointer;
            height: 100px;
            width: 300px;
            background: url('images/2019/12/19/matchapply.png');
            margin-top: 10px;
            margin-left: 50px;
        }

        .huiYuan{
            cursor: pointer;
            height: 100px;
            width: 300px;
            background: url('images/2019/12/31/HYFW.png');
            margin-left: 50px;
        }
        li {
            color: #337AB7;
            font-size: 15px;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
            list-style-type: none;
        }

        .home_video_obj_title {
            background-color: #666666;
            width: 366px;
            height: 20px;
            z-index: 2;
            position: relative;
            top: -20px;
            filter: alpha(opacity=50);
            -moz-opacity: 0.5;
            opacity: 0.5;
        }


        .dcp_list {
            padding-left: 0px;
            padding-right: 0px;
            height: 327px;
            background-color: #ffffff;
            overflow: auto;
            padding-left: 10px;padding-right: 10px;margin-top: 20px;
        }

        .dcp_list a {
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
            display: block;
        }
        .panel-heading{
            font-size: 17px;
            text-align: center;
            font-weight: 800
        }
        .panel-footer{
            height: 20px;padding: 0px
        }
        .more{
            color: #CCCCCC;float: right;
        }

        .navigation {
            color: white;
        }

        .news {
            font-family: 黑体;
            font-weight: 800;
            margin-bottom: 5px;
        }
        .videoAndpicture{
            border-bottom: solid 1px #DD0102;margin-left: 0px;margin-right: 0px;margin-top: 20px;
        }
        .home_match_obj_div{
            height: 60px;background-color: #F1F1F1;;font-size: 25px;margin:0px;
        }
        .home_match_obj_title{
            font-family: 黑体;margin-left: 10px;margin-top: 20px;
        }
        .home_match_button_div{
            margin-top: 30px;border: 1px solid #e7e7e7;margin-left: 0px;margin-right: 0px;
        }
        .home_match_button_row{
            margin-left: 0px;margin-right: 0px;margin-top: 20px;
        }
        .home_match_button_btn{
            height: 70px;width: 100%;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;
        }
        .home_match_button_class{
            margin-left: 0px;margin-right: 0px;margin-top: 20px;margin-bottom: 80px;
        }
        .breadcrumb{
            margin-top: 10px;padding-bottom: 0px;padding-top: 0px;
        }
    </style>
</head>
<body>
<div style="margin-bottom: 60px">
    <div style="margin-top: 30px">
        <nav class="navbar navbar-inverse" style="background: #666666">
            <div class="container-fluid">
                <div class="navbar-header col-lg-3">
                    <p style="float: right;font-size: 20px;color: white;margin-top: 10px;font-family: 宋体">安徽省空手道协会官网</p>
                </div>

                <ul class="nav nav-pills" style="margin-top: 5px;">
                    <li><a href="home.jsp" class="navigation">首页</a></li>
                    <li><a href="./associationIntroduce.jsp" class="navigation">关于协会</a></li>
                    <li><a href="${pageContext.request.contextPath}/NewsCenterSearchPageServlet" class="navigation">新闻中心</a></li>
                    <li><a href="${pageContext.request.contextPath}/MatchNewsCenterSearchPageServlet" class="navigation">通知公告</a></li>
                    <li><a href="${pageContext.request.contextPath}/MatchPictureShowPageServlet" class="navigation">图片</a></li>
                    <li><a href="${pageContext.request.contextPath}/VideoListServlet" class="navigation">视频</a></li>
                </ul>
            </div>
        </nav>
    </div>
    <div class="container">
        <div class="row carousel slide col-lg-7 col-sm-6" data-ride="carousel" style="padding: 0px;margin: 0px;">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner" role="listbox">
                <div class="item active" >
                    <img  src="images/2019/12/19/slideshow1.png">
                </div>
                <div class="item">
                    <img  src="images/2019/12/19/slideshow2.png">
                </div>
                <div class="item">
                    <img  src="images/2019/12/19/slideshow3.png">
                </div>
            </div>
        </div>
        <div class="row col-lg-5 col-sm-6"role="listbox" >
            <div class="row huiYuan col-sm-2" onclick="window.location.href='#'">
            </div>
            <div class="row applyButton col-sm-2" onclick="window.location.href='http://39.107.68.116/KarateWeb/Login'">
            </div>
        </div>
    </div>
    <div class="container" style="margin-top: 40px">
        <div class="row">
            <div class="col-lg-4 col-sm-4">
                <div class="panel panel-default">
                    <div class="panel-heading" style="">
                        <b>新&nbsp;闻&nbsp;资&nbsp;讯</b>
                    </div>
                    <div class="panel-body" style="padding: 0px;">
                        <ul class="demo1" id="news1" style="padding-left: 10px;">
                            <%--<li class="news" data-toggle="tooltip" data-placement="bottom" title="尹笑言马德里摘金获得年度总冠军"
                                onclick="window.location.href='showNews.jsp'">
                                尹笑言马德里摘金获得年度总冠军
                            </li>--%>
                            <%--<li class="news" data-toggle="tooltip" data-placement="bottom" title="空手道列入2022年达喀尔青奥会比赛项目"
                                onclick="window.location.href='showNews.jsp'">
                                空手道列入2022年达喀尔青奥会比赛项目
                            </li>
                            <li class="news" data-toggle="tooltip" data-placement="bottom" title="2019全国空手道教练员培训圆满落幕"
                                onclick="window.location.href=''">
                                2019全国空手道教练员培训圆满落幕
                            </li>
                            <li class="news" data-toggle="tooltip" data-placement="bottom" title="全国空手道教练员岗位培训无锡开班"
                                onclick="window.location.href=''">
                                全国空手道教练员岗位培训无锡开班
                            </li>
                            <li class="news" data-toggle="tooltip" data-placement="bottom"
                                title="中国跆拳道队、中国空手道队学习女排精神 争创奥运佳绩" onclick="window.location.href=''">
                                中国跆拳道队、中国空手道队学习女排精神 争创奥运佳绩
                            </li>--%>
                        </ul>
                    </div>
                    <div class="panel-footer" >
                        <a href="${pageContext.request.contextPath}/NewsCenterSearchPageServlet"class="more">更多……</a>
                    </div>
                </div>
            </div>

            <div class="col-lg-4 col-sm-4">
                <div class="panel panel-default">
                    <div class="panel-heading" >
                        <b>协&nbsp;会&nbsp;动&nbsp;态</b>
                    </div>
                    <div class="panel-body" style="padding: 0px;">
                        <ul class="demo1" id="news2" style="padding-left: 10px;">
                            <%--<li class="news" data-toggle="tooltip" data-placement="bottom" title="尹笑言马德里摘金获得年度总冠军">
                                <a href="${pageContext.request.contextPath}/textServlet">尹笑言马德里摘金获得年度总冠军</a>
                            </li>
                            <li class="news" data-toggle="tooltip" data-placement="bottom" title="空手道列入2022年达喀尔青奥会比赛项目"
                                onclick="window.location.href='./success.jsp'">
                                空手道列入2022年达喀尔青奥会比赛项目
                            </li>
                            <li class="news" data-toggle="tooltip" data-placement="bottom" title="2019全国空手道教练员培训圆满落幕"
                                onclick="window.location.href=''">
                                2019全国空手道教练员培训圆满落幕
                            </li>
                            <li class="news" data-toggle="tooltip" data-placement="bottom" title="全国空手道教练员岗位培训无锡开班"
                                onclick="window.location.href=''">
                                全国空手道教练员岗位培训无锡开班
                            </li>
                            <li class="news" data-toggle="tooltip" data-placement="bottom"
                                title="中国跆拳道队、中国空手道队学习女排精神 争创奥运佳绩" onclick="window.location.href=''">
                                中国跆拳道队、中国空手道队学习女排精神 争创奥运佳绩
                            </li>--%>
                        </ul>
                    </div>
                    <div class="panel-footer">
                        <a href="${pageContext.request.contextPath}/AssociationNewsSearchPageServlet"class="more">更多……</a>
                    </div>
                </div>
            </div>

            <div class="col-lg-4 col-sm-4">
                <div class="panel panel-default">
                    <div class="panel-heading" >
                        <b>通&nbsp;知&nbsp;公&nbsp;告</b>
                    </div>
                    <div class="panel-body" style="padding: 0px;overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">
                        <ul class="demo3" id="news3" style="padding-left: 10px;">
                            <%--<li class="news" data-toggle="tooltip" data-placement="bottom" title="尹笑言马德里摘金获得年度总冠军"
                                onclick="window.location.href=''">
                                尹笑言马德里摘金获得年度总冠军
                            </li>
                            <li class="news" data-toggle="tooltip" data-placement="bottom" title="空手道列入2022年达喀尔青奥会比赛项目"
                                onclick="window.location.href=''">
                                空手道列入2022年达喀尔青奥会比赛项目
                            </li>
                            <li class="news" data-toggle="tooltip" data-placement="bottom" title="2019全国空手道教练员培训圆满落幕"
                                onclick="window.location.href=''">
                                2019全国空手道教练员培训圆满落幕
                            </li>
                            <li class="news" data-toggle="tooltip" data-placement="bottom" title="全国空手道教练员岗位培训无锡开班"
                                onclick="window.location.href=''">
                                全国空手道教练员岗位培训无锡开班
                            </li>
                            <li class="news" data-toggle="tooltip" data-placement="bottom"
                                title="中国跆拳道队、中国空手道队学习女排精神 争创奥运佳绩" onclick="window.location.href=''">
                                中国跆拳道队、中国空手道队学习女排精神 争创奥运佳绩
                            </li>--%>
                        </ul>
                    </div>
                    <div class="panel-footer">
                        <a href="${pageContext.request.contextPath}/MatchNewsCenterSearchPageServlet" class="more">更多……</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container" style="margin-top: 20px;padding: 15px">
        <div class="col-lg-8 col-sm-8" style="background:#666666;">
            <div class="row videoAndpicture">
                <div class="col-lg-2 col-sm-4" style="color: white;font-size: 20px">视频</div>
                <div class="col-lg-1 col-lg-pull-1 col-sm-1 col-sm-pull-2" style="margin-top: 5px;padding: 0px">Video
                </div>
                <div class="col-lg-2 col-sm-3" style="float: right"><a href="${pageContext.request.contextPath}/VideoListServlet" style="color: #CCCCCC;">更多……</a></div>
            </div>
            <div class="row" style="margin-top: 5px">
                <div class="col-lg-6 col-sm-6" style="padding: 10px"onclick="openURL('https://v.qq.com/x/page/f0911t2w4ee.html');">
                    <img src="images/2019/12/19/indexpicture1.jpg" style="height: 240px;width: 100%;">
                    <div class="home_video_obj_title">
                        <div class="col-lg-6 col-sm-6" style="padding: 0px">二青会空手道比赛高光时刻</div>
                    </div>
                </div>
                <div class="col-lg-6 col-sm-6" style="padding: 10px"onclick="openURL('https://v.qq.com/x/page/k0909wuuhyk.html');">
                    <img src="images/2019/12/19/indexpicture2.jpg" style="height: 240px;width: 100%;">
                    <div class="home_video_obj_title">
                        <div class="col-lg-6 col-sm-6" style="padding: 0px">二青会空手道比赛高光时刻</div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-4 col-sm-4" style="background:#666666;">
            <div class="row videoAndpicture">
                <div class="col-lg-3 col-sm-4" style="color: white;font-size: 20px">图片</div>
                <div class="col-lg-2 col-lg-pull-1 col-sm-1 col-sm-pull-1" style="margin-top: 5px;padding: 0px">Picture
                </div>
            </div>
            <div class="row" style="margin-top: 5px;padding: 8px">
                <div id="carousel-example-generic" class="carousel slide" data-ride="carousel"
                     style="margin-bottom: 10px">
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                    </ol>

                    <!-- Wrapper for slides -->
                    <div class="carousel-inner" role="listbox">
                        <div class="item active">
                            <img src="images/2019/12/19/slideshow4.jpg" style="height: 254px">
                        </div>
                        <div class="item">
                            <img src="images/2019/12/19/slideshow5.jpg" style="height: 254px">
                        </div>
                        <div class="item">
                            <img src="images/2019/12/19/slideshow6.jpg" style="height: 254px">
                        </div>
                        <div class="item">
                            <img src="images/2019/12/19/slideshow7.jpg" style="height: 254px">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container" style="margin-top: 20px;padding: 0px">
        <div class="row" style="margin: 0px">
            <div class="col-lg-8 col-sm-8" style="margin: 0px;padding: 0px;">
                <div class="row home_match_obj_div" >
                    <p class="home_match_obj_title" >年&nbsp;度&nbsp;赛&nbsp;事</p>
                </div>
                <div class="row home_match_button_div">
                    <div class="row col-lg-6 col-sm-6 home_match_button_row" >
                        <a href="${pageContext.request.contextPath}/ButtonServlet">
                            <input type="button" class="btn btn-primary home_match_button_btn" name="第二届全国青年运动会空手道决赛" value="第二届全国青年运动会空手道决赛">
                        </a>
                        <%-- <a href="${pageContext.request.contextPath}/MatchNewsCenterSearchPageServlet"><button class="btn btn-primary home_match_button_btn" title="第二届全国青年运动会空手道决赛" value="第二届全国青年运动会空手道决赛">第二届全国青年运动会空手道决赛
                         <tton></a>--%>
                    </div>
                    <div class="row col-lg-6 col-sm-6 home_match_button_row">
                        <a href="#">
                            <input type="button" class="btn btn-danger home_match_button_btn" name="第二届全国青年运动会空手道决赛" value="第二届全国青年运动会空手道决赛">
                        </a>
                    </div>
                    <div class="row col-lg-6 col-sm-6 home_match_button_row">
                        <a href="#">
                            <input type="button" class="btn btn-info home_match_button_btn" name="第二届全国青年运动会空手道决赛" value="第二届全国青年运动会空手道决赛">
                        </a>
                    </div>
                    <div class="row col-lg-6 col-sm-6 home_match_button_row">
                        <%--<button
                                class="btn btn-warning home_match_button_btn" title="第二届全国青年运动会空手道决赛" >第二届全国青年运动会空手道决赛
                        <tton>--%>
                        <a href="#">
                            <input type="button" class="btn btn-warning home_match_button_btn" name="第二届全国青年运动会空手道决赛" value="第二届全国青年运动会空手道决赛">
                        </a>
                    </div>
                    <div class="row col-lg-6 col-sm-6 home_match_button_row">
                        <a href="#">
                            <input type="button" class="btn btn-success home_match_button_btn" name="第二届全国青年运动会空手道决赛" value="第二届全国青年运动会空手道决赛">
                        </a>
                    </div>
                    <div class="row col-lg-6 col-sm-6 home_match_button_class">
                        <a href="#">
                            <input type="button" class="btn home_match_button_btn" name="第二届全国青年运动会空手道决赛" value="第二届全国青年运动会空手道决赛">
                        </a>
                    </div>

                </div>

            </div>
            <div class="col-lg-4 col-sm-4" style="margin: 0px;padding: 0px">
                <div style="padding-left: 10px;padding-right: 10px;">
                    <nav class="navbar navbar-default" role="navigation" style="">
                        <div class="navbar-header" style="float: left; font-weight: bold;">
                            <a class="navbar-brand " href="javascript:void(0);">下载中心</a>
                        </div>
                        <div>
                            <ul class="breadcrumb">
                                <li><a href="javascript:administrationProvide();">管理规定</a></li>
                                <li><a href="javascript:eventResults();">赛事成绩</a></li>
                            </ul>
                        </div>
                    </nav>
                </div>
                <div class="dcp_list" id="dcp_list">
                    <a href="http://39.107.68.116/karatePdf/getPdf" class="list-group-item" target="_blank"> 报名名单预览与下载 </a>

                    <a href="file/2020/1/2/空手道2019年运动员注册通知.pdf" class="list-group-item" target="_blank"
                       title="空手道2019年运动员注册通知">空手道2019年运动员注册通知</a>
                    <a href="file/2020/1/2/WKF2019规则1月版.pdf" class="list-group-item" target="_blank"
                       title="WKF2019规则1月版" style="color: red;">WKF2019规则1月版</a>
                    <a href="file/2020/1/2/中国空手道协会裁判管理实施细则.doc" class="list-group-item" target="_blank"
                       title="中国空手道协会裁判管理实施细则">中国空手道协会裁判管理实施细则</a>
                    <a href="file/2020/1/2/13karate.pdf" class="list-group-item" target="_blank"
                       title="第十三届全国运动会空手道项目竞赛文件汇编">第十三届全国运动会空手道项目竞赛文件汇编</a>
                    <a href="file/2020/1/2/WKF2017.pdf" class="list-group-item" target="_blank" title="WKF规则2017">WKF规则2017</a>
                    <a href="file/2020/1/2/jlbxxpd2016.docx" class="list-group-item" target="_blank"
                       title="星级俱乐部、学校评定管理办法（2016版）">星级俱乐部、学校评定管理办法（2016版）</a>
                    <a href="file/2020/1/2/中国空手道协会裁判员管理规定.doc" target="_blank" class="list-group-item" title="中国空手道协会裁判员管理规定">中国空手道协会裁判员管理规定</a>
                    <a href="file/2020/1/2/中国空手道协会会员管理办法.doc" target="_blank" class="list-group-item" title="中国空手道协会会员管理办法">中国空手道协会会员管理办法</a>
                    <a href="file/2020/1/2/中国空手道协会教练员管理规定（2014）.doc" class="list-group-item" target="_blank"
                       title="中国空手道协会教练员管理规定">中国空手道协会教练员管理规定</a>
                    <a href="file/2020/1/2/中国空手道协会竞赛管理办法2014.doc" target="_blank" class="list-group-item" title="中国空手道协会竞赛管理办法">中国空手道协会竞赛管理办法</a>
                    <a href="file/2020/1/2/中国空手道协会竞赛纪律处罚条例（新增）.doc" target="_blank" class="list-group-item" title="中国空手道协会竞赛纪律处罚条例（新增）">中国空手道协会竞赛纪律处罚条例（新增）</a>
                    <%--<a href="/doc/dwksgglbf2016.doc" class="list-group-item" title="中国空手道协会段位考试官管理办法（2016版）">中国空手道协会段位考试官管理办法（2016版）</a>
                    <a href="/doc/ydyzcglbf2016.docx" class="list-group-item" title="中国空手道协会运动员注册管理办法（2016版）">中国空手道协会运动员注册管理办法（2016版）</a>--%>
                </div>
                <div class="dcp_list" id="ss_list" style="padding-left: 10px;padding-right: 10px;display: none">
                    <a href="file/2020/1/2/2017qgjbscjc.pdf" class="list-group-item" target="_blank"
                       title="2017年全国竞技空手道锦标赛成绩册">2017年全国竞技空手道锦标赛成绩册</a>
                    <a href="file/2020/1/2/2017ahcjc.doc" class="list-group-item" target="_blank" title="2017年全国竞技空手道俱乐部争霸赛(安徽站)分站赛成绩册">2017年全国竞技空手道俱乐部争霸赛(安徽站)分站赛成绩册</a>
                    <a href="file/2020/1/2/ctccjc.xlsx" class="list-group-item" target="_blank" title="西铁城上海俱乐部争霸赛成绩册">西铁城上海俱乐部争霸赛成绩册</a>
                </div>
            </div>
        </div>
    </div>
    <div class="container"style="margin-top: 40px;background: #2D3237">
        <div class="row">
            <div class="col-sm-12" style="padding-top: 20px;">
                <div class="row" style="background-color: #2D3237;">
                    <div class="col-sm-12">
                        <div class="row">
                            <!-- Foot left container start -->
                            <div class="col-sm-4" style="padding: 30px;">
                                <div class="row">
                                    <div class="col-sm-12 " style="color: #ffffff;font-size: 13px;font-weight: 800;border-bottom: solid 1px #666666;height: 35px;line-height: 35px;">
                                        会员服务
                                    </div>
                                </div>

                                <div class="row" style="padding-top: 20px;">
                                    <div class="col-sm-12" style="color: #ffffff;font-size: 13px;font-weight: 800;">
                                        电话：010-87101791<br>
                                    </div>
                                </div>
                                <div class="row" style="padding-top: 20px;">
                                    <div class="col-sm-12" style="color: #ffffff;font-size: 13px;font-weight: 800;">
                                        邮箱：hyfw@chinacka.org.cn<br>
                                    </div>
                                </div>

                                <div class="row" style="padding-top: 40px;">
                                    <div class="col-sm-12" style="border-bottom: solid 1px #666666;">
                                    </div>
                                </div>

                                <div class="row" style="padding-top: 5px;">
                                    <div class="col-sm-12" style="color: #ffffff;font-size: 13px;font-weight: 800;height: 35px;line-height: 35px;">

                                    </div>
                                </div>

                                <div class="row" style="padding-top: 5px;">
                                    <div class="col-sm-12" style="color: #ffffff;font-size: 13px;font-weight: 800;">
                                        <br>
                                    </div>
                                </div>
                            </div>
                            <!-- Foot left container end -->

                            <!-- Foot center container start -->
                            <div class="col-sm-4" style="padding: 30px;">
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div style="width: 100%;height: 100%;background-color: #272C30;text-align: center;height: 230px;line-height: 230px;border: solid 1px #2B2F34;">
                                            <img alt="" src="images/2019/12/19/wxewm.png" style="width: 168px;height: 168px;margin-top: 30px">
                                        </div>
                                    </div>
                                </div>
                                <div class="row" style="margin-top: 10px;">
                                    <div class="col-sm-12" style="font-size: 12px;color: #ffffff;text-align: center;">
                                        扫一扫关注微信公众号
                                    </div>
                                </div>
                            </div>
                            <!-- Foot center container end -->

                            <!-- Foot right container start -->
                            <div class="col-sm-4" style="padding: 30px;">
                                <div class="row">
                                    <div class="col-lg-12 col-sm-12" style="color: #ffffff;font-size: 13px;font-weight: 800;border-bottom: solid 1px #666666;height: 35px;line-height: 35px;">
                                        友情链接
                                    </div>
                                </div>
                                <div class="row" style="padding-top: 20px;">
                                    <div class="col-sm-6 " style="height: 87px;line-height: 87px;cursor: pointer;padding: 5px">
                                        <img alt="" src="images/2019/12/19/TYJLJ.jpg" onclick="openURL('http://www.sport.gov.cn')"style="width: 100%;margin-top: 15px;">
                                    </div>
                                    <div class="col-sm-6" style="height: 87px;line-height: 87px;text-align: center;cursor: pointer;padding: 5px">
                                        <img alt="" src="images/2019/12/19/WKFLJ.png" onclick="openURL('http://www.wkf.net')"style="width: 90%;height: 80px;margin: 0px">
                                    </div>
                                </div>
                                <div class="row" style="padding-top: 20px;">
                                    <div class="col-sm-6" style="cursor: pointer;padding: 5px">
                                        <img alt="" src="images/2019/12/19/AWHLJ.jpg" onclick="openURL('http://www.olympic.cn')"style="width: 100%;margin: 0px">
                                    </div>
                                    <div class="col-sm-6" style="cursor: pointer;padding: 5px">
                                        <img alt="" src="images/2019/12/19/TYHLJ.jpg" onclick="openURL('http://www.sport.org.cn')"style="width: 100%;margin: 0px">
                                    </div>
                                </div>
                            </div>
                            <!-- Foot right container start -->
                        </div>

                        <div class="row">
                            <div class="col-sm-12" style="text-align: center;background-color: #23282D;color: #949494;font-size: 12px;padding-top: 10px;">
                                <p>中国空手道协会 www.chncka.org  京ICP备16016752</p>
                                <p>协会地址：北京市东城区体育馆路 国家体育总局拳击跆拳道运动管理中心（国家体育总局训练局游泳馆北楼） 邮编 100061</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>

</body>

<script src="js/jquery.bootstrap.newsbox.min.js" rel="stylesheet"></script>
<script type="text/javascript">

    $.post("${pageContext.request.contextPath}/HomeNewsListServlet","",function (data) {
        var table_list = '';

        for (var i = 0; i < data.list.length; i++) {
            if(i>3)
            {break;}
            table_list +=
                '<li  class="news" data-toggle="tooltip" data-placement="bottom" title="'+data.list[i].title+'">'
           +'<a style="text-decoration: none;" href="${pageContext.request.contextPath}/ShowHomeNewsServlet?id='+data.list[i].id+'"><p style="font-weight: 400;overflow: hidden; white-space: nowrap; text-overflow: ellipsis">'+data.list[i].title+'</p></a>'
            +'</li>';
        }
        $("#news1").html(table_list);
    })

    $.post("${pageContext.request.contextPath}/HomeAssociationNewsServlet","",function (data) {
        var table_list = '';

        for (var i = 0; i < data.list.length; i++) {
            if(i>3)
            {break;}
            table_list +=
                '<li class="news" data-toggle="tooltip" data-placement="bottom" title="'+data.list[i].title+'">'
                +'<a style="text-decoration: none;" href="${pageContext.request.contextPath}/ShowHomeAssociationServlet?id='+data.list[i].id+'"><p style="font-weight: 400;overflow: hidden; white-space: nowrap; text-overflow: ellipsis">'+data.list[i].title+'</p></a>'
                +'</li>';
        }
        $("#news2").html(table_list);
    })

    $.post("${pageContext.request.contextPath}/HomeNotificationNewsServlet","",function (data) {
        var table_list = '';

        for (var i = 0; i < data.list.length; i++) {
            if(i>3)
            {break;}
            table_list +=
                '<li  class="news" data-toggle="tooltip" data-placement="bottom" title="'+data.list[i].title+'">'
                +'<a style="text-decoration: none;" href="${pageContext.request.contextPath}/ShowHomeNotificationServlet?id='+data.list[i].id+'"><p style="font-weight: 400;overflow: hidden; white-space: nowrap; text-overflow: ellipsis">'+data.list[i].title+'</p></a>'
                +'</li>';
        }
        $("#news3").html(table_list);
    })
    function eventResults() {
        $("#dcp_list").hide();
        $("#ss_list").show();
    }

    function administrationProvide() {
        $("#dcp_list").show();
        $("#ss_list").hide();
    }
    function openURL(url){
        window.open(url);
    }
</script>
</html>

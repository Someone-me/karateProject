<%--
  Created by IntelliJ IDEA.
  User: 12816
  Date: 2019/12/20
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>安徽省空手道协会</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- <link rel="stylesheet" href="css/register.css">-->
    <!--		导入jquery-->
    <script src="js/jquery-3.3.1.js"></script>
    <script src="js/bootstrap.js" rel="stylesheet"></script>

    <style>
        li {
            color: #337AB7;
            font-size: 15px;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
            list-style-type: none;
        }

        .navigation {
            color: white;
        }

        pre{
            white-space:pre-wrap;
            white-space:-moz-pre-wrap;
            white-space:-o-pre-wrap;
            word-wrap:break-word;
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
                    <li><a href="#" class="navigation">首页</a></li>
                    <li><a href="./associationIntroduce.jsp" class="navigation">关于协会</a></li>
                    <li><a href="${pageContext.request.contextPath}/NewsCenterSearchPageServlet" class="navigation">新闻中心</a></li>
                    <li><a href="${pageContext.request.contextPath}/MatchNewsCenterSearchPageServlet" class="navigation">通知公告</a></li>
                    <li><a href="${pageContext.request.contextPath}/MatchPictureShowPageServlet" class="navigation">图片</a></li>
                    <li><a href="${pageContext.request.contextPath}/VideoListServlet" class="navigation">视频</a></li>
                </ul>
            </div>
        </nav>
    </div>
    <div class="container"style="border: 6px solid grey">
        <div class="row"style="margin-top: 20px">
            <div class="col-lg-12 col-sm-12">
                <p style="font-size: 17px;font-weight: 800;white-space: nowrap;"id="title"></p>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-4 col-sm-4">
                <button type="button" class="btn btn-primary"style="margin-bottom: 6px">安徽省空协</button>
            </div>
            <div class="row col-lg-8 col-sm-8 col-lg-pull-3 col-sm-pull-2"style="margin-top: 5px;color: grey">
                <%-- <p style="margin-top: 10px">更新时间：&nbsp;</p>--%>
                <div class="col-lg-4 col-sm-4">更新时间：&nbsp;</div>
                <div class="col-lg-4 col-lg-pull-3 col-sm-4 col-sm-pull-3" id="time"></div>
            </div>
        </div>
        <div class="container">
            <div class="row"style="margin-left: 0px;margin-right: 0px;padding-top: 20px">
                <div class="col-lg-12 col-sm-12"style="padding-left: 0px;padding-right: 0px"id="image">
                    <%-- <img src=""style="width: 90%;padding-left: 20px" >--%>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12 col-sm-12"style="margin-top: 10px">
                <%--<p style="font-family: 黑体;font-size: 15px">
                    &nbsp;&nbsp;&nbsp;&nbsp;世空联K1超级联赛本赛季最后一场比赛于2019年11月29日至12月1日在西班牙马德里举行，来自87国家/地区的714名选手参加了比赛。</p>
                <p style="font-family: 黑体;font-size: 15px">
                    &nbsp;&nbsp;&nbsp;&nbsp;在女子组手-61公斤级决赛中，中国选手尹笑言以1-0战胜俄罗斯选手，摘得金牌。这是尹笑言本年度继亚锦赛和世空联K1超级联赛上海、拉巴特、萨尔茨堡站比赛后，获得的第五枚金牌，同时以积分排名第一的战绩获得2019年度世空联K1超级联赛总冠军，为本赛季画上了金色的句号。这是尹笑言在2017年获得总冠军后，再次获得了“最好中的最好”的荣誉。
                </p>--%>
                <pre id="context"></pre>
            </div>
        </div>
    </div>
    <div class="container"style="margin-top: 40px;background: #2D3237">
        <div class="row">
            <div class="col-xs-12" style="padding-top: 20px;">
                <div class="row" style="background-color: #2D3237;">
                    <div class="col-xs-12">
                        <div class="row">
                            <!-- Foot left container start -->
                            <div class="col-xs-4" style="padding: 30px;">
                                <div class="row">
                                    <div class="col-xs-12" style="color: #ffffff;font-size: 13px;font-weight: 800;border-bottom: solid 1px #666666;height: 35px;line-height: 35px;">
                                        会员服务
                                    </div>
                                </div>

                                <div class="row" style="padding-top: 20px;">
                                    <div class="col-xs-12" style="color: #ffffff;font-size: 13px;font-weight: 800;">
                                        电话：010-87101791<br>
                                    </div>
                                </div>
                                <div class="row" style="padding-top: 20px;">
                                    <div class="col-xs-12" style="color: #ffffff;font-size: 13px;font-weight: 800;">
                                        邮箱：hyfw@chinacka.org.cn<br>
                                    </div>
                                </div>

                                <div class="row" style="padding-top: 40px;">
                                    <div class="col-xs-12" style="border-bottom: solid 1px #666666;">
                                    </div>
                                </div>

                                <div class="row" style="padding-top: 5px;">
                                    <div class="col-xs-12" style="color: #ffffff;font-size: 13px;font-weight: 800;height: 35px;line-height: 35px;">

                                    </div>
                                </div>

                                <div class="row" style="padding-top: 5px;">
                                    <div class="col-xs-12" style="color: #ffffff;font-size: 13px;font-weight: 800;">
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
                            <div class="col-xs-12" style="text-align: center;background-color: #23282D;color: #949494;font-size: 12px;padding-top: 10px;">
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
<script>
    window.onload=function () {
        display();
    }
    function display() {
        $.post("${pageContext.request.contextPath}/AssociationNewsInfoServlet",{},function (data) {
            var table_list = '';

            for (var i = 0; i < data.length; i++) {
                table_list +=
                    '<img src="'+ data[i].filepath +'"style="width: 90%;padding-left: 20px" >  ';
            }
            //alert(data);
            console.log(table_list);
            $("#title").html(data[0].title);
            $("#time").html(data[0].publishTime);
            $("#image").html(table_list);
            $("#context").html(data[0].context);
        })
    }
    function openURL(url){
        window.open(url);
    }
</script>
</html>

<%@ page import="cn.anhui.karate.domain.NewsBean" %><%--
  Created by IntelliJ IDEA.
  User: 12816
  Date: 2019/12/20
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>新闻中心-安徽省空手道协会</title>
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <script src="./js/jquery-3.3.1.js"></script>
    <script src="./js/bootstrap.js" rel="stylesheet"></script>

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
                    <li><a href="./home.jsp" class="navigation">首页</a></li>
                    <li><a href="./associationIntroduce.jsp" class="navigation">关于协会</a></li>
                    <li><a href="${pageContext.request.contextPath}/NewsCenterSearchPageServlet"
                           class="navigation">新闻中心</a></li>
                    <li><a href="${pageContext.request.contextPath}/MatchNewsCenterSearchPageServlet"
                           class="navigation">通知公告</a></li>
                    <li><a href="${pageContext.request.contextPath}/MatchPictureShowPageServlet" class="navigation">图片</a></li>
                    <li><a href="${pageContext.request.contextPath}/VideoListServlet" class="navigation">视频</a></li>
                </ul>
            </div>
        </nav>
    </div>
    <div class="container">
        <div>
            <hr width="100%" style="margin-top:-5px;border:1px solid red;"/>
        </div>
        <c:forEach items="${bean.list}" var="bean" varStatus="varSta">
            <c:if test="${varSta.count%5==0}">
                <br>
                <div class="row col-lg-3 col-md-3" style="height: 290px;margin: 0px">
                    <div class="thumbnail" style="height: 240px">
                        <img src="${bean.filepath}" onclick="openURL('${bean.url}')" style="height: 186px">
                        <div class="caption" style="background: grey;padding: 0px">
                            <p style="color: white;font-weight: 400;height: 46px">${bean.title}</p>
                        </div>
                    </div>
                </div>
            </c:if>
            <c:if test="${varSta.count%5!=0}">
                <div class="col-lg-3 col-md-3" style="height: 290px;">
                    <div class="thumbnail" style="height: 240px">
                        <img src="${bean.filepath}" onclick="openURL('${bean.url}')" style="height: 186px">
                        <div class="caption" style="background: grey;padding: 0px">
                            <p style="color: white;font-weight: 400;height: 46px">${bean.title}</p>
                        </div>
                    </div>
                </div>

            </c:if>

        </c:forEach>

    </div>
    <div class="container">
        <nav aria-label="...">
            <ul class="pagination" style="float: right">
                <c:if test="${bean.currentPage==1}">
                <li class="disabled">
                    <a href="javascript:void(0);"aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                    </c:if>
                    <c:if test="${bean.currentPage!=1}">
                <li>
                    <a href="${pageContext.request.contextPath}/VideoListServlet?currentPage=${bean.currentPage-1}"aria-label="Previous">
                        <span aria-hidden="true">&laquo</span>
                    </a>
                    </c:if>
                    <c:forEach begin="1" end="${bean.totalPage}" var="page">

                        <%--判断当前页--%>
                    <c:if test="${bean.currentPage==page}">
                <li class="active">
                    <a href="javascript:void(0);">${page}</a>
                    </c:if>
                    <c:if test="${bean.currentPage!=page}">
                <li>
                    <a href="${pageContext.request.contextPath}/VideoListServlet?currentPage=${page}">${page}</a>
                    </c:if>

                    </c:forEach>

                    <c:if test="${bean.currentPage==bean.totalPage}">
                <li  class="disabled"> <a href="javascript:void(0);"aria-label="Next">
                    <span aria-hidden="true">&laquo;</span>
                </a>
                    </c:if>

                    <c:if test="${bean.currentPage!=bean.totalPage}">
                <li> <a href="${pageContext.request.contextPath}/VideoListServlet?currentPage=${bean.currentPage+1}"aria-label="Next">
                    <span aria-hidden="true">&laquo;</span>
                </a>
                    </c:if>
            </ul>
        </nav>
    </div>
    <div class="container" style="margin-top: 40px;background: #2D3237">
        <div class="row">
            <div class="col-xs-12" style="padding-top: 20px;">
                <div class="row" style="background-color: #2D3237;">
                    <div class="col-xs-12">
                        <div class="row">
                            <!-- Foot left container start -->
                            <div class="col-xs-4" style="padding: 30px;">
                                <div class="row">
                                    <div class="col-xs-12"
                                         style="color: #ffffff;font-size: 13px;font-weight: 800;border-bottom: solid 1px #666666;height: 35px;line-height: 35px;">
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
                                    <div class="col-xs-12"
                                         style="color: #ffffff;font-size: 13px;font-weight: 800;height: 35px;line-height: 35px;">

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
                                            <img alt="" src="./images/2019/12/19/wxewm.png"
                                                 style="width: 168px;height: 168px;margin-top: 30px">
                                        </div>
                                    </div>
                                </div>
                                <div class="row" style="margin-top: 10px;">
                                    <div class="col-sm-12"
                                         style="font-size: 12px;color: #ffffff;text-align: center;">
                                        扫一扫关注微信公众号
                                    </div>
                                </div>
                            </div>
                            <!-- Foot center container end -->

                            <!-- Foot right container start -->
                            <div class="col-sm-4" style="padding: 30px;">
                                <div class="row">
                                    <div class="col-lg-12 col-sm-12"
                                         style="color: #ffffff;font-size: 13px;font-weight: 800;border-bottom: solid 1px #666666;height: 35px;line-height: 35px;">
                                        友情链接
                                    </div>
                                </div>
                                <div class="row" style="padding-top: 20px;">
                                    <div class="col-sm-6 "
                                         style="height: 87px;line-height: 87px;cursor: pointer;padding: 5px">
                                        <img alt="" src="./images/2019/12/19/TYJLJ.jpg"
                                             onclick="openURL('http://www.sport.gov.cn')"
                                             style="width: 100%;margin-top: 15px;">
                                    </div>
                                    <div class="col-sm-6"
                                         style="height: 87px;line-height: 87px;text-align: center;cursor: pointer;padding: 5px">
                                        <img alt="" src="./images/2019/12/19/WKFLJ.png"
                                             onclick="openURL('http://www.wkf.net')"
                                             style="width: 90%;height: 80px;margin: 0px">
                                    </div>
                                </div>
                                <div class="row" style="padding-top: 20px;">
                                    <div class="col-sm-6" style="cursor: pointer;padding: 5px">
                                        <img alt="" src="./images/2019/12/19/AWHLJ.jpg"
                                             onclick="openURL('http://www.olympic.cn')"
                                             style="width: 100%;margin: 0px">
                                    </div>
                                    <div class="col-sm-6" style="cursor: pointer;padding: 5px">
                                        <img alt="" src="./images/2019/12/19/TYHLJ.jpg"
                                             onclick="openURL('http://www.sport.org.cn')"
                                             style="width: 100%;margin: 0px">
                                    </div>
                                </div>
                            </div>
                            <!-- Foot right container start -->
                        </div>

                        <div class="row">
                            <div class="col-sm-12"
                                 style="text-align: center;background-color: #23282D;color: #949494;font-size: 12px;padding-top: 10px;">
                                <p>中国空手道协会 www.chncka.org 京ICP备16016752</p>
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
    function openURL(url) {
        window.open(url);
    }
</script>
</html>

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

        P{
            font-weight: 500;
            font-size: 17px;
        }


        .divstyletab  li a,divstyletab  li a:link{
            font-weight: 400;
            text-align: center;
            text-decoration: none;color: #000;

        }
        .divstyletab  li a:hover{
            color: red;
        }
        #tabbable{
            padding: 0px;
            margin-left: 60px;
            margin-right: 460px;
        }
        #tabbable ul{
            padding: 10px;
        }
        #tabbable ul li{
            margin-left: 30px;
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
                    <li><a href="${pageContext.request.contextPath}/NewsCenterSearchPageServlet" class="navigation">新闻中心</a></li>
                    <li><a href="${pageContext.request.contextPath}/MatchNewsCenterSearchPageServlet" class="navigation">通知公告</a></li>
                    <li><a href="${pageContext.request.contextPath}/MatchPictureShowPageServlet" class="navigation">图片</a></li>
                    <li><a href="${pageContext.request.contextPath}/VideoListServlet" class="navigation">视频</a></li>
                </ul>
            </div>
        </nav>
    </div>
    <div class="container">
        <div class="row notice" id="notice">
            <div id="myTab" class="col-lg-2 col-sm-2 myTab" style="height: 550px;background: #F4F4F4;padding: 0px">
                <ul class="nav nav-pills nav-stacked nav-pills-stacked-example" style="margin-top: 100px">
                    <li class="introduction" >
                        <a href="#introduction">协会介绍</a>
                    </li>
                    <li class="organization">
                        <a href="#organization">机构设置</a>
                    </li>
                    <li class="constitution">
                        <a href="#constitution">协会章程</a>
                    </li>
                    <li class="relation">
                        <a href="#relation">联系我们</a>
                    </li>
                </ul>
            </div>

            <div class="tab-content col-lg-10">
                <!--1-->
                <div class="tab-pane active" id="introduction"style="margin-left: 100px;margin-top: 60px">
                    <div class="tabbable" >
                        <br />
                        <p>中国空手道协会——简称“中国空协”。</p>

                        <p>英文名称：CHINESE KARATE ASSOCIATION；</p>
                        <p>英文缩写：CKA</p>
                        <br />
                        <p>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;中国空协由全国各省、自治区、直辖市、行业体协空手道协会、解放军所属体育运动组织、其它合法空手道社会团体、体育院校以及爱好空手道运动的个人自愿组成，是专业性、全国性、非营利性的社会组织。
                        </p>
                        <p>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;中国空协宗旨：遵守国家宪法、法律、法规和有关政策，团结全国空手道工作者、运动员和空手道爱好者，推广和普及空手道运动，增强全民族身体素质，丰富群众文化生活，为社会主义物质文明和精神文明建设服务；提高空手道运动技术水平，攀登世界空手道高峰，为国争光；增进同各国家（地区）空手道运动员的友谊，加强与世界空手道联盟和亚洲空手道联盟等国际体育组织的联系与合作。
                        </p>
                    </div>
                </div>
                <!-- 2 -->
                <div class="tab-pane" id="organization">
                    <div class="tabbable"id="tabbable" >
                        <ul class="row divstyletab" style="background: #F4F4F4;">
                            <li class="active col-lg-3"><a href="#tab21" >组织机构</a></li>
                            <li class="col-lg-3" style="margin-left: 20px"><a href="#tab22" >协会领导</a></li>
                            <li class="col-lg-3" style="margin-left: 20px"><a href="#tab23" >部门介绍</a></li>
                        </ul>
                        <div class="tab-content">
                            <!-- 第一个tab -->
                            <div class="tab-pane fade active in" id="tab21">
                                <img src="images/2019/12/20/zuzhijigou.jpg">
                            </div>
                            <!-- 第二个tab -->
                            <div class="tab-pane fade" id="tab22" style="padding: 20px;margin-left: 40px">
                                <br />
                                <p>主席：管建民</p>
                                <p>副主席：刘吉平    刘晓辉</p>
                                <p>秘书长：袁永清</p>
                            </div>
                            <!-- 第三个tab -->
                            <div class="tab-pane fade" id="tab23"style="padding: 20px">
                                <br />
                                <p style="font-weight: bold;">秘书处</p>
                                <p>联系电话：010-67163721/67129261</p>
                                <p>负责协会党建、行政、人事、财务、文秘和国家队服务等工作。</p>
                                <p>李珂珂（副部长）</p>
                                <br/>
                                <p style="font-weight: bold;">外事部</p>
                                <p>联系电话：010-67175631</p>
                                <p>负责国家队出访，相关国际组织联络、国家协会交流等工作。</p>
                                <p>赵光茹（部长）</p>
                                <br/>
                                <p style="font-weight: bold;">竞赛部</p>
                                <p>联系电话：010-67125331</p>
                                <p>负责全国竞赛体系建设；竞赛管理相关制度建设；赛事运营管理；运动员和裁判员的注册、赛风赛纪监管等工作。</p>
                                <br/>
                                <p style="font-weight: bold;">会员部</p>
                                <p>联系电话：010-87188971</p>
                                <p>负责全国会员管理体系建设；拟定协会会员管理政策制度；会员管理和服务等工作。</p>
                                <p>苏伟（副部长）</p>
                            </div>
                            <!-- 中间图表结束 -->
                        </div>
                    </div>
                </div>
                <!-- 3 -->
                <div class="tab-pane" id="constitution">
                    <div class="tabbable" style="margin-left: 60px;margin-top: 20px">
                        <br />
                        <p  align="center" style="font-weight:bold;">第一章  总则</p>
                        <p>第一条  本团体名称为“中国空手道协会”，简称“中国空协”。英文名称：CHINESE  KARATEDO  ASSOCIATION；英文缩写：CKA。</p>
                        <p>第三条  本团体的宗旨是：遵守国家宪法、法律、法规和有关政策，团结全国空手道工作者、运动员和空手道爱好者，推广和普及空手道运动，增强全民族身体素质，丰富群众文化生活，为社会主义物质文明和精神文明建设服务；提高空手道运动技术水平，攀登世界空手道高峰，为国争光；增进同各国家（地区）空手道运动员的友谊，加强与世界空手道联盟（以下简称世空联）和亚洲空手道联盟（以下简称亚空联）等国际体育组织的联系与合作。</p>
                        <p>第四条  本团体接受社团登记管理机关中华人民共和国民政部、业务主管单位国家体育总局的业务指导和监督管理。</p>
                        <p>第五条  本团体的总部设在北京市崇文区体育馆路2号（国家体育总局拳击跆拳道运动管理中心院内）。</p>
                        <p  align="center" style="font-weight:bold;">第二章  业务范围</p>
                        <p>第六条  本团体的业务范围</p>
                        <p>（一）宣传和普及空手道运动，推动群众性空手道运动的开展，通过组织广大群众和青少年参加空手道运动，增强人民群众的体质和提高空手道运动技术水平；</p>
                        <p>（二）研究、拟定空手道运动发展战略；</p>
                        <p>（三）按照国家体育行政部门和国际体育组织的有关规定，负责举办国际性竞赛，向有关部门提出国际活动有关事项的建议，获批准后负责全面实施。促进国际交流，增进与其他国家和地区空手道协会的友谊；</p>
                        <p>（四）负责协调、组织全国性各类、各级空手道竞赛和训练工作，加强协会、道馆、俱乐部之间的联系与交流，增进运动员、空手道工作者之间的团结和友谊；</p>
                        <p>（五）负责协调组织培训教练员、裁判员、运动员工作；</p>
                        <p>（六）根据国家体育行政部门和中华全国体育总会、中国奥委会的有关规定选拔和推荐国家队教练员和运动员，负责组织国家队、国家青年队和国家青少年队的集训工作及参加国际空手道比赛；</p>
                        <p>（七）受国家体育行政部门委托，开展以下活动:</p>
                        <p>1.负责空手道各类外事活动以及教练员出国任教的选拔、运动员个人到境外训练、比赛的归口管理工作；</p>
                        <p>2.制订空手道项目的竞赛制度、竞赛规程、裁判法、教练员、运动员和裁判员管理制度、段位考试与审批及俱乐部管理办法等，报国家体育行政部门审批后实施；</p>
                        <p>3.制订运动员、教练员、裁判员技术等级制度，负责运动员资格的审查和空手道运动的大众传播媒体的管理工作。</p>
                        <p>（八）负责协调和组织空手道运动的科学研究工作；</p>
                        <p>（九）对全国各类空手道的培训活动、道馆（场）、俱乐部等进行业务指导服务。</p>
                        <p  align="center" style="font-weight:bold;">第三章  会员</p>
                        <p>第七条  本团体的会员种类：单位会员和个人会员。</p>
                        <p>本团体可接纳各省、自治区、直辖市、计划单列市、各体育院校、行业体协、解放军体育组织和其它经体育行政主管部门认可的，具有合法地位的空手道运动群众组织、社会团体和体育院校为单位会员；对于热心支持中国空手道事业发展，爱好空手道运动的个人，可接纳为本团体个人会员。</p>
                        <p>第八条  申请加入本团体的单位和个人会员，必须具备下列条件：</p>
                        <p>（一）拥护本团体的章程</p>
                        <p>（二）有加入本团体的意愿；</p>
                        <p>（三）在本团体的业务领域内具有一定作用；</p>
                        <p>（四）单位会员必须为地方体育行政主管部门和地方社团登记部门审批后，具有合法地位的从事空手道运动的群众组织和团体</p>
                        <p>第九条  会员入会的程序是：</p>
                        <p>（一）提交入会申请书；</p>
                        <p>（二）经执委会讨论通过；</p>
                        <p>（三）由执委会或执委会授权的机构发给会员证。</p>
                        <p>第十条  会员享有下列权利：</p>
                        <p>（一）本团体的选举权、被选举权和表决权；</p>
                        <p>（二）参加本团体的活动；</p>
                        <p>（三）获得本团体服务的优先权；</p>
                        <p>（四）对本团体工作的批评建议权和监督权；</p>
                        <p>（五）入会自愿、退会自由。</p>
                        <p>第十一条  会员履行下列义务：</p>
                        <p>（一）执行本团体的决议；</p>
                        <p>（二）维护本团体的合法权益；</p>
                        <p>（三）完成本团体交办的工作；</p>
                        <p>（四）按规定交纳会费；</p>
                        <p>（五）向本团体反映情况，提供有关资料；</p>
                        <p>（六）单位会员应当上报年度工作计划和总结报告。</p>
                        <p>第十二条  会员退会应书面通知本团体，并交回会员证。会员如果一年不交纳会费或不参加本团体活动的，视为自动退会。</p>
                        <p>第十三条  会员如有严重违反本章程的行为，由本团体执委会或常务执委会表决通过后，予以除名</p>
                        <p  align="center" style="font-weight:bold;">第四章  组织机构及其职责</p>
                        <p>
                            第十四条  本团体的最高权力机构是会员代表大会。会员代表由会员协商、推荐或选举产生，单位会员的法定代表人为该单位的会员代表人选。会员代表大会每四年举行一次，须有2/3以上的会员代表出席才能召开；其决议须经到会会员代表半数以上表决通过才能生效。
                        </p>
                        <p>第十五条  会员代表大会的职责如下：</p>
                        <p>（一）制定和修改章程；</p>
                        <p>（二）听取和审议本团体的工作报告；</p>
                        <p>（三）审议本团体的财务预决算报告；</p>
                        <p>（四）讨论通过有关提案决议；</p>
                        <p>（五）选举本团体负责人；</p>
                        <p>（六）选举产生执委会组成人员；</p>
                        <p>（七）制订和修改会费标准；</p>
                        <p>（八）决定本团体的中止事宜；</p>
                        <p>（九）决定其它重大事宜。</p>
                        <p>第十六条  本团体的执委会是会员代表大会闭会期间的执行机构，在闭会期间领导本团体工作，向会员代表大会负责。</p>
                        <p>第十七条  本团体的执行委员会由主席、副主席、秘书长、及执行委员（以下简称执委）组成。</p>
                        <p>第十八条  执委会的职责：</p>
                        <p>（一）执行会员代表大会的决议；</p>
                        <p>（二）选举和罢免主席、副主席、秘书长；选举和罢免常务执委；</p>
                        <p>（三）筹备召开会员代表大会；</p>
                        <p>（四）向会员代表大会报告工作和财务状况；</p>
                        <p>（五）决定会员的吸收和除名；</p>
                        <p>（六）决定设立办事机构、分支机构、代表机构和实体机构；</p>
                        <p>（七）决定副秘书长、各机构主要负责人的聘任；</p>
                        <p>（八）领导社团各机构开展工作；</p>
                        <p>（九）制定内部管理制度；</p>
                        <p>（十）决定本团体工作任务和工作方针；</p>
                        <p>（十一）决定其它重要事项。</p>
                        <p>第十九条  执委会须有2/3以上的执委会组成人员出席方能召开，其决议须经2/3以上与会者表决通过方能生效。执委会每年召开一次会议，情况特殊也可采取通讯形式召开。</p>
                        <p>第二十条  本团体设常务执委会,常务执委会由执委会选举产生,在执委会闭会期间行使第十八条第一、三、五、七、八、九项的职权，对执委会负责（常务执委人数不超过执委人数的1/3）。</p>
                        <p>第二十一条  常务执委会须有2/3以上的常务执委出席方能召开，其决议须经2/3以上与会者表决通过方能生效。常务执委会每半年召开一次会议，情况特殊也可采取通讯形式召开。</p>
                        <p>第二十二条  本团体的主席、副主席、秘书长必须具备下列条件：</p>
                        <p>（一）坚持党的路线、方针、政策，政治素质好；</p>
                        <p>（二）在本团体业务领域内有较大影响；</p>
                        <p>（三）主席、副主席、秘书长最高任职年龄不超过70岁，秘书长为专职；</p>
                        <p>（四）身体健康，能坚持正常工作；</p>
                        <p>（五）未受过剥夺政治权利的刑事处罚；</p>
                        <p>（六）具有完全民事行为能力。</p>
                        <p>第二十三条  本团体的主席、副主席、秘书长如超过最高任职年龄的，须经执委会表决通过，报业务主管部门审查并经社团登记管理机关批准同意后，方可任职。</p>
                        <p>第二十四条  本团体的主席、副主席、秘书长、执委任期四年。主席、副主席、秘书长任期最长不超过两届，因特殊情况需延长任期的，须经会员代表大会2/3以上会员代表表决通过，报业务主管单位审查并经社团登记管理机关批准同意后方可任职。</p>
                        <p>第二十五条  本团体秘书长为本团体法定代表人，法定代表人代表本团体签署有关重要文件；本团体法定代表人不兼任其他团体的法定代表人。</p>
                        <p>第二十六条  本团体主席行使下列职权：</p>
                        <p>（一）召集和主持执委会；</p>
                        <p>（二）检查会员代表大会、执委会决议的落实情况；</p>
                        <p>第二十七条  本团体秘书长行使下列职权：</p>
                        <p>（一）主持秘书处开展日常工作，组织落实年度工作计划；</p>
                        <p>（二）协调各分支机构、代表机构、实体机构开展工作；</p>
                        <p>（三）提名副秘书长以及各分支机构、代表机构和实体机构的主要负责人，交执委会或常务执委会决定；</p>
                        <p>（四）决定分支机构、代表机构、实体机构专职工作人员的聘任；</p>
                        <p>（五）处理其他日常事务。</p>
                        <p  align="center" style="font-weight:bold;">第五章  负责人产生与罢免的程序</p>
                        <p>第二十八条  本团体设主席、副主席若干、秘书长、执委若干和司库，司库由秘书长兼任。</p>
                        <p>第二十九条  单位会员或代表单位推选的社团领导人，实行部门单位代表制，随人员工作的变化而变动。其人员调整由代表单位推荐出人选，经本团体执委会讨论通过后报业务主管单位审批，并报社团登记管理机关备案。</p>
                        <p  align="center" style="font-weight:bold;">第六章  资产管理和使用原则</p>
                        <p>第三十条  本团体主要经费来源</p>
                        <p>（一）政府资助；</p>
                        <p>（二）捐赠；</p>
                        <p>（三）会费；</p>
                        <p>（四）在核准的业务范围内开展活动或服务的收入</p>
                        <p>（五）利息；</p>
                        <p>（六）其他合法收入。</p>
                        <p>第三十一条  本团体按照国家规定收取会员费。</p>
                        <p>第三十二条  本团体经费必须用于本章程规定的业务范围和事业的发展，不得在会员中分配。</p>
                        <p>第三十三条  本团体建立严格的财务管理制度，保证会计资料合法、真实、准确、完整。</p>
                        <p>第三十四条  本团体配备具有专业资格的会计人员。会计不得兼任出纳。会计人员必须进行会计核算，实行会计监督。会计人员调动或离职时，必须与接管人员办理清交手续。</p>
                        <p>第三十五条  本团体的资产管理必须执行国家规定的财务管理制度，接受会员代表大会和财政部门的监督。资产来源属于国家拨款或者社会捐赠、资助的，必须接受审计机关的监督，并将有关情况以适当方式向社会公布。</p>
                        <p>第三十六条  本团体换届或更换法定代表人之前必须接受社团登记管理机关和业务主管单位组织的财务审计。</p>
                        <p>第三十七条  本团体的资产任何单位、个人不得侵占、私分和挪用。</p>
                        <p>第三十八条  本团体专职工作人员的工资和保险、福利待遇，参照国家对事业单位的有关规定执行。</p>
                        <p  align="center" style="font-weight:bold;">第七章   会旗、会徽、知识产权</p>
                        <p>第三十九条  本团体的会旗、会徽、标识及相关知识产权由会员代表大会审定颁布，属本团体独有财产，未经本团体的批准，任何单位和个人不得以任何方式擅自使用、复制或用于商业活动。有关批准使用本团体会旗等的规定另行制定。</p>
                        <p  align="center" style="font-weight:bold;">第八章         章程的修改程序</p>
                        <p>第四十条  对本团体章程的修改，须经执委会表决通过后报会员代表大会审议。</p>
                        <p>第四十一条  本团体修改的章程，须在会员代表大会通过后15日内，报业务主管部门同意，并报社团登记管理机关核准后生效。</p>
                        <p align="center" style="font-weight:bold;">第九章  终止程序及终止后的财产处理</p>
                        <p>第四十二条  本团体完成宗旨或自行解散或由于分立、合并等原因需要注销的，由执委会提出终止动议。</p>
                        <p>第四十三条  本团体终止动议须经会员代表大会表决通过，并报业务主管部门审查同意。</p>
                        <p>第四十四条  本团体终止前，须在业务主管单位及有关机关指导下成立清算组织，清理债权债务，处理善后事宜。清算期间，不开展清算以外的活动。</p>
                        <p>第四十五条  本团体经社团登记管理机关办理注销登记手续后即为终止。</p>
                        <p>第四十六条  本团体终止后的剩余财产，在业务主管部门和社团登记机关的监督下，按照国家有关规定，用于发展与本团体宗旨相关的事业。</p>
                        <p align="center" style="font-weight:bold;">第十章  附则</p>
                        <p>第四十七条  本章程由2008年12月9日第一届会员代表大会审议通过。</p>
                        <p>第四十七条  本章程由2008年12月9日第一届会员代表大会审议通过。</p>
                        <p>第四十九条  本章程自社团登记管理机关核准之日起生效。</p>
                    </div>
                </div>

                <%--4--%>
                <div class="tab-pane" id="relation">
                    <div class="tabbable" style="margin-left: 60px;margin-top: 20px">
                        <br />
                        <p>秘书处：010-67129261</p>
                        <br />
                        <p>外联部：010-67175631</p>
                        <br />
                        <p>竞赛部：010-67125331</p>
                        <br />
                        <p>会员部：010-87188971</p>
                        <br />
                        <p>通讯地址：北京市东城区体育馆路</p>
                    </div>
                </div>
                <!-- tab end -->
            </div>
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

</div>

</body>
<script type="text/javascript">
    $(function() {
        $('#myTab a').click(function (e) {
            e.preventDefault();
            $(this).tab('show');
        });
        $('.divstyletab a').click(function (e) {
            e.preventDefault();
            $(this).tab('show');
        });
    });
    function openURL(url){
        window.open(url);
    }
</script>
</html>

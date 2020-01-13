package servlet.groupInformation;

import cn.RefereeScore.personalTypeRefereeScore;
import cn.groupInformation.grouping;
import cn.playerInformation.playerInfoCombine;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.RefereeScore.personalTypeRefereeScoreSql;
import domain.groupInformation.addGroupNumberSql;
import domain.groupInformation.addPlayerInfoSql;
import domain.groupInformation.personalTypeReScoreSql;
import org.junit.Test;
import service.groupInfomationService.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@WebServlet("/groupInformationServlet")
public class groupInformationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type=request.getParameter("type");
        String level=request.getParameter("level");
        String typenumber=request.getParameter("typenumber");

        domain.playerInformation.playInfomationSql Player= new domain.playerInformation.playInfomationSql();
        List<playerInfoCombine> playInfo=Player.PInfoFindPlayer();

        if(typenumber.equals("第一套型"))
        {
            //把选手信息添加到评分表中
            addPlayerInfoSql cinfo=new addPlayerInfoSql();
            cinfo.addPlayerInfo();

            firstTypeGroupInfo first=new firstTypeGroupInfo();
            //找出相同类别的选手
            List<playerInfoCombine> info=first.classification_one(playInfo,type,level);

//            分组
            List<grouping> group=first.group(info);

            //添加组号
            addGroupNumberSql ad=new addGroupNumberSql();
            ad.addGroupNumber(group,"第一套型");

            ObjectMapper mapper=new ObjectMapper();
            mapper.writeValue(response.getOutputStream(),group);
        }
        else if(typenumber.equals("第二套型")){

            personalTypeReScoreSql info=new personalTypeReScoreSql();
            //演练完第一套型的所查询类别的选手
            List<personalTypeRefereeScore>  Info=info.findEquallyPlayer("第一套型",type,level);

            //给演练完的选手，晋级判断，且分组。
            secondTypeGroupInfo second=new secondTypeGroupInfo();
            List<grouping> info_two=second.classification_two(Info);

            //把晋级的选手信息添加到评分表中
            addPlayerInfoSql cinfo=new addPlayerInfoSql();
            cinfo.addPlayerInfo_other(info_two,"第二套型");

            //添加组号。
            addGroupNumberSql ad=new addGroupNumberSql();
            ad.addGroupNumber(info_two,"第二套型");

            sort(info_two);

            ObjectMapper mapper=new ObjectMapper();
            mapper.writeValue(response.getOutputStream(),info_two);
        }else if(typenumber.equals("第三套型"))
        {
            personalTypeReScoreSql info=new personalTypeReScoreSql();
            //演练完第一套型的所查询类别的选手
            List<personalTypeRefereeScore>  Info=info.findEquallyPlayer("第二套型",type,level);

            thirdTypeGroupInfo third=new thirdTypeGroupInfo();
            List<grouping> info_third=third.classification_third(Info);

            //把晋级的选手信息添加到评分表中
            addPlayerInfoSql cinfo=new addPlayerInfoSql();
            cinfo.addPlayerInfo_other(info_third,"第三套型");

            //添加组号。
            addGroupNumberSql ad=new addGroupNumberSql();
            ad.addGroupNumber(info_third,"第三套型");

            //返回数据
            ObjectMapper mapper=new ObjectMapper();
            mapper.writeValue(response.getOutputStream(),info_third);
        }else if(typenumber.equals("第四套型"))
        {
            personalTypeReScoreSql info=new personalTypeReScoreSql();
            //演练完第一套型的所查询类别的选手
            List<personalTypeRefereeScore>  Info=info.findEquallyPlayer("第三套型",type,level);

            fourthTypeGroupInfo fourth=new fourthTypeGroupInfo();
            List<grouping> info_fourth=fourth.classification_fourth(Info);

            //把晋级的选手信息添加到评分表中
            addPlayerInfoSql cinfo=new addPlayerInfoSql();
            cinfo.addPlayerInfo_other(info_fourth,"第四套型");

            //添加组号。
            addGroupNumberSql ad=new addGroupNumberSql();
            ad.addGroupNumber(info_fourth,"第四套型");

            //返回数据
            ObjectMapper mapper=new ObjectMapper();
            mapper.writeValue(response.getOutputStream(),info_fourth);
        }else if(typenumber.equals("第五套型"))
        {
            personalTypeReScoreSql info=new personalTypeReScoreSql();
            //演练完第一套型的所查询类别的选手
            List<personalTypeRefereeScore>  Info=info.findEquallyPlayer("第四套型",type,level);

            fifthTypeGroupInfo fifth=new fifthTypeGroupInfo();
            List<grouping> info_fifth=fifth.classification_fifth(Info);

            //把晋级的选手信息添加到评分表中
            addPlayerInfoSql cinfo=new addPlayerInfoSql();
            cinfo.addPlayerInfo_other(info_fifth,"第五套型");

            //添加组号。
            addGroupNumberSql ad=new addGroupNumberSql();
            ad.addGroupNumber(info_fifth,"第五套型");

            //返回数据
            ObjectMapper mapper=new ObjectMapper();
            mapper.writeValue(response.getOutputStream(),info_fifth);
        }
        else {
            ObjectMapper mapper=new ObjectMapper();
            mapper.writeValue(response.getOutputStream(),null);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }

    @Test
    public void test()
    {
        domain.playerInformation.playInfomationSql Player= new domain.playerInformation.playInfomationSql();
        List<playerInfoCombine> playInfo=Player.PInfoFindPlayer();

        String type="个人型";
        String level="男子成年组(18岁以上)";

        personalTypeReScoreSql info=new personalTypeReScoreSql();
        //演练完第一套型的所查询类别的选手
        List<personalTypeRefereeScore>  Info=info.findEquallyPlayer("第一套型",type,level);

        //给演练完的选手，晋级判断，且分组。
        secondTypeGroupInfo second=new secondTypeGroupInfo();
        List<grouping> info_two=second.classification_two(Info);

        //把晋级的选手信息添加到评分表中
        addPlayerInfoSql cinfo=new addPlayerInfoSql();
        cinfo.addPlayerInfo_other(info_two,"第二套型");

        //添加组号。
        addGroupNumberSql ad=new addGroupNumberSql();
        ad.addGroupNumber(info_two,"第二套型");

        sort(info_two);

        System.out.println(info_two);
//        String type="个人型";
////        String level="男子成年组(18岁以上)";
////        String sex="男";
////        domain.playerInformation.playInfomationSql Player= new domain.playerInformation.playInfomationSql();
////        List<playerInfoCombine> playInfo=Player.PInfoFindPlayer();
////        List<playerInfoCombine> info=classification_one(playInfo,type,level,sex);
////
////        List<grouping> group=group(info);
////
////        addGroupNumberSql ad=new addGroupNumberSql();
////        ad.addGroupNumber(group);
    }

    public void sort(List<grouping> info_two)
    {
        Collections.sort(info_two, new Comparator<grouping>() {

            @Override
            public int compare(grouping o1, grouping o2) {

                if(o1.getGroup()>o2.getGroup())
                {
                    return 1;
                }
                if(o1.getGroup()==o2.getGroup())
                {
                    return 0;
                }
                return -1;
            }
        });
    }

}

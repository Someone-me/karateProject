package service.groupInfomationService;

import cn.groupInformation.grouping;
import cn.playerInformation.playerInfoCombine;

import java.util.ArrayList;
import java.util.List;

public class firstTypeGroupInfo {

    //找出第一套型相同类别的比赛选手
    public List<playerInfoCombine> classification_one(List<playerInfoCombine> playInfo , String type, String level)
    {
        List<playerInfoCombine> info=new ArrayList<>();


        for (int i=0;i<playInfo.size();i++)
        {
            if(playInfo.get(i).getLevelType().equals(type)&&playInfo.get(i).getLevel().equals(level))
            {
                info.add(playInfo.get(i));
            }
        }
        return info;
    }


    //第一套型分组
    public List<grouping> group(List<playerInfoCombine> info)
    {
        List<grouping> groupings=new ArrayList<>();
        int Leng=info.size();
        int k=1;   //组号
        if (Leng<3)
        {
            int n=3;
            groupings=Group1(info,n);
        }
        else if(Leng==4)
        {
            int n=2;
            groupings=Group1(info,n);
        }
        else if(Leng>=5&&Leng<=11)
        {
            int n=0;
            if(info.size()%2==0)
            {
                n=info.size()/2;
            }
            else {
                n=info.size()/2+1;
            }
            groupings=Group1(info,n);
        }
        else if(Leng>=12&&Leng<=24)
        {
            int n;
            if(info.size()%2==0)
            {
                n=info.size()/2;
            }
            else {
                n=info.size()/2+1;
            }
            groupings=Group1(info,n);
        }
        else if(Leng>=25&&Leng<=48)
        {
            int n,m,q;
            q=0;        //标识选手多的组
            n=Leng/4;   //每组选手人数计算
            m=Leng%4;   //共有几个组人数等于n+1

            groupings=Group2(info,m,n,q);
        }
        else if(Leng>=49&&Leng<=96)
        {
            int n,m,q;
            q=0;        //标识选手多的组
            n=Leng/8;   //每组选手人数计算
            m=Leng%8;   //共有几个组人数等于n+1

            groupings=Group2(info,m,n,q);
        }
        else if(Leng>=97)
        {
            int n,m,q;
            q=0;        //标识选手多的组
            n=Leng/16;   //每组选手人数计算
            m=Leng%16;   //共有几个组人数等于n+1

            groupings=Group2(info,m,n,q);
        }
        return groupings;
    }
    //第一套型分组
    public List<grouping> Group1(List<playerInfoCombine> info,int n)
    {
        int k=1;
        List<grouping> groupings=new ArrayList<>();
        for (int i=0;i<info.size();i++)
        {
            if(i==n)
            {
                k=k+1;
            }
            grouping group=new grouping();
            group.setGroup(k);
            group.setPlayername(info.get(i).getPlayerName());
            group.setPlayerId(info.get(i).getPlayerIdCrad());

            groupings.add(group);
        }
        return groupings;
    }
    //第一套型分组
    public List<grouping> Group2(List<playerInfoCombine> info,int m,int n,int q)
    {
        int k=1;

        List<grouping> groupings=new ArrayList<>();

        for (int i=0;i<info.size();i++)
        {
            if(q<m)
            {
                n=n+1;
            }
            if(i%n==0)
            {
                k=k+1;
                q++;
            }
            grouping group=new grouping();
            group.setGroup(k);
            group.setPlayername(info.get(i).getPlayerName());
            group.setPlayerId(info.get(i).getPlayerIdCrad());

            groupings.add(group);
        }
        return groupings;
    }

}

package service.groupInfomationService;

import cn.RefereeScore.personalTypeRefereeScore;
import cn.groupInformation.grouping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class thirdTypeGroupInfo {

    public List<grouping> classification_third(List<personalTypeRefereeScore> info)
    {
        List<grouping> groupings=new ArrayList<>();
        grouping group=new grouping();
        //分为两组的选手信息
        List<personalTypeRefereeScore> group1=new ArrayList<>();
        List<personalTypeRefereeScore> group2=new ArrayList<>();
        List<personalTypeRefereeScore> group3=new ArrayList<>();
        List<personalTypeRefereeScore> group4=new ArrayList<>();
        List<personalTypeRefereeScore> group5=new ArrayList<>();
        List<personalTypeRefereeScore> group6=new ArrayList<>();
        List<personalTypeRefereeScore> group7=new ArrayList<>();
        List<personalTypeRefereeScore> group8=new ArrayList<>();

        System.out.println(info.size());

        if(info.size()==8)
        {
            group_number_two(info,group1,group2);

            medalsCompetition(groupings,group1,group2);
            return groupings;
        }else if(info.size()==16)
        {
            for(int i=0;i<info.size();i++)
            {
                switch ((int) info.get(i).getResult())
                {
                    case 1:group1.add(info.get(i));
                    case 2:group2.add(info.get(i));
                    case 3:group3.add(info.get(i));
                    case 4:group4.add(info.get(i));
                }
            }
            sort(group1);
            sort(group2);
            sort(group3);
            sort(group4);

            for(int i=0;i<4;i++)
            {
                grouping Group1=new grouping();
                Group1.setGroup(1);
                Group1.setPlayername(group1.get(i).getPlayerId());
                Group1.setPlayerId(group1.get(i).getPlayerIdcard());
                groupings.add(Group1);

                grouping Group2=new grouping();
                Group2.setGroup(1);
                Group2.setPlayername(group2.get(i).getPlayerId());
                Group2.setPlayerId(group2.get(i).getPlayerIdcard());
                groupings.add(Group2);

                grouping Group3=new grouping();
                Group3.setGroup(2);
                Group3.setPlayername(group3.get(i).getPlayerId());
                Group3.setPlayerId(group3.get(i).getPlayerIdcard());
                groupings.add(Group3);

                grouping Group4=new grouping();
                Group4.setGroup(2);
                Group4.setPlayername(group4.get(i).getPlayerId());
                Group4.setPlayerId(group4.get(i).getPlayerIdcard());
                groupings.add(Group4);
            }
            return groupings;
        }else if(info.size()==32)
        {
            for(int i=0;i<info.size();i++)
            {
                switch ((int) info.get(i).getResult())
                {
                    case 1:group1.add(info.get(i));
                    case 2:group2.add(info.get(i));
                    case 3:group3.add(info.get(i));
                    case 4:group4.add(info.get(i));
                    case 5:group5.add(info.get(i));
                    case 6:group6.add(info.get(i));
                    case 7:group7.add(info.get(i));
                    case 8:group8.add(info.get(i));
                }
            }

            for(int i=0;i<4;i++)
            {
                grouping Group1=new grouping();
                Group1.setGroup(1);
                Group1.setPlayername(group1.get(i).getPlayerId());
                Group1.setPlayerId(group1.get(i).getPlayerIdcard());
                groupings.add(Group1);

                grouping Group2=new grouping();
                Group2.setGroup(1);
                Group2.setPlayername(group2.get(i).getPlayerId());
                Group2.setPlayerId(group2.get(i).getPlayerIdcard());
                groupings.add(Group2);

                grouping Group3=new grouping();
                Group3.setGroup(2);
                Group3.setPlayername(group3.get(i).getPlayerId());
                Group3.setPlayerId(group3.get(i).getPlayerIdcard());
                groupings.add(Group3);

                grouping Group4=new grouping();
                Group4.setGroup(2);
                Group4.setPlayername(group4.get(i).getPlayerId());
                Group4.setPlayerId(group4.get(i).getPlayerIdcard());
                groupings.add(Group4);

                grouping Group5=new grouping();
                Group5.setGroup(3);
                Group5.setPlayername(group5.get(i).getPlayerId());
                Group5.setPlayerId(group5.get(i).getPlayerIdcard());
                groupings.add(Group5);

                grouping Group6=new grouping();
                Group6.setGroup(3);
                Group6.setPlayername(group6.get(i).getPlayerId());
                Group6.setPlayerId(group6.get(i).getPlayerIdcard());
                groupings.add(Group6);

                grouping Group7=new grouping();
                Group7.setGroup(4);
                Group7.setPlayername(group7.get(i).getPlayerId());
                Group7.setPlayerId(group7.get(i).getPlayerIdcard());
                groupings.add(Group7);

                grouping Group8=new grouping();
                Group8.setGroup(4);
                Group8.setPlayername(group8.get(i).getPlayerId());
                Group8.setPlayerId(group8.get(i).getPlayerIdcard());
                groupings.add(Group8);
            }
            return groupings;

        }else
        {
            return null;
        }
    }
    //奖牌赛分组
    public void medalsCompetition(List<grouping> groupings,List<personalTypeRefereeScore> group1,List<personalTypeRefereeScore> group2)
    {
        grouping Group1=new grouping();
        Group1.setGroup(1);
        Group1.setPlayername(group1.get(0).getPlayerId());
        Group1.setPlayerId(group1.get(0).getPlayerIdcard());
        groupings.add(Group1);

        grouping Group2=new grouping();
        Group2.setGroup(1);
        Group2.setPlayername(group2.get(0).getPlayerId());
        Group2.setPlayerId(group2.get(0).getPlayerIdcard());
        groupings.add(Group2);

        grouping Group3=new grouping();
        Group3.setGroup(2);
        Group3.setPlayername(group1.get(1).getPlayerId());
        Group3.setPlayerId(group1.get(1).getPlayerIdcard());
        groupings.add(Group3);

        grouping Group4=new grouping();
        Group4.setGroup(2);
        Group4.setPlayername(group2.get(2).getPlayerId());
        Group4.setPlayerId(group2.get(2).getPlayerIdcard());
        groupings.add(Group4);

        grouping Group5=new grouping();
        Group5.setGroup(3);
        Group5.setPlayername(group1.get(2).getPlayerId());
        Group5.setPlayerId(group1.get(2).getPlayerIdcard());
        groupings.add(Group5);

        grouping Group6=new grouping();
        Group6.setGroup(3);
        Group6.setPlayername(group2.get(1).getPlayerId());
        Group6.setPlayerId(group2.get(1).getPlayerIdcard());
        groupings.add(Group6);
    }


    //第一套型只有两组的情况下把两组的人的信息分别分组，并排序
    public void group_number_two(List<personalTypeRefereeScore> info,List<personalTypeRefereeScore> group1,List<personalTypeRefereeScore> group2)
    {
        for(int i=0;i<info.size();i++)
        {
            if(info.get(i).getStatus()==1)
            {
                group1.add(info.get(i));
            }else if(info.get(i).getStatus()==2)
            {
                group2.add(info.get(i));
            }
        }
        sort(group1);
        sort(group2);
    }
    //根据总分降序排序
    public void sort(List<personalTypeRefereeScore> Info)
    {
        Collections.sort(Info, new Comparator<personalTypeRefereeScore>() {

            @Override
            public int compare(personalTypeRefereeScore o1, personalTypeRefereeScore o2) {

                if(o1.getResult()>o2.getResult())
                {
                    return 1;
                }
                if(o1.getResult()==o2.getResult())
                {
                    return 0;
                }
                return -1;
            }
        });
    }
}

package service.juryPanelService;

import cn.juryPanel.juryPanel;
import domain.juryPanel.addGroupNumSql;
import domain.juryPanel.juryPanelSql;
import domain.juryPanel.panelListSql;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class juryPanelService {
    public void addJuryPanel(int id,String refereenumber)
    {
        int number=Integer.parseInt(refereenumber);
        juryPanelSql info=new juryPanelSql();
        List<juryPanel> panel =new ArrayList<>();
        //找出所有的裁判信息
        panel=info.JPanelFindJuryPanel();


            //随机生成5名裁判
            List<juryPanel> panels=new ArrayList<juryPanel>();
            Random random = new Random();
            int i=0;
            while(i<number)
            {
                int j= random.nextInt(100)%panel.size();
                if(panel.get(j).getStatus()==0&&panel.get(j).getFlag()!=1)
                {
                    panels.add(panel.get(j));
                    panel.get(j).setFlag(1);
                    i++;
                }
            }

            //把生成的裁判小组中的裁判放在另一张表，方便查看
            panelListSql insert=new panelListSql();
            insert.addpanelList(panels,id);

            //添加组号
            addGroupNumSql add=new addGroupNumSql();
            add.addGroupNum(id,panels);
    }

    public void clearing(int id)
    {
        //找到裁判小组的所有裁判
        juryPanelSql clear=new juryPanelSql();
        List<juryPanel> panels=clear.clearingStatus(id);

        //在refereelist_ed表中删除裁判
       panelListSql delete=new panelListSql();
       delete.deletePanelList(panels,id);


        addGroupNumSql clearing=new addGroupNumSql();
        clearing.zeroClearing(panels);
    }

    public void clear(int id)
    {
        //找到裁判小组的所有裁判
        juryPanelSql clear=new juryPanelSql();
        List<juryPanel> panels=clear.clearingStatus(id);

        addGroupNumSql clearing=new addGroupNumSql();
        clearing.zeroClearing(panels);
    }
}

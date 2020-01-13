package domain.juryPanel;

import Util.JDBCutil;
import cn.juryPanel.juryPanel;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class panelListSql {

    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCutil.getdatasource());

    public void addpanelList(List<juryPanel> panels,int id)
    {
        try {
            for (int i=0;i<panels.size();i++)
            {
                String sql="insert into refereelist_ed (refereeName,phone,refereeId,state) value(?,?,?,?)";
                jdbcTemplate.update(sql,panels.get(i).getRefereeName(),panels.get(i).getPhone(),panels.get(i).getRefereeId(),id);
            }
        }catch (Exception e)
        {

        }
    }

    public void deletePanelList(List<juryPanel> panels,int id)
    {
        try {
            for (int i=0;i<panels.size();i++)
            {
                String sql="delete from refereelist_ed where state=?";
                jdbcTemplate.update(sql,id);
            }
        }catch (Exception e)
        {

        }
    }
}

package domain.juryPanel;

import Util.JDBCutil;
import cn.juryPanel.juryPanel;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

//添加裁判小组的组号
public class addGroupNumSql {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCutil.getdatasource());

    public void addGroupNum(int id,List<juryPanel> panels)
    {
        for (int i=0;i<panels.size();i++)
        {
            try{
                String sql="update refereelist set status =?,state=? where refereeId=?";
                jdbcTemplate.update(sql,id,id,panels.get(i).getRefereeId());
            }catch (Exception e)
            {
                System.out.println(e);
            }
        }
    }

    public void zeroClearing(List<juryPanel> panels)
    {
        int id=0;
        for (int i=0;i<panels.size();i++)
        {
            try{
                String sql="update refereelist set status =? where refereeId=?";
                jdbcTemplate.update(sql,id,panels.get(i).getRefereeId());
            }catch (Exception e)
            {
                System.out.println(e);
            }
        }
    }
}

package domain.juryPanel;

import Util.JDBCutil;
import cn.juryPanel.refereePanel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class addRefereePanelSql {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCutil.getdatasource());
    public int addRefereePanel(String position,String refereenumber)
    {
        try {
            String sql="insert into refereepanel (position,refereenumber) value(?,?)";
            jdbcTemplate.update(sql,position,refereenumber);
        }catch (Exception e)
        {
            System.out.println(e);
        }

        List<refereePanel> info=new ArrayList<>();
        String sql="select * from refereepanel where position=? and refereenumber=?";
        info= (List<refereePanel>) jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(refereePanel.class),position,refereenumber);
        return info.get(0).getId();
    }
}

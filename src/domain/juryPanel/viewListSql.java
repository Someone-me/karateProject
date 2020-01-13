package domain.juryPanel;

import Util.JDBCutil;
import cn.juryPanel.juryPanel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class viewListSql {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCutil.getdatasource());

    public List<juryPanel> viewlist(String id)
    {
        List<juryPanel> info=new ArrayList<>();
        try {
            String sql="select * from refereelist_ed where state=?";
            info=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(juryPanel.class),id);
        }catch (Exception e)
        {
            System.out.println(e);
        }
        return info;
    }
}

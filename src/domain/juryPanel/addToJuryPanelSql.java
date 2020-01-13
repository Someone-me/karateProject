package domain.juryPanel;

import Util.JDBCutil;
import cn.juryPanel.juryPanel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class addToJuryPanelSql {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCutil.getdatasource());
    public List<juryPanel> addToJuryPanel(String[] id_array,int id)
    {
        List<juryPanel> list=new ArrayList<>();
        try {
            for (int i=0;i<id_array.length;i++)
            {
                String sql="update refereelist set status=? where id=?"; //给裁判添加组号
                jdbcTemplate.update(sql,id,id_array[i]);
            }

        }catch (Exception e)
        {
            System.out.println(e);
        }

        try {
            String sql="select * from refereelist where status=?";
            list=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(juryPanel.class),id);
        }catch (Exception e)
        {
            System.out.println(e);
        }
        return list;
    }

}

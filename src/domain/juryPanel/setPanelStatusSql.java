package domain.juryPanel;

import Util.JDBCutil;
import org.springframework.jdbc.core.JdbcTemplate;

public class setPanelStatusSql {

    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCutil.getdatasource());

    public  void  setPanelStatus(int id,int status)
    {
        try {
            String sql="update refereepanel set status=? where id=?";
            jdbcTemplate.update(sql,status,id);
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
}

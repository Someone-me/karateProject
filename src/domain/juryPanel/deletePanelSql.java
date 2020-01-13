package domain.juryPanel;

import Util.JDBCutil;
import org.springframework.jdbc.core.JdbcTemplate;

public class deletePanelSql {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCutil.getdatasource());
    public void deletePanel(String id)
    {
        try {
            String sql="delete from refereepanel where id=?";
            jdbcTemplate.update(sql,id);
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }

}

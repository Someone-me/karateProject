package domain.juryPanel;

import Util.JDBCutil;
import org.springframework.jdbc.core.JdbcTemplate;

public class deleteRefereeSql {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCutil.getdatasource());

    public void deleteRefree(String id)
    {
        try {
            String sql="delete from refereelist where id=?";
            jdbcTemplate.update(sql,id);
        }catch (Exception e)
        {
            System.out.println("abcd");
        }

    }
}

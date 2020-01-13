package domain.juryPanel;

import Util.JDBCutil;
import cn.juryPanel.juryPanel;
import cn.juryPanel.utils;
import org.springframework.jdbc.core.JdbcTemplate;

public class addRefereeSql {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCutil.getdatasource());
    public void addReferee()
    {
        String flag="0";
        try {
            juryPanel juryPanel = utils.getPq();
            String sql = "insert into refereelist (refereeName,phone,refereeId,flag) value (?,?,?,?)";
            jdbcTemplate.update(sql, juryPanel.getRefereeName(), juryPanel.getPhone(), juryPanel.getRefereeId(),flag);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}

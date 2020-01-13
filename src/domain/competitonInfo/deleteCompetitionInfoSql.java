package domain.competitonInfo;

import Util.JDBCutil;
import org.springframework.jdbc.core.JdbcTemplate;

public class deleteCompetitionInfoSql {

    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCutil.getdatasource());

    public void deleteCompetitionInfo(String id)
    {
        try {
            String sql="delete from competition_information where teamId=?";
            jdbcTemplate.update(sql,id);
        }catch (Exception e)
        {
            System.out.println(e);
        }

    }
}

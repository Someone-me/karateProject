package domain.groupInformation;

import Util.JDBCutil;
import cn.groupInformation.grouping;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class addGroupNumberSql {

    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCutil.getdatasource());

    public void addGroupNumber(List<grouping> info,String typenumber)
    {
        for(int i=0;i<info.size();i++)
        {
            try {
                String sql="update refereescore_personaltype set status=? where playerIdcard=? and typenumber=?";
                jdbcTemplate.update(sql,info.get(i).getGroup(),info.get(i).getPlayerId(),typenumber);
            }catch (Exception e)
            {
                System.out.println(e);
            }

        }

    }
}

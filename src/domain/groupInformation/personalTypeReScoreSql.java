package domain.groupInformation;

import Util.JDBCutil;
import cn.RefereeScore.personalTypeRefereeScore;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class personalTypeReScoreSql {

    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCutil.getdatasource());

    public List<personalTypeRefereeScore> findEquallyPlayer(String typenumber,String type,String level)
    {
        List<personalTypeRefereeScore> info=new ArrayList<>();

        try{
            String sql="select * from refereescore_personaltype where typenumber=? and type=? and level=?";
            info=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(personalTypeRefereeScore.class),typenumber,type,level);
        }catch (Exception e){
            System.out.println(e);
            System.out.println("查询失败");
            return null;
        }
        return info;
    }
}

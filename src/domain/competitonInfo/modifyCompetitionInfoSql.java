package domain.competitonInfo;

import Util.JDBCutil;
import cn.competitonInfo.competitonInfo;
import cn.competitonInfo.saveId;
import cn.competitonInfo.utils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class modifyCompetitionInfoSql {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCutil.getdatasource());

    public List<competitonInfo> modifyCompetitionInfo( String id)
    {

//        System.out.println("sql中得到的Id"+id);
        List<competitonInfo> competitonInfo=null;
        try {

            String sql="select * from competition_information where teamId=?";
            competitonInfo=jdbcTemplate.query(sql,new BeanPropertyRowMapper<competitonInfo>(competitonInfo.class),id);
        }catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
        return competitonInfo;
    }
}

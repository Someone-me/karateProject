package domain.competitonInfo;

import Util.JDBCutil;
import cn.competitonInfo.competitonInfo;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class competitonInfoSql {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCutil.getdatasource());

    public List<competitonInfo> FindcompetitonInfo()
    {
        List<competitonInfo> info = null;
        try {
            String sql = "select * from competition_information";
            info = (List<competitonInfo>) jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<competitonInfo>(competitonInfo.class));


        } catch (EmptyResultDataAccessException e) {
//            System.out.println("数据库的内容查询不到");
            return null;
        }
        return info;
    }
}

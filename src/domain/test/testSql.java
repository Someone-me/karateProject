package domain.test;

import Util.JDBCutil;
import cn.test.test;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class testSql {

    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCutil.getdatasource());

    public List<test> PInfoFindtypeRefereeScore() {
        List<test> typeRefereeScore = null;
        try {
            String sql = "select type, level,typenumber from refereescore_personaltype";
            typeRefereeScore = (List<test>) jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<test>(test.class));
        } catch (EmptyResultDataAccessException e) {
//            System.out.println("数据库的内容查询不到");
            return null;
        }

        return typeRefereeScore;
    }
}

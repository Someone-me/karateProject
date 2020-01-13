package domain.RefereeScore;

import Util.JDBCutil;
import cn.RefereeScore.RefereeScore;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RefereeScoreSql {

    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCutil.getdatasource());

    public List<RefereeScore> PInfoFindRefereeScore() {

        List<RefereeScore> RefereeScore = null;
        try {
            String sql = "select * from refereescore";
            RefereeScore = (List<RefereeScore>) jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<RefereeScore>(RefereeScore.class));


        } catch (EmptyResultDataAccessException e) {
//            System.out.println("数据库的内容查询不到");
            return null;
        }

        return RefereeScore;
    }
}

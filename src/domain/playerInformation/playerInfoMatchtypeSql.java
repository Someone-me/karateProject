package domain.playerInformation;

import Util.JDBCutil;
import cn.playerInformation.playerInfoMatchtype;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class playerInfoMatchtypeSql {

    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCutil.getdatasource());

    public List<playerInfoMatchtype> PInfoFindMatchtype() {

        List<playerInfoMatchtype> matchtype = null;
        try {
            String sql = "select * from matchtype";
            matchtype = (List<playerInfoMatchtype>) jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<playerInfoMatchtype>(playerInfoMatchtype.class));


        } catch (EmptyResultDataAccessException e) {
//            System.out.println("数据库的内容查询不到");
            return null;
        }

        return matchtype;
    }
}

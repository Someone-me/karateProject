package domain.playerInformation;

import Util.JDBCutil;
import cn.playerInformation.playerLevel;
import cn.playerInformation.playerLevelsingle;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class playerLevelSql {

    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCutil.getdatasource());

    public List<playerLevelsingle> PInfoFindplayerLevel() {

        List<playerLevelsingle> levels = null;
        try {
            String sql = "select level from player_level";
            levels = (List<playerLevelsingle>) jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<playerLevelsingle>(playerLevelsingle.class));


        } catch (EmptyResultDataAccessException e) {
//            System.out.println("数据库的内容查询不到");
            return null;
        }

        return levels;
    }
}

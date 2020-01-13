package domain.playerInformation;

import Util.JDBCutil;
import cn.playerInformation.playerInfoTeamname;
import cn.playerInformation.playerInformation;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class playerInfoTeamnameSql {

    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCutil.getdatasource());

    public List<playerInfoTeamname> PInfoFindteamname() {

        List<playerInfoTeamname> teamnames = null;
        try {
            String sql = "select groupName from group_user";
            teamnames = (List<playerInfoTeamname>) jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<playerInfoTeamname>(playerInfoTeamname.class));

        } catch (EmptyResultDataAccessException e) {
//            System.out.println("数据库的内容查询不到");
            return null;
        }

        return teamnames;
    }
}

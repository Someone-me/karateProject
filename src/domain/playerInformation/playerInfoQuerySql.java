package domain.playerInformation;

import Util.JDBCutil;
import cn.playerInformation.playerInfoQuery;
import cn.playerInformation.playerInformation;
import cn.playerInformation.utils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class playerInfoQuerySql {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCutil.getdatasource());


    public List<playerInformation> PInfoQueryteamname() {

        List<playerInformation> teamInfo = null;
        playerInfoQuery query = utils.getPq();

        if(!query.getTeamname().equals("队名")&&!query.getKilogram().equals("公斤级")&&!query.getMatchtype().equals("比赛类型")) {

            try {
                String sql = "select * from player where teamname=? and matchsort=? and matchlevel=?";

                teamInfo = (List<playerInformation>) jdbcTemplate.query(sql,
                        new BeanPropertyRowMapper<playerInformation>(playerInformation.class), query.getTeamname(), query.getKilogram(), query.getMatchtype());
            } catch (EmptyResultDataAccessException e) {
//            System.out.println("数据库的内容查询不到");
                return null;
            }
            return teamInfo;
        }else if (!query.getTeamname().equals("队名") && !query.getKilogram().equals("公斤级") && query.getMatchtype().equals("比赛类型"))
        {
            try {
                String sql = "select * from player where teamname=? and matchsort=?";

                teamInfo = (List<playerInformation>) jdbcTemplate.query(sql,
                        new BeanPropertyRowMapper<playerInformation>(playerInformation.class), query.getTeamname(), query.getKilogram());
            } catch (EmptyResultDataAccessException e) {
//            System.out.println("数据库的内容查询不到");
                return null;
            }
            return teamInfo;
        }else if (!query.getTeamname().equals("队名") && query.getKilogram().equals("公斤级") && !query.getMatchtype().equals("比赛类型"))
        {
            try {
                String sql = "select * from player where teamname=? and matchlevel=?";

                teamInfo = (List<playerInformation>) jdbcTemplate.query(sql,
                        new BeanPropertyRowMapper<playerInformation>(playerInformation.class), query.getTeamname(), query.getMatchtype());
            } catch (EmptyResultDataAccessException e) {
//            System.out.println("数据库的内容查询不到");
                return null;
            }
            return teamInfo;
        }else if(query.getTeamname().equals("队名") && !query.getKilogram().equals("公斤级") && !query.getMatchtype().equals("比赛类型")) {

            try {
                String sql = "select * from player where  matchsort=? and matchlevel=?";

                teamInfo = (List<playerInformation>) jdbcTemplate.query(sql,
                        new BeanPropertyRowMapper<playerInformation>(playerInformation.class), query.getKilogram(), query.getMatchtype());
            } catch (EmptyResultDataAccessException e) {
//            System.out.println("数据库的内容查询不到");
                return null;
            }
            return teamInfo;
        }
        else if(!query.getTeamname().equals("队名") && query.getKilogram().equals("公斤级") && query.getMatchtype().equals("比赛类型")) {

            try {
                String sql = "select * from player where teamname=? ";

                teamInfo = (List<playerInformation>) jdbcTemplate.query(sql,
                        new BeanPropertyRowMapper<playerInformation>(playerInformation.class), query.getTeamname());
            } catch (EmptyResultDataAccessException e) {
//            System.out.println("数据库的内容查询不到");
                return null;
            }
            return teamInfo;
        }
        else if(query.getTeamname().equals("队名") && !query.getKilogram().equals("公斤级") && query.getMatchtype().equals("比赛类型")) {

            try {
                String sql = "select * from player where  matchsort=? ";

                teamInfo = (List<playerInformation>) jdbcTemplate.query(sql,
                        new BeanPropertyRowMapper<playerInformation>(playerInformation.class), query.getKilogram());
            } catch (EmptyResultDataAccessException e) {
//            System.out.println("数据库的内容查询不到");
                return null;
            }
            return teamInfo;
        }else if(query.getTeamname().equals("队名") && query.getKilogram().equals("公斤级") && !query.getMatchtype().equals("比赛类型")) {

            try {
                String sql = "select * from player where matchlevel=?";

                teamInfo = (List<playerInformation>) jdbcTemplate.query(sql,
                        new BeanPropertyRowMapper<playerInformation>(playerInformation.class),  query.getMatchtype());
            } catch (EmptyResultDataAccessException e) {
//            System.out.println("数据库的内容查询不到");
                return null;
            }
            return teamInfo;
        }else  {

                return null;
        }
    }
}

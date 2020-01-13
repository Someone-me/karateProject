package domain.playerInformation;

import cn.playerInformation.playerInfoCombine;
import cn.playerInformation.playerInformation;
import cn.playerInformation.playerLevel;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import Util.JDBCutil;

import java.util.ArrayList;
import java.util.List;

public class playInfomationSql {

    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCutil.getdatasource());

    public List<playerInfoCombine> PInfoFindPlayer() {

        List<playerInformation> player = null;
        List<playerInfoCombine> all=new ArrayList<>();
        List<playerLevel> level=null;
        try {
            String sql = "select * from player_information";
            player = (List<playerInformation>) jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<playerInformation>(playerInformation.class));
        } catch (EmptyResultDataAccessException e) {
//            System.out.println("数据库的内容查询不到");
            return null;
        }
        for (int i=0;i<player.size();i++)
        {
            playerInfoCombine pf = new playerInfoCombine();

            pf.setPlayerName(player.get(i).getPlayerName());
            pf.setPlayerSex(player.get(i).getPlayerSex());
            pf.setPlayerTel(player.get(i).getPlayerTel());
            pf.setPlayerIdCrad(player.get(i).getPlayerIdCrad());
            pf.setPlayerPosition(player.get(i).getPlayerPosition());
            pf.setPlayerGroup(player.get(i).getPlayerGroup());
            all.add(pf);
        }

        for (int i=0;i<player.size();i++)
        {
            String SQL="select * from player_level where level_id=?";
            level= (List<playerLevel>) jdbcTemplate.query(SQL,new BeanPropertyRowMapper<playerLevel>(playerLevel.class),player.get(i).getPlayerLevel());
            all.get(i).setLevel(level.get(0).getLevel());
            all.get(i).setLevelType(level.get(0).getLevelType());
        }
        return all;
    }


}


package domain.playerInformation;

import Util.JDBCutil;
import cn.playerInformation.playerInfoLookup;
import cn.playerInformation.playerInformation;
import cn.playerInformation.utils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.logging.StreamHandler;
import java.util.stream.Stream;
import java.util.*;
import java.util.stream.Collectors;

public class playerInfoLookupSql {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCutil.getdatasource());
    private String sql=null;
    public ArrayList<playerInformation> playerInfoLookup() {
        List<playerInformation> pInfo1=null;
        List<playerInformation> pInfo2=null;
        List<playerInformation> pInfo3=null;
        ArrayList<playerInformation> all=null;
        playerInfoLookup player = utils.getLp();
        String name = player.getName();

            sql="select * from player_information where playerName like '"+name+"%'";
            pInfo1=  jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(playerInformation.class));


            sql="select * from player_information where playerName like '%"+name+"%'";
            pInfo2=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(playerInformation.class));


            sql="select * from player_information where playerName like '%"+name+"'";
            pInfo3=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(playerInformation.class));

            all=contact(pInfo1,pInfo2,pInfo3);

        return all;
    }

    public ArrayList<playerInformation> contact(List<playerInformation> list1,List<playerInformation> list2,List<playerInformation> list3)
    {
        Map<Integer,playerInformation> map=new HashMap<>();
        for (playerInformation s1:list1)
        {
            map.put(s1.getPlayerId(),s1);
        }
        for (playerInformation s2:list2)
        {
            map.put(s2.getPlayerId(),s2);
        }
        for (playerInformation s3:list3)
        {
            map.put(s3.getPlayerId(),s3);
        }
        HashSet<Integer> set=new HashSet<Integer>();
        for (playerInformation list:list1)
        {
            set.add(list.getPlayerId());
        }
        for (playerInformation list:list2)
        {
            set.add(list.getPlayerId());
        }
        for (playerInformation list:list3)
        {
            set.add(list.getPlayerId());
        }
        ArrayList<playerInformation> arrayList=new ArrayList<>();
        for (Integer integer:set)
        {
            arrayList.add(map.get(integer));
        }
//        System.out.println("arrayList"+arrayList);

        return arrayList;
    }
}


package domain.groupInformation;

import Util.JDBCutil;
import cn.RefereeScore.personalTypeRefereeScore;
import cn.groupInformation.grouping;
import cn.playerInformation.playerInfoCombine;
import domain.playerInformation.playInfomationSql;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class addPlayerInfoSql {

    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCutil.getdatasource());

    public void addPlayerInfo()
    {
        playInfomationSql info=new playInfomationSql();
        List<playerInfoCombine> nInfo=info.PInfoFindPlayer();

        List<playerInfoCombine> Cinfo=new ArrayList<>();

        List<personalTypeRefereeScore> someone=new ArrayList<>();

        for(int i=0;i<nInfo.size();i++)
        {
            if(nInfo.get(i).getPlayerPosition().equals("运动员"))
            {
                Cinfo.add(nInfo.get(i));
            }
        }

        String typeNumber="第一套型";
        float number=0;
        for(int i=0;i<Cinfo.size();i++)
        {
            try{
                String sql="select * from refereescore_personaltype where playerIdcard=? and level=?";
                someone= (List<personalTypeRefereeScore>) jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(personalTypeRefereeScore.class),
                        Cinfo.get(i).getPlayerIdCrad(),Cinfo.get(i).getLevel());
            }catch (Exception e)
            {
                System.out.println(e);
            }

            System.out.println(someone.size());

            if(someone.size()==0) {
                String sql = "insert into refereescore_personaltype (playerId,playerIdcard,type,level,typenumber," +
                        "Treferee1,Treferee2,Treferee3,Treferee4,Treferee5,Treferee6,Treferee7,Ttotal," +
                        "referee1,referee2,referee3,referee4,referee5,referee6,referee7,total,result,status) value(?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?,?,?)";
                jdbcTemplate.update(sql, Cinfo.get(i).getPlayerName(), Cinfo.get(i).getPlayerIdCrad(), Cinfo.get(i).getLevelType(),
                        Cinfo.get(i).getLevel(), typeNumber,
                        number, number, number, number, number, number, number, number,
                        number, number, number, number, number, number, number, number, number, number);
            }
            else {

            }
        }
    }

    public void addPlayerInfo_other(List<grouping> group,String typeNumber)
    {
//        String typeNumber="第二套型";

        float number=0;
        List<personalTypeRefereeScore> Cinfo=new ArrayList<>();
        List<personalTypeRefereeScore> ninfo=new ArrayList<>();
        for(int i=0;i<group.size();i++)
        {
           try {
               String check="select * from refereescore_personaltype where playerIdcard=? and typenumber=?";
               ninfo=jdbcTemplate.query(check,new BeanPropertyRowMapper<>(personalTypeRefereeScore.class),group.get(i).getPlayerId(),typeNumber);
           }catch (Exception e)
           {
               System.out.println(e);
           }
           if(ninfo.size()==0)
           {
               String SQL="select * from refereescore_personaltype where playerIdcard=?";
               Cinfo= (List<personalTypeRefereeScore>) jdbcTemplate.query(SQL,new BeanPropertyRowMapper<>(personalTypeRefereeScore.class),group.get(i).getPlayerId());

               String sql="insert into refereescore_personaltype (playerId,playerIdcard,type,level,typenumber," +
                       "Treferee1,Treferee2,Treferee3,Treferee4,Treferee5,Treferee6,Treferee7,Ttotal," +
                       "referee1,referee2,referee3,referee4,referee5,referee6,referee7,total,result,status) value(?,?,?,?,?," +
                       "?,?,?,?,?,?,?,?," +
                       "?,?,?,?,?,?,?,?,?,?)";
               jdbcTemplate.update(sql,Cinfo.get(0).getPlayerId(),Cinfo.get(0).getPlayerIdcard(),Cinfo.get(0).getType(),
                       Cinfo.get(0).getLevel(),typeNumber,
                       number,number,number,number,number,number,number,number,
                       number,number,number,number,number,number,number,number,number,number);
           }

        }
    }
}

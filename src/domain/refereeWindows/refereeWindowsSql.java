package domain.refereeWindows;

import Util.JDBCutil;
import cn.refereeWindows.refereeWindows;
import org.springframework.jdbc.core.JdbcTemplate;

public class refereeWindowsSql {

    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCutil.getdatasource());

    public void addScoreInfo(refereeWindows info)
    {
        String sql=null;

        if(info.getRefereeNumber().equals("1号"))
        {
            sql="update refereescore_personaltype set typename=?,Treferee1=?,referee1=? where playerId=? and typenumber=? and type=? and level=?";
        }
        else if (info.getRefereeNumber().equals("2号"))
        {
            sql="update refereescore_personaltype set typename=?,Treferee2=?,referee2=? where playerId=? and typenumber=? and type=? and level=?";
        }
        else if (info.getRefereeNumber().equals("3号"))
        {
            sql="update refereescore_personaltype set typename=?,Treferee3=?,referee3=? where playerId=? and typenumber=? and type=? and level=?";
        }
        else if (info.getRefereeNumber().equals("4号"))
        {
            sql="update refereescore_personaltype set typename=?,Treferee4=?,referee4=? where playerId=? and typenumber=? and type=? and level=?";
        }
        else if (info.getRefereeNumber().equals("5号"))
        {
            sql="update refereescore_personaltype set typename=?,Treferee5=?,referee5=? where playerId=? and typenumber=? and type=? and level=?";
        }
        else if (info.getRefereeNumber().equals("6号"))
        {
            sql="update refereescore_personaltype set typename=?,Treferee6=?,referee6=? where playerId=? and typenumber=? and type=? and level=?";
        }
        else if (info.getRefereeNumber().equals("7号"))
        {
            sql="update refereescore_personaltype set typename=?,Treferee7=?,referee7=? where playerId=? and typenumber=? and type=? and level=?";
        }

        jdbcTemplate.update(sql,info.getTypeName(),info.getTechnicalPoints(),info.getMotionScore(),info.getPlayerName(),info.getTypeNumber(),info.getType(),info.getLevel());
    }
}

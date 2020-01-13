package domain.competitonInfo;

import Util.JDBCutil;
import cn.competitonInfo.competitonInfo;
import cn.competitonInfo.utils;
import org.springframework.jdbc.core.JdbcTemplate;

public class addCompetitionInfoSql {

    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCutil.getdatasource());
    competitonInfo info= utils.getPq();
    public void addCompetitionInfo()
    {
        try {
            String sql="insert into competition_information (teamName,teamOrganizer,teamUndertake,teamCoOrganizer," +
                    "teamPavilion,TeamStartTime,TeamEndTime,TeamLevel,TeamFormat) value(?,?,?,?,?,?,?,?,?)";
            jdbcTemplate.update(sql,info.getTeamName(),info.getTeamOrganizer(),info.getTeamUndertake(),info.getTeamCoOrganizer()
                    ,info.getTeamPavilion(),info.getTeamStartTime(),info.getTeamEndTime(),info.getTeamLevel(),info.getTeamFormat());
        }catch (Exception e)
        {
            System.out.println(e);
            System.out.println("数据插入有误");
        }

    }

}

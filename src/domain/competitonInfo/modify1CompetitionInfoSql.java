package domain.competitonInfo;

import Util.JDBCutil;
import cn.competitonInfo.competitonInfo;
import cn.competitonInfo.utils;
import org.springframework.jdbc.core.JdbcTemplate;

public class modify1CompetitionInfoSql {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCutil.getdatasource());
    competitonInfo info= utils.getP();
    public void addCompetitionInfo(String id)
    {
        try {
            String sql="update competition_information set teamName=?,teamOrganizer=?,teamUndertake=?,teamCoOrganizer=?," +
                    "teamPavilion=?,TeamStartTime=?,TeamEndTime=?,TeamLevel=?,TeamFormat=? where teamId=?";
            jdbcTemplate.update(sql,info.getTeamName(),info.getTeamOrganizer(),info.getTeamUndertake(),info.getTeamCoOrganizer()
                    ,info.getTeamPavilion(),info.getTeamStartTime(),info.getTeamEndTime(),info.getTeamLevel(),info.getTeamFormat(),id);
        }catch (Exception e)
        {
            System.out.println(e);
            System.out.println("改数据有误");
        }

    }
}

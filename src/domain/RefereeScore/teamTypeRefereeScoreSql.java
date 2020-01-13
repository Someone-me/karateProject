package domain.RefereeScore;

import Util.JDBCutil;
import cn.RefereeScore.teamTypeRefereeScore;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class teamTypeRefereeScoreSql {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCutil.getdatasource());

    public List<teamTypeRefereeScore> findteamTypeRefereeScore1() {
        display();
        List<teamTypeRefereeScore> teamtypeRefereeScore = null;
        String typenumber="第一套型";
        try {
            String sql = "select * from refereescore_teamtype where typenumber=?";
            teamtypeRefereeScore = (List<teamTypeRefereeScore>) jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<teamTypeRefereeScore>(teamTypeRefereeScore.class),typenumber);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("数据库的内容查询不到");
            return null;
        }
        return teamtypeRefereeScore;
    }

    public List<teamTypeRefereeScore> findteamTypeRefereeScore2() {
        display();
        List<teamTypeRefereeScore> teamtypeRefereeScore = null;
        String typenumber="第二套型";
        try {
            String sql = "select * from refereescore_teamtype where typenumber=?";
            teamtypeRefereeScore = (List<teamTypeRefereeScore>) jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<teamTypeRefereeScore>(teamTypeRefereeScore.class),typenumber);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("数据库的内容查询不到");
            return null;
        }
        return teamtypeRefereeScore;
    }

    public List<teamTypeRefereeScore> findteamTypeRefereeScore3() {
        display();
        List<teamTypeRefereeScore> teamtypeRefereeScore = null;
        String typenumber="第三套型";
        try {
            String sql = "select * from refereescore_teamtype where typenumber=?";
            teamtypeRefereeScore = (List<teamTypeRefereeScore>) jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<teamTypeRefereeScore>(teamTypeRefereeScore.class),typenumber);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("数据库的内容查询不到");
            return null;
        }
        return teamtypeRefereeScore;
    }

    public List<teamTypeRefereeScore> findteamTypeRefereeScore4() {
        display();
        List<teamTypeRefereeScore> teamtypeRefereeScore = null;
        String typenumber="第四套型";
        try {
            String sql = "select * from refereescore_teamtype where typenumber=?";
            teamtypeRefereeScore = (List<teamTypeRefereeScore>) jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<teamTypeRefereeScore>(teamTypeRefereeScore.class),typenumber);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("数据库的内容查询不到");
            return null;
        }
        return teamtypeRefereeScore;
    }

    public void display()
    {
        List<teamTypeRefereeScore> TRefereeScore=null;
        try {
            String sql = "select * from refereescore_teamtype";
            TRefereeScore = (List<teamTypeRefereeScore>) jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<teamTypeRefereeScore>(teamTypeRefereeScore.class));
        } catch (EmptyResultDataAccessException e) {
            System.out.println("数据库的内容查询不到");
        }
        for(int i=0;i<TRefereeScore.size();i++)
        {
            if(TRefereeScore.get(i).getTtotal()!=0&&TRefereeScore.get(i).getTotal()!=0&&TRefereeScore.get(i).getResult()!=0)
            {
            }else {
                Calculation(TRefereeScore);
            }
        }


    }
    public void insert(float Ttotal,float total,float result,String teamId)
    {
        try {
            String sql="update refereescore_teamtype set Ttotal=?,total=?,result=? where teamId=?";
            jdbcTemplate.update(sql,Ttotal,total,result,teamId);
        }catch (Exception e )
        {
            System.out.println("插入失败");
            System.out.println(e);
        }

    }

    public void Calculation(List<teamTypeRefereeScore> typeRefereeScore)
    {
        for(int i=0;i<typeRefereeScore.size();i++)
        {
            float[] str=new float[7];
            str[0]=(float)(typeRefereeScore.get(i).getTreferee1());
            str[1]=(float)typeRefereeScore.get(i).getTreferee2();
            str[2]=(float)typeRefereeScore.get(i).getTreferee3();
            str[3]=(float)typeRefereeScore.get(i).getTreferee4();
            str[4]=(float)typeRefereeScore.get(i).getTreferee5();
            str[5]=(float)typeRefereeScore.get(i).getTreferee6();
            str[6]=(float)typeRefereeScore.get(i).getTreferee7();
            float Taverage=sort(str);

            str[0]=(float)typeRefereeScore.get(i).getReferee1();
            str[1]=(float)typeRefereeScore.get(i).getReferee2();
            str[2]=(float)typeRefereeScore.get(i).getReferee3();
            str[3]=(float)typeRefereeScore.get(i).getReferee4();
            str[4]=(float)typeRefereeScore.get(i).getReferee5();
            str[5]=(float)typeRefereeScore.get(i).getReferee6();
            str[6]=(float)typeRefereeScore.get(i).getReferee7();
            float average=sort(str);

            float total= (float) (Taverage*0.7+average*0.3);

//            System.out.println(Taverage+"  "+average+"  "+total+"  "+typeRefereeScore.get(i).getTeamId());
            insert(Taverage,average,total,typeRefereeScore.get(i).getTeamId());
        }
    }

    public float sort(float[] str){
        float t;
        float total;
        for (int i=0;i<7;i++)
        {
            for (int j=i+1;j<7;j++) {
                if (str[i] < str[j]) {
                    t = str[i];
                    str[i] = str[j];
                    str[j] = t;
                }
            }
        }
        total= str[2]+str[3]+str[4];
        return  total;
    }

}

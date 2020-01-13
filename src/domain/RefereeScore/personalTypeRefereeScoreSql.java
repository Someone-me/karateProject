package domain.RefereeScore;

import Util.JDBCutil;
import cn.RefereeScore.personalTypeRefereeScore;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class personalTypeRefereeScoreSql {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCutil.getdatasource());

    public List<personalTypeRefereeScore> PInfoFindtypeRefereeScore(String type,String level,String typeNumber) {
        System.out.println("aaaaaaaaaaaaaaa");
        display(type,level,typeNumber);
        System.out.println("bbbbbbbbbbbbbbbbbbbbbb");
        List<personalTypeRefereeScore> typeRefereeScore = null;
        try {
            String sql = "select * from refereescore_personaltype where type=? and level=? and typenumber=? order by result desc ";
            typeRefereeScore = (List<personalTypeRefereeScore>) jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<personalTypeRefereeScore>(personalTypeRefereeScore.class),type,level,typeNumber);
        } catch (EmptyResultDataAccessException e) {
//            System.out.println("数据库的内容查询不到");
            return null;
        }

        return typeRefereeScore;
    }


    public void display(String type,String level,String typeNumber)
    {
        List<personalTypeRefereeScore> TRefereeScore=null;
        try {
            String sql = "select * from refereescore_personaltype where type=? and level=? and typenumber=? ";
            TRefereeScore = (List<personalTypeRefereeScore>) jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<personalTypeRefereeScore>(personalTypeRefereeScore.class),type,level,typeNumber);
        } catch (EmptyResultDataAccessException e) {
//            System.out.println("数据库的内容查询不到");
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
    public void insert(float Ttotal,float total,float result,String playerId)
    {
        try {
            String sql="update refereescore_personaltype set Ttotal=?,total=?,result=? where playerId=?";
            jdbcTemplate.update(sql,Ttotal,total,result,playerId);
        }catch (Exception e )
        {
            System.out.println("插入失败");
            System.out.println(e);
        }

    }

    public void Calculation(List<personalTypeRefereeScore> typeRefereeScore)
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

//            System.out.println(Taverage+"  "+average+"  "+total+"  "+typeRefereeScore.get(i).getPlayerId());
            insert(Taverage,average,total,typeRefereeScore.get(i).getPlayerId());
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

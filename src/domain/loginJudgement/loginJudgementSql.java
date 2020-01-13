package domain.loginJudgement;

import Util.JDBCutil;
import cn.juryPanel.juryPanel;
import cn.loginJudgement.loginJudgement;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class loginJudgementSql {


    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCutil.getdatasource());

    public List<loginJudgement> loginJudgement()
    {
        List<loginJudgement> login = null;
        try {
            String sql = "select * from adminsetting";
            login = (List<loginJudgement>) jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<loginJudgement>(loginJudgement.class));


        } catch (EmptyResultDataAccessException e) {
//            System.out.println("数据库的内容查询不到");
            return null;
        }

        return login;
    }
}

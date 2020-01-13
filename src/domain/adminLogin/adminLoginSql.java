package domain.adminLogin;

import Util.JDBCutil;
import cn.adminLogin.adminLogin;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class adminLoginSql {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCutil.getdatasource());

    public List<adminLogin> AdminPass()
    {
        List<adminLogin> admin= null;
        try {
            String sql = "select * from adminsetting";
            admin= jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(adminLogin.class));
        } catch (EmptyResultDataAccessException e) {
            System.out.println(e);
            return null;
        }
        return admin;
    }
    public void setflag(adminLogin admin)
    {
        String sql="update adminsetting set flag=1 where phonenumber="+admin.getPhonenumber();
        jdbcTemplate.update(sql);
    }
}

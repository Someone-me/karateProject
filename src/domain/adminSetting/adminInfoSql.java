package domain.adminSetting;

import Util.JDBCutil;
import cn.adminSetting.adminSetting;
import cn.adminSetting.utils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class adminInfoSql {

    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCutil.getdatasource());

    public List<adminSetting> AdminInfo()
    {
        List<adminSetting> admin= null;
        try {
            String sql = "select * from adminsetting";
           admin= jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(adminSetting.class));
        } catch (EmptyResultDataAccessException e) {
            System.out.println(e);
            return null;
        }
    return admin;

    }
}

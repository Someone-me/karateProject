package domain.adminSetting;

import Util.JDBCutil;
import cn.adminSetting.adminSetting;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class deleteAdminInfoSql {

    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCutil.getdatasource());

    public void deleteAdminInfo(String id)
    {
        try {
            String sql = "delete from adminsetting where id=?";
            jdbcTemplate.update(sql,id);
        } catch (EmptyResultDataAccessException e) {
            System.out.println(e);
            System.out.println("删除信息失败");
        }

    }
}

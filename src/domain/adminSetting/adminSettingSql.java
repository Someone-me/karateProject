package domain.adminSetting;

import Util.JDBCutil;
import cn.adminSetting.adminSetting;
import cn.adminSetting.utils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class adminSettingSql {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCutil.getdatasource());

    public void ASettingAdd()
    {
        String flag="0";
        adminSetting admin=utils.getPq();
        try {
            String sql = "insert into adminsetting(adminname,phonenumber,password,email,idcard,flag) values(?,?,?,?,?,?)";
            jdbcTemplate.update(sql, admin.getUsername(),admin.getPhonenumber(),admin.getPassword(),admin.getEmail(),admin.getIdCard(),flag);

        } catch (EmptyResultDataAccessException e) {
            System.out.println(e);

        }


    }
}

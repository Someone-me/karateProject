package domain.loginJudgement;

import Util.JDBCutil;
import cn.adminLogin.adminLogin;
import cn.adminSetting.adminSetting;
import org.springframework.jdbc.core.JdbcTemplate;

public class logoutSql {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCutil.getdatasource());

    public void setflag(adminSetting admin)
    {
        String sql="update adminsetting set flag=0 where adminname=?";
        jdbcTemplate.update(sql,admin.getAdminname());
    }
}

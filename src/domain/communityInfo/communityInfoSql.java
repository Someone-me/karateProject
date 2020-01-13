package domain.communityInfo;

import Util.JDBCutil;
import cn.communityInfo.communityInfo;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class communityInfoSql {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCutil.getdatasource());

    public List<communityInfo> FindcommunityInfo()
    {
        List<communityInfo> info = null;
        try {
            String sql = "select * from login_user";
            info = (List<communityInfo>) jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<communityInfo>(communityInfo.class));


        } catch (EmptyResultDataAccessException e) {
//            System.out.println("数据库的内容查询不到");
            return null;
        }
        return info;
    }
}

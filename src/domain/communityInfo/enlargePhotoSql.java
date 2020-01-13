package domain.communityInfo;

import Util.JDBCutil;
import cn.communityInfo.AenlargePhoto;
import cn.communityInfo.BenlargePhoto;
import cn.communityInfo.communityInfo;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class enlargePhotoSql {

    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCutil.getdatasource());

    public List<AenlargePhoto> FindAenlagePhoto(String id)
    {
        List<AenlargePhoto> info = null;
        try {
            String sql = "select identityCardFrontPic from login_user where userId=?";
            info = (List<AenlargePhoto>) jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<AenlargePhoto>(AenlargePhoto.class),id);


        } catch (EmptyResultDataAccessException e) {
//            System.out.println("数据库的内容查询不到");
            return null;
        }
        return info;
    }

    public List<BenlargePhoto> FindBenlagePhoto(String id)
    {
        List<BenlargePhoto> info = null;
        try {
            String sql = "select identityCardReversePic from login_user where userId=?";
            info = (List<BenlargePhoto>) jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<BenlargePhoto>(BenlargePhoto.class),id);

        } catch (EmptyResultDataAccessException e) {
//            System.out.println("数据库的内容查询不到");
            return null;
        }
        return info;
    }
}

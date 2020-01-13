package domain.juryPanel;

import Util.JDBCutil;
import cn.juryPanel.juryPanel;
import cn.juryPanel.refereePanel;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class juryPanelSql {

    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCutil.getdatasource());

    //查询全部的裁判信息
    public List<juryPanel> JPanelFindJuryPanel()
    {
        List<juryPanel> juryPanels = null;
        try {
            String sql = "select * from refereelist";
            juryPanels = (List<juryPanel>) jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<juryPanel>(juryPanel.class));


        } catch (EmptyResultDataAccessException e) {
//            System.out.println("数据库的内容查询不到");
            return null;
        }

        return juryPanels;
    }

    public List<refereePanel> JPanelFindRefereePanel(){

        List<refereePanel> info=new ArrayList<>();

        try {
            String sql="select * from refereepanel";
            info=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(refereePanel.class));
        }catch (Exception e)
        {
            System.out.println(e);
        }
        return info;
    }

    public List<juryPanel> clearingStatus(int id)
    {
        List<juryPanel> juryPanels = null;
        try {
            String sql = "select * from refereeList where status=?";
            juryPanels = (List<juryPanel>) jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<juryPanel>(juryPanel.class),id);


        } catch (EmptyResultDataAccessException e) {
//            System.out.println("数据库的内容查询不到");
            return null;
        }

        return juryPanels;
    }
}

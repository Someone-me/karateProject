package cn.anhui.karate.dao.impl;

import cn.anhui.karate.dao.VideoBeanDao;
import cn.anhui.karate.domain.NewsBean;
import cn.anhui.karate.domain.NotificationBean;
import cn.anhui.karate.domain.VideoBean;
import cn.anhui.karate.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VideoBeanDaoImpl implements VideoBeanDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 保存数据到数据库
     * @param bean
     */
    @Override
    public void saveVideo(VideoBean bean) {
        //定义sql语句
        String sql = "insert into video_list(name,title,filepath,url) values(?,?,?,?)";
        //执行sql语句
        template.update(sql,
                bean.getName(),
                bean.getTitle(),
                bean.getFilepath(),
                bean.getUrl()
        );
    }

    /**
     * 总页数
     * @return
     */
    @Override
    public int videoTotalCount(Map<String, String[]> condition) {
        //定义模板初始化sql
        String sql = "select count(*) from video_list where 1=1 ";
        StringBuilder sb=new StringBuilder(sql);
        //遍历map
        Set<String> keySet = condition.keySet();
        //定义参数集合
        List<Object> params = new ArrayList<Object>();
        for(String key:keySet){
            //排除分页条件参数
            if("currentPage".equals(key)|| "currentCount".equals(key)){
                continue;
            }
            //获取value值
            String value=condition.get(key)[0];
            //判断value是否有值
            if(value!=null && !"".equals(value)){
                //有值
                sb.append(" and "+key+" like ?");
                params.add("%"+value+"%");//?条件的值
            }
        }
        System.out.println(sb.toString());
        System.out.println(params);
        Long query = template.queryForObject(sb.toString(), Long.class,params.toArray());
        return query.intValue();
    }

    /**
     * 分页展示的每页数据的集合
     * @param index
     * @param currentCount
     * @param condition
     * @return
     */
    @Override
    public List<VideoBean> videoPageList(int index, int currentCount, Map<String, String[]> condition) {
        /*String sql = "select * from video_list limit ?,?";
        return template.query(sql, new BeanPropertyRowMapper<VideoBean>(VideoBean.class), index, currentCount);*/
        String sql = "select * from video_list where 1=1";
        StringBuilder sb=new StringBuilder(sql);
        //遍历map
        Set<String> keySet = condition.keySet();
        //定义参数集合
        List<Object> params = new ArrayList<Object>();
        for(String key:keySet){
            //排除分页条件参数
            if("currentPage".equals(key)|| "currentCount".equals(key)){
                continue;
            }
            //获取value值
            String value=condition.get(key)[0];
            //判断value是否有值
            if(value!=null && !"".equals(value)){
                //有值
                sb.append(" and "+key+" like ?");
                params.add("%"+value+"%");//?条件的值
            }
        }

        //添加分页查询
        sb.append(" order by id desc limit ?,?");
        /*sb.append(" limit ?,?");*/
        //添加分页查询参数值
        //params.add(index,currentCount);
        params.add(index);
        params.add(currentCount);
        sql=sb.toString();
        System.out.println(sql);
        //System.out.println(params);
        return template.query(sql, new BeanPropertyRowMapper<VideoBean>(VideoBean.class),params.toArray());
    }


    /**
     * 通过id查找要删除的视频的信息
     * @param id
     * @return
     */
    @Override
    public VideoBean findVideoInfo(int id) {
        VideoBean bean = null;
        try {
            String sql = "select * from video_list where id =?";
            bean = template.queryForObject(sql, new BeanPropertyRowMapper<VideoBean>(VideoBean.class), id);
        } catch (DataAccessException e) {
        }
        return bean;
    }

    /**
     * 通过id删除信息
     * @param id
     */
    @Override
    public void deleteVideoById(int id) {
        String sql = "delete from video_list where id =?";
        template.update(sql, new Object[]{id});
    }

    /**
     * 查找数据库中的视频封装成集合
     * @return
     */
    @Override
    public List<VideoBean> findVideoNewsInfo() {
        String sql = "select * from video_list";
        return template.query(sql, new BeanPropertyRowMapper<VideoBean>(VideoBean.class));
    }
}

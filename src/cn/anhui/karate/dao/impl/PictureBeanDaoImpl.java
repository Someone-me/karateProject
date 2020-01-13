package cn.anhui.karate.dao.impl;

import cn.anhui.karate.dao.PictureBeanDao;
import cn.anhui.karate.domain.PictureBean;
import cn.anhui.karate.domain.VideoBean;
import cn.anhui.karate.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PictureBeanDaoImpl implements PictureBeanDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 保存赛事图片到数据库
     * @param bean
     */
    @Override
    public void saveMatchPicture(PictureBean bean) {
        //定义sql语句
        String sql = "insert into match_picture(name,title,filepath) values(?,?,?)";
        //执行sql语句
        template.update(sql,
                bean.getName(),
                bean.getTitle(),
                bean.getFilepath()
        );
    }

    /**
     * 总页数
     * @param condition
     * @return
     */
    @Override
    public int matchPictureTotalCount(Map<String, String[]> condition) {
        //定义模板初始化sql
        String sql = "select count(*) from match_picture where 1=1 ";
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
     * 每页显示数据的集合
     * @param index
     * @param currentCount
     * @param condition
     * @return
     */
    @Override
    public List<PictureBean> matchPicturePageList(int index, int currentCount, Map<String, String[]> condition) {
        String sql = "select * from match_picture where 1=1";
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
        return template.query(sql, new BeanPropertyRowMapper<PictureBean>(PictureBean.class),params.toArray());
    }

    /**
     * 查找要删除赛事图片的信息
     * @param id
     * @return
     */
    @Override
    public PictureBean findMatchPictureInfo(int id) {
        PictureBean bean = null;
        try {
            String sql = "select * from match_picture where id =?";
            bean = template.queryForObject(sql, new BeanPropertyRowMapper<PictureBean>(PictureBean.class), id);
        } catch (DataAccessException e) {
        }
        return bean;
    }

    /**
     * 通过id删除
     * @param id
     */
    @Override
    public void deleteMatchPictureById(int id) {
        String sql = "delete from match_picture where id =?";
        template.update(sql, new Object[]{id});
    }

    /**
     * 保存活动图片到数据库
     * @param bean
     */
    @Override
    public void saveActivityPicture(PictureBean bean) {
        //定义sql语句
        String sql = "insert into activity_picture(name,title,filepath) values(?,?,?)";
        //执行sql语句
        template.update(sql,
                bean.getName(),
                bean.getTitle(),
                bean.getFilepath()
        );
    }

    /**
     * 数据库中活动图片的总条数
     * @param condition
     * @return
     */
    @Override
    public int activityPictureTotalCount(Map<String, String[]> condition) {
        //定义模板初始化sql
        String sql = "select count(*) from activity_picture where 1=1 ";
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
     * 每页展示数据的集合
     * @param index
     * @param currentCount
     * @param condition
     * @return
     */
    @Override
    public List<PictureBean> activityPicturePageList(int index, int currentCount, Map<String, String[]> condition) {
        String sql = "select * from activity_picture where 1=1";
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
        return template.query(sql, new BeanPropertyRowMapper<PictureBean>(PictureBean.class),params.toArray());
    }


    /**
     * 查找数据库中活动图片的信息
     * @param id
     * @return
     */
    @Override
    public PictureBean findActivityPictureInfo(int id) {
        PictureBean bean = null;
        try {
            String sql = "select * from activity_picture where id =?";
            bean = template.queryForObject(sql, new BeanPropertyRowMapper<PictureBean>(PictureBean.class), id);
        } catch (DataAccessException e) {
        }
        return bean;
    }

    /**
     * 通过id删除
     * @param id
     */
    @Override
    public void deleteActivityPictureById(int id) {
        String sql = "delete from activity_picture where id =?";
        template.update(sql, new Object[]{id});
    }
}

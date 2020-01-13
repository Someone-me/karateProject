package cn.anhui.karate.dao.impl;

import cn.anhui.karate.dao.NotificationBeanDao;
import cn.anhui.karate.domain.NotificationBean;
import cn.anhui.karate.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NotificationBeanServiceDaoImpl implements NotificationBeanDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 保存比赛通知到数据库
     * @param bean
     */
    @Override
    public void saveNotification(NotificationBean bean) {
        //定义sql语句
        String sql = "insert into match_list(name,title,filepath,publishTime) values(?,?,?,?)";
        //执行sql语句
        template.update(sql,
                bean.getName(),
                bean.getTitle(),
                bean.getFilepath(),
                bean.getPublishTime()
        );
    }

    /**
     * 数据库中比赛通知的总条数
     * @return
     */
    /*@Override
    public int matchNewsTotalCount() {
        String sql = "select count(*) from match_list";
        Long query = template.queryForObject(sql, Long.class);
        return query.intValue();
    }*/

    /**
     * 分页展示的每页数据的集合
     * @param index
     * @param currentCount
     * @return
     */
   /* @Override
    public List<NotificationBean> matchNewsPageList(int index, int currentCount) {
        String sql = "select * from match_list limit ?,?";
        return template.query(sql, new BeanPropertyRowMapper<NotificationBean>(NotificationBean.class), index, currentCount);
    }*/

    /**
     * 通过id查找要删除的比赛通知的信息
     * @param id
     * @return
     */
    @Override
    public NotificationBean findMatchNewsInfo(int id) {
        NotificationBean bean = null;
        try {
            String sql = "select * from match_list where id =?";
            bean = template.queryForObject(sql, new BeanPropertyRowMapper<NotificationBean>(NotificationBean.class), id);
        } catch (DataAccessException e) {
        }
        return bean;
    }

    /**
     * 通过id删除信息
     * @param id
     */
    @Override
    public void deleteMatchNewsById(int id) {
        String sql = "delete from match_list where id =?";
        template.update(sql, new Object[]{id});
    }

    /**
     * 总页数
     * @param condition
     * @return
     */
    @Override
    public int findMatchNewsSearchTotalCount(Map<String, String[]> condition) {
        //定义模板初始化sql
        String sql = "select count(*) from match_list where 1=1 ";
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
     * 每页显示内容的集合
     * @param index
     * @param currentCount
     * @param condition
     * @return
     */
    @Override
    public List<NotificationBean> matchNewsSearchContextList(int index, int currentCount, Map<String, String[]> condition) {
        String sql = "select * from match_list where 1=1";
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
        sb.append(" order by publishTime desc limit ?,?");
        /*sb.append(" limit ?,?");*/
        //添加分页查询参数值
        //params.add(index,currentCount);
        params.add(index);
        params.add(currentCount);
        sql=sb.toString();
        System.out.println(sql);
        //System.out.println(params);
        return template.query(sql, new BeanPropertyRowMapper<NotificationBean>(NotificationBean.class),params.toArray());
    }

    /**
     * 通过id找到每个新闻的信息
     * @param id
     * @return
     */
    @Override
    public List<NotificationBean> findSingleMatchNewsInfo(int id) {
        String sql = "select * from match_list where id =?";
        return template.query(sql, new BeanPropertyRowMapper<NotificationBean>(NotificationBean.class), id);
    }

    /**
     * 保存培训新闻到数据库
     * @param bean
     */
    @Override
    public void saveTrainNews(NotificationBean bean) {
        //定义sql语句
        String sql = "insert into train_list(name,title,filepath,publishTime) values(?,?,?,?)";
        //执行sql语句
        template.update(sql,
                bean.getName(),
                bean.getTitle(),
                bean.getFilepath(),
                bean.getPublishTime()
        );
    }

    /**
     * 数据库中培训通知的总条数
     * @return
     */
    /*@Override
    public int trainNewsTotalCount() {
        String sql = "select count(*) from train_list";
        Long query = template.queryForObject(sql, Long.class);
        return query.intValue();
    }*/

    /**
     * 分页展示的每页数据的集合
     * @param index
     * @param currentCount
     * @return
     */
    /*@Override
    public List<NotificationBean> trainNewsPageList(int index, int currentCount) {
        String sql = "select * from train_list limit ?,?";
        return template.query(sql, new BeanPropertyRowMapper<NotificationBean>(NotificationBean.class), index, currentCount);
    }*/

    /**
     * 通过id查找要删除的培训通知的信息
     * @param id
     * @return
     */
    @Override
    public NotificationBean findTrainNewsInfo(int id) {
        NotificationBean bean = null;
        try {
            String sql = "select * from train_list where id =?";
            bean = template.queryForObject(sql, new BeanPropertyRowMapper<NotificationBean>(NotificationBean.class), id);
        } catch (DataAccessException e) {
        }
        return bean;
    }

    /**
     * 通过id删除信息
     * @param id
     */
    @Override
    public void deleteTrainNewsById(int id) {
        String sql = "delete from train_list where id =?";
        template.update(sql, new Object[]{id});
    }

    /**
     * 总页数
     * @param condition
     * @return
     */
    @Override
    public int findTrainNewsSearchTotalCount(Map<String, String[]> condition) {
        //定义模板初始化sql
        String sql = "select count(*) from train_list where 1=1 ";
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
     * 每页显示内容的集合
     * @param index
     * @param currentCount
     * @param condition
     * @return
     */
    @Override
    public List<NotificationBean> trainNewsSearchContextList(int index, int currentCount, Map<String, String[]> condition) {
        String sql = "select * from train_list where 1=1";
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
        sb.append(" order by publishTime desc limit ?,?");
        /*sb.append(" limit ?,?");*/
        //添加分页查询参数值
        //params.add(index,currentCount);
        params.add(index);
        params.add(currentCount);
        sql=sb.toString();
        System.out.println(sql);
        //System.out.println(params);
        return template.query(sql, new BeanPropertyRowMapper<NotificationBean>(NotificationBean.class),params.toArray());
    }

    /**
     * 通过id找到每个新闻的信息
     * @param id
     * @return
     */
    @Override
    public List<NotificationBean> findSingleTrainNewsInfo(int id) {
        String sql = "select * from train_list where id =?";
        return template.query(sql, new BeanPropertyRowMapper<NotificationBean>(NotificationBean.class), id);
    }

    @Override
    public List<NotificationBean> buttonNews() {
        String sql = "select * from match_list where title like '%第二届全国青年运动会%' order by publishTime desc";
        return template.query(sql, new BeanPropertyRowMapper<NotificationBean>(NotificationBean.class));

    }
}

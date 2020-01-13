package cn.anhui.karate.dao.impl;

import cn.anhui.karate.dao.NewsBeanDao;
import cn.anhui.karate.domain.FileBean;
import cn.anhui.karate.domain.NewsBean;
import cn.anhui.karate.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NewsBeanDaoImpl implements NewsBeanDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 保存新闻数据到数据库
     *
     * @param bean
     */
    @Override
    public void save(NewsBean bean) {
        //定义sql语句
        String sql = "insert into news_list(name,title,filepath,context,publishTime) values(?,?,?,?,?)";
        //执行sql语句
        template.update(sql,
                bean.getName(),
                bean.getTitle(),
                bean.getFilepath(),
                bean.getContext(),
                bean.getPublishTime()
        );
    }

    /**
     * 查询所有新闻
     *
     * @return
     */
    @Override
    public List<NewsBean> findAll() {
        String sql = "select * from news_list";
        return template.query(sql, new BeanPropertyRowMapper<NewsBean>(NewsBean.class));
    }

    /**
     * 通过id查找要删除新闻的所有信息
     *
     * @param id
     * @return
     */
    @Override
    public NewsBean findNewsInfo(int id) {
        NewsBean bean = null;
        try {
            String sql = "select * from news_list where id =?";
            bean = template.queryForObject(sql, new BeanPropertyRowMapper<NewsBean>(NewsBean.class), id);
        } catch (DataAccessException e) {
        }
        return bean;
    }

    /**
     * 通过id删除要删除的新闻
     *
     * @param id
     */
    @Override
    public void deleteById(int id) {
        String sql = "delete from news_list where id =?";
        template.update(sql, new Object[]{id});
    }



    /**
     * 通过id找到每个新闻的信息
     *
     * @param id
     * @return
     */
    @Override
    public List<NewsBean> findSingleNewInfo(int id) {
            String sql = "select * from news_list where id =?";
            return template.query(sql, new BeanPropertyRowMapper<NewsBean>(NewsBean.class), id);
    }



   /* @Override
    public int findNewsCenterTotalCount() {
        String sql = "select count(*) from news_list";
        Long query = template.queryForObject(sql, Long.class);
        return query.intValue();

    }
*/

    /*@Override
    public List<NewsBean> pageContextList(int index, int currentCount) {
        String sql = "select * from news_list limit ?,?";
        return template.query(sql, new BeanPropertyRowMapper<NewsBean>(NewsBean.class), index, currentCount);

    }*/

    /*@Override
    public int findTotalCount() {
        String sql = "select count(*) from news_list";
        Long query = template.queryForObject(sql, Long.class);
        return query.intValue();
    }

    @Override
    public List<NewsBean> pageList(int index, int currentCount) {
        String sql = "select * from news_list limit ?,?";
        return template.query(sql, new BeanPropertyRowMapper<NewsBean>(NewsBean.class), index, currentCount);
    }*/

    /**
     * 保存协会新闻到数据库
     * @param bean
     */
    @Override
    public void associationNewsSave(NewsBean bean) {
        //定义sql语句
        String sql = "insert into association_list(name,title,filepath,context,publishTime) values(?,?,?,?,?)";
        //执行sql语句
        template.update(sql,
                bean.getName(),
                bean.getTitle(),
                bean.getFilepath(),
                bean.getContext(),
                bean.getPublishTime()
        );
    }
    /**
     * 数据库中协会新闻的总条数
     * @return
     */
    /*@Override
    public int associationNewsTotalCount() {
        String sql = "select count(*) from association_list";
        Long query = template.queryForObject(sql, Long.class);
        return query.intValue();
    }*/


    /**
     * 每页要显示的数据的内容封装成集合
     * @param index
     * @param currentCount
     * @return
     */
   /* @Override
    public List<NewsBean> associationNewsPageList(int index, int currentCount) {
        String sql = "select * from association_list limit ?,?";
        return template.query(sql, new BeanPropertyRowMapper<NewsBean>(NewsBean.class), index, currentCount);

    }*/

    /**
     * 通过id查找要删除的协会新闻的信息
     * @param id
     * @return
     */
    @Override
    public NewsBean findAssociationNewsInfo(int id) {
        NewsBean bean = null;
        try {
            String sql = "select * from association_list where id =?";
            bean = template.queryForObject(sql, new BeanPropertyRowMapper<NewsBean>(NewsBean.class), id);
        } catch (DataAccessException e) {
        }
        return bean;
    }


    /**
     * 通过id删除要删除的新闻
     * @param id
     */
    @Override
    public void deleteAssociationNewsById(int id) {
        String sql = "delete from association_list where id =?";
        template.update(sql, new Object[]{id});
    }

    /**
     * 通过id找到每个协会新闻的信息
     * @param id
     * @return
     */
    @Override
    public List<NewsBean> findSingleAssociationNewInfo(int id) {
        String sql = "select * from association_list where id =?";
        return template.query(sql, new BeanPropertyRowMapper<NewsBean>(NewsBean.class), id);
    }


    /**
     * 查找新闻中心的新闻总数
     * @param condition
     * @return
     */
    @Override
    public int findNewsCenterSearchTotalCount(Map<String, String[]> condition) {
         //定义模板初始化sql
        String sql = "select count(*) from news_list where 1=1 ";
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
     * 或得分页数据的内容
     * @param index
     * @param currentCount
     * @param condition
     * @return
     */
    @Override
    public List<NewsBean> pageSearchContextList(int index, int currentCount, Map<String, String[]> condition) {
        String sql = "select * from news_list where 1=1";
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
        return template.query(sql, new BeanPropertyRowMapper<NewsBean>(NewsBean.class),params.toArray());
    }

    /**
     * 查找协会新闻的新闻总数
     * @param condition
     * @return
     */
    @Override
    public int findAssociationNewsSearchTotalCount(Map<String, String[]> condition) {
        //定义模板初始化sql
        String sql = "select count(*) from association_list where 1=1 ";
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
     * 或得协会新闻的分页数据的内容
     * @param index
     * @param currentCount
     * @param condition
     * @return
     */
    @Override
    public List<NewsBean> associationNewsSearchContextList(int index, int currentCount, Map<String, String[]> condition) {
        String sql = "select * from association_list where 1=1";
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
       /* sb.append(" limit ?,?");*/
        //添加分页查询参数值
        //params.add(index,currentCount);
        params.add(index);
        params.add(currentCount);
        sql=sb.toString();
        System.out.println(sql);
        //System.out.println(params);
        return template.query(sql, new BeanPropertyRowMapper<NewsBean>(NewsBean.class),params.toArray());
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public NewsBean findNewsInfoById(int id) {
        String sql="select * from news_list where id=?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<NewsBean>(NewsBean.class),id);
    }

    /**
     * 更新新闻
     * @param bean
     */
    @Override
    public void updateNews(NewsBean bean) {
        String sql="update news_list set title=?,context=? where id=?";
        template.update(sql,bean.getTitle(),bean.getContext(),bean.getId());
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public NewsBean findAssociationInfoById(int id) {
        String sql="select * from association_list where id=?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<NewsBean>(NewsBean.class),id);
    }

    /**
     * 更新协会新闻
     * @param bean
     */
    @Override
    public void updateAssociation(NewsBean bean) {
        String sql="update association_list set title=?,context=? where id=?";
        template.update(sql,bean.getTitle(),bean.getContext(),bean.getId());
    }
}

package cn.anhui.karate.dao.impl;

import cn.anhui.karate.dao.FileBeanDao;
import cn.anhui.karate.domain.FileBean;
import cn.anhui.karate.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FileBeanDaoImpl implements FileBeanDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 保存文件到数据库
     * @param bean
     */
    @Override
    public void save(FileBean bean) {
        //定义sql语句
        String sql = "insert into picture_list(name,size,type,uploadTime,filepath,information) values(?,?,?,?,?,?)";
        //执行sql语句
        template.update(sql,
                bean.getName(),
                bean.getSize(),
                bean.getType(),
                bean.getUploadTime(),
                bean.getFilepath(),
                bean.getInformation()
        );
    }

    /**
     * 查询数据库中所有图片
     * @return
     */
    @Override
    public List<FileBean> findAll() {
        //定义sql语句
        String sql="select * from picture_list";
        return template.query(sql,new BeanPropertyRowMapper<FileBean>(FileBean.class));
    }

    /**
     * 保存上传的文件
     * @param bean
     */
    @Override
    public void saveFile(FileBean bean) {
        //定义sql语句
        String sql = "insert into file_list(name,size,type,uploadTime,filepath,information) values(?,?,?,?,?,?)";
        //执行sql语句
        template.update(sql,
                bean.getName(),
                bean.getSize(),
                bean.getType(),
                bean.getUploadTime(),
                bean.getFilepath(),
                bean.getInformation()
        );
    }

    /**
     * 查询数据库中所有文件
     * @return
     */
    @Override
    public List<FileBean> findFileAll() {
        //定义sql语句
        String sql="select * from file_list";
        return template.query(sql,new BeanPropertyRowMapper<FileBean>(FileBean.class));
    }

    /**
     * 通过Id删除图片信息
     * @param id
     */
    @Override
    public void deleteFindById(int id) {
        String sql="delete from picture_list where id =?";
        template.update(sql,new Object[]{id});
    }

    /**
     * 通过id删除图片
     * @param id
     * @return
     */
    @Override
    public FileBean findDeletePictureInfo(int id) {
        FileBean bean=null;
        try {
            String sql="select * from picture_list where id =?";
            bean=template.queryForObject(sql,new BeanPropertyRowMapper<FileBean>(FileBean.class),id);
        } catch (DataAccessException e) {
        }
        return bean;
    }

    /**
     * 通过id删除文件
     * @param id
     * @return
     */
    @Override
    public FileBean findDeleteFileInfo(int id) {
        FileBean bean=null;
        try {
            String sql="select * from file_list where id =?";
            bean=template.queryForObject(sql,new BeanPropertyRowMapper<FileBean>(FileBean.class),id);
        } catch (DataAccessException e) {
        }
        return bean;
    }

    /**
     * 通过id删除数据库中的文件
     * @param id
     */
    @Override
    public void deleteById(int id) {
        String sql="delete from file_list where id =?";
        template.update(sql,new Object[]{id});
    }
    /**
     * 获得全部商品的条数
     * @return
     * @param condition
     */

    @Override
    public int getTotalCount(Map<String, String[]> condition) {
       /* String sql = "select count(*) from file_list";
        Long query = template.queryForObject(sql, Long.class);
        return query.intValue();*/
        //定义模板初始化sql
        String sql = "select count(*) from file_list where 1=1 ";
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
     * 或得分页的商品数据
     * @param index
     * @param currentCount
     * @param condition
     * @return
     */
    @Override
    public List<FileBean> findFileListForPageBean(int index, int currentCount, Map<String, String[]> condition) {
        /*String sql = "select * from file_list limit ?,?";
        return template.query(sql,new BeanPropertyRowMapper<FileBean>(FileBean.class),index,currentCount);*/
        String sql = "select * from file_list where 1=1";
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
        sb.append(" order by uploadTime desc limit ?,?");
        /*sb.append(" limit ?,?");*/
        //添加分页查询参数值
        //params.add(index,currentCount);
        params.add(index);
        params.add(currentCount);
        sql=sb.toString();
        System.out.println(sql);
        //System.out.println(params);
        return template.query(sql, new BeanPropertyRowMapper<FileBean>(FileBean.class),params.toArray());
    }


    /**
     * 或得总页数
     * @param condition
     * @return
     */
    @Override
    public int getPictureTotalCount(Map<String, String[]> condition) {
        /*String sql = "select count(*) from picture_list";
        Long query = template.queryForObject(sql, Long.class);
        return query.intValue();*/
    /* String sql = "select count(*) from file_list";
        Long query = template.queryForObject(sql, Long.class);
        return query.intValue();*/
        //定义模板初始化sql
        String sql = "select count(*) from picture_list where 1=1 ";
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
     * 条件分页
     * @param index
     * @param currentCount
     * @param condition
     * @return
     */
    @Override
    public List<FileBean> findPictureListForPageBean(int index, int currentCount, Map<String, String[]> condition) {
        /*String sql = "select * from picture_list limit ?,?";
        return template.query(sql,new BeanPropertyRowMapper<FileBean>(FileBean.class),index,currentCount);*/
        String sql = "select * from picture_list where 1=1";
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
        sb.append(" order by uploadTime desc limit ?,?");
        /*sb.append(" limit ?,?");*/
        //添加分页查询参数值
        //params.add(index,currentCount);
        params.add(index);
        params.add(currentCount);
        sql=sb.toString();
        System.out.println(sql);
        //System.out.println(params);
        return template.query(sql, new BeanPropertyRowMapper<FileBean>(FileBean.class),params.toArray());
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public FileBean findPictureById(int id) {
        String sql="select * from picture_list where id=?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<FileBean>(FileBean.class),id);
    }

    /**
     * 修改图片信息
     * @param bean
     */
    @Override
    public void updatePicture(FileBean bean) {
        String sql="update picture_list set information=? where id=?";
        template.update(sql,bean.getInformation(),bean.getId());
    }
}


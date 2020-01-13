package cn.anhui.karate.service.impl;

import cn.anhui.karate.dao.VideoBeanDao;
import cn.anhui.karate.dao.impl.VideoBeanDaoImpl;
import cn.anhui.karate.domain.PageBean;
import cn.anhui.karate.domain.VideoBean;
import cn.anhui.karate.service.VideoBeanService;

import java.util.List;
import java.util.Map;

public class VideoBeanServiceImpl implements VideoBeanService {
    private VideoBeanDao dao=new VideoBeanDaoImpl();

    /**
     * 保存数据到数据库
     * @param bean
     */
    @Override
    public void saveVideo(VideoBean bean) {
        dao.saveVideo(bean);
    }

    /**
     * 分页
     * @param currentPage
     * @param currentCount
     * @param condition
     * @return
     */
    @Override
    public PageBean<VideoBean> findVideoPageBean(int currentPage, int currentCount, Map<String, String[]> condition) {
        //封装成PageBean并返回
        PageBean<VideoBean> pageBean=new PageBean<VideoBean>();
        //当前页private int currentPage;
        pageBean.setCurrentPage(currentPage);
        //当前页显示的条数private int currentCount;
        pageBean.setCurrentCount(currentCount);
        //总条数private int totalCount;
        int totalCount=dao.videoTotalCount(condition);
        pageBean.setTotalCount(totalCount);
        //总页数private int totalPage;
        /**
         * 公式：总页数=Math.ceil(总条数/当前显示的条数)
         */
        int totalPage=(totalCount%currentCount)*currentCount==0?totalCount/currentCount:(totalCount/currentCount)+1;
        /*int totalPage=(int) Math.ceil(1.0*totalCount/currentCount);*/
        pageBean.setTotalPage(totalPage);
        //每页显示数据private List<T> productList=new ArrayList<T>();
        /**
         * 页数与limit起始所以的关系
         * 例如每页显示4条
         *   页数         起始索引       每页显示条数
         *   1              0             4
         *   2              4             4
         *   3              8             4
         *   4              12            4
         *
         *   索引index=（当前页-1）*每页显示条数
         */
        int index=(currentPage-1)*currentCount;
        List<VideoBean> list =dao.videoPageList(index,currentCount,condition);
        pageBean.setList(list);

        return pageBean;
    }

    /**
     * 通过id查找要删除的视频的信息
     * @param id
     * @return
     */
    @Override
    public VideoBean findVideoInfo(int id) {
        return dao.findVideoInfo(id);
    }

    /**
     * 通过id删除信息
     * @param id
     */
    @Override
    public void findVideoById(int id) {
        dao.deleteVideoById(id);
    }

    /**
     * 查找数据库中的视频封装成集合
     * @return
     */
    @Override
    public List<VideoBean> findVideoNewsInfo() {
        return dao.findVideoNewsInfo();
    }
}

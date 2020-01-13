package cn.anhui.karate.service.impl;

import cn.anhui.karate.dao.PictureBeanDao;
import cn.anhui.karate.dao.impl.PictureBeanDaoImpl;
import cn.anhui.karate.domain.PageBean;
import cn.anhui.karate.domain.PictureBean;
import cn.anhui.karate.domain.VideoBean;
import cn.anhui.karate.service.PictureBeanService;

import java.util.List;
import java.util.Map;

public class PictureBeanServiceImpl implements PictureBeanService {
    private PictureBeanDao dao=new PictureBeanDaoImpl();
    /**
     * 保存赛事图片到数据库
     * @param bean
     */
    @Override
    public void saveMatchPicture(PictureBean bean) {
        dao.saveMatchPicture(bean);
    }

    /**
     * 赛事图片条件分页
     * @param currentPage
     * @param currentCount
     * @param condition
     * @return
     */
    @Override
    public PageBean<PictureBean> matchPictureSearchPageBean(int currentPage, int currentCount, Map<String, String[]> condition) {
        //封装成PageBean并返回
        PageBean<PictureBean> pageBean=new PageBean<PictureBean>();
        //当前页private int currentPage;
        pageBean.setCurrentPage(currentPage);
        //当前页显示的条数private int currentCount;
        pageBean.setCurrentCount(currentCount);
        //总条数private int totalCount;
        int totalCount=dao.matchPictureTotalCount(condition);
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
        List<PictureBean> list =dao.matchPicturePageList(index,currentCount,condition);
        pageBean.setList(list);

        return pageBean;
    }

    /**
     * 查找要删除赛事图片的信息
     * @param id
     * @return
     */
    @Override
    public PictureBean findMatchPictureInfo(int id) {
        return dao.findMatchPictureInfo(id);
    }

    /**
     * 通过id删除
     * @param id
     */
    @Override
    public void findMatchPictureById(int id) {
        dao.deleteMatchPictureById(id);
    }

    /**
     * 保存活动图片到数据库
     * @param bean
     */
    @Override
    public void saveActivityPicture(PictureBean bean) {
        dao.saveActivityPicture(bean);
    }

    /**
     * 活动图片的条件分页
     * @param currentPage
     * @param currentCount
     * @param condition
     * @return
     */
    @Override
    public PageBean<PictureBean> activityPictureSearchPageBean(int currentPage, int currentCount, Map<String, String[]> condition) {
        //封装成PageBean并返回
        PageBean<PictureBean> pageBean=new PageBean<PictureBean>();
        //当前页private int currentPage;
        pageBean.setCurrentPage(currentPage);
        //当前页显示的条数private int currentCount;
        pageBean.setCurrentCount(currentCount);
        //总条数private int totalCount;
        int totalCount=dao.activityPictureTotalCount(condition);
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
        List<PictureBean> list =dao.activityPicturePageList(index,currentCount,condition);
        pageBean.setList(list);

        return pageBean;
    }

    /**
     * 查找数据库中活动图片的信息
     * @param id
     * @return
     */
    @Override
    public PictureBean findActivityPictureInfo(int id) {
        return dao.findActivityPictureInfo(id);
    }

    /**
     * 通过id删除
     * @param id
     */
    @Override
    public void findActivityPictureById(int id) {
        dao.deleteActivityPictureById(id);
    }
}

package cn.anhui.karate.service.impl;

import cn.anhui.karate.dao.NotificationBeanDao;
import cn.anhui.karate.dao.impl.NotificationBeanServiceDaoImpl;
import cn.anhui.karate.domain.NotificationBean;
import cn.anhui.karate.domain.PageBean;
import cn.anhui.karate.service.NotificationBeanService;

import java.util.List;
import java.util.Map;

public class NotificationBeanServiceImpl implements NotificationBeanService {
    private NotificationBeanDao dao=new NotificationBeanServiceDaoImpl();

    /**
     * 保存比赛通知到数据库
     * @param bean
     */
    @Override
    public void saveNotification(NotificationBean bean) {
        dao.saveNotification(bean);
    }
    /**
     * 比赛通知的分页显示
     * @param currentPage
     * @param currentCount
     * @return
     */
    /*@Override
    public PageBean<NotificationBean> findMatchPageBean(int currentPage, int currentCount) {
        //封装成PageBean并返回
        PageBean<NotificationBean> pageBean=new PageBean<NotificationBean>();
        //当前页private int currentPage;
        pageBean.setCurrentPage(currentPage);
        //当前页显示的条数private int currentCount;
        pageBean.setCurrentCount(currentCount);
        //总条数private int totalCount;
        int totalCount=dao.matchNewsTotalCount();
        pageBean.setTotalCount(totalCount);
        //总页数private int totalPage;
        *//**
         * 公式：总页数=Math.ceil(总条数/当前显示的条数)
         *//*
        int totalPage=(totalCount%currentCount)*currentCount==0?totalCount/currentCount:(totalCount/currentCount)+1;
        *//*int totalPage=(int) Math.ceil(1.0*totalCount/currentCount);*//*
        pageBean.setTotalPage(totalPage);
        //每页显示数据private List<T> productList=new ArrayList<T>();
        *//**
         * 页数与limit起始所以的关系
         * 例如每页显示4条
         *   页数         起始索引       每页显示条数
         *   1              0             4
         *   2              4             4
         *   3              8             4
         *   4              12            4
         *
         *   索引index=（当前页-1）*每页显示条数
         *//*
        int index=(currentPage-1)*currentCount;
        List<NotificationBean> list =dao.matchNewsPageList(index,currentCount);
        pageBean.setList(list);

        return pageBean;
    }*/

    /**
     * 通过id查找要删除的比赛通知的信息
     * @param id
     * @return
     */
    @Override
    public NotificationBean findMatchNewsInfo(int id) {
        return dao.findMatchNewsInfo(id);
    }

    /**
     * 通过id删除信息
     * @param id
     */
    @Override
    public void findMatchNewsById(int id) {
        dao.deleteMatchNewsById(id);
    }

    /**
     * 比赛通知的条件分页
     * @param currentPage
     * @param currentCount
     * @param condition
     * @return
     */
    @Override
    public PageBean<NotificationBean> matchNewsCenterSearchPageBean(int currentPage, int currentCount, Map<String, String[]> condition) {
        //封装成PageBean并返回
        PageBean<NotificationBean> pageBean=new PageBean<NotificationBean>();
        //当前页private int currentPage;
        pageBean.setCurrentPage(currentPage);
        //当前页显示的条数private int currentCount;
        pageBean.setCurrentCount(currentCount);
        //总条数private int totalCount;
        int totalCount=dao.findMatchNewsSearchTotalCount(condition);
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
        List<NotificationBean> list =dao.matchNewsSearchContextList(index,currentCount,condition);
        pageBean.setList(list);

        return pageBean;
    }

    /**
     * 通过id找到每个新闻的信息
     * @param id
     * @return
     */
    @Override
    public List<NotificationBean> findSingleMatchNewsInfo(int id) {
        return dao.findSingleMatchNewsInfo(id);
    }

    /**
     * 保存培训新闻到数据库
     * @param bean
     */
    @Override
    public void saveTrainNews(NotificationBean bean) {
        dao.saveTrainNews(bean);
    }

    /**
     * 培训通知的分页显示
     * @param currentPage
     * @param currentCount
     * @param condition
     * @return
     */
    /*@Override
    public PageBean<NotificationBean> findTrainPageBean(int currentPage, int currentCount, Map<String, String[]> condition) {
        //封装成PageBean并返回
        PageBean<NotificationBean> pageBean=new PageBean<NotificationBean>();
        //当前页private int currentPage;
        pageBean.setCurrentPage(currentPage);
        //当前页显示的条数private int currentCount;
        pageBean.setCurrentCount(currentCount);
        //总条数private int totalCount;
        int totalCount=dao.trainNewsTotalCount();
        pageBean.setTotalCount(totalCount);
        //总页数private int totalPage;
        *//**
         * 公式：总页数=Math.ceil(总条数/当前显示的条数)
         *//*
        int totalPage=(totalCount%currentCount)*currentCount==0?totalCount/currentCount:(totalCount/currentCount)+1;
        *//*int totalPage=(int) Math.ceil(1.0*totalCount/currentCount);*//*
        pageBean.setTotalPage(totalPage);
        //每页显示数据private List<T> productList=new ArrayList<T>();
        *//**
         * 页数与limit起始所以的关系
         * 例如每页显示4条
         *   页数         起始索引       每页显示条数
         *   1              0             4
         *   2              4             4
         *   3              8             4
         *   4              12            4
         *
         *   索引index=（当前页-1）*每页显示条数
         *//*
        int index=(currentPage-1)*currentCount;
        List<NotificationBean> list =dao.trainNewsPageList(index,currentCount);
        pageBean.setList(list);

        return pageBean;
    }*/

    /**
     * 通过id查找要删除的培训通知的信息
     * @param id
     * @return
     */
    @Override
    public NotificationBean findTrainNewsInfo(int id) {
        return dao.findTrainNewsInfo(id);
    }

    /**
     * 通过id删除信息
     * @param id
     */
    @Override
    public void findTrainNewsById(int id) {
        dao.deleteTrainNewsById(id);
    }

    /**
     * 培训通知的条件分页
     * @param currentPage
     * @param currentCount
     * @param condition
     * @return
     */
    @Override
    public PageBean<NotificationBean> trainNewsCenterSearchPageBean(int currentPage, int currentCount, Map<String, String[]> condition) {
        //封装成PageBean并返回
        PageBean<NotificationBean> pageBean=new PageBean<NotificationBean>();
        //当前页private int currentPage;
        pageBean.setCurrentPage(currentPage);
        //当前页显示的条数private int currentCount;
        pageBean.setCurrentCount(currentCount);
        //总条数private int totalCount;
        int totalCount=dao.findTrainNewsSearchTotalCount(condition);
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
        List<NotificationBean> list =dao.trainNewsSearchContextList(index,currentCount,condition);
        pageBean.setList(list);

        return pageBean;
    }

    /**
     * 通过id找到每个新闻的信息
     * @param id
     * @return
     */
    @Override
    public List<NotificationBean> findSingleTrainNewsInfo(int id) {
        return dao.findSingleTrainNewsInfo(id);
    }

    @Override
    public List<NotificationBean> buttonNews() {
        return dao.buttonNews();
    }
}

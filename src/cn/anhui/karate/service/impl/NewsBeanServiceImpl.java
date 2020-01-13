package cn.anhui.karate.service.impl;

import cn.anhui.karate.dao.NewsBeanDao;
import cn.anhui.karate.dao.impl.NewsBeanDaoImpl;
import cn.anhui.karate.domain.NewsBean;
import cn.anhui.karate.domain.PageBean;
import cn.anhui.karate.service.NewsBeanService;

import java.util.List;
import java.util.Map;

public class NewsBeanServiceImpl implements NewsBeanService {
    private NewsBeanDao dao=new NewsBeanDaoImpl();
    /**
     * 保存数据到数据库
     * @param bean
     */
    @Override
    public void save(NewsBean bean) {
        dao.save(bean);
    }

    /**
     * 查询所有新闻
     * @return
     */
    @Override
    public List<NewsBean> findAll() {
        return dao.findAll();
    }

    /**
     * 通过id查找要删除新闻的所有信息
     * @param id
     * @return
     */
    @Override
    public NewsBean findNewsInfo(int id) {
        return dao.findNewsInfo(id);
    }
    /**
     * 通过id删除要删除的新闻
     * @param id
     */
    @Override
    public void findNewsById(int id) {
        dao.deleteById(id);
    }


    /**
     * 通过id找到每个新闻的信息
     * @param id
     * @return
     */
    @Override
    public List<NewsBean> findSingleNewInfo(int id) {
        return dao.findSingleNewInfo(id);
    }


    /**
     * 新闻中心的分页
     * @param currentPage
     * @param currentCount
     * @param condition
     * @return
     */
    @Override
    public PageBean<NewsBean> newsCenterSearchPageBean(int currentPage, int currentCount, Map<String, String[]> condition) {
        //封装成PageBean并返回
        PageBean<NewsBean> pageBean=new PageBean<NewsBean>();
        //当前页private int currentPage;
        pageBean.setCurrentPage(currentPage);
        //当前页显示的条数private int currentCount;
        pageBean.setCurrentCount(currentCount);
        //总条数private int totalCount;
        int totalCount=dao.findNewsCenterSearchTotalCount(condition);
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
        List<NewsBean> list =dao.pageSearchContextList(index,currentCount,condition);
        pageBean.setList(list);

        return pageBean;
    }

    /**
     * 新闻中心的分页
     * @param currentPage
     * @param currentCount
     * @return
     */
   /* @Override
    public PageBean<NewsBean> newsCenterPageBean(int currentPage, int currentCount) {
        //封装成PageBean并返回
        PageBean<NewsBean> pageBean=new PageBean<NewsBean>();
        //当前页private int currentPage;
        pageBean.setCurrentPage(currentPage);
        //当前页显示的条数private int currentCount;
        pageBean.setCurrentCount(currentCount);
        //总条数private int totalCount;
        int totalCount=dao.findNewsCenterTotalCount();
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
        List<NewsBean> list =dao.pageContextList(index,currentCount);
        pageBean.setList(list);

        return pageBean;
    }*/

   /* @Override
    public PageBean<NewsBean> findPageBean(int currentPage, int currentCount, Map<String, String[]> condition) {
        //封装成PageBean并返回
        PageBean<NewsBean> pageBean=new PageBean<NewsBean>();
        //当前页private int currentPage;
        pageBean.setCurrentPage(currentPage);
        //当前页显示的条数private int currentCount;
        pageBean.setCurrentCount(currentCount);
        //总条数private int totalCount;
        int totalCount=dao.findTotalCount();
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
        List<NewsBean> list =dao.pageList(index,currentCount);
        pageBean.setList(list);

        return pageBean;
    }*/

    /**
     * 保存协会新闻到数据库
     * @param bean
     */
    @Override
    public void associationNewsSave(NewsBean bean) {
        dao.associationNewsSave(bean);
    }


    /**
     * 对协会新闻进行分页展示
     * @param currentPage
     * @param currentCount
     * @return
     */
   /* @Override
    public PageBean<NewsBean> associationNewsPageBean(int currentPage, int currentCount) {
        //封装成PageBean并返回
        PageBean<NewsBean> pageBean=new PageBean<NewsBean>();
        //当前页private int currentPage;
        pageBean.setCurrentPage(currentPage);
        //当前页显示的条数private int currentCount;
        pageBean.setCurrentCount(currentCount);
        //总条数private int totalCount;
        int totalCount=dao.associationNewsTotalCount();
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
        List<NewsBean> list =dao.associationNewsPageList(index,currentCount);
        pageBean.setList(list);

        return pageBean;
    }
*/
    /**
     * 通过id查找要删除的协会新闻的信息
     * @param id
     * @return
     */
    @Override
    public NewsBean findAssociationNewsInfo(int id) {
        return dao.findAssociationNewsInfo(id);
    }


    /**
     * 通过id删除要删除的新闻
     * @param id
     */
    @Override
    public void findAssociationNewsById(int id) {
        dao.deleteAssociationNewsById(id);
    }


    /**
     * 协会新闻分页
     * @param currentPage
     * @param currentCount
     * @return
     */
    /*@Override
    public PageBean<NewsBean> associationNewsPage(int currentPage, int currentCount) {
        //封装成PageBean并返回
        PageBean<NewsBean> pageBean=new PageBean<NewsBean>();
        //当前页private int currentPage;
        pageBean.setCurrentPage(currentPage);
        //当前页显示的条数private int currentCount;
        pageBean.setCurrentCount(currentCount);
        //总条数private int totalCount;
        int totalCount=dao.associationNewsTotalCount();
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
        List<NewsBean> list =dao.associationNewsPageList(index,currentCount);
        pageBean.setList(list);

        return pageBean;
    }
*/
    /**
     * 通过id找到每个协会新闻的信息
     * @param id
     * @return
     */
    @Override
    public List<NewsBean> findSingleAssociationNewInfo(int id) {
        return dao.findSingleAssociationNewInfo(id);
    }

    /**
     * 协会新闻的条件分页
     * @param currentPage
     * @param currentCount
     * @param condition
     * @return
     */
    @Override
    public PageBean<NewsBean> associationNewsSearchPageBean(int currentPage, int currentCount, Map<String, String[]> condition) {
        //封装成PageBean并返回
        PageBean<NewsBean> pageBean=new PageBean<NewsBean>();
        //当前页private int currentPage;
        pageBean.setCurrentPage(currentPage);
        //当前页显示的条数private int currentCount;
        pageBean.setCurrentCount(currentCount);
        //总条数private int totalCount;
        int totalCount=dao.findAssociationNewsSearchTotalCount(condition);
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
        List<NewsBean> list =dao.associationNewsSearchContextList(index,currentCount,condition);
        pageBean.setList(list);

        return pageBean;
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public NewsBean findNewsInfoById(String id) {
        return dao.findNewsInfoById(Integer.parseInt(id));
    }

    /**
     * 更新新闻
     * @param bean
     */
    @Override
    public void updateNews(NewsBean bean) {
        dao.updateNews(bean);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public NewsBean findAssociationInfoById(String id) {
        return dao.findAssociationInfoById(Integer.parseInt(id));
    }

    /**
     * 更新协会新闻
     * @param bean
     */
    @Override
    public void updateAssociation(NewsBean bean) {
        dao.updateAssociation(bean);
    }
}

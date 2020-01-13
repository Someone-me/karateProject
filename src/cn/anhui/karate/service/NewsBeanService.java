package cn.anhui.karate.service;

import cn.anhui.karate.domain.NewsBean;
import cn.anhui.karate.domain.PageBean;

import java.util.List;
import java.util.Map;

public interface NewsBeanService {
    /**
     * 保存数据到数据库
     * @param bean
     */
    void save(NewsBean bean);

    /**
     * 查询所有新闻
     * @return
     */
    List<NewsBean> findAll();

    /**
     * 通过id查找要删除新闻的所有信息
     * @param id
     * @return
     */
    NewsBean findNewsInfo(int id);

    /**
     * 通过id删除要删除的新闻
     * @param id
     */
    void findNewsById(int id);


    /**
     * 通过id找到每个新闻的信息
     * @param id
     * @return
     */
    List<NewsBean> findSingleNewInfo(int id);


    /**
     * 分页
     * @param currentPage
     * @param currentCount
     * @param condition
     * @return
     */
    /*PageBean<NewsBean> findPageBean(int currentPage, int currentCount, Map<String, String[]> condition);*/

    /**
     * 保存协会新闻到数据库
     * @param bean
     */
    void associationNewsSave(NewsBean bean);

    /**
     * 对协会新闻信息进行分页展示
     * @param currentPage
     * @param currentCount
     * @return
     */
    /*PageBean<NewsBean> associationNewsPageBean(int currentPage, int currentCount);*/

    /**
     * 通过id查找要删除的协会新闻的信息
     * @param id
     * @return
     */
    NewsBean findAssociationNewsInfo(int id);


    /**
     * 通过id删除要删除的新闻
     * @param id
     */
    void findAssociationNewsById(int id);

    /**
     * 协会新闻分页
     * @param currentPage
     * @param currentCount
     * @return
     */
    /*PageBean<NewsBean> associationNewsPage(int currentPage, int currentCount);*/

    /**
     * 通过id找到每个协会新闻的信息
     * @param id
     * @return
     */
    List<NewsBean> findSingleAssociationNewInfo(int id);

    /**
     * 新闻中心分页
     * @param currentPage
     * @param currentCount
     * @return
     */
   /* PageBean<NewsBean> newsCenterPageBean(int currentPage, int currentCount);*/

    PageBean<NewsBean> newsCenterSearchPageBean(int currentPage, int currentCount, Map<String, String[]> condition);

    /**
     * 协会新闻的条件查询分页
     * @param currentPage
     * @param currentCount
     * @param condition
     * @return
     */
    PageBean<NewsBean> associationNewsSearchPageBean(int currentPage, int currentCount, Map<String, String[]> condition);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    NewsBean findNewsInfoById(String id);

    /**
     * 更新新闻
     * @param bean
     */
    void updateNews(NewsBean bean);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    NewsBean findAssociationInfoById(String id);

    /**
     * 更新协会新闻
     * @param bean
     */
    void updateAssociation(NewsBean bean);
}

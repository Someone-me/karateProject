package cn.anhui.karate.dao;

import cn.anhui.karate.domain.NewsBean;

import java.util.List;
import java.util.Map;

public interface NewsBeanDao {
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
    void deleteById(int id);


    /**
     * 通过id找到每个新闻的信息
     * @param id
     * @return
     */
    List<NewsBean> findSingleNewInfo(int id);


    /**
     * 查找新闻中心的新闻总数
     * @return
     */
   /* int findNewsCenterTotalCount();*/


   /* List<NewsBean> pageContextList(int index, int currentCount);*/

   /* int findTotalCount();

    List<NewsBean> pageList(int index, int currentCount);*/

    /**
     * 保存协会新闻到数据库
     * @param bean
     */
    void associationNewsSave(NewsBean bean);

    /**
     * 数据库中协会新闻的总条数
     * @return
     */
    /*int associationNewsTotalCount();*/

    /**
     * 每页要显示的数据的内容封装成集合
     * @param index
     * @param currentCount
     * @return
     */
    /*List<NewsBean> associationNewsPageList(int index, int currentCount);*/

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
    void deleteAssociationNewsById(int id);

    /**
     * 通过id找到每个协会新闻的信息
     * @param id
     * @return
     */
    List<NewsBean> findSingleAssociationNewInfo(int id);

    /**
     * 查找新闻中心的新闻总数
     * @return
     */
    int findNewsCenterSearchTotalCount(Map<String, String[]> condition);

    /**
     * 或得分页数据的内容
     * @param index
     * @param currentCount
     * @param condition
     * @return
     */
    List<NewsBean> pageSearchContextList(int index, int currentCount, Map<String, String[]> condition);

    /**
     * 查找协会新闻的新闻总数
     * @return
     */
    int findAssociationNewsSearchTotalCount(Map<String, String[]> condition);

    /**
     * 或得协会新闻分页数据的内容
     * @param index
     * @param currentCount
     * @param condition
     * @return
     */
    List<NewsBean> associationNewsSearchContextList(int index, int currentCount, Map<String, String[]> condition);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    NewsBean findNewsInfoById(int id);

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
    NewsBean findAssociationInfoById(int id);

    /**
     * 更新协会新闻
     * @param bean
     */
    void updateAssociation(NewsBean bean);
}

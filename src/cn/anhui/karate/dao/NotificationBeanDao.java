package cn.anhui.karate.dao;

import cn.anhui.karate.domain.NotificationBean;

import java.util.List;
import java.util.Map;

public interface NotificationBeanDao {
    /**
     * 保存比赛通知到数据库
     * @param bean
     */
    void saveNotification(NotificationBean bean);

    /**
     * 数据库中比赛通知的总条数
     * @return
     */
    /*int matchNewsTotalCount();*/


    /**
     * 分页展示的每页数据的集合
     * @param index
     * @param currentCount
     * @return
     */
   /* List<NotificationBean> matchNewsPageList(int index, int currentCount);*/

    /**
     * 通过id查找要删除的比赛通知的信息
     * @param id
     * @return
     */
    NotificationBean findMatchNewsInfo(int id);

    /**
     * 通过id删除信息
     * @param id
     */
    void deleteMatchNewsById(int id);

    /**
     * 总页数
     * @param condition
     * @return
     */
    int findMatchNewsSearchTotalCount(Map<String, String[]> condition);

    /**
     * 每页显示内容的集合
     * @param index
     * @param currentCount
     * @param condition
     * @return
     */
    List<NotificationBean> matchNewsSearchContextList(int index, int currentCount, Map<String, String[]> condition);

    /**
     * 通过id找到每个新闻的信息
     * @param id
     * @return
     */
    List<NotificationBean> findSingleMatchNewsInfo(int id);

    /**
     * 保存培训新闻到数据库
     * @param bean
     */
    void saveTrainNews(NotificationBean bean);

    /**
     * 数据库中培训通知的总条数
     * @return
     */
   /* int trainNewsTotalCount();*/

    /**
     * 分页展示的每页数据的集合
     * @param index
     * @param currentCount
     * @return
     */
    /*List<NotificationBean> trainNewsPageList(int index, int currentCount);*/

    /**
     * 通过id查找要删除的培训通知的信息
     * @param id
     * @return
     */
    NotificationBean findTrainNewsInfo(int id);

    /**
     * 通过id删除信息
     * @param id
     */
    void deleteTrainNewsById(int id);

    /**
     * 总页数
     * @param condition
     * @return
     */
    int findTrainNewsSearchTotalCount(Map<String, String[]> condition);

    /**
     * 每页显示内容的集合
     * @param index
     * @param currentCount
     * @param condition
     * @return
     */
    List<NotificationBean> trainNewsSearchContextList(int index, int currentCount, Map<String, String[]> condition);

    /**
     * 通过id找到每个新闻的信息
     * @param id
     * @return
     */
    List<NotificationBean> findSingleTrainNewsInfo(int id);

    List<NotificationBean> buttonNews();
}

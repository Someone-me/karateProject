package cn.anhui.karate.service;

import cn.anhui.karate.domain.NotificationBean;
import cn.anhui.karate.domain.PageBean;

import java.util.List;
import java.util.Map;

public interface NotificationBeanService {
    /**
     * 保存比赛通知到数据库
     * @param bean
     */
    void saveNotification(NotificationBean bean);

    /**
     * 比赛通知的分页显示
     * @param currentPage
     * @param currentCount
     * @return
     */
    /*PageBean<NotificationBean> findMatchPageBean(int currentPage, int currentCount);*/

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
    void findMatchNewsById(int id);

    /**
     * 比赛通知的条件分页
     * @param currentPage
     * @param currentCount
     * @param condition
     * @return
     */
    PageBean<NotificationBean> matchNewsCenterSearchPageBean(int currentPage, int currentCount, Map<String, String[]> condition);

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
     * 培训通知的分页显示
     * @param currentPage
     * @param currentCount
     * @param condition
     * @return
     */
   /* PageBean<NotificationBean> findTrainPageBean(int currentPage, int currentCount, Map<String, String[]> condition);*/

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
    void findTrainNewsById(int id);

    /**
     * 培训通知的条件分页
     * @param currentPage
     * @param currentCount
     * @param condition
     * @return
     */
    PageBean<NotificationBean> trainNewsCenterSearchPageBean(int currentPage, int currentCount, Map<String, String[]> condition);

    /**
     * 通过id找到每个新闻的信息
     * @param id
     * @return
     */
    List<NotificationBean> findSingleTrainNewsInfo(int id);


    List<NotificationBean> buttonNews();
}

package cn.anhui.karate.service;

import cn.anhui.karate.domain.PageBean;
import cn.anhui.karate.domain.PictureBean;

import java.util.Map;

public interface PictureBeanService {
    /**
     * 保存赛事图片到数据库
     * @param bean
     */
    void saveMatchPicture(PictureBean bean);

    /**
     * 条件分页
     * @param currentPage
     * @param currentCount
     * @param condition
     * @return
     */
    PageBean<PictureBean> matchPictureSearchPageBean(int currentPage, int currentCount, Map<String, String[]> condition);

    /**
     * 查找要删除赛事图片的信息
     * @param id
     * @return
     */
    PictureBean findMatchPictureInfo(int id);

    /**
     * 通过id删除
     * @param id
     */
    void findMatchPictureById(int id);

    /**
     * 保存活动图片到数据库
     * @param bean
     */
    void saveActivityPicture(PictureBean bean);

    /**
     * 活动图片的条件分页
     * @param currentPage
     * @param currentCount
     * @param condition
     * @return
     */
    PageBean<PictureBean> activityPictureSearchPageBean(int currentPage, int currentCount, Map<String, String[]> condition);

    /**
     * 查找数据库中活动图片的信息
     * @param id
     * @return
     */
    PictureBean findActivityPictureInfo(int id);

    /**
     * 通过id删除
     * @param id
     */
    void findActivityPictureById(int id);
}

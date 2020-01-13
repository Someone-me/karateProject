package cn.anhui.karate.dao;

import cn.anhui.karate.domain.PictureBean;

import java.util.List;
import java.util.Map;

public interface PictureBeanDao {
    /**
     * 保存赛事图片到数据库
     * @param bean
     */
    void saveMatchPicture(PictureBean bean);

    /**
     * 总页数
     * @param condition
     * @return
     */
    int matchPictureTotalCount(Map<String, String[]> condition);

    /**
     * 每页显示数据的集合
     * @param index
     * @param currentCount
     * @param condition
     * @return
     */
    List<PictureBean> matchPicturePageList(int index, int currentCount, Map<String, String[]> condition);

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
    void deleteMatchPictureById(int id);

    /**
     * 保存活动图片到数据库
     * @param bean
     */
    void saveActivityPicture(PictureBean bean);

    /**
     * 数据库中活动图片的总条数
     * @param condition
     * @return
     */
    int activityPictureTotalCount(Map<String, String[]> condition);

    /**
     * 每页展示数据的集合
     * @param index
     * @param currentCount
     * @param condition
     * @return
     */
    List<PictureBean> activityPicturePageList(int index, int currentCount, Map<String, String[]> condition);

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
    void deleteActivityPictureById(int id);
}

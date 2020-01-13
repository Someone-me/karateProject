package cn.anhui.karate.dao;

import cn.anhui.karate.domain.VideoBean;

import java.util.List;
import java.util.Map;

public interface VideoBeanDao {
    /**
     * 保存数据到数据库
     * @param bean
     */
    void saveVideo(VideoBean bean);

    /**
     * 总页数
     * @return
     * @param condition
     */
    int videoTotalCount(Map<String, String[]> condition);

    /**
     * 分页展示的每页数据的集合
     * @param index
     * @param currentCount
     * @param condition
     * @return
     */
    List<VideoBean> videoPageList(int index, int currentCount, Map<String, String[]> condition);

    /**
     * 通过id查找要删除的视频的信息
     * @param id
     * @return
     */
    VideoBean findVideoInfo(int id);

    /**
     * 通过id删除信息
     * @param id
     */
    void deleteVideoById(int id);

    /**
     * 查找数据库中的视频封装成集合
     * @return
     */
    List<VideoBean> findVideoNewsInfo();
}

package cn.anhui.karate.service;

import cn.anhui.karate.domain.PageBean;
import cn.anhui.karate.domain.VideoBean;

import java.util.List;
import java.util.Map;

public interface VideoBeanService {
    /**
     * 保存视频信息到数据库
     * @param bean
     */
    void saveVideo(VideoBean bean);

    /**
     * 分页
     * @param currentPage
     * @param currentCount
     * @param condition
     * @return
     */
    PageBean<VideoBean> findVideoPageBean(int currentPage, int currentCount, Map<String, String[]> condition);

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
    void findVideoById(int id);

    /**
     * 查找数据库中的视频封装成集合
     * @return
     */
    List<VideoBean> findVideoNewsInfo();
}

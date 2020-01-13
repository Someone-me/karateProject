package cn.anhui.karate.service;

import cn.anhui.karate.domain.FileBean;
import cn.anhui.karate.domain.PageBean;

import java.util.List;
import java.util.Map;

public interface FileBeanService {


    void savePicture(FileBean bean);

    List<FileBean> findAll();

    void saveFile(FileBean bean);

    List<FileBean> findFileAll();


    void findById(int id);


    FileBean findPictureInfo(int id);

    FileBean findFileInfo(int id);

    void findFileById(int id);

    /**
     * 文件信息的条件分页
     * @param currentPage
     * @param currentCount
     * @param condition
     * @return
     */
    PageBean<FileBean> findPageBean(int currentPage, int currentCount, Map<String, String[]> condition) ;

    /**
     * 图片信息的条件分页
     * @param currentPage
     * @param currentCount
     * @param condition
     * @return
     */
    PageBean<FileBean> findPicturePageBean(int currentPage, int currentCount, Map<String, String[]> condition);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    FileBean findPictureById(String id);

    /**
     * 修改
     * @param bean
     */
    void updatePicture(FileBean bean);
}

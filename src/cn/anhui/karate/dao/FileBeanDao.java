package cn.anhui.karate.dao;

import cn.anhui.karate.domain.FileBean;

import java.util.List;
import java.util.Map;

public interface FileBeanDao {


    void save(FileBean bean);

    List<FileBean> findAll();

    void saveFile(FileBean bean);

    List<FileBean> findFileAll();


    void deleteFindById(int id);


    FileBean findDeletePictureInfo(int id);

    FileBean findDeleteFileInfo(int id);

    void deleteById(int id);

    /**
     * 获得总页数
     * @param condition
     * @return
     */
    int getTotalCount(Map<String, String[]> condition);

    /**
     * 每页显示的数据的集合
     * @param index
     * @param currentCount
     * @param condition
     * @return
     */
    List<FileBean> findFileListForPageBean(int index, int currentCount, Map<String, String[]> condition);

    int getPictureTotalCount(Map<String, String[]> condition);

    List<FileBean> findPictureListForPageBean(int index, int currentCount, Map<String, String[]> condition);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    FileBean findPictureById(int id);

    void updatePicture(FileBean bean);
}

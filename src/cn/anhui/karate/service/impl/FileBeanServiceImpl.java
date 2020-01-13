package cn.anhui.karate.service.impl;

import cn.anhui.karate.dao.FileBeanDao;
import cn.anhui.karate.dao.impl.FileBeanDaoImpl;
import cn.anhui.karate.domain.FileBean;
import cn.anhui.karate.domain.PageBean;
import cn.anhui.karate.service.FileBeanService;

import java.util.List;
import java.util.Map;

public class FileBeanServiceImpl implements FileBeanService {
    private FileBeanDao dao=new FileBeanDaoImpl();

    /**
     * 保存图片
     * @param bean
     */
    @Override
    public void savePicture(FileBean bean) {
        dao.save(bean);
    }


    /**
     * 查询所有图片列表
     * @return
     */
    @Override
    public List<FileBean> findAll() {

        return dao.findAll();
    }

    /**
     * 保存上传的文件
     * @param bean
     */
    @Override
    public void saveFile(FileBean bean) {
        dao.saveFile(bean);
    }

    /**
     * 查找所有文件信息
     * @return
     */
    @Override
    public List<FileBean> findFileAll() {
        return dao.findFileAll();
    }

    @Override
    public void findById(int id) {
        dao.deleteFindById(id);
    }

    /**
     * 通过id查找要删除图片的信息
     * @param id
     * @return
     */
    @Override
    public FileBean findPictureInfo(int id) {
        return dao.findDeletePictureInfo(id);
    }

    /**
     * 通过id查找要删除文件的信息
     * @param id
     * @return
     */
    @Override
    public FileBean findFileInfo(int id) {
        return dao.findDeleteFileInfo(id);
    }

    /**
     * 通过id查询要删除文件
     * @param id
     */
    @Override
    public void findFileById(int id) {
        dao.deleteById(id);
    }

    @Override
    public PageBean<FileBean> findPageBean(int currentPage, int currentCount, Map<String, String[]> condition) {
        //封装成PageBean并返回
        PageBean pageBean=new PageBean();
        //当前页private int currentPage;
        pageBean.setCurrentPage(currentPage);
        //当前页显示的条数private int currentCount;
        pageBean.setCurrentCount(currentCount);
        //总条数private int totalCount;
        int totalCount=dao.getTotalCount(condition);
        pageBean.setTotalCount(totalCount);
        //总页数private int totalPage;
        /**
         * 公式：总页数=Math.ceil(总条数/当前显示的条数)
         */
        int totalPage=(int) Math.ceil(1.0*totalCount/currentCount);
        pageBean.setTotalPage(totalPage);
        //每页显示数据private List<T> productList=new ArrayList<T>();
        /**
         * 页数与limit起始所以的关系
         * 例如每页显示4条
         *   页数         起始索引       每页显示条数
         *   1              0             4
         *   2              4             4
         *   3              8             4
         *   4              12            4
         *
         *   索引index=（当前页-1）*每页显示条数
         */
        int index=(currentPage-1)*currentCount;
        List<FileBean> list =dao.findFileListForPageBean(index,currentCount,condition);
        pageBean.setList(list);

        return pageBean;
    }

    @Override
    public PageBean<FileBean> findPicturePageBean(int currentPage, int currentCount, Map<String, String[]> condition) {
        //封装成PageBean并返回
        PageBean pageBean=new PageBean();
        //当前页private int currentPage;
        pageBean.setCurrentPage(currentPage);
        //当前页显示的条数private int currentCount;
        pageBean.setCurrentCount(currentCount);
        //总条数private int totalCount;
        int totalCount=dao.getPictureTotalCount(condition);
        pageBean.setTotalCount(totalCount);
        //总页数private int totalPage;
        /**
         * 公式：总页数=Math.ceil(总条数/当前显示的条数)
         */
        int totalPage=(int) Math.ceil(1.0*totalCount/currentCount);
        pageBean.setTotalPage(totalPage);
        //每页显示数据private List<T> productList=new ArrayList<T>();
        /**
         * 页数与limit起始所以的关系
         * 例如每页显示4条
         *   页数         起始索引       每页显示条数
         *   1              0             4
         *   2              4             4
         *   3              8             4
         *   4              12            4
         *
         *   索引index=（当前页-1）*每页显示条数
         */
        int index=(currentPage-1)*currentCount;
        List<FileBean> list =dao.findPictureListForPageBean(index,currentCount,condition);
        pageBean.setList(list);

        return pageBean;
    }


    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public FileBean findPictureById(String id) {
        return dao.findPictureById(Integer.parseInt(id));
    }

    @Override
    public void updatePicture(FileBean bean) {
        dao.updatePicture(bean);
    }
}


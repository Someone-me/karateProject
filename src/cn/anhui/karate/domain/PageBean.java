package cn.anhui.karate.domain;

import java.util.ArrayList;
import java.util.List;

public class PageBean<T> {
    //当前页
    private int currentPage;
    //当前页显示的条数
    private int currentCount;
    //总条数
    private int totalCount;

    @Override
    public String toString() {
        return "PageBean{" +
                "currentPage=" + currentPage +
                ", currentCount=" + currentCount +
                ", totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", List=" + List +
                '}';
    }

    //总页数
    private int totalPage;
    //每页显示数据
    private List<T> List=new ArrayList<T>();

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public java.util.List<T> getList() {
        return List;
    }

    public void setList(java.util.List<T> list) {
        List = list;
    }
}

package com.HZ.MyLife.entity;

import java.util.List;

/**
 * Created by xsjdn on 2019/3/20.
 */
public class PageBean {
    private List list;  //需要分类的某一类所有事物
    private Integer totalCounts;    //总条数
    private Integer pageSize;   //每一页的数量
    private Integer currentPage;    //当前页数
    private Integer totalPage;  //总页数
    private Integer beginRows;  //开始行数

    public PageBean() {
    }

    public void setBeginRows() {
        this.beginRows = (this.currentPage-1)*this.pageSize;;
    }

    /**
     * 根据当前页数获取开始行数
     * @return
     */
    public Integer getBeginRows(){
        return beginRows;
    }

    public List getList() {
        return list;
    }

    public Integer getTotalCounts() {
        return totalCounts;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setList(List list) {
        this.list = list;
    }

    public void setTotalCounts(Integer totalCounts) {
        this.totalCounts = totalCounts;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public void setTotalPage() {
        int i = this.totalCounts % this.pageSize;
        int k = this.totalCounts / this.pageSize;
        if(i==0){
            this.totalPage=k;
        }else{
            this.totalPage=k+1;
        }
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "list=" + list +
                ", totalCounts=" + totalCounts +
                ", pageSize=" + pageSize +
                ", currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                '}';
    }
}

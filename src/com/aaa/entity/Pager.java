package com.aaa.entity;

import java.util.List;
import java.util.Map;

public class Pager {
    private Integer pageNo;
    private Integer pageSize;
    private Integer first;
    private Integer pageCount;
    private Integer prev;
    private Integer next;
    private Integer userCount;
    private List<Map> pageList;

    public Pager(Integer pageNo, Integer pageSize, List<Map> pageList,Integer userCount) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.pageList = pageList;
        this.userCount=userCount;
        this.first=1;
        this.pageCount=userCount%pageSize==0?(userCount/pageSize):(userCount/pageSize+1);
        this.prev=pageNo<=1?1:pageNo-1;
        this.next=pageNo>=pageCount?pageCount:pageNo+1;
    }

    public List<Map> getPageList() {
        return pageList;
    }

    public void setPageList(List<Map> pageList) {
        this.pageList = pageList;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getFirst() {
        return first;
    }

    public void setFirst(Integer first) {
        this.first = first;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPrev() {
        return prev;
    }

    public void setPrev(Integer prev) {
        this.prev = prev;
    }

    public Integer getNext() {
        return next;
    }

    public void setNext(Integer next) {
        this.next = next;
    }

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }

    @Override
    public String toString() {
        return "Pager{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", first=" + first +
                ", pageCount=" + pageCount +
                ", prev=" + prev +
                ", next=" + next +
                ", userCount=" + userCount +
                ", pageList=" + pageList +
                '}';
    }
}

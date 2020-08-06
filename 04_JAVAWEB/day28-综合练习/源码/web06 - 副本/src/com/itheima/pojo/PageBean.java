package com.itheima.pojo;

import lombok.Data;

import java.util.List;
@Data
public class PageBean <T>{
    //定义当前是第几页
    private int currentPage;

    //定义每页显示多少条数据
    private int pageSize;

    //定义共有多少条数据
    private long totalCount;

    //定义共有多少页
    private int totalPage;

    //定义需要展示的数据,集合
    private List<T> list;
}

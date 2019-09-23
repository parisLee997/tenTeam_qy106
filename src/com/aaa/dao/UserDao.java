package com.aaa.dao;

import com.aaa.entity.Pager;
import com.aaa.entity.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<Map> login(User info);
    int reg(User info);
    List<Map> query();
    int del(int id);
    Map<String,Object> queryId(int id);
    int update(User user);
    Pager queryPage(int pageNo, int pageSize);
    Integer queryPageCount();
    List<Map> queryByUname(String uname);
}

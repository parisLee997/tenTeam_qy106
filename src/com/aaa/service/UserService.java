package com.aaa.service;

import com.aaa.entity.Pager;
import com.aaa.entity.User;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<Map> login(User info);
    int reg(User info);
    List<Map> query();
    String del(int id);
    Map<String,Object> queryId(int id);
    String update(User user);
    Pager queryPage(int pageNo, int pageSize);
    Integer queryPageCount();
    Boolean ExitUname(String uname);
}

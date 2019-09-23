package com.aaa.service;

import com.aaa.dao.UserDao;
import com.aaa.dao.UserDaoImpl;
import com.aaa.entity.Pager;
import com.aaa.entity.User;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService{
    private UserDao userDao=new UserDaoImpl();
    @Override
    public List<Map> login(User info) {

        return userDao.login(info);
    }

    @Override
    public int reg(User info) {

        return userDao.reg(info);
    }

    @Override
    public List<Map> query() {
        return userDao.query();
    }

    @Override
    public String del(int id) {
        int result=userDao.del(id);
        if (result > 0) {
            String str = "删除成功";
            return str;
        } else {
            String str = "删除成功";
            return str;
        }
    }

    @Override
    public Map<String, Object> queryId(int id) {
        return userDao.queryId(id);
    }

    @Override
    public String update(User user) {
        int result=-1;
        result= userDao.update( user);
        if (result > 0) {
            String str = "修改ok";
            return str;
        } else {
            String str="修改失败";
            return str;
        }
    }

    @Override
    public Pager queryPage(int pageNo, int pageSize) {
        return userDao.queryPage(pageNo,pageSize);
    }

    @Override
    public Integer queryPageCount() {
        return userDao.queryPageCount();
    }

    @Override
    public Boolean ExitUname(String uname) {
        List<Map> list=userDao.queryByUname(uname);
        return  Integer.parseInt(list.get(0).get("cnt").toString())>0?true:false;
    }
}

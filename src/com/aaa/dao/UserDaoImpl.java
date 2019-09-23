package com.aaa.dao;

import com.aaa.entity.Pager;
import com.aaa.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public List<Map> login(User info) {
        String sql="select * from user where uname=? and pwd=?";
        Object[] objects =new Object[]{info.getUname(),info.getPwd()};
        List<Map> list=super.executeQuery(sql,objects);
        return  list;
    }

    @Override
    public int reg(User info) {
        String sql="insert into user(uname,pwd) values(?,?)";
        Object[] objects=new Object[]{info.getUname(),info.getPwd()};
        int result=super.executeUpdate(sql,objects);
        return result;
    }

    @Override
    public List<Map> query() {
        String sql="select * from user";
        List<Map> list=super.executeQuery(sql,null);
        return list;
    }

    @Override
    public int del(int id) {
        String sql="delete from user where id=?";
        Object[] objects=new Object[]{id};
        int result=super.executeUpdate(sql,objects);
        return result;
    }

    @Override
    public Map<String, Object> queryId(int id) {
        String sql="select * from user where id=?";
        Object[] objects=new Object[]{id};
        List<Map> list=super.executeQuery(sql,objects);
        Map<String,Object> map=new HashMap<>();
        for (Map map1 : list) {
            map=map1;
        }
        return map;
    }

    @Override
    public int update(User user) {
        String sql="update user set uname=?,pwd=?,sex=? where id=?";
        Object[] objects=new Object[]{user.getUname(),user.getPwd(),user.getSex(),user.getId()};
        return super.executeUpdate(sql,objects);
    }

    @Override
    public Pager queryPage(int pageNo, int pageSize) {

        String sql="select * from user limit ?,?";
        Object[] objects=new Object[]{(pageNo-1)*pageSize,pageSize};
        List<Map> list=super.executeQuery(sql,objects);
        Pager pager=new Pager(pageNo,pageSize,list,queryPageCount());
        return pager;
    }

    @Override
    public Integer queryPageCount() {
        String sql="select count(*) cnt from user";
        List<Map> list=super.executeQuery(sql,null);
        return Integer.valueOf(list.get(0).get("cnt").toString());
    }

    @Override
    public List<Map> queryByUname(String uname) {
        String sql="select count(*) cnt from user where uname=?";
        Object[] objects=new Object[]{uname};
        return super.executeQuery(sql,objects);
    }

}

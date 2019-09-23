package com.aaa.servlet;

import com.aaa.dao.UserDao;
import com.aaa.dao.UserDaoImpl;
import com.aaa.entity.User;

import java.util.List;
import java.util.Map;

public class Test {


    public static void main(String[] args) {
        User user=new User(26,"sry","123456");
        UserDao userDao=new UserDaoImpl();
//        List<Map> list=userDao.login(user);
//        for (Map map : list) {
//            System.out.println(map);
//        }
        //userDao.reg(user);
//       List<Map>list= userDao.query();
//        for (Map map : list) {
//            System.out.println(map);
//        }
       // userDao.del(23);
        //userDao.queryPage(2,2);
//        List<Map> list=userDao.queryByUname("lym");
//        System.out.println(list.get(0).get("cnt").toString());
            //userDao.update(user);

    }
}

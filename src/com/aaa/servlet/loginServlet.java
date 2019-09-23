package com.aaa.servlet;

import com.aaa.dao.UserDao;
import com.aaa.dao.UserDaoImpl;
import com.aaa.entity.User;
import com.aaa.service.UserService;
import com.aaa.service.UserServiceImpl;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.servlet.annotation.WebServlet(name = "loginServlet",urlPatterns = "/login.action")
public class loginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String uname=request.getParameter("uname");
        String pwd=request.getParameter("pwd");
        User user=new User(uname,pwd);

        //UserDao userDao =new UserDaoImpl();
        UserService userService=new UserServiceImpl();
        List<Map> list=userService.login(user);
        if (list!=null){
            for (Map map : list) {
                HttpSession session=request.getSession();
                session.setAttribute("uname",map.get("uname"));
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
        }
    }
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}

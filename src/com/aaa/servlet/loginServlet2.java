package com.aaa.servlet;

import com.aaa.entity.User;
import com.aaa.service.UserService;
import com.aaa.service.UserServiceImpl;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;

@javax.servlet.annotation.WebServlet(name = "login2Servlet",urlPatterns = "/login2.action")
public class loginServlet2 extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String uname=request.getParameter("uname");
        String pwd=request.getParameter("pwd");
        User user=new User(uname,pwd);
        //UserDao userDao =new UserDaoImpl();
        UserService userService=new UserServiceImpl();
        List<Map> list=userService.login(user);
        PrintWriter writer=response.getWriter();
        if (list!=null){
            for (Map map : list) {
                HttpSession session=request.getSession();
                session.setAttribute("uname",map.get("uname"));
                writer.print("ok");
            }
        }else {
            writer.print("false");
        }
    }
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}

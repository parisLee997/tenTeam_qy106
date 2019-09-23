package com.aaa.servlet;

import com.aaa.dao.UserDao;
import com.aaa.dao.UserDaoImpl;
import com.aaa.entity.User;
import com.aaa.service.UserService;
import com.aaa.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "regServlet",urlPatterns = "/reg.action")
public class regServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String uname=request.getParameter("uname");
        String pwd=request.getParameter("pwd");
        if (uname!=null&&pwd!=null&&!uname.trim().equals("")&&!pwd.trim().equals("")){
            User user=new User(uname,pwd);
            UserService userService=new UserServiceImpl();
           // UserDao userDao=new UserDaoImpl();
            int result=userService.reg(user);
            if(result>0){
                request.getRequestDispatcher("query.action").forward(request,response);
            }else {
                request.setAttribute("msg","注册失败");
                request.getRequestDispatcher("error").forward(request,response);
            }
        }else {
            request.setAttribute("msg","参数为空");
            request.getRequestDispatcher("error").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

package com.aaa.servlet;

import com.aaa.entity.User;
import com.aaa.service.UserService;
import com.aaa.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateServlet",urlPatterns = "/update.action")
public class updateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname=request.getParameter("uname");
        String pwd=request.getParameter("pwd");
        String id=request.getParameter("id");
        String sex=request.getParameter("sex");
        User user=new User(Integer.parseInt(id),uname,pwd,sex);
        UserService userService=new UserServiceImpl();
        String str=userService.update(user);
        response.getWriter().print(str);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

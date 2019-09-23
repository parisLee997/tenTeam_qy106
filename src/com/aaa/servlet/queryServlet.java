package com.aaa.servlet;

import com.aaa.dao.UserDao;
import com.aaa.dao.UserDaoImpl;
import com.aaa.entity.Pager;
import com.aaa.service.UserService;
import com.aaa.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.aaa.utils.Pageutil.PAGE_SIZE;

@WebServlet(name = "queryServlet",urlPatterns = "/query.action")
public class queryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        UserService userService=new UserServiceImpl();
        //UserDao userDao=new UserDaoImpl();
        String pageNo=request.getParameter("pageNo");
        if (pageNo==null) pageNo="1";
        Pager pager=userService.queryPage(Integer.parseInt(pageNo),PAGE_SIZE);
        //List<Map> list=userDao.query();
        if (pager!=null){
            request.setAttribute("pager",pager);
            request.getRequestDispatcher("admin/query.jsp").forward(request,response);
        }else {
            request.setAttribute("msg","查询失败");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

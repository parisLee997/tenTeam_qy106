package com.aaa.servlet;

import com.aaa.entity.Pager;
import com.aaa.service.UserService;
import com.aaa.service.UserServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.aaa.utils.Pageutil.PAGE_SIZE;

@WebServlet(name = "queryServlet2",urlPatterns = "/query2.action")

public class queryServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService=new UserServiceImpl();
        String pageNo=request.getParameter("pageNo");
        if (pageNo==null) pageNo="1";
        Pager pager=userService.queryPage(Integer.parseInt(pageNo),PAGE_SIZE);
        System.out.println(pager);
        if (pager!=null){
            //java对象转换成json字符串并进行日期格式处理
            String str=JSON.toJSONStringWithDateFormat(pager,"yyyy-MM-dd");
            //得到响应输出流对象
            //输出结果能被回调函数获取
            PrintWriter writer=response.getWriter();
            writer.print(str);
        }else {
            request.setAttribute("msg","查询失败");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

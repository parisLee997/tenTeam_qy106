<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/11 0011
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="login.jsp">登陆</a>
  <a href="login2.jsp">登陆</a>
  <a href="zhuxiao.action">注销</a>
  <a href="query.action">查询</a>
  <a href="admin/query2.jsp">查询2</a>
  <a href="reg.jsp">注册</a>
  <a href="admin/index.html">zhuye</a>
<%
  if (session.getAttribute("uname")!=null){
    out.print("<h3>欢迎");
    out.print(session.getAttribute("uname"));
    out.print("</h3>");
  }
%>
  </body>
</html>

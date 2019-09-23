<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/11 0011
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>Title</title>
    <style>
        table{
            border: 1px solid black;
        }
        td{
            border: 1px solid black;
        }
        th{
            border: 1px solid black;
        }
    </style>
</head>
<body>
<a href="index.jsp">主页</a>
<table>
    <tr>
        <th>姓名</th>
        <th>密码</th>
        <th>操作</th>
    </tr>
    <c:if test="${ not empty pager.pageList}">
        <c:forEach items="${pager.pageList}" var="user" varStatus="status">
        <tr>
            <td>
                ${user.uname}
            </td>
            <td>
                ${user.pwd}
            </td>
            <td>
               <a >修改</a>
               <a href="del.action?id=${user.id}">删除</a>
            </td>
        </tr>
        </c:forEach>
    </c:if>
</table>
<div>
    <a href="query.action?pageNo=${pager.first}">首页</a>
    <a href="query.action?pageNo=${pager.prev}">上一页</a>
    <a href="query.action?pageNo=${pager.next}">下一页</a>
    <a href="query.action?pageNo=${pager.pageCount}">尾页</a>
</div>
</body>
</html>

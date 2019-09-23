<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/16 0016
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="static/js/jquery-3.4.1.min.js"></script>
    <script>
        alert($)
       function getTime() {
           $.get("date.action",function (date) {
               $("#d1").html(date);
           })
       }
    </script>
</head>
<body>
<input type="button" value="gettime" onclick="getTime()">
<div id="d1"></div>
</body>
</html>

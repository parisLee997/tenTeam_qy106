<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/11 0011
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="login.action" method="post">
    <table>
        <tr>
            <td>
                用户
            </td>
            <td>
                <input type="text" name="uname" onblur="sub()" id="uname"><div id="msg"></div>
            </td>
        </tr>
        <tr>
            <td>
            密码
            </td>
            <td>
                <input type="password" name="pwd">
            </td>
        </tr>
        <tr>
        <td colspan="2">
            <input type="submit" value="提交">
        </td>
    </tr>
    </table>
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/11 0011
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="static/js/jquery-3.4.1.min.js"></script>
    <script>
        alert($);
        function sub() {
            $.ajax({
                type:"POST",
                url:"exitUname.action",
                data:{
                    uname:$("#uname").val()
                },
                success: function (msg) {
                    if (msg == 'true') {
                        $("#msg").html("该账号已经存在");
                    } else {
                        $("#msg").html("该账户可以使用");
                    }
                },
                error:function (xmr,info,e) {
                    alert("错误"+info);
                }
            })
        }
    </script>
</head>
<body>
<form action="reg.action" method="post">
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

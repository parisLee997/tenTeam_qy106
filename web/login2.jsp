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
    <script src="static/js/jquery-3.4.1.min.js"></script>
    <script>
        function sub() {
            $.ajax({
                type:"POST",
                url:"login2.action",
                data:$("#form1").serialize(),
                // data:{
                //     uname:$("#uname").val(),
                //     pwd:$("#pwd").val()
                // },
                success:function (msg) {
                    if (msg == "ok") {
                        location.href = "index.jsp";
                    } else {
                        alert("失败");
                    }
                },
                error:function (xmr, info, e) {
                    alert(info);
                }
            })
        }
    </script>
</head>
<body>
<form action="login2.action" method="post" id="form1">
    <table>
        <tr>
            <td>
                用户
            </td>
            <td>
                <input type="text" name="uname" id="uname"><div id="msg"></div>
            </td>
        </tr>
        <tr>
            <td>
            密码
            </td>
            <td>
                <input type="password" name="pwd" id="pwd">
            </td>
        </tr>
        <tr>
        <td colspan="2">
            <input type="button" value="提交" id="btn1" onclick="sub()">
        </td>
    </tr>
    </table>
</form>
</body>
</html>

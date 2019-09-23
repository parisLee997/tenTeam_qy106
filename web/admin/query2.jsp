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
<%@ include file="../common/header.jsp"%>
<html>
<head>
    <script src="../static/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        var pager;
        function queryAll(pageNo) {
            if (pageNo==null) pageNo=1;
            $.ajax({
                type:"GET",
                url: "../query2.action",
                data:{pageNo:pageNo},
                dataType:'json',
                success:function (msg) {
                    pager=msg;
                    $("#tbd").empty();
                    var list=msg.pageList;
                    for (var i = 0; i < list.length; i++) {
                        var tr="<tr>"+
                            "<td>"+list[i].uname+"</td>"+
                            "<td>"+list[i].pwd+"</td>"+
                            "<td>"+list[i].sex+"</td>"+
                            '<td> <input type="button" value="修改" onclick="queryOne('+list[i].id+')" class="btn btn-primary" data-toggle="modal" data-target="#myModal"/>' +
                            '<input type="button" value="删除" onclick="deleteOne('+list[i].id+')" class="btn btn-primary"  data-target="#myModal"/></td>' +
                                "</tr>"
                        $("#tbd").append(tr);
                        $("#pageInfo").html("当前页"+pager.pageNo+"/总页数"+pager.pageCount);
                        $("#pageNo").val(pager.pageNo);
                        $("#pageNo").attr("max",pager.pageCount);
                    }
                },
                error: function () {
                    alert("错误")
                }
            })
        }
        function queryOne(id){
            $.ajax({
                type:"GET",
                url:"../queryId.action?id="+id,
                dataType:'json',
                success:function (msg) {
                    $("#id").val(msg.id);
                    $("#uname").val(msg.uname);
                    $("#pwd").val(msg.pwd);
                    if (msg.sex == null)  msg.sex='男';
                    if (msg.sex == '男') {
                        $("#boy").prop("checked", true);
                    } else {
                        $("#girl").prop("checked", true);
                    }
                },
                error: function () {
                    alert("error");
                }
            })
        }
        function deleteOne(id){
            $.ajax({
                type:"GET",
                url:"../del.action?id="+id,
                dataType:'json',
                success:function (msg) {
                    alert(msg);
                    queryAll();
                },error:function () {
                    alert("删除失败");
                }
            })
        }
        function work(){
            $.ajax({
                type:"POST",
                url:"../update.action",
                data:$("#form1").serialize(),
                success:function (msg) {
                    alert(msg);
                    queryAll(pager.pageNo);
                },
                error:function () {
                    alert(error);
                }
            })

        }

        //绑定声明，页面加载完执行
        $(function () {
            queryAll();
        })
        $(function () {
            $("#btnGo").click(function () {
                var pageNo=$("#pageNo").val();
                if (pageNo>pager.pageCount) pageNo=pager.pageCount;
                queryAll(pageNo);
            })
        })
    </script>
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
<input type="button" value="添加用户">
<table class="table table-bordered table-hover">
    <tr>
        <th>姓名</th>
        <th>密码</th>
        <th>性别</th>
        <th>操作</th>
    </tr>
    <tbody id="tbd">

    </tbody>
</table>
<div>
    <span id="pageInfo"></span>
    <a href="#" onclick="queryAll(1)">首页</a>
    <a href="#" onclick="queryAll(pager.prev)">上一页</a>
    <a href="#" onclick="queryAll(pager.next)">下一页</a>
    <a href="#" onclick="queryAll(pager.pageCount)">尾页</a>
    <input type="number" value="" id="pageNo" min="1" step="1">
    <input type="button" value="GO" id="btnGo">
</div>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    员工信息管理
                </h4>
            </div>
            <div class="modal-body">
                <form action="userUpdate.action" method="post" id="form1">
                    <table class="table">
                        </tr>
                        <tr>
                            <td>
                                用户
                            </td>
                            <td>
                                <input type="hidden" name="id" id="id" >
                                <input type="text" name="uname" id="uname" >
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
                            <td>
                                性别
                            </td>
                            <td>
                                <input type="radio" name="sex" id="boy" value="男">男
                                <input type="radio" name="sex" id="girl" value="女">女
                            </td>
                        </tr>
                    </table>
                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" onclick="work(id)" data-toggle="modal" data-target="#myModal" >
                    提交更改
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</body>
</html>

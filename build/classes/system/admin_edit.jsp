<%--
  Created by IntelliJ IDEA.
  User: hang.yang
  Date: 2018/10/28
  Time: 7:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path;
%>
<html>
<head>
    <title>修改文章</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <script type="text/javascript" charset="utf-8" src="ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="lang/zh-cn/zh-cn.js"></script>
    <script type="text/javascript">
        window.onload = function(){
            var ue = UE.getEditor('editor');
        };
    </script>
</head>
<body>

<h2>文章标题：${blog.title}</h2><br>
<form method="post" name="ueditor" id="ueditor" action="admin?method=doEdit">
    <input type="hidden" name="id" value="${blog.articleId}">
    修改标题：<input type="text" name="title" value="${blog.title}">

<script id="editor" type="text/plain" style="width:1024px;height:500px;">
    ${blog.value}
</script>
    <button>提交修改</button>
<%--修改文章：<textarea>${blog.value}</textarea>--%>

</form>


<%--
  Created by IntelliJ IDEA.
  User: hang.yang
  Date: 2018/10/28
  Time: 10:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加文章</title>
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
    <form action="admin" method="post">
        <input type="hidden" name="method" value="doAddArticle">
        题目：<input type="text" name="title">
        <div id="editor" style="height:360px">
            <script type="text/javascript" charset="utf-8">
                UE.getEditor('editor');
            </script>
        </div>
        <button>提交留言</button>
    </form>
</body>
</html>

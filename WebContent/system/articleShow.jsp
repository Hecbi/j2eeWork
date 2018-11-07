<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="gbk">
<title>文章信息</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <script type="text/javascript" charset="utf-8" src="ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="lang/zh-cn/zh-cn.js"></script>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
    <script src="js/jquery.min.js"></script>
    <script src="js/jquery.dropotron.min.js"></script>
    <script src="js/jquery.scrollgress.min.js"></script>
    <script src="js/skel.min.js"></script>
    <script src="js/skel-layers.min.js"></script>
    <script src="js/init.js"></script>
    <noscript>
        <link rel="stylesheet" href="css/skel.css" />
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/style-wide.css" />
    </noscript>
</head>
<body>

<c:if test="${addCommentResult=='ok' }">
    <script>
        alert("评论成功");
        document.location(history.back())
    </script>
</c:if>

<c:if test="${addCommentResult!='ok' }">

    <%--<hr>--%>



    <%--<hr>--%>

    <%--<h2>评论：</h2>--%>
    <%--<c:forEach var="comment" items="${COMMENT_LIST}">--%>
        <%--评论人：${comment.nickname}<br>--%>
        <%--评论内容：${comment.value}<hr>--%>
    <%--</c:forEach>--%>

<!-- Header -->
<header id="header" class="skel-layers-fixed">
    <h1><a href="/">Homaebic</a> by HTML5 UP</h1>
    <nav id="nav">
        <ul>
            <li><a href="/">Home</a></li>
            <li>
                <ul>
                    <li>
                        <a href="">Submenu</a>
                        <ul>
                            <li><a href="#">Option One</a></li>
                            <li><a href="#">Option Two</a></li>
                            <li><a href="#">Option Three</a></li>
                            <li><a href="#">Option Four</a></li>
                        </ul>
                    </li>
                </ul>
            </li>
        </ul>
    </nav>
</header>

<!-- Main -->
<section id="main" class="container small">
    <header>
        <h2>${blog.title}</h2>
        <div>${blog.value}</div>
    </header>
    <div class="box">


        <h3><b>评论：</b></h3>
        <c:forEach var="comment" items="${COMMENT_LIST}">
            ${comment.nickname} 说：${comment.value}<hr>
        </c:forEach>

        <form method="post" name="ueditor" id="ueditor" action="blog">
            <input type="hidden" name="articleId" value="${blog.articleId}">
            <input type="hidden" name="method" value="addComment">
            <div class="12u">
                您的ID：<input type="text" name="nickname"><br>
            </div>
            <div class="15u">
                <div id="editor" style="width: 832px; height: 300px;">
                    <script type="text/javascript" charset="utf-8">
                        UE.getEditor('editor');
                    </script>
                </div>
                <button>提交留言</button>
            </div>
        </form>

    </div>
</section>

<!-- Footer -->
<footer id="footer">
    <ul class="copyright">
        <li>&copy; Untitled. All rights reserved.</li><li>Design: <a href="#">Homaebic</a></li>
    </ul>
</footer>


<%--<h2>添加评论</h2>--%>
<%--<form method="post" name="ueditor" id="ueditor" action="blog">--%>
    <%--<input type="hidden" name="articleId" value="${blog.articleId}">--%>
    <%--<input type="hidden" name="method" value="addComment">--%>
    <%--您的ID：<input type="text" name="nickname">--%>
    <%--<div id="editor" style="height:360px">--%>
        <%--<script type="text/javascript" charset="utf-8">--%>
            <%--UE.getEditor('editor');--%>
        <%--</script>--%>
    <%--</div>--%>
    <%--<button>提交留言</button>--%>
<%--</form>--%>
<%--<div>--%>
</c:if>

</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: hang.yang
  Date: 2018/10/28
  Time: 4:20 PM
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
    <head>
        <title>我都写了啥</title>
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
        <!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
    </head>
</head>
<body>


<!-- Header -->
<header id="header" class="skel-layers-fixed">
    <h1><a href="index.html">Homaebic</a> by HTML5 UP</h1>
    <nav id="nav">
        <ul>
            <li><a href="/admin?method=addArticle">Write</a></li>
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
            <li><a href="/login" class="button">Login</a></li>
        </ul>
    </nav>
</header>

<!-- Main -->
<section id="main" class="container">
    <header>
        <h2>${username}的文章列表</h2>
        <br>
        <c:forEach var="blog" items="${BLOG_LIST}">
            <a href="<%=basePath%>/blog?method=findOne&id=${blog.articleId}"><h3>${blog.title}</h3></a>
            <a href="<%=basePath%>/admin?method=edit&id=${blog.articleId}">编辑</a>
            <a href="<%=basePath%>/admin?method=delete&id=${blog.articleId}">删除</a>
            <hr>
        </c:forEach>
        <hr>
    </header>

</section>

<!-- Footer -->
<footer id="footer">
    <ul class="copyright">
        <li>&copy; Untitled. All rights reserved.</li><li>Design: <a href="#">Homaebic</a></li>
    </ul>
</footer>





<%--<h2>${username}的文章列表</h2>--%>
<%--<a href="<%=basePath%>/admin?method=addArticle">添加文章</a>--%>
<%--<c:forEach var="blog" items="${BLOG_LIST}">--%>
    <%--<a href="<%=basePath%>/blog?method=findOne&id=${blog.articleId}"><h3>${blog.title}</h3></a>--%>
    <%--<a href="<%=basePath%>/admin?method=edit&id=${blog.articleId}">编辑</a>--%>
    <%--<a href="<%=basePath%>/admin?method=delete&id=${blog.articleId}">删除</a>--%>
    <%--<hr>--%>
<%--</c:forEach>--%>
<%--<hr>--%>
<%--<a href="login?logout">登出</a>--%>
</body>
</html>

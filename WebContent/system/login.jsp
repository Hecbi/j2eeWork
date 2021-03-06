<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>登录</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

    <style>body{padding-top: 60px;}</style>

    <link href="bootstrap3/css/bootstrap.css" rel="stylesheet" />

    <link href="login-register.css" rel="stylesheet" />
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">

    <script src="jquery/jquery-1.10.2.js" type="text/javascript"></script>
    <script src="bootstrap3/js/bootstrap.js" type="text/javascript"></script>
    <script src="login-register.js" type="text/javascript"></script>
</head>
<body>
<c:if test="${loginerror=='1' }">
    <script>
        alert("登录失败，请检查账号密码");
        document.location(history.back())
    </script>
</c:if>
<c:if test="${loginerror=='0' }">

    <div class="container">
        <div class="row">
            <div class="col-sm-4"></div>
            <div class="col-sm-4">
                <a class="btn big-login" data-toggle="modal" href="javascript:void(0)" onclick="openLoginModal();">Log in</a>
                <a class="btn big-register" data-toggle="modal" href="javascript:void(0)" onclick="openRegisterModal();">Register</a></div>
            <div class="col-sm-4"></div>
        </div>


        <div class="modal fade login" id="loginModal">
            <div class="modal-dialog login animated">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title">Login with</h4>
                    </div>
                    <div class="modal-body">
                        <div class="box">
                            <div class="content">
                                <div class="social">
                                    <a class="circle github" href="/auth/github">
                                        <i class="fa fa-github fa-fw"></i>
                                    </a>
                                    <a id="google_login" class="circle google" href="/auth/google_oauth2">
                                        <i class="fa fa-google-plus fa-fw"></i>
                                    </a>
                                    <a id="facebook_login" class="circle facebook" href="/auth/facebook">
                                        <i class="fa fa-facebook fa-fw"></i>
                                    </a>
                                </div>
                                <div class="division">
                                    <div class="line l"></div>
                                    <span>or</span>
                                    <div class="line r"></div>
                                </div>
                                <div class="error"></div>
                                <div class="form loginBox">
                                    <form action="login" method="post">
                                        <input id="user" class="form-control" type="text" placeholder="Username" name="username">
                                        <input id="password" class="form-control" type="password" placeholder="Password" name="password">
                                        <input class="btn btn-default btn-login" type="submit" value="Login">
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="box">
                            <div class="content registerBox" style="display:none;">
                                <div class="form">
                                    <form action="login" method="post">
                                        <input type="hidden" name="register">
                                        <input id="user" class="form-control" type="text" placeholder="Username" name="username">
                                        <input id="password" class="form-control" type="password" placeholder="Password" name="password">
                                        <input class="btn btn-default btn-register" type="submit" value="Create account" name="commit">
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <div class="forgot login-footer">
                            <span>Looking to
                                 <a href="javascript: showRegisterForm();">create an account</a>
                            ?</span>
                        </div>
                        <div class="forgot register-footer" style="display:none">
                            <span>Already have an account?</span>
                            <a href="javascript: showLoginForm();">Login</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </body>
    </html>






    <%--<div>--%>
        <%--<form action="login" method="post">--%>
            <%--<table>--%>
                <%--<tr>--%>
                    <%--<td><label for="user">用户名：</label></td>--%>
                    <%--<td><input type="text" id="user" name="username" value=""></td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td><label for="password">密码：</label></td>--%>
                    <%--<td><input type="password" id="password" name="password" value=""></td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td colspan="2"><input type="submit" name="submit" value="登录"></td>--%>
                <%--</tr>--%>
            <%--</table>--%>
        <%--</form>--%>
        <%--<a href="login?register">注册</a>--%>
    <%--</div>--%>
    <%--</body>--%>
    <%--</html>--%>
</c:if>
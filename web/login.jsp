<%--
  Created by IntelliJ IDEA.
  User: xsjdn
  Date: 2020/1/3
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="css/bootstrapValidator.min.css" rel="stylesheet">
    <title>MyLife登录--欢迎登录</title>
    <script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.js" type="text/javascript"></script>
    <script type="text/javascript" src="js/bootstrapValidator.min.js"></script>
    <style>
        .bg{
            background: url('images/bg002.jpg') no-repeat center;
            background-size: cover;
        }
    </style>
</head>
<body class="bg">
    <div class="container-fluid">
    <div class="row" style="height: 100%; position: relative;text-align: center">
        <div class="offset-2 col-md-3" style="border: solid 1px black;height:50%;position: absolute;top: 50%;transform:translate(0,-50%)">
            <p>
                nihaonihaonihaoniahoniaho
            </p>
        </div>
        <div class="col-md-3 offset-7" style="background: rgba(255,255,255,0.4);position: absolute;top: 50%;transform:translate(0,-50%)">
            <!-- 选项卡面板 -->
            <div id="myTabContent" class="tab-content">
                <div class="tab-pane fade" id="telephone">
                    <form action="UserServlet?method=loginByPhone" method="post" id="pform">
                        <div class="container text-center">
                            <h2>用户登录</h2>
                            <a href="register.jsp">没有账号，立即注册</a>
                        </div>
                        <div class="form-group row">
                            <div class="col-md-12">
                                <div class="input-group">
                                    <input type="text" class="form-control" id="phone" name="phone" placeholder="请输入电话号码">
                                    <span class="input-group-btn">
                                            <button class="btn btn-info" id="getcode" disabled="disabled">获取验证码</button>
                                        </span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-md-12">
                                <input type="text" class="form-control" name="verify" placeholder="请输入验证码">
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-md-8 offset-2">
                                <input class="btn btn-info" type="submit" id="plogin" value="登录" style="width: 100%"/>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="tab-pane fade show active" id="account">
                    <form action="UserServlet?method=loginByAccount" method="post" id="mform">
                        <div class="container text-center">
                            <h2>用户登录</h2>
                            <a href="register.jsp">没有账号，立即注册</a>
                        </div>
                        <div class="form-group row">
                            <div class="col-md-12">
                                <input type="text" class="form-control" name="name" placeholder="请输入名称">
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-md-12">
                                <input type="text" class="form-control" name="pass" placeholder="请输入密码">
                            </div>
                        </div>
                        <div class="form-group row">
                                <div class="col">
                                    <input type="text" class="form-control" name="verify" placeholder="请输入验证码">
                                </div>
                                <div class="col">
                                    <img id="checkImg" src="checkImg.jpg"/>
                                </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-md-8 offset-2">
                                <input class="btn btn-info" type="submit" id="mlogin" value="登录" style="width: 100%"/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div>
                <!-- 选项卡组件（菜单项nav-tabs）-->
                <ul id="myTab" class="nav nav-tabs" role="tablist">
                    <li class="col-md-6" style="padding: 0;"><a class="nav-link" href="#telephone" role="tab" data-toggle="tab">手机登录</a></li>
                    <li class="col-md-6" style="padding: 0;"><a class="active nav-link" href="#account" role="tab" data-toggle="tab">账号登录</a></li>
                </ul>
            </div>
        </div>
        <div class="foot" style="position: absolute;bottom: 5%; left: 40%; width: 20%">
            <p>HZ xxx备案 xxx号</p>
        </div>
    </div>
</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: xsjdn
  Date: 2019/12/29
  Time: 21:00
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
    <title>MyLife注册--欢迎注册</title>
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
            <div class="col-md-4 offset-4" style="background: rgba(255,255,255,0.4);position: absolute;top: 50%;transform:translate(0,-50%)">
                <!-- 选项卡面板 -->
                <div id="myTabContent" class="tab-content">
                    <div class="tab-pane fade" id="telephone">
                        <form action="userServlet?method=registerByPhone" method="post" id="pform">
                            <div class="container text-center">
                                <h2>用户注册</h2>
                                <a href="login.jsp">已有账号，立即登录</a>
                            </div>
                            <div class="form-group row">
                                <div class="col-md-12">
                                    <input type="text" class="form-control" name="name" id="pname" placeholder="请输入名称">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-md-12">
                                    <input type="text" class="form-control" name="pass" placeholder="请输入密码">
                                </div>
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
                                    <input class="btn btn-info" type="submit" id="register" value="注册" style="width: 100%"/>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="tab-pane fade show active" id="mail">
                        <form action="UserServlet?method=registerByMail" method="post" id="mform">
                            <div class="container text-center">
                                <h2>用户注册</h2>
                                <a href="login.jsp">已有账号，立即登录</a>
                            </div>
                            <div class="form-group row">
                                <div class="col-md-12">
                                    <input type="text" class="form-control" name="name" placeholder="请输入名称">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-md-12">
                                    <input type="text" class="form-control" name="password" placeholder="请输入密码">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-md-12">
                                    <input type="text" class="form-control" name="email" placeholder="请输入邮箱">
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
                                    <input class="btn btn-info" type="submit" id="mregister" value="注册" style="width: 100%"/>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div>
                    <!-- 选项卡组件（菜单项nav-tabs）-->
                    <ul id="myTab" class="nav nav-tabs" role="tablist">
                        <li class="nav-item col-md-6" style="padding: 0;">
                            <a class="nav-link" href="#telephone" role="tab" data-toggle="tab">手机注册</a>
                        </li>
                        <li class="nav-item col-md-6" style="padding: 0;">
                            <a class="nav-link active" href="#mail" role="tab" data-toggle="tab">邮箱注册</a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="foot" style="position: absolute;bottom: 5%; left: 40%; width: 20%">
                <p>HZ xxx备案 xxx号</p>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript">
    function showmsg(){
        <% String error=(String) request.getAttribute("error");
         if(error!=null){
                %>
        alert("<%=error%>");
        //弹出提示后清零，便于下次验证
        <%request.setAttribute("error","");}%>
    }
    $(function () {
        showmsg();
        $("#pform").bootstrapValidator({
            live: 'enabled',//验证时机，enabled是内容有变化就验证（默认），disabled和submitted是提交再验证
            message:'信息错误' ,//通用的验证失败消息
            excluded: [':disabled', ':hidden', ':not(:visible)'],//排除无需验证的控件，比如被禁用的或者被隐藏的
            feedbackIcons: {//根据验证结果显示的各种图标
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                name: {
                    message: '请输入正确的用户名',
                    validators: {
                        notEmpty: {
                            message: '用户名不能为空'
                        },
                        stringLength: {
                            min: 6,
                            max: 18,
                            message: '用户名长度必须在6到18位之间'
                        },
                        regexp: {
                            regexp: /^[a-zA-Z0-9_]+$/,
                            message: '用户名只能包含大写、小写、数字和下划线'
                        },
                        remote: {//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}
                            url: 'UserServlet?method=checkUsername',//验证地址
                            message: '用户已存在',//提示消息
                            threshold :  6 , //有6字符以上才发送ajax请求，（input中输入一个字符，插件会向服务器发送一次，设置限制，6字符以上才开始）
                            delay :  2000,//设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
                            type: 'POST',//请求方式
                        }
                    }
                },
                pass:{
                    message:'请输入正确的密码',
                    validators:{
                        notEmpty:{
                            message:'密码不能为空'
                        },
                        stringLength: {
                            min: 6,
                            max: 18,
                            message: '密码长度必须在6到18位之间'
                        }
                    }
                },
                phone: {
                    message:'请输入正确的号码',
                    validators: {
                        notEmpty: {
                            message: '电话号码不能为空'
                        },
                        regexp: {
                            regexp: /^13\d{9}$/gi,
                        }
                    }
                },
                verify:{
                    message:'请输入正确的验证码',
                    validators:{
                        notEmpty:{
                            message:'验证码不能为空',
                        }
                    }
                }
            }
        });
        //当电话号码输入正确后才可以点击获取短信验证码
        var phone=$("#phone");
        var btn=$("#getcode");
        var reg=/^13\d{9}$/gi;
        phone.blur(function () {
            if (reg.test(phone.val())){
                btn.removeAttr("disabled")  //当号码符合规则后发送验证码按钮可点击
            }
            else{
                btn.attr("disabled",true)
            }
        });
        btn.onclick=function () {
            alert("发送短信验证码")
        }
        $("#mform").bootstrapValidator({
            live: 'enabled',//验证时机，enabled是内容有变化就验证（默认），disabled和submitted是提交再验证
            message:'信息错误' ,//通用的验证失败消息
            excluded: [':disabled', ':hidden', ':not(:visible)'],//排除无需验证的控件，比如被禁用的或者被隐藏的
            feedbackIcons: {//根据验证结果显示的各种图标
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                name: {
                    message: '请输入正确的用户名',
                    validators: {
                        notEmpty: {
                            message: '用户名不能为空'
                        },
                        stringLength: {
                            min: 6,
                            max: 18,
                            message: '用户名长度必须在6到18位之间'
                        },
                        regexp: {
                            regexp: /^[a-zA-Z0-9_]+$/,
                            message: '用户名只能包含大写、小写、数字和下划线'
                        },
                        threshold :  6 , //有6字符以上才发送ajax请求，（input中输入一个字符，插件会向服务器发送一次，设置限制，6字符以上才开始）
                        remote: {//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}
                            url: 'UserServlet?method=checkUsername',//验证地址
                            message: '用户已存在',//提示消息
                            delay :  2000,//设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
                            type: 'POST'//请求方式
                        }
                    }
                },
                password:{
                    message:'请输入正确的密码',
                    validators:{
                        notEmpty:{
                            message:'密码不能为空'
                        },
                        stringLength: {
                            min: 6,
                            max: 18,
                            message: '密码长度必须在6到18位之间'
                        }
                    }
                },
                email: {
                    message:'请输入正确的邮箱',
                    validators: {
                        notEmpty: {
                            message: '邮箱地址不能为空'
                        },
                        emailAddress:{
                            message:'邮箱格式错误'
                        }
                    }
                },
                verify:{
                    message:'请输入正确的验证码',
                    validators:{
                        notEmpty:{
                            message:'验证码不能为空',
                        }
                    }
                }
            }
        });
        //给验证码图片绑定一个点击事件
        $("#checkImg").click(function () {
            //改变一下他本身地址，在url后面加上一个日期
            $(this).attr("src","checkImg.jpg?"+new Date());
        })
    })
</script>
</html>

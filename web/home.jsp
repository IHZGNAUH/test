<%--
  Created by IntelliJ IDEA.
  User: xsjdn
  Date: 2020/1/6
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyLife主页</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="js/popper.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.js" type="text/javascript"></script>
    <style>
        .topbg{
            height: 500px;
            background: url("images/bdbg01.jpg") no-repeat;
            background-size: cover;
            padding-top: 150px;
            margin-bottom: 30px;
        }
        .footbg{
            height: 100px;
            background-color: #ce8483;
            margin-left: auto;
            margin-top: 30px;
            padding: 5px 20px 5px 100px;
        }
        .footbg a{
            list-style: none;
            float: left;
            margin-left: 30px
        }
    </style>
</head>
<body>
<jsp:include page="include/header.jsp"/>
    <div class="topbg">
        <div class="col-md-4 col-md-offset-2">
            <h3>图标+MyLife</h3>
        </div>
        <div class="col-md-8 col-md-offset-2">
            <h1>陪你过好每一天</h1>
        </div>
    </div>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-3 col-sm-6">
                <div class="card">
                    <img class="card-img-top" src="images/bg002.jpg" alt="Card image" style="width:100%">
                    <div class="card-body">
                        <h4 class="card-title">Blog</h4>
                        <p class="card-text">用blog记录你的心得</p>
                        <a href="blogServlet?method=pageBlogByCid" class="btn btn-primary">进入Blog</a>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-6">
                <div class="card">
                    <img class="card-img-top" src="images/bg002.jpg" alt="Card image" style="width:100%">
                    <div class="card-body">
                        <h4 class="card-title">Plan</h4>
                        <p class="card-text">用plan规划你的生活</p>
                        <a href="#" class="btn btn-primary">进入Plan</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="footbg">
        <h4 style="line-height: 28px">友情链接</h4>
        <div class="text-center">
            <a>cc's blog</a>
            <a>乐享商城</a>
            <a>闪光设计</a>
            <a href="https://www.baidu.com/?tn=21002492_7_hao_pg">百度</a>
            <a href="https://www.imooc.com/">慕课</a>
            <a href="https://www.iviewui.com/">iview</a>
            <a href="https://juejin.im/">掘金</a>
            <a href="https://github.com/">GitHub</a>
            <a href="https://www.csdn.net/">CSDN</a>
        </div>
    </div>
<jsp:include page="include/footer.jsp"/>
</body>
</html>

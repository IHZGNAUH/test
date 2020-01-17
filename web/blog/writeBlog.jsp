<%--
  Created by IntelliJ IDEA.
  User: xsjdn
  Date: 2020/1/10
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>writeBlog</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="../js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="../js/bootstrap.js" type="text/javascript"></script>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-6">
            <form action="${pageContext.request.contextPath}/blogServlet?method=writeBlog" method="post" >
                <div class="form-group">
                    <input name="blogName" placeholder="请输入文章标题">
                </div>
                <div class="form-group">
                    <label for="container">文章内容:</label>
                    <%--<textarea name="blogContent" class="form-control" rows="5" id="content"></textarea>--%>
                    <!-- 加载编辑器的容器 -->
                    <script id="container" name="blogContent" type="text/plain">
                这里写你的博客内容
            </script>
                    <!-- 配置文件 -->
                    <script type="text/javascript" src="../ue/ueditor.config.js"></script>
                    <!-- 编辑器源码文件 -->
                    <script type="text/javascript" src="../ue/ueditor.all.js"></script>
                    <!-- 实例化编辑器 -->
                    <script type="text/javascript">
                        var ue = UE.getEditor('container');
                    </script>
                </div>
                <div class="form-group">
                    <label class="radio-inline"><input type="radio" name="cid" value="1">java</label>
                    <label class="radio-inline"><input type="radio" name="cid" value="5">other</label>
                </div>
                <div class="form-group">
                    <button type="submit">发布文章</button>
                </div>
                </form>
        </div>
        <div class="col-md-6 offset-6">
            hgjgjk
        </div>
    </div>
</div>
</body>
</html>

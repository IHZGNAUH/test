<%--
  Created by IntelliJ IDEA.
  User: xsjdn
  Date: 2020/1/8
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>blog-home</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <script src="../js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="../js/bootstrap.js" type="text/javascript"></script>
</head>
<body class="bg-light">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-2 text-center">
                <div class="card">
                    <img class="card-img-top" src="" style="height: 200px">
                    <div class="card-body">
                        <div class="card-text">
                            <a href="#" class="btn btn-sm btn-primary" style="float: left">个人信息</a>
                            <a href="../blog/writeBlog.jsp" class="btn btn-sm btn-primary" style="float: right">写博客</a>
                        </div>
                    </div>
                </div>
                <!-- 垂直导航栏 -->
                <nav class="navbar bg-white text-center">

                    <!-- Links -->
                    <ul class="navbar-nav" id="categoryList">
                        <li class="nav-item">
                            <a class="nav-link active" href="#">推荐</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/blogServlet?method=pageBlogByUser">我的</a>
                        </li>
                        <%--<li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/blogServlet?method=pageBlogByCid&cid=1">Java</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/blogServlet?method=pageBlogByCid&cid=5">数据库</a>
                        </li>--%>
                    </ul>

                </nav>
            </div>
            <div class="col-md-8 offset-1">
                <!--分页展示-->
                <div class="row">

                    <c:forEach items="${page.list}" var="b">
                            <div class="col-md-6" style="margin-top: 20px">
                                <div class="bg-white">
                                    <a href="blog_info.jsp">${b.blogName}</a>
                                    <div style="width:200px;overflow: hidden;text-overflow: ellipsis;white-space: nowrap">${b.blogContent}</div>
                                    <div class="row">
                                        <a class="col-md-3">${b.postUser}</a>
                                        <a class="col-md-2 offset-5" style="display: flex">
                                            <i class="fa fa-heart" aria-hidden="true" style="margin: auto">${b.likeNumber}</i>
                                        </a>
                                        <a class="col-md-2" style="display: flex">
                                            <i class="fa fa-commenting-o" aria-hidden="true" style="margin: auto">${b.commentNumber}</i>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>

                </div>
                <!--分页栏-->
                <div class="row" style="margin-top: 50px;">
                    <div class="col-md-6 offset-3" style="display: flex">
                        <ul class="pagination" style="margin: auto">
                            <c:if test="${page.currentPage > 1}">
                            <li class="page-item disabled">
                                <a class="page-link" href="${pageContext.request.contextPath}/blogServlet?method=pageBlogByCid&cid=${param.cid}&currPage=${currPage-1}">
                                    &laquo;
                                </a>
                            </li>
                        </c:if>
                            <c:forEach begin="1" end="${page.totalPage}" var="currPage">
                            <li  <c:if test="${page.currentPage == currPage}"> class="page-item active"</c:if> >
                                <a class="page-link" href="${pageContext.request.contextPath}/blogServlet?method=pageBlogByCid&cid=${param.cid}&currPage=${currPage}">${currPage}</a>
                            </li>
                            </c:forEach>
                            <c:if test="${page.currentPage < page.totalPage}">
                            <li class="page-item">
                                <a class="page-link" href="${pageContext.request.contextPath}/blogServlet?method=pageBlogByCid&cid=${param.cid}&currPage=${currPage+1}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<script type="application/javascript">
    $.ajax({
        url:"categoryServlet?method=findAll",
        type:"get",
        dataType:"json",
        success:function (json) {
            //循环遍历json
            for(var i = 0 ;i < json.length;i++)
            {
                var category = json[i];
                //拼装li节点
                var liNode =  "<li class='nav-item'><a class='nav-link' href=\"blogServlet?method=pageBlogByCid&cid="+category.cid+"\">"+category.cname+"</a></li>";
                //选中categoryList ，追加liNode
                $("#categoryList").append(liNode);
            }
        }
    })
</script>
</html>

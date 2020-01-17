<%--
  Created by IntelliJ IDEA.
  User: xsjdn
  Date: 2020/1/6
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>header</title>
</head>
<body>
    <nav class="navbar fixed-top navbar-expand-sm bg-light">
        <a class="navbar-brand" href="#">MyLife</a>
        <a class="navbar-brand" href="#">userName</a>
        <button type="button" class="btn btn-secondary" data-container="body" data-toggle="popover" data-placement="bottom" data-content="Vivamus
	sagittis lacus vel augue laoreet rutrum faucibus.">
            Popover on bottom
        </button>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
            </li>
            <!-- Dropdown -->
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                    中文
                </a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="#">英文</a>
                    <a class="dropdown-item" href="#">西班牙语</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">退出</a>
            </li>
        </ul>
    </nav>
</body>
<script>
    $(document).ready(function(){
        $('[data-toggle="popover"]').popover();
    });
</script>
</html>

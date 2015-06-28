<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jp.ac.hal.tokyo.nippon_hal_fighters.service.UserUtil, java.net.URLEncoder, java.net.URLDecoder" %>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");

	String title = request.getParameter("title");

 	if (title == null) {
		title = URLDecoder.decode(URLEncoder.encode("要員管理システム", "utf-8"), "utf-8");
	}

%>
<!DOCTYPE html>
<html>
  <head>
    <title><%= title %></title>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="./css/styles.css" type="text/css" />
    <link rel="stylesheet" href="./css/font-awesome/font-awesome.css" type="text/css" />
    <%
    	if (request.getParameter("css") != null) {
    		out.println(request.getParameter("css"));
    	}
    %>
    <script src="./js/jquery-2.1.4.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
    <script src="./js/script.js"></script>
    <%
    	if (request.getParameter("script") != null) {
    		out.println(request.getParameter("script"));
    	}
    %>
</head>
<body>
    <!-- 共通部分 -->
    <nav>
        <header>
            <img src="./img/hal_fighters.png" />
            <a href="./index.html">
                <h1>要員管理システム</h1>
            </a>
        </header>
        <%
        if (UserUtil.isLogin(request)) {
		%>
        <form class="input-group">
            <div>
                <select class="form-control">
                    <option>在席中</option>
                    <option>離席中</option>
                    <option>会議中</option>
                    <option>出張中</option>
                    <option>長期病気療養中</option>
                    <option>その他</option>
                </select>
            </div>
            <div>
                <input class="form-control" type="text" placeholder="書き置き" disabled="true" />
            </div>
            <div>
                <input class="btn" type="submit" value="更新" disabled="true" />
            </div>
        </form>
		<%
		}
        %>
        <ul>
        <%
        if (UserUtil.isAdmin(request)) {
       	%>
            <a href="">
                <li><i class="fa fa-home"></i>TOPページ</li>
            </a>
            <a href="">
                <li><i class="fa fa-list"></i>社員情報一覧</li>
            </a>
            <a href="">
                <li><i class="fa fa-user-plus"></i>社員情報登録</li>
            </a>
            <a href="">
                <li><i class="fa fa-cog"></i>マスタ情報更新</li>
            </a>
            <a href="">
                <li><i class="fa fa-pencil"></i>組織図作成</li>
            </a>
            <a href="">
                <li><i class="fa fa-sitemap"></i>組織図閲覧</li>
            </a>
            <a href="">
                <li><i class="fa fa-pencil"></i>座席表作成</li>
            </a>
            <a href="">
                <li><i class="fa fa-th"></i>座席表閲覧</li>
            </a>
            <a href="./LogoutServlet">
                <li class="nav-last"><i class="fa fa-sign-out"></i>ログアウト</li>
            </a>
       	<%
        } else {
		%>
            <a href="">
                <li><i class="fa fa-home"></i>TOPページ</li>
            </a>
            <a href="">
                <li><i class="fa fa-list"></i>社員情報一覧</li>
            </a>
            <a href="">
                <li><i class="fa fa-sitemap"></i>組織図閲覧</li>

            <a href="">
                <li><i class="fa fa-th"></i>座席表閲覧</li>
            </a>
            <%
            if (UserUtil.isLogin(request)) {
            %>
            <a href="./LogoutServlet">
                <li class="nav-last"><i class="fa fa-sign-out"></i>ログアウト</li>
            </a>
            <%
            }
            %>
		<%
        }
        %>
        </ul>
    </nav>
    <!-- 共通部分ここまで -->
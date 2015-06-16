<%@page import="jp.ac.hal.tokyo.nippon_hal_fighters.beans.EmployeeBean"%>
<%@page import="jp.ac.hal.tokyo.nippon_hal_fighters.beans.PostBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>テンプレート</title>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="./css/styles.css" type="text/css" />
    <link rel="stylesheet" href="./css/font-awesome/font-awesome.css" type="text/css" />
    <link rel="stylesheet" href="./css/template.css" type="text/css" />
    <link rel="stylesheet" href="./css/employeeentry.css" type="text/css" />
    <script src="./js/jquery-2.1.4.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
    <script src="./js/script.js"></script>
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
        <ul>
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
            <a href="">
                <li class="nav-last"><i class="fa fa-sign-out"></i>ログアウト</li>
            </a>
        </ul>
    </nav>
    <!-- 共通部分ここまで -->
    <main>
        <%
        	ArrayList<PostBean> postrecode = (ArrayList<PostBean>)request.getAttribute("postlist");
    	%>
    	<div id="main-form">
	        <h2>社員情報登録</h2>
	        <form action="AddEmployeedata" method="post">
	        	<div class="forms">
	        		社員番号:<input type="text" class="form-control" placeholder="社員番号を入力してください" />
	        		<br>
	        	</div>
	        	
	        	<div class="forms">
	        		氏名:<input type="text" class="form-control" placeholder="氏名を入力してください" />
	        		<br>
	        	</div>
	        	
	        	<div class="forms">
	        	雇用状態:<select name="koyo" class="form-control">
						<option value="0">選択してください</option>
						<option value="1">社員</option>
						<option value="2">協力会社</option>
						<option value="3">派遣</option>
					</select>
					<br>
				</div>
				
				<div class="forms">
				役職:<select name="koyo" class="form-control">
						<option value="">選択してください</option>
						<!-- 
						<option value="0">代表取締役会長</option>
						<option value="1">代表取締役社長</option>
						<option value="2">専務取締役</option>
						<option value="3">常務取締役</option>
						<option value="4">監査役</option>
						<option value="5">本部長</option>
						<option value="6">事業部長</option>
						<option value="7">部長</option>
						<option value="8">次長</option>
						<option value="9">係長</option>
						<option value="10">課長</option>
						<option value="11">主任</option>
						<option value="12">リーダー</option>
						<option value="13">メンバー</option>
						-->
						<% 
							for(PostBean post : postrecode){
								out.print("<option value="+post.getPostId()+">"+post.getPostName()+"</option>");
							}
						
						%>
					</select>
					<br>
				</div>
				
				<div class="forms">
				部署:<select name="koyo" class="form-control">
						<option value="">選択してください</option>
						<option value="0000">取締役会</option>
						<option value="0001">代表取締役社長</option>
						<option value="1000">事業統括部</option>
						<option value="1100">事業管理部</option>
						<option value="1101">事業管理</option>
						<option value="1102">人事管理</option>
						<option value="2000">経理事業部</option>
						<option value="2100">東京経理サービス部</option>
						<option value="2101">食肉東京</option>
						<option value="2102">東日本加工事業</option>
						<option value="2103">東日本営業</option>
						<option value="2104">東京経理サービス部長付</option>
						<option value="2200">大阪経理サービス部</option>
						<option value="2201">本社・食肉大阪</option>
						<option value="2202">西日本加工事業</option>
						<option value="2203">西日本営業・資金</option>
						<option value="3000">ITサービス事業部</option>
						<option value="3001">海外支援</option>
						<option value="3100">システム企画部</option>
						<option value="3101">加工企画</option>
						<option value="3101">システム企画</option>
						<option value="3200">システム開発部</option>
						<option value="3201">食肉事業</option>
						<option value="3202">加工開発</option>
						<option value="3203">加工運用</option>
					</select>
					<br>
				</div>
				
				<div class="forms">
	        		内線番号:<input type="text" class="form-control" placeholder="内線番号を入力してください" />
	        		<br>
	        	</div>
	        	
	        	<div class="forms">
	        		外線番号:<input type="text" class="form-control" placeholder="外線番号を入力してください" />
	        		<br>
	        	</div>
	        	
	        	<div class="form">
	        	所属会社:<select name="koyo" class="form-control">
						<option value="0">選択してください</option>
						<option value="1">日本ハムビジネスエキスパート株式会社 大阪本社</option>
						<option value="2">日本ハムビジネスエキスパート株式会社 東京事業所</option>
						<option value="3">協力会社</option>
					</select>
					<br>
				</div>
	        	<input type="submit" value="登録" class="btn btn-default" />
	        </form>
        </div>
    </main>
</body>
</html>

<%@page
	import="jp.ac.hal.tokyo.nippon_hal_fighters.beans.OrganaizationBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta charset="UTF-8" />
<link rel="stylesheet" href="./css/styles.css" type="text/css" />
<link rel="stylesheet" href="./css/font-awesome/font-awesome.css"
	type="text/css" />
<link rel="stylesheet" href="./css/template.css" type="text/css" />
<link rel="stylesheet" href="./css/employeeentry.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="./css/master.css" />
<script src="./js/jquery-2.1.4.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<script src="./js/script.js"></script>
</head>
<body>
	<!-- 共通部分 -->
	<nav>
		<header>
			<img src="./img/hal_fighters.png" /> <a href="./index.html">
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
				<input class="form-control" type="text" placeholder="書き置き"
					disabled="true" />
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
				<li><i class="fa fa-td"></i>座席表閲覧</li>
			</a>
			<a href="">
				<li class="nav-last"><i class="fa fa-sign-out"></i>ログアウト</li>
			</a>
		</ul>
	</nav>
	<!-- 共通部分ここまで -->
	<main> <%
 	ArrayList<OrganaizationBean> recode = (ArrayList<OrganaizationBean>)request.getAttribute("orglist");
  	OrganaizationBean organaizationBean = new OrganaizationBean();
 %>
	<h1>マスタ情報</h1>



	<div id="all">
		<table border="0">
			<tr>
				<form action="#" method="post">
					<td id="left"><input type="text" name="text"
						class="form-control" /></td>
					<td><input type="submit" name="add" value="追加"
						class="btn btn-info"></td>
				</form>

				<form action="#" method="post">
					<td id="right"><select name="category" class="form-control">
							<option value="organaization">部署</option>
							<option value="post">役職</option>
							<option value="phoneInside">内線番号</option>
							<option value="phoneOutside">外線番号</option>
							<option value="company">所属会社</option>
					</select></td>
					<td><input type="submit" name="add" value="切替"
						class="btn btn-info"></td>
				</form>
			</tr>
		</table>
	</div>

	<table border="1">

		<!-- 一行分ここから -->
		<tr>
			<td class="name">部署名</td>

			<td class="change">
				<form action="#" method="post">
					<input type="submit" name="change" value="変更" class="btn btn-info" />
				</form>
			</td>

			<td class="delete">
				<form action="#" method="post">
					<input type="submit" name="delete" value="削除" class="btn btn-info" />
				</form>
			</td>
		</tr>
		<!-- ここまで -->
		<%
			for(OrganaizationBean org : recode){
				out.print(
					"<tr>"+
					"<td class=\"name\">"+org.getOrganaizationName()+"</td>"				//社員番号
					+"<td　class=\"change\"><input type=\"submit\" name=\"change\" value=\"変更\" class=\"btn btn-info\"/></td>"
					+"<td　class=\"delete\"><input type=\"submit\" name=\"delete\" value=\"削除\" class=\"btn btn-info\"/></td>"
					+"</tr>");
				}
		%>

		
		<!--<tr>
			<td class="name">部署名</td>

			<td class="change">
				<form action="#" method="post">
					<input type="submit" name="change" value="変更" class="btn btn-info" />
				</form>
			</td>

			<td class="delete">
				<form action="#" method="post">
					<input type="submit" name="delete" value="削除" class="btn btn-info" />
				</form>
			</td>
		</tr>-->


	</table>

	</main>
</body>
</html>
<%@page import="jp.ac.hal.tokyo.nippon_hal_fighters.controller.GetOrganizationServlet"%>
<%@page import="jp.ac.hal.tokyo.nippon_hal_fighters.beans.CompanieBean"%>
<%@page import="jp.ac.hal.tokyo.nippon_hal_fighters.beans.PhoneBean"%>
<%@page import="jp.ac.hal.tokyo.nippon_hal_fighters.beans.PostBean"%>
<%@page
	import="jp.ac.hal.tokyo.nippon_hal_fighters.beans.OrganaizationBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	String updatetype = (String)request.getAttribute("updatetype"); 
 %>
    
<!DOCTYPE html>
<html>
<head>
<title>追加内容確認</title>
<meta charset="UTF-8" />
<link rel="stylesheet" href="./css/styles.css" type="text/css" />
<link rel="stylesheet" href="./css/font-awesome/font-awesome.css"
	type="text/css" />
<link rel="stylesheet" href="./css/template.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="./css/master.css" />
<link rel="stylesheet" href="./css/jquery.dataTables.css" />
<script src="./js/jquery-2.1.4.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<script src="./js/script.js"></script>
<script src="./js/jquery.dataTables.min.js"></script>
<!--  <script src="./js/AddCheck.js"></script> -->
<script src="./js/TestAddCheck.js"></script>
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
    <main>	
	<table border="0">
	<%
   			//Organaiationの中身を取得
   			OrganaizationBean orgBean = (OrganaizationBean)request.getAttribute("orgBean");
   			//Postの中身を取得
   		    PostBean postBean = (PostBean)request.getAttribute("postBean");
   			//companyの中身を取得
   		  	CompanieBean compBean = (CompanieBean)request.getAttribute("compBean");	   
 
   		   if(updatetype.equals("org")){
   			   //古い組織ID
   				String ordid = (String)request.getAttribute("ordid");
   			   out.print("<h1>組織情報更新確認画面</h1>"
   				+"<form action =\"UpdateMaster\" method=\"post\">"
   				+"<tr><td>ID:"+orgBean.getOrganaizationId()+"</td></tr>"
				+"<tr><td>組織名："+orgBean.getOrganaizationName()+"</td></tr>"
				+"<input type=\"hidden\" name=\"updatetype\" value="+updatetype+" />"
				+"<input type=\"hidden\" name=\"ordid\" value="+ordid+" />"
				+"<input type=\"hidden\" name=\"orgid\" value="+orgBean.getOrganaizationId()+" />"
				+"<input type=\"hidden\" name=\"orgname\" value="+orgBean.getOrganaizationName()+" /></td></tr>"
				+"<tr><td>上記の内容に更新します。よろしいですか？<td></tr>"
				+"<tr><td><input type=\"submit\" name=\"add\" value=\"更新\" class=\"btn btn-info\"></td>"
   		    	+"</form>"
   		    	+"<form action =\"master.jsp\" method=\"post\">"
   	   	  		+"<td><input type=\"submit\" name=\"cancel\" value=\"取消\" class=\"btn btn-info\"></td></tr>"
   	   	  		+"</form>"
   		    	);
   		    }
   		    if(updatetype.equals("post")){
   		 		out.print("<h1>役職情報更新確認画面</h1>"
   	   		  	+"<form action =\"UpdateMaster\" method=\"post\">"
   				+"<tr><td>役職名："+postBean.getPostName()+"</td></tr>"
   				+"<input type=\"hidden\" name=\"updatetype\" value="+updatetype+" />"
   				+"<input type=\"hidden\" name=\"postid\" value="+postBean.getPostId()+" />"
   				+"<input type=\"hidden\" name=\"postname\" value="+postBean.getPostName()+" />"
   				+"<tr><td>上記の内容に更新します。よろしいですか？</td></tr>"
   				+"<tr><td><input type=\"submit\" name=\"add\" value=\"更新\" class=\"btn btn-info\"></td>"
   	   			+"</form>"
   	   			+"<form action =\"master.jsp\" method=\"post\">"
	   	  		+"<td><input type=\"submit\" name=\"cancel\" value=\"取消\" class=\"btn btn-info\"></td></tr>"
	   	  		+"</form>"
   	   		    );
   		    }
   		    if(updatetype.equals("comp")){
   		    	out.print("<h1>所属会社情報更新確認画面</h1>"
   	   	   		+"<form action =\"UpdateMaster\" method=\"post\">"
   	   			+"役職名："+compBean.getCompanyName()+"<br>"
   	   			+"<input type=\"hidden\" name=\"updatetype\" value="+updatetype+" />"
   	   			+"<input type=\"hidden\" name=\"compid\" value="+compBean.getCompanyId()+" />"
   	   			+"<input type=\"hidden\" name=\"compname\" value="+compBean.getCompanyName()+" />"
   	   			+"上記の内容に更新します。よろしいですか？"
   	   			+"<input type=\"submit\" name=\"add\" value=\"更新\" class=\"btn btn-info\">"
   	   	   		+"</form>"
   	   	  		+"<form action =\"master.jsp\" method=\"post\">"
   	   	  		+"<input type=\"submit\" name=\"cancel\" value=\"取消\" class=\"btn btn-info\">"
   	   	  		+"</form>"
   	   	   		);
   		    }
 		
 		
 	%>	
 	</table>
</main>
</body>
</html>
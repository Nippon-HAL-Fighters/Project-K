<%@page import="jp.ac.hal.tokyo.nippon_hal_fighters.beans.CompanieBean"%>
<%@page import="jp.ac.hal.tokyo.nippon_hal_fighters.beans.OrganaiationBean"%>
<%@page import="jp.ac.hal.tokyo.nippon_hal_fighters.beans.EmployeeBean"%>
<%@page import="jp.ac.hal.tokyo.nippon_hal_fighters.beans.PostBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>社員情報登録</title>
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
        	ArrayList<OrganaiationBean> orgrecode = (ArrayList<OrganaiationBean>)request.getAttribute("orglist");
        	ArrayList<CompanieBean> comprecode = (ArrayList<CompanieBean>)request.getAttribute("complist");
			int phoneid = (Integer)request.getAttribute("phoneid");
        %>
    	<div id="main-form">
	        <h2>社員情報登録</h2>
	       <form action="InsertEmployeeData" method="post">
	        	<div class="forms">
	        		社員番号:<input type="text" name="employeeid" class="form-control" placeholder="社員番号を入力してください" />
	        		<br>
	        	</div>
	        	
	        	<div class="forms">
	        		氏名:<input type="text" name="employeename" class="form-control" placeholder="氏名を入力してください" />
	        		<br>
	        	</div>
	        	
	        	<div class="forms">
	        	雇用状態:<select name="koyo" class="form-control">
						<option value="none">選択してください</option>
						<option value="社員">社員</option>
						<option value="協力会社">協力会社</option>
						<option value="派遣">派遣</option>
					</select>
					<br>
				</div>
				
		      	<div class="forms">
	        	管理者権限:<select name="admin" class="form-control">
						<option value="none">選択してください</option>
						<option value="0">なし</option>
						<option value="1">あり</option>
					</select>
					<br>
				</div>
				
				<div class="forms">
				役職:<select name="posts" class="form-control">
						<option value="none">選択してください</option>
						<% 
							for(PostBean post : postrecode){
								out.print("<option value="+post.getPostId()+">"+post.getPostName()+"</option>");
							}
						%>
					</select>
					<br>
				</div>
				
				<div class="forms">
				部署:<select name="org" class="form-control">
						<option value="none">選択してください</option>
						<% 
							for(OrganaiationBean org : orgrecode){
								out.print("<option value="+org.getOrganaizationId()+">"+org.getOrganaizationName()+"</option>");
							}
						%>
					</select>
					<br>
				</div>
				
				<div class="forms">
	        		内線番号:<input type="text" name="foneinside" class="form-control" placeholder="内線番号を入力してください" />
	        		<br>
	        	</div>
	        	
	        	<div class="forms">
	        		外線番号:<input type="text" name="foneout" class="form-control" placeholder="外線番号を入力してください" />
	        		<br>
	        	</div>
	        	
	        	<div class="form">
	        	所属会社:<select name="comp" class="form-control">
						<option value="none">選択してください</option>
						<% 
							for(CompanieBean comp : comprecode){
								out.print("<option value="+comp.getCompanyId()+">"+comp.getCompanyName()+"</option>");
							}
						%>
					</select>
					<br>
				</div>
				<input type="hidden" name="phoneid" value= "<%= phoneid %>" />
				<input type="hidden" name="pass" value="0000" />
	        	<input type="submit" value="登録" class="btn btn-default" />
	        	
	        </form>
        </div>
    </main>
</body>
</html>

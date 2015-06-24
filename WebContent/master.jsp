<%@page import="jp.ac.hal.tokyo.nippon_hal_fighters.beans.CompanieBean"%>
<%@page import="jp.ac.hal.tokyo.nippon_hal_fighters.beans.PhoneBean"%>
<%@page import="jp.ac.hal.tokyo.nippon_hal_fighters.beans.PostBean"%>
<%@page
	import="jp.ac.hal.tokyo.nippon_hal_fighters.beans.OrganaizationBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>マスタ情報</title>
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
<!--  <script>
	$(document).ready(function(){
	    $('#myTable').DataTable({ "language": {
	    	   "url": "//cdn.datatables.net/plug-ins/3cfcc339e89/i18n/Japanese.json"},});
	});
</script>-->

<script>
	$(document).ready(function() {
		$('#myTable').DataTable({
			"language" : {
				"emptyTable" : "データが登録されていません。",
				"info" : "_TOTAL_ 件中 _START_ 件から _END_ 件までを表示",
				"infoEmpty" : "",
				"infoFiltered" : "(_MAX_ 件からの絞り込み表示)",
				"infoPostFix" : "",
				"thousands" : ",",
				"lengthMenu" : "1ページあたりの表示件数: _MENU_",
				"loadingRecords" : "ロード中",
				"processing" : "処理中...",
				"search" : "検索",
				"zeroRecords" : "該当するデータが見つかりませんでした。",
				"paginate" : {
					"first" : "先頭",
					"previous" : "前へ",
					"next" : "次へ",
					"last" : "末尾"
				}
			},
		});
	});
</script>
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
			int num=(Integer)request.getAttribute("num");
   			//Organaiationの中身を取得
  		 	ArrayList<OrganaizationBean> Organaizationrecode = (ArrayList<OrganaizationBean>)request.getAttribute("recode");
   	        OrganaizationBean organaizationBean = new OrganaizationBean();
   		
   			//Postの中身を取得
   		    ArrayList<PostBean> Postrecode = (ArrayList<PostBean>)request.getAttribute("recode");
   		    PostBean postBean = new PostBean();
   		    
   			//Phoneの中身を取得
   		    ArrayList<PhoneBean> phoneRecode = (ArrayList<PhoneBean>)request.getAttribute("recode");
   		    PhoneBean phoneBean = new PhoneBean();
   		    
   			//companyの中身を取得
   		    ArrayList<CompanieBean> companyRecode = (ArrayList<CompanieBean>)request.getAttribute("recode");
   		    CompanieBean companieBean = new CompanieBean();
 	%>
	<h1>マスタ情報</h1>



	<div id="all">
		<table border="0">
			<tr>
				<form action="AddDataServlet" method="post">
					<td id="left"><input type="text" name="addtext"
						class="form-control" /></td>
					<td><input type="submit" name="add" value="追加"
						class="btn btn-info"></td>
						<input type="hidden" name="addtype" value="<%= num %>" />
				</form>

				<form action="ChangeMasterServlet" method="post">
					<td id="right"><select name="category" class="form-control">
							<option value="organaization">部署</option>
							<option value="post">役職</option>
							<option value="company">所属会社</option>
					</select></td>
					<td><input type="submit" name="add" value="切替"
						class="btn btn-info"></td>
				</form>
			</tr>
		</table>
	</div>

	<table cellpadding="0" cellspacing="0" border="1" class="display"
		id="myTable">
		<thead>
			<tr>
				<th>部署名</th>
				<th>変更</th>
				<th>削除</th>
			</tr>
		</thead>
		<tbody>
			<%
			//表示内容を判定するwordを取得
     		
   			System.out.print(num);
				switch(num){
					//組織の場合
					case 1:
					for(OrganaizationBean org : Organaizationrecode){
						out.print(
								"<tr>"
								+"<input type=\"hidden\" name=\"OrganaizationID\" value="+org.getOrganaizationId()+">"
								+"<td>"+org.getOrganaizationName()+"</td>"//部署名
								+"<td><input type=\"submit\" name=\"change\" value=\"変更\" class=\"btn btn-info\" /></td>"
								+"<td><input type=\"submit\" name=\"delete\" value=\"削除\"  class=\"btn btn-info\" /></td>"
								+"</tr>");
							}
					break;
					
					//役職の場合
					case 2:
					for(PostBean post : Postrecode){
					out.print(
								"<tr>"
								+"<input type=\"hidden\" name=\"PostID\" value="+post.getPostId()+">"
								+"<td>"+post.getPostName()+"</td>"//部署名
								+"<td><input type=\"submit\" name=\"change\" value=\"変更\" class=\"btn btn-info\" /></td>"
								+"<td><input type=\"submit\" name=\"delete\" value=\"削除\"  class=\"btn btn-info\" /></td>"
								+"</tr>");
							}
					break;
					
					//内線電話番号の場合
					/*case 3:
					for(PhoneBean phoneInside : phoneRecode){
					out.print(
								"<tr>"
								+"<input type=\"hidden\" name=\"PhoneID\" value="+phoneInside.getPhoneId()+">"
								+"<td>"+phoneInside.getPhoneInside()+"</td>"//外線番号
								+"<td><input type=\"submit\" name=\"change\" value=\"変更\" class=\"btn btn-info\" /></td>"
								+"<td><input type=\"submit\" name=\"delete\" value=\"削除\"  class=\"btn btn-info\" /></td>"
								+"</tr>");
							}
					break;
					
					//外線電話番号の場合
					case 4:
					for(PhoneBean phoneOutside : phoneRecode){
					out.print(
								"<tr>"
								+"<input type=\"hidden\" name=\"PhoneID\" value="+phoneOutside.getPhoneId()+">"
								+"<td>"+phoneOutside.getPhoneOutside()+"</td>"//内線番号
								+"<td><input type=\"submit\" name=\"change\" value=\"変更\" class=\"btn btn-info\" /></td>"
								+"<td><input type=\"submit\" name=\"delete\" value=\"削除\"  class=\"btn btn-info\" /></td>"
								+"</tr>");
							}
					break;*/
					
					//所属会社の場合
					case 3:
					for(CompanieBean company : companyRecode){
					out.print(
								"<tr>"
								+"<input type=\"hidden\" name=\"CompanyID\" value="+company.getCompanyId()+">"
								+"<td>"+company.getCompanyName()+"</td>"//会社名
								+"<td><input type=\"submit\" name=\"change\" value=\"変更\" class=\"btn btn-info\" /></td>"
								+"<td><input type=\"submit\" name=\"delete\" value=\"削除\"  class=\"btn btn-info\" /></td>"
								+"</tr>");
							}
					break;
					
				}//switch文終了
			%>
		</tbody>
	</table>

	</main>
</body>
</html>
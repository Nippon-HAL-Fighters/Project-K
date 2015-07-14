<%@page import="jp.ac.hal.tokyo.nippon_hal_fighters.controller.GetOrganizationServlet"%>
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
<!--  <script src="./js/AddCheck.js"></script> -->
<script src="./js/TestAddCheck.js"></script>

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
	    	"aoColumnDefs": [
		                     { "bSortable": false, "aTargets": [ 2, 3 ] }
		                     ],
		});
	});	
</script>

<script type="text/javascript">
<!--
function delcheck(){
	if(window.confirm('削除します。よろしいですか？')){
	}
	else{
		return false;
	}
}
// -->
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
			int num;
			if(request.getAttribute("num")== null){
				response.sendRedirect("GetOrganizationServlet");
				return;
			}else{
				num = (Integer)request.getAttribute("num");
			}	
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
	<h1>マスタ情報一覧</h1>
	<div id="all">
		<table border="0">
			<tr>
			<%
						if(num == 1){
							out.print("<label id=\"errorgid\" style=\"display:none;color:red;\"></label><label id=\"errorgname\" style=\"display:none;color:red;\"></label>");
						}else if(num == 2){
							out.print("<label id=\"errpostname\" style=\"display:none;color:red;\"></label>");
						}else if(num == 3){
							out.print("<label id=\"errcompname\" style=\"display:none;color:red;\"></label>");
						}
					%>
			
			
				<form action="AddDataServlet" method="post" class="form-inline text-right">
					<td id="left">
					<%
						if(num == 1){
							
							out.print("<input type=\"text\" name=\"orgid\" class=\"form-control\" value=\"\" placeholder=\"組織IDを入力してください\" />"
									 	+"<input type=\"text\" name=\"orgaddtext\" class=\"form-control\" value=\"\" placeholder=\"組織名を入力してください\" />");
						}else if(num == 2){
							out.print("<input type=\"text\" name=\"postaddtext\" class=\"form-control\" value=\"\" placeholder=\"役職名を入力してください\" />");
						}else if(num == 3){
							out.print("<input type=\"text\" name=\"compaddtext\" class=\"form-control\" value=\"\"　 placeholder=\"協力会社名を入力してください\" />");
						}
					%>
					</td>
					<td><input type="submit" name="add" value="追加"
						class="btn btn-info" id="add"/></td>
						<input type="hidden" name="addtype" value="<%= num %>" />
				</form>

				
					<td id="right">
					<form action="ChangeMasterServlet" method="post" class="form-inline text-left">
							<select name="category" class="form-control">
							<option value="organaization">組織</option>
							<option value="post">役職</option>
							<option value="company">所属会社</option>
					</select>
					<input type="submit" name="add" value="切替"
						class="btn btn-info">
					</form></td>
					
			</tr>
		</table>
	</div>

	<table cellpadding="0" cellspacing="0" border="1" class="display"
		id="myTable">
		<thead>
			<tr>

			<%
			//表示内容を判定するwordを取得
     		
   			//System.out.print(num);
				switch(num){
					//組織の場合
					case 1:
						out.print("<th>組織ID</th>"
								+"<th>組織名</th>"
								+"<th>変更</th>"
								+"<th>削除</th>"
								+"</tr>"
								+"</thead>"
								+"<tbody>");
						
					for(OrganaizationBean org : Organaizationrecode){
						out.print(
								"<tr>"
								+"<td>"+org.getOrganaizationId()+"</td>"//組織ID
								+"<td>"+org.getOrganaizationName()+"</td>"//組織名
								+"<td><form action=\"SendUpdateMaster\" method=\"post\"><input type=\"submit\" name=\"change\" class=\"btn btn-info\" value=\"変更\" style=\"width:100%\" />"
								+"<input type=\"hidden\" name=\"OrganaizationID\" value="+org.getOrganaizationId()+" />"	
								+"<input type=\"hidden\" name=\"OrganaizationName\" value="+org.getOrganaizationName()+" />"	
								+"<input type=\"hidden\" name=\"updateType\" value=\"org\" />"
								+"</form></td>"
								+"<td><form action=\"DelMaster\" method=\"post\"><input type=\"submit\" name=\"delete\" value=\"削除\" class=\"btn btn-info\" style=\"width:100%\" onClick=\"return delcheck()\" style=\"width:100%\" /></td>"
								+"<input type=\"hidden\" name=\"OrganaizationID\" value="+org.getOrganaizationId()+" />"
								+"<input type=\"hidden\" name=\"Deltype\" value=\"org\" />"
								+"</form></tr>");
							}
					break;
					
					//役職の場合
					case 2:
						out.print("<th>役職No</th>"
								+"<th>役職名</th>"
								+"<th>変更</th>"
								+"<th>削除</th>"
								+"</tr>"
								+"</thead>"
								+"<tbody>");
					for(PostBean post : Postrecode){
					out.print(
							"<tr>"
							+"<td>"+post.getPostId()+"</td>"//部署ID
							+"<td>"+post.getPostName()+"</td>"//部署名
							+"<td><form action=\"SendUpdateMaster\" method=\"post\"><input type=\"submit\" name=\"change\"  value=\"変更\" class=\"btn btn-info\" style=\"width:100%\" />"
							+"<input type=\"hidden\" name=\"PostID\" value="+post.getPostId()+" />"		
							+"<input type=\"hidden\" name=\"PostName\" value="+post.getPostName()+" />"		
							+"<input type=\"hidden\" name=\"updateType\" value=\"post\" />"
							+"</form></td>"
							+"<td><form action=\"DelMaster\" method=\"post\"><input type=\"submit\" name=\"delete\" value=\"削除\" class=\"btn btn-info\" style=\"width:100%\" onClick=\"return delcheck()\" /></td>"
							+"<input type=\"hidden\" name=\"PostID\" value="+post.getPostId()+" />"		
							+"<input type=\"hidden\" name=\"PostName\" value="+post.getPostName()+" />"	
							+"<input type=\"hidden\" name=\"Deltype\" value=\"post\" />"
							+"</form></tr>");
							}
					break;
					
					//所属会社の場合
					case 3:
						out.print("<th>会社No</th>"
								+"<th>会社名</th>"
								+"<th>変更</th>"
								+"<th>削除</th>"
								+"</tr>"
								+"</thead>"
								+"<tbody>");
					for(CompanieBean company : companyRecode){
					out.print(
								"<tr>"
								+"<td>"+company.getCompanyId()+"</td>"//会社ID
								+"<td>"+company.getCompanyName()+"</td>"//会社名
								+"<td><form action=\"SendUpdateMaster\" method=\"post\"><input type=\"submit\" name=\"change\" class=\"btn btn-info\" value=\"変更\" style=\"width:100%\" />"
								+"<input type=\"hidden\" name=\"CompanyID\" value="+company.getCompanyId()+">"
								+"<input type=\"hidden\" name=\"CompanyName\" value="+company.getCompanyName()+">"	
								+"<input type=\"hidden\" name=\"updateType\" value=\"comp\" />"
								+"</form></td>"
								+"<td><form action=\"DelMaster\" method=\"post\"><input type=\"submit\" name=\"delete\" value=\"削除\" class=\"btn btn-info\" style=\"width:100%\" onClick=\"return delcheck()\" /></td>"
								+"<input type=\"hidden\" name=\"CompanyID\" value="+company.getCompanyId()+">"
								+"<input type=\"hidden\" name=\"CompanyName\" value="+company.getCompanyName()+">"
								+"<input type=\"hidden\" name=\"Deltype\" value=\"comp\" />"
								+"</form></tr>");
							}
					break;
					
				}//switch文終了
			%>
		</tbody>
	</table>
	</main>	
</body>
</html>
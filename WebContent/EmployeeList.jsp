<%@page import="jp.ac.hal.tokyo.nippon_hal_fighters.beans.EmployeeBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>社員情報一覧</title>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="./css/styles.css" type="text/css" />
    <link rel="stylesheet" href="./css/font-awesome/font-awesome.css" type="text/css" />
	<link rel="stylesheet" href="./css/employeelist.css" type="text/css" />
    <script src="./js/jquery-2.1.4.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
    <script src="./js/script.js"></script>
    <script src="./js/jquery.dataTables.min.js"></script>
	<link rel="stylesheet" href="./css/jquery.dataTables.css" />
	<script>
	$(document).ready(function(){
	    $('#myTable').DataTable({ 
	    	"language": {
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
	    		}
	    });
	});
	</script>
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
    		ArrayList<EmployeeBean> recode = null;
			//EmployeeBean employeeBean = new EmployeeBean();
			recode = (ArrayList<EmployeeBean>)request.getAttribute("recode");
			
			if(recode == null){
				response.sendRedirect("GetEmployeeData");
				return;
			}
    	%>
		<h1>社員情報一覧</h1>
		
		<div id="sort_box">
			<div id="header_left">
				<select name="sort" class="form-control" id="sort">
					<option value="1">条件1?</option>
					<option value="2">条件2?</option>
					<option value="3">条件3?</option>
				</select>
			</div>
			<div id="header_right">
				<input type="text" name="text" class="form-control" id="text"/>
				<input type="submit" value="検索" id="submit" />
			</div>
		</div>
		
		<!-- とりあえず仮置きでテーブルにて出力 -->	
		<table cellpadding="0" cellspacing="0" border="0" class="display" id="myTable">
			<thead>
				<tr>
					<th>社員番号</th>
					<th>氏名</th>
					<th>雇用状態</th>
					<th>役職</th>
					<th>組織</th>
					<th>内線番号</th>
					<th>外線番号</th>
					<th>所属会社</th>
					<th></th>
				</tr>	
			</thead>
			<tbody>
			<%
				for(EmployeeBean emp : recode){
					out.print("<tr>"+
								"<td>"+emp.getEmployeeId()+"</td>"				//社員番号
								+"<td>"+emp.getEmployeeName()+"</td>"			//氏名
								+"<td>"+emp.getEmployeeStatus()+"</td>"			//雇用状態
								+"<td>"+emp.getPostName()+"</td>"				//役職
								+"<td>"+emp.getOrgnaizationName()+"</td>"		//組織
								+"<td>"+emp.getPhoneInside()+"</td>"			//内線番号
								+"<td>"+emp.getPhoneOutside()+"</td>"			//外線番号
								+"<td>"+emp.getCompanayName()+"</td>"			//所属会社
								+"<td><form action=\"SendUpdateEmployeeData\" method=\"post\">"
								+"<input type=\"submit\" value=\"更新\" class=\"chengebutton\" style=\"width:100%\" />"
								+"<input type=\"hidden\" name=\"updateempid\" value="+emp.getEmployeeId()+" />"
								+"</form></td>"
								+"<td><form action=\"DelEmployeeData\" method=\"post\">"
								+"<input type=\"submit\" value=\"削除\" class=\"chengebutton\" style=\"width:100%\" />"
								+"<input type=\"hidden\" name=\"delempid\" value="+emp.getEmployeeId()+" />"
								+"<input type=\"hidden\" name=\"delphoneid\" value="+emp.getPhoneId()+" />"
								+"</form></td>"
								+"</tr>");
					}
				%>
			</tbody>
		</table>
    </main>
</body>
</html>

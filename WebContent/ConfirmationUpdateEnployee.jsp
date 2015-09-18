<%@page import="jp.ac.hal.tokyo.nippon_hal_fighters.beans.PhoneBean"%>
<%@page import="jp.ac.hal.tokyo.nippon_hal_fighters.beans.CompanieBean"%>
<%@page import="jp.ac.hal.tokyo.nippon_hal_fighters.beans.OrganaizationBean"%>
<%@page import="jp.ac.hal.tokyo.nippon_hal_fighters.beans.EmployeeBean"%>
<%@page import="jp.ac.hal.tokyo.nippon_hal_fighters.beans.PostBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>社員情報登録確認画面</title>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="./css/styles.css" type="text/css" />
    <link rel="stylesheet" href="./css/font-awesome/font-awesome.css" type="text/css" />
    <link rel="stylesheet" href="./css/template.css" type="text/css" />
    <link rel="stylesheet" href="./css/confEmployee.css" type="text/css" />
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
    	request.setCharacterEncoding("utf-8");
    	//ArrayList<EmployeeBean> recode = null;
		String adminName = null;
		EmployeeBean recode = (EmployeeBean)request.getAttribute("emprecode");
		String ordEmpid = (String)request.getAttribute("ordemp");
    %> 
    
		<h2>社員情報更新確認画面</h2>
		<div id="forms">
		<form action="UpdateEmployeeData" method="post">
			<table>
			<%
				if(recode.getAdmin() == 0){
					adminName = "なし";
				}else{
					adminName = "あり";
				}
				out.print("<tr><th>社員番号</th><td>"+recode.getEmployeeId()+"</td></tr>"
					+"<tr><th>氏名</th><td>"+recode.getEmployeeName()+"</td></tr>"
					+"<tr><th>氏名</th><td>"+recode.getPassword()+"</td></tr>"
					+"<tr><th>雇用状態</th><td>"+recode.getEmployeeStatus()+"</td></tr>"
					+"<tr><th>管理者権限</th><td>"+adminName+"</td></tr>"
					+"<tr><th>役職</th><td>"+recode.getPostName()+"</td></tr>"
					+"<tr><th>部署</th><td>"+recode.getOrgnaizationName()+"</td></tr>"
					+"<tr><th>所属会社</th><td>"+recode.getCompanayName()+"</td></tr>"
					+"<tr><th>内線番号</th><td>"+recode.getPhoneInside()+"</td></tr>"
					+"<tr><th>外線番号</th><td>"+recode.getPhoneOutside()+"</td></tr>");			
			 %>
			</table>

			<input type="hidden" name="employeeid" value=<%= recode.getEmployeeId() %>>
			<input type="hidden" name="ordempid" value=<%=ordEmpid %>>
			<input type="hidden" name="employeename" value=<%= recode.getEmployeeName() %>>
			<input type="hidden" name="password" value=<%= recode.getPassword() %>>
			<input type="hidden" name="employeestatus" value=<%= recode.getEmployeeStatus() %>>
			<input type="hidden" name="admin" value=<%= recode.getAdmin() %>>
			<input type="hidden" name="posts" value=<%= recode.getPostId()%>>
			<input type="hidden" name="org" value=<%= recode.getOrgnaizationId()%>>
			<input type="hidden" name="comp" value=<%= recode.getCompanyId() %>>
			<input type="hidden" name="phoneid" value=<%= recode.getPhoneId() %>>
			<input type="hidden" name="phoneinside" value=<%= recode.getPhoneInside() %>>
			<input type="hidden" name="phoneoutside" value=<%= recode.getPhoneOutside() %>>
			
			<div id="centerbox">
				上記の内容に更新します。よろしいですか？<br>
				<input type="submit" name="submit" value="更新" class="btn btn-primary" >
				<input type="submit" name="submit" value="取り消し" class="btn btn-primary" >
			</div>
		</form>
		</div>
    </main>
</body>
</html>
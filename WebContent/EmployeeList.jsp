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
    		ArrayList<EmployeeBean> recode = (ArrayList<EmployeeBean>)request.getAttribute("recode");
			EmployeeBean employeeBean = new EmployeeBean();
    	%>
		<h1>社員情報一覧</h1>
		
		<div class="header">
			<div id="header_left">
				<select name="sort" class="form-control" id="test">
					<option value="1">条件1?</option>
					<option value="2">条件2?</option>
					<option value="3">条件3?</option>
				</select>
			</div>
			<div id="header_right">
				<input type="text" name="text" class="form-control" />
				<input type="submit" value="検索" />
			</div>
		</div>
		
		<!-- とりあえず仮置きでテーブルにて出力 -->
		<table border="1">

		<tr><th>社員番号</th><th>氏名</th><th>部署</th><th>役職</th><th>内線番号</th><th>外線番号</th><th>所属会社</th><th>在籍状態</th></tr>		
		
		<%
			for(EmployeeBean emp : recode){
				out.print("<tr>"+
						"<td>"+emp.getEmployeeId()+"</td>"
						+"<td>"+emp.getEmployeeName()+"</td>"
						+"<td>"+emp.getEmployeeStatus()+"</td>"
						+"<td>"+emp.getAdmin()+"</td>"
						+"<td>"+emp.getPhoneId()+"</td>"
						+"<td></td>"
						+"<td>"+emp.getCompanyId()+"</td>"
						+"<td></td>"
						+"<td><input type=\"submit\" value=\"編集\" class=\"chengebutton\" style=\"width:100%\" /></td>"
						+"</tr>");
			}
		%>
				
			<tr><th>社員番号</th><th>氏名</th><th>部署</th><th>役職</th><th>内線番号</th><th>外線番号</th><th>所属会社</th><th>在籍状態</th></tr>		
			<tr><td>999999</td><td>XXXXXXXX</td><td>XXXX</td><td>XXXX</td><td>9999</td><td>9999999999</td><td>XXXX</td><td>XXXX</td><td><input type="submit" value="編集" class="chengebutton" style="width:100%" /></td></tr>
			<tr><td>999999</td><td>XXXXXXXX</td><td>XXXX</td><td>XXXX</td><td>9999</td><td>9999999999</td><td>XXXX</td><td>XXXX</td><td><input type="submit" value="編集" class="chengebutton" style="width:100%" /></td></tr>
			<tr><td>999999</td><td>XXXXXXXX</td><td>XXXX</td><td>XXXX</td><td>9999</td><td>9999999999</td><td>XXXX</td><td>XXXX</td><td><input type="submit" value="編集" class="chengebutton" style="width:100%" /></td></tr>
			<tr><td>999999</td><td>XXXXXXXX</td><td>XXXX</td><td>XXXX</td><td>9999</td><td>9999999999</td><td>XXXX</td><td>XXXX</td><td><input type="submit" value="編集" class="chengebutton" style="width:100%" /></td></tr>		
		</table>
    </main>
</body>
</html>

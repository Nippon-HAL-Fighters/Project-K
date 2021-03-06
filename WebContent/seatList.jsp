<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>テンプレート</title>
<meta charset="UTF-8" />
<link rel="stylesheet" href="./css/styles.css" type="text/css" />
<link rel="stylesheet" href="./css/font-awesome/font-awesome.css"
	type="text/css" />
<link rel="stylesheet" href="./css/seatList.css" type="text/css" />
<script src="./js/jquery-2.1.4.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<script src="./js/script.js"></script>
<script src="./js/list.js"></script>
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
				<li><i class="fa fa-th"></i>座席表閲覧</li>
			</a>
			<a href="">
				<li class="nav-last"><i class="fa fa-sign-out"></i>ログアウト</li>
			</a>
		</ul>
	</nav>
	<!-- 共通部分ここまで -->
	<main> <!-- <script language="javascript">
		function getCELL() {
			var myTbl = document.getElementById('TBL');
			// trをループ。rowsコレクションで,行位置取得。
			for (var i = 0; i < myTbl.rows.length; i++) {
				// tr内のtdをループ。cellsコレクションで行内セル位置取得。
				for (var j = 0; j < myTbl.rows[i].cells.length; j++) {
					var Cells = myTbl.rows[i].cells[j]; //i番行のj番列のセル "td"
					// onclickで 'Mclk'を実行。thisはクリックしたセル"td"のオブジェクトを返す。
					Cells.onclick = function() {
						Mclk(this);
					}
				}
			}
		}

		function Mclk(Cell) {
			var rowINX = '行位置：' + Cell.parentNode.rowIndex;//Cellの親ノード'tr'の行位置
			var cellINX = 'セル位置：' + Cell.cellIndex;
			var cellVal = 'セルの内容：' + Cell.innerHTML;
			//取得した値の書き出し
			res = rowINX + '<br/> ' + cellINX + '<br/>' + cellVal;
			document.getElementById('Mbox0').innerHTML = res;
			var Ms1 = document.getElementById('Mbox1')
			Ms1.innerText = Cell.innerHTML;
			Ms1.textContent = Cell.innerHTML;
		}
		// try ～ catch 例外処理、エラー処理
		// イベントリスナーaddEventListener,attachEventメソッド
		try {
			window.addEventListener("load", getCELL, false);
		} catch (e) {
			window.attachEvent("onload", getCELL);
		}
	</script>
	-->

	<div class="header_box">
		<h2>座席表一覧</h2>
		<form action="BackupServlet" name="form" method="post">

			<input type="hidden" id="cell" name="cell" value="" />
			<button type="submit" class="btn btn-primary headerbtn" value="編集"
				name="choices">編集</button>
			<button type="submit" class="btn btn-primary headerbtn" value="削除"
				name="choices">削除</button>
			<button type="submit" class="btn btn-primary headerbtn" value="印刷"
				name="choices">印刷</button>
			<button type="submit" class="btn btn-primary headerbtn" value="新規"
				name="choices">新規作成</button>
		</form>
	</div>

	<div class="main_box">


		<table id="TBL">
			<tbody>
				<tr>
					<th width="50%">タイトル</th>
					<th width="25%">最終変更日</th>
					<th width="25">変更者</th>
				</tr>


				<c:forEach items="${listData}" var="list" varStatus="status">
					<tr id="tr${status.count}" onclick="sentaku(${status.count})"
						style="">
						<td><a style="display: none">,${list.backupId},</a>${list.title}</td>
						<td><a style="display: none">,${list.backupId},</a>${list.resetDate}</td>
						<td><a style="display: none">,${list.backupId},</a>${list.implementor}</td>
					</tr>
				</c:forEach>


			</tbody>
		</table>
		<div id="Div">

			<p id="Mbox0">セルをクリックしたらここに書き出します。</p>
			<p id="Mbox1">インデックス値は '0'から始まります。</p>
			<input type="hidden" id="Mbox0" /> <input type="hidden" id="Mbox1" />

		</div>
	</div>


	</main>
</body>
</html>

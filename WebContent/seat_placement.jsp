<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>座席表人員配置ページ</title>
<meta charset="UTF-8" />
<link rel="stylesheet" href="./css/styles.css" type="text/css" />
<link rel="stylesheet" href="./css/font-awesome/font-awesome.css" type="text/css" />
<link rel="stylesheet" href="./css/joint.all.min.css" type="text/css" />
<link rel="stylesheet" href="./css/jointjs_seatEdit.css" type="text/css" />
<link rel="stylesheet" href="./css/seatEdit.css" type="text/css" />
<link rel="stylesheet" href="./css/print.css" type="text/css" media="print" />

<script src="./js/jquery-2.1.4.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<script src="./js/joint.all.min.js"></script>
<script src="./js/script.js"></script>
<script src="./js/jointjs_seat_placement.js"></script>


<style type="text/css">
input#sample {
    width:200px;
    padding:2px;
}
input.dummy_text {
    color:#888;
}
</style>

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
	<main>
	<div class="header_box">
		<h2>人員の配置</h2>
		<input type="text" id="sample" value="" />

		<button type="button" class="item btn btn-primary headerbtn" value="保存">保存</button>
		<button type="button" class="item btn btn-primary headerbtn" value="印刷">印刷</button>

		<button type="button" class="item btn btn-primary headerbtn" value="redo">進む</button>
		<button type="button" class="item btn btn-primary headerbtn" value="undo">戻る</button>

	</div>
	<div class="main_box">
		<div class="edit_area"></div>
	</div>

	<div class="sub_box">
		<div class="tabbox">
			<div id="0" class="tab">
				<p>
				<div>
					<button type="button" class="item btn btn-primary name">一郎</button>
					<button type="button" class="item btn btn-primary name">二郎</button>
					<button type="button" class="item btn btn-primary name">三郎</button>
				</div>
				</p>
			</div>
		</div>

	</div>

	</main>
</body>
</html>


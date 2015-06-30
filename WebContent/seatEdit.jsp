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
<link rel="stylesheet" href="./css/seatEdit.css" type="text/css" />
<link rel="stylesheet" href="./css/joint.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="./print.css" media="print" />
<script src="./js/jquery-2.1.4.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<script src="./js/script.js"></script>
<script type="text/javascript" src="joint.format.print.js"></script>
<script src="./js/joint.all.min.js"></script>
<script src="./js/jointjs_seatEdit.js"></script>
<script src="./js/change.js"></script>


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
		<h2>座席表作成</h2>
		<input type="text" id="sample" value="" />

		<a class="btn btn-primary headerbtn">保存</a> <a href="#tab1" id="tab1"
			class="btn btn-primary headerbtn" style="display: none;"
			onclick="ChangeTab('0'); return false;">切り替え</a> <a href="#tab2"
			id="tab2" class="btn btn-primary headerbtn" style="display: block;"
			onclick="ChangeTab('1'); return false;">切り替え</a>
		<button type="button" class="btn btn-primary headerbtn button"
			value="印刷">印刷</button>

	</div>
	<div id="main_box">
		<div id="editArea" style="width: 1000px; height: 600px;"></div>
	</div>

	<div class="sub_box">
		<div class="tabbox">
			<div id="0" class="tab">
				<p>
				<div class="btn btn-primary name">田中 タロウ</div>
				<div class="btn btn-primary name">田中 タロウ</div>
				<div class="btn btn-primary name">田中 タロウ</div>
				</p>

			</div>
			<div id="1" class="tab">
				<p>
				<div>
					<button type="button" class="button btn btn-primary name" value="机">机</button>
					<button type="button" class="button btn btn-primary name" value="丸">丸</button>
					<button type="button" class="button btn btn-primary name"
						value="しきり">しきり</button>
				</div>
				</p>

			</div>
		</div>
		<script type="text/javascript">
			// デフォルトのタブを選択
			ChangeTab('0');
		</script>




	</div>

	</main>
</body>
</html>


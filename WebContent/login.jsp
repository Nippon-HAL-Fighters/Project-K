<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>ログインページ</title>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="./css/styles.css" type="text/css" />
    <link rel="stylesheet" href="./css/font-awesome/font-awesome.css" type="text/css" />
    <link rel="stylesheet" href="./css/login.css" type="text/css" />
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
        <div class="left_box text-center">
            <h2>要員管理システム</h2>
            <img src="./img/hal_fighters.png" />
        </div>
        <div class="login_box">
            <h3>ログインしてください</h3>
            <%
            if (request.getAttribute("errorMsg") != null) {

           %>
            <div class="panel panel-danger">
                <div class="panel-heading">
                    エラー
                </div>
                <div class="panel-body">
                    <%= (String) request.getAttribute("errorMsg") %>
                </div>
            </div>
                <%
            }
            %>
            <form action="LoginServlet" method="post">
                <div class="input-group">
                    <span class="input-group-addon" id="employee-id-addon">
                        <i class="fa fa-user"></i>
                    </span>
                  <input type="text" name="employee_id" class="form-control" placeholder="従業員番号（数字5桁で入力してください）" aria-describedby="employee-id-addon" />
                </div>
                <div class="input-group">
                    <span class="input-group-addon" id="password-addon">
                        <i class="fa fa-key"></i>
                    </span>
                  <input type="password" name="password" class="form-control" placeholder="パスワード（数字5桁で入力してください）" aria-describedby="password-addon" />
                </div>
                <button class="btn btn-default btn-lg">ログイン</button>
            </form>
        </div>
    </main>
</body>
</html>

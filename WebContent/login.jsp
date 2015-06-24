<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String script = "<script>alert(\"Test Script\");</script>";
	String css    = "<link rel=\"stylesheet\" href=\"./css/login.css\" type=\"text/css\" />";
%>

	<jsp:include page="./common_menu.jsp">
	    <jsp:param value="ログインページ" name="title"/>
	    <jsp:param value="<%= css %>" name="css" />
	    <jsp:param value="<%= script %>" name="script"/>
	</jsp:include>
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

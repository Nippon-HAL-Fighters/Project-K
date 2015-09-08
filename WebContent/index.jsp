<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String title = "TOPページ";
	String css   = "<link rel=\"stylesheet\" href=\"./css/index.css\" type=\"text/css\" />";
%>

	<jsp:include page="./common_menu.jsp">
	    <jsp:param value="<%= css %>" name="css" />
	    <jsp:param value="<%= title %>" name="title" />
	</jsp:include>
    <main>
        <h2>TOPページ</h2>
        <div class="panel panel-primary">
            <div class="panel-heading">
                	在席情報
            </div>
            <div class="panel-body">
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
                        <input class="form-control" type="text" placeholder="書き置き" />
                    </div>
                    <div>
                        <input class="btn btn-warning" type="submit" value="更新" />
                    </div>
                </form>
            </div>
        </div>
    </main>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, jp.ac.hal.tokyo.nippon_hal_fighters.beans.OrgChartBean, java.util.HashMap" %>
<%
	request.setCharacterEncoding("utf-8");

	if (request.getAttribute("orgCharts") == null) {
		response.sendRedirect("./OrgChartListServlet");
		return;
	}

	ArrayList<OrgChartBean> charts = (ArrayList<OrgChartBean>) request.getAttribute("orgCharts");
	HashMap<String, String> empNameMap = (HashMap<String, String>) request.getAttribute("empNameMap");

	String title = "組織図作成";
	String css   = "<link rel=\"stylesheet\" href=\"./css/index.css\" type=\"text/css\" />";
	String script = "<script src=\"./js/org_chart_list.js\"></script>";
%>

	<jsp:include page="./common_menu.jsp">
	    <jsp:param value="<%= css %>" name="css" />
	    <jsp:param value="<%= title %>" name="title" />
	    <jsp:param value="<%= script %>" name="script" />
	</jsp:include>
    <main>
        <h2>組織図一覧</h2>
		<table class="table">
			<tr>
				<th>タイトル</th>
				<th>最終更新日</th>
				<th>作成者</th>
				<th>削除</th>
			</tr>
			<%
			for (OrgChartBean ocb : charts) {
				out.println("<tr>");
				out.println("<td><a class=\"title_link\" href=\"./make_org_chart.html?org_chart_id=" + ocb.getOrgChartID() + "\">" + ocb.getTitle() + "</a></td>");
				out.println("<td>" + ocb.getLastModify() + "</td>");
				out.println("<td>" + empNameMap.get(ocb.getEmployeeID()) + "</td>");
				out.println("<td><a class=\"delete_link\" href=\"./OrgChartServlet?org_chart_id=" + ocb.getOrgChartID() + "\">削除する</a></td>");
				out.println("</tr>");
			}
			%>
		</table>
    </main>
</body>
</html>

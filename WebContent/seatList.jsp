<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table id="TBL">
		<tbody>
			<tr>
				<th width="50%">タイトル</th>
				<th width="25%">最終変更日</th>
				<th width="25">変更者</th>
			</tr>

			<c:forEach var="list" items="${list} varStatus="status">
				<tr id="tr1" onclick="sentaku(1)">
					<td><a style="display: none">,1,</a>ほげほげふぁいる</td>
					<td>2015/6/1</td>
					<td>ほげ～</td>
				</tr>
			</c:forEach>

			<tr id="tr2" onclick="sentaku(2)">
				<td><a style="display: none">,2,</a>ほげほげふぁいる</td>
				<td>2015/6/1</td>
				<td>ほげ～</td>
			</tr>

		</tbody>
	</table>
</body>
</html>
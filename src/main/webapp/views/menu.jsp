<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/script.js"></script>
</head>

<body>
	<h1>メニュー</h1>
	<%
	if (request.getAttribute("message") != null && !request.getAttribute("message").equals("")) {
	%>
	<%=request.getAttribute("message")%>
	<br>
	<%
	}
	%>


	<%
	if (session.getAttribute("username") != null && !session.getAttribute("username").equals("")) {
	%>
	ようこそ
	<%=session.getAttribute("username")%>
	さん！
	<br>
	<button onclick="goToUpdate()">会員情報変更ページへ</button>
	<form action="logoutServlet" method="post">
		<input type="submit" value="ログアウトページへ">
	</form>
	<button onclick="goToDelete()">アカウントの削除へ</button>

	<%
	} else {
	%>

	<button onclick="goToLogin()">ログインページへ</button>
	<%
	}
	%>

</body>
</html>
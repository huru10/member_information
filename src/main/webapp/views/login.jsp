<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>ログイン</title>
</head>
<body>
	<%
	if (request.getAttribute("errormsg") != null) {
	%>
	<p style="color: red;"><%=request.getAttribute("errormsg")%></p>
	<%
}
%>
	<h2>ログイン</h2>
	<form action="loginServlet" method="post">
		<label for="userId">ID:</label> <input type="text" id="userId"
			name="userId"><br> <br> <label for="password">パスワード:</label>
		<input type="password" id="password" name="password"><br>
		<br> <input type="submit" value="ログイン">
	</form>
	<br>
	<a href="passwordUpdate.jsp">パスワードを忘れた方はこちら</a>
	<br>
	<a href="newuser.jsp">会員登録の方はこちら</a>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>会員登録</title>
<script src="addressSearch.js"></script>
<script src="../js/script.js"></script>
</head>
<body>
	<h2>会員登録フォーム</h2>
	<form action="registarServlet" method="post">
		<label for="userId">ユーザーID:</label> <input type="text" id="userId"
			name="userId" required><br> <br> <label
			for="username">ユーザー名:</label><input type="text" id="username"
			name="username" required><br> <br> <label for="fm">性別:</label>
		<input type="radio" name="fm" value="男" checked>男 <input
			type="radio" name="fm" value="女">女 <input type="radio"
			name="fm" value="その他">その他 <br> <br> <label
			for="y_birth">生まれた年:</label> <input type="text" id="y_birth"
			name="y_birth" required><br> <br> <label
			for="d_birth">生まれた日:</label><input type="text" id="d_birth"
			name="d_birth" required><br> <br> <label for="mail">メールアドレス:</label>
		<input type="text" id="mail" name="mail" required><br> <br>
		<label for="zipCode">郵便番号：</label> <input type="text" id="zipCode"
			name="zipCode" required>
		<button type="button" onclick="searchAddress()">検索</button>
		<br> <br> <label for="address">住所：</label> <input
			type="text" id="address" name="address" required> <br> <br>
		<label for="pass">パスワード:</label> <input type="password" id="pass"
			name="pass" required> <br> <br> <label
			for="question">秘密の質問:</label> <input type="text" id="question"
			name="question" required> <br> <br> <label
			for="answer">質問の答え:</label> <input type="text" id="answer"
			name="answer" required> <br> <br> <input
			type="submit" value="登録">
	</form>
</body>
</html>

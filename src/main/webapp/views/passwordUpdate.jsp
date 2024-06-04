<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>パスワード変更</title>
</head>
<body>
	<h2>パスワード変更フォーム</h2>
	<form action="passupdate" method="post">
		<label for="mail">メールアドレス:</label> <input type="text" id="mail"
			name="mail" required><br> <br> <label
			for="question">秘密の質問:</label> <input type="text" id="question"
			name="question" required> <br> <br> <label
			for="answer">質問の答え:</label> <input type="text" id="answer"
			name="answer" required> <br> <br> <label for="pass">パスワード:</label>
		<input type="password" id="pass" name="pass" required> <br>
		<br> <label for="passcheck">パスワード再確認:</label> <input
			type="password" id="passcheck" name="passcheck" required> <br>
		<br> <input type="submit" value="登録">
	</form>
</body>
</html>

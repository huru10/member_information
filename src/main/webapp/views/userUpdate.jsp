<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>会員情報変更</title>
<script src="../js/script.js"></script>
</head>
<body>
	<h2>登録情報変更フォーム</h2>
	<form action="userupdate" method="post">
		<label for="mail">メールアドレス:</label> <input type="text" id="mail"
			name="mail"><br> <br> <label for="zipCode">郵便番号：</label>
		<input type="text" id="zipCode" name="zipCode">
		<button type="button" onclick="searchAddress()">検索</button>
		<br> <br> <label for="address">住所：</label> <input
			type="text" id="address" name="address"> <br> <br>
		<input type="submit" value="更新">
	</form>
</body>
</html>

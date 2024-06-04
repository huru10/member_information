function searchAddress() {
	var zipCode = document.getElementById("zipCode").value;
	// 郵便番号に対応する住所を取得するための処理を記述する
	// ここではAPIを使用する例を示す
	var apiUrl = "https://zipcloud.ibsnet.co.jp/api/search?zipcode=" + zipCode;
	fetch(apiUrl)
		.then(response => response.json())
		.then(data => {
			var address = data.results[0].address1 + data.results[0].address2 + data.results[0].address3;
			document.getElementById("address").value = address;
		})

		.catch(error => console.error('Error:', error));
}

function goToUpdate() {
	// ログインページへのURLを指定
	var updatePageUrl = "userUpdate.jsp";
	// ページを遷移
	window.location.href = updatePageUrl;
}

function goToDelete() {
	// ログインページへのURLを指定
	var deletePageUrl = "userDelete.jsp";
	// ページを遷移
	window.location.href = deletePageUrl;
}

function goToLogin() {
	// ログインページへのURLを指定
	var loginPageUrl = "login.jsp";
	// ページを遷移
	window.location.href = loginPageUrl;
}
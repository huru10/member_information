function searchAddress() {		//郵便番号を入力して決定を押すと住所を自動で入力してくれる
	var zipCode = document.getElementById("zipCode").value;
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
	// 会員情報更新ページへのURLを指定
	var updatePageUrl = "userUpdate.jsp";
	// ページを遷移
	window.location.href = updatePageUrl;
}

function goToDelete() {
	// 退会ページへのURLを指定
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<style>
.main {
	text-align: center;
	padding: 30px 0
}

.error-message {
	color: red;
}
</style>
</head>
<body>
	<div class="main">
		<main>
			<div class="main__imageBox">
				<img class="main__image" src="assets/images/seassist_logo.png"
					alt="ロゴ">
			</div>
			<h2>従業員管理システム</h2>
			<%
			String errMsg = (String) request.getAttribute("errorMessage");
			if (errMsg != null) {
			%>
			<div class="error-message"><%=errMsg%></div>
			<%
			}
			%>
			<form action="login" method="post">
				<input type="text" name="id" placeholder="userId"><br>
				<input type="password" name="password" placeholder="password"><br>
				<br> <input type="submit" value="ログイン">
			</form>
		</main>
	</div>
</body>
</html>

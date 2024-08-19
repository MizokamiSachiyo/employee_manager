<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="assets/stylesheets/app.css">
<style>
.header header {
	display: flex;
	align-items: center;
	justify-content: space-between;
	padding: 12px 25px;
}
</style>
</head>
<body>
	<div class="header">
		<header>
			<div class="header__imageBox">
				<img class="header__image" src="assets/images/seassist_logo.png"
					alt="ロゴ">
			</div>
			<form action="logout" method="post">
				<input type="submit" value="ログアウト">
			</form>
		</header>
	</div>
</body>
</html>
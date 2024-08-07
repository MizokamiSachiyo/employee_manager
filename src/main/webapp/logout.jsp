<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログアウト画面</title>
</head>
<body>
	<div class="main">
		<main>
			<%
			/* リクエストからユーザIdを取得 */
			String userId = (String) request.getAttribute("userId");
			%>
			<h2><%=userId%>さんログアウトしました
			</h2>
			<form action="login.jsp" method="post">
				<input type="submit" value="ログイン画面へ">
			</form>
		</main>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー画面</title>
<style>
.main {
	text-align: center;
}
</style>
</head>
<body>
  <%@ include file="header.jsp"%>
  <div class="main">
    <main>
      <h2>従業員管理システム</h2>
      <form action="menu" method="post">
        <input type="submit" name="button" value="従業員一覧"><br>
        <input type="submit" name="button" value="従業員登録画面へ"><br>
        <input type="submit" name="button" value="経験言語登録画面へ">
      </form>
    </main>
  </div>
</body>
</html>

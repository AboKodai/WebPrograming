<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/style.css">
<meta charset="UTF-8">
<title>ログイン画面</title>

</head>
<body>
	<!-- body -->

	<div class="container center">

		<c:if test="${errMsg != null }">
			<div>
				<font color="red">${errMsg}</font>
			</div>
		</c:if>

		<h1 class="top">ログイン画面</h1>
		<form method="post" action="LoginServlet">
			<div class="center content-margin">
				<span>ログインID：</span> <input type="text" name="loginId" required>
			</div>
			<div class="center content-margin">
				<span>パスワード：</span> <input type="password" name="password" required>
			</div>
			<input type="submit" value="ログイン">
		</form>
	</div>
</body>
</html>
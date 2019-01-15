<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.css">
<head>
<meta charset="UTF-8">
<title>新規登録</title>
</head>
<body>

	<div class="yellow right header-height">
		<pre>
				<span>${userInfo.name}　さん</span>　　　　<span><a
				href="LogoutServlet">ログアウト</a></span>
			</pre>
	</div>
	<div class="container">
		<c:if test="${errMsg != null }">
			<div class="center">
				<font color="red">${errMsg}</font>
			</div>
		</c:if>
		<h1 class="center top">ユーザー新規登録</h1>
		<form method="post" action="NewUserServlet">
			<div class="row">
				<div class="col-sm-3"></div>
				<div class="col-sm-3">ログインID</div>
				<div class="col-sm-3 content-margin">
					<input type="text" name="loginId" value="${loginId}" required>
				</div>
				<div class="col-sm-3"></div>
				<div class="col-sm-3"></div>
				<div class="col-sm-3">パスワード</div>
				<div class="col-sm-3 content-margin">
					<input type="password" name="password" required>
				</div>
				<div class="col-sm-3"></div>
				<div class="col-sm-3"></div>
				<div class="col-sm-3">パスワード確認</div>
				<div class="col-sm-3 content-margin">
					<input type="password" name="passwordCon" required>
				</div>
				<div class="col-sm-3"></div>
				<div class="col-sm-3"></div>
				<div class="col-sm-3">ユーザー名</div>
				<div class="col-sm-3 content-margin">
					<input type="text" name="name" value="${name}" required>
				</div>
				<div class="col-sm-3"></div>
				<div class="col-sm-3"></div>
				<div class="col-sm-3">生年月日</div>
				<div class="col-sm-3 content-margin">
					<input type="date" name="birthDate" style="width: 178px"value="${birthDate}" required>
				</div>
			</div>
			<p class="center">
				<input type="submit" value="登録">
			</p>

		</form>


		<a href="UserListServlet">戻る</a>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.css">
<meta charset="UTF-8">
<title>ユーザ情報更新</title>
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
		<h1 class="center top">ユーザ情報更新</h1>

		<form method="post" action="UserUpdateServlet">
			<div class="row">
				<div class="col-sm-2 "></div>
				<div class="col-sm-5 content-margin">ログインID</div>
				<div class="col-sm-5 ">${userDetail.loginId}${user.loginId}</div>
				<div class="col-sm-2 "></div>
				<div class="col-sm-5 content-margin">パスワード</div>
				<div class="col-sm-5 ">
					<input type="password" name="password">
				</div>
				<div class="col-sm-2 "></div>
				<div class="col-sm-5 content-margin">パスワード確認</div>
				<div class="col-sm-5 ">
					<input type="password" name="passwordCon">
				</div>
				<div class="col-sm-2 "></div>
				<div class="col-sm-5 content-margin">ユーザ名</div>
				<div class="col-sm-5 ">
					<input type="text" name="name" value="${userDetail.name}${name}"
						required>
				</div>
				<div class="col-sm-2 "></div>
				<div class="col-sm-5 content-margin">生年月日</div>
				<div class="col-sm-5 ">
					<input type="date" name="birthDate" style="width: 178px"
						value="${userDetail.birthDate}${birthDate}" required>
				</div>
				<input type="hidden" name="id" value="${userDetail.id}${id}">
			</div>
			<p class="center">
				<input type="submit" value="更新">
			</p>
			<br>
		</form>
		<a href="UserListServlet">戻る</a>
	</div>
</body>
</html>
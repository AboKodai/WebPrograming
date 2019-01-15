<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.css">
<meta charset="UTF-8">
<title>ユーザ削除確認</title>
</head>
<body>

		<div class="yellow right header-height">
			<pre>
				<span>${userInfo.name}　さん</span>　　　　<span><a href="LogoutServlet">ログアウト</a></span>
			</pre>
		</div>
		<div class="container">
		<h1 class="center top">ユーザ削除確認</h1>
		<p>ログインID：${userDetail.loginId}</p>
		<p>ユーザ名：${userDetail.name}</p>
		<p class="content-margin">を削除しますか？</p>
		<form method="post" action="UserDeleteServlet">
			<span class="space">
				<input type="submit" value="キャンセル"	name="no" style="width: 150px">
			</span>
			<span>
				<input type="submit" value="OK" name="yes" style="width: 150px">
			</span>
			<input type="hidden"name="id"value="${userDetail.id}">
		</form>


	</div>

</body>
</html>
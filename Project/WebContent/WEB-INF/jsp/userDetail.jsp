<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/style.css">
<meta charset="UTF-8">
<title>ユーザ詳細</title>
</head>
<body>
	<div class="yellow right header-height">
		<pre>
				<span>${userInfo.name}　さん</span>　　　　<span><a href="LogoutServlet">ログアウト</a></span>
			</pre>
	</div>
	<div class="container">
		<h1 class="center top">ユーザ情報詳細参照</h1>
		<div class="row top">
			<div class="col-sm-2 "></div>
			<div class="col-sm-5 content-margin">ログインID</div>
			<div class="col-sm-5 ">${userDetail.loginId}</div>
			<div class="col-sm-2 "></div>
			<div class="col-sm-5 content-margin">ユーザ名</div>
			<div class="col-sm-5 ">${userDetail.name}</div>
			<div class="col-sm-2 "></div>
			<div class="col-sm-5 content-margin">生年月日</div>
			<div class="col-sm-5 ">${userDetail.birthDate}</div>
			<div class="col-sm-2 "></div>
			<div class="col-sm-5 content-margin">登録日時</div>
			<div class="col-sm-5 ">${userDetail.createDate}</div>
			<div class="col-sm-2 "></div>
			<div class="col-sm-5 content-margin">更新日時</div>
			<div class="col-sm-5 ">${userDetail.updateDate}</div>
			<div class="col-sm-2 "></div>
			<div class="col-sm-5">
				<a href="UserListServlet">戻る</a>
			</div>
		</div>

	</div>

</body>
</html>
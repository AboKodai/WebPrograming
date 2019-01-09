<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
	<div class="container">
		<div class="yellow right header-height">
			<pre>
				<span>${userInfo.name}　さん</span>　　　　<span><a>ログアウト</a></span>
			</pre>
		</div>

		<h1 class="center top">ユーザ情報詳細参照</h1>
		<div class="row">
			<div class="col-sm-2 "></div>
			<div class="col-sm-5 content-margin">ログインID</div>
			<div class="col-sm-5 ">${userDetail.loginId}</div>
			<div class="col-sm-2 "></div>
			<div class="col-sm-5 content-margin">ユーザ名</div>
			<div class="col-sm-5 ">${userDetail.name}</div>
			<div class="col-sm-2 "></div>
			<div class="col-sm-5 content-margin">生年月日</div>
			<div class="col-sm-5 ">1989年04月26日</div>
			<div class="col-sm-2 "></div>
			<div class="col-sm-5 content-margin">登録日時</div>
			<div class="col-sm-5 ">2017年01月01日 10:50</div>
			<div class="col-sm-2 "></div>
			<div class="col-sm-5 content-margin">更新日時</div>
			<div class="col-sm-5 ">2017年02月01日01:05</div>
			<div class="col-sm-2 "></div>
			<div class="col-sm-5">
				<a>戻る</a>
			</div>
		</div>

	</div>

</body>
</html>
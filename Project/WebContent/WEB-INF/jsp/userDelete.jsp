<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="bootstrap.css">
<meta charset="UTF-8">
<title>ユーザ削除確認</title>
</head>
<body>
	<div class="container">
		<div class="yellow right header-height">
			<pre>
				<span>${userInfo.name}　さん</span>　　　　<span><a>ログアウト</a></span>
			</pre>
		</div>
		<h1 class="center top">ユーザ削除確認</h1>
		<p>ログインID：id0001</p>
		<p class="content-margin">を本当に削除してよろしいですか。</p>
		<form>
			<span class="space"><input type="submit" value="キャンセル"
				name="no" style="width: 150px"></span> <span><input
				type="submit" value="OK" name="yes" style="width: 150px"></span>
		</form>



	</div>

</body>
</html>
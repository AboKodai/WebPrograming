<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.css">
<meta charset="UTF-8">
<title>ユーザ一覧</title>

</head>
<body>

	<!-- header -->

	<div class="yellow right header-height">
		<pre>
				<span>${userInfo.name}　さん</span>　　　　<span><a
				href="LogoutServlet">ログアウト</a></span>
			</pre>
	</div>
	<!-- /header -->

	<!-- body -->
	<div class="container">
		<h1 class="center top">ユーザ一覧</h1>
		<p class="right top">
			<a href="NewUserServlet">新規登録</a>
		</p>
		<div>
			<form method="post" action="#">
				<pre class="content-margin center">
	ログインID：	<input type="text" name="loginId" style="width: 250px"><br>
	ユーザ名： 	<input type="text" name="name" style="width: 250px"><br>
	生年月日：	<input type="date" name="birthDateMin" style="width: 105px">　～　<input
						type="date" name="birthDateMax" style="width: 105px">
	</pre>
				<p class="right">
					<input type="submit" value="検索" style="width: 100px">
				</p>
			</form>
		</div>
		<hr size="5" color="black">
		<table border="1" class="auto-mgn">
			<thead>
				<tr>
					<th width="150px">ログインID</th>
					<th width="150px">ユーザ名</th>
					<th width="150px">生年月日</th>
					<th></th>
				</tr>
			</thead>
			<tbody>

				<c:if test="${userList != null}">
					<c:forEach var="user" items="${userList}">
						<tr>
							<td>${user.loginId }</td>
							<td>${user.name }</td>
							<td>${user.birthDate }</td>
							<td><a href="UserDetailServlet?id=${user.id}"><button
										type="submit" class="dt-btn btn-mgn">詳細</button></a> <a
								href="UserUpdateServlet?id=${user.id}"><button type="submit"
										class="ud-btn btn-mgn">更新</button></a> <a
								href="UserDeleteServlet?id=${user.id}"><button type="submit"
										class="dl-btn btn-mgn">削除</button></a></td>
						</tr>
					</c:forEach>
				</c:if>

				<c:if test="${userList2 != null}">
					<c:forEach var="user" items="${userList2}">
						<tr>
							<td>${user.loginId }</td>
							<td>${user.name }</td>
							<td>${user.birthDate }</td>
							<c:if test="${user.loginId == userInfo.loginId}">
								<td><a href="UserDetailServlet?id=${user.id}"><button
											type="submit" class="dt-btn btn-mgn">詳細</button></a> <a
									href="UserUpdateServlet?id=${user.id}"><button
											type="submit" class="ud-btn btn-mgn">更新</button></a>
							</c:if>

							<c:if test="${user.loginId != userInfo.loginId}">
								<td class="text-left"><a
									href="UserDetailServlet?id=${user.id}"><button
											type="submit" class="dt-btn btn-mgn">詳細</button></a>
							</c:if>
						</tr>

					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>

</body>
</html>
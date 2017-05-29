<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
body {
	background-color: #006060;
	min-height: 100%;
	padding-top: 70px;
	min-height: 100%;
	padding-top: 70px;
}
</style>
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
		<div class="navbar-header navbar-left">
			<a class="navbar-brand" href="MainMenu.jsp">B'z Project</a>
		</div>
		<!--/.nav-collapse -->
		<div id="navbar" class="navbar-collapse collapse navbar-left">
			<div class="btn-group">
				<form action="Bz" method="post">
					<div class="btn-group">
						<button type="submit" class="btn navbar-btn active"
							name="ACTION" value="お客様情報登録">
							<span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;お客様情報登録
						</button>
						<button type="submit" class="btn navbar-btn" name="ACTION"
							value="卓管理">
							<span class="glyphicon glyphicon-unchecked" aria-hidden="true"></span>&nbsp;卓管理
						</button>
						<button type="submit" class="btn navbar-btn" name="ACTION"
							value="カード管理">
							<span class="glyphicon glyphicon-inbox" aria-hidden="true"></span>&nbsp;カード管理
						</button>
						<button type="submit" class="btn navbar-btn" name="ACTION"
							value="経費">
							<span class="glyphicon glyphicon-usd" aria-hidden="true"></span>&nbsp;経費
						</button>
						<button type="submit" class="btn navbar-btn" name="ACTION"
							value="情報参照">
							<span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>&nbsp;情報参照
						</button>
					</div>
				</form>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	<h1 align="center">
		<FONT color="red">ビ</FONT><font color="green">ー</font><font
			color="blue">ズ</font>System
	</h1>
	<h2 align="center">情報登録</h2>

	<hr>
	<div class="container">
		<form action="DB" method="post">
			<div class="form-group">
				<table class="table" border="3" align="center">
					<tr>
						<td align="center"><font color="white">名前</font></td>
						<td align="center"><input type="text" class="form-control"
							name="name"></td>
					</tr>
					<tr>
						<td align="center"><font color="white">ふりがな</font></td>
						<td align="center"><input type="text" class="form-control"
							name="kanaName"></td>
					</tr>
					<tr>
						<td align="center"><font color="white">種別</font></td>
						<td align="center"><input type="radio" name="mg" value="1"
							checked="checked"><font color="white">お客様&nbsp;&nbsp;</font><br> <input
							type="radio" name="mg" value="0"><font color="white">メンバー</font></td>
					</tr>
					<tr>
						<td align="center"></td>
						<td align="right"><input type="submit"
							class="btn btn-primary" name="ACTION" value="登録"></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
	<hr>

	<form action="Bz" method="post">
		<div class="form-group">
			<div align="center">
				<input type="submit" class="btn btn-primary" name="ACTION"
					value="メニューに戻る">
			</div>
		</div>
	</form>
</body>
</html>
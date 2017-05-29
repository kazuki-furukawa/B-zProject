<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main Menu</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
body {
	background-color: #006060;
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
						<button type="submit" class="btn navbar-btn" name="ACTION"
							value="お客様情報登録">
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
						<button type="submit" class="btn navbar-btn active" name="ACTION"
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
	<h2 align="center">みんなの成績</h2>

	<hr>

	<%
	String x1[] = (String[])session.getAttribute("rankname");
	String x2[] = (String[])session.getAttribute("seiseki");
	%>

	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3">
				<div align="center" style="color:white;">
					トップ回数ランキング
				</div>
				<table class="table table-bordered" style="color:white;">
				<tr>
					<td>1位</td><td><%=x1[0] %></td><td><%=x2[0] %></td>
				</tr>
				<tr>
					<td>2位</td><td><%=x1[1] %></td><td><%=x2[1] %></td>
				</tr>
				<tr>
					<td>3位</td><td><%=x1[2] %></td><td><%=x2[2] %></td>
				</tr>
				</table>
			</div>

		</div>
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
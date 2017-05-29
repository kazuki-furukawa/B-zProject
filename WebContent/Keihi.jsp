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
						<button type="submit" class="btn navbar-btn active" name="ACTION"
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
	<h2 align="center">経費入力</h2>

	<hr>
	<div class="container">
		<div class="row">
			<div align="center">
				<br> <br>
				<h4>
					<font color="white">使った経費の金額を入れてください</font>
				</h4>
				<form action="DB" method="post" class="form-inline">
					<div class="form-group">
						<select name="amount_man" class="form-control">
							<%
								for (int i = 0; i < 10; i++) {
							%>

							<option value="<%=i%>"><%=i%></option>
							<%
								}
							%>
						</select> &nbsp;万&nbsp; <select name="amount_senn" class="form-control">
							<%
								for (int i = 0; i < 9; i++) {
							%>

							<option value="<%=i%>"><%=i%></option>
							<%
								}
							%>
						</select> &nbsp;千&nbsp; <select name="amount_hyaku" class="form-control">
							<%
								for (int i = 0; i < 9; i++) {
							%>

							<option value="<%=i%>"><%=i%></option>
							<%
								}
							%>
						</select> &nbsp;百&nbsp;円 <br> <br> <input type="submit"
							class="btn btn-primary" name="ACTION" value="経費使用">
					</div>
				</form>
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
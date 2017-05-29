<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Main Menu</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/mycss.css" rel="stylesheet">
<style type="text/css">
body {
	background-color: #006060; min-height: 100%; padding-top: 70px;
	min-height: 100%;
	padding-top: 50px;
}

header.jumbotron {
	background-image: url("img/image1.JPG");
	background-position: center center;
	background-size: cover;
	height: 340px;
	color: #fff;
	filter: blur(5px);
}

header .container-fluid {
	margin-top: 0;
}

header .midashi-btn {
	border: 1px solid #fff;
	color: #fff;
	border-radius: 0;
}

header .midashi-btn:hover {
	color: #0089ff;
	border-color: #0089ff;
}

.navbar-form {
	padding-right: 30px;
}

h1 {
	background-color: #000000;
	margin-top: 40px;
	margin-bottom: 0;
	width: 100%;
}

p {
	background-color: #000000;
	margin-top: 0;
	width: 100%;
}

section {
	overflow: hidden;
}
</style>
</head>
<body>
	<!-- Fixed navbar -->
	<nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
		<div class="navbar-header navbar-left">
			<a class="navbar-brand" href="#">B'z Project</a>
		</div>
		<!--/.nav-collapse -->
		<div id="navbar" class="navbar-collapse collapse navbar-left">
			<div class="btn-group">
				<form action="Bz" method="post">
					<div class="btn-group">
						<button type="submit" class="btn navbar-btn"
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
	<header class="jumbotron hidden-xs">
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-5"></div>
				<div class="col-sm-7 col-xs-12">
				<div class="row">
					<h1 class="animation1">
						<FONT color="red" class="animation2" id="in">B</FONT><font color="green"  class="animation2" id="in">'</font><font
							color="blue" class="animation2" id="in">z</font><font color="#ffffff">System</font>
					</h1>
					<p class="animation1">
					&nbsp;&nbsp;&nbsp;ビーズの、ビーズによる、ビーズのためのシステム。それがビーズシステムです。<br>
					&nbsp;&nbsp;&nbsp;このシステムは、業務に関する情報を見やすく、的確に処理するために趣味で<br>
					&nbsp;&nbsp;&nbsp;開発されました。<br>
					&nbsp;&nbsp;&nbsp;随時アップデート予定です！お楽しみに！
					</p>
					</div>
				</div>
			</div>
		</div>
	</header>
<br>
	<div class="container-fluid">
		<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">
			<fieldset>
				<legend><font color="white">機能一覧</font></legend>
				<div align="center">
				<table>
					<tr>
						<td class="">
							<form action="Bz" method="post">
								<div class="form-group">
									<input type="submit" class="btn btn-primary btn btn-lg btn-block"
										name="ACTION" value="お客様情報登録">
								</div>
							</form>
						</td>
						<td class="hidden-xs"><font color="white">&nbsp;&nbsp;お客様と従業員の情報を新規登録します。</font></td>
					</tr>
					<tr>
						<td align="center">
							<form action="Bz" method="post">
								<div class="form-group">
									<input type="submit" class="btn btn-primary btn btn-lg btn-block"
										name="ACTION" value="卓管理">
								</div>
							</form>
						</td>
						<td class="hidden-xs"><font color="white">&nbsp;&nbsp;卓の使用状況を管理します。</font></td>
					</tr>
					<tr>
						<td align="center">
							<form action="Bz" method="post">
								<div class="form-group">
									<input type="submit" class="btn btn-primary btn btn-lg btn-block"
										name="ACTION" value="カード管理">
								</div>
							</form>
						</td>
						<td class="hidden-xs"><font color="white">&nbsp;&nbsp;カードの買入れ、アウト、清算・入金を管理します。</font></td>
					</tr>
					<tr>
						<td align="center">
							<form action="Bz" method="post">
								<div class="form-group">
									<input type="submit" class="btn btn-primary btn btn-lg btn-block"
										name="ACTION" value="経費">
								</div>
							</form>
						</td>
						<td class="hidden-xs"><font color="white">&nbsp;&nbsp;経費と売上収得に関して管理します。</font></td>
					</tr>
					<tr>
						<td align="center">
							<form action="DB" method="post">
								<div class="form-group">
									<input type="submit" class="btn btn-primary btn btn-lg btn-block"
										name="ACTION" value="役満">
								</div>
							</form>
						</td>
						<td class="hidden-xs"><font color="white">&nbsp;&nbsp;役満が出た場合、ここから登録します。</font></td>
					</tr>
					<tr>
						<td align="center">
							<form action="Bz" method="post">
								<div class="form-group">
									<input type="submit" class="btn btn-primary btn btn-lg btn-block"
										name="ACTION" value="情報参照">
								</div>
							</form>
						</td>
						<td class="hidden-xs"><font color="white">&nbsp;&nbsp;様々な情報を参照します。</font></td>
					</tr>
				</table>
				</div>
			</fieldset>
			</div>
		</div>
	</div>

	<footer class="footer">
		<div class="container-fluid">
		<div class="row">
			<div align="center">
				<p class="text-muted">Created by Kazuki Furukawa</p>
			</div>
			</div>
		</div>
	</footer>

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>
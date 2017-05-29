<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title><link href="css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">body {background-color: #006060; min-height: 100%; padding-top: 70px;}</style></head>
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
						<button type="submit" class="btn navbar-btn"
							name="ACTION" value="お客様情報登録">
							<span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;お客様情報登録
						</button>
						<button type="submit" class="btn navbar-btn active" name="ACTION"
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
<FONT color="red">ビ</FONT><font color="green">ー</font><font color="blue">ズ</font>System
</h1>
<h2 align="center">
卓&nbsp;選択画面
</h2>
<hr>
<div class="container">


<br>
<form action="DB" method="post"> <div class="form-group">
<div align="center">
<h4><font color="white">管理したい卓を選択してください。</font></h4>
 <table class="table"  border="3">
<tr>
<td align="center">
<input type="submit" class="btn btn-primary btn-lg btn-block" name="ACTION" value="1">
</td>
<td align="center">
<input type="submit" class="btn btn-primary btn-lg btn-block" name="ACTION" value="2">
</td>
</tr>
<tr>
<td align="center">
<input type="submit" class="btn btn-primary btn-lg btn-block" name="ACTION" value="3">
</td>
<td align="center">
<input type="submit" class="btn btn-primary btn-lg btn-block" name="ACTION" value="4">
</td>
</tr>
<tr>
<td align="center">
<input type="submit" class="btn btn-primary btn-lg btn-block" name="ACTION" value="5">
</td>
</tr>
</table>

</div>
</div></form>
</div>
<hr>
<form action="Bz" method="post"> <div class="form-group">
<div align="center">
<input type="submit" class="btn btn-primary" name="ACTION" value="メニューに戻る">
</div>
</div></form>


</body>
</html>
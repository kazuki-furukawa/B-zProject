<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.entity.GuestBean"%>
<%@ page import="model.entity.TableBean"%>
<%@ page import="java.util.ArrayList"%>
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
						<button type="submit" class="btn navbar-btn" name="ACTION"
							value="情報参照">
							<span class="glyphicon glyphicon-info-sign active"
								aria-hidden="true"></span>&nbsp;情報参照
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
	<h2 align="center">アウト</h2>
	<hr>
	<br>
	<br>
	<div class="container">
		<h4>
			<font color="white">出金をした人と金額を入れてください</font>
		</h4>
		<form action="DB" method="post" class="form-inline">
			<div class="form-group">
				<div class="container" align="center">
					<%
						ArrayList<GuestBean> member = (ArrayList)session.getAttribute("member"+session.getAttribute("tableNum"));
					%>
					<select name="guest" class="form-control">
						<%
							Object o = session.getAttribute("id");
						String os = o.toString();
						int id = new Integer(os);
						String name = new String();
						for(int i=0;i<member.size();i++){
						if(member.get(i).getId()==id){
							name = member.get(i).getName();
						}
						%>
						<option value="<%=member.get(i).getId()%>"><%=member.get(i).getName()%></option>
						<%
							}
						%>
					</select> <input type="submit" class="btn btn-primary" name="ACTION"
						value="アウト情報表示"> <br> <br>
					<font color="white"><%=name%>さんのアウト情報 </font>
					<br>
					<%
						String html = (String)session.getAttribute("html");
					%>
					<%=html%>
					<%

					%>

				</div>
			</div>
		</form>
		<br> <br>
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
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
						<button type="submit" class="btn navbar-btn active" name="ACTION"
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
	<h2 align="center">精算/入金</h2>
	<hr>
	<div class="container">
		<div class="row">
			<br> <br>
			<h4>
				<font color="white">精算合計額と入金額を入れてください</font>
			</h4>
			<div align="center">
				<form action="DB" method="post" class="form-inline">
					<div class="form-group">

						<%
							ArrayList<GuestBean> member = (ArrayList)session.getAttribute("member"+session.getAttribute("tableNum"));
						%>
						<table class="table" border="3">
							<tr>
								<td align="center"><select name="guest">
										<%
											for(int i=0;i<member.size();i++){
										%>
										<option value="<%=member.get(i).getId()%>"><%=member.get(i).getName()%></option>
										<%
											}
										%>
								</select></td>
								<td align="center"><font color="white"> 清算合計 </font></td>
								<td align="center"><select name="amount_man_s"
									class="form-control">
										<%
											for(int i=0; i<11;i++){
										%>

										<option value="<%=i%>"><%=i%></option>
										<%
											}
										%>
								</select> &nbsp;万&nbsp; <select name="amount_senn_s" class="form-control">
										<%
											for(int i=0; i<9;i++){
										%>

										<option value="<%=i%>"><%=i%></option>
										<%
											}
										%>
								</select> &nbsp;千&nbsp; <select name="amount_hyaku_s"
									class="form-control">
										<%
											for(int i=0; i<9;i++){
										%>

										<option value="<%=i%>"><%=i%></option>
										<%
											}
										%>
								</select> &nbsp;百&nbsp;円</td>
							</tr>
							<tr>
								<td align="center"></td>
								<td align="center"><font color="white"> 入金 </font></td>
								<td align="center"><select name="amount_man_n"
									class="form-control">
										<%
											for(int i=0;i<10;i++){
										%>

										<option value="<%=i%>"><%=i%></option>
										<%
											}
										%>
								</select> &nbsp;万&nbsp; <select name="amount_senn_n" class="form-control">
										<%
											for(int i=0; i<9;i++){
										%>

										<option value="<%=i%>"><%=i%></option>
										<%
											}
										%>
								</select> &nbsp;千&nbsp; <select name="amount_hyaku_n"
									class="form-control">
										<%
											for(int i=0; i<9;i++){
										%>

										<option value="<%=i%>"><%=i%></option>
										<%
											}
										%>
								</select> &nbsp;百&nbsp;円</td>
							</tr>
						</table>

						<br> <input type="submit" class="btn btn-primary"
							name="ACTION" value="精算・入金">

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
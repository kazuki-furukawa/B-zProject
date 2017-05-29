<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.entity.TableBean" %>
    <%@ page import="java.util.ArrayList" %>
       <%@ page import="model.entity.GuestBean" %>
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
<font color="white">
<%=session.getAttribute("tableNum") %>番卓&nbsp;状況
</font>
</h2>
<hr>
<form action="DB" method="post"> <div class="form-group">
<div align="center">
<%

TableBean tb = (TableBean)session.getAttribute("Table"+session.getAttribute("tableNum"));
ArrayList<GuestBean> member = (ArrayList)session.getAttribute("member"+session.getAttribute("tableNum"));
for(GuestBean gb : member){
	if(gb.getId() == tb.getEast()){
%>
<font color="white">
<%=gb.getName() %>　さん
</font>
<% }} %>
<br>
★★★★<font color="white">東</font>★★★★<br>
★★★★★★★★★<br>
★★★★★★★★★<br>
<%
for(GuestBean gb : member){
	if(gb.getId() == tb.getSouth()){
%>
<font color="white">
<%=gb.getName() %>　さん
</font>
<% }} %>
★★★
<%
for(GuestBean gb : member){
	if(gb.getId() == tb.getNorth()){
%>
<font color="white">
<%=gb.getName() %>　さん
</font>
<% }} %>
<br>
★★★★★★★★★<br>
★★★★★★★★★<br>
★★★★★★★★★<br>
<%
for(GuestBean gb : member){
	if(gb.getId() == tb.getWest()){
%>
<font color="white">
<%=gb.getName() %>　さん
</font>
<% }} %>
<br><br>
<font color="white">
ゲーム中！
</font>
<br><br>
<input type="submit" class="btn btn-primary" name="ACTION" value="ラスト！">
<input type="submit" class="btn btn-primary" name="ACTION" value="ゲーム中止">
<br>
</div>
</div></form>

<hr>

<form action="Bz" method="post"> <div class="form-group">
<div align="center">
<input type="submit" class="btn btn-primary" name="ACTION" value="メニューに戻る">
</div>
</div></form>
</body>
</html>
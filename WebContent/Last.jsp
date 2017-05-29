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
<h1 align="center">
<FONT color="red">ビ</FONT><font color="green">ー</font><font color="blue">ズ</font>System
</h1>
<h2 align="center">
順位登録
</h2>

<hr>

<div class="container" align="center">

<br>
<h4><font color="white">順位を選択してください。</font></h4>
<br>
<%

TableBean tb = (TableBean)session.getAttribute("Table"+session.getAttribute("tableNum"));
ArrayList<GuestBean> member = (ArrayList)session.getAttribute("member"+session.getAttribute("tableNum"));

%>

<form action="DB" method="post"> <div class="form-group">
 <table class="table"  border="3" align="center">
<tr>
<td align="center">
<font color="white">
名前
</font>
</td>
<td align="center">
<font color="white">
トップ
</font>
</td>
<td align="center">
<font color="white">
ラス
</font>
</td>
</tr>
<tr>
<%
for(GuestBean gb : member){
	if(gb.getId() == tb.getEast()){
%>
<td align="center">
<font color="white">
<%=gb.getName() %>
</font>
</td>
<td align="center">
<input type="radio" name="top" checked="checked" value=<%=gb.getId()%>>
</td>
<td align="center">
<input type="radio" name="las" checked="checked" value=<%=gb.getId()%>>
</td>
<% }} %>
</tr>
<tr>
<%
for(GuestBean gb : member){
	if(gb.getId() == tb.getSouth()){
%>
<td align="center">
<font color="white">
<%=gb.getName() %>
</font>
</td>
<td align="center">
<input type="radio" name="top" value=<%=gb.getId()%>>
</td>
<td align="center">
<input type="radio" name="las" value=<%=gb.getId()%>>
</td>
<% }} %>
</tr>
<tr>
<%
for(GuestBean gb : member){
	if(gb.getId() == tb.getWest()){
%>
<td align="center">
<font color="white">
<%=gb.getName() %>
</font>
</td>
<td align="center">
<input type="radio" name="top" value=<%=gb.getId()%>>
</td>
<td align="center">
<input type="radio" name="las" value=<%=gb.getId()%>>
</td>
<% }} %>
</tr>
<tr>
<%
for(GuestBean gb : member){
	if(gb.getId() == tb.getNorth()){
%>
<td align="center">
<font color="white">
<%=gb.getName() %>
</font>
</td>
<td align="center">
<input type="radio" name="top" value=<%=gb.getId()%>>
</td>
<td align="center">
<input type="radio" name="las" value=<%=gb.getId()%>>
</td>
<% }} %>
</tr>
</table>
<input type="submit" class="btn btn-primary" name="ACTION" value="続行">&nbsp;&nbsp;<input type="submit" class="btn btn-primary" name="ACTION" value="卓割れ">
</div></form>
</div>
</body>
</html>
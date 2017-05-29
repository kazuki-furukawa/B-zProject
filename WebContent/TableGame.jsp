<%@page import="model.entity.TableBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.entity.GuestBean" %>
<%@ page import="model.entity.TableBean" %>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery.min.js"></script>
<script src="js/select2.min.js"></script>
<title>Insert title here</title><link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/select2.css" rel="stylesheet">
<style type="text/css">
body {background-color: #006060; min-height: 100%; padding-top: 70px;}
select{width:150px;}
</style>
<script type="text/javascript">
$(function(){
    $('select').select2();
});
</script>
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

ArrayList<GuestBean> member = (ArrayList)session.getAttribute("member"+session.getAttribute("tableNum"));

%>
<select name="guestEast" class="select">
<%

for(int i=0;i<member.size();i++){

%>
<option value="<%=member.get(i).getId() %>"><%=member.get(i).getName() %></option>
<%

}

%>
</select>
さん
<br>
★★★★<font color="white">東</font>★★★★<br>
★★★★★★★★★<br>
★★★★★★★★★<br>
<select name="guestSouth">
<%

for(int i=0;i<member.size();i++){

%>
<option value="<%=member.get(i).getId() %>"><%=member.get(i).getName() %></option>
<%

}

%>
</select>
さん
★★★
<select name="guestNorth">
<%

for(int i=0;i<member.size();i++){

%>
<option value="<%=member.get(i).getId() %>"><%=member.get(i).getName() %></option>
<%

}

%>
</select>
さん
<br>
★★★★★★★★★<br>
★★★★★★★★★<br>
★★★★★★★★★<br>
<select name="guestWest">
<%

for(int i=0;i<member.size();i++){

%>
<option value="<%=member.get(i).getId() %>"><%=member.get(i).getName() %></option>
<%

}

%>
</select>
さん
<br><br>


<font color="white">準備中...</font>
<br><br>
<input type="submit" class="btn btn-primary" name="ACTION" value="スタート！">
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
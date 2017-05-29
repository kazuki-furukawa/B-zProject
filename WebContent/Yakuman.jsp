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
<title>役満</title><link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/select2.css" rel="stylesheet">
<style type="text/css">body {background-color: #006060; min-height: 100%; padding-top: 70px;}</style>
<script type="text/javascript">
$(function(){
    $('.form-control').select2();
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
<FONT color="red">ビ</FONT><font color="green">ー</font><font color="blue">ズ</font> System
</h1>
<h2 align="center">
役満
</h2>
<hr>
<div class="container">
<br><br>
<h4><font color="white">役満をだした人と種類を入れてください。</font></h4>
<form action="DB" method="post"> <div class="form-group">
<div align="center">
<%

ArrayList<GuestBean> member = (ArrayList)session.getAttribute("member"+session.getAttribute("tableNum"));

%>
 <table class="table"  border="3" >
<tr>
<td align="center">
<select name="guest" class="form-control">
<%

for(int i=0;i<member.size();i++){

%>
<option value="<%=member.get(i).getId() %>"><%=member.get(i).getName() %></option>
<%

}

%>
</select>
</td>
<td align="center">
<select name="yaku" class="form-control">
<option value="四暗刻">四暗刻</option>
<option value="国士無双">国士無双</option>
<option value="大三元">大三元</option>
<option value="緑一色">緑一色</option>
<option value="清老頭">清老頭</option>
<option value="四槓子">四槓子</option>
<option value="天和">天和</option>
<option value="地和">地和</option>
<option value="九蓮宝燈">九蓮宝燈</option>
<option value="小四喜/大四喜">小四喜/大四喜</option>
<option value="字一色">字一色</option>
</select>
</td>
</tr>
</table>
<br>
<input type="submit" class="btn btn-primary" name="ACTION" value="祝儀">
</div>
</div></form>
<br>
</div>

<hr>

<form action="Bz" method="post"> <div class="form-group">
<div align="center">
<input type="submit" class="btn btn-primary" name="ACTION" value="メニューに戻る">
</div>
</div></form>
</body>
</html>

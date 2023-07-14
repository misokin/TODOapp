<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/input.css">
<link rel="shortcut icon" href="images/favicon.ico">
<link rel ="stylesheet" href="./css/style.css">

<title>TODOアプリ入力画面</title>
<c:if test="${not empty errorMsg1}">
<p class="error"><c:out value ="${errorMsg3}"/></p>
<p class="error"><c:out value ="${errorMsg4}"/></p>
</c:if>
</head>


<body>
<h1>TODOアプリケーション</h1>
<h2>TODO入力</h2>

<form action="InputServlet" method="post">
重要度：<select name = "priority">
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
</select><br>
内容：<input type = "text" name="content"><br>
期日：<input type = "date" name= "deadline" ><br>
	<input type = "submit" value = "登録">
</form>
</body>
</html>
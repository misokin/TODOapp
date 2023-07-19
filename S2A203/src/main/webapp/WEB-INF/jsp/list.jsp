<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="images/listfavicon.ico">
<title>TODOアプリ出力画面</title>
<style>

.logout{
floatr:ight: 
}
</style>
</head>
<body>
<a href = "LogoutServlet" class = "logout">ログアウト</a>
<h1>TODOアプリケーション</h1>
<h2>${loginUser.name}のTODOリスト</h2>
<p class="error">${errorMsg}</p>
<table border=1>
<tr><th>No</th><th>重要度</th><th>内容</th><th>期日</th></tr>
<th>${todo.priority}</th>
<th>${todo.content}</th>
<th>${todo.deadline}</th>
</tr>
<c:forEach var="todo" items ="${todoList}" varStatus="status">
<tr>
<td>${status.count}</td><td>${todo.priority }</td><td>${todo.content}</td><td>${todo.deadline}
</td></tr>
</c:forEach>
</table><br>
<form action = "UpdateServlet" method="post">
変更no:<select name= "no">
<option value="0">1</option>
<option value="1">2</option>
<option value="2">3</option>
<option value="3">4</option>
</select>
重要度：<select name = "priority">
<option value="5">5</option>
<option value="4">4</option>
<option value="3">3</option>
<option value="2">2</option>
<option value="1">1</option>
</select>
内容：<input type = "text" name="content">
期日：<input type = "date" name= "deadline" >
<input type="submit" value="変更">
</form>
<form action = "RemoveServlet" method="post">
削除no:<select name= "no">
<option value ="0">1</option>
<option value ="1">2</option>
<option value ="2">3</option>
<option value ="3">4</option>
<option value ="4">5</option>
<input type="submit" value="削除">
</select>
</form>

<form action="InputServlet" method="get">
<input type="submit" value="戻る">
</form>
</body>
</html>
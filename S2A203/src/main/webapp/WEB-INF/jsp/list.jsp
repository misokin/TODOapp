<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="images/listfavicon.ico">
<title>TODOアプリ出力画面</title>
</head>
<body>
<h1>TODOアプリケーション</h1>
<h2>${loginUser.name}のTODOリスト</h2>
<table border=1>
<tr><th>No</th><th>重要度</th><th>内容</th><th>期日</th></tr>
<tr><th>1</th>
<th>${todo.priority}</th>
<th>${todo.content}</th>
<th>${todo.deadline}</th>
</tr>
</table>
<form action = "UpdateServlet" method="post">
変更no:<select name= "no">
<option value="0">1</option>
<option value="1">2</option>
<option value="2">3</option>
<option value="3">4</option>
</select>
重要度：<select name = "priority">
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
</select>
内容：<input type = "text" name="content">
期日：<input type = "date" name= "deadline" >


</form>
<a href="javascript:history.back();">戻る</a>
</body>
</html>
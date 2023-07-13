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
<h2>${login.Username}のTODOリスト</h2>
<h1>DoPost</h1>
<table border=1>
<tr><th>No</th><th>重要度</th><th>内容</th><th>期日</th></tr>
<tr><th>1</th>
<th>${todo.priority}</th>
<th>${todo.content}</th>
<th>${todo.deadline}</th>
</tr>

</table>
<a href="javascript:history.back();">戻る</a>
</body>
</html>
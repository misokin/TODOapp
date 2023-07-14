<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<title>TODOアプリログイン</title>
<link rel ="stylesheet" href="./css/style.css">
<link rel="shortcut icon" href="images/favicon.ico">
</head>
<body>
<h1>TODOアプリケーション</h1>
<h2>ログイン</h2>
<c:if test="${not empty errorMsg1}">
<p class="error"><c:out value ="${errorMsg1}"/></p>
<p class="error"><c:out value ="${errorMsg2}"/></p>
</c:if>
<form action="/S2A203/LoginServlet" method="post">
ユーザー名：<input type="text" name="name"><br>
パスワード：<input type="password" name="pass"><br>
<input type="submit" value="ログイン">
</form>
</body>
</html>
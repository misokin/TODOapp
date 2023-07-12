<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.util.Date,java.text.SimpleDateFormat, java.util.Random" %>
    
  <%  
  		String[] todoList = { "Linuxテスト対策", "paiza", "TODOアプリ作成", "履歴書作成" };
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
		String today = sdf.format(date);
		
		%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TODOアプリ出力画面</title>
</head>
<body>
<h1>TODOアプリケーション</h1>
<h2>一宮佑輔のTODOリスト</h2>

<table border=1>
<tr><th>No</th><th>重要度</th><th>内容</th><th>期日</th></tr>
<%for (int i = 1; i<11;i++){ 
	int index = new Random().nextInt(4);
	int important = index + 1;
	
	String todo = todoList[index];
%>
<tr><td><%= i %></td><td><%=important %></td><td><%=todo %></td><td><%=today %></td></tr>
<% 
}
%>
</table>
</body>
</html>
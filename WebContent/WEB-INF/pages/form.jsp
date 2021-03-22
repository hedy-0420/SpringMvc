<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form</title>
</head>
<body>
<h2>Form</h2>
<form action="hello.controller" method="get">
<table>
	<tr>
		<td>Name:
		<td><input type="text" name="username">
		<td>${errors.reply}
	</tr>
	<tr>
		<td><input type="submit" value="send">
	</tr>
</table>
</form>


</body>
</html>
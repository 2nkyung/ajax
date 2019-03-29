<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<form method="post" action="/user">
<table border="1">

<tr>
<th> 이름 </th>
<td><input type="text" name="ui_name" id="ui_name">
</tr>

<tr>
<th> 아이디</th>
<td><input type="text" name="ui_id" id="ui_id">
</tr>

<tr>
<th> 비밀번호</th>
<td><input type="password" name="ui_pwd" id="ui_pwd">
</tr>

<tr>
<th> 이메일</th>
<td><input type="text" name="ui_email" id="ui_email">
</tr>
<tr>
<td colspan="2">
<button> 회원가입 </button>
</td>
</tr>
</table>
<input type="hidden" name="cmd" value="insert">
</form>
</body>
</html>
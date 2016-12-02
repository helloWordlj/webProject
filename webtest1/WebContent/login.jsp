<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/j_spring_security_check" method="post">
<table style="width:60%'">
<tr>
	<td>userName：</td>
	<td><input type="text" name="j_username"></td>
</tr>
<tr>
	<td>userPass：</td>
	<td><input type="text" name="j_password"></td>
</tr>
<tr>
	<td colspan="2">
	<%if(request.getParameter("error")!=null){%>
   		<span style="color:red;float:left">用户名或密码错误</span>
   	<%}%>
	</td>
</tr>
<tr>
	<td><input type="submit" value="Submit"></td>
	<td></td>
</tr>
</table>
</form>
</body>
</html>
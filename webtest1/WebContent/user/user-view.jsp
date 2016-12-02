<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<form id="fid" action="#" method="post">
	<table class="table-1">
		<tr>
            <th width="15%">用户名称</th>
            <td width="35%"><c:out value="${user.userName}"></c:out></td>
            <th width="15%">用户性别</th>
            <td width="35%"><c:out value="${user.userSex}"></c:out></td>
        </tr>
        <tr>
            <th width="15%">用户年龄</th>
            <td width="35%"><c:out value="${user.userAge}"></c:out></td>
            <th width="15%">用户手机</th>
            <td width="35%"><c:out value="${user.userTel}"></c:out></td>
        </tr>        
        <tr>
            <th width="15%">用户QQ</th>
            <td width="35%"><c:out value="${user.userQq}"></c:out></td>
            <th width="15%">用户邮箱</th>
            <td width="35%"><c:out value="${user.userEmail}"></c:out></td>
        </tr>
        
        <tr>
            <th width="15%">用户地址</th>
            <td width="35%"><c:out value="${user.userAddress}"></c:out></td>
            <th width="15%">用户身份证</th>
            <td width="35%"><c:out value="${user.userIdCard}"></c:out></td>
        </tr>
       
		<tfoot><tr align="center">
			<td colspan="4">
				<a href="#" class="easyui-linkbutton" onclick="closeWindow()">返回</a>
			</td>
		</tr>
		</tfoot>
	</table>
		</form>
</body>
</html>
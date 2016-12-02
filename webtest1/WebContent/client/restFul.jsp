<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="../../resources/public.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" >
	$(function(){
		$("#hrefClick").click(function(){
			$.post("str",null,function(r){
				alert(JSON.stringify(r));
			})
		})
	})
</script>
</head>
<body>
<h1>test restFul</h1><br>
<a href="javascript:void(0)" id="hrefClick">--getStr--</a>
</body>
</html>
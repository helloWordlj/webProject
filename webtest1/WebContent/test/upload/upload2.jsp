<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/test/source/jquery.html5uploader.css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/test/source/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/test/source/jquery.html5uploader.js"></script>
<style type="text/css">
</style>
<script type="text/javascript">
$(function(){
	$('#upload').html5uploader({
		auto:false,
		multi:true,
		removeTimeout:1000,
		url:'upload5',
		fileTypeExts:'zip,txt,xlsx,jpg,png,jar,rar,docx',//允许上传的文件类型，填写mime类型
		fileDesc:'只能上传 zip,txt,xlsx,jpg,png,jar,rar,docx 的文件类型！',//上传时文件类型框给出的提示
		sizeLimit:10*1024*1024,//限制文件大小
		onUploadStart:function(){
			//alert('开始上传');
		},
		onInit:function(){
			//alert('初始化');
		},
		onUploadComplete:function(){
			alert('上传完成');
		}
	});
});
</script>
</head>

<body>
<div id="upload"></div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<%=request.getContextPath()%>/test/source/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/test/source/jquery.html5uploader.js"></script>
<style type="text/css"> 

#progress{ 
	/*border: 1px solid blue; 
	width:500px; 
	height:20px; */
	
	display:inline-block; 
	 width:300px; 
	 height:10px; 
	 background-color:white;
	 border-radius:20px;
	 border:1px groove #666;
	 vertical-align:middle;
	 padding:0 2px;
} 
 
#progressbar { 
	/*background:#66cc33; 
	height:20px; 
	width:0%; 
	text-align:center;
	color:red;
	font-weight:bold;*/
	
	width:0;
	height:9px;
	border-radius:10px;
	background:url(../source/images/jdt.png) repeat-x center; 
} 

#fileMsg{
height:20px; 
width:500; 
text-align:center;
color:red;
font-weight:bold;
}
</style>

<script type="text/javascript">
	var typeArray=["zip","txt","xlsx","jpg","png","jar","rar","docx"];
	var sizeLimit=100*1024*1024;
	
	/**
	*选择文件时，校验文件大小和类型
	*/
	function onSelect(_this){
		var fileObj=document.getElementById("upload-file").files[0];
		
		if(fileObj.constructor == File){
			//判断文件类型大小
			var fileType=fileObj.name.lastIndexOf(".");
			if(fileType>0){
				fileType=fileObj.name.substring(fileType+1);
				
				if ($.inArray(fileType.toLowerCase(), typeArray) < 0) {
					alert('只能上传 zip,txt,xlsx,jpg,png,jar,rar,docx 的文件类型！');
					return;
				}
				
				//判断文件大小
				if (fileObj.size > sizeLimit) {
					alert('上传文件大小应在10M以内！');
					return;
				}
			}else{
				alert('只能上传 zip,txt,xlsx,jpg,png,jar,rar,docx 的文件类型！');
				return;
			}
		}else{
			alert("plase select file!");
		}
		
		//文件上传
		uploadFile(fileObj);
	}
	
	function uploadFile(fileObj){
		var url="upload5";
		
		var form = new FormData();
		form.append(fileObj.name,fileObj);
		
		var xhr=new XMLHttpRequest();
		xhr.open("post",url,true);
		
		// xhr.upload 这是html5新增的api,储存了上传过程中的信息
        xhr.upload.onprogress = function (ev) {
            var percent = 0;
            if(ev.lengthComputable) {
                percent = 100 * ev.loaded/ev.total;
                //document.getElementById('progress').innerHTML = percent;
                document.getElementById('progressbar').style.width = percent + '%';
                document.getElementById('progressbar').innerHTML = percent.toFixed() + '%';
                document.getElementById('fileMsg').innerHTML = fileObj.name + " "+formatFileSize(ev.loaded)+ "/" + formatFileSize(ev.total);
            }
        }
		
		/* xhr.onload=function(){
			alert("");
		}; */
		
		// 文件上传成功或是失败
	    xhr.onreadystatechange = function(e) {
		    if (xhr.readyState == 4) {
			    if (xhr.status == 200) {
				    alert("ok");	
			    } else {
			        alert("er");		
			    }
		    }
	    };
		xhr.send(form);
	}
	
	//将文件的单位由bytes转换为KB或MB
	function formatFileSize(size){
		if (size> 1024 * 1024){
			size = (Math.round(size * 100 / (1024 * 1024)) / 100).toString() + 'MB';
		}
		else{
			size = (Math.round(size * 100 / 1024) / 100).toString() + 'KB';
		}
		return size;
	}
	
	/*document.getElementById("upload-file").onchange = function() {
        alert('你选择文件了');
        //alert(this.files[0]); // 文件对象,html5新增的api
        var fd = new FormData(); // html5新增的对象,可以包装字符,二进制信息
        fd.append(this.name,this.files[0]);
		
        var xhr = new XMLHttpRequest();
        xhr.open('POST','upload5',true); // 异步传输

        // xhr.upload 这是html5新增的api,储存了上传过程中的信息
        xhr.upload.onprogress = function (ev) {
            var percent = 0;
            if(ev.lengthComputable) {
                percent = 100 * ev.loaded/ev.total;
                document.getElementById('bar').style.width = percent + '%';
            }
        }
        xhr.send(fd);
    }*/
</script>
</head>

<body>
输入文件：<input type="file" value="选择文件" id="upload-file" onchange="onSelect(this)">
<br>
<div id="progress"><div id="progressbar"></div></div><div id="fileMsg"></div>
<br>
<input type="button" value="上传" onclick="uploadFile()">
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../resources/public.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript">
    var cols =[
				{title:'用户姓名',field:'USER_NAME',width:100, align:'left',sortable:true},
				{title:'用户性别',field:'USER_SEX',width:210, align:'left',sortable:true},
				{title:'用户年龄',field:'USER_AGE',width:180, align:'left',sortable:true},
				{title:'用户住址',field:'USER_ADDRESS',width:130, align:'left',sortable:true},
				{title:'用户电话',field:'USER_TEL',width:130, align:'left',sortable:true},
				{title:'用户qq',field:'USER_QQ',width:130, align:'left',sortable:true},
				{title:'用户身份证',field:'USER_ID_CARD',width:130, align:'left',sortable:true},
				{title:'操作',field:'USER_ID',width:150,align:'center',
					formatter:function(val,row,index){
						var cen = "<a href='#' onclick='view("+index+")'><img title='查看' src='../resources/common/img/view.png' /></a>"
						+ " <a href='#' onclick='edit("+index+")'><img title='编辑' src='../resources/common/img/edit.png' /></a>"
						+ " <a href='#' onclick='del("+index+")'><img title='删除' src='../resources/common/img/remove.png' /></a>";
						return cen;  
					}
				}
			];
		$(function(){ 		
			
		 	draghandle();
	 		init();
	 		drag();

 			$('#tbl').datagrid('getPanel').panel({
 				tools:'#add'
 			});
		});

		function init(){
			$('#tbl').datagrid({
				title:'用户列表',
				url:'querys',
				fitColumns:true,
				rownumbers:true,
				singleSelect:true,
				pagination:true,
				columns:[cols],
				detailFormatter:function(index,row){
					return '<div id="ddv-' + index + '" style="padding:0"></div>';
				},    
                onDblClickRow:function(rowIndex, rowData){
                	edit(rowIndex);
                },
 	            onLoadSuccess:function(data){
		            drag();
		        }
			});
		}
		function query(){
			$('#tbl').datagrid('load',{
				'strVal1':$('#userName_q').val(),
				'strVal2':$('#userQq_q').val(),
				'strVal3':$('#userEmail_q').val()
			});
		}
		function clean(){
			$('#userName_q').val('');
			$('#userQq_q').val('');
			$('#userEmail_q').val('');
		}
		function add(){
			openWindow('用户信息新增','add');
		}
		function view(index){
			var id=$('#tbl').datagrid('getRows')[index].USER_ID;
			openWindow('用户信息查看','view?id='+id);
		}
		function edit(index){
			var id=$('#tbl').datagrid('getRows')[index].USER_ID;
			openWindow('用户信息编辑','edit?id='+id);
		}
		function save(){
			checkEmpty($('#userName'),'用户名称不能为空');
			checkEmpty($('#userSex'),'用户性别不能为空');
			checkEmpty($('#userAge'),'用户年龄不能为空');
			checkEmpty($('#userTel'),'用户手机不能为空');
			checkEmpty($('#userQq'),'用户QQ不能为空');
			checkEmpty($('#userEmail'),'用户邮箱不能为空');
			checkEmpty($('#userAddress'),'用户地址不能为空');
			checkEmpty($('#userIdCard'),'用户身份证不能为空');
			
			  if($('#userName').attr("title")||
				$('#userSex').attr("title")||
				$('#userAge').attr('title')||
				$('#userTel').attr("title")||
				$('#userQq').attr("title")||
				$('#userEmail').attr("title")||
				$('#userAddress').attr("title")||
				$('#userIdCard').attr("title")
					) 
				  return;  
			  
			$('#fid').form('submit',{
				url:"save",
				success:function(data){
					if(data==1){
						appendError($('#userName'),'该用户名称已经存在');
					}else if(data==-1){
						alertError('保存用户信息出错');
					}else{
						alertDefined("操作成功");
						$('#tbl').datagrid('reload');
						closeWindow();
					}
				}
			});
		}
		function del(index){
			$.messager.confirm('删除提示','记录将被删除，是否继续？',function(r){
				if(r){
			var row=$('#tbl').datagrid('getRows')[index];
			$.ajax({
				url:'remove',
				dataType:'json',
				data:'id='+row.USER_ID,
				success:function(data){
					if(data)
						alertError('删除用户信息出错');
					else
						$('#tbl').datagrid('reload');
				}
			});
				}
			});
		}
	</script>
</head>
<body>
<div style="width:1000px;margin:auto">
	<div class="easyui-panel" title="用户信息查询" collapsible="true">
		<table class="table-detail" style="width:99%">
			<tr>
				<th width="15%">用户名称</th>
				<td width="35%">
					<input id="userName_q"  type="text" />
				</td>
				<th width="15%">用户QQ</th>
				<td width="35%">
					<input id="userQq_q"  type="text" />
				</td>
			</tr>
			<tr><td colspan="4" style="text-align:center">
				<a href="#" class="easyui-linkbutton" onclick="query()">查询</a>
				<a href="#" class="easyui-linkbutton" onclick="clean()">清空</a>
			</td></tr>
		</table>
	</div><br/>
	<div id="add">
		<a href="#" onclick="add()"><img title="新增" src="../resources/common/img/add.png" /></a>
	</div>
	<table id="tbl" data-options="tools:'#add'"></table>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<form id="fid" action="#" method="post">
        <table class="table-1">
        <tr>
            <th width="15%"><span style="color:red">*</span>用户姓名</th>
            <td width="35%"><form:input path="user.userName" maxlength="15" /></td>
            <th width="15%"><span style="color:red">*</span>用户性别</th>
            <td width="35%"><form:input path="user.userSex" maxlength="15" /></td>
        </tr>
        
        <tr>
        	<th width="15%"><span style="color:red">*</span>用户年龄</th>
            <td width="35%"><form:input path="user.userAge" maxlength="15" /></td>
            <th width="15%"><span style="color:red">*</span>用户手机</th>
            <td width="35%"><form:input path="user.userTel" /></td>
        </tr>
        
        <tr>
            <th width="15%"><span style="color:red">*</span>用户qq</th>
            <td width="35%"><form:input path="user.userQq" maxlength="15" /></td>
            <th width="15%"><span style="color:red">*</span>用户邮箱</th>
            <td width="35%"><form:input path="user.userEmail" maxlength="15"/></td>
        </tr>        
            
        <tr>
            <th width="15%"><span style="color:red">*</span>用户地址</th>
            <td width="35%"><form:input path="user.userAddress" maxlength="15"/></td>
            <th width="15%"><span style="color:red">*</span>用户身份证</th>
            <td width="35%"><form:input path="user.userIdCard" maxlength="15" /></td>
        </tr>
        <%-- <tr>
            <th width="15%"><span style="color:red">*</span>所属SGSN池</th>
            <td width="35%"><form:input path="user.belongSgsnPool" maxlength="15"  onKeyUp="value=value.replace(/\D/g,'')"
                            onafterpaste="value=value.replace(/\D/g,'')"/></td>
            <th width="15%"><span style="color:red">*</span>最大PDCH数</th>
            <td width="35%"><form:input path="user.pcuMaxPdchNum" maxlength="15"  onKeyUp="value=value.replace(/\D/g,'')"
                            onafterpaste="value=value.replace(/\D/g,'')"/></td>
        </tr>
        <tr>
        	<th width="15%"><span style="color:red">*</span>SGSN的NSEI</th>
            <td width="35%" colspan="4"><form:input path="user.sgsnNsei" maxlength="15" cssStyle="width:502px"/></td>
        </tr>
        <tr>
            <th width="15%"><span style="color:red">*</span>关联的CE</th>
            <td width="35%" colspan="4"><form:input path="user.relateCe" maxlength="15" cssStyle="width:502px"/></td>
        </tr>
        <tr>
        	<th width="15%"><span style="color:red">*</span>所属的SGSN</th>
            <td width="35%" colspan="4"><form:input path="user.belongSgsn" maxlength="15"  cssStyle="width:502px"/></td>
        </tr>
        <tr>
            <th width="15%">备注1</th>
            <td width="35%" colspan="4">
              <form:textarea path="user.remark1" rows="3" cssStyle="height: 40px;width:500px"
								onKeyUp="value=value.length > 50?value.substring(0,50):value"
                            	onafterpaste="value=value.length > 50?value.substring(0,50):value"
	                            maxlength="30"  ondragenter="return false"/>
            </td>
        </tr>
        <tr>
            <th width="15%">备注2</th>
            <td width="35%"  colspan="4">
				<form:textarea path="user.remark2" rows="3" cssStyle="height: 40px;width:500px"
								onKeyUp="value=value.length > 50?value.substring(0,50):value"
                            	onafterpaste="value=value.length > 50?value.substring(0,50):value"
	                            maxlength="30"  ondragenter="return false"/>
			</td> 
        </tr>--%>
        <tfoot>
	       <tr>
	           <td colspan="4">
	               <a href="#" class="easyui-linkbutton" onClick="save()">保存</a>
	               <a href="#" class="easyui-linkbutton" onclick="closeWindow()">取消</a>
	           </td>
	       </tr>
        </tfoot>
        </table>
    </form>
</body>
</html>
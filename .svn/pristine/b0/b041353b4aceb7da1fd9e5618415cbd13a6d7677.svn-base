<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  <link rel="stylesheet" href="<%=basePath%>css/displaytag_fit.css" type="text/css"></link>
  <link rel="stylesheet" href="<%=basePath%>css/screen.css" type="text/css"></link></head>
  
  <body>
    	<s:form action="edituser!editUser.action" namespace="/user" >
	    	<table>
		   		<tr>
		   			<th colspan="4"><center>编辑人员</center></th>
		   		</tr>
		   		<tr>
		   			<td>名称：</td>
		   			<td><input name="name" value="${edituser.name}"></td>
		   			<td>手机/座机：</td>
		   			<td><input name="tel" value="${edituser.tel }"></td>
		   		</tr>
		   		<tr>
		   			<td>邮箱：</td>
		   			<td><input name="email" value="${edituser.email }"></td>
		   			<td>密码：</td>
		   			<td><input name="pwd" type="password" value="${edituser.pwd }"></td>
		   		</tr>
		   		<tr>
		   			<td>确认密码：</td>
		   			<td><input name="repwd" type="password"  value="${edituser.pwd }"></td>
		   			<td>所属公司：</td>
		   			<td>${cHtml}</td>
		   		</tr>
		   		<tr>
		   			<td>所属部门：</td>
		   			<td>${dHtml}</td>
		   			<td>角色：</td>
		   			<td>${rHtml}</td>
		   		</tr>
		   		<tr>
		   			<td colspan='4'>
		   				<input type="submit" value="保存修改">
		   				<input type="reset" value="重置">
		   			</td>
		   		</tr>
		   	</table>
    	</s:form>
  </body>
</html>

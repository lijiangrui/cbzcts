<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  <link rel="stylesheet" href="<%=basePath%>css/displaytag_fit.css" type="text/css"/>
  <link rel="stylesheet" href="<%=basePath%>css/base.css" type="text/css"/>
  <script type="text/javascript" src="<%=basePath%>js/user.js"></script>
  <script type="text/javascript" src="<%=basePath%>js/basicCheck.js"></script>
  <script type="text/javascript" src="<%=basePath%>js/jquery-1.8.2.min.js"></script>
  <script type="text/javascript" src="<%=basePath%>js/form.js"></script>
  <script type="text/javascript">
  function mixVal(name){
	  var depts = document.getElementsByName(name);
	  var chargeDepts = "";
	for(var i=0;i<depts.length;i++){
		if(depts[i].checked){
			chargeDepts+=depts[i].value+",";
		}
	}
	chargeDepts = chargeDepts.substr(0,chargeDepts.length-1);
	document.getElementById('chargeDepts').value= chargeDepts;
  }
  </script>
  <body bgcolor="#ffffff">
   	<s:form action="saveuser" namespace="/user" onsubmit="">
	   	<table>
	   		<tr>
	   			<th colspan="4"><center>添加人员</center></th>
	   		</tr>
	   		<tr>
	   			<td>登录名：</td>
	   			<td><input id="name" name="name"></td>
	   			<td>用户名：</td>
	   			<td><input name="realname" ></td>
	   			
	   		</tr>
	   		<tr>
	   			<td>手机/座机：</td>
	   			<td><input name="tel"></td>
	   			<td>邮箱：</td>
	   			<td><input name="email"></td>
	   		</tr>
	   		<tr>
	   			<td>密码：</td>
	   			<td><input name="pwd" type="password"></td>
	   			<td>确认密码：</td>
	   			<td><input name="repwd" type="password"></td>
	   		</tr>
	   		<tr>
	   			<td>组织机构：</td>
	   			<td>${cHtml }</td>
	   			<td>角色：</td>
	   			<td>${rHtml }</td>
	   		</tr>
	   		<tr>
	   			<td>所属部门：</td>
	   			<td>${dHtml}</td>
	   			<td>职位：</td>
	   			<td>${tHtml}</td>
	   		</tr>
	   		<tr>
	   			<td>管辖部门</td>
	   			<td colspan="3">${chargeDeptHtml}
	   			<input type="hidden" id="chargeDepts" name="chargeDepts" value="" >
	   			</td>
	   		</tr>
	   	
	   		<tr>
	   			<td colspan='4'>
	   				<img src="<%=basePath%>img/submit.gif" style="width:50px;height:20" onclick="submit();">
	   				<img src="<%=basePath%>img/reset.gif" style="width:50px;height: 20" onclick="reset();">
	   			</td>
	   		</tr>
	   	</table>
   	</s:form>
  </body>
</html>

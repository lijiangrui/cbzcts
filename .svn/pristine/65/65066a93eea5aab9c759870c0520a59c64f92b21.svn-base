<%@ page language="java" import="java.util.*,com.jbl.pagemodel.User" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	User user = (User)session.getAttribute("currentuser");
%>
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
  <script type="text/javascript" src="<%=basePath%>js/jquery-1.8.2.min.js"></script>
  <script type="text/javascript" src="<%=basePath%>js/user.js"></script>
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
  </head>
  
  <body>
	  <s:form id="form" action="modify!modify.action" namespace="/user">
		<table>
	   		<tr>
	   			<th colspan="4"><center>修改人员信息</center></th>
	   		</tr>
	   		<tr>
	   			<td>登录名：</td>
	   			<td><input name="name"  value="${user.name }" />
	   			<input type="hidden" name="id"  value="${user.id }" />
	   			</td>
	   			<td>用户名：</td>
	   			<td><input name="realname"  value="${user.realname }"></td>
	   		</tr>
	   		<tr>
	   			<td>密码：</td>
	   			<td><input name="pwd" type="password" value=""></td>
	   			<td>确认密码：</td>
	   			<td><input name="repwd" type="password"></td>
	   		</tr>
	   		<tr>
	   			<td>手机/座机：</td>
	   			<td><input name="tel" value="${user.tel }"></td>
	   			<td>邮箱：</td>
	   			<td><input name="email" value="${user.email }"></td>
	   		</tr>
	   		<tr>
	   			
	   			<td>所属公司：</td>
	   			<td>${cHtml}</td>
	   			<td>所属部门：</td>
	   			<td>${dHtml}</td>
	   		</tr>
	   		<tr>
	   			<td>角色：</td>
	   			<td>${rHtml }</td>
	   			<td>职位：</td>
	   			<td>${tHtml }</td>
	   		</tr>
	   		<tr>
	   			<td>管辖部门：</td>
	   			<td colspan="3">
				${chargeDeptHtml}
				<input type="hidden" id="chargeDepts" name="chargeDepts" value="" />
	   			</td>
	   		</tr>
	   	
			<tr>
				<td colspan="4">
					<input type="submit" value="修改">
				</td>
			</tr>
		</table>	
	</s:form>
  </body>
</html>

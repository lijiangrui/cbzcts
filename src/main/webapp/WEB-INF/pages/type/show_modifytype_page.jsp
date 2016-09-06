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
  </head>
  
  <body>
	  <s:form id="form" action="modify!modify.action" namespace="/type">
		<table>
			<tr>
				<td>分类名称：</td>
				<td>
				<input id="name" name="name" value="${type.name}" />
				<input type="hidden" name="id" value="${type.id}" />
				<input type="hidden" name="deltriger" value="${type.deltriger}" />
				<input type="hidden" name="type" value="${type.type}" />
				</td>
				<td>所属部门：</td>
				<td>${dHtml}
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

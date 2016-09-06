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
	<link rel="stylesheet" href="<%=basePath%>css/base.css" type="text/css"/>
<link rel="stylesheet" href="<%=basePath%>css/displaytag_fit.css" type="text/css"/>
  </head>
  
  <body>
  	<s:form>
  		<table>
  			<th colspan="4"><center>批量导入企业档案</center></th>
  			<tr>
  				<td>导入模板</td>
  				<td colspan="3"><a href="downloadtemplate!downloadTemplate.action">企业档案导入模板.xls</a></td>
  			</tr>
  			<tr>
  				<td>上传文件</td>
  				<td colspan="3">
  					<input type="file" name=""/>
  				</td>
  			</tr>
  			<tr>
  				<td colspan="4">
  					<input type="submit" name="" value="导入"/>
  				</td>
  			</tr>
  		</table>
  	</s:form>
  </body>
</html>

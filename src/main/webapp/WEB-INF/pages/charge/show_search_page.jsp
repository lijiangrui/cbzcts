<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
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
  <link rel="stylesheet" href="<%=basePath%>css/displaytag_fit.css" type="text/css"></link>
  <link rel="stylesheet" href="<%=basePath%>css/screen.css" type="text/css"></link></head>
  
  </head>
  
  <body>
  	<div align="center">
	   	<s:form action="searchpatrollist!searchPatrolList.action"  namespace="/patrol" id="form" name="form">
		    	检索：
				&nbsp;&nbsp;
				<div>
					<span>企业名称：</span><input type="text">
				</div>
				<div>
					<span>地址：</span><input type="text">
				</div>
				<div>
					<span>巡检内容：</span><input type="text">
				</div>
				<div>
					<span>巡检时间：</span><input type="text">
				</div>
				<div>
					<span align="left">科室：</span><input type="text">
				</div>
				<input id="searchVal" name="searchVal" value="" /> 
		    	&nbsp;&nbsp;
		    	<input type="submit" id="submit" name="submit" value="查询"/>
	    </s:form>
	</div>
   	<display:table name="resultList" id="table_row"
			class="ITS" 
			requestURI="patrol/showpatrollist!showPatrolList.action"
		 	cellpadding="0" cellspacing="0" 
		 	size="${total}" pagesize="${pagesize}"
		 	>
			code
			<display:column property="areaName" title="地区"/>
			
			<display:column property="supplierName" title="企业名称"/>
			
			<display:column property="content" title="巡检内容" style="text-align:left;" />
			
			<display:column property="result" title="巡检结果" style="text-align:left;"/>
			
			<display:column property="patrolTime" title="巡检时间" style="text-align:left;" format="{0,date,yyyy-MM-dd}"/>
			
		</display:table>
  </body>
</html>

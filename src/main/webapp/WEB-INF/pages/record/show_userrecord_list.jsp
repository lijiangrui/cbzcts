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
  	<div align="left">
	   	<s:form action="searchuserrecordlist!searchUserRecordList.action"  namespace="/record" id="form" name="form">
				&nbsp;&nbsp;
				用户名：${userListHtml} 
		    	&nbsp;&nbsp;
		    	操作：<select id="type" name="type">
		    		<option value="0">全部</option>
		    		<option value="1">登录</option>
		    		<option value="2">录入</option>
		    		<option value="3">修改</option>
		    		<option value="4">删除</option>
		    	</select>
		    	<input type="submit" id="submit" name="submit" value="查询"/>
	    </s:form>
	</div>
   	<display:table name="resultList" id="table_row"
			class="ITS" 
			requestURI="recordAction!record0List.action"
		 	cellpadding="0" cellspacing="0" 
		 	size="${total}" pagesize="${pagesize}"
		 	export="false"
		 	>
			
			<display:column property="operater" title="操作用户"/>
			
			<display:column property="operateTime" title="操作时间" style="text-align:left;" />
			
			<display:column property="something" title="操作" style="text-align:left;"/>
			
		</display:table>
  </body>
</html>

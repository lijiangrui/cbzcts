<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/screen.css" />
		
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/displaytag_fit.css" />

  </head>
  
  <body>
    <s:form action="searchhistorylist!searchHistoryList.action"  namespace="/files" id="form" name="form" target="_parent">
    			关键字查询：
    				<select id="searchType" name="searchType" >
    					<option value="name">文件名称</option>
    					<option value="sendDept">发文部门</option>
    					<option value="renter">租赁人名称</option>
    				</select>
    				&nbsp;&nbsp;
    				<input id="searchVal" name="searchVal" value="" /> 
    			<input type="submit" id="submit" name="submit" value="查询"/>
    	
    </s:form>
  </body>
</html>

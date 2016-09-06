<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ include file="/common/header-js.jsp" %>
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
	   	<s:form action="searchcertificatelist!searchCertificateList.action"  namespace="/certificate" id="form" name="form">
		    	搜索：
				&nbsp;&nbsp;
				<input id="searchVal" name="searchVal" value="" /> 
		    	&nbsp;&nbsp;
		    	<input type="submit" id="submit" name="submit" value="查询"/>
	    </s:form>
	    
	</div>
   	<display:table name="resultList" id="table_row"
			class="ITS" 
			requestURI="showcertificatelist!showCertificateList.action"
		 	cellpadding="0" cellspacing="0" 
		 	size="${total}" pagesize="${pagesize}"
		 	decorator="com.jbl.decorator.CertificateDisplayTagDecorator"
		 	>
		 	
		 	<display:column property="supplierName" title="所属企业" />
		 	
		 	<display:column property="name" title="证书名称"/>
		 	
		 	<display:column property="type" title="证书类型"/>
		 	
			<display:column property="no" title="编号"/>
			
			<display:column property="validate" title="有效截止日期"/>
			
			<display:column title="操作" style="text-align:left;">
				<input type="button" value="查看" onclick="checkItem(${table_row.id});" />
				<input type="button" value="编辑" onclick="modifyItem(${table_row.id});" />
				<input type="button" value="删除" onclick="deleteItem(${table_row.id});" />
			</display:column>
			
		</display:table>
  </body>
</html>

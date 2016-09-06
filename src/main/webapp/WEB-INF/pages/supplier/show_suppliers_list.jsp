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
  <script type="text/javascript" src="<%=basePath%>js/util.js"></script>
  </head>
  
  <body>
  	<div align="center">
	   	<s:form action="searchsupplierlist!searchSupplierList.action"  namespace="/supplier" id="form" name="form">
		    	搜索：
				&nbsp;&nbsp;
				<input id="searchVal" name="searchVal" value="" /> 
		    	&nbsp;&nbsp;
		    	<input type="submit" id="submit" name="submit" value="查询"/>
	    </s:form>
	</div>
   	<display:table name="resultList" id="table_row"
			class="ITS" 
			requestURI="showsupplierlist!showSupplierList.action"
		 	cellpadding="0" cellspacing="0" 
		 	size="${total}" pagesize="${pagesize}"
		 	decorator="com.jbl.decorator.SupplierDisplayTagDecorator"
		 	>
			<display:column property="code" title="组织机构代码"/>
			
			<display:column title="企业名称">
				<a href="showsupplier!showSupplier.action?id=${table_row.id}">${table_row.name }</a>
			</display:column>
			
			<display:column property="areaName" title="乡镇" style="text-align:left;" />
			
			<display:column property="position" title="地址" style="text-align:left;"/>
			
			<display:column property="legalPerson" title="企业法人" style="text-align:left;"/>
			
			<display:column property="contactPerson" title="联系人" style="text-align:left;"/>

			<display:column property="contact" title="联系方式" style="text-align:left;"/>		
			<display:column property="deltriger" title="操作">
			</display:column>
		</display:table>
  </body>
</html>

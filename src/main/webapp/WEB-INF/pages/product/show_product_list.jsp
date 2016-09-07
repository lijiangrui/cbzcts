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
	   	<s:form action="searchproductlist!searchProdcutList.action"  namespace="/product" id="form" name="form">
		    	搜索：
				&nbsp;&nbsp;
				<input id="searchVal" name="searchVal" value="" /> 
		    	&nbsp;&nbsp;
		    	<input type="submit" id="submit" name="submit" value="查询"/>
	    </s:form>
	</div>
   	<display:table name="resultList" id="table_row"
			class="ITS" 
			requestURI="showproductlist!showProductList.action"
		 	cellpadding="0" cellspacing="0" 
		 	size="${total}" pagesize="${pagesize}"
		 	>
		 	
		 	<display:column property="supplierName" title="所属企业"/>
		 	
			<display:column property="name" title="产品名称"/>
			
			<display:column property="no" title="商品代码"/>
			
			<display:column property="size" title="产品规格" style="text-align:left;" />
			
			<display:column property="material" title="材料" style="text-align:left;" />
			
			<display:column property="purpose" title="用途" style="text-align:left;" />
			
			<display:column title="操作" style="text-align:left;">
				<input type="button" value="查看" onclick="checkItem(${table_row.id});" />				
				<input type="button" value="编辑" onclick="modifyItem(${table_row.id});" />
				<input type="button" value="删除" onclick="deleteItem(${table_row.id});" />
			</display:column>
		</display:table>
  </body>
</html>

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
	   	<s:form action="searchchargelist!searchChargeList.action"  namespace="/charge" id="form" name="form">
		    	搜索：
				&nbsp;&nbsp;
				<input id="searchVal" name="searchVal" value="" /> 
		    	&nbsp;&nbsp;
		    	<input type="submit" id="submit" name="submit" value="查询"/>
	    </s:form>
	</div>
   	<display:table name="resultList" id="table_row"
			class="ITS" 
			requestURI="charge/showchargelist!showChargeList.action"
		 	cellpadding="0" cellspacing="0" 
		 	size="${total}" pagesize="${pagesize}"
		 	>
			<display:column property="deptName" title="部门"/>
			
			<display:column property="serialNo" title="流水号" href="showcharge!showCharge.action?id=${table_row.id}"/>
			
			<display:column property="supplierName" title="企业名称"/>
			
			<display:column property="typeName" title="收费项目" style="text-align:left;" />
			
			<display:column property="no" title="票号" style="text-align:left;"/>
			
			<display:column property="money" title="金额" style="text-align:left;"/>
			
			<display:column property="chargeTime" title="收费日期" style="text-align:left;" format="{0,date,yyyy-MM-dd}"/>
			
			<display:column title="操作" style="text-align:left;">
				<input type="button" value="编辑" onclick="modifyItem(${table_row.id});" />
				<input type="button" value="删除" onclick="deleteItem(${table_row.id});" />
			</display:column>
		</display:table>
  </body>
</html>

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
  <script type="text/javascript">
  	function showItem(id){
  		var url = "showsupplier!showSupplier.action?id="+id;
  		window.open(url,'','height=400,width=1000,top=200,left=200,scrollbars=yes');
  	}
  </script>
  
  </head>
  
  <body>
   	<display:table name="resultList" id="table_row"
			class="ITS" 
			requestURI="user/showuserlist!showUserList.action"
		 	cellpadding="0" cellspacing="0" 
		 	size="${total}" pagesize="${pagesize}"
		 	decorator="com.jbl.decorator.SupplierDisplayTagDecorator">
			<display:column title="企业名称">
				<a href="showsupplier!showSupplier.action?id=${table_row.id}">${table_row.name }</a>
			</display:column>
		</display:table>
  </body>
</html>

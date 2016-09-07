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
	<jsp:include page="/WEB-INF/header.jsp"></jsp:include>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  <script type="text/javascript" src="<%=basePath%>js/patrol.js"></script>
  <style>
	span{
		color:red;
	}
	</style>
  </head>
  
  <body>
		<table>
			<tr>
				<td colspan="4"><h3><center>产品信息</center></h3></td>
			</tr>
			<tr>
				<td>所属企业</td>
				<td colspan='3'>${product.supplierName }</td>
			</tr>
			<tr>
  				<td>产品名称</td>
  				<td>
  					${product.name}
  				</td>
  				<td>商品代码</td>
  				<td>
  					${product.no }
  				</td>
  			</tr>
  			<tr>
  				<td>产品规格</td>
  				<td>
  					${product.size }
  				</td>
  				<td>材料</td>
  				<td>
  					${product.material }
  				</td> 
  			</tr>
  			<tr>
  				<td>用途</td>
  				<td colspan="3">
  					${product.purpose }
  				</td>
  			</tr>
		</table>	
  </body>
</html>

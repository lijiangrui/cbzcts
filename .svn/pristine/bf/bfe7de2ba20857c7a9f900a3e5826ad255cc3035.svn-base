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
	  <s:form id="form" action="modify!modify.action" namespace="/product">
		<table>
			<tr>
				<td colspan="4"><h3><center>修改内容</center></h3></td>
			</tr>
			<tr>
  				<td>产品名称</td>
  				<td>
  					<input type="hidden" id="id" name="id" value="${product.id }" />
  					<input type="hidden" id="sid" name="sid" value="${product.sid }" />
  					<input type="text" id="name" name="name" value="${product.name}" />
  				</td>
  				<td>生产能力</td>
  				<td>
  					<input type="text" id="capacity" name="capacity" value="${product.capacity }" />
  				</td>
  			</tr>
  			<tr>
  				<td>年产值</td>
  				<td>
  					<input type="text" id="yearCapacity" name="yearCapacity" value="${product.yearCapacity }" />
  				</td>
  				<td>年利润</td>
  				<td>
  					<input type="text" id="yearProfit" name="yearProfit" value="${product.yearProfit }" />
  				</td> 
  			</tr>
  			<tr>
  				<td>年纳税</td>
  				<td>
  					<input type="text" id="yearTax" name ='yearTax' value="${product.yearTax }" />
  				</td>
  				<td>销售流向</td>
  				<td>
  					<input type="text" id="saleTo" name="saleTo" value="${product.saleTo }" />
   				</td>
  			</tr>
			<tr>
				<td colspan="4">
					<input type="submit" value="修改">
				</td>
			</tr>
		</table>	
	</s:form>
  </body>
</html>

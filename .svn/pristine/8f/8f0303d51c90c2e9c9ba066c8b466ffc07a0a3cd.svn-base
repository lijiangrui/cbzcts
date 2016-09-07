<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
	 <link rel="stylesheet" href="<%=basePath%>css/displaytag_fit.css" type="text/css"/>
  <link rel="stylesheet" href="<%=basePath%>css/base.css" type="text/css"/>
  <link rel="stylesheet" href="<%=basePath%>css/jquery.bigautocomplete.css" type="text/css"></link>
  <script type="text/javascript" src="<%=basePath%>js/jquery-1.8.2.min.js"></script>
  <script type="text/javascript" src="<%=basePath%>js/patrol.js"></script>
  <script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
  <script type="text/javascript" src="<%=basePath%>js/jquery.bigautocomplete.js"></script>
  <script type="text/javascript" src="<%=basePath%>js/basicCheck.js"></script>
  
</head>
  <body>
  		<table>
  			<th colspan="2"><center>${charge.serialNo}巡检记录</center></th>
  			<tr>
  				<td>收费项目</td>
  				<td>
					${charge.typeName }
  				</td>
  			</tr>
  			<tr>
  				<td>城镇</td>
  				<td>
  				${charge.areaName }
  				</td>
  			</tr>
  			<tr>
  				<td>企业名称</td>
  				<td id="td">
  					${charge.supplierName }
  				</td>
  			</tr>
  			<tr>
  				<td>收费日期</td>
  				<td>
					${charge.chargeTime }
  				</td>
  			</tr>
  			<tr>
  				<td>票号</td>
  				<td>
					${charge.no }
  				</td>
  			</tr>
  			<tr>
  				<td>金额</td>
  				<td>
	  				${charge.money }
  				</td>
  			</tr>
  			<tr>
  				<td>备注</td>
  				<td>
	  				<textarea id="comment" name="comment" cols="110" rows="4" readonly="readonly">${charge.comment }</textarea>
  				</td>
  			</tr>
  		</table>
  		<br>
  		<table>
	 		<th colspan="8"><center>录入人员信息</center></th>
  			<tr>
  				<td>姓名：</td>
  				<td>${charge.userName}</td>
  				<td>部门编号：</td>
  				<td>${charge.deptNo}</td>
  				<td>部门名称：</td>
  				<td>${charge.deptName}</td>
  				<td>提交时间：</td>
  				<td>${charge.createTime}</td>
  			</tr>
  		</table>
  </body>
</html>

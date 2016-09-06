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
  			<th colspan="2"><center>${patrol.serialNo}巡检记录</center></th>
  			<tr>
  				<td>巡检项目</td>
  				<td>
					${patrol.typeName }
  				</td>
  			</tr>
  			<tr>
  				<td>城镇</td>
  				<td>
  				${patrol.areaName }
  				</td>
  			</tr>
  			<tr>
  				<td>企业名称</td>
  				<td id="td">
  					${patrol.supplierName }
  				</td>
  				
  			</tr>
  			<tr>
  				<td>巡检日期</td>
  				<td>
					${patrol.patrolTime }
  				</td>
  			</tr>
  			<tr>
  				<td>巡检内容</td>
  				<td>
					${patrol.content }
  				</td>
  			</tr>
  			<tr>
  				<td>巡检结果</td>
  				<td>
	  				<textarea id="result" name="result" cols="110" rows="4" readonly="readonly">${patrol.result}</textarea>
  				</td>
  			</tr>
  		</table>
  		<br>
  		<table>
	 		<th colspan="8"><center>录入人员信息</center></th>
  			<tr>
  				<td>姓名：</td>
  				<td>${patrol.userName}</td>
  				<td>部门编号：</td>
  				<td>${patrol.deptNo}</td>
  				<td>部门名称：</td>
  				<td>${patrol.deptName}</td>
  				<td>提交时间：</td>
  				<td>${patrol.createTime}</td>
  			</tr>
  		</table>
  </body>
</html>

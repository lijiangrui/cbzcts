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
  
  <link rel="stylesheet" href="<%=basePath%>bootstrap/css/bootstrap.min.css" type="text/css"></link>
  <link rel="stylesheet" href="<%=basePath%>js/jquery-ui-bootstrap/css/custom-theme/jquery-ui-1.10.0.custom.css" type="text/css"></link>
  <script type="text/javascript" src="<%=basePath%>js/jquery-ui-bootstrap/js/jquery-1.8.3.min.js"></script>
  <script type="text/javascript" src="<%=basePath%>js/jquery-ui-bootstrap/js/jquery-ui-1.9.2.custom.min.js"></script>
  
  <script type="text/javascript" src="<%=basePath%>js/patrol.js"></script>
  <script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
  <script type="text/javascript" src="<%=basePath%>js/basicCheck.js"></script>
  
	<style>
	.spanalert{
		color:red;
	}
	</style>
</head>
  <body>
  	<s:form id='form' action='save!save.action' namespace='/charge' onsubmit="return checkspans();">
  		<table>
  			<th colspan="2"><center>收费记录</center></th>
  			<tr>
  				<td>收费项目</td>
  				<td>
  				${tHtml}
  				<span id="span6" class="spanalert">*</span>
  				</td>
  			</tr>
  			<tr>
  				<td>城镇</td>
  				<td>
  				${areaHTML}
  				<span id="span1" class="spanalert">*</span>
  				</td>
  			</tr>
  			<tr>
  				<td>企业名称</td>
  				<td>
  				<input type="supplierName" id="supplierName">
  				<span id="td">
  				<select id="sid" name="sid"><option value="0">请选择</option></select>
  				<span id="span2" class="spanalert">*</span>
  				</span>
  				</td>
  			</tr>
  			<!-- 
  			<tr>
  				<td>测试补全</td>
  				<td>
  				<input type="text" id="test" onclick="aaa();" onmouseout="aaa();">
  				</td>
  			</tr>
  			 -->
  			<tr>
  				<td>收费日期</td>
  				<td>
  					<input id="chargeTime" name="chargeTime" onclick="WdatePicker()" onblur="checkNull(this.id,'span3')"/>
  					<span id="span3" class="spanalert">*</span>
  				</td>
  			</tr>
  			<tr>
  				<td>票号</td>
  				<td>
	  				<input id="no" name="no" onblur="checkNull(this.id,'span4')"/>
  					<span id="span4" class="spanalert">*</span>
  				</td>
  			</tr>
  			<tr>
  				<td>金额</td>
  				<td>
	  				<input id="money" name="money" onblur="checkNum(this.value,'span5')" />
	  				<span id="span5" class="spanalert">*</span>
  				</td>
  			</tr>
  			<tr>
  				<td>备注</td>
  				<td>
	  				<textarea id="comment" name="comment" cols="110" rows="4"></textarea>
  				</td>
  			</tr>
  			<tr>
  				<td colspan="2">
  					<input type="submit" value="提交">
  					<input type="reset" value="重置">
  				</td>
  			</tr>
  		</table>
  	</s:form>
  </body>
</html>

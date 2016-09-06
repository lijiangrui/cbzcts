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
  <script type="text/javascript" src="<%=basePath%>js/charge.js"></script>
  <style>
	span{
		color:red;
	}
	</style>
  </head>
  
  <body>
	  <s:form id="form" action="modify!modify.action" namespace="/charge">
		<table>
			<tr>
				<td colspan="4"><h3><center>修改内容</center></h3></td>
			</tr>
			<tr>
  				<td>收费项目</td>
  				<td>
  				${tHtml}
  				<input type="hidden" id="id" name="id" value="${charge.id}" />
  				<input type="hidden" id="serialNo" name="serialNo" value="${charge.serialNo}" />
  				<input type="hidden" id="createTime" name="createTime" value="${charge.createTime}"/>
  				<input type="hidden" id="userId" name="userId" value="${charge.userId}" />
  				<span id="span6"></span>
  				</td>
  			</tr>
  			<tr>
  				<td>城镇</td>
  				<td>
  				${areaHTML}
  				<span id="span1"></span>
  				</td>
  			</tr>
  			<tr>
  				<td>企业名称</td>
  				<td id="td">
  				${suHtml}
  				<span id="span2"></span>
  				</td>
  			</tr>
  			<tr>
  				<td>收费日期</td>
  				<td>
  				<input id="chargeTime" name="chargeTime" value="${charge.chargeTime}" onclick="WdatePicker()" onblur="checkNull(this.id,'span3')"/>
  				<span id="span3"></span>
  				</td>
  			</tr>
  			<tr>
  				<td>票号</td>
  				<td>
	  				<input id="no" name="no" value="${charge.no}" onblur="checkNull(this.id,'span4')"/>
  					<span id="span4"></span>
  				</td>
  			</tr>
  			<tr>
  				<td>金额</td>
  				<td>
	  				<input id="money" name="money" value="${charge.money}" onblur="checkNull(this.id,'span5')" />
	  				<span id="span5"></span>
  				</td>
  			</tr>
  			<tr>
  				<td>备注</td>
  				<td>
	  				<textarea id="comment" name="comment" cols="110" rows="4" >${charge.comment }</textarea>
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

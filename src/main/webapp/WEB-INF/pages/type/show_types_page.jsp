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
	  <s:form id="form" action="save!save.action" namespace="/type">
		<table>
			<tr>
				<td>分类名称：</td>
				<td><input id="name" name="name" value="" />
				<input type="hidden" name="deltriger" value="0" />
				<input type="hidden" name="type" value="${type}" />
				</td>
				<td>所属部门：</td>
				<td>
					${dHtml}
				</td>
				<td>
					<input type="submit" value="添加">
				</td>
			</tr>
		</table>	
	</s:form>
   	<display:table name="resultList" id="table_row"
			class="ITS" 
			requestURI="showtypes!showTypes.action"
		 	cellpadding="0" cellspacing="0" 
		 	size="${total}" pagesize="${pagesize}"
		 	decorator="com.jbl.decorator.TypeDisplayTagDecorator"
		 	>
		 	<display:column title="序号" value="${table_row_rowNum}"/>
		 	
			<display:column property="name" title="分类名称"/>
			
			<display:column property="deptName" title="所属部门" />
			
			<display:column title="其他操作" style="text-align:left;" >
				<input type="button" value="编辑" onclick="modifyItem(${table_row.id});" />
				<input type="button" value="删除" onclick="deleteItem(${table_row.id});" />
			</display:column>
			
		</display:table>
  </body>
</html>

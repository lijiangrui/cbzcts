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
  	/*function edituser(id){
  		var xmlhttpRequest;
  		if(window.XMLHttpRequest){
  			xmlhttpRequest = new XMLHttpRequest();
  		}else{
  			xmlhttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
  		}
  		var url = "edituser!editUser.action?id="+id;
  		xmlhttpRequest.open("post", url);
		xmlhttpRequest.send(null);
  	}*/
  	
  	function edituser(id){
  		var url = "showuser!showUser.action?id="+id;
  		window.open(url,'','height=400,width=800,top=200,left=200,scrollbars=yes');
  	}
  </script>
  </head>
  
  <body>
   	<div align="center">
	   	<s:form action="searchuserlist!searchUserList.action"  namespace="/user" id="form" name="form">
		    	搜索：
				&nbsp;&nbsp;
				<input id="searchVal" name="searchVal" value="" /> 
		    	&nbsp;&nbsp;
		    	<input type="submit" id="submit" name="submit" value="查询"/>
	    </s:form>
	</div>
   	<display:table name="resultList" id="table_row"
			class="ITS" 
			requestURI="showuserlist!showUserList.action"
		 	cellpadding="0" cellspacing="0" 
		 	size="${total}" pagesize="${pagesize}"
		 	decorator="com.jbl.decorator.UserDisplayTagDecorator"
		 	>
			
			<display:column property="name" title="登录名"/>
			
			<display:column property="realname" title="名称"/>
			
			<display:column property="companyname" title="组织机构" style="text-align:left;" />
			
			<display:column property="deptname" title="部门" style="text-align:left;"/>
			
			<display:column property="rolename" title="角色" style="text-align:left;"/>

			<display:column property="deltriger" title="操作" style="text-align:left;" >
			</display:column>
		</display:table>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="common/header.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

</head>
<frameset rows="127,*,11" frameborder="no" border="0" framespacing="0">
  <frame src="<%=basePath%>/admin/top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" />
  <frame src="<%=basePath%>/admin/center.jsp" name="mainFrame" id="mainFrame" />
  <frame src="<%=basePath%>/admin/down.jsp" name="bottomFrame" scrolling="No" noresize="noresize" id="bottomFrame" />
</frameset>
<noframes>
	<body >您的浏览器不支持框架！</body>
</noframes>
</html>
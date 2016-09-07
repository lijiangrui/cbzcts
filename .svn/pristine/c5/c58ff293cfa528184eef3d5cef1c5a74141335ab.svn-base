<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test_typeahead.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <link rel="stylesheet" href="<%=basePath%>bootstrap/css/bootstrap.min.css" type="text/css"></link>
  <link rel="stylesheet" href="<%=basePath%>js/jquery-ui-bootstrap/css/custom-theme/jquery-ui-1.10.0.custom.css" type="text/css"></link>
  <script type="text/javascript" src="<%=basePath%>js/jquery-ui-bootstrap/js/jquery-1.8.3.min.js"></script>
  <script type="text/javascript" src="<%=basePath%>js/jquery-ui-bootstrap/js/jquery-ui-1.9.2.custom.min.js"></script>
 </head>
  <script type="text/javascript">
  	$(function(){
  		var availableTags = ["阿凡达短发", "asdfasdfa", "Asp", "BASIC", "C", "C++", "Clojure", "COBOL", "ColdFusion", "Erlang", "Fortran", "Groovy", "Haskell", "Java", "JavaScript", "Lisp", "Perl", "PHP", "Python", "Ruby", "Scala", "Scheme"];
  		 
  		$("#test").autocomplete({
  		    source: availableTags
  		});
  	});
  </script>
  <body>
    <input type="text" name="test" id="test" value=""/>
  </body>
</html>

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
    <script type="text/javascript" src="<%=basePath%>js/jquery-1.8.2.min.js"></script>
  <script type="text/javascript" src="<%=basePath%>js/form.js"></script>
  <script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
  <script type="text/javascript" src="<%=basePath%>js/ext-base.js"></script>
  <script type="text/javascript" src="<%=basePath%>js/ext-all.js"></script>
  <script type="text/javascript">
  $(function($){
		$('#type>option').each(function(){
			if($('#typeVal').val()==this.value){
				$(this).attr("selected","selected");
			}
		});
	});
  </script>
  <style>
	span{
		color:red;
	}
	</style>
  </head>
  
  <body>
		<table>
			<tr>
				<td colspan="4"><h3><center>证书信息</center></h3></td>
			</tr>
			<tr>
  				<td>证书类型</td>
  				<td>
  					<select name="type" id="type">
						<option value="0">请选择</option>
						<option value="1">业务类型</option>
						<option value="2">质量管理</option>
						<option value="3">认证管理</option>
						<option value="4">认证认可</option>
						<option value="5">执行标准</option>
						<option value="6">食品相关产品</option>
						<option value="7">生产许可证</option>
						<option value="8">特种设备</option>
						<option value="9">自愿性认证</option>
						<option value="10">其他业务</option>
					</select>
					<input type="hidden" id="typeVal" name="typeVal" value="${certificate.type}">
  				</td>
  			</tr>
  			<tr>
  				<td>项目名称</td>
  				<td>
  					${certificate.name }
  				</td>
  			</tr>
  			<tr>
  				<td>编号代码</td>
  				<td>
  					${certificate.no }
  				</td>
  			</tr>
  			<tr>
  				<td>发证单位</td>
  				<td>
  					${certificate.unit }
  				</td> 
  			</tr>
  			<tr>
  				<td>有效截止日期</td>
  				<td>
  					${certificate.validate }
  				</td>
  			</tr>
		</table>	
  </body>
</html>

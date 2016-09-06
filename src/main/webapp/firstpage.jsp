<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<jsp:include page="common/header.jsp" />
  <script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.min.js"></script>
  <script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
  <link rel="stylesheet" href="js/jquery-easyui-1.4.1/themes/default/easyui.css" type="text/css"></link>
  <script type="text/javascript" src="js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
  <link rel="stylesheet" href="js/jquery-easyui-1.4.1/themes/icon.css" type="text/css"></link>
		<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow: hidden;
}

.STYLE3 {
	font-size: 12px;
	color: #adc9d9;
}
-->
</style>

 <script type="text/javascript">
 	function checkForm(){
 		var form = document.getElementById("form1");
		if(document.getElementById('name').value == ""){
			alert("用户名不能为空");
			return false;
		}
		if(document.getElementById('pwd').value == ""){
			alert("密码不能为空");
			return false;
		}
		form.submit();
	}
	
	function reset(){
		document.getElementById('name').value = "";
		document.getElementById('pwd').value = "";
	}
	
	function subm(evt){
		if(evt.keyCode ==13)checkForm();
	}
 </script>
	</head>
	<body onload="document.getElementById('name').focus();">
		<s:form action="loginAction!login.action" namespace="/" method="post"
			name="form1" id="form1" onsubmit="return checkForm();">
			<table width="100%" height="100%" border="0" cellspacing="0"
				cellpadding="0">
				<tr>
					<td bgcolor="#1075b1">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td height="608" background="<%=basePath%>img/login_03.gif">
						<table width="847" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td height="318" background="<%=basePath%>img/login_04_1.jpg">
									&nbsp;
								</td>
							</tr>
							<tr>
								<td height="84">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="381" height="84"
												background="<%=basePath%>img/login_06.gif">
												&nbsp;
											</td>
											<td width="162" valign="middle"
												background="<%=basePath%>img/login_07.gif">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													${msg}
													<tr>
														<td width="44" height="24" valign="bottom">
															<div align="right">
																<span class="STYLE3">用户</span>
															</div>
														</td>
														<td width="10" valign="bottom">
															&nbsp;
														</td>
														<td height="24" colspan="2" valign="bottom">
															<div align="left">
																<input type="text" name="name" id="name"
																	style="width: 100px; height: 17px; background-color: #87adbf; border: solid 1px #153966; font-size: 12px; color: #283439;">
															</div>
														</td>
													</tr>
													<tr>
														<td height="24" valign="bottom">
															<div align="right">
																<span class="STYLE3">密码</span>
															</div>
														</td>
														<td width="10" valign="bottom">
															&nbsp;
														</td>
														<td height="24" colspan="2" valign="bottom">
															<input type="password" name="pwd" id="pwd" onkeyup="subm(event);"
																style="width: 100px; height: 17px; background-color: #87adbf; border: solid 1px #153966; font-size: 12px; color: #283439;">
														</td>
													</tr>
													<tr></tr>
												</table>
											</td>
											<td width="26">
												<img src="<%=basePath%>img/login_08.gif" width="26"
													height="84">
											</td>
											<td width="67" background="<%=basePath%>img/login_09.gif">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td height="25">
															<div align="center">
																<img src="<%=basePath%>img/dl.gif" width="57" onclick="checkForm();"
																	height="20">
															</div>
														</td>
													</tr>
													<tr>
														<td height="25">
															<div align="center">
																<img src="<%=basePath%>img/cz.gif" width="57" onclick="reset();"
																	height="20">
															</div>
														</td>
													</tr>
												</table>
											</td>
											<td width="211" background="<%=basePath%>img/login_10.gif">
												&nbsp;
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="206" background="<%=basePath%>img/login_11.gif">
									&nbsp;
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td bgcolor="#152753">
						&nbsp;
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>
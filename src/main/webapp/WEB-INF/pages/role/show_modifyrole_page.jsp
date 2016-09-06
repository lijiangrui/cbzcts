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
  <script type="text/javascript" src="<%=basePath%>js/jquery-1.8.2.min.js"></script>
  <script type="text/javascript" src="<%=basePath%>js/user.js"></script>
  <script type="text/javascript">
 	$(function($) {
		$menu = $('#menu');
 		$(":checkbox[name='menubox']").each(function(i){
 			if($menu.val().indexOf(this.value) !=-1){
	 			$(this).attr("checked","checked");
 			}
 		});
 		if($('#chaRight').val()=="true"){
	 		$('#cha').attr("checked",true);
 		}else{
 			$('#cha').attr("checked",false);
 		}
	});
  </script>
  </head>
  
  <body>
	  <s:form id="form" action="modify!modify.action" namespace="/role">
		<table>
			<tr>
				<td>角色名称：</td>
				<td>
				<input id="name" name="name" value="${role.name}" />
				<input type="hidden" name="id" value="${role.id}" />
				<input type="hidden" name="deltriger" value="0" />
				</td>
			</tr>
			<tr>
				<td>
					菜单权限：
				</td>
				<td>
					<div>
						<div><B>个人中心</B></div>
						<div>
							<span><input type="checkbox" name="menubox" onclick="menuVal();" value="a"  checked="checked" disabled="disabled">修改密码</input></span>
							<span><input type="checkbox" name="menubox" onclick="menuVal();" value="b"  checked="checked" disabled="disabled">操作记录</input></span>
						</div>
					</div>
					<div>
						<div><B>用户管理</B></div>
						<div>
							<span><input type="checkbox" name="menubox" onclick="menuVal();" value="c" >新增用户</input></span>
							<span><input type="checkbox" name="menubox" onclick="menuVal();" value="d" >人员列表</input></span>
						</div>
					</div>
					<div>
						<div><B>企业管理</B></div>
						<div>
							<span><input type="checkbox" name="menubox" onclick="menuVal();" value="e" >企业录入</input></span>
							<span><input type="checkbox" name="menubox" onclick="menuVal();" value="r" >证书录入</input></span>
							<span><input type="checkbox" name="menubox" onclick="menuVal();" value="q" >产品录入</input></span>
							<span><input type="checkbox" name="menubox" onclick="menuVal();" value="f" >企业列表</input></span>
							<span><input type="checkbox" name="menubox" onclick="menuVal();" value="s" >证书列表</input></span>
							<span><input type="checkbox" name="menubox" onclick="menuVal();" value="t" >产品列表</input></span>
						</div>
					</div>
					<div>
						<div><B>分类维护</B></div>
						<div>
							<span><input type="checkbox" name="menubox" onclick="menuVal();" value="g" >角色分类</input></span>
							<span><input type="checkbox" name="menubox" onclick="menuVal();" value="h" >部门分类</input></span>
							<span><input type="checkbox" name="menubox" onclick="menuVal();" value="i" >巡检项目分类</input></span>
							<span><input type="checkbox" name="menubox" onclick="menuVal();" value="j" >收费项目分类</input></span>
						</div>
					</div>
					<div>
						<div><B>巡检管理</B></div>
						<div>
							<span><input type="checkbox" name="menubox" onclick="menuVal();" value="k" >巡检录入</input></span>
							<span><input type="checkbox" name="menubox" onclick="menuVal();" value="l" >巡检管理</input></span>
						</div>
					</div>
					<div>
						<div><B>收费管理</B></div>
						<div>
							<span><input type="checkbox" name="menubox" onclick="menuVal();" value="m" >收费录入</input></span>
							<span><input type="checkbox" name="menubox" onclick="menuVal();" value="n" >收费管理</input></span>
						</div>
						<input type="hidden" id="menu" name="menu" value="${role.menu}">
					</div>
					<div>
						<span><input type="checkbox" name="menubox" onclick="menuVal();" value="o" ><B>综合检索</B></input></span>
					</div>
					<div>
						<span><input type="checkbox" name="menubox" onclick="menuVal();" value="p" ><B>最新动态</B></input></span>
					</div>
				</td>
			</tr>
			<tr>
				<td>角色权限</td>
				<td>
					<input type="checkbox" name='cha' id="cha" onclick="document.getElementById('chaRight').value=this.checked;">编辑</input>
					<input type="hidden" name="chaRight" id="chaRight" value="${role.chaRight}">
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

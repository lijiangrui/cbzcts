<%@ page language="java" import="java.util.*,com.jbl.pagemodel.User" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	User user = (User)session.getAttribute("currentuser");
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/changeColor.js"></script>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

a {
	text-decoration: none;
	color: #000
}

.left-fenlei {
	text-align: center;
	width: 147px;
	height: 23px;
	border: 0;
	color: #FFF;
	font-weight: bold;
	font-size: 12px;
	background: url(<%=basePath%>img/main_34.gif);
}

.yewu {
	color: #FFF;
	line-height: 23px;
	font-weight: bold;
}

.left {
	
}

.left-text {
	line-height: 23px;
	display: none;
	font-size: 12px;
}
-->
</style>
<script type="text/javascript">
	$(function() {
		$('.left-fenlei').on('click', function() {
			$(this).next('.left-text').toggle();
		})
	})
</script>
</head>

<body>
	<div>
		<div class="left-fenlei">
			<span class="yewu"><a href="#">个人中心</a> </span>
		</div>

		<div class="left-text">

			<!--二级菜单-->
			<div>
				<div style=" background:none; " class="left-fenlei">
					<span style=" font-weight:normal;" class="yewu"><a href="<%=basePath%>user/showmodifypwd!showModifyPwdPage.action" onclick="changeColor(this)" target="right">修改密码</a> </span>
				</div>
			</div>
			<div>
				<div style=" background:none; " class="left-fenlei">
					<span style=" font-weight:normal;" class="yewu"><a href="<%=basePath%>record/recordAction!record0List.action" onclick="changeColor(this)" target="right">操作记录</a> </span>
				</div>
			</div>
			<div>
				<div style=" background:none; " class="left-fenlei">
					<span style=" font-weight:normal;" class="yewu"><a href="<%=basePath%>/exitAction!exit.action" onclick="changeColor(this)" target="_top">退出系统</a> </span>
				</div>
			</div>
			<!--二级菜单-->

		</div>

		<div style="clear:both"></div>
	</div>
	<div>
		<div class="left-fenlei">
			<span class="yewu"><a href="#">用户管理</a> </span>
		</div>

		<div class="left-text">

			<!--二级菜单-->
			<div>
				<div style=" background:none; " class="left-fenlei">
					<span style=" font-weight:normal;" class="yewu"><a href="<%=basePath%>user/adduser!addUser.action" onclick="changeColor(this)" target="right">新增用户</a> </span>
				</div>
			</div>
			<div>
				<div style=" background:none; " class="left-fenlei">
					<span style=" font-weight:normal;" class="yewu"><a href="<%=basePath%>user/showuserlist!showUserList.action" onclick="changeColor(this)" target="right">人员列表</a> </span>
				</div>
			</div>
			<!--二级菜单-->
		</div>

		<div style="clear:both"></div>
	</div>

	<div>
		<div class="left-fenlei">
			<span class="yewu"><a href="#">企业管理</a> </span>
		</div>

		<div class="left-text">

			<!--二级菜单-->
			<div>
				<div style=" background:none; " class="left-fenlei">
					<span style=" font-weight:normal;" class="yewu"><a href="<%=basePath%>supplier/showsupplierpage!showSupplierPage.action" onclick="changeColor(this)" target="right">企业录入</a> </span>
				</div>

				<div style=" clear:both"></div>
			</div>
			<div>
				<div style=" background:none; " class="left-fenlei">
					<span style=" font-weight:normal;" class="yewu"><a href="<%=basePath%>certificate/showcertificatepage!showCertificatePage.action" onclick="changeColor(this)" target="right">证书录入</a> </span>
				</div>

				<div style=" clear:both"></div>
			</div>
			<div>
				<div style=" background:none; " class="left-fenlei">
					<span style=" font-weight:normal;" class="yewu"><a href="<%=basePath%>product/showproductpage!showProductPage.action" onclick="changeColor(this)" target="right">产品录入</a> </span>
				</div>

				<div style=" clear:both"></div>
			</div>
			<!--二级菜单-->
			<div>
				<div style=" background:none; " class="left-fenlei">
					<span style=" font-weight:normal;" class="yewu"><a href="#">企业列表</a> </span>
				</div>
				<div class="left-text">
					<s:iterator value="#session.areaList" var="area">
						<div>
							<span style=" float:left; padding-left:60px;"><a href="<%=basePath%>supplier/showsupplierlist!showSupplierList.action?areaId=<s:property value='#area.id'/>" onclick="changeColor(this)" target="right"><s:property value="#area.name"/></a></span>
						</div>
					</s:iterator>
				</div>
				<!--三级菜单-->
				<div style=" clear:both"></div>
			</div>
			<!--二级菜单-->
			<div>
				<div style=" background:none; " class="left-fenlei">
					<span style=" font-weight:normal;" class="yewu"><a href="<%=basePath%>certificate/showcertificatelist!showCertificateList.action" onclick="changeColor(this)" target="right">证书列表</a> </span>
				</div>

				<div style=" clear:both"></div>
			</div>
			<div>
				<div style=" background:none; " class="left-fenlei">
					<span style=" font-weight:normal;" class="yewu"><a href="<%=basePath%>product/showproductlist!showProductList.action" onclick="changeColor(this)" target="right">产品列表</a> </span>
				</div>

				<div style=" clear:both"></div>
			</div>
		</div>

		<div style="clear:both"></div>
	</div>

	<div>
		<div class="left-fenlei">
			<span class="yewu"><a href="#">分类维护</a> </span>
		</div>

		<div class="left-text">

			<!--二级菜单-->
			<div>
				<div style=" background:none; " class="left-fenlei">
					<span style=" font-weight:normal;" class="yewu"><a href="<%=basePath%>role/showroles!showRoles.action" onclick="changeColor(this)" target="right">角色分类</a> </span>
				</div>
				<div style=" background:none; " class="left-fenlei">
					<span style=" font-weight:normal;" class="yewu"><a href="<%=basePath%>dept/showdepts!showDepts.action" onclick="changeColor(this)" target="right">部门分类</a> </span>
				</div>
				<div style=" background:none; " class="left-fenlei">
					<span style=" font-weight:normal;" class="yewu"><a href="<%=basePath%>type/showtypes!showTypes.action?type=patrol" onclick="changeColor(this)" target="right">巡检项目分类</a> </span>
				</div>
				<div style=" background:none; " class="left-fenlei">
					<span style=" font-weight:normal;" class="yewu"><a href="<%=basePath%>type/showtypes!showTypes.action?type=charge" onclick="changeColor(this)" target="right">收费项目分类</a> </span>
				</div>
				<div style=" clear:both"></div>
			</div>
			<!--二级菜单-->

		</div>

		<div style="clear:both"></div>
	</div>

	<div>
		<div class="left-fenlei">
			<span class="yewu"><a href="#">巡检管理</a> </span>
		</div>

		<div class="left-text">

			<!--二级菜单-->
			<div>
				<div style=" background:none; " class="left-fenlei">
					<span style=" font-weight:normal;" class="yewu"><a href="<%=basePath%>patrol/showpatrolpage!showPatrolPage.action" onclick="changeColor(this)" target="right">巡检录入</a> </span>
				</div>
			</div>
			<!--二级菜单-->
			<div>
				<div style=" background:none; " class="left-fenlei">
					<span style=" font-weight:normal;" class="yewu"><a href="<%=basePath%>patrol/showpatrollist!showPatrolList.action" onclick="changeColor(this)" target="right">巡检列表</a> </span>
				</div>
			</div>
			<!-- 
			<div>
				<div style=" background:none; " class="left-fenlei">
					<span style=" font-weight:normal;" class="yewu"><a href="<%=basePath%>patrol/showsearchpage!showSearchPage.action" onclick="changeColor(this)" target="right">巡检检索</a> </span>
				</div>
			</div>
			 -->
		</div>
		<div style="clear:both"></div>
	</div>
	
	<div>
		<div class="left-fenlei">
			<span class="yewu"><a href="#">收费管理</a> </span>
		</div>

		<div class="left-text">

			<!--二级菜单-->
			<div>
				<div style=" background:none; " class="left-fenlei">
					<span style=" font-weight:normal;" class="yewu"><a href="<%=basePath%>charge/showchargepage!showChargePage.action" onclick="changeColor(this)" target="right">收费录入</a> </span>
				</div>
			</div>
			<!--二级菜单-->
			<div>
				<div style=" background:none; " class="left-fenlei">
					<span style=" font-weight:normal;" class="yewu"><a href="<%=basePath%>charge/showchargelist!showChargeList.action" onclick="changeColor(this)" target="right">收费列表</a> </span>
				</div>
			</div>
			<!-- 
			<div>
				<div style=" background:none; " class="left-fenlei">
					<span style=" font-weight:normal;" class="yewu"><a href="<%=basePath%>charge/showsearchpage!showSearchPage.action" onclick="changeColor(this)" target="right">收费检索</a> </span>
				</div>
			</div>
			 -->
		</div>
		<div style="clear:both"></div>
	</div>
	<div>
		<div class="left-fenlei">
			<span class="yewu"><a href="<%=basePath%>supplier/searchsupplierpage!searchSupplierPage.action" target="right"><font color="red">综合检索</font></a> </span>
		</div>
	</div>
	<div>
		<div class="left-fenlei">
			<span class="yewu"><a href="<%=basePath%>record/showuserrecordlist!showUserRecordList.action" target="right"><font color="red">最新动态</font></a> </span>
		</div>
	</div>
</body>
</html>

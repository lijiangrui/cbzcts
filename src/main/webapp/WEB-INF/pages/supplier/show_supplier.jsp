<%@page import="com.jbl.util.CommonUtils"%>
<%@page import="com.jbl.pagemodel.Supplier"%>
<%@page import="com.jbl.pagemodel.Certificate"%>
<%@page import="com.jbl.pagemodel.Product"%>
<%@page import="com.jbl.pagemodel.Charge"%>
<%@page import="com.jbl.pagemodel.Patrol"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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

  <link rel="stylesheet" href="<%=basePath%>css/displaytag_fit.css" type="text/css"/>
  <link rel="stylesheet" href="<%=basePath%>css/base.css" type="text/css"/>
  <style type="text/css">
  	.tr1{
  	}
  </style>
  <script type="text/javascript" src="<%=basePath%>js/jquery-1.8.2.min.js"></script>
  <script type="text/javascript" src="<%=basePath%>js/form.js"></script>
  <script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
  <script type="text/javascript" src="<%=basePath%>js/basicCheck.js"></script>
  <script type="text/javascript" src="<%=basePath%>js/supplier.js"></script>
  <script type="text/javascript">
  	function showcharge(id){
  		var basePath = "<%=basePath%>";
  		var url = basePath+"charge/showcharge!showCharge.action?id="+id;
  		window.open(url,'','height=400,width=1000,top=200,left=200,scrollbars=yes');
  	}
  	function showpatrol(id){
  		var basePath = "<%=basePath%>";
  		var url = basePath+"patrol/showpatrol!showPatrol.action?id="+id;
  		window.open(url,'','height=400,width=1000,top=200,left=200,scrollbars=yes');
  	}
  	function showcp(id){
  		var basePath = "<%=basePath%>";
  		var url = basePath+"product/showproduct!showProduct.action?id="+id;
  		window.open(url,'','height=400,width=1000,top=200,left=200,scrollbars=yes');
  	}
  	
  	function showzs(id){
  		var basePath = "<%=basePath%>";
  		var url = basePath+"certificate/showcertificate!showCertificate.action?id="+id;
  		window.open(url,'','height=400,width=1000,top=200,left=200,scrollbars=yes');
  	}
  </script>
  </head>
  <body>
	   	<table>
	   		<tr>
	   			<th colspan="4"><center>企业质量档案</center></th>
	   		</tr>
	   		<tr>
	   			<td>企业名称（公章）</td>
	   			<td><input name="name" value="${supplier.name }" >
	   			</td>
	   			<td>地址</td>
	   			<td>
	   				霸州市${supplier.areaName}
	   				
	   				<input name="position" id="position" value="${supplier.position }"/>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>组织机构代码</td>
	   			<td><input type="text" name='code' value="${supplier.code }">
	   			</td>
	   			<td>营业执照编号</td>
	   			<td><input type="text" name='license' value="${supplier.license }">
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>企业法人</td>
	   			<td><input type="text" name='legalPerson' value="${supplier.legalPerson }"></td>
	   			<td>身份证号</td>
	   			<td><input type="text" name="idNo" value="${supplier.idNo }">
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>联系人</td>
	   			<td><input type="text" name='contactPerson' value="${supplier.contactPerson }"></td>
	   			<td>联系电话</td>
	   			<td><input type="text" name='contact' value="${supplier.contact }"></td>
	   		</tr>
	   		<tr>
	   			<td>联系人1</td>
	   			<td><input type="text" name='contactPerson1' value="${supplier.contactPerson1}"></td>
	   			<td>联系电话1</td>
	   			<td><input type="text" name='contact1'  value="${supplier.contact1}"></td>
	   		</tr>
	   		<tr>
	   			<td>联系人2</td>
	   			<td><input type="text" name='contactPerson2' value="${supplier.contactPerson2}"></td>
	   			<td>联系电话2</td>
	   			<td><input type="text" name='contact2'  value="${supplier.contact2}"></td>
	   		</tr>
	   		<tr>
	   			<td>企业规模</td>
	   			<td><select id="scaleId" name="scaleId" >
	   			<option value="1">小</option>
	   			<option value="2">中</option>
	   			<option value="3">大</option>
	   			</select>
	   			<input type="hidden" name="scaleIdVal" id="scaleIdVal" value="${supplier.scaleId }"/>
	   			</td>
	   			<td>从业人数</td>
	   			<td><input type="text" name="workers" value="${supplier.workers }"></td>
	   		</tr>
	   		<tr>
	   			<td>注册资金</td>
	   			<td><input type="text" name='zcCapital' value="${supplier.zcCapital }"></td>
	   			<td>固定资产</td>
	   			<td><input type="text" name='gdCapital' value="${supplier.gdCapital }"></td>
	   		</tr>
	   		<tr>
	   			<td>成立日期</td>
	   			<td><input type="text" name='foundDate'value="${supplier.foundDate }"></td>
	   			<td>登记注册类型</td>
	   			<td><select id='zcTypeId' name='zcTypeId'>
	   				<option value="0">请选择</option>
	   				<option value="1">有限责任公司</option>
	   				<option value="2">股份公司</option>
	   				<option value="3">有限公司</option>
	   				<option value="4">个体工商户</option>
	   				<option value="5">个人独资</option>
	   				<option value="6">农村信用合作社</option>
	   				<option value="7">机关单位</option>
	   				<option value="8">社会团体法人</option>
	   				<option value="9">民办非企业登记证书</option>
	   				<option value="10">医院</option>
	   				<option value="11">学校</option>
	   				<option value="12">其他机构</option>
	   			</select>
	   			<input type="hidden" name="zcTypeIdVal" id="zcTypeIdVal" value="${supplier.zcTypeId}"/>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>产业分类</td>
	   			<td><select id="cpTypeId" name="cpTypeId">
	   				<option value='0'>请选择</option>
	   				<option value='1'>钢木家具</option>
	   				<option value='2'>机械加工</option>
	   				<option value='3'>乐器制造</option>
	   				<option value='4'>林木加工</option>
	   				<option value='5'>塑料加工</option>
	   				<option value='6'>线缆加工</option>
	   				<option value='7'>金属压延</option>
	   				<option value='8'>其他类型</option>
	   			</select>
	   			<input type="hidden" name="cpTypeIdVal" id="cpTypeIdVal" value="${supplier.cpTypeId}"/>
	   			</td>
	   			<td>
	   				生产能力
	   			</td>
	   			<td>
	   				<input type="text" id="capacity" name="capacity" value="${supplier.capacity}"/>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>年产值</td>
	   			<td>
	   				<input type="text" id="yearCapacity" name="yearCapacity" value="${supplier.yearCapacity}" />
	   			</td>
	   			<td>年利润</td>
	   			<td>
	   				<input type="text" id="yearProfit" name="yearProfit" value="${supplier.yearProfit}" />
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>年纳税</td>
	   			<td>
	   				<input type="text" id="yearTax" name="yearTax" value="${supplier.yearTax}" />
	   			</td>
	   			<td>销售流向</td>
	   			<td>
	   				<input type="text" id="saleTo" name="saleTo" value="${supplier.saleTo}" />
	   			</td>
	   		</tr>
	   		</tr>
	   		<%
	   			Supplier su = (Supplier)request.getAttribute("supplier");
	   				List<Certificate> clist = su.getClist();
	   				List<Product> plist = su.getPlist();
	   				List<Patrol> palist = su.getPalist();
	   				List<Charge> chlist = su.getChlist();
	   		%>
	   		<tr>
	   			<td>所有产品</td>
	   			<td colspan="3">
	   				<%
	   					if(plist != null){
	   					   						for(Product p : plist){
	   					   							String name = p.getName();
	   					   							int id = p.getId();
	   				%>
	   								<a href="#" onclick="showcp(<%=id%>);"><%=name%></a>
	   							<%
	   								}
	   								   					}
	   							%>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>所有证书</td>
	   			<td colspan="3">
	   				<%
	   					if(CommonUtils.isNotNull(clist)){
	   					   						for(Certificate c : clist){
	   					   							String name = c.getName();
	   					   							int id = c.getId();
	   				%>
	   								<a href="#" onclick="showzs(<%=id%>);"><%=name%></a>
	   							<%
	   								}
	   								   					}
	   							%>
	   			</td>
	   		</tr>
	   	</table>
	   	<table>
	   		<tr>
	   			<td colspan="3">巡检流水号</td>
	   		</tr>
	   		<tr>
	   			<td colspan='3'>
	   			<%
	   				if(CommonUtils.isNotNull(palist)){
	   						for(Patrol patrol : palist){
	   							String serialNo = patrol.getSerialNo();
	   							Integer id = patrol.getId();
	   			%>
		   				<a href="#" onclick="showpatrol(<%=id%>);"><%=serialNo%></a>
		   				<%
		   					}
		   						}
		   				%>
	   			</td>
	   		</tr>
	   	</table>
	   	<table>
	   		<tr>
	   			<td colspan="3">收费流水号</td>
	   		</tr>
	   		<tr>
	   			<td colspan='3'>
	   			<%
	   				if(CommonUtils.isNotNull(chlist)){
	   				   				for(Charge charge : chlist){
	   				   					String serialNo = charge.getSerialNo();
	   				   					Integer id = charge.getId();
	   			%>
		   				<a href="#" onclick="showcharge(<%=id%>);"><%=serialNo%></a>
		   				<%
		   			}
	   			}
	   			%>
	   			</td>
	   		</tr>
	   	</table>
  </body>
  <script type="text/javascript">
  	$(function(){
  		rebackSel("cpTypeId");
  		rebackSel("zcTypeId");
  		rebackSel("scaleId");
  	})
  	function rebackSel(selectId){
  		$("#"+selectId+" option").each(function(){
  			if($(this).val()==$("#"+selectId+"Val").val()){
  				$(this).attr("selected",true);
  			}
  		});
  	}
  </script>
</html>

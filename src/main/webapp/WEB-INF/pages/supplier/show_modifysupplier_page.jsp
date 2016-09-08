<%@page import="com.jbl.util.CommonUtils"%>
<%@page import="com.jbl.pagemodel.Supplier"%>
<%@page import="com.jbl.pagemodel.Certificate"%>
<%@page import="com.jbl.pagemodel.Product"%>
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
  <script type="text/javascript">
  var i = 1;
  function addTr(obj){
    i = i+1;
  	$('.tr1').last().after("<tr id='tr' class='tr1'>"+
								"<td><input type='checkbox'></td>"+
									"<td>"+i+"</td>"+
									"<td>"+
										"<select name='clist["+i+"].type'>"+
											"<option value='0'>请选择</option>"+
											"<option value='1'>行政许可证</option>"+
											"<option value='2'>自愿性认证</option>"+
										"</select>"+
									"</td>"+
									"<td>"+
										"<input name='clist["+i+"].no'>"+
									"</td>"+
			   						"<td>"+
										"<input name='clist["+i+"].unit'>"+
									"</td>"+
			   						"<td>"+
			   							"<input name='clist["+i+"].validate' onclick='WdatePicker();'>"+
			   						"</td>"+
								"</tr>");
  }
  
  function delTr(){
  	var $items = $(':checkbox');
	for(var j=0;j<$items.length;j++){
  		if($items[j].checked ){
  			var $tr = $($items[j]).parent().parent().remove();
  		}
  	}
  }
  </script>
  <script type="text/javascript">
  	$(function($){
  		$('#scaleId>option').each(function(){
  			if($('#scaleIdVal').val()==this.value){
  				$(this).attr("selected","selected");
  			}
  		});
  		$('#zcTypeId>option').each(function(){
  			if($('#zcTypeIdVal').val()==this.value){
  				$(this).attr("selected","selected");
  			}
  		});
  		$('#cpTypeId>option').each(function(){
  			if($('#cpTypeIdVal').val()==this.value){
  				$(this).attr("selected","selected");
  			}
  		});
  		checkCode($('#code').val(),'span2');
  		checkID($('#idNo').val(),'span3');
  		checkLicense($('#license').val(),'span4');
  	});
  </script>
  <script type="text/javascript">
  	function modifycp(id){
  		var basePath = "<%=basePath%>";
  		var url = basePath+"product/showmodifypage!showModifyPage.action?id="+id;
  		window.open(url,'','height=400,width=1000,top=200,left=200,scrollbars=yes');
  	}
  	
  	function modifyzs(id){
  		var basePath = "<%=basePath%>";
  		var url = basePath+"certificate/showmodifypage!showModifyPage.action?id="+id;
  		window.open(url,'','height=400,width=1000,top=200,left=200,scrollbars=yes');
  	}
  </script>
  <style>
  	span{color:red;}
  </style>
  </head>
  <body>
   	<s:form id="form" action="modify!modify.action" namespace="/supplier">
	   	<table>
	   		<tr>
	   			<th colspan="4"><center>企业质量档案录入</center></th>
	   			<input type="hidden" id="templateName" name="templateName" value="" />
	   		</tr>
	   		<tr>
	   			<td>企业名称（公章）</td>
	   			<td><input name="name" value="${supplier.name}">
	   			<input type="hidden" id="id" name="id" value="${supplier.id}" />
	   			</td>
	   			<td>地址</td>
	   			<td>
	   				<select>
	   					<option>霸州市</option>
	   				</select>
	   				${areaHTML}
	   				<input name="position" id="position" value="${supplier.position}"/>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>组织机构代码</td>
	   			<td><input type="text" id="code" name='code' value="${supplier.code}" readonly="readonly" >
	   			</td>
	   			<td>营业执照编号</td>
	   			<td><input type="text" id="license" name='license' value="${supplier.license}" readonly='readonly' >
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>企业法人</td>
	   			<td><input type="text" name='legalPerson' value="${supplier.legalPerson}"></td>
	   			<td>身份证号</td>
	   			<td><input type="text" id="idNo" name="idNo" value="${supplier.idNo}">
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>联系人</td>
	   			<td><input type="text" name='contactPerson' value="${supplier.contactPerson}"></td>
	   			<td>联系电话</td>
	   			<td><input type="text" name='contact' value="${supplier.contact}" ></td>
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
	   			<td><select id="scaleId" name="scaleId">
	   			<option value="1">小</option>
	   			<option value="2">中</option>
	   			<option value="3">大</option>
	   			</select>
	   			<input type="hidden" id="scaleIdVal" value="${supplier.scaleId}" />
	   			</td>
	   			<td>从业人数</td>
	   			<td><input type="text" name="workers"  value="${supplier.workers}" ></td>
	   		</tr>
	   		<tr>
	   			<td>注册资金</td>
	   			<td><input type="text" name='zcCapital' value="${supplier.zcCapital}"></td>
	   			<td>固定资产</td>
	   			<td><input type="text" name='gdCapital' value="${supplier.gdCapital}"></td>
	   		</tr>
	   		<tr>
	   			<td>成立日期</td>
	   			<td><input type="text" name='foundDate' value="${supplier.foundDate}" onclick="WdatePicker();"></td>
	   			<td>登记注册类型</td>
	   			<td><select id="zcTypeId" name='zcTypeId'>
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
	   			<input type="hidden" id="zcTypeIdVal" value="${supplier.zcTypeId}" />
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
	   			<input type="hidden" id="cpTypeIdVal" value="${supplier.cpTypeId}" />
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
	   		<%
	   			Supplier su = (Supplier)request.getAttribute("supplier");
	   				List<Certificate> clist = su.getClist();
	   				List<Product> plist = su.getPlist();
	   		%>
	   		<tr>
	   			<td>所有产品</td>
	   			<td colspan="3">
	   				<%
	   					if(CommonUtils.isNotNull(plist)){
	   					   						for(Product p : plist){
	   					   							String name = p.getName();
	   					   							int id = p.getId();
	   				%>
	   								<a href="#" onclick="modifycp(<%=id%>);"><%=name%></a>
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
	   								<a href="#" onclick="modifyzs(<%=id%>);"><%=name%></a>
	   							<%
	   						}
	   					}
	   				%>
	   			</td>
	   		</tr>
	   		<!-- tr>
	   			<td>产品名称</td>
	   			<td><input type="text" name='product' value="${supplier.product}"></td>
	   		</tr>
	   		<tr>
	   			<td>生产能力</td>
	   			<td><input name="capacity" value="${supplier.capacity}"></td>
	   			<td>年产值</td>
	   			<td><input name="yearCapacity" value="${supplier.yearCapacity}"></td>
	   		</tr>
	   		<tr>
	   			<td>年利润</td>
	   			<td><input name="yearProfit" value="${supplier.yearProfit}"></td>
	   			<td>年纳税</td>
	   			<td><input name="yearTax" value="${supplier.yearTax}"></td>
	   		</tr>
	   		<tr>
	   			<td>销售流向：</td>
	   			<td colspan="3"><textarea name="saleTo" cols="97" rows="1" >${supplier.saleTo}</textarea></td>
	   		</tr>
	   		 -->
	   		<tr>
	   			<td colspan='4'>
	   				<img src="<%=basePath%>img/submit.gif" style="width:50px;height:20" onclick="submit();">
	   				<img src="<%=basePath%>img/reset.gif" style="width:50px;height: 20" onclick="reset();">
	   				<!-- img src="<%=basePath%>img/reset.gif" style="width:50px;height: 20" onclick="saveTemplate();" -->
	   			</td>
	   		</tr>
	   	</table>
   	</s:form>
  </body>
</html>

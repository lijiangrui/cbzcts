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
  	.tr0{}
  	.tr1{
  	}
  </style>
  <script type="text/javascript" src="<%=basePath%>js/jquery-1.8.2.min.js"></script>
  <script type="text/javascript" src="<%=basePath%>js/form.js"></script>
  <script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
  <script type="text/javascript" src="<%=basePath%>js/basicCheck.js"></script>
  <script type="text/javascript" src="<%=basePath%>js/supplier.js"></script>
  <script type="text/javascript">
  var i = 1;
  var j = 1;
  function addTr(obj){
    i = i+1;
  	$('.tr1').last().after("<tr id='tr' class='tr1'>"+
								"<td><input type='checkbox'></td>"+
									"<td>"+
										"<select name='clist["+i+"].type'>"+
											"<option value='0'>请选择</option>"+
			   								"<option value='1'>业务类型</option>"+
			   								"<option value='2'>质量管理</option>"+
			   								"<option value='3'>认证管理</option>"+
			   								"<option value='4'>认证认可</option>"+
			   								"<option value='5'>执行标准</option>"+
			   								"<option value='6'>食品相关产品</option>"+
			   								"<option value='7'>生产许可证</option>"+
			   								"<option value='8'>特种设备</option>"+
			   								"<option value='9'>自愿性认证</option>"+
			   								"<option value='10'>其他业务</option>"+
										"</select>"+
									"</td>"+
									"<td>"+
										"<input name='clist["+i+"].name'>"+
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
  
  function addTr1(obj){
	    j = j+1;
	  	$('.tr0').last().after("<tr id='tr0' class='tr0'>"+
									"<td>"+
										"<input type='checkbox'>"+
									"</td>"+
					   			"<td>"+
					   				"<input name='plist["+j+"].name'>"+
					   			"</td>"+
					   			"<td><input name='plist["+j+"].capacity'></td>"+
					   			"<td><input name='plist["+j+"].yearCapacity'></td>"+
					   			"<td><input name='plist["+j+"].yearProfit'></td>"+
					   			"<td><input name='plist["+j+"].yearTax'></td>"+
					   			"<td><input name='plist["+j+"].saleTo'></td>"+
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
  	function saveTemplate(){
  		var templateName = prompt("请输入模板名称：");
  		if(templateName ==null){
  			alert("模板名称不能为空");
  			return false;
  		}else{
  			$('#templateName').val(templateName);
  		}
  		$.post("supplierAction!saveTemplate.action",$('#form').serialize());
  	}
  	
  	function importTemplate(){
  		//$.get("importtemplate!importTemplate.action",function(data){});
  		$("p").dialog({
  			wdith:300,
  			height:200
  		}).dialog("open");
  		
  	}
  	
  </script>
  </head>
  <body>
   	<s:form id="form" action="searchlist!searchList.action" namespace="/supplier">
	   	<table>
	   		<tr>
	   			<th colspan="4"><center>企业质量档案录入</center></th>
	   			<input type="hidden" id="templateName" name="templateName" value="" />
	   		</tr>
	   		<tr>
	   			<td>企业名称（公章）</td>
	   			<td><input name="name" >
	   			<!-- <img src="<%=basePath%>img/reset.gif" style="width:50px;height: 20" onclick="importTemplate();"> -->
	   			</td>
	   			<td>地址</td>
	   			<td>
	   				<select>
	   					<option>霸州市</option>
	   				</select>
	   				${areaHTML}
	   				<input name="position" id="position"/>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>统一社会信用代码</td>
	   			<td><input type="text" name='code'>
	   			
	   			</td>
	   			<td>营业执照编号</td>
	   			<td><input type="text" name='license'>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>企业法人</td>
	   			<td><input type="text" name='legalPerson'></td>
	   			<td>身份证号</td>
	   			<td><input type="text" name="idNo" >
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>联系人</td>
	   			<td><input type="text" name='contactPerson'></td>
	   			<td>联系电话</td>
	   			<td><input type="text" name='contact' ></td>
	   		</tr>
	   		<tr>
	   			<td>联系人1</td>
	   			<td><input type="text" name='contactPerson1'></td>
	   			<td>联系电话1</td>
	   			<td><input type="text" name='contact1' ></td>
	   		</tr>
	   		<tr>
	   			<td>联系人2</td>
	   			<td><input type="text" name='contactPerson2'></td>
	   			<td>联系电话2</td>
	   			<td><input type="text" name='contact2' ></td>
	   		</tr>
	   		<tr>
	   			<td>企业规模</td>
	   			<td><select id="scaleId" name="scaleId">
	   			<option value="0">请选择</option>
	   			<option value="1">小</option>
	   			<option value="2">中</option>
	   			<option value="3">大</option>
	   			</select></td>
	   			<td>从业人数</td>
	   			<td><input type="text" name="workers"></td>
	   		</tr>
	   		<tr>
	   			<td>注册资金</td>
	   			<td><input type="text" name='zcCapital'></td>
	   			<td>固定资产</td>
	   			<td><input type="text" name='gdCapital'></td>
	   		</tr>
	   		<tr>
	   			<td>成立日期</td>
	   			<td><input type="text" name='foundDate' onclick="WdatePicker();"></td>
	   			<td>登记注册类型</td>
	   			<td><select name='zcTypeId'>
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
	   			</select></td>
	   		</tr>
	   		<tr>
	   			<td>产业分类</td>
	   			<td colspan="3"><select name="cpTypeId">
	   				<option value='0'>请选择</option>
	   				<option value='1'>钢木家具</option>
	   				<option value='2'>机械加工</option>
	   				<option value='3'>乐器制造</option>
	   				<option value='4'>林木加工</option>
	   				<option value='5'>塑料加工</option>
	   				<option value='6'>线缆加工</option>
	   				<option value='7'>金属压延</option>
	   				<option value='8'>其他类型</option>
	   			</select></td>
	   		</tr>
	   		<tr>
	   			<td colspan="4">所有产品</td>
	   		</tr>
	   		<tr>
	   			<td colspan="4">
	   				<table>
	   					<tr>
	   						<td></td>
	   						<td>产品名称</td>
	   						<td>生产能力</td>
	   						<td>年产值</td>
	   						<td>年利润</td>
	   						<td>年纳税</td>
	   						<td>销售流向</td>
	   					</tr>
	   					<tr id='tr0' class='tr0'>
	   						<td>
	   							<input type="checkbox" disabled="disabled">
	   						</td>
				   			<td>
				   				<input name='plist[0].name'>
				   			</td>
				   			<td><input name='plist[0].capacity'></td>
				   			<td><input name='plist[0].yearCapacity'></td>
				   			<td><input name='plist[0].yearProfit'></td>
				   			<td><input name='plist[0].yearTax'></td>
				   			<td><input name='plist[0].saleTo'></td>
				   		</tr>
				   		<tr>
				   			<td colspan="7">
					   			<img src="<%=basePath%>img/addItem.gif" width="20" height="20" onclick="addTr1();"></img>
					   			<img src="<%=basePath%>img/delItem.gif" width="20" height="20" onclick="delTr()"></img>
				   			</td>
			 			</tr>
	   				</table>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td colspan="4" bgcolor="#F5BFB2">所获证书</td>
	   		</tr>
	   		<tr>
	   			<td colspan="4">
	   				<table>
	   					<tr>
	   						<td></td>
	   						<td>证书类型</td>
	   						<td>项目名称</td>
	   						<td>编号代码</td>
	   						<td>发证单位</td>
	   						<td>有效截止日期</td>
	   					</tr>
	   					<tr id="tr" class="tr1">
	   						<td><input type="checkbox" disabled="disabled"></td>
	   						<td>
	   							<select name="clist[0].type" id="type">
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
	   						</td>
	   						<td>
	   							<input name="clist[0].name">
	   						</td>
	   						<td>
								<input name="clist[0].no">
							</td>
	   						<td>
								<input name="clist[0].unit">
							</td>
	   						<td>
	   							<input name="clist[0].validate"  onclick="WdatePicker();">
	   						</td>
	   					</tr>
	   					<tr>
				   			<td colspan="7">
					   			<img src="<%=basePath%>img/addItem.gif" width="20" height="20" onclick="addTr();"></img>
					   			<img src="<%=basePath%>img/delItem.gif" width="20" height="20" onclick="delTr()"></img>
				   			</td>
	   					</tr>
	   				</table>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td colspan='4'>
	   				<input type="submit" value="查询" />
	   				<!-- <img src="<%=basePath%>img/submit.gif" style="width:50px;height:20" onclick="submit();">
	   				img src="<%=basePath%>img/reset.gif" style="width:50px;height: 20" onclick="saveTemplate();" -->
	   			</td>
	   		</tr>
	   	</table>
   	</s:form>
  </body>
</html>

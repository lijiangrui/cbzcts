<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	 <link rel="stylesheet" href="<%=basePath%>css/displaytag_fit.css" type="text/css"/>
  <link rel="stylesheet" href="<%=basePath%>css/base.css" type="text/css"/>
  <link rel="stylesheet" href="<%=basePath%>css/jquery.bigautocomplete.css" type="text/css"></link>
  <script type="text/javascript" src="<%=basePath%>js/jquery-1.8.2.min.js"></script>
  <script type="text/javascript" src="<%=basePath%>js/patrol.js"></script>
  <script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
  <script type="text/javascript" src="<%=basePath%>js/jquery.bigautocomplete.js"></script>
  <script type="text/javascript" src="<%=basePath%>js/basicCheck.js"></script>
  <script type="text/javascript">
  function aaa(){
		var aid = $('#aid').val();
		$.post(
				"patrol/patrolAction!supplierJSON.action",
				{areaId:aid},
				function(data){
					$("#test").bigAutocomplete({
						width:604,
						//data:[{title:"中国好声音",result:{ff:"qq"}},{title:"中国移动网上营业厅"},{title:"中国银行"},{title:"中国移动"},{title:"中国好声音第三期"},{title:"中国好声音 第一期"},{title:"中国电信网上营业厅"},{title:"中国工商银行"},{title:"中国好声音第二期"},{title:"中国地图"}],
						data:data,
						callback:function(data){
							//alert(data.result.ff);
						}});
					
				},"json");
	}
	</script>
	<style>
	span{
		color:red;
	}
	</style>
</head>
  <body>
  	<s:form id='form' action='save!save.action' namespace='/product' onsubmit="return checkspan();">
  		<table>
			<tr>
				<td colspan="4"><h3><center>新增产品</center></h3></td>
			</tr>
			<tr>
				<td>所属企业</td>
				<td>
					${sHTML}
				</td>
			</tr>
			<tr>
  				<td>产品名称</td>
  				<td>
  					<input type="text" id="name" name="name" value="" />
  				</td>
  			</tr>
  			<tr>
  				<td>生产能力</td>
  				<td>
  					<input type="text" id="capacity" name="capacity" value="" />
  				</td>
  			</tr>
  			<tr>
  				<td>年产值</td>
  				<td>
  					<input type="text" id="yearCapacity" name="yearCapacity" value="" />
  				</td>
  			</tr>
  			<tr>
  				<td>年利润</td>
  				<td>
  					<input type="text" id="yearProfit" name="yearProfit" value="" />
  				</td> 
  			</tr>
  			<tr>
  				<td>年纳税</td>
  				<td>
  					<input type="text" id="yearTax" name ='yearTax' value="" />
  				</td>
  			</tr>
  			<tr>
  				<td>销售流向</td>
  				<td>
  					<input type="text" id="saleTo" name="saleTo" value="" />
   				</td>
  			</tr>
  			<tr>
  				<td colspan='2'>
  					<input type="submit" value="提交" />
  					<input type="reset" value="重置" />
  				</td>
  			</tr>
		</table>
  	</s:form>
  </body>
</html>

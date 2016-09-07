<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="<%=basePath%>css/byzl.css" type="text/css"></link>
<script>
var  highlightcolor='#fbe5d7';
//此处clickcolor只能用win系统颜色代码才能成功,如果用#xxxxxx的代码就不行,还没搞清楚为什么:(
var  clickcolor='#51b2f6';
function  changeto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=highlightcolor;
}
}

function  changeback(){
if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
return
if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
//source.style.backgroundColor=originalcolor
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}

function  clickto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=clickcolor&&source.id!="nc")
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=clickcolor;
}
else
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}
</script>
</head>

<body>
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="24" bgcolor="#314F76"><table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td><table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td width="94%" valign="bottom"><span class="STYLE1">欢迎使用质检技术监督规范化管理平台</span>
												</td>
											</tr>
										</table>
									</td>
									<td>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<!-- tr>
						<td style="color:red;font-weight: bold;">更新内容</td>
					</tr>
					<tr>
						<td>
							<table>
								<tr>
									<td>2015-03-19</td>
								</tr>
								<tr>
									<td>新增用户完成，可以配置查看菜单权限。</td>
								</tr>
								<tr>
									<td>2015-04-23</td>
								</tr>
								<tr>
									<td>企业录入完成，企业列表完成，还不能编辑、删除。</td>
								</tr>
								<tr><td>
									问题：企业档案批量录入不太好实现，因为每个企业证书有多个，用Excel表不好对应企业。而且填写Excel不比单个录入效率高。
								</td></tr>
								<tr>
								<td>2015-06-04
								</td></tr>
								<tr><td>
								对组织机构代码、营业执照编号身份证ID做了验证。增加巡检功能
								</td></tr>
								<tr>
								<td>2015-06-19
								</td></tr>
								<tr><td>
								优化搜索功能，增加菜单功能
								</td></tr>
							</table>
						</td>
					</tr -->
				</table>
			</td>
		</tr>
	</table>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {
	font-size: 12px;
	color: #000000;
}
.STYLE5 {font-size: 12}
.STYLE7 {font-size: 12px; color: #FFFFFF; }
a img { border:none;}
</style>
<script type="text/javascript">
	
function show(){
	var date = new Date(); //日期对象
	var now = "";
	var hour = date.getHours();
	var mins = date.getMinutes();
	var second = date.getSeconds();
	if(hour <10)hour = "0"+hour;
	if(mins <10)mins = "0"+mins;
	if(second <10)second = "0"+second;
	now = date.getFullYear()+"-"; //读英文就行了
	now = now + (date.getMonth()+1)+"-"; //取月的时候取的是当前月-1如果想取当前月+1就可以了
	now = now + date.getDate()+" ";
	now = now + hour+":";
	now = now + mins+":";
	now = now + second+"";
	document.getElementById("nowDiv").innerHTML = now; //div的html是now这个字符串
	setTimeout("show()",1000); //设置过1000毫秒就是1秒，调用show方法
	} 
</script>
</head>

<body onload="show()">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td class="topbj" height="57" background="<%=basePath%>img/main_03.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="351" height="57" background="<%=basePath%>img/main_03-10.gif">&nbsp;</td>
        <td>&nbsp;</td>
        <td width="281" valign="bottom"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="33" height="27"><img src="<%=basePath%>img/main_05.gif" width="33" height="27" /></td>
            <td width="248" background="<%=basePath%>img/main_06.gif"><table width="225" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
              	<td><div align="right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div></td>
                <td height="17"><div align="right"><a href="<%=basePath%>user/showmodifypwd!showModifyPwdPage.action" target="right"><img src="<%=basePath%>img/pass.gif" width="69" height="17" /></a></div></td>
                <td><div align="right"><a href="<%=basePath%>/exitAction!exit.action" target="_top"><img src="<%=basePath%>img/quit.gif" width="69" height="17" /></a></div></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="40" background="<%=basePath%>img/main_10.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="194" height="40" background="<%=basePath%>img/main_10.gif">&nbsp;</td>
        <td></td>
        <td width="248" background="<%=basePath%>img/main_11.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="16%"><span class="STYLE5"></span></td>
            <td width="75%"><div align="center"><span class="STYLE7">服务器时间：<span id="nowDiv"></span>
            </span></div></td>
            <td width="9%">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="30" background="<%=basePath%>img/main_31.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="8" height="30"><img src="<%=basePath%>img/main_28.gif" width="8" height="30" /></td>
        <td width="147" background="<%=basePath%>img/main_29.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="24%">&nbsp;</td>
            <td width="43%" height="20" valign="bottom" class="STYLE1">管理菜单</td>
            <td width="33%">&nbsp;</td>
          </tr>
        </table></td>
        <td width="39"><img src="<%=basePath%>img/main_30.gif" width="39" height="30" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="20" valign="bottom"><span class="STYLE1">当前登录用户：${sessionScope.currentuser.name } &nbsp;用户角色：${sessionScope.currentuser.rolename}</span></td>
            <td valign="bottom" class="STYLE1"><div align="right"><img src="<%=basePath%>img/sj.gif" width="6" height="7" /> IP：${sessionScope.ip }       &nbsp; &nbsp;&nbsp;<img src="<%=basePath%>img/sj.gif" width="6" height="7" /> &nbsp;部门: ${sessionScope.currentuser.deptname } &nbsp; &nbsp; </div></td>
          </tr>
        </table></td>
        <td width="17"><img src="<%=basePath%>img/main_32.gif" width="17" height="30" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>

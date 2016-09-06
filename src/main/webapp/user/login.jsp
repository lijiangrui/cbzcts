<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
$(function(){
	$('#user_login_form').form({
  			url:'${pageContext.request.contextPath}/loginAction!login.action',
  			data: $('#user_login_form').serialize(),
  			success:function (r, textStatus) {
  						var obj = $.parseJSON(r);
  						if(obj.success){
			  				$('#user_login_dialog').dialog('close');
			  			}
	  					$.messager.show({
	  						title:'提示',
	  						msg:obj.msg,
	  						timeout:3000,
	  						showType:'slide'
	  					});
					}
	});
	$('#user_login_form input').bind('keyup',function(event){/*增加回车提交功能*/
		if(event.keyCode=='13'){
			$('#user_login_form').submit();
		}		
	});
	window.setTimeout(function(){
		$('#user_login_form input[name=name]').focus();
	},0);
});

</script>
<div id="user_login_dialog"  class="easyui-dialog" data-options="title:'登陆',closable:false,modal:true,buttons:[{
    	text:'登陆',
    	iconCls:'icon-reset',
    	icoCls:'icon-ok',
    	handler:function(){
    		if($('#user_login_form').form('validate')){
	  			$.ajax({
	  	  			url:'${pageContext.request.contextPath}/loginAction!login.action',
	  	  			data: $('#user_login_form').serialize(),
	  	  			dataType:'json',
	  	  			success:function (obj, textStatus) {
	  							if(obj.success){
	  			  					$('#user_login_dialog').dialog('close');
	  			  				}
	  		  					$.messager.show({
	  		  						title:'提示',
	  		  						msg:obj.msg,
	  		  						timeout:5000,
	  		  						showType:'slide'
	  		  					});
	  						}
	  	  		});
	  		}else{
	  			alert(1);
	  		}
    	}
    },{
    	text:'注册',
    	iconCls:'icon-login',
    	handler:function(){   
    		$('#user_register_form input').val('');
    		$('#user_register_dialog').dialog('open');
    	}
    }]">
    <form id="user_login_form" method="post">
    	<table>
    		<tr>
    			<th>登录名</th>
    			<td><input name="name" class="easyui-validatebox" data-options="required:true,missingMessage:'登录名必填！'"></td>
    			
    		</tr>
    		<tr>
    			<th>密码</th>
    			<td><input type="password" name="pwd" class="easyui-validatebox" data-options="required:true,missingmessage:'密码必填！'"></td>
    			
    		</tr>
    	</table>
    	</form>
    </div>

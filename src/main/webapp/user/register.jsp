<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
$(function(){
	$('#user_register_form').form({
  			url:'${pageContext.request.contextPath}/userAction!register.action',
  			data: $('#user_register_form').serialize(),
  			success:function (r, textStatus) {
  						var obj = $.parseJSON(r);
						if(obj.success){
		  					$('#user_register_dialog').dialog('close');
		  				}
	  					$.messager.show({
	  						title:'提示',
	  						msg:obj.msg,
	  						timeout:3000,
	  						showType:'slide'
	  					});
					}
	});
	$('#user_register_form input').bind('keyup',function(event){/*增加回车提交功能*/
		if(event.keyCode=='13'){
			$('#user_register_form').submit();
		}		
	});
});
</script>

<div id="user_register_dialog" class="easyui-dialog" data-options="closed:true,title:'注册',closable:true,modal:true,buttons:[{
    	text:'注册',
    	iconCls:'icon-ok',
    	handler:function(){
    		if($('#user_register_form').form('validate')){
	  			$.ajax({
	  	  			url:'${pageContext.request.contextPath}/userAction!register.action',
	  	  			data: $('#user_register_form').serialize(),
	  	  			dataType:'json',
	  	  			success:function (obj, textStatus) {
	  							if(obj.success){
	  			  					$('#user_register_dialog').dialog('close');
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
    }]">
	    <form id="user_register_form" method="post">
	    	<table>
	    		<tr>
	    			<th>注册名</th>
	    			<td><input class="easyui-validatebox" data-options="required:true" name="name"></td>
	    			
	    		</tr>
	    		<tr>
	    			<th>密码</th>
	    			<td><input type="password" class="easyui-validatebox" data-options="required:true" name="pwd"></td>
	    			
	    		</tr>
	    		<tr>
	    			<th>确认密码</th>
	    			<td><input type="password" class="easyui-validatebox" data-options="required:true" name="repwd"></td>
	    			
	    		</tr>
	    	</table>
    	</form>
    </div>

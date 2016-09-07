<%@ page language="java"  pageEncoding="utf-8"%>
<script type="text/javascript">
	function addTabs(opts){
  		var t = $('#layout_center_tab');
  		if(t.tabs('exists',opts.title)){
  			t.tabs('select',opts.title);
  		}else{
  			t.tabs('add',opts);
  		}
  	}
</script>
<div class="easyui-panel" data-options="title:'功能导航',border:false,fit:true">

	<div id="layout_west_accordion" class="easyui-accordion" style="width:300px;height:200px;" data-options="border:false,fit:true">
		<div title="系统菜单" data-options="iconCls:'icon-save',selected:true" style="overflow:auto;padding:10px;">
			<ul class="easyui-tree" data-options="url:'${pageContext.request.contextPath}/menuAction!getAllTreeNode.action',lines:true,parentField:'pid',onLoadSuccess:function(node,data){
						$(this).tree('collapseAll');
					},onClick:function(node){
						if(node.attributes.url){
							var url = '${pageContext.request.contextPath}/'+node.attributes.url;
							console.info(url);
							addTabs({title:node.text,closable:true,href:url});
						}
						
					}"></ul>
		</div>
		<div title="Title2" data-options="iconCls:'icon-reload'" style="padding:10px;">content2</div>
	</div>
</div>

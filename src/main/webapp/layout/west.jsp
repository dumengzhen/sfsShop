<%@ page language="java" pageEncoding="UTF-8"%>
<div class="easyui-panel" data-options="title:'功能导航',border:false,fit:true">
	<div class="easyui-accordion" data-options="fit:true,border:false">
		<div title="系统菜单" data-options="iconCls:'icon-save'">
			<ul id="layout_west_tree" class="easyui-tree" data-options="
					url : '${pageContext.request.contextPath}/menu_getTree.action',
					parentField : 'pid',
					lines : true,
					onClick : function(node){
						if(node.attributes.url){
							var url = '${pageContext.request.contextPath}'+node.attributes.url;
							addTab({title:node.text,href:url,closable:true});
						
						}
					}
					"></ul>
		</div>
		<div title="Title2" data-options="iconCls:'icon-reload'"></div>
	</div>
</div>
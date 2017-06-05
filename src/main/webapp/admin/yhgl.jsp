<%@ page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function() {
		$('#admin_yhgl_datagrid').datagrid({
			url : '${pageContext.request.contextPath}/user_datagrid.action',
			fit : true,
			pagination : true,
			border : false,
			idField : 'id',
			fitColumns : true,
			pageSize : 10,
			pageList : [ 5, 10, 15 ],
			sortName : 'userName',
			sortOrder : 'asc',
			checkOnSelect : false,
			selectOnCheck : false,
			frozenColumns : [ [ {
				field : 'id',
				title : '编号',
				width : 100,
				checkbox : true
			}, {
				field : 'userName',
				title : '昵称',
				width : 100,
				sortable : true
			}, ] ],
			columns : [ [ {
				field : 'userPswd',
				title : '密码',
				width : 100,
				align : 'right',
				formatter : function(value, row, index) {
					return '******';
				}
			}, {
				field : 'tel',
				title : '手机号',
				width : 100,
				align : 'right',
				sortable : true
			} ] ],
			toolbar : [ {
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					append();
				}
			}, '-', {
				text : '删除',
				iconCls : 'icon-remove',
				handler : function() {
					remove();
				}
			}, '-', {
				text : '修改',
				iconCls : 'icon-edit',
				handler : function() {
					editFun();
				}
			} ]
		});
	});
	function searchFun() {
		$('#admin_yhgl_datagrid').datagrid('load',
				serializeObject($('#admin_yhgl_form')));
	}
	function clearFun() {
		$('#admin_yhgl_layout input[name=name]').val('');
		$('#admin_yhgl_datagrid').datagrid('load', {});
	}
	function append() {
		$('#admin_yhgl_addForm input').val('');
		$('#admin_yhgl_addDialog').dialog('open');
	}
	function editFun() {
		var rows = $('#admin_yhgl_datagrid').datagrid('getChecked');
		if (rows.length == 1) {
			var d = $('<div/>')
					.dialog(
							{
								width : 500,
								height : 200,
								modal : true,
								title : '修改',
								href : '${pageContext.request.contextPath}/admin/editUser.jsp',
								buttons : [ {
									text : '修改',
									handler : function() {
										$('#admin_editUser_form')
												.form(
														'submit',
														{
															url : '${pageContext.request.contextPath}/user_edit.action',
															data : d
																	.serialize(),
															success : function(
																	data) {
																var obj = jQuery
																		.parseJSON(data);
																console
																		.info(obj);
																if (obj.success) {
																	d
																			.dialog('close');
																	$(
																			'#admin_yhgl_datagrid')
																			.datagrid(
																					'updateRow',
																					{
																						index : $(
																								'#admin_yhgl_datagrid')
																								.datagrid(
																										'getRowIndex',
																										rows[0]),
																						row : obj.obj
																					});
																}
																$.messager
																		.show({
																			title : '提示',
																			msg : obj.msg
																		});
															}
														});
									}
								} ],
								onClose : function() {
									$(this).dialog('destroy');
								},
								onLoad : function() {
									$('#admin_editUser_form').form('load',
											rows[0]);
								}
							});
		} else
			$.messager.alert({
				title : '小提示',
				msg : '请一定要选择一条记录进行修改啊！'
			});

	}
	function remove() {
		var rows = $('#admin_yhgl_datagrid').datagrid('getChecked');
		var ids = [];
		if (rows.length > 0) {
			$.messager
					.confirm(
							'请确认~',
							'您是否要删除当前选中的项目？',
							function(r) {
								if (r) {
									for ( var i = 0; i < rows.length; i++) {
										ids.push(rows[i].id);
									}
									$
											.ajax({
												url : '${pageContext.request.contextPath}/user_remove.action',
												data : {
													ids : ids.join(',')
												},
												dataType : 'json',
												success : function(r) {
													$('#admin_yhgl_datagrid')
															.datagrid('load');
													$('#admin_yhgl_datagrid')
															.datagrid(
																	'unselectAll');
													$.messager.show({
														title : '提示',
														msg : r.msg
													});
												}
											});
								}
							});
		} else
			$.messager.show({
				title : '小提示',
				msg : '请至少勾选一条记录哦！'
			});
	}
</script>
<div id="admin_yhgl_layout" class="easyui-layout" data-options="fit:true">
	<div data-options="region:'north',title:'查询条件'" style="height:100px;">
		<form id="admin_yhgl_form">
			<input name="name" />
		</form>
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-search',plain:true" onclick="searchFun();">查询</a>
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-cancel',plain:true" onclick="clearFun();">清空</a>
	</div>
	<div data-options="region:'center'" style="height:200px;">
		<table id="admin_yhgl_datagrid"></table>
	</div>
</div>

<div id="admin_yhgl_addDialog" class="easyui-dialog"
	data-options="closed:true,modal:true,title:'添加用户',buttons:[{
					text : '增加',
					iconCls : 'icon-add',
					handler : function() {
						$('#admin_yhgl_addForm').form('submit',{
							url:'${pageContext.request.contextPath}/user_add.action',
							success:function(r){
								var obj = jQuery.parseJSON(r);
								console.info(obj.obj);
								if(obj.success){
									 $('#admin_yhgl_datagrid').datagrid('insertRow',{
										index:0,
										row:obj.obj
									});
									$('#admin_yhgl_addDialog').dialog('close');
								}
								$.messager.show({
									title:'提示',
									msg:obj.msg
								});
							}
						})
					}
				}]"
	style="width: 500px;height:200px;" align="center">
	<form id="admin_yhgl_addForm" method="post">
		<table>
			<tr>
				<th>编号</th>
				<td><input name="id" readonly="readonly" />
				</td>
				<th>登录名称</th>
				<td><input name="userName" class="easyui-validatebox"
					data-options="required:true" />
				</td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input name="userPswd" type="password" class="easyui-validatebox"
					data-options="required:true" />
				</td>
				<th>手机号</th>
				<td><input name="tel" class="easyui-validatebox"
					data-options="required:true" />
				</td>
			</tr>

		</table>
	</form>
</div>

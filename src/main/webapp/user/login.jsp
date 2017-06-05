<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
$(function(){
	$('#user_regist_regForm input').bind('keyup',function(event){
		if(event.keyCode=='13'){
			$('#user_regist_regForm').submit();
		}
	});
	$('#user_login_logForm input[name=name]').focus();
});
</script>
<div id="user_login_logDialog" class="easyui-dialog"
	data-options="title:'登录',closable:false,modal:true,
			buttons:[{
				text:'登录',
				iconCls:'icon-help',
				handler:function(){
					$('#user_login_logForm').form('submit',{
						url : '${pageContext.request.contextPath}/user_Mlogin.action',
						data : $('#user_login_logForm').serialize(),
						success : function(data) {
							var obj = jQuery.parseJSON(data);
							console.log(obj);
							if (obj.success) {
								$('#user_login_logDialog').dialog('close');
							}
							$.messager.show({
								title : '提示',
								msg : obj.msg
							});
						}
					});
				}
			}]">
	<form id="user_login_logForm" method="post">
		<table>
			<tr>
				<th>登录名</th>
				<td><input name="userName" class="easyui-validatebox"
					data-options="required:true,missingMessage:'登录名必须要写哦！'" />
				</td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input name="userPswd" type="password" class="easyui-validatebox"
					data-options="required:true,missingMessage:'密码必须要写哦！'" />
				</td>
			</tr>
		</table>
	</form>
</div>

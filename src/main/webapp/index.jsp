<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>index</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="jslib/jquery-easyui-1.5.1/jquery.min.js"></script>
<script type="text/javascript"
	src="jslib/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="jslib/jquery-easyui-1.5.1/locale/easyui-lang-en.js"></script>
<link rel="stylesheet"
	href="jslib/jquery-easyui-1.5.1/themes/default/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="jslib/jquery-easyui-1.5.1/themes/icon.css"
	type="text/css"></link>
<script type="text/javascript" src="jslib/dmz.js"></script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north'" style="height:65px;">
		<jsp:include page="layout/north.jsp"></jsp:include>
	</div>
	<div data-options="region:'south'" style="height:20px;"></div>
	<div data-options="region:'east',title:'日期'"
		style="width:200px;">
		<jsp:include page="layout/east.jsp"></jsp:include>
		</div>
	<div data-options="region:'west'" style="width:200px;"><jsp:include
			page="layout/west.jsp"></jsp:include></div>
	<div data-options="region:'center',title:'欢迎来到sfs后台管理系统'"
		style="padding:5px;background:#eee;">
		<jsp:include page="layout/center.jsp"></jsp:include>
	</div>
	<br>
	<jsp:include page="user/login.jsp"></jsp:include>
</body>
</html>

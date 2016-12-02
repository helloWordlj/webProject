<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/common/js/themes/default/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/common/js/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/common/css/jquery.qtip.min.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/common/css/style.css">
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/common/js/jquery-1.8.0.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/common/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/common/js/jquery.qtip.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/common/js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/common/js/highcharts.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/common/js/exporting.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/common/js/jquery.easyui.datagrid.extend.js"></script>
    <script type="text/javascript">
    	$.fn.datagrid.defaults.pageList=[20,50,100];
    	$.fn.datagrid.defaults.onHeaderContextMenu = createGridHeaderContextMenu;
    </script>
</head>
</html>
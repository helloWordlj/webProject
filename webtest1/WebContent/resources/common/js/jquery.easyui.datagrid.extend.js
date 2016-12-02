/**
 * dataGrid扩展，用于编辑dataGrid
 * */
$.extend($.fn.datagrid.methods, {
	editCell : function(jq, param) {
		return jq.each(function() {
			var opts = $(this).datagrid('options');
			var fields = $(this).datagrid('getColumnFields', true).concat(
					$(this).datagrid('getColumnFields'));
			for ( var i = 0; i < fields.length; i++) {
				var col = $(this).datagrid('getColumnOption', fields[i]);
				col.editor1 = col.editor;
				if (fields[i] != param.field) {
					col.editor = null;
				}
			}
			$(this).datagrid('beginEdit', param.index);
			for ( var i = 0; i < fields.length; i++) {
				var col = $(this).datagrid('getColumnOption', fields[i]);
				col.editor = col.editor1;
			}
		});
	}
});

var editIndex = undefined;
function endEditing(dataGridId) {
	if (editIndex == undefined) {
		return true;
	}
	if ($(dataGridId).datagrid('validateRow', editIndex)) {
		$(dataGridId).datagrid('endEdit', editIndex);
		editIndex = undefined;
		return true;
	} else {
		return false;
	}
}

/**
 * 扩展表格列对齐属性：
 *      自定义一个列字段属性：
 *      headalign ：原始align属性针对数据有效, headalign针对列名有效
 *
 */
$.extend($.fn.datagrid.defaults,{
    onLoadSuccess : function() {
        var target = $(this);
        var opts = $.data(this, "datagrid").options;
        var panel = $(this).datagrid("getPanel");
        //获取列
        var fields=$(this).datagrid('getColumnFields',false);
        //datagrid头部 table 的第一个tr 的td们，即columns的集合
        var headerTds =panel.find(".datagrid-view2 .datagrid-header .datagrid-header-inner table tr:first-child").children();
        //重新设置列表头的对齐方式
        headerTds.each(function (i, obj) {
            var col = target.datagrid('getColumnOption',fields[i]);
            if (!col.hidden && !col.checkbox)
            {
                var headalign=col.headalign||col.align||'left';
                $("div:first-child", obj).css("text-align", headalign);
            }
        });
    },
    loadFilter: function (data) {
    	if (!data.rows) data = {rows:data};
    	for (var i = 0; i < data.rows.length; i++) { 
    		for (var att in data.rows[i]) { 
    			if (typeof (data.rows[i][att]) == "string") { 
    				data.rows[i][att] = data.rows[i][att].replace(/</g, "&lt;").replace(/>/g, "&gt;"); 
    			} 
    		} 
    	}
    	return data;
    }
});
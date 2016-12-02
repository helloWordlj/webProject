$.extend($.fn.window.defaults, {
    onMove:function(left,top){
        var body_width=document.body.offsetWidth;
        var body_height=document.body.offsetHeight;
        var dd_width= $(this).panel('options').width;//dialog的宽度
        var dd_height= $(this).panel('options').height;//dialog的高度
        if (left < 1) {
            $(this).dialog('move', {left: 1 });
        }else if (left > body_width - dd_width) {
            $(this).dialog('move', {left: body_width - dd_width});
        }
        if (top < 1) {
            $(this).dialog('move', {top: 1});
        }
        else if (top > body_height - dd_height) {
            $(this).dialog('move', {top: body_height - dd_height});
        }
    }
});

if ($.fn.pagination){
	$.fn.pagination.defaults.beforePageText = '';
	$.fn.pagination.defaults.afterPageText = '/ {pages}';
	$.fn.pagination.defaults.displayMsg = '显示{from}到{to}，共{total}条记录';
}
if ($.fn.datagrid){
	$.fn.datagrid.defaults.loadMsg = $.fn.panel.defaults.loadingMessage;
}
if ($.fn.treegrid && $.fn.datagrid){
	$.fn.treegrid.defaults.loadMsg = $.fn.datagrid.defaults.loadMsg;
}
if ($.messager){
	$.messager.defaults.ok = '确定';
	$.messager.defaults.cancel = '取消';
}
if ($.fn.validatebox){
	$.fn.validatebox.defaults.missingMessage = '该输入项为必输项';
	$.fn.validatebox.defaults.rules.email.message = '请输入有效的电子邮件地址';
	$.fn.validatebox.defaults.rules.url.message = '请输入有效的URL地址';
	$.fn.validatebox.defaults.rules.length.message = '输入内容长度必须介于{0}和{1}之间';
	$.fn.validatebox.defaults.rules.remote.message = '请修正该字段';
}
if ($.fn.numberbox){
	$.fn.numberbox.defaults.missingMessage = '该输入项为必输项';
}
if ($.fn.combobox){
	$.fn.combobox.defaults.missingMessage = '该输入项为必输项';
}
if ($.fn.combotree){
	$.fn.combotree.defaults.missingMessage = '该输入项为必输项';
}
if ($.fn.combogrid){
	$.fn.combogrid.defaults.missingMessage = '该输入项为必输项';
}
if ($.fn.calendar){
	$.fn.calendar.defaults.weeks = ['日','一','二','三','四','五','六'];
	$.fn.calendar.defaults.months = ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'];
}
if ($.fn.datebox){
	$.fn.datebox.defaults.currentText = '今天';
	$.fn.datebox.defaults.closeText = '关闭';
	$.fn.datebox.defaults.okText = '确定';
	$.fn.datebox.defaults.missingMessage = '该输入项为必输项';
	$.fn.datebox.defaults.formatter = function(date){
		var y = date.getFullYear();
		var m = date.getMonth()+1;
		var d = date.getDate();
		return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
	};
	$.fn.datebox.defaults.parser = function(s){
		if (!s) return new Date();
		var ss = s.split('-');
		var y = parseInt(ss[0],10);
		var m = parseInt(ss[1],10);
		var d = parseInt(ss[2],10);
		if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
			return new Date(y,m-1,d);
		} else {
			return new Date();
		}
	};
}
if ($.fn.datetimebox && $.fn.datebox){
	$.extend($.fn.datetimebox.defaults,{
		currentText: $.fn.datebox.defaults.currentText,
		closeText: $.fn.datebox.defaults.closeText,
		okText: $.fn.datebox.defaults.okText,
		missingMessage: $.fn.datebox.defaults.missingMessage
	});
}
function openWindow(title,url,height){	
	if($('#ww').length>0)closeWindow();
	//自定义遮罩效果
	if(height != "" && height != null){
		divLocker(height);
	}
	$('#DivLocker').show();

	$('<div id="ww" style="width:670px;padding:8px"></div>').appendTo('body');
	$('#ww').window({
		title:title,
		collapsible:false,
		minimizable:false,
		maximizable:false,
		closed:true,
		modal:true,
		onClose:function(){$('#DivLocker').hide();}
	});
	$('#ww').window('open').window('refresh',url).window('move',{top:$(window).height()*0.5-200});
}
function closeWindow(){
	$('#DivLocker').hide();
	$('#ww').window('destroy');
}
function alertError(msg){
	if($('#error-tip').length<1){
		$('<div id="error-tip" style="width:250px;padding:8px;text-align:center"><div>'
				+msg+'</div><br/><a id="error-btn"></a></div>').appendTo('body');
		$('#error-tip').window({
			title:'错误提示',
			collapsible:false,
			minimizable:false,
			maximizable:false,
			closed:true,
			modal:true
		});
		$('#error-btn').linkbutton({text:'确定'}).bind('click',function(){
			$('#error-tip').window('destroy');
		});
	}
	$('#error-tip').window('open');
}

function alertDefined(msg){
	if($('#msg-tip').length<1){
		$('<div id="msg-tip" style="width:250px;padding:8px;text-align:center"><div>'
				+msg+'</div><br/><a id="msg-btn"></a></div>').appendTo('body');
		$('#msg-tip').window({
			title:'提示信息',
			collapsible:false,
			minimizable:false,
			maximizable:false,
			closed:true,
			modal:true
		});
		$('#msg-btn').linkbutton({text:'确定'}).bind('click',function(){
			$('#msg-tip').window('destroy');
		});
	}
	$('#msg-tip').window('open');
}

function alertLoading(msg){
	//$("body").css({overflow:"hidden"});此处方法用于隐藏滚动条
	var path = getRootPath();
	if($('#loadingWin-tip').length<1){
		$('<div id="loadingWin-tip" style="width:400px;padding:8px;text-align:center;top:200px;"><div>'
				+msg+'</div><br/><img alt="'
				+path+'/img/loading.gif" src="'
				+path+'/img/loading.gif" width="214px" height="15px" style="padding:10px;"/><br/><span id="loadingText"></span></div>').appendTo('body');
		$('#loadingWin-tip').window({
			title:'等待信息',
			collapsible:false,
			minimizable:false,
			maximizable:false,
			closed:true,
			modal:true,
			draggable:false,
			closable:false
		});
	}
	$('#loadingWin-tip').window('open');
}
//自定义半透膜遮罩效果
function divLocker(height){
    $('#DivLocker').css({
        "position": "absolute",
        "margin-left": "1px",
        "margin-top": "1px",
        "background-color": "#000000",
        "height": height,
        "filter": "alpha(opacity=30)",
        "opacity": "0.2",
        "overflow": "hidden",
        "width": function () { return $(document).width(); },
        "z-index": "999"
    });
}
//js获取项目根路径，如： http://localhost:8083/uimcardprj
function getRootPath(){
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath=window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPaht=curWwwPath.substring(0,pos);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    return(localhostPaht+projectName);
}

function appendError(obj,msg){
	$(obj).attr('title',msg).css('background-color','#F6CECE');
	$(obj).qtip({position:{my:'top center',at:'bottom center'}});
}
function removeError(obj){
	$(obj).qtip('destroy');
	$(obj).attr('title',null).css('background-color','#FFFFFF');
}
function checkEmpty(obj,msg){
	if($(obj).hasClass('combo-f')){
		var box=$(obj).combobox('textbox');
		if($(obj).combobox('getValue')==''){
			$(box).attr('title',msg).css('background-color','#F6CECE');
			$(box).qtip({position:{my:'top center',at:'bottom center'}});;
		}else{
			$(box).qtip('destroy');
			$(box).attr('title',null).css('background-color','#FFFFFF');
		}
		return;
	}
	if($(obj).val()=='')
		appendError(obj,msg);
	else
		removeError(obj);
}
function checkInt(obj,msg){
	if(!/^\d+$/.test($(obj).val()))
		appendError(obj,msg);
	else
		removeError(obj);
}
//验证非负数
function checkDouble(obj,msg){
    if(!isEmpty(obj) && !/^\d+(.\d+)?$/.test($(obj).val()))
        appendError(obj,msg);
    else
        removeError(obj);
}
//验证经度
function checkLongitude(obj,msg){
	if(isEmpty(obj)){
		appendError(obj,'经度不能为空');
	}
	else{
		if(!isEmpty(obj) && !/^[\-\+]?(0?\d{1,2}\.\d{1,6}|1[0-7]?\d{1}\.\d{1,6}|180\.0{1,6})$/.test($(obj).val()))
	        {appendError(obj,msg);}
	    else
	        {removeError(obj);}
	}
}
//验证纬度
function checkLatitude(obj,msg){
	if(isEmpty(obj)){
		appendError(obj,'纬度不能为空');
	}
	else{
		if(!isEmpty(obj) && !/^[\-\+]?([0-8]?\d{1}\.\d{1,6}|90\.0{1,6})$/.test($(obj).val()))
			{appendError(obj,msg);}
	    else
	        {removeError(obj);}
	}
}
//验证8位长带两位小数的非负数（整数最多6位,最多保留2位小数）
function checkDouble8_2(obj, msg) {
    if (!isEmpty(obj) && !/^([1-9]{1}[0-9]{0,5}(\.[0-9]{0,2})?|0(\.[0-9]{0,2})?|\.[0-9]{1,2})$/.test($(obj).val()))
        appendError(obj, msg);
    else
        removeError(obj);
}
//验证7位长带两位小数的非负数（整数最多5位,最多保留2位小数）
function checkDouble7_2(obj, msg) {
    if (!isEmpty(obj) && !/^([1-9]{1}[0-9]{0,4}(\.[0-9]{0,2})?|0(\.[0-9]{0,2})?|\.[0-9]{1,2})$/.test($(obj).val()))
        appendError(obj, msg);
    else
        removeError(obj);
}
//验证6位长带两位小数的非负数（整数最多4位,最多保留2位小数）
function checkDouble6_2(obj, msg) {
    if (!isEmpty(obj) && !/^([1-9]{1}[0-9]{0,3}(\.[0-9]{0,2})?|0(\.[0-9]{0,2})?|\.[0-9]{1,2})$/.test($(obj).val()))
        appendError(obj, msg);
    else
        removeError(obj);
}
//只要判断为空
function isEmpty(obj){
    if($.trim($(obj).val()) != '' && $(obj).val() != null){
        return false;
    }
    return true;
}
function setSelect(obj,str,top,val){
	var arr=$.parseJSON(str);
	if(top)
		arr=eval('[{"text":"'+top+'","value":""}]').concat(arr);
	$(obj).combobox({
		data:arr,
		editable:false
	});
	if(val)$(obj).combobox('setValue',val);
}
function getDictText(arr,val){
	for(var i=0;i<arr.length;i++){
		if(arr[i].value==val)
			return arr[i].text;
	}
}
function unescape(record){
    $(this).combobox('setText',$(this).combobox('getText').replace(/&lt;/g, "<").replace(/&gt;/g, ">")
        .replace(/&nbsp;/g, " ").replace(/&quot;/g, "\"").replace(/&amp;/g, "&"));
}

//重构title
function draghandle(){
    var tempcols=[];
    for (var i = 0; i < cols.length; i++) {
        //再循环一遍，把源和目标的列对换
        var col = {
            field: cols[i].field,
            title: '<span class="draghandle">' +cols[i].title + '</span>',
            align: cols[i].align,
            width: cols[i].width,
            hidden: cols[i].hidden,
            headalign:cols[i].headalign,
            sortable:cols[i].sortable,
            formatter:cols[i].formatter
        };
         tempcols.push(col);  
    }
     cols = tempcols;
}
//拖动表头
function drag() {
	$('.draghandle').css('width','10px');
    $('.datagrid-header-inner .datagrid-cell').draggable({
//    	cursor: 'auto',
        revert: true,
        proxy: 'clone',
        handle:'.draghandle'
    });
    $('.datagrid-header-inner .datagrid-cell').droppable({
        accept: '.datagrid-header-inner .datagrid-cell',
        onDrop: function (e, source) {
        	$('.draghandle').removeAttr("style");
            //取得拖动源的html值
            var src = $(e.currentTarget.innerHTML).html();
            //取得拖动目标的html值
            var sou = $(source.innerHTML).html();
            var tempcolsrc;//拖动后源和目标列交换
            var tempcolsou;
            var tempcols=[];
            for (var i = 0; i < cols.length; i++) {
                if (cols[i].title == sou) {
                    tempcolsrc = cols[i];//循环读一遍列把源和目标列都记下来
                }
                else if (cols[i].title == src) {
                    tempcolsou = cols[i];
                }
            }
            for (var i = 0; i < cols.length; i++) {
                //再循环一遍，把源和目标的列对换
                var col = {
                    field: cols[i].field,
                    title: cols[i].title,
                    align: cols[i].align,
                    width: cols[i].width,
                    hidden: cols[i].hidden,
                    headalign:cols[i].headalign,
                    sortable:cols[i].sortable,
                    formatter:cols[i].formatter,
                    checkbox:cols[i].checkbox
                };
                if (cols[i].title == sou) {
                    col = tempcolsou;
                }
                else if (cols[i].title == src) {
                    col = tempcolsrc;
                }
                 tempcols.push(col);  
            }
             cols = tempcols;
             //1秒后执行重绑定datagrid操作。可能是revert需要时间,这边如果没有做延时就直接重绑 就会出错。
             //我目前的水平就想到这个笨办法,各位如果有好的想法建议可以提出来讨论下。
            timeid = setTimeout("init()", 1000);
        }
    });
}






var createGridHeaderContextMenu = function(e, field) {
	e.preventDefault();
	var grid = $(this);/* grid本身 */
	var headerContextMenu = this.headerContextMenu;/* grid上的列头菜单对象 */
	if (!headerContextMenu) {
		var tmenu = $('<div style="width:100px;"></div>').appendTo('body');
		var fields = grid.datagrid('getColumnFields');
		for ( var i = 0; i < fields.length; i++) {
			var fildOption = grid.datagrid('getColumnOption', fields[i]);
			if (!fildOption.hidden) {
				$('<div iconCls="icon-ok" field="' + fields[i] + '"/>').html(fildOption.title).appendTo(tmenu);
			} else {
				$('<div iconCls="icon-empty" field="' + fields[i] + '"/>').html(fildOption.title).appendTo(tmenu);
			}
		}
		headerContextMenu = this.headerContextMenu = tmenu.menu({
			onClick : function(item) {
				var field = $(item.target).attr('field');
				if (item.iconCls == 'icon-ok') {
					grid.datagrid('hideColumn', field);
					$(this).menu('setIcon', {
						target : item.target,
						iconCls : 'icon-empty'
					});
				} else {
					grid.datagrid('showColumn', field);
					$(this).menu('setIcon', {
						target : item.target,
						iconCls : 'icon-ok'
					});
				}
			}
		});
	}
	headerContextMenu.menu('show', {
		left : e.pageX,
		top : e.pageY
	});
};


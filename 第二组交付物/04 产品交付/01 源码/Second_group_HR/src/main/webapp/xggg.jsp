<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="javax.servlet.*,java.text.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!-- import easyui-css -->
<link rel="stylesheet" type="text/css"
	href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<!-- 引入easyu的js文件 -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript">
<!-- 页面加载时-->
var theRequest = new Object();
window.onload = function(){
	var gurl = location.search;  
	if ( gurl.indexOf( "?" ) != -1 ) {  
		var str = gurl.substr( 1 ); //substr()方法返回从参数值开始到结束的字符串；  
		var strs = str.split( "&" );  
		for ( var i = 0; i < strs.length; i++ ) {  
			theRequest[ strs[ i ].split( "=" )[ 0 ] ] = decodeURI( strs[ i ].split( "=" )[ 1 ] );   //decodeURI()解决中文乱码
		}
	}
	console.log(theRequest)
	document.getElementsByName('annName')[0].value = theRequest["annName"];
	document.getElementsByName('annContext')[0].value = theRequest["annContext"];

}
$( function(){

	$('#btn1').click( function(){
		
		var title = $("#annName").val();
		var mtext = $("#annContext").val();
		if($('#annName').val().length > 15 || $('#annContext').val().length > 200){
			$.messager.alert('提示','公告标题不能超过15个字，公告内容不能超过200个字！');
		}else{
			$.ajax({  
			    type : 'POST',  
			    url: 'modifyAnns',
			    contentType: "application/x-www-form-urlencoded",
			    data: {"annName":title, 'annContext':mtext, 'aid':theRequest["aid"]},
			    success : function(data) {
			    	$.messager.alert('提示','修改公告成功！','info',function(){
			    		window.location.href="ggcx.jsp";
			    	});
				}
			});
		}
		
	});
	$('#btn2').click(function(){
		$('#ff').form('clear');
	});
});
</script>

<body class="easyui-layout">   
<div id="cc" class="easyui-panel" title="当前位置：公告管理 > 修改公告" style="width:1200px;height:330px;"> 
	<form id="ff" method="post">   
    <div data-options="region:'north'" style="height:30px;background:#eee;">   
        <label for="annName">公告名称:</label>   
        <input id="annName" class="textbox" type="text" name="annName" />   
    </div>   
    <div data-options="region:'center'" style="padding:5px;background:#eee;">   
        <label for="annContext">公告内容:</label>  <br>
        <textarea id="annContext"  type="text" rows="2" name="annContext" cols="20" style="width:600px;height:180px"></textarea>  
    </div> 
    <div data-options="region:'south'" style="height:40px;background:#eee;">
		<a id="btn1" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">修改</a>
		<a id="btn2" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">重置</a>
	</div>
</form> 	
</div>
</body>
</html>
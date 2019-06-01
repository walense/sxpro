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
<script type="text/javascript" src="js/jquery.min.js"></script>

<!-- import easyui-css -->
<link rel="stylesheet" type="text/css"
	href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<!-- 引入easyu的js文件 -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>

<script type="text/javascript">
<!-- 页面加载时-->
var UserName = '<%=session.getAttribute("UserName")%>';
var pwer = '<%=session.getAttribute("pwer")%>';
$( function(){
	
	$('#btn1').click( function(){
		if(pwer == 0){
			$.messager.alert('提示','没有添加公告的权限!');
		}else{
			var annName = $('#annName').val();
			var annContext = $('#annContext').val();
			if(annName == ''){
				$.messager.alert('提示','请输入公告名称！');
			}else if(annContext == ''){
				$.messager.alert('提示','请输入公告内容！');
			}else if(annName.length > 15 || annContext.length > 200){
				$.messager.alert('提示','公告标题不能超过15个字，公告内容不能超过200个字！');
			}else{
				console.log(UserName);
				$.ajax({  
				    type : 'POST',  
				    url: 'submitAnns',
				    contentType: "application/x-www-form-urlencoded",
				    data: {"annName":annName,"annContext":annContext,"UserName":UserName},
				    success : function(data) {
				    	$.messager.alert('提示','添加数据成功！');
				    }  
				});  //endajax
				
			}//endelse
		}//endelse	
		//document.getElementsByClass()[0].value==''
	});
	$('#btn2').click(function(){
		$('#ff').form('clear');
	});
});
</script>

<body class="easyui-layout">  
<div id="cc" class="easyui-panel" style="width:full;height:full;" title="当前位置：公告管理 > 添加公告"> 
	<form id="ff" method="post">   
    <div data-options="region:'north'" style="height:30px;background:#eee;">   
        <label for="annName">公告名称:</label>   
        <input id="annName" class="textbox" type="text" name="annName" />   
    </div>   
    <div data-options="region:'center'" style="padding:5px;background:#eee;">   
        <label for="annContext">公告内容:</label>  <br>
        <input id="annContext" class="easyui-textbox" type="text" name="annContext" data-options="multiline:true" style="width:600px;height:180px" />   
    </div> 
    <div data-options="region:'south'" style="height:40px;background:#eee;">
		<a id="btn1" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">添加</a>
		<a id="btn2" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">重置</a>
	</div>
</form> 	
</div>
</body>
</html>
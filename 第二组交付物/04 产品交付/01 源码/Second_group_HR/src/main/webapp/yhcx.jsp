<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CSI员工之家</title>
</head>
<!-- import easyui-css -->
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<!-- 引入easyu的js文件 -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
var pwer = '<%=session.getAttribute("pwer")%>';
$(function(){
	$('#bb').click(function(){
		//name
		var index = document.getElementById("cc").selectedIndex;
		var lvl = document.getElementById("cc").options[index].value;
		var uname = $('#uname').val();
		if($('#uname').val() == ''){
			$.messager.alert('提示','请输入搜索条件！');
		}else {
			var url = "czYhs";
			$('#dg').datagrid('options').url = url;
			$("#dg").datagrid("load",{
				"uname": $("#uname").val(),
				"lvl":lvl
			});
		}
	});//endbb
	$('#dg').datagrid({
		url: 'czYhs',
	    columns:[[    
	    	{field:'a',checkbox:true,width:25,align:'center',resizable:false},
	        {field:'name',title:'登录名',width:50,align:'center',resizable:false},    
	        {field:'pwd',title:'密码',width:50,align:'center',resizable:false},    
	        {field:'uname',title:'用户名',width:50,align:'center',resizable:false},
	        {field:'lvl',title:'状态',width:50,align:'center',resizable:false},
	        {field:'date',title:'创建时间',width:50,align:'center',resizable:false},
	        {field:'modi',title:'操作',width:50,align:'center',resizable:false,formatter:modi},
	    ]],
	    pagination:true,
	    fitColumns:true,
	});
	$('#aa').click(function(){
		if(pwer == 0){
			$.messager.alert('提示','没有权限！');
		}else{
			var rows = $("#dg").datagrid("getSelections");
			
			var selected = new Array();
			for(var i = 0; rows && i < rows.length; i++) {
				selected[i] = rows[i]["useridd"];
			}
			if(selected.length < 1){
				$.messager.alert('提示','选择要删除的数据！');
			}else{
				$.ajax({  
				    type : 'POST',  
				    url: 'scYhs',
				    contentType: "application/x-www-form-urlencoded",
				    data: {"array": selected},
				    success : function(data) {
				    	$.messager.alert('提示','删除数据成功！');
				    	var url = "czYhs";
						$('#dg').datagrid('options').url = url;
					}
				    }) 
				};  
		}
		
	});//endaa
	function modi(val,row,index){
		return '<a class="a" href="#" onclick="modiYh('+index+')"><img  src="js/imgs/modi.png" /></a>'; 
	}
	modiYh = function(index){
		if(pwer == 0){
			$.messager.alert('提示','没有权限！');
		}else{
			$('#dg').datagrid('selectRow',index);
			var row = $('#dg').datagrid('getSelected');
			window.location.href="xgyh.jsp?name="+row["name"]+"&uname="+row["uname"]+"&useridd="+row["useridd"]+"&lvl="+row["lvl"];	

		}
	}
});
</script>
<body class="easyui-layout"> 
    <div data-options="region:'center',title:'当前位置：用户管理 > 用户查询'" style="padding:5px;background:#eee;width:100%;height:300px"> 
    <form id="ff" method="post">    
        <label for="uname">用户名:</label>   
        <input id="uname" class="easyui-validatebox" type="text" name="uname"  />    
    <label for="name" style="margin-left:30px">用户状态:</label> 
    <select id="cc" class="easyui-combobox" name="dept" style="width:100px;">   
    <option value=0>全部</option>   
    <option value=1>管理员</option>   
    <option value=2>普通用户</option>    
</select>   
<a id="bb" href="#" class="easyui-linkbutton" style="margin-left:20px">搜索</a>
<a id="aa" href="#" class="easyui-linkbutton" style="margin-left:10px">删除</a>
</form> 
<table id='dg' style="width:88%"> </table>
</div>
</body>
</html>
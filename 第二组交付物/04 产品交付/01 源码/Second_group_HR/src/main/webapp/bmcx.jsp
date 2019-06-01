<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- import easyui-css -->
<link rel="stylesheet" type="text/css"
	href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<!-- 引入easyu的js文件 -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
</head>
<script type="text/javascript" >
var pwer = '<%=session.getAttribute("pwer")%>';
$( function(){
	$('#bb').click(function(){
		if($('#tb').val() == ''){
			$.messager.alert('提示','请输入部门名称！');
		}else if($('#tb').val().length > 5){
			$.messager.alert('提示','部门名字不能超过5个字');
		}else {
			var url = "cxBms";
			$('#dg').datagrid('options').url = url;
			$("#dg").datagrid("load",{
				"uname": $("#tb").val(),
			});
		}  
	});
	$("#aa").click(function(){	
		
		var rows = $("#dg").datagrid("getSelections");
		var selected = new Array();
		for(var i = 0; rows && i < rows.length; i++) {
			if(UserName != rows[i]["announcer"]){
				flag = 0;
				break;
			}else{
				flag = 1;
			}
		}
		//pwer == 1：总经理权限
		if(pwer == 1){
			
			for(var i = 0; rows && i < rows.length; i++) {
				selected[i] = rows[i]["aid"];
			}
			if(selected.length < 1){
				$.messager.alert('提示','选择要删除的部门！');
			}else{
				$.ajax({  
				    type : 'POST',  
				    url: 'scBms',
				    contentType: "application/x-www-form-urlencoded",
				    data: {"array": selected},
				    success : function(data) {
				    	$.messager.alert('提示','删除部门成功！');
				    	var url = "cxBms";
						$('#dg').datagrid('options').url = url;
						$("#dg").datagrid("load",{
							"annName": $("#annName").val(),
							
						});
				    }//success  
				});  
			}//endelse
		}else{
			$.messager.alert('提示','没有删除部门的权限！');
		}
		
	});

	$('#dg').datagrid({
	    url:'cxBms',
	    columns:[[
	    	
	    	{field:'ck',checkbox:true,width:100},      
			{field:'uid',title:'编号',hidden:true,width:100},
			{field:'uname',title:'部门名称',align:'center',width:500,resizable:false},
			{field:'usname',title:'详细信息',align:'center',width:500,resizable:false},
			{field:'ucao',title:'操作',width:100,align:'center',resizable:false,formatter:modi}
	    ]],
	    pagination:true,
	    fitColumns:true,   
	});

	function modi(val,row,index){  
			return '<a class="a" href="#" onclick="modiAnn('+index+')"><img  src="js/imgs/modi.png" /></a>'; 
		}
	modiAnn = function(index){
		$('#dg').datagrid('selectRow',index);
		var row = $('#dg').datagrid('getSelected');
		if(pwer == 1){
		window.location.href="xgbm.jsp?uname="+row["uname"]+"&usname="+row["usname"]+"&uid="+row["uid"];	
		}else{
			console.log(UserName);
			console.log(pwer);
			$.messager.alert('提示','没有修改部门的权限！');
		}
	}
});


</script>
  
<body class="easyui-layout">   
    <div data-options="region:'center',title:'当前位置：部门管理 > 部门查询'" style="padding:5px;background:#eee;">
   
    <label>部门名称：</label>
    <input id="tb" type="text"  style="width:120px;height:20px">
    <input style="margin-left:10px" type="submit" value='搜索'' id="bb">
   	<input style="margin-left:10px"  id="aa" type="submit" value='删除'' >
    <br>
    <br>
   	<br>	 
    <table id='dg' style="width:85%"> </table>
      
    
 </div> 
  
 
</body> 
   
</html>
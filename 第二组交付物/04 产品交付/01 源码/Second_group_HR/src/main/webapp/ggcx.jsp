<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
var UserName = '<%=session.getAttribute("UserName")%>';
var pwer = '<%=session.getAttribute("pwer")%>';
var flag = 0;
$( function(){
	
		$('#dg').datagrid({
			url: 'searchAnns',
		    columns:[[    
		    	{field:'a',checkbox:true,width:25,align:'center',resizable:false},
		        {field:'annName',title:'公告名称',width:200,align:'center',resizable:false},    
		        {field:'annContext',title:'公告内容',width:300,align:'center',resizable:false},    
		        {field:'annTime',title:'创建时间',width:200,align:'center',resizable:false},
		        {field:'announcer',title:'公告人',width:100,align:'center',resizable:false},
		        {field:'modi',title:'操作',width:50,align:'center',resizable:false,formatter:modi},
		        {field:'view',title:'预览',width:50,align:'center',resizable:false,formatter:view},
		    ]],
		    pagination:true,
		    fitColumns:true,
		});
		$("#btn1").click(function(){
			if($('#annName').val() == '' && $('#annContext').val() == ''){
				$.messager.alert('提示','请输入搜索条件！');
			}else if($('#annName').val().length > 15 || $('#annContext').val().length > 200){
				$.messager.alert('提示','公告标题不能超过15个字，公告内容不能超过200个字！');
			}else {
				var url = "searchAnns";
				$('#dg').datagrid('options').url = url;
				$("#dg").datagrid("load",{
					"annName": $("#annName").val(),
					"annContext": $("#annContext").val()
				});
			}
			
		});
		$("#btn2").click(function(){	
			
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
			//pwer == 1：总经理权限  flag ==1：公告发布人为当前登陆用户 ==》 只能删除自己发布的公告？
			if(pwer == 1){
				
				for(var i = 0; rows && i < rows.length; i++) {
					selected[i] = rows[i]["aid"];
				}
				if(selected.length < 1){
					$.messager.alert('提示','选择要删除的数据！');
				}else{
					$.ajax({  
					    type : 'POST',  
					    url: 'deleteAnns',
					    contentType: "application/x-www-form-urlencoded",
					    data: {"array": selected},
					    success : function(data) {
					    	$.messager.alert('提示','删除数据成功！');
					    	var url = "searchAnns";
							$('#dg').datagrid('options').url = url;
							$("#dg").datagrid("load",{
								"annName": $("#annName").val(),
								"annContext": $("#annContext").val()
							});
					    }//success  
					});  
				}//endelse
			}else{
				$.messager.alert('提示','没有删除该公告的权限！');
			}
			
		});//btn2 function
		function modi(val,row,index){
			return '<a class="a" href="#" onclick="modiAnn('+index+')"><img  src="js/imgs/modi.png" /></a>';		 
		}
		function view(val,row,index){  
		    return '<a href="#" onclick="viewAnn('+index+')"><img  src="js/imgs/view.png" /></a>';  
		}
		viewAnn = function(index){
			$('#dg').datagrid('selectRow',index);
			var row = $('#dg').datagrid('getSelected');
			if(row){
				document.getElementsByClassName('title')[0].innerHTML = row["annName"];
				document.getElementsByClassName('text')[0].innerHTML = row["annContext"];
			}
			$('#win').window({    
			    width:800,    
			    height:450,
			    title:'预览公告'
			});
		}
		modiAnn = function(index){
			$('#dg').datagrid('selectRow',index);
			var row = $('#dg').datagrid('getSelected');
			//pwer == 1：总经理权限 UserName == row["announcer"]：公告发布人为当前登陆用户 ==》 只能修改自己发布的公告？
			if(pwer == 1){
				window.location.href="xggg.jsp?annName="+row["annName"]+"&annContext="+row["annContext"]+"&aid="+row["aid"];
			}else{
				console.log(UserName);
				console.log(pwer);
				$.messager.alert('提示','没有修改该公告的权限！');
			}	
		}
});
</script>
<body class="easyui-layout">
<div style="height:70px width:100%" class="easyui-panel" title="当前位置：公告管理 > 公告查询">
	<form id="ff" method="post">
		<label for="annName">公告名称:</label>
		<input id="annName" class="textbox" type="text" name="annName" style="width:200px" />
		<label for="annContext" style="margin-left:15px">公告内容:</label>
   		<input id="annContext" class="textbox" type="text" name="annContext" style="width:200px" />
  		<a id="btn1" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
		<a id="btn2" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cut'">删除</a>
	</form>
</div>

<table id="dg" style="width:85%"></table>

<div id="win" style="display:none;">
<div align="center"><h1 class="title" style="font-size: 45px;"></h1></div>
<div>
<p class="text" word-break="break-all" style="font-size: 25px;"></p>
</div>

</div> 
  
</body>
</html>
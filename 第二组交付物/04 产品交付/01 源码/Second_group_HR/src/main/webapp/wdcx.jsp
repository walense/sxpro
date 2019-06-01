<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<!-- 引入easyu的js文件 -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
var pwer = '<%=session.getAttribute("pwer")%>';
	$(function(){
		$('#shuju').datagrid({
			url : 'download',
			columns : [ [ {
				field : 'ck',
				checkbox : true,
				width : 50
			}, {
				field : 'title',
				title : '标题',
				width : 230
			}, {
				field : 'creation_time',
				title : '创建时间',
				width : 330
			}, {
				field : 'describe',
				title : '描述',
				width : 400
			}, {
				field : 'founder',
				title : '创建人',
				width : 200
			}, {
				field : 'operation',
				title : '操作',
				width : 50
			}, {
				field : 'download',
				title : '下载',
				width : 50
			} ] ],
			pagination : true,
			onClickCell: function(index,field,value){				 
				if(field=='operation'){
					var  datas = $('#shuju').datagrid('getSelections');
					if(datas[0]!=null){
					$.ajax({
						 url:"Update",
						 type:"post",
						 data:{"fid":datas[0].fid,
							 "title":datas[0].title,
							 "creation_time":datas[0].creation_time,
							 "describe":datas[0].describe,
							 "founder":datas[0].founder,
							 "operation":datas[0].operation,
							 "download":datas[0].download},
						 dataType:"text",
						 success:function(res){
						    //获取通过resp回写的数据
							 window.location.href="wdgg.jsp";							
						 }
						 
					 })
					}else  {
						alert("请先选择要更改的一列！！")
					}
				}
			}
			
		});		
		$("#ss").click(function(){
			if(pwer == 0){
				$.messager.alert('提示','没有权限！');
			}else{
				var url = "ss";			
				$('#shuju').datagrid('options').url = url;			
				$("#shuju").datagrid("load",{				
					"title": $("#title").val()
				});
			}
			
		})
		$("#sc").click(function(){		
			if(pwer == 0){
				$.messager.alert('提示','没有权限！');
			}else{
				var url = "sc";
				$('#shuju').datagrid('options').url = url;
				var  datas = $('#shuju').datagrid('getSelections');
				if(datas.length==1){
					$("#shuju").datagrid("reload",{				
						"fid": String(datas[0].fid)
					});
				}else{
					alert('只能选择一行')
				}
			}
			
			
		})	
		
	})
</script>
<body class="easyui-layout">
	<div id="wecx" data-options="region:'center',title:'当前位置:文档管理>文档查询'"
		style="padding: 5px; background: #eee;">
	标题：<input type="text" name="title" id="title">
	<input type="submit" value="搜索" id="ss"> 
	<input type="submit" value="删除" id="sc">
						
 	<table id="shuju" width="85%" border="1" cellpadding="5" cellspacing="0"
	   	   style="border: #c2c6cc 1px solid; border-collapse: collapse;">
	</table>
			

	</div>
</body>
</html>
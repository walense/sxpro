<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!-- import easyui-css -->
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<!-- 引入easyu的js文件 -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
var UserName = '<%=session.getAttribute("UserName")%>';
var pwer = '<%=session.getAttribute("pwer")%>';	
	$(function() {
		$('#dg').datagrid({
					//url : 'datagrid',					
					toolbar : [
							{
								iconCls : 'icon-edit',
								text : '人员变更',
								handler : function() {
									
										var datas = $('#dg').datagrid(
										'getSelections');
								console.log(datas[0]);
								var data = datas[0];
								/*id="+ data["id"]+ "&*/
								window.location.href = "updata.jsp?name="
										+ data["name"] + "&sex="
										+ data["sex"] + "&shouji="
										+ data["shouji"] + "&youxiang="
										+ data["youxiang"] + "&zhiwei="
										+ data["zhiwei"] + "&xueli="
										+ data["xueli"] + "&bumen="
										+ data["bumen"] + "&shenfenzheng="
										+ data["shenfenzheng"] + "&lxdz="
										+ data["lxdz"]+ "&jdrq="
										+ data["jdrq"];
								}	
							},
							{
								iconCls : 'icon-remove',
								text : '删除信息',
								handler : function() {
									//if(pwer==1||pwer==0){
									var datas = $('#dg').datagrid('getSelections');
									/*用ajax传递数据*/
									$.ajax({
										 url:"removeinfo",
										 type:"post",
											 data:{ "id":datas[0].id},
										 dataType:"text",
										 success:function(res){
										    //获取通过resp回写的数据
											// window.location.href="wdgg.jsp";	
										    if(res=='true'){
										    	alert("删除成功")
										    }else{
										    	alert("删除失败")
										    }
										 }
										 
									 })
								//}
									}
							} ],
					columns : [ [ {
						field : 'code',
						checkbox : true,
						title : '',
						width : 50
					}, {
						field : 'name',
						title : '姓名',
						width : 100,
						resizable : true
					}, {
						field : 'sex',
						title : '性别',
						width : 100,
						resizable : true
					}, {
						field : 'shouji',
						title : '手机',
						resizable : true,
						width : 100
					}, {
						field : 'youxiang',
						title : '邮箱',
						resizable : true,
						width : 100
					}, {
						field : 'zhiwei',
						title : '职位',
						resizable : true,
						width : 100
					}, {
						field : 'xueli',
						title : '学历',
						resizable : true,
						width : 100
					}, {
						field : 'shenfenzheng',
						title : '身份证',
						resizable : true,
						width : 100
					}, {
						field : 'bumen',
						title : '部门',
						resizable : true,
						width : 100
					}, {
						field : 'lxdz',
						title : '联系地址',
						resizable : true,
						width : 100
					}, {
						field : 'jdrq',
						title : '建档日期',
						resizable : true,
						width : 100
					} ] ]

				}),
				$("#btn").click(function() {
					
						var zhiwei = $("#zhiwei").val();
						var name = $("#name").val();
						var sfz = $("#sfz").val();
						var sex = $("#sex").val();
						var shouji = $("#sj").val();
						var suoshubumen = $("#ssbm").val();
						$("#dg").datagrid({
											url : "Submit?" + "zhiwei=" + zhiwei
													+ "&" + "name=" + name + "&"
													+ "sfz=" + sfz + "&" + "sex="
													+ sex + "&" + "shouji="
													+ shouji + "&" + "bumen="
													+ suoshubumen,
											pagination : true,
											fitColumns : true,
										});
					
			})
	})
</script>
<body>
	<div id="p" class="easyui-panel" title="当前位置：员工管理 > 员工查询"
		style="width: 100%; height: 800px; padding: 10px; background: #fafafa;"
		>
			<div data-options="region:'center'">
				</select> <label for="zhiwei">职 位:</label> <select id="zhiwei"
					class="easyui-combobox" name="dept1" style="width: 200px;">
					<option>职员</option>
					<option>Java开发工程师</option>
					<option>Java中级开发工程师</option>
					<option>Java高级开发工程师</option>
					<option>系统管理员</option>
					<option>架构师</option>
					<option>主管</option>
					<option>经理</option>
					<option>总经理</option>
				</select> <label for="name">姓名:</label> <input class="easyui-validatebox"
					type="text" id="name" name="name" data-options="validType:'name'" />
				<label for="zhiwei">身份证:</label> <input class="easyui-validatebox"
					type="text" id="sfz" name="sfz" data-options="validType:'sfz'" />
			</div>
			<div>
				<label for="sex">性别:</label> <select id="sex"
					class="easyui-combobox" name="dept1" style="width: 200px;">
					<option>女</option>
					<option>男</option>
				</select> <label for="shouji">手机:</label> <input class="easyui-validatebox"
					type="text" id="sj" name="sj" data-options="validType:'sj'" /> <label
					for="ssbm">所属部门:</label> <select id="ssbm" class="easyui-combobox"
					name="dept2" style="width: 200px;">
					<option>技术部</option>
					<option>市场部</option>
					<option>财务部</option>
					<option>运营部</option>
				</select>
				<a id="btn" href="#" class="easyui-linkbutton">搜索</a>
			</div>
			<br>
   			<br>
   			<br>
			<table id="dg"></table>
		

	</div>
</body>
</html>
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
	$("#btn1").click(function(){
		if(confirm("确定要取消添加员工信息吗？")){
	        //alert("确定");
	        var str1=$(this).attr("name"); // jQuery attr() 方法用于获取属性值
	        window.location.href = "/prmsdemo/tab2.jsp";
	    }else{
	        //alert("取消");
	    }
	})
	$("#btn").click(function(){
		
			var name = $("#name").val();
			var shenfenzheng = $("#sfz").val();
			var zhiwei = $("#zhiwei").val();
			var sex = $("#sex").val();
			var xueli = $("#xueli").val();
			var youxiang = $("#youxiang").val();
			var shouji = $("#shouji").val();
			var dianhua = $("#dianhua").val();
			var zzmm = $("#zzmm").val();
			var qqhao = $("#qqh").val();
			var lxdz = $("#lxdz").val();
			var yzbm = $("#yzbm").val();
			var csrq = $("#csrq").val();
			var minzu = $("#minzu").val();
			var jdrq=$("#jdrq").val();
			var bumen=$("#bumen").val();
			 $.ajax({
				 url:"Saveinfo",
				 type:"post",
				data:{
							"name":name,
						 	"sfz":shenfenzheng,
							"sex":sex,
					 		"zhiwei":zhiwei,
					 		"xueli":xueli,
					 		"youxiang":youxiang,
					 		"shouji":shouji,
						 	"dianhua":dianhua,
						 	"zzmm":zzmm,
							"qqh":qqhao,
					 		"lxdz":lxdz,
					 		"yzbm":yzbm,
					 		"csrq":csrq,
					 		"minzu":minzu,
					 		"jdrq":jdrq,
					 		"bumen":bumen
						},
				 dataType:"text",
				 
				 success:function(res){
				    //获取通过resp回写的数据
				    //if(res=="true") 
				    	alert("添加成功");
				    //else  alert("添加失败");
				 },
				 error: function () {
		                alert("添加失败");
		            },
			})
		
		
	})	
})
</script>
<body>
	<div id="p" class="easyui-panel" title="当前位置：员工管理 > 添加员工"fit="true"
		style="width: 100%; height: 100px; padding: 10px; background: #fafafa;">
	
	<div>
		<label for="name">姓      名:</label> 
		<input class="easyui-validatebox"
			type="text" id="name" name="name"
			data-options="validType:'name'" /> 
		<label for="sfz">身份   证:</label>
		<input class="easyui-validatebox" type="text" id="sfz"
			name="zhiwei" data-options="validType:'sfz'" />
			
	</div></br>
	<div>
		<label for="sex">性      别:</label> 
		<select id="sex" class="easyui-combobox"
			name="dept1" style="width: 200px;">
			<option>女</option>
			<option>男</option>
		</select> 
		<label for="zhiwei">职      位:</label> 
		<select id="zhiwei"
			class="easyui-combobox" name="dept1" style="width: 200px;">
			<option >职员</option>
			<option>Java开发工程师</option>
			<option>Java中级开发工程师</option>
			<option>Java高级开发工程师</option>
			<option>系统管理员</option>
			<option>架构师</option>
			<option>主管</option>
			<option>经理</option>
			<option>总经理</option>
		</select>
	</div></br>
	<div>
		<lable>学      历:</lable>
		<input class="easyui-validatebox" type="text" id="xueli"
			name="xueli" data-options="validType:'xueli'" /> 
			<label for="youxiang">邮      箱:</label> 
			<input class="easyui-validatebox"
			type="text" id="youxiang" name="youxiang"
			data-options="validType:'youxiang'" />
	</div></br>
	<div>
		<label for="shouji">手      机:</label> 
		<input class="easyui-validatebox"
			type="text" id="shouji" name="shouji"
			data-options="validType:'shouji'" /> 
		<label for="dianhua">电      话:</label> 
		<input class="easyui-validatebox" type="text" id="dianhua"
			name="dianhua" data-options="validType:'dianhua'" />
	</div></br>
	<div>
		    <label for="zzmm">政治面貌:</label> 
		    <input class="easyui-validatebox"
			type="text" id="zzmm" name="zzmm"
			data-options="validType:'zzmm'" /> 
			<label for="qqh">QQ  号码:</label> 
			<input class="easyui-validatebox" type="text" id="qqh"
			name="qqh" data-options="validType:'qqh'" />
	</div></br>
	<div>
		<label for="lxdz">联系地址:</label> <input class="easyui-validatebox"
			type="text" id="lxdz" name="lxdz"
			data-options="validType:'lxzd'" /> 
		<label for="yzbm">邮政编码:</label>
		<input class="easyui-validatebox" type="text" id="yzbm"
			name="yzbm" data-options="validType:'yzbm'" />
	</div></br>
	<div>
		<label for="csrq">出生日期:</label> <input class="easyui-validatebox"
			type="text" id="csrq" name="csrq"
			data-options="validType:'csrq'" /> 
			<label for="minzu">民          族:</label> <input class="easyui-validatebox" type="text" id="minzu"
			name="minzu" data-options="validType:'minzu'" />
	</div></br>
	<div>
		<lable>建档日期</lable>
		<input type="text" id="jdrq" name="jdrq"/>
		<lable>部门</lable>
		<input type="text" id="bumen" name="bumen"/>
	</div>
	<div>
		<a id="btn" href="#" class="easyui-linkbutton">添加</a> 
		<a id="btn1"href="#" class="easyui-linkbutton">取消</a>
	</div>
	</div>
</body>
</html>
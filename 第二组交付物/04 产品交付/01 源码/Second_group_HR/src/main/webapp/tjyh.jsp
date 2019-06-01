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
<script type="text/javascript">
var pwer = '<%=session.getAttribute("pwer")%>';
$( function(){
	$('#tb').click(function(){    
		$('#dd').form('clear');
   });
   $('#aa').click(function(){ 
	   if(pwer == 0){
		   $.messager.alert('提示','没有添加的权限!');
	   }else{
		   var index = document.getElementById("cc").selectedIndex;
		   var lvl = document.getElementById("cc").options[index].value;
		   
		   if($('#tn').val() == ''){
				$.messager.alert('提示','部门名字部门为空！');
			}else if($('#tu').val() == ''){
				$.messager.alert('提示','详细信息不能为空');
			}else if(lvl < 1){
				$.messager.alert('提示','选择权限');
			}else{
				var name = $('#tn').val(); //姓名
				var uname = $('#tu').val();//登录名
				var pwd = $('#tp').val();//密码
				
				$.ajax({  
				    type : 'POST',  
				    url: 'tjYhs',
				    contentType: "application/x-www-form-urlencoded",
				    data: {"name":name,"uname":uname,"pwd":pwd,"lvl":lvl},
				    success : function(data) {
				    	$.messager.alert('提示','添加数据成功！');
				    }  
				});  
			}//endelse
	   }
	   
   });//end#aa
   
   
})


</script>
  
<body class="easyui-layout">   
    <div data-options="region:'center',title:'当前位置：用户管理 > 添加用户'" style="padding:5px;background:#eee;">
    <form id="dd">
    <label>姓&nbsp&nbsp&nbsp名：</label>
           <input id="tn" type="text"  style="width:120px;height:20px">
    <label style="margin-left:30px">状态：</label>
           <select id="cc" class="easyui-combobox" name="dept" style="width:100px;">   
           <option value=0>全部</option>   
           <option value=1>管理员</option>   
           <option value=2>普通用户</option>
           </select><br><br>
           <label>登录名：</label>
           <input id="tu" type="text"  style="width:120px;height:20px">
           <label style="margin-left:30px">密码：</label>
           <input id="tp" type="text"  style="width:100px;height:20px"><br><br>
           <a id="aa" href="#" class="easyui-linkbutton"  >添加</a>
           <a id="tb" href="#" class="easyui-linkbutton"  >取消</a>
    </form>       
    </div>    
</body>   
</html>
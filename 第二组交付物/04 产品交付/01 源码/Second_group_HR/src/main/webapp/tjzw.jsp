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
   $('#aa').click(function(){
	  // $.messager.alert('确认' ,'职位名字不能为空');    
	   //console.log("");
	   if(pwer == 0){
		   $.messager.alert('提示','没有添加的权限!');
	   }else{
		   if($('#tb').val() == ''){
				$.messager.alert('提示','职位名字不能为空！');
			}else if($('#ta').val() == ''){
				$.messager.alert('提示','详细信息不能为空');
			}else{
				var uname = $('#tb').val() ;
				var usname = $('#ta').val();
				$.ajax({  
				    type : 'POST',  
				    url: 'tjZws',
				    contentType: "application/x-www-form-urlencoded",
				    data: {"uname":uname,"usname":usname},
				    success : function(data) {
				    	$.messager.alert('提示','添加数据成功！');
				    }  
				});  
			}
	   }
	   
   });
   $('#bb').click( function(){
	   
   });
})

 </script> 
<body class="easyui-layout">   
    <div data-options="region:'center',title:'当前位置：职位管理 > 添加职位'" style="padding:5px;background:#eee;"> 
    <label>职位名称：</label>
    <input id="tb" type="text"  style="width:120px;height:20px">
    
    <label style="margin-left:50px">详细信息：</label>
    <input id="ta" type="text"  style="width:120px;height:20px">
    <br>
    <br>
    <br>
    <input id="aa" type="submit" value='添加' >
   	<input id="bb"style="margin-left:15px" type="submit" value='取消' >
    </div> 
    
</body> 

</html>
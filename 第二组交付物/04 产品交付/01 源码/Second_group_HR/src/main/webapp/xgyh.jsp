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
	document.getElementsByName('tn')[0].value = theRequest["name"];
	document.getElementsByName('tu')[0].value = theRequest["uname"];
	document.getElementsByName('dept')[0].value = theRequest["lvl"];
	
}
$( function(){
   $('#aa').click(function(){
	   $.messager.alert('确认' ,'是否添加用户');    
	   //console.log("");
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
			var useridd = theRequest["useridd"];//id
			
			$.ajax({  
			    type : 'POST',  
			    url: 'xgYhs',
			    contentType: "application/x-www-form-urlencoded",
			    data: {"name":name,"uname":uname,"useridd":useridd,"lvl":lvl},
			    success : function(data) {
			    	$.messager.alert('提示','添加数据成功！');
			    }  
			});  
		}//endelse
	   
	   
   });//endaa
   
})


</script>
  
<body class="easyui-layout">   
    <div data-options="region:'center',title:'当前位置：用户管理 > 添加用户'" style="padding:5px;background:#eee;">
    <label>姓&nbsp&nbsp&nbsp名：</label>
           <input id="tn" type="text"  style="width:120px;height:20px" name="tn">
    <label style="margin-left:30px">状态：</label>
           <select id="cc" class="easyui-combobox" name="dept" style="width:100px;">   
           <option value="aa">全部</option>   
           <option value=1>管理员</option>   
           <option value=2>普通用户</option>
           </select><br><br>
           <label>登录名：</label>
           <input id="tu" type="text"  style="width:120px;height:20px" name="tu"><br><br>
           <a id="aa" href="#" class="easyui-linkbutton"  >修改</a>
           <a id="tb" href="#" class="easyui-linkbutton" >取消</a>
    </div>    
</body>   
</html>